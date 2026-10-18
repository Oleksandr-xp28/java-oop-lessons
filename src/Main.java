import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Member> members = new ArrayList<>();
        members.add(new Teacher("Olga"));
        members.add(new Student("Anna"));

        for (Member m : members) {
            System.out.println(m.getName() + " can borrow " + m.getBorrowLimit());
        }
    }
}
