# Compile and Run the Java Experiments

Open a terminal at the repository root. Each experiment is independent; enter its folder before compiling.
The `.java` files are source programs. `javac` creates runnable `.class` bytecode, launched with `java` and
the class name (without `.java` or `.class`). Sample output is saved as `output.txt` in each experiment folder.

## Experiments 1-4

```sh
cd experiment1
javac *.java
java StudentDemoJava
java MarksArray
java StringDemo
java CaseStudy1
```

`CaseStudy1` reads the student count, name, and days from standard input.

```sh
cd ../experiment2
javac -d . MathUtil.java UseMath.java
java UseMath
javac -d . CaseStudy2.java com/scsvmv/fee/model/Student.java com/scsvmv/fee/service/FeeRule.java
java CaseStudy2
```

```sh
cd ../experiment3
javac InterfacesDemo.java
java InterfacesDemo

cd ../experiment4
javac InheritanceDemo.java
java InheritanceDemo
```

## Experiments 5-7

```sh
cd ../experiment5
javac ThreadDemo.java
java ThreadDemo

cd ../experiment6
javac ExceptionDemo.java
java ExceptionDemo

cd ../experiment7
javac FileOperationsDemo.java
java FileOperationsDemo
```

Experiment 5 booking order varies, but the synchronized final counts remain correct. Experiment 7 creates
`student.txt` and `result.txt` in the current directory.

## Experiments 8-9

These programs open Swing windows and need a graphical desktop session.

```sh
cd ../experiment8
javac AppletReplacement.java
java AppletReplacement

cd ../experiment9
javac RegisterForm.java
java RegisterForm
```

Java 17 removed the applet API, so Experiment 8 is implemented as the manual's Swing `JPanel` replacement.
`output.txt` describes the expected interactive window; it is not a terminal transcript.

## Experiment 10

Set up MySQL and the table from this folder:

```sh
cd ../experiment10
mysql -u root -p < schema.sql
```

Download MySQL Connector/J and put its JAR in this folder. Substitute the JAR's actual filename below.
The Linux classpath separator is `:`. Set `DB_URL`, `DB_USER`, and `DB_PASSWORD` for your local database.

```sh
javac -cp ".:mysql-connector-j-8.x.x.jar" Db.java StudentRecordApp.java
java -cp ".:mysql-connector-j-8.x.x.jar" StudentRecordApp
```

`experiment10/output.txt` is sample output; a live database and JDBC driver are required to reproduce it.