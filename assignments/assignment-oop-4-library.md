# OOP. 4 — Practical Assignment: Library

**Topic:** Polymorphism and Abstraction
**Project:** continues `Book`, `Member`, `Student`, `Teacher`, `Borrowable` from the lesson.
**Task only.** Write all the code yourself.

---

## Data

**Member** (abstract class)

| Field | Type |
|---|---|
| Last name | `String` |
| Year of birth | `int` |
| Borrow limit | from the method `getBorrowLimit()` |

Children: `Student` (limit 5), `Teacher` (limit 10).

**Book** (implements `Borrowable`)

| Field | Type |
|---|---|
| Title | `String` |
| Author | `String` |
| Year of publication | `int` |
| Available | `boolean` |

---

## The task

1. Create an array or list of 5 books and 4 members (at least 2 students and 2 teachers).
2. Calculate and print the **average year of birth** of all members.
3. Print the **last name and borrow limit** of every member, using one loop over a `List<Member>`.
4. Find the books **published more than 10 years ago** (before 2016) and print all their information.
5. Borrow 2 books by calling `borrow()`. Then print only the books that are **still available**.

---

## Requirements

- `Member` must be `abstract`, and `getBorrowLimit()` must be an abstract method.
- `Student` and `Teacher` must each `@Override` `getBorrowLimit()`.
- `Book` must implement the `Borrowable` interface.
- All fields must be `private`. Use getters.
- Steps 3 and 5 must use the parent type (`Member`, `Borrowable`), not the child type. This is the point of the whole task.
- Every class must have a `toString()` method for printing.

---

## Example output (your numbers may differ)

This is sample data. The titles and years are only examples. There are 4 members, born in 1990, 1995, 1985 and 2000, and 5 books. In step 5, the books "Effective Java" and "Head First Java" are borrowed.

```
Average year of birth: 1992.5

Members:
Shevchenko - limit 5
Kovalenko - limit 5
Bondarenko - limit 10
Tkachenko - limit 10

Books published before 2016:
"Clean Code", Robert Martin, 2008
"Effective Java", Joshua Bloch, 2008
"Java Concurrency in Practice", Brian Goetz, 2006
"Head First Java", Kathy Sierra, 2005

Available books after borrowing:
"Clean Code", Robert Martin, 2008
"Modern Java in Action", Raoul-Gabriel Urma, 2018
"Java Concurrency in Practice", Brian Goetz, 2006
```

---

## Hints

- Add up the years of birth in a loop, then divide by `members.size()`. Use `double` for the result.
- For step 5, loop over the books and check `isAvailable()`.
- If `getBorrowLimit()` returns the same number for both classes, you forgot `@Override` or you wrote a different method name.

---

## Self-check before you finish

1. Does `new Member("Shevchenko", 1990)` fail to compile? It should.
2. Does your loop in step 3 use `Member`, not `Student`?
3. Does your program still work if you add a third child class, for example `Guest` with a limit of 1? Try it. You should only need to add one class, not change the loop.

---

## Bonus (optional)

Try calling `borrow()` twice on the same book. Write down what happens and why it is wrong. We fix this in **Stage 2: Exceptions**.
