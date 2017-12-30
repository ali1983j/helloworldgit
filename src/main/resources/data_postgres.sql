INSERT INTO tenant (ID, NAME, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, LOCK_VERSION, DELETED, INACTIVE) VALUES ('402881834d9ee4d1014d9ee596186039', 'SAAS', 'admin', '2017-12-30 15:26:38', 'admin', '2017-12-30 15:26:38', 0, FALSE, FALSE);

INSERT INTO profile (ID, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, LOCK_VERSION, DELETED, INACTIVE, UUID, NAME, DEFAULT_PROFILE, TENANT_ID) VALUES ('1', 'admin', '2014-11-09 15:37:20', 'admin', '2014-11-09 15:37:20', 0, FALSE, FALSE, '5c1456ef-b4bf-4b45-ac50-6c44782a3c00', 'BASIC', TRUE, '402881834d9ee4d1014d9ee596186039');
INSERT INTO users (ID, CREATED_BY, CREATED_DATE, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, LOCK_VERSION, DELETED, INACTIVE, USERNAME, FIRSTNAME, LASTNAME, PASSWORD, ENABLED, ORGANIZATION, profile_id, TENANT_ID, OWNER_ID) VALUES ('1', 'admin', '2014-11-09 15:37:20', 'admin', '2014-11-09 15:37:20', 0, FALSE, FALSE, 'admin', 'Intializr', 'Administrator', '$2a$10$ZH/pjD8qtozHaZGoBbJnp.qua7Z560ThP0LKdax4vhYbhO9ok2OKC', TRUE, '1', '1', '402881834d9ee4d1014d9ee596186039', '1');

INSERT INTO users_authorities VALUES ('1', 'ROLE_USER');
INSERT INTO users_authorities VALUES ('1', 'ROLE_TENANT_ADMIN');
INSERT INTO users_authorities VALUES ('1', 'ROLE_CLOUD_ADMIN');