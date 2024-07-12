package com.demo.project82;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.demo.project82._00_student_constraints.Student00;
import com.demo.project82._00_student_constraints.repo.Student00Repository;
import com.demo.project82._01_student_one2one_unidirectional.Contact01;
import com.demo.project82._01_student_one2one_unidirectional.Student01;
import com.demo.project82._01_student_one2one_unidirectional.repo.Contact01Repository;
import com.demo.project82._02_student_one2one_mapsid.Contact02;
import com.demo.project82._02_student_one2one_mapsid.Student02;
import com.demo.project82._02_student_one2one_mapsid.repo.Contact02Repository;
import com.demo.project82._03_student_one2one_joincolumn.Contact03;
import com.demo.project82._03_student_one2one_joincolumn.Student03;
import com.demo.project82._03_student_one2one_joincolumn.repo.Contact03Repository;
import com.demo.project82._04_student_one2one_bidirectional.Contact04;
import com.demo.project82._04_student_one2one_bidirectional.Student04;
import com.demo.project82._04_student_one2one_bidirectional.repo.Contact04Repository;
import com.demo.project82._04_student_one2one_bidirectional.repo.Student04Repository;
import com.demo.project82._05_student_one2one_bidirectional_nplus1.Student05;
import com.demo.project82._05_student_one2one_bidirectional_nplus1.repo.Student05Repository;
import com.demo.project82._06_student_one2many_3tables.Student06;
import com.demo.project82._06_student_one2many_3tables.repo.Student06Repository;
import com.demo.project82._07_student_one2many_joincolumn.Course07;
import com.demo.project82._07_student_one2many_joincolumn.Student07;
import com.demo.project82._07_student_one2many_joincolumn.repo.Student07Repository;
import com.demo.project82._08_student_one2many_joincolumn_nplus1.Student08;
import com.demo.project82._08_student_one2many_joincolumn_nplus1.repo.Student08Repository;
import com.demo.project82._09_student_one2many_mappedby_nplus1.Student09;
import com.demo.project82._09_student_one2many_mappedby_nplus1.repo.Student09Repository;
import com.demo.project82._10_student_one2many_bidirectional_mappedby.Course10;
import com.demo.project82._10_student_one2many_bidirectional_mappedby.Student10;
import com.demo.project82._10_student_one2many_bidirectional_mappedby.repo.Course10Repository;
import com.demo.project82._10_student_one2many_bidirectional_mappedby.repo.Student10Repository;
import com.demo.project82._11_student_many2one_unidirectional.Course11;
import com.demo.project82._11_student_many2one_unidirectional.Student11;
import com.demo.project82._11_student_many2one_unidirectional.repo.Course11Repository;
import com.demo.project82._11_student_many2one_unidirectional.repo.Student11Repository;
import com.demo.project82._12_student_elementcollection.Phone12;
import com.demo.project82._12_student_elementcollection.Student12;
import com.demo.project82._12_student_elementcollection.repo.Student12Repository;
import com.demo.project82._13_student_many2many_bidirectional.Student13;
import com.demo.project82._13_student_many2many_bidirectional.Teacher13;
import com.demo.project82._13_student_many2many_bidirectional.repo.Student13Repository;
import com.demo.project82._13_student_many2many_bidirectional.repo.Teacher13Repository;
import com.demo.project82._14_student_many2many_unidirectional.Student14;
import com.demo.project82._14_student_many2many_unidirectional.Teacher14;
import com.demo.project82._14_student_many2many_unidirectional.repo.Student14Repository;
import com.demo.project82._14_student_many2many_unidirectional.repo.Teacher14Repository;
import com.demo.project82._15_student_many2many_bidirectional_without.Student15;
import com.demo.project82._15_student_many2many_bidirectional_without.Teacher15;
import com.demo.project82._15_student_many2many_bidirectional_without.repo.Student15Repository;
import com.demo.project82._15_student_many2many_bidirectional_without.repo.Teacher15Repository;
import com.demo.project82._16_student_one2many_jointable.Course16;
import com.demo.project82._16_student_one2many_jointable.Student16;
import com.demo.project82._16_student_one2many_jointable.repo.Student16Repository;
import com.demo.project82._17_student_one2many_jointable_mapkey.Course17;
import com.demo.project82._17_student_one2many_jointable_mapkey.Student17;
import com.demo.project82._17_student_one2many_jointable_mapkey.repo.Student17Repository;
import com.demo.project82._20_student_enum_lob.Student20;
import com.demo.project82._20_student_enum_lob.StudentType;
import com.demo.project82._20_student_enum_lob.repo.Student20Repository;
import com.demo.project82._21_student_audit.Student21;
import com.demo.project82._21_student_audit.repo.Student21Repository;
import com.demo.project82._22_student_unique_constraints.Student22;
import com.demo.project82._22_student_unique_constraints.repo.Student22Repository;
import com.demo.project82._23_student_nartual_id.Student23;
import com.demo.project82._23_student_nartual_id.repo.Student23Repository;
import com.demo.project82._24_student_composite_key.Student24;
import com.demo.project82._24_student_composite_key.Student24Identity;
import com.demo.project82._24_student_composite_key.repo.Student24Repository;
import com.demo.project82._25_student_json_map.Student25;
import com.demo.project82._25_student_json_map.repo.Student25Repository;
import com.demo.project82._26_student_embeddable.Address;
import com.demo.project82._26_student_embeddable.Student26;
import com.demo.project82._26_student_embeddable.Teacher26;
import com.demo.project82._26_student_embeddable.repo.Student26Repository;
import com.demo.project82._26_student_embeddable.repo.Teacher26Repository;
import com.demo.project82._27_student_inheritance.Student27;
import com.demo.project82._27_student_inheritance.repo.Student27Repository;
import com.demo.project82._28_student_projections.Student28;
import com.demo.project82._28_student_projections.Student28View;
import com.demo.project82._28_student_projections.repo.Student28Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class StudentTest extends BaseTest {

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
    Teacher26Repository teacher26Repository;

    @Autowired
    Course10Repository course10Repository;

    @Autowired
    Course11Repository course11Repository;

    @Autowired
    Teacher13Repository teacher13Repository;

    @Autowired
    Teacher14Repository teacher14Repository;

    @Autowired
    Teacher15Repository teacher15Repository;

    @Test
    public void test_00_student_constraints() {
        String photo = "photo";
        Student00 student = Student00.builder()
                .studentName("Jack")
                .userName("jack")
                .dob(new Date())
                .registered_on(LocalDate.now())
                .age(40)
                .email("email@email.com")
                .gpaScore(BigDecimal.valueOf(9.9))
                .blob(photo.getBytes(StandardCharsets.UTF_8))
                .build();
        Student00 savedStudent = student00Repository.save(student);
        System.out.println("student: " + student);
        assertNotNull(savedStudent.getId());
        assertNotNull(savedStudent.getDob());
        assertNotNull(savedStudent.getRegistered_on());
    }

    @Test
    public void test_01_student_one2one_unidirectional() {
        Student01 student = Student01.builder().studentName("Jack").build();
        Contact01 contact = Contact01.builder().address("bangalore").student(student).build();
        Contact01 savedContact = contact01Repository.save(contact);
        //No cascade so student is not saved.
        Assertions.assertNull(savedContact.getStudent().getId());
        assertNotNull(savedContact.getId());
    }

    @Test
    public void test_02_student_one2one_mapsid() {
        Student02 student = Student02.builder().studentName("Jack").build();
        Contact02 contact = Contact02.builder().address("bangalore").student(student).build();
        Contact02 savedContact = contact02Repository.save(contact);
        //No cascade so student but still saved.
        assertNotNull(savedContact.getStudent().getId());
        assertNotNull(savedContact.getId());
    }

    @Test
    public void test_03_student_one2one_joincolumn() {
        Student03 student = Student03.builder().studentName("Jack").build();
        Contact03 contact = Contact03.builder().address("bangalore").student(student).build();
        Contact03 savedContact = contact03Repository.save(contact);
        //cascade so student is saved.
        assertNotNull(savedContact.getStudent().getId());
        assertNotNull(savedContact.getId());
    }

    @Test
    public void test_04_student_one2one_bidirectional() {
        Contact04 contact = Contact04.builder().address("bangalore").build();
        Student04 student = Student04.builder().studentName("Jack").contact(contact).build();
        Student04 savedStudent = student04Repository.save(student);
        assertNotNull(savedStudent.getContact().getId());
        assertNotNull(savedStudent.getId());
        Optional<Student04> studentOptional = student04Repository.findById(student.getId());
        assertNotNull(studentOptional.get().getContact().getId());
    }

    @Test
    public void test_04_student_one2one_bidirectional_nplus1() {
        //creates the N+1 problem
        Iterable<Student04> studentList = student04Repository.findAll();
        //Even though student contact is not required it is loaded as the relation is @OneToOne
        studentList.forEach(e -> {
            assertNotNull(e.getId());
        });
    }

    @Test
    public void test_05_student_one2one_bidirectional_nplus1_fixed() {
        //No N+1 problem
        Iterable<Student05> studentList = student05Repository.findAll();
        studentList.forEach(e -> {
            assertNotNull(e.getId());
        });
    }

    @Test
    public void test_06_student_one2many() {
        Iterable<Student06> studentList = student06Repository.findAll();
        studentList.forEach(e -> {
            assertNotNull(e.getId());
            assertEquals(3, e.getCourses().size());
        });
    }

    @Test
    public void test_07_student_one2many_joincolumn() {
        Iterable<Student07> studentList = student07Repository.findAll();
        studentList.forEach(e -> {
            assertNotNull(e.getId());
            assertEquals(3, e.getCourses().size());
        });
    }

    @Test
    public void test_07_student_one2many_joincolumn_save() {
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
    public void test_08_student_one2many_joincolumn_nplus1() {
        Iterable<Student08> studentList = student08Repository.findAll();
        studentList.forEach(e -> {
            assertNotNull(e.getId());
            assertEquals(3, e.getCourses().size());
        });
    }

    @Test
    public void test_09_student_one2many_mappedby_nplus1() {
        Iterable<Student09> studentList = student09Repository.findAll();
        studentList.forEach(e -> {
            assertNotNull(e.getId());
            assertEquals(3, e.getCourses().size());
        });
    }

    @Test
    public void test_10_student_one2many_bidirectional_mappedby() {
        Iterable<Student10> student10List = student10Repository.findAll();
        student10List.forEach(e -> {
            assertNotNull(e.getId());
            System.out.println("Student Name: " + e.getStudentName());
            assertEquals(3, e.getCourses().size());
        });
    }

    @Test
    public void test_10_student_one2many_bidirectional_mappedby_2() {
        List<Course10> history = course10Repository.findAllByCourseName("history");
        assertEquals(2, history.size());
        history.forEach(e -> {
            System.out.println("Student Name: " + e.getStudent().getStudentName());
            assertNotNull(e.getStudent().getId());
        });
    }

    @Test
    public void test_10_student_one2many_bidirectional_mappedby_3() {
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
    public void test_10_student_one2many_bidirectional_mappedby_4() {
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
    public void test_11_student_many2one_unidirectional_find() {
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
    public void test_11_student_many2one_unidirectional_save() {
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
    public void test_12_student_elementcollection_save() {
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
    public void test_12_student_elementcollection_find() {
        Iterable<Student12> listOfStudents = student12Repository.findAll();
        listOfStudents.forEach(e -> {
            assertEquals(2, e.getPhones().size());
        });
    }

    @Test
    public void test_13_student_many2many() {
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
    public void test_14_student_many2many_unidirectional() {
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
    public void test_15_student_many2many_bidirectional_without() {
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
    public void test_16_student_one2many_jointable() {
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
    public void test_17_student_one2many_jointable_mapkey() {
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
    public void test_20_student_enum_lob() {
        Student20 student = Student20.builder()
                .studentName("Jack")
                .studentType(StudentType.FULL_TIME)
                .build();
        Student20 savedStudent = student20Repository.save(student);
        assertNotNull(savedStudent.getId());
        assertEquals(StudentType.FULL_TIME, savedStudent.getStudentType());
    }

    @Test
    public void test_21_student_audit() {
        Student21 student = Student21.builder()
                .studentName("Jack")
                .build();
        Student21 savedStudent = student21Repository.save(student);
        assertNotNull(savedStudent.getId());
        assertNotNull(savedStudent.getCreatedAt());
        assertNotNull(savedStudent.getUpdatedAt());
    }

    @Test
    public void test_22_student_unique_constraints() {
        Student22 student = Student22.builder()
                .studentName("Jack")
                .userName("user01")
                .email("email@email.com")
                .build();
        Student22 savedStudent = student22Repository.save(student);
        assertNotNull(savedStudent.getId());
    }

    @Test
    public void test_23_student_nartual_id() {
        Student23 student = Student23.builder()
                .studentName("Jack")
                .email("email@email.com")
                .build();
        Student23 savedStudent = student23Repository.save(student);
        assertNotNull(savedStudent.getId());
    }

    @Test
    public void test_24_student_composite_key() {
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
    public void test_25_student_json_map() {
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
    public void test_26_student_embeddable() {
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
    public void test_27_student_inheritance() {
        Student27 student = Student27.builder()
                .studentName("Jack")
                .build();
        Student27 savedStudent = student27Repository.save(student);
        assertNotNull(savedStudent.getId());
    }

    @Test
    public void test_28_student_projections() {
        Student28 student = Student28.builder()
                .studentName("Jack")
                .build();
        Student28 savedStudent = student28Repository.save(student);
        assertNotNull(savedStudent.getId());
        Student28View student27View = student28Repository.getStudent27View(savedStudent.getStudentName());
        assertNotNull("Jack", student27View.getStudentName());
    }

}
