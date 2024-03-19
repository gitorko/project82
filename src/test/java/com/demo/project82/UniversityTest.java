package com.demo.project82;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UniversityTest {
//    @Autowired
//    StudentRepository studentRepository;
//
//    @Autowired
//    StaffRepository staffRepository;
//
//    @Autowired
//    CourseRepository courseRepository;
//
//    @Autowired
//    DepartmentRepository departmentRepository;
//
//    @Test
//    public void simpleQueryExamples() {
//
//        System.out.println("\nFind 20 year old students");
//        studentRepository.findByAge(20).forEach(System.out::println);
//        System.out.println("\nFind full time old students");
//        studentRepository.findByFullTime(true).forEach(System.out::println);
//        System.out.println("\nFind students with 'doe' as last name");
//        studentRepository.findByAttendeeLastName("doe").forEach(System.out::println);
//    }
//
//    @Test
//    public void intermediateQueryExamples() {
//        System.out.println("Find students by name and traverse entities \n" +
//                studentRepository.findByAttendeeFirstNameAndAttendeeLastName("jane", "doe"));
//        System.out.println("Find students by name with Person Object \n" +
//                studentRepository.findByAttendee(new Person("jane", "doe")));
//
//        System.out.println("\nFind Students older than 19");
//        studentRepository.findByAgeGreaterThan(19).forEach(System.out::println);
//
//        System.out.println("\nFind Students under 19");
//        studentRepository.findByAgeLessThan(19).forEach(System.out::println);
//
//        System.out.println("\nFind Students with last name Doe, despite the case");
//        studentRepository.findByAttendeeLastNameIgnoreCase("Doe").forEach(System.out::println);
//
//        System.out.println("\nFind Students with an i in the last name");
//        studentRepository.findByAttendeeLastNameLike("%i%").forEach(System.out::println);
//
//        System.out.println("\nFind first Student in alphabet \n" +
//                studentRepository.findFirstByOrderByAttendeeLastNameAsc());
//
//        System.out.println("\nFind oldest Student \n" +
//                studentRepository.findTopByOrderByAgeDesc());
//
//        System.out.println("\nFind 3 oldest Students \n" +
//                studentRepository.findTop3ByOrderByAgeDesc());
//
//    }
//
//    @Test
//    public void jpqlQueries() {
//        //*******Method Simplification*******
//
//        System.out.println("Find Courses where Jones is the department Chair with Property Expression");
//        courseRepository.findByDepartmentChairMemberLastName("Jones").forEach(System.out::println);
//
//        //Select c from Course c where c.department.chair.member.lastName=:chair
//        System.out.println("\nFind Courses where Jones is the department Chair with @Query");
//        courseRepository.findByChairLastName("Jones").forEach(System.out::println);
//
//
//        //*******Complex Queries********
//        //Leverage Optional.ifPresent to avoid null checks
//        courseRepository.findByName("English 101").ifPresent(english101 -> {
//            //Select c from Course c join c.prerequisites p where p.id = ?1
//            System.out.println("\nFind Courses where English 101 is a prerequisite");
//            courseRepository.findCourseByPrerequisite(english101.getId())
//                    .forEach(System.out::println);
//
//            //Select new com.example.university.view.CourseView
//            //  (c.name, c.instructor.member.lastName, c.department.name) from Course c where c.id=?1
//            System.out.println("\nCourseView for English 101 \n" +
//                    courseRepository.getCourseView(english101.getId()));
//        });
//    }
//
//    @Test
//    public void pagingAndSortingQueries() {
//        System.out.println("\nFind all 3-credit courses");
//        courseRepository.findByCredits(3).forEach(System.out::println);
//
//        System.out.println("\nFind first 4 3-credit courses, sort by credit, then course name");
//        Page<Course> courses = courseRepository.findByCredits(3,
//                PageRequest.of(0, 4, Sort.Direction.ASC, "credits", "name"));
//        courses.forEach(System.out::println);
//
//        System.out.println("\nFind all staff members, sort alphabetically by last name");
//        Sort sortByLastName = Sort.by(Sort.Direction.ASC, "member.lastName");
//        staffRepository.findAll(sortByLastName).forEach(System.out::println);
//
//        Page<Staff> members = staffRepository.findAll(PageRequest.of(0, 5, sortByLastName));
//        System.out.println("\nTotal number of staff members=" + members.getTotalElements());
//        System.out.println("Total number of 5-element-pages=" + members.getTotalPages());
//        System.out.println("Find first 5 Staff members, sort alphabetically by last name");
//        members.forEach(System.out::println);
//    }
//
//    @Test
//    public void queryByExample() {
//        System.out.println("\nFind the Department with the name 'Humanities' \n" +
//                departmentRepository.findOne(Example.of(new Department("Humanities", null))));
//
//
//        System.out.println("\nFind Departments with the first name of the chair is 'John'");
//        departmentRepository.findAll(Example.of(
//                new Department(null, new Staff(new Person("John", null), null)))).forEach(System.out::println);
//
//        System.out.println("\nFind All Departments with the name ending in 'sciences', case insensitive");
//        departmentRepository.findAll(Example.of(new Department("sciences", null),
//                ExampleMatcher.matching().
//                        withIgnoreCase().
//                        withStringMatcher(ExampleMatcher.StringMatcher.ENDING))).forEach(System.out::println);
//
//    }
//
//
//    @Before("")
//    @After("")
//    public void printBanner() {
//        System.out.println("*************************************************************************************");
//    }
//
//    @Test
//    public void runtimeErrors() {
//        Course course = courseRepository.findByDepartmentName("Sciences");
//        //Various ways to leverage the Optional
////        CourseView view = courseRepository.getCourseViewByName("English 101").get();
////        view = courseRepository.getCourseViewByName("English 101").orElseThrow();
////        view = courseRepository.getCourseViewByName("English 100").orElse(
////                new CourseView("dummyCourse",
////                        "Bad Instructor",
////                        "No Department"));
//    }
//
//    @AfterTestClass
//    public void init() {
//        boolean fullTime = true;
//        studentRepository.save(new Student(new Person("jane", "doe"), fullTime, 20));
//        studentRepository.save(new Student(new Person("john", "doe"), fullTime, 22));
//        studentRepository.save(new Student(new Person("mike", "smith"), fullTime, 18));
//        studentRepository.save(new Student(new Person("ally", "kim"), !fullTime, 19));
//
//        //Staff
//        Staff deanJones = staffRepository.save(new Staff(new Person("John", "Jones"), null));
//        Staff deanMartin = staffRepository.save(new Staff(new Person("Matthew", "Martin"), null));
//        Staff profBrown = staffRepository.save(new Staff(new Person("James", "Brown"), null));
//        Staff profMiller = staffRepository.save(new Staff(new Person("Judy", "Miller"), null));
//        Staff profDavis = staffRepository.save(new Staff(new Person("James", "Davis"), null));
//        Staff profMoore = staffRepository.save(new Staff(new Person("Allison", "Moore"), null));
//        Staff profThomas = staffRepository.save(new Staff(new Person("Tom", "Thomas"), null));
//        Staff profGreen = staffRepository.save(new Staff(new Person("Graham", "Green"), null));
//        Staff profWhite = staffRepository.save(new Staff(new Person("Whitney", "White"), null));
//        Staff profBlack = staffRepository.save(new Staff(new Person("Jack", "Black"), null));
//        Staff profKing = staffRepository.save(new Staff(new Person("Queen", "King"), null));
//
//        //Departments
//        Department humanities = departmentRepository.save(new Department("Humanities", deanJones));
//        Department naturalSciences = departmentRepository.save(new Department("Natural Sciences", deanMartin));
//        Department socialSciences = departmentRepository.save(new Department("Social Sciences", deanJones));
//
//        //Humanities Courses
//        Course english101 = courseRepository.save(new Course("English 101", 3, profBlack, humanities));
//        Course english202 = courseRepository.save(new Course("English 202", 3, profBlack, humanities));
//        courseRepository.save(english202.addPrerequisite(english101));
//        Course english201 = courseRepository.save(new Course("English 201", 3, profBrown, humanities));
//        courseRepository.save(english201.addPrerequisite(english101));
//
//        //Natural Science Courses
//        Course chemistry = courseRepository.save(new Course("Chemistry", 3, profDavis, naturalSciences));
//        Course physics = courseRepository.save(new Course("Physics", 3, profDavis, naturalSciences));
//        courseRepository.save(physics.addPrerequisite(chemistry));
//        Course cProgramming = courseRepository.save(new Course("C Programming", 3, profMoore, naturalSciences));
//        Course jProgramming = courseRepository.save(new Course("Java Programming", 3, profMoore, naturalSciences));
//
//        //Social Science Courses
//        Course history101 = courseRepository.save(new Course("History 101", 3, profMiller, socialSciences));
//        Course anthro = courseRepository.save(new Course("Anthropology ", 3, profKing, socialSciences));
//        courseRepository.save(anthro.addPrerequisite(history101));
//        Course sociology = courseRepository.save(new Course("Sociology", 3, profKing, socialSciences));
//        courseRepository.save(sociology.addPrerequisite(history101));
//        Course psych = courseRepository.save(new Course("Psychology", 3, profWhite, socialSciences));
//        courseRepository.save(psych.addPrerequisite(history101).addPrerequisite(english101));
//    }
}
