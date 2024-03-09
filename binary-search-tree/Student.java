public class Student {
    //in this class, a student's attributes are declared and there's a toString method to use while printing results
    private int id;
    private String name;
    private String surname;
    private int age;
    private double gpa;

    public Student(int id, String name, String surname, int age, double gpa){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gpa = gpa;

    }

    public String toString(){
        return "ID: " + id +  " | Name: " + name + " | Surname: " + surname + " | Age: " + age + " | GPA: " + gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
