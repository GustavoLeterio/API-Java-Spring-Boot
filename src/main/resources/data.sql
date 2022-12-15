INSERT INTO USER(name, email, senha) VALUES('Student', 'student@email.com', '123456');

INSERT INTO COURSE(name, category) VALUES('Spring Boot', 'Coding');
INSERT INTO COURSE(name, category) VALUES('HTML 5', 'Front-end');

INSERT INTO TOPIC(title, message, create_date, status, author_id, course_id) VALUES('Doubt', 'Error creating project', '2019-05-05 18:00:00', 'NOT_ANSWERED', 1, 1);
INSERT INTO TOPIC(title, message, create_date, status, author_id, course_id) VALUES('Doubt 2', "Project doesn't compile", '2019-05-05 19:00:00', 'NOT_ANSWERED', 1, 1);
INSERT INTO TOPIC(title, message, create_date, status, author_id, course_id) VALUES('Doubt 3', 'Tag HTML', '2019-05-05 20:00:00', 'NOT_ANSWERED', 1, 2);