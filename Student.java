public final class Student {

    private final int id;
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String extensionName;
    private final String gender;
    private final int age;
    private final String course;
    private final int yearLevel;
    private final String address;
    private final String contactNumber;

    private Student(Builder builder) {
        this.id = builder.id;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.extensionName = builder.extensionName;
        this.gender = builder.gender;
        this.age = builder.age;
        this.course = builder.course;
        this.yearLevel = builder.yearLevel;
        this.address = builder.address;
        this.contactNumber = builder.contactNumber;
    }

    public int getId(){ return id; }
    public String getLastName(){ return lastName; }
    public String getFirstName(){ return firstName; }
    public String getMiddleName(){ return middleName; }
    public String getExtensionName(){ return extensionName; }
    public String getGender(){ return gender; }
    public int getAge(){ return age; }
    public String getCourse(){ return course; }
    public int getYearLevel(){ return yearLevel; }
    public String getAddress(){ return address; }
    public String getContactNumber(){ return contactNumber; }

    @Override
    public String toString() {

        String suffix = (extensionName == null || extensionName.isBlank())
                ? ""
                : " " + extensionName;

        return id + " | " +
                lastName + ", " +
                firstName + " " +
                (middleName == null ? "" : middleName) +
                suffix +
                " | " + gender +
                " | Age: " + age +
                " | " + course +
                " | Year " + yearLevel +
                 " | " + address +
                " | " + contactNumber;
    }

    // ===== BUILDER =====
    public static class Builder {

        private int id;
        private String lastName;
        private String firstName;
        private String middleName;
        private String extensionName;
        private String gender;
        private int age;
        private String course;
        private int yearLevel;
        private String address;
        private String contactNumber;

        public Builder setId(int id){ this.id=id; return this; }
        public Builder setLastName(String lastName){ this.lastName=lastName; return this; }
        public Builder setFirstName(String firstName){ this.firstName=firstName; return this; }
        public Builder setMiddleName(String middleName){ this.middleName=middleName; return this; }
        public Builder setExtensionName(String extensionName){ this.extensionName=extensionName; return this; }
        public Builder setGender(String gender){ this.gender=gender; return this; }
        public Builder setAge(int age){ this.age=age; return this; }
        public Builder setCourse(String course){ this.course=course; return this; }
        public Builder setYearLevel(int yearLevel){ this.yearLevel=yearLevel; return this; }
        public Builder setAddress(String address){ this.address=address; return this; }
        public Builder setContactNumber(String contactNumber){ this.contactNumber=contactNumber; return this; }

        public Student build() {

            if(firstName == null || lastName == null || course == null)
                throw new IllegalStateException("Missing required fields");

            return new Student(this);
        }
    }
}
