# Design Patterns – Office System (Pseudocode Version)

This README explains how three major design patterns are used to build a simple office system:

- **Singleton Pattern** – Controls the HR Manager as a single instance
- **Factory Pattern** – Creates different employee types
- **Observer Pattern** – Allows employees to automatically receive notices

---

# 1. Singleton Pattern – HR Manager

## What is the Singleton Pattern?

The **Singleton Pattern** ensures that **only one object** of a class exists throughout the entire program.

It is used when:

- You need **one central authority**
- You want **controlled access** to that object
- You need to avoid multiple conflicting instances

In this office system, the **HR Manager** should exist only once, because:

- All employees depend on HR’s announcements
- There should not be multiple HR managers giving different instructions
- A single global access point simplifies management

---

## Diagram

```
 ---------------------------
|        HRManager          |
|---------------------------|
| + getInstance()           |
| + publishNotice()         |
 ---------------------------
```

---

## Flowchart

```
    +-----------------------------+
    |     getInstance() called    |
    +-----------------------------+
                 |
                 v
      +-----------------------+
      | Is instance null?     |
      +-----------------------+
        | Yes         | No
        v             v
+----------------+   +----------------------------+
| Create new     |   | Return existing instance  |
| HRManager      |   +----------------------------+
+----------------+
```

---

## Pseudocode

```
class HRManager:
    private static instance = null

    private constructor()

    static getInstance():
        if instance == null:
            instance = new HRManager()
        return instance

    function publishNotice(message):
        print "Notice: " + message
```

---

# 2. Factory Pattern – Employee Creation

## What is the Factory Pattern?

The **Factory Pattern** is used to create objects **without exposing the creation logic to the client**.

It is used when:

- You need to create many related objects
- The objects share a common interface
- You want a clean, central place for object creation

In this office system, different employee types are created:

- Full-Time Employee
- Part-Time Employee
- Intern

Instead of manually creating each type, the factory decides which object to return.

---

## Diagram

```
Request -----> [ EmployeeFactory ] -----> Employee Object
```

---

## Flowchart

```
    +------------------------------+
    |      createEmployee()        |
    +------------------------------+
                 |
                 v
      +----------------------+
      | Check employee type  |
      +----------------------+
      | FULLTIME / PARTTIME / INTERN
                 |
                 v
    +------------------------------+
    | Return corresponding object  |
    +------------------------------+
```

---

## Pseudocode

```
class EmployeeFactory:
    function createEmployee(type):
        if type == "FULLTIME":
            return new FullTimeEmployee()
        else if type == "PARTTIME":
            return new PartTimeEmployee()
        else if type == "INTERN":
            return new Intern()
        else:
            return null

class FullTimeEmployee:
    function getRole():
        return "Full-Time Employee"

class PartTimeEmployee:
    function getRole():
        return "Part-Time Employee"

class Intern:
    function getRole():
        return "Intern"
```

---

# 3. Observer Pattern – Notice System

## What is the Observer Pattern?

The **Observer Pattern** allows multiple objects to be notified automatically when something changes in another object.

It is used when:

- Many objects depend on one central object
- You want **automatic updates** without manual checking
- You want to maintain a **publish–subscribe relationship**

In this office system:

- HR publishes notices
- Employees (observers) automatically receive updates
- No employee needs to manually check for new announcements

This keeps the system responsive and consistent.

---

## Diagram

```
     HRManager (Subject)
            |
    ------------------------
    |   |   |   |   |     |
 Employee A ... Employee N
```

---

## Flowchart

```
    HRManager
        |
        | addObserver()
        v
+------------------------------+
| Add employee to observer list|
+------------------------------+
        |
 HR publishes notice
        v
+------------------------------+
| notifyObservers(message)     |
+------------------------------+
        |
        v
+------------------------------+
| All employees receive update |
+------------------------------+
```

---

## Pseudocode

```
interface Observer:
    function update(message)

class Employee implements Observer:
    function update(message):
        print "Received: " + message

class HRManager:
    observers = []

    function addObserver(emp):
        observers.add(emp)

    function notifyObservers(msg):
        for each observer in observers:
            observer.update(msg)

    function publishNotice(msg):
        notifyObservers(msg)
```

---

# Summary Table

| Pattern   | Purpose                         | Role in System           |
| --------- | ------------------------------- | ------------------------ |
| Singleton | Only one instance allowed       | HR Manager               |
| Factory   | Creates related objects easily  | Employees (FT/PT/Intern) |
| Observer  | Auto-notifications to observers | Employees receive notice |

---

# End of README
