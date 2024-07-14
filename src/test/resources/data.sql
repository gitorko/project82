-- insert data to student_04

insert into student_04 (id, student_name) values (100, 'roger');
insert into contact_04 (id, address) values (100, 'france');

insert into student_04 (id, student_name) values (101, 'adam');
insert into contact_04 (id, address) values (101, 'france');

insert into student_04 (id, student_name) values (102, 'raj');
insert into contact_04 (id, address) values (102, 'india');

-- insert data to student_06

insert into student_06 (id, student_name) values (100, 'raj');
insert into course_06 (id, course_name) values (200, 'mathematics');
insert into course_06 (id, course_name) values (201, 'history');
insert into course_06 (id, course_name) values (202, 'physics');

insert into student_06 (id, student_name) values (101, 'jack');
insert into course_06 (id, course_name) values (203, 'chemistry');
insert into course_06 (id, course_name) values (204, 'history');
insert into course_06 (id, course_name) values (205, 'physics');

insert into student_06_courses (student06_id, courses_id) values (100, 200);
insert into student_06_courses (student06_id, courses_id) values (100, 201);
insert into student_06_courses (student06_id, courses_id) values (100, 202);

insert into student_06_courses (student06_id, courses_id) values (101, 203);
insert into student_06_courses (student06_id, courses_id) values (101, 204);
insert into student_06_courses (student06_id, courses_id) values (101, 205);

-- insert data to student_07

insert into student_07 (id, student_name) values (100, 'raj');
insert into course_07 (id, student_id, course_name) values (200, 100, 'mathematics');
insert into course_07 (id, student_id, course_name) values (201, 100, 'history');
insert into course_07 (id, student_id, course_name) values (202, 100, 'physics');

insert into student_07 (id, student_name) values (101, 'jack');
insert into course_07 (id, student_id, course_name)  values (203, 101, 'chemistry');
insert into course_07 (id, student_id, course_name)  values (204, 101, 'history');
insert into course_07 (id, student_id, course_name)  values (205, 101, 'physics');

-- insert data to student_08

insert into student_08 (id, student_name) values (100, 'raj');
insert into course_08 (id, student_id, course_name) values (200, 100, 'mathematics');
insert into course_08 (id, student_id, course_name) values (201, 100, 'history');
insert into course_08 (id, student_id, course_name) values (202, 100, 'physics');

insert into student_08 (id, student_name) values (101, 'jack');
insert into course_08 (id, student_id, course_name) values (203, 101, 'chemistry');
insert into course_08 (id, student_id, course_name) values (204, 101, 'history');
insert into course_08 (id, student_id, course_name) values (205, 101, 'physics');

-- insert data to student_09

insert into student_09 (id, student_name) values (100, 'raj');
insert into course_09  (id, student_id, course_name)  values (200, 100, 'mathematics');
insert into course_09  (id, student_id, course_name)  values (201, 100, 'history');
insert into course_09  (id, student_id, course_name)  values (202, 100, 'physics');

insert into student_09 (id, student_name) values (101, 'jack');
insert into course_09 (id, student_id, course_name) values (203, 101, 'chemistry');
insert into course_09 (id, student_id, course_name) values (204, 101, 'history');
insert into course_09 (id, student_id, course_name) values (205, 101, 'physics');

-- insert data to student_10

insert into student_10 (id, student_name) values (100, 'raj');
insert into course_10 (id, student_id, course_name) values (200, 100, 'mathematics');
insert into course_10 (id, student_id, course_name) values (201, 100, 'history');
insert into course_10 (id, student_id, course_name) values (202, 100, 'physics');

insert into student_10 (id, student_name) values (101, 'jack');
insert into course_10 (id, student_id, course_name) values (203, 101, 'chemistry');
insert into course_10 (id, student_id, course_name) values (204, 101, 'history');
insert into course_10 (id, student_id, course_name) values (205, 101, 'physics');

-- insert data to student_11

insert into student_11 (id, student_name) values (100, 'raj');
insert into course_11 (id, student_id, course_name) values (200, 100, 'mathematics');
insert into course_11 (id, student_id, course_name) values (201, 100, 'history');
insert into course_11 (id, student_id, course_name) values (202, 100, 'physics');

insert into student_11 (id, student_name) values (101, 'jack');
insert into course_11 (id, student_id, course_name) values (203, 101, 'chemistry');
insert into course_11 (id, student_id, course_name) values (204, 101, 'history');
insert into course_11 (id, student_id, course_name) values (205, 101, 'physics');

-- insert data to student_12

insert into student_12 (id, student_name) values (100, 'raj');
insert into phone_12 (phone_id, phone) values (100, '999-999-99999');
insert into phone_12 (phone_id, phone) values (100, '998-999-99999');

insert into student_12 (id, student_name) values (101, 'jack');
insert into phone_12 (phone_id, phone) values (101, '997-999-99999');
insert into phone_12 (phone_id, phone) values (101, '996-999-99999');

-- insert data to student_14

insert into student_14 (id, student_name) values (100, 'raj');
insert into student_14 (id, student_name) values (101, 'david');
insert into teacher_14 (id, teacher_name) values (200, 'Mr. Adams');
insert into teacher_14 (id, teacher_name) values (201, 'Mr. Smith');

insert into student_14_teacher_join(student_id, teacher_id) values (100, 200);
insert into student_14_teacher_join(student_id, teacher_id) values (100, 201);

insert into student_14_teacher_join(student_id, teacher_id) values (101, 200);
insert into student_14_teacher_join(student_id, teacher_id) values (101, 201);

-- insert data to student_19

insert into student_19 (id, student_name) values (100, 'raj');
insert into course_19 (id, student_id, course_name) values (200, 100, 'mathematics');
insert into course_19 (id, student_id, course_name) values (201, 100, 'history');
insert into course_19 (id, student_id, course_name) values (202, 100, 'physics');

insert into student_19 (id, student_name) values (101, 'jack');
insert into course_19 (id, student_id, course_name)  values (203, 101, 'chemistry');
insert into course_19 (id, student_id, course_name)  values (204, 101, 'history');
insert into course_19 (id, student_id, course_name)  values (205, 101, 'physics');

-- insert data to student_30

insert into student_30 (id, student_name, updated_count) values (100, 'raj', 0);
