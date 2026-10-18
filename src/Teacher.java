public class Teacher extends Member {

    public Teacher(String name) {
        super(name);
    }

    @Override
    public int getBorrowLimit() {
        return 10;
    }
}
