import java.io.*;

class StudentData implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int marks;
    transient String password;

    StudentData(String name, int marks, String password) {
        this.name = name; this.marks = marks; this.password = password;
    }

    public String toString() {
        return name + " " + marks + " password=" + password;
    }
}

public class SaveLoad {
    public static void main(String[] args) throws Exception {
        StudentData[] students = {
            new StudentData("Riya", 90, "secret"),
            new StudentData("Amit", 85, "abc")
        };

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            out.writeObject(students);
        }

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream("students.dat"))) {
            StudentData[] loaded = (StudentData[]) in.readObject();
            for (StudentData s : loaded) System.out.println(s);
        }
    }
}
