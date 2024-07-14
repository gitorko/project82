-- insert data to student_29
ALTER DATABASE "test-db" SET lock_timeout=10000;
commit;
insert into student_29 (id, student_name, amount, updated_count) values (200, 'raj', 100, 0);

-- insert data to student_30

insert into student_30 (id, student_name, amount, updated_count) values (200, 'raj', 100, 0);

-- insert data to student_32

insert into student_32 (id, student_name) values (200, 'raj');
