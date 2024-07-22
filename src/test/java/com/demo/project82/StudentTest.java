package com.demo.project82;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.demo.project82._00_constraints.Student00;
import com.demo.project82._00_constraints.repo.Student00Repository;
import com.demo.project82._01_one2one_unidirectional.Contact01;
import com.demo.project82._01_one2one_unidirectional.Student01;
import com.demo.project82._01_one2one_unidirectional.repo.Contact01Repository;
import com.demo.project82._01_one2one_unidirectional.repo.Student01Repository;
import com.demo.project82._02_one2one_unidirectional_mapsid.Contact02;
import com.demo.project82._02_one2one_unidirectional_mapsid.Student02;
import com.demo.project82._02_one2one_unidirectional_mapsid.repo.Contact02Repository;
import com.demo.project82._02_one2one_unidirectional_mapsid.repo.Student02Repository;
import com.demo.project82._03_one2one_unidirectional_no_cascade.Contact03;
import com.demo.project82._03_one2one_unidirectional_no_cascade.Student03;
import com.demo.project82._03_one2one_unidirectional_no_cascade.repo.Contact03Repository;
import com.demo.project82._03_one2one_unidirectional_no_cascade.repo.Student03Repository;
import com.demo.project82._04_one2one_bidirectional.Contact04;
import com.demo.project82._04_one2one_bidirectional.Student04;
import com.demo.project82._04_one2one_bidirectional.repo.Contact04Repository;
import com.demo.project82._04_one2one_bidirectional.repo.Student04Repository;
import com.demo.project82._05_one2one_bidirectional_nplus1_fixed.Student05;
import com.demo.project82._05_one2one_bidirectional_nplus1_fixed.repo.Student05Repository;
import com.demo.project82._06_one2many_3tables_unidirectional_wrong.Student06;
import com.demo.project82._06_one2many_3tables_unidirectional_wrong.repo.Student06Repository;
import com.demo.project82._07_one2many_unidirectional.Course07;
import com.demo.project82._07_one2many_unidirectional.Student07;
import com.demo.project82._07_one2many_unidirectional.repo.Student07Repository;
import com.demo.project82._08_one2many_unidirectional_nplus1_fixed.Student08;
import com.demo.project82._08_one2many_unidirectional_nplus1_fixed.repo.Student08Repository;
import com.demo.project82._09_one2many_mappedby_wrong.Student09;
import com.demo.project82._09_one2many_mappedby_wrong.repo.Student09Repository;
import com.demo.project82._10_one2many_many2one_bidirectional_mappedby.Course10;
import com.demo.project82._10_one2many_many2one_bidirectional_mappedby.Student10;
import com.demo.project82._10_one2many_many2one_bidirectional_mappedby.repo.Course10Repository;
import com.demo.project82._10_one2many_many2one_bidirectional_mappedby.repo.Student10Repository;
import com.demo.project82._11_many2one_unidirectional.Course11;
import com.demo.project82._11_many2one_unidirectional.Student11;
import com.demo.project82._11_many2one_unidirectional.repo.Course11Repository;
import com.demo.project82._11_many2one_unidirectional.repo.Student11Repository;
import com.demo.project82._12_one2many_elementcollection_unidirectional.Phone12;
import com.demo.project82._12_one2many_elementcollection_unidirectional.Student12;
import com.demo.project82._12_one2many_elementcollection_unidirectional.repo.Student12Repository;
import com.demo.project82._13_many2many_bidirectional.Student13;
import com.demo.project82._13_many2many_bidirectional.Teacher13;
import com.demo.project82._13_many2many_bidirectional.repo.Student13Repository;
import com.demo.project82._13_many2many_bidirectional.repo.Teacher13Repository;
import com.demo.project82._14_many2many_unidirectional.Student14;
import com.demo.project82._14_many2many_unidirectional.Teacher14;
import com.demo.project82._14_many2many_unidirectional.repo.Student14Repository;
import com.demo.project82._14_many2many_unidirectional.repo.Teacher14Repository;
import com.demo.project82._15_many2many_jointable_bidirectional.Student15;
import com.demo.project82._15_many2many_jointable_bidirectional.Teacher15;
import com.demo.project82._15_many2many_jointable_bidirectional.repo.Student15Repository;
import com.demo.project82._15_many2many_jointable_bidirectional.repo.Teacher15Repository;
import com.demo.project82._16_one2many_jointable_unidirectional.Course16;
import com.demo.project82._16_one2many_jointable_unidirectional.Student16;
import com.demo.project82._16_one2many_jointable_unidirectional.repo.Student16Repository;
import com.demo.project82._17_one2many_jointable_mapkey.Course17;
import com.demo.project82._17_one2many_jointable_mapkey.Student17;
import com.demo.project82._17_one2many_jointable_mapkey.repo.Student17Repository;
import com.demo.project82._18_one2one_jointable_unidirectional.Contact18;
import com.demo.project82._18_one2one_jointable_unidirectional.Student18;
import com.demo.project82._18_one2one_jointable_unidirectional.repo.Student18Repository;
import com.demo.project82._19_one2many_unidirectional.Course19;
import com.demo.project82._19_one2many_unidirectional.Student19;
import com.demo.project82._19_one2many_unidirectional.repo.Course19Repository;
import com.demo.project82._19_one2many_unidirectional.repo.Student19Repository;
import com.demo.project82._20_enum_lob.Student20;
import com.demo.project82._20_enum_lob.StudentType;
import com.demo.project82._20_enum_lob.repo.Student20Repository;
import com.demo.project82._21_audit.Student21;
import com.demo.project82._21_audit.repo.Student21Repository;
import com.demo.project82._22_unique_constraints.Student22;
import com.demo.project82._22_unique_constraints.repo.Student22Repository;
import com.demo.project82._23_nartual_id.Student23;
import com.demo.project82._23_nartual_id.repo.Student23Repository;
import com.demo.project82._24_composite_key.Student24;
import com.demo.project82._24_composite_key.Student24Identity;
import com.demo.project82._24_composite_key.repo.Student24Repository;
import com.demo.project82._25_json_map.Student25;
import com.demo.project82._25_json_map.repo.Student25Repository;
import com.demo.project82._26_embeddable.Address;
import com.demo.project82._26_embeddable.Student26;
import com.demo.project82._26_embeddable.Teacher26;
import com.demo.project82._26_embeddable.repo.Student26Repository;
import com.demo.project82._26_embeddable.repo.Teacher26Repository;
import com.demo.project82._27_inheritance.Student27;
import com.demo.project82._27_inheritance.repo.Student27Repository;
import com.demo.project82._28_projections.Student28;
import com.demo.project82._28_projections.Student28DTO;
import com.demo.project82._28_projections.Student28Pojo;
import com.demo.project82._28_projections.Student28View;
import com.demo.project82._28_projections.repo.Student28Repository;
import com.demo.project82._29_pessimistic_locking.repo.Student29Repository;
import com.demo.project82._29_pessimistic_locking.service.Student29Service;
import com.demo.project82._30_optimistic_locking.Student30;
import com.demo.project82._30_optimistic_locking.repo.Student30Repository;
import com.demo.project82._30_optimistic_locking.service.Student30Service;
import com.demo.project82._31_java_records.Student31Record;
import com.demo.project82._31_java_records.repo.Student31Converter;
import com.demo.project82._31_java_records.service.Student31Service;
import com.demo.project82._32_transaction.Student32;
import com.demo.project82._32_transaction.repo.Student32Repository;
import com.demo.project82._32_transaction.service.Student32Service;
import com.demo.project82._34_proxy.Course34;
import com.demo.project82._34_proxy.Student34;
import com.demo.project82._34_proxy.repo.Course34Repository;
import com.demo.project82._34_proxy.repo.Student34Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.transaction.support.TransactionTemplate;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Import({Student29Service.class, Student30Service.class, Student31Service.class, Student32Service.class, Student31Converter.class})
public class StudentTest extends BaseTest {

    final ExecutorService threadPool = Executors.newFixedThreadPool(2);

    @Autowired
    Contact01Repository contact01Repository;

    @Autowired
    Contact02Repository contact02Repository;

    @Autowired
    Contact03Repository contact03Repository;

    @Autowired
    Contact04Repository contact04Repository;

    @Autowired
    Student00Repository student00Repository;

    @Autowired
    Student01Repository student01Repository;

    @Autowired
    Student02Repository student02Repository;

    @Autowired
    Student03Repository student03Repository;

    @Autowired
    Student04Repository student04Repository;

    @Autowired
    Student05Repository student05Repository;

    @Autowired
    Student06Repository student06Repository;

    @Autowired
    Student07Repository student07Repository;

    @Autowired
    Student08Repository student08Repository;

    @Autowired
    Student09Repository student09Repository;

    @Autowired
    Student10Repository student10Repository;

    @Autowired
    Student11Repository student11Repository;

    @Autowired
    Student12Repository student12Repository;

    @Autowired
    Student13Repository student13Repository;

    @Autowired
    Student14Repository student14Repository;

    @Autowired
    Student15Repository student15Repository;

    @Autowired
    Student16Repository student16Repository;

    @Autowired
    Student17Repository student17Repository;

    @Autowired
    Student18Repository student18Repository;

    @Autowired
    Student19Repository student19Repository;

    @Autowired
    Student20Repository student20Repository;

    @Autowired
    Student21Repository student21Repository;

    @Autowired
    Student22Repository student22Repository;

    @Autowired
    Student23Repository student23Repository;

    @Autowired
    Student24Repository student24Repository;

    @Autowired
    Student25Repository student25Repository;

    @Autowired
    Student26Repository student26Repository;

    @Autowired
    Student27Repository student27Repository;

    @Autowired
    Student28Repository student28Repository;

    @Autowired
    Student29Repository student29Repository;

    @Autowired
    Student30Repository student30Repository;

    @Autowired
    Student32Repository student32Repository;

    @Autowired
    Student34Repository student34Repository;

    @Autowired
    Teacher26Repository teacher26Repository;

    @Autowired
    Course10Repository course10Repository;

    @Autowired
    Course11Repository course11Repository;

    @Autowired
    Course19Repository course19Repository;

    @Autowired
    Course34Repository course34Repository;

    @Autowired
    Teacher13Repository teacher13Repository;

    @Autowired
    Teacher14Repository teacher14Repository;

    @Autowired
    Teacher15Repository teacher15Repository;

    @Autowired
    TransactionTemplate transactionTemplate;

    @Autowired
    Student31Service student31Service;

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void test_00_constraints_entityManager() {
        transactionTemplate.executeWithoutResult(status -> {
            String photo = "photo";
            Student00 student = Student00.builder()
                    .studentName("Jack")
                    .userName("jack")
                    .dob(new Date())
                    .registered_on(LocalDate.now())
                    .age(40)
                    .email("email@email.com")
                    .gpaScore(BigDecimal.valueOf(9.9))
                    .notes("something about student")
                    .blob(photo.getBytes(StandardCharsets.UTF_8))
                    .build();
            entityManager.persist(student);
            entityManager.flush();
            entityManager.clear();
            System.out.println("Student: " + student);
        });
    }

    @Test
    public void test_00_constraints() {
        String photo = "photo";
        Student00 student = Student00.builder()
                .studentName("Jack")
                .userName("jack")
                .dob(new Date())
                .registered_on(LocalDate.now())
                .age(40)
                .email("email@email.com")
                .gpaScore(BigDecimal.valueOf(9.9))
                .notes("something about student")
                .blob(photo.getBytes(StandardCharsets.UTF_8))
                .build();
        Student00 savedStudent = student00Repository.save(student);
        System.out.println("Student: " + student);
        assertNotNull(savedStudent.getId());
        assertNotNull(savedStudent.getDob());
        assertNotNull(savedStudent.getRegistered_on());
    }

    @Test
    public void test_01_one2one_unidirectional() {
        Contact01 contact = Contact01.builder().address("Bangalore").build();
        Student01 student = Student01.builder().studentName("Jack").contact(contact).build();
        Student01 savedStudent = student01Repository.save(student);
        assertNotNull(savedStudent.getId());
        assertNotNull(savedStudent.getContact().getId());
    }

    @Test
    public void test_02_one2one_unidirectional_mapsid() {
        Contact02 contact = Contact02.builder().address("Bangalore").build();
        Student02 student = Student02.builder().studentName("Jack").contact(contact).build();
        Student02 savedStudent = student02Repository.save(student);
        //No cascade but contact still saved.
        assertNotNull(savedStudent.getId());
        assertNotNull(savedStudent.getContact().getId());
    }

    @Test
    public void test_03_one2one_unidirectional_no_cascade() {
        Contact03 contact = Contact03.builder().address("Bangalore").build();
        Student03 student = Student03.builder().studentName("Jack").contact(contact).build();
        Student03 savedStudent = student03Repository.save(student);
        //no cascade so contact is not saved.
        assertNotNull(savedStudent.getId());
        assertNull(savedStudent.getContact().getId());
    }

    @Test
    public void test_04_one2one_bidirectional() {
        Contact04 contact1 = Contact04.builder().address("Bangalore").build();
        Student04 student1 = Student04.builder().studentName("Jack").contact(contact1).build();

        Student04 savedStudent = student04Repository.save(student1);
        assertNotNull(savedStudent.getContact().getId());
        assertNotNull(savedStudent.getId());
        Optional<Student04> studentOptional = student04Repository.findById(savedStudent.getId());
        assertNotNull(studentOptional.get().getContact().getId());

        Student04 student2 = Student04.builder().studentName("Jack").build();
        Contact04 contact2 = Contact04.builder().address("Bangalore").student(student2).build();

        Contact04 savedContact = contact04Repository.save(contact2);
        assertNotNull(savedContact.getStudent().getId());
        assertNotNull(savedContact.getId());
        Optional<Contact04> contactOptional = contact04Repository.findById(savedContact.getId());
        assertNotNull(contactOptional.get().getStudent().getId());
    }

    @Test
    public void test_04_one2one_bidirectional_nplus1() {
        //creates the N+1 problem
        Iterable<Student04> studentList = student04Repository.findAll();
        //Even though student contact is not required it is loaded as the relation is @OneToOne
        studentList.forEach(e -> {
            assertNotNull(e.getId());
        });
    }

    @Test
    public void test_05_one2one_bidirectional_nplus1_fixed() {
        //N+1 problem solved
        Iterable<Student05> studentList = student05Repository.findAll();
        studentList.forEach(e -> {
            assertNotNull(e.getId());
        });
    }

    @Test
    public void test_06_one2many_3tables_unidirectional_wrong() {
        //Wrong way to map relation don't use this
        Iterable<Student06> studentList = student06Repository.findAll();
        studentList.forEach(e -> {
            assertNotNull(e.getId());
            assertEquals(3, e.getCourses().size());
        });
    }

    @Test
    public void test_07_one2many_unidirectional() {
        Iterable<Student07> studentList = student07Repository.findAll();
        studentList.forEach(e -> {
            assertNotNull(e.getId());
            assertEquals(3, e.getCourses().size());
        });
    }

    @Test
    public void test_07_one2many_unidirectional_save() {
        Course07 course = Course07.builder()
                .courseName("chemistry")
                .build();
        Student07 student = Student07.builder()
                .studentName("Jack")
                .courses(List.of(course))
                .build();
        Student07 savedStudent = student07Repository.save(student);
        assertNotNull(savedStudent.getId());
        assertEquals(1, savedStudent.getCourses().size());
    }

    @Test
    public void test_08_one2many_unidirectional_nplus1_fixed() {
        Iterable<Student08> studentList = student08Repository.findAll();
        studentList.forEach(e -> {
            assertNotNull(e.getId());
            assertEquals(3, e.getCourses().size());
        });
    }

    @Test
    public void test_09_one2many_mappedby_wrong() {
        //Wrong way to map relation don't use this
        Iterable<Student09> studentList = student09Repository.findAll();
        studentList.forEach(e -> {
            assertNotNull(e.getId());
            assertEquals(3, e.getCourses().size());
        });
    }

    @Test
    public void test_10_one2many_many2one_bidirectional_mappedby_1() {
        Iterable<Student10> student10List = student10Repository.findAll();
        student10List.forEach(e -> {
            assertNotNull(e.getId());
            System.out.println("Student Name: " + e.getStudentName());
            assertEquals(3, e.getCourses().size());
        });
    }

    @Test
    public void test_10_one2many_many2one_bidirectional_mappedby_2() {
        List<Course10> history = course10Repository.findAllByCourseName("history");
        assertEquals(2, history.size());
        history.forEach(e -> {
            System.out.println("Student Name: " + e.getStudent().getStudentName());
            assertNotNull(e.getStudent().getId());
        });
    }

    @Test
    public void test_10_one2many_many2one_bidirectional_mappedby_3() {
        Course10 historyCourse = Course10.builder()
                .courseName("history")
                .build();
        Course10 physicsCourse = Course10.builder()
                .courseName("physics")
                .build();
        Student10 student = Student10.builder()
                .studentName("Jack")
                .build();
        student.addCourse(historyCourse);
        student.addCourse(physicsCourse);
        Student10 savedStudent = student10Repository.save(student);

        List<Course10> courses = course10Repository.findAllByStudent(savedStudent);
        assertEquals(2, courses.size());
    }

    @Test
    public void test_10_one2many_many2one_bidirectional_mappedby_4() {
        Course10 historyCourse = Course10.builder()
                .courseName("history")
                .build();
        Course10 physicsCourse = Course10.builder()
                .courseName("physics")
                .build();
        Student10 student = Student10.builder()
                .studentName("Jack")
                .build();
        student.addCourse(historyCourse);
        student.addCourse(physicsCourse);
        Course10 savedHistoryCourse = course10Repository.save(historyCourse);
        Course10 savedPhysicsCourse = course10Repository.save(physicsCourse);
        Student10 savedStudent = savedHistoryCourse.getStudent();
        assertNotNull(savedStudent.getId());

        List<Course10> courses = course10Repository.findAllByStudent(savedStudent);
        assertEquals(2, courses.size());
    }

    @Test
    public void test_11_many2one_unidirectional() {
        //Get all the students & for each student get all the courses
        Iterable<Student11> studentList = student11Repository.findAll();
        studentList.forEach(e -> {
            assertNotNull(e.getId());
            System.out.println("Student Name: " + e.getStudentName());
            List<Course11> courses = course11Repository.findAllByStudent(e);
            courses.forEach(c -> {
                System.out.println("Course: " + c.getCourseName());
            });
        });
    }

    @Test
    public void test_11_many2one_unidirectional_save() {
        Student11 student = Student11.builder()
                .studentName("Jack")
                .build();
        Course11 historyCourse = Course11.builder()
                .courseName("history")
                .student(student)
                .build();
        Course11 physicsCourse = Course11.builder()
                .courseName("physics")
                .student(student)
                .build();
        Course11 savedHistory = course11Repository.save(historyCourse);
        Course11 savedPhysics = course11Repository.save(physicsCourse);
        Student11 savedStudent = student11Repository.findById(savedHistory.getStudent().getId()).orElseGet(null);

        List<Course11> courses = course11Repository.findAllByStudent(savedStudent);
        assertEquals(2, courses.size());
    }

    @Test
    public void test_12_one2many_elementcollection_unidirectional() {
        Phone12 phone1 = Phone12.builder()
                .phone("999-999-9999")
                .build();
        Student12 student = Student12.builder()
                .studentName("Jack")
                .phones(List.of(phone1))
                .build();
        Student12 savedStudent12 = student12Repository.save(student);
        assertNotNull(savedStudent12.getId());
    }

    @Test
    public void test_12_one2many_elementcollection_unidirectional_find() {
        Iterable<Student12> listOfStudents = student12Repository.findAll();
        listOfStudents.forEach(e -> {
            assertEquals(2, e.getPhones().size());
        });
    }

    @Test
    public void test_13_many2many_bidirectional() {
        Teacher13 teacher1 = Teacher13.builder()
                .teacherName("Mr. Adam")
                .build();
        Teacher13 teacher2 = Teacher13.builder()
                .teacherName("Mr. Smith")
                .build();
        Student13 student1 = Student13.builder()
                .studentName("Jack")
                .build();
        Student13 student2 = Student13.builder()
                .studentName("David")
                .build();

        Student13 savedStudent1 = student13Repository.save(student1);
        Student13 savedStudent2 = student13Repository.save(student2);

        Teacher13 savedTeacher1 = teacher13Repository.save(teacher1);
        Teacher13 savedTeacher2 = teacher13Repository.save(teacher2);

        savedTeacher1.addStudent(student1);
        teacher13Repository.save(savedTeacher1);

        savedStudent2.addTeacher(savedTeacher2);
        student13Repository.save(savedStudent2);
    }

    @Test
    public void test_14_many2many_unidirectional_save() {
        Teacher14 teacher1 = Teacher14.builder()
                .teacherName("Mr. Adam")
                .build();
        Teacher14 teacher2 = Teacher14.builder()
                .teacherName("Mr. Smith")
                .build();
        Student14 student1 = Student14.builder()
                .studentName("Jack")
                .build();
        Student14 student2 = Student14.builder()
                .studentName("David")
                .build();

        Student14 savedStudent1 = student14Repository.save(student1);
        Student14 savedStudent2 = student14Repository.save(student2);

        Teacher14 savedTeacher1 = teacher14Repository.save(teacher1);
        Teacher14 savedTeacher2 = teacher14Repository.save(teacher2);

        savedStudent1.addTeacher(savedTeacher1);
        savedStudent2.addTeacher(savedTeacher2);
        student14Repository.save(savedStudent1);
        student14Repository.save(savedStudent2);
    }

    @Test
    public void test_14_many2many_unidirectional_delete() {

        Student14 savedStudent1 = student14Repository.findById(100l).orElseGet(null);
        Student14 savedStudent2 = student14Repository.findById(101l).orElse(null);

        Teacher14 savedTeacher1 = teacher14Repository.findById(200l).orElse(null);
        Teacher14 savedTeacher2 = teacher14Repository.findById(201l).orElse(null);

        savedStudent1.removeTeacher(savedTeacher1);
        student14Repository.save(savedStudent1);

        savedStudent1 = student14Repository.findById(100l).orElseGet(null);
        assertEquals(1, savedStudent1.getTeachers().size());

        savedStudent2 = student14Repository.findById(101l).orElseGet(null);
        assertEquals(2, savedStudent2.getTeachers().size());
    }

    @Test
    public void test_15_many2many_jointable_bidirectional() {
        Teacher15 teacher1 = Teacher15.builder()
                .teacherName("Mr. Adam")
                .build();
        Teacher15 teacher2 = Teacher15.builder()
                .teacherName("Mr. Smith")
                .build();
        Student15 student1 = Student15.builder()
                .studentName("Jack")
                .build();
        Student15 student2 = Student15.builder()
                .studentName("David")
                .build();

        Student15 savedStudent1 = student15Repository.save(student1);
        Student15 savedStudent2 = student15Repository.save(student2);

        Teacher15 savedTeacher1 = teacher15Repository.save(teacher1);
        Teacher15 savedTeacher2 = teacher15Repository.save(teacher2);

        savedTeacher1.addStudent(student1);
        teacher15Repository.save(savedTeacher1);

        savedStudent2.addTeacher(savedTeacher2);
        student15Repository.save(savedStudent2);
    }

    @Test
    public void test_16_one2many_jointable_unidirectional() {
        Course16 physicsCourse = Course16.builder()
                .courseName("physics")
                .build();
        Course16 chemistryCourse = Course16.builder()
                .courseName("chemistry")
                .build();
        Student16 student = Student16.builder()
                .studentName("Jack")
                .courses(List.of(physicsCourse, chemistryCourse))
                .build();
        Student16 savedStudent = student16Repository.save(student);
        assertNotNull(savedStudent.getId());
    }

    @Test
    public void test_17_one2many_jointable_mapkey() {
        Course17 physicsCourse = Course17.builder()
                .courseName("physics")
                .build();
        Course17 chemistryCourse = Course17.builder()
                .courseName("chemistry")
                .build();
        Student17 student = Student17.builder()
                .studentName("Jack")
                .build();
        Map<String, Course17> courseMap = new HashMap<>();
        courseMap.put("physics", physicsCourse);
        courseMap.put("chemistry", chemistryCourse);
        student.setCourseMap(courseMap);
        Student17 savedStudent = student17Repository.save(student);
        assertNotNull(savedStudent.getId());
    }

    @Test
    public void test_18_one2one_jointable_unidirectional() {
        Contact18 contact = Contact18.builder()
                .address("Bangalore")
                .build();
        Student18 student = Student18.builder()
                .studentName("Jack")
                .contact(contact)
                .build();
        Student18 savedStudent = student18Repository.save(student);
        assertNotNull(savedStudent.getId());
        assertNotNull(savedStudent.getContact().getId());
    }

    @Test
    public void test_19_one2many_unidirectional_save() {
        Student19 student = Student19.builder()
                .studentName("Jack")
                .build();
        Course19 course = Course19.builder()
                .courseName("physics")
                .student(student)
                .build();
        Course19 savedCourse = course19Repository.save(course);
        assertNotNull(savedCourse.getId());
        assertNotNull(savedCourse.getStudent().getId());
    }

    @Test
    public void test_19_one2many_unidirectional_find() {
        Iterable<Student19> students = student19Repository.findAll();
        students.forEach(e -> {
            System.out.println("Student: " + e);
            List<Course19> courses = course19Repository.findAllByStudent(e);
            assertEquals(3, courses.size());
            courses.forEach(c -> {
                System.out.println("Student: " + e + ", Course: " + c);
                assertNotNull(c.getId());
            });
        });
    }

    @Test
    public void test_20_enum_lob() {
        Student20 student = Student20.builder()
                .studentName("Jack")
                .studentType(StudentType.FULL_TIME)
                .build();
        Student20 savedStudent = student20Repository.save(student);
        assertNotNull(savedStudent.getId());
        assertEquals(StudentType.FULL_TIME, savedStudent.getStudentType());
    }

    @Test
    public void test_21_audit() {
        Student21 student = Student21.builder()
                .studentName("Jack")
                .build();
        Student21 savedStudent = student21Repository.save(student);
        assertNotNull(savedStudent.getId());
        assertNotNull(savedStudent.getCreatedAt());
        assertNotNull(savedStudent.getUpdatedAt());
    }

    @Test
    public void test_22_unique_constraints() {
        Student22 student = Student22.builder()
                .studentName("Jack")
                .userName("user01")
                .email("email@email.com")
                .build();
        Student22 savedStudent = student22Repository.save(student);
        assertNotNull(savedStudent.getId());
    }

    @Test
    public void test_23_nartual_id() {
        Student23 student = Student23.builder()
                .studentName("Jack")
                .email("email@email.com")
                .build();
        Student23 savedStudent = student23Repository.save(student);
        assertNotNull(savedStudent.getId());
    }

    @Test
    public void test_24_composite_key() {
        Student24 student = Student24.builder()
                .student24Identity(Student24Identity.builder()
                        .registrationId("R-568")
                        .studentId("S-457")
                        .build())
                .studentName("Jack")
                .build();
        Student24 savedStudent = student24Repository.save(student);
        assertNotNull(savedStudent);
    }

    @Test
    public void test_25_json_map() {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("address", "123 Main Street");
        attributes.put("zipcode", 12345);
        String payload = "{\"city\": \"bangalore\"}";

        Student25 student = Student25.builder()
                .attributes(attributes)
                .payload(payload)
                .build();
        Student25 savedStudent25 = student25Repository.save(student);
        assertNotNull(savedStudent25);
        assertNotNull(student.serializeCustomerAttributes());
        assertNotNull(student.deserializeCustomerAttributes());
    }

    @Test
    public void test_26_embeddable() {
        Student26 student = Student26.builder()
                .studentName("Jack")
                .addresses(Address.builder()
                        .addressLine("5th street")
                        .city("Bangalore")
                        .country("India")
                        .zipCode("570021")
                        .build())
                .build();
        Teacher26 teacher = Teacher26.builder()
                .teacherName("Mr. Adams")
                .addresses(Address.builder()
                        .addressLine("9th street")
                        .city("Bangalore")
                        .country("India")
                        .zipCode("570015")
                        .build())
                .build();
        Student26 savedStudent = student26Repository.save(student);
        Teacher26 savedTeacher = teacher26Repository.save(teacher);
        assertNotNull(savedStudent.getId());
        assertNotNull(savedTeacher.getId());
    }

    @Test
    public void test_27_inheritance() {
        Student27 student = Student27.builder()
                .studentName("Jack")
                .build();
        Student27 savedStudent = student27Repository.save(student);
        assertNotNull(savedStudent.getId());
    }

    @Test
    public void test_28_projections() {
        Student28 student = Student28.builder()
                .studentName("Jack")
                .notes("something about student")
                .monthlySalary(5000)
                .build();
        Student28 savedStudent = student28Repository.save(student);
        assertNotNull(savedStudent.getId());

        Student28View student27View = student28Repository.getStudent27View(savedStudent.getStudentName());
        assertEquals(60000, student27View.getAnnualSalary());

        Student28DTO student27Dto = student28Repository.getStudent27Dto(savedStudent.getStudentName());
        assertEquals(60000, student27Dto.annualSalary());

        Student28Pojo student27Pojo = student28Repository.getStudent27Pojo(savedStudent.getStudentName());
        assertEquals(60000, student27Pojo.getAnnualSalary());
    }

    @Test
    public void test_30_optimistic_locking_multi_thread() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        modifyStudent30(100l, latch);
        modifyStudent30(100l, latch);
        latch.await(5, TimeUnit.SECONDS);
        Student30 student = student30Repository.findById(100l).orElseThrow();
        System.out.println("Student: " + student);
    }

    private void modifyStudent30(Long id, CountDownLatch latch) {
        threadPool.submit(() -> {
            try {
                Student30 student = student30Repository.findById(id).orElseThrow();
                student.setStudentName(student.getStudentName() + "_" + Thread.currentThread().getName());
                //Delay so that version is updated before next thread saves.
                TimeUnit.SECONDS.sleep(5);
                student30Repository.save(student);
            } catch (ObjectOptimisticLockingFailureException | InterruptedException ex) {
                ex.printStackTrace();
                assertEquals(ObjectOptimisticLockingFailureException.class, ex.getClass());
            } finally {
                latch.countDown();
            }
        });
    }

    @Test
    public void test_31_java_records() {
        Student31Record student = new Student31Record(null, "jack");
        Student31Record savedStudent = student31Service.save(student);
        assertNotNull(savedStudent.id());
    }

    @Test
    public void test_32_transaction() {
        /**
         * Tests do transaction rollback after the test is completed.
         */
        Student32 student = Student32.builder()
                .studentName("jack")
                .build();
        Student32 savedStudent = student32Repository.save(student);
        assertNotNull(savedStudent.getId());
    }

    @Test
    public void test_33_dynamic_update() {
        //Check the SQL update statement they will contain on the columns that changed as we used @DynamicUpdate
        //Since tests don't persist the data you will not see this in the test logs.
        Student32 student = Student32.builder()
                .studentName("jack")
                .build();
        Student32 savedStudent = student32Repository.save(student);
        assertNotNull(savedStudent.getId());
    }

    @Test
    public void test_34_proxy() {
        //by using getReferenceById we get a proxy object instead of the real object.
        //with just the proxy object we are able to get the courses.
        //drawback is that there can be constraint violation if the object doesn't really exist as we never checked the db.
        Student34 student = student34Repository.getReferenceById(100l);
        List<Course34> courses = course34Repository.findAllByStudent(student);
        assertEquals(3, courses.size());
    }

}
