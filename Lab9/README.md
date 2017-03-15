# Storage: SQLite Databases

## Pair Programming

Pair programming has many benefits in software development, CS
education, and particularly learning mobile application development
(Seyam and McCrickard, 2016). In this lab, we will try pair
programming. You must work in pairs. You can work with anybody of your
choosing. (You will probably benefit most if you work with someone
other than your partner for the course project, but that's not a
requirement *today*.)

One of you will be the "driver"; the other will be the
"navigator". The driver types at the computer, while the navigator
reviews what is being written and watches for mistakes. Every 15
minutes, the driver and navigator should switch roles.

In a common model of pair programming the driver and navigator use a
single computer. Today we won't be quite so strict. The driver and
navigator will use a single instance of AndroidStudio, but can use
multiple computers (e.g., you might want AndroidStudio open on one lab
machine, and a browser with documentation on another).

**To receive credit for this lab you must pair program.**

Mohammed Seyam and D. Scott McCrickard. 2016. Teaching Mobile
Application Development with Pair Programming. In *Proceedings of the
47th ACM Technical Symposium on Computer Science Education (SIGCSE
2016)*, pages 96-101. Memphis, USA.

## Introduction

In this lab you will build a simple app that uses an
[SQLite database](https://www.sqlite.org/). 

You are provided with skeleton code, which includes two Java files:
```MainActiviy``` and ```DBHelper```. ```DBHelper``` is a subclass of
```SQLiteOpenHelper```. This class creates a database that has three
columns: an id, item, and number.

The app allows the user to add new rows to the database. The app also
allows the user to search for rows that have a particular item. Below
is a sample screenshot of the app after the user has searched for the
item "Cat". In this case the database had three rows with the item
"Cat" with the numbers "2", "5", and "8". (Note that the results have
been sorted by number.)

![Main Activity](http://i.imgur.com/3UVwHED.png)



## Resources

The following documentation might be helpful in this lab.

SQLite databases in Android:
http://developer.android.com/training/basics/data-storage/databases.html

Cursor: http://developer.android.com/reference/android/database/Cursor.html



## Todo


Read the skeleton code and make sure you understand what it's doing.

Complete the TODOs **by pair programming**.

## Deliverables

Show your working app to the instructor or TA

