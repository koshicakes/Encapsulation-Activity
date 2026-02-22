import java.util.List;

public class Main {

    public static void main(String[] args) {

        Repository repo = new Repository();

        addStudents(repo);

        System.out.println("\n===== STUDENT MASTER LIST =====");

        List<Student> students = repo.getAllStudents();

        for(Student s : students)
            System.out.println(s);
    }

    private static void addStudents(Repository repo) {

        repo.addStudent(new Student.Builder().setId(1).setLastName("Dela Cruz").setFirstName("Juan").setMiddleName("Santos").setExtensionName("Jr").setGender("Male").setAge(19).setCourse("BSIT").setYearLevel(2).setAddress("Quezon City").setContactNumber("09171234567").build());

        repo.addStudent(new Student.Builder().setId(2).setLastName("Santos").setFirstName("Maria").setMiddleName("Lopez").setGender("Female").setAge(20).setCourse("BSCS").setYearLevel(3).setAddress("Marikina City").setContactNumber("09181234567").build());

        repo.addStudent(new Student.Builder().setId(3).setLastName("Reyes").setFirstName("Carlo").setMiddleName("Mendoza").setGender("Male").setAge(18).setCourse("BSIT").setYearLevel(1).setAddress("Pasig City").setContactNumber("09191234567").build());

        repo.addStudent(new Student.Builder().setId(4).setLastName("Garcia").setFirstName("Ana").setMiddleName("Ramos").setGender("Female").setAge(21).setCourse("BSIS").setYearLevel(4).setAddress("Taguig City").setContactNumber("09201234567").build());

        repo.addStudent(new Student.Builder().setId(5).setLastName("Torres").setFirstName("Mark").setMiddleName("Diaz").setGender("Male").setAge(19).setCourse("BSIT").setYearLevel(2).setAddress("Makati City").setContactNumber("09211234567").build());

        repo.addStudent(new Student.Builder().setId(6).setLastName("Flores").setFirstName("Liza").setMiddleName("Aquino").setGender("Female").setAge(22).setCourse("BSCS").setYearLevel(4).setAddress("Manila").setContactNumber("09221234567").build());

        repo.addStudent(new Student.Builder().setId(7).setLastName("Ramos").setFirstName("Paul").setMiddleName("Villanueva").setGender("Male").setAge(20).setCourse("BSIT").setYearLevel(3).setAddress("Caloocan City").setContactNumber("09231234567").build());

        repo.addStudent(new Student.Builder().setId(8).setLastName("Mendoza").setFirstName("Nina").setMiddleName("Castro").setGender("Female").setAge(18).setCourse("BSIS").setYearLevel(1).setAddress("Valenzuela City").setContactNumber("09241234567").build());

        repo.addStudent(new Student.Builder().setId(9).setLastName("Aquino").setFirstName("Jose").setMiddleName("Bautista").setExtensionName("III").setGender("Male").setAge(23).setCourse("BSCS").setYearLevel(4).setAddress("San Juan City").setContactNumber("09251234567").build());

        repo.addStudent(new Student.Builder().setId(10).setLastName("Lopez").setFirstName("Kate").setMiddleName("Fernandez").setGender("Female").setAge(19).setCourse("BSIT").setYearLevel(2).setAddress("Pasay City").setContactNumber("09261234567").build());
    }
}
