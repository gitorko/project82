-- insert data to student_29
ALTER DATABASE "test-db" SET lock_timeout=10000;
commit;
insert into student_29 (id, student_name, updated_count) values (100, 'raj', 0);

-- insert data to student_30

insert into student_30 (id, student_name, updated_count) values (100, 'raj', 0);
