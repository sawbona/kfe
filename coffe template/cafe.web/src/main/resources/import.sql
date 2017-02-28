/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  sawbona
 * Created: 25-feb-2017
 */

INSERT INTO ROLES(NAME) VALUES ('ROLE_ADMIN')
INSERT INTO USERS(email, password) VALUES ('a@b.com', 'asd')
INSERT INTO users_roles (User_userId, roles_rolId) values ((SELECT userId from USERS Where USERS.email = 'a@b.com'), (SELECT rolId from ROLES where ROLES.name = 'ROLE_ADMIN'))
