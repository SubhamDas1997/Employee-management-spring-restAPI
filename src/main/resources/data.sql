-- Adding roles into roles table
-- 'USER' cannot add or delete 'employees', 'users' or 'roles'
-- 'ADMIN' cannot add or delete 'roles' or 'users'
-- 'OWNER' role is of the highest order which access every API
INSERT INTO ROLES (name) VALUES ('OWNER');
INSERT INTO ROLES (name) VALUES ('ADMIN');
INSERT INTO ROLES (name) VALUES ('USER');

-- Adding users into users table
INSERT INTO USERS (username, password) VALUES ('owner', '$2a$12$5iB60ubTKQdrhExon9xWRuOQOmLSJXcEtgoYmZVhFHk62fLCZgqHe');
INSERT INTO USERS (username, password) VALUES ('subham', '$2a$12$YqaD6dbZ.ey4PO/0axBfs.b9gBa3/YvZVkIpUBWNMWUitvxTztwke');
INSERT INTO USERS (username, password) VALUES ('admin', '$2a$12$J6juMw9Lfqa10LGjP/qgP.3KhByjfNcbj3aXIK/o.R8XGtthMYkmu');

-- Adding role mapping into user_roles join table
INSERT INTO USER_ROLES (user_id, id) VALUES (1, 1);
INSERT INTO USER_ROLES (user_id, id) VALUES (2, 3);
INSERT INTO USER_ROLES (user_id, id) VALUES (3, 2);

-- Adding employees into the employee table
INSERT INTO EMPLOYEE (first_name, last_name, email) VALUES ('Vivian', 'Stevens', 'v.stevens@randatmail.com');
INSERT INTO EMPLOYEE (first_name, last_name, email) VALUES ('Annabella', 'Henderson', 'a.henderson@randatmail.com');
INSERT INTO EMPLOYEE (first_name, last_name, email) VALUES ('Stuart', 'Payne', 's.payne@randatmail.com');
INSERT INTO EMPLOYEE (first_name, last_name, email) VALUES ('Joyce', 'Stewart', 'j.stewart@randatmail.com');
INSERT INTO EMPLOYEE (first_name, last_name, email) VALUES ('Melanie', 'West', 'm.west@randatmail.com');