# 📚 Library Management System

A **simple console-based Java Library Management System** using **MySQL** for storage.

---

## 🧾 Overview

This project provides **basic CRUD** for books & members, and **loan/return recording** via Java console menus.

### 🧩 Core Classes

* `Main.main` — entry point & menu flow
* `Admin` — admin operations:
  `recordLoan`, `recordReturn`, `addNewMember`, `addNewBook`, `searchBook`, `deleteBook`, `updateBook`
* `Book`, `Member`, `Loan` — simple POJOs

### 🗂 Database Schema & Seed Data

* `sql/library_manage_system.sql` — database + tables
* `sql/insert_data.sql` — sample inserts

---

## 📁 Files in this Repository

```
src/Main.java
src/Admin.java
src/Book.java
src/Member.java
src/Loan.java
sql/library_manage_system.sql
sql/insert_data.sql
Lib/                    # contains JDBC driver
Library Managment System.iml
.gitignore
.idea/...
```

---

## 🔧 Requirements

* ☕ Java JDK (configured for JDK 21)
* 🗄 MySQL server
* 🔗 JDBC driver (`mysql-connector-j-8.4.0.jar` under /Lib)

---

## ▶️ Setup & Run

1. **Create DB & Insert Data**

```bash
mysql -u root -p < sql/library_manage_system.sql
mysql -u root -p library_manage_system < sql/insert_data.sql
```

2. **Update DB Credentials**
   Edit top of `src/Admin.java` → `url`, `username`, `password`

3. **Compile & Run (Windows example)**

```bash
javac -cp "Lib/mysql-connector-j-8.4.0.jar" -d out src/*.java
java -cp "out;Lib/mysql-connector-j-8.4.0.jar" Main
```

> On Linux/Mac replace `;` with `:` in classpath.


