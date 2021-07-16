INSERT INTO OAUTH_CLIENT_DETAILS(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
	VALUES ('api', 'resource-server-rest-api',
	/*api*/'$2a$04$9YMVOW133mair8lEYGEeOexZqpP/.1/tNwTtQG1mR1AaLv1FWk5aO',
	'read,write', 'password,authorization_code,refresh_token,implicit', 'API', 10800, 2592000);

INSERT INTO OAUTH_CLIENT_DETAILS(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
	VALUES ('user-ui', 'resource-server-rest-api',
	/*userUI*/'$2a$04$9gD/hhbFrrVYc2a9rBCVXeN5N5gKVf3X.L9hmo.DKf4DqmekrMLhS',
	'read,write', 'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);

INSERT INTO OAUTH_CLIENT_DETAILS(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
	VALUES ('customer-ui', 'resource-server-rest-api',
	/*customerUI*/'$2a$04$yL2ZRsooIejyHjozAEu10egtQe.0TdO2WfOcoLtBly4C7Y63Bxyny',
	'read,write', 'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);