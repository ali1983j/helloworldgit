package com.practise.springboot.service;

import com.practise.converter.security.UsersConverter;

import com.practise.orm.entity.security.Profile;
import com.practise.orm.entity.security.Tenant;
import com.practise.orm.repository.UsersRepository;
import com.practise.schema.security.Users;
import com.practise.service.base.GenericServiceImpl;
import com.practise.springboot.response.MessageType;
import com.practise.springboot.response.ResponseEntity;
import com.sky.converter.exception.SkyRuntimeException;
import com.sky.service.util.SecurityRoles;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 28/12/17.
 */
@Service
@Transactional
public class UsersServiceImpl  extends GenericServiceImpl<com.practise.orm.entity.security.Users, Users, String> implements UsersService{

    private UsersRepository usersRepository;
    private UsersConverter usersConverter;
    private PasswordEncoder encoder;
    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, UsersConverter converter, PasswordEncoder encoder){
        super(usersRepository, converter);
        this.usersRepository = usersRepository;
        this.usersConverter = converter;
        this.encoder = encoder;
    }
    public ResponseEntity<Users> create(Users users){

        users.setPassword(encoder.encode(users.getPassword()));
        ResponseEntity<Users> response = save(users);
        return response;
    }

    public ResponseEntity<Users> update(Users users){
        ResponseEntity<Users> response = save(users);
        return response;
    }


    @Override
    public ResponseEntity<com.practise.schema.security.Users> findByPkId(String id) {
       return findById(id);
    }

    @Override
    public ResponseEntity<List<com.practise.schema.security.Users>> findAllEntitled(){
        List<com.practise.schema.security.Users> lst = new ArrayList<>();
        ResponseEntity<List<com.practise.schema.security.Users>> responseEntity =  new ResponseEntity<>();
        return createResonse(converter.convertToList(repository.findAll()));
    }


    @Override
    public ResponseEntity<Users> signup(Users users) {
        // check username exists in SAAS Tenant
        users.setUsername(users.getUsername().toLowerCase());
        users.setEmail(users.getEmail().toLowerCase());
        List<com.practise.orm.entity.security.Users> existingUsers = ((UsersRepository) repository).findByEmailAndTenantName(users.getEmail(), "SAAS");

        if (!CollectionUtils.isEmpty(existingUsers)) {
            return (ResponseEntity<Users>) createErrorResponse(new com.practise.springboot.response.Message(MessageType.ERROR , "", "Email already exists"));
        }
        // use username, password, USER_ROLE
        com.practise.orm.entity.security.Users users_ = new com.practise.orm.entity.security.Users();
        users_.setUsername(users.getUsername().split("@")[0]);
        users_.setFirstname(users.getFirstname());
        users_.setLastname(users.getLastname());

        if (StringUtils.isEmpty(users_.getFirstname())) {
            //users_.setFirstname(" ");
            users_.setFirstname(users_.getLastname());
        }
        if (StringUtils.isEmpty(users_.getLastname())) {
            users_.setLastname(" ");
        }
        if (StringUtils.isEmpty(users.getPassword())) {
            users.setPassword(RandomStringUtils.randomAlphanumeric(12));
        }
        users_.setPassword(users.getPassword());
        users_.setEmail(users.getEmail());

        // admin needs to approve

        Tenant tenant = new Tenant();
        tenant.setId("402881834d9ee4d1014d9ee596186039");
        tenant.setName("SAAS");
        users_.setTenant(tenant);
        //profile

        Profile profile = new Profile();
        profile.setId("1");

        users_.setProfile(profile);
        users_.getAuthorities().add(SecurityRoles.ROLE_USER);

//        // promo-codes handle
//        String pr = users.getPromoCode();
//        users_.setPromoCode(pr);
//        if (StringUtils.isEmpty(pr)) {
//            pr = "NONE";
//        }

        String responseText = "Thank you for signing up. You will receive an email once your account is approved.";



        Users u = converter.convertTo(users_);
        u.setPassword(users.getPassword());

        try {
            ResponseEntity<Users> response = create(u);
        } catch (Exception ex) {
            throw new SkyRuntimeException(ex.getLocalizedMessage());
        }

        if (BooleanUtils.isTrue(users_.getEnabled())) {
            //ResponseEntity<String> resetPassRes = this.sendResetPasswordEmail(users.getUsername());

            //return (ResponseEntity<com.dchq.schema.beans.security.Users>) createErrorResponse(new com.dchq.schema.beans.base.Message()
            //        .withMessageText(resetPassRes.getResults()));
        }

        // notify
        // notificationServiceClient.userSignup(u);



        return new ResponseEntity<>().withResults(responseText);
    }


}
