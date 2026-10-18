public class Student extends Member {

    public Student(String name) {
        super(name);
    }

    @Override
    public int getBorrowLimit() {
        return 5;
    }
}
