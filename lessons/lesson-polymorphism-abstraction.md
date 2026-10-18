# Lesson: Polymorphism and Abstraction

**Project:** Library (`Book`, `Member`, `Student`)
**Level:** You know the basics of Java.
**Time:** About 1-2 hours.

---

## Part 1: Polymorphism

### The idea

Polymorphism means "many forms". One type can have many behaviors.

A variable of type `Member` can hold a `Member` or a `Student`. When you call a method, Java runs the version that belongs to the real object.

### Code

```java
public class Member {
    private String name;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBorrowLimit() {
        return 3;
    }
}
```

```java
public class Student extends Member {

    public Student(String name) {
        super(name);
    }

    @Override
    public int getBorrowLimit() {
        return 5;
    }
}
```

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Member> members = new ArrayList<>();
        members.add(new Member("Olga"));
        members.add(new Student("Anna"));

        for (Member m : members) {
            System.out.println(m.getName() + " can borrow " + m.getBorrowLimit());
        }
    }
}
```

**Output:**

```
Olga can borrow 3
Anna can borrow 5
```

The list type is `Member`, but each object uses its own `getBorrowLimit()`.

### Key points

- Use `@Override` when you replace a method from the parent class. If the method does not really replace a parent method (for example, you made a spelling mistake in the name), the compiler shows an error.
- The type of the variable decides which methods you can call.
- The type of the object decides which version runs.

### Common mistake

Overloading is not overriding.
- **Overriding:** same method name and same parameters, in a child class.
- **Overloading:** same method name, different parameters, in the same class.

---

## Part 2: Abstraction

### The idea

Abstraction means you show **what** something does and hide **how** it does it.

Java has two tools for this:

| Tool | Use it when |
|---|---|
| `abstract class` | Classes share some code and some fields, but each child must complete a part. |
| `interface` | You only need a promise: "this class can do these actions". |

### Abstract class

You cannot create an object from an abstract class (`new Member(...)` will not compile). Abstract methods have no body. Every child class must write one.

Change `Member` like this:

```java
public abstract class Member {
    private String name;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getBorrowLimit();
}
```

`Student` stays almost the same, because it already has `getBorrowLimit()`.

Now add a second child:

```java
public class Teacher extends Member {

    public Teacher(String name) {
        super(name);
    }

    @Override
    public int getBorrowLimit() {
        return 10;
    }
}
```

In `Main`, replace `new Member("Olga")` with `new Teacher("Olga")`.

### Interface

An interface is a list of methods a class promises to have. A class can implement many interfaces, but it can extend only one class.

```java
public interface Borrowable {
    boolean isAvailable();
    void borrow();
    void giveBack();
}
```

`Book` implements the interface:

```java
public class Book implements Borrowable {
    private String title;
    private String author;
    private boolean available = true;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void borrow() {
        available = false;
    }

    @Override
    public void giveBack() {
        available = true;
    }
}
```

Use it:

```java
Borrowable item = new Book("Clean Code", "Robert Martin");
item.borrow();
System.out.println(item.isAvailable()); // false
```

This is polymorphism and abstraction together. The code uses `Borrowable` and does not care which class is behind it. Later, a `Magazine` or a `DVD` can implement the same interface.

### Abstract class vs. interface (short rule)

- Is it a kind of thing (`Student` is a `Member`)? Use an **abstract class**.
- Is it an ability (`Book` can be borrowed)? Use an **interface**.

### Common mistakes

- Trying to create an object from an abstract class or an interface.
- Forgetting to write one of the abstract methods in a child class. This is a compile error.
- Putting too much into an interface. Keep it small.

---

## Practice (30 minutes)

1. Make `Member` abstract and add `Teacher`.
2. Create a `Borrowable` interface and make `Book` implement it.
3. In `Main`, create a `List<Member>` with one `Student` and one `Teacher`. Print each borrow limit.
4. Create a `Book`, call `borrow()`, and print `isAvailable()`.
5. Call `borrow()` twice on the same book. Think about what should happen the second time. **We will fix this in the next topic (Exceptions).**

## Self-check

1. What decides which method runs: the variable type or the object type?
2. Why can you not write `new Member("Olga")` when `Member` is abstract?
3. Can a class implement two interfaces? Can it extend two classes?
4. When would you pick an interface instead of an abstract class?

## Notes to write (3 lines)

- **What it is:**
- **When to use it:**
- **One common mistake:**

## Next

**Stage 2, Exceptions.** You will use `Book.borrow()` to throw a `BookNotAvailableException` when the book is already taken.
