# Here we will see use of Eclipse and MySQL for SpringBoot Microservices Project.

# Eclipse
## Importing the SpringBoot Maven Project
* Once you have created the project in spring initializer : https://start.spring.io/;
* Download that project, that project must be maven project, and JDK versoin you can chose whatever you have downloaded in the system.
* You don't have to download tomcat server. As in springboot project they come pre-installed.
* Once the project is downloaded, extract the project.
* Now open Eclipse : You must have this eclipse version to run spring/springboot projects : Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)
* Also you must download JDK
* So now that project you can open in eclipse :
* Just follow below steps
    * Open the eclipse ide,
    * Goto File, click on Import Project, Expand maven folder in sub-window, click on Existing maven project, browse the file, select the folder and then finish.
    * hence our project is imported, Open the pom.xml file to update it, as it will download all the dependency.

## Running the springboot project in TomCat Server
* To run the project service on tomcat server. first make sure it is spring boot application. As springboot annotation must be there in the projectNamed java file.
* Only the springboot project has pre-installed Tomcat server, as you have to install yourself.
* Open that projectNamedjava file.
* Righg click on it.
* click on Run As, and then click Run As java application. Your project will run in tomcat server
* You can check the port in settings.properties file the port in which your project is running, or check in console when the tomcat server is started, it will show you there only the port id.

## Create the jar file of the application in Eclipse
* You can build your project and create the jar file, which is a executable application file. You can run thie jar file from command prompt.
* You can also use this jar file to run in docker or any other services

## Running the jar file from Command Prompt
* If we want to run same api application in different port in same computer/host. then we can create the jar file of it and run via different command prompts in same computer.


# MySQL
## How to install and setup in windows 11 and in command prompt with workbench ide
* Just follow this youtube video : https://www.youtube.com/watch?v=mLQpd3hRD7g&ab_channel=AmitThinks
* download website is : https://downloads.mysql.com/archives/installer/
* In the video ther is option to open in command prompt
* Setting up the environment
* Username usually: root
* pass is : Vichaha9haha@123 like thing only
* Remember : There is dedicated command line also downloaded here for mysql. and you can do from normal command prompt also.

## How to get connection details and connect my DB with SpringBoot project
*

## Let's Populate and prepare our DB for LibraryManagementSystem as ad-hoc project

create database librarymanagementsystem;

use librarymanagementsystem;

create table IF NOT EXISTS student(
	studentId INTEGER NOT NULL ,
    firstName varchar(128),
    lastName varchar(128),
    PRIMARY KEY (studentId)
);

create table IF NOT EXISTS book(
	bookId INTEGER NOT NULL,
    bookName varchar(128),
    author varchar(128),
    TotalCountOfThisBookInitiallyPresentInLibrary INTEGER NOT NULL,
    countOfThisBookCurrentlyPresentInLibrary INTEGER NOT NULL,
    PRIMARY KEY (bookId)
);

-- A student can't issue more than 3 book at a time
-- Number of book present in library should be also taken care. If a student take a book from library, then count of that book currently present in the llibrary would
-- decrese by one, and the count of number of book that single student will increase by one, but never be more than 3. 
-- If a student is going to get more than 3 book, he can't get. make that sure.
-- A student can keep a single book for max 15 days, if he keeps more than 15days, 10 rs per day fine will be paid.
-- max 100 rs fine is allowed, after 100 rs fine is reached, authority should call that student and get the book to submit back with fine.
-- so before issuing the library, first librarian will check if this book is present and also checks if this student has exceedes his book limit or not.

create table IF NOT EXISTS bookIssued(
	bookIssueReferenceId INTEGER NOT NULL,
	issuedBookId INTEGER NOT NULL,
    issuedToStudentId INTEGER NOT NULL,
    issueDate date,
    returnDate date,
    fine Integer default 0,  -- fine should be per book issue, not combine
    numberOfActiveBookInThisStudentId integer,  -- this count tells number of book present with this student id.
    statusOfThisIssueReferenceId varchar(32), -- Can be true of false, false for those which book is returned after fine is cleared if any
    finePendingStatusOnThisIssueReferenceId varchar(32),  -- default value : paid, unpaid, n/a (when fine is 0) : until the fine is paid, book can't be returned and fine keeps on going per day rule. default false; will be true when library gives him back
    PRIMARY KEY (bookIssueReferenceId)
);


#####  ============================ INSRTING SOME VALUES IN THIS TABLE TO MAKE API AND UI =================================
insert into student
(studentId , firstName ,    lastName) 
values
(1,'vicky','prasad'),
(2,'shashank','chouhan'),
(3,'gautam','batra'),
(4,'sonali','singh'),
(5,'harsh','pandey');


insert into book
(bookId , bookName , author, TotalCountOfThisBookInitiallyPresentInLibrary ,     countOfThisBookCurrentlyPresentInLibrary)
values
(1,'concept of physics','hc verma',105,104), -- as this book was issued, so one minus
(2,'maths','rd sharma',3,2), -- as this book was issue so one minus
(3,'sst','batra sahab',30,30),
(4,'science','singh sahab',2,2),
(5,'evs','pandey ji',10,10);

insert into bookIssued
(bookIssueReferenceId,issuedBookId,issuedToStudentId ,issueDate ,returnDate,fine , numberOfActiveBookInThisStudentId,
    statusOfThisIssueReferenceId ,finePendingStatusOnThisIssueReferenceId )
 values
(101,1,1,'2024-07-01',null,0,1,'Active','n/a'),
(102,2,3,'2024-07-01',null,0,1,'Active','n/a');


* Here primary key index will be build by default.
* UI should have option to login student, check availability of book student wants, check eligibility of student if he can issue,  issue book, return book, pay fine. You can simulate this options to update table count, fine etc.
* Admin/Librarian has option to add new book, check list of all students who have issued book, check the total count of books are good in issue and those present in library.










