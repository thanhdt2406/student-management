drop database student_management;
create  database student_management;
use  student_management;


CREATE TABLE user (
                      id int NOT NULL AUTO_INCREMENT,
                      username varchar(30) NOT NULL unique ,
                      password varchar(30) NOT NULL,
                      signUp_date datetime default now(),
                      role varchar(30) not null ,
                      PRIMARY KEY (id)
);

CREATE TABLE `teacher` (
                           `id` int NOT NULL,
                           `name` varchar(30) NOT NULL,
                           `phone_number` varchar(30) ,
                           address varchar(100) ,
                           `salary` int ,
                           `status` bit(1) DEFAULT b'1',
                           PRIMARY KEY (`id`),
                           CONSTRAINT `teacher_id` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
);

CREATE TABLE `classroom` (
                             `classID` int NOT NULL AUTO_INCREMENT,
                             `name` varchar(30) NOT NULL unique ,
                             `startDate` datetime DEFAULT now(),
                             PRIMARY KEY (`classID`)
);

CREATE TABLE `student` (
                           `id` int NOT NULL,
                           `name` varchar(30) NOT NULL,
                           `classID` int NOT NULL,
                           `phone_number` varchar(30) DEFAULT NULL,
                           address varchar(100) ,
                           `status` bit(1) DEFAULT b'1',
                           PRIMARY KEY (`id`),
                           KEY `student_id2` (`classID`),
                           CONSTRAINT `student_id` FOREIGN KEY (`id`) REFERENCES `user` (`id`),
                           CONSTRAINT `student_id2` FOREIGN KEY (`classID`) REFERENCES `classroom` (`classID`)
);

CREATE TABLE `class_diary` (
                              `diaryID` int NOT NULL AUTO_INCREMENT,
                              `content` varchar(1000) not null,
                              `date` datetime DEFAULT now(),
                              `classID` int NOT NULL,
                              PRIMARY KEY (`diaryID`),
                              KEY `class_diary` (`classID`),
                              CONSTRAINT `class_diary` FOREIGN KEY (`classID`) REFERENCES `classroom` (`classID`)
);
CREATE TABLE `student_diary` (
                                `diaryID` int NOT NULL AUTO_INCREMENT,
                                `content` varchar(1000) not null ,
                                `date` datetime DEFAULT now(),
                                `studentID` int NOT NULL,
                                PRIMARY KEY (`diaryID`),
                                KEY `student_diary` (`studentID`),
                                CONSTRAINT `student_diary` FOREIGN KEY (`studentID`) REFERENCES `student` (`id`)
);

CREATE TABLE `academic_staff` (
                                  `ID` int NOT NULL,
                                  `name` varchar(30),
                                  `phone_number` varchar(30) ,
                                  address varchar(100) ,
                                  `salary` int ,
                                  `status` bit(1) DEFAULT b'1',
                                  PRIMARY KEY (`ID`),
                                  CONSTRAINT `academic_id` FOREIGN KEY (`ID`) REFERENCES `user` (`id`)
);

CREATE TABLE `academic_classroom` (
                                      `classID` int NOT NULL,
                                      `asID` int NOT NULL,
                                      PRIMARY KEY (`classID`,`asID`),
                                      KEY `academic_classroom` (`asID`),
                                      CONSTRAINT `academic_classroom` FOREIGN KEY (`asID`) REFERENCES `academic_staff` (`ID`),
                                      CONSTRAINT `classroom_academic` FOREIGN KEY (`classID`) REFERENCES `classroom` (`classID`)
);

CREATE TABLE `subject` (
                           `subId` int NOT NULL AUTO_INCREMENT,
                           `subName` varchar(30) NOT NULL,
                           PRIMARY KEY (`subId`)
);

CREATE TABLE `mark` (
                        `markID` int NOT NULL AUTO_INCREMENT,
                        `subID` int NOT NULL,
                        `studentID` int NOT NULL,
                        `practiceMark` double DEFAULT 0,
                        `theoreticalMark` double DEFAULT 0,
                        PRIMARY KEY (`markID`),
                        KEY `subject_student` (`subID`),
                        KEY `student_subject` (`studentID`),
                        CONSTRAINT `student_subject` FOREIGN KEY (`studentID`) REFERENCES `student` (`id`),
                        CONSTRAINT `subject_student` FOREIGN KEY (`subID`) REFERENCES `subject` (`subId`)
);

CREATE TABLE `teacher_class` (
                                 `teacherID` int NOT NULL,
                                 `classID` int NOT NULL,
                                 PRIMARY KEY (`teacherID`,`classID`),
                                 KEY `class_id` (`classID`),
                                 CONSTRAINT `class_teacher` FOREIGN KEY (`classID`) REFERENCES `classroom` (`classID`),
                                 CONSTRAINT `teacher_id2` FOREIGN KEY (`teacherID`) REFERENCES `teacher` (`id`)
);

-- Class
DROP PROCEDURE IF EXISTS createNewClass;
delimiter //
create procedure createNewClass(IN _name varchar(30))
begin
    insert into classroom (name) value (_name);
end //
delimiter ;

DROP PROCEDURE IF EXISTS createNewClassWithDate;
delimiter //
create procedure createNewClassWithDate(IN _name varchar(30),in _date datetime)
begin
    insert into classroom (name,startDate) value (_name,_date);
end //
delimiter ;


-- Academic Staff
DROP PROCEDURE IF EXISTS createNewAcademicStaff;
delimiter //
create procedure createNewAcademicStaff(IN _username varchar(30),IN _password varchar(30), in _name varchar(30))
begin
    insert into user (username, password, role) value (_username,_password,'academic_staff');
    insert into academic_staff(id,name) value ((select id from user where username = _username),_name);
end //
delimiter ;

DROP PROCEDURE IF EXISTS createNewAcademicStaffFullInformation;
delimiter //
create procedure createNewAcademicStaffFullInformation(IN _username varchar(30),IN _password varchar(30), in _name varchar(30),in _phone_number varchar(30),in _address varchar(100),in _salary int)
begin
    insert into user (username, password, role) value (_username,_password,'academic_staff');
    insert into academic_staff(id,name,phone_number,address,salary) value ((select id from user where username = _username),_name,_phone_number,_address,_salary);
end //
delimiter ;
DROP PROCEDURE IF EXISTS deleteAcademicStaff;
delimiter //
create procedure deleteAcademicStaff(IN _ID INT)
begin
delete from academic_staff where ID = _ID;
delete from user where id = _ID;
end  //
delimiter ;

DROP PROCEDURE IF EXISTS editAcademicStaff;
delimiter //
create procedure editAcademicStaff(IN _ID INT,IN _name varchar(30),IN _phone varchar(30),IN _address varchar(30),IN _status bit)
begin
    UPDATE academic_staff
    SET name=_name, phone_number = _phone,address =_address, status = _status
    WHERE ID=_ID;
end  //
delimiter ;
-- Teacher
DROP PROCEDURE IF EXISTS createNewTeacher;
delimiter //
create procedure createNewTeacher(IN _username varchar(30),IN _password varchar(30), in _name varchar(30))
begin
    insert into user (username, password, role) value (_username,_password,'teacher');
    insert into teacher(id,name) value ((select id from user where username = _username),_name);
end //
delimiter ;

DROP PROCEDURE IF EXISTS createNewTeacherFullInformation;
delimiter //
create procedure createNewTeacherFullInformation(IN _username varchar(30),IN _password varchar(30), in _name varchar(30),in _phone_number varchar(30),in _address varchar(100),in _salary int)
begin
    insert into user (username, password, role) value (_username,_password,'teacher');
    insert into teacher(id,name,phone_number,address,salary) value ((select id from user where username = _username),_name,_phone_number,_address,_salary);
end //
delimiter ;


-- Student
DROP PROCEDURE IF EXISTS createNewStudent;
delimiter //
create procedure createNewStudent(IN _username varchar(30),IN _password varchar(30), in _name varchar(30), in _classID int)
begin
    insert into user (username, password, role) value (_username,_password,'student');
    insert into student(id,name,classID) value ((select id from user where username = _username),_name,_classID);
end //
delimiter ;

DROP PROCEDURE IF EXISTS createNewStudentFullInformation;
delimiter //
create procedure createNewStudentFullInformation(IN _username varchar(30),IN _password varchar(30), in _name varchar(30),in _classID int,in _phone_number varchar(30),in _address varchar(100))
begin
    insert into user (username, password, role) value (_username,_password,'student');
    insert into student(id,name,classID,phone_number,address) value ((select id from user where username = _username),_name,_classID,_phone_number,_address);
end //
delimiter ;


-- Student Diary
DROP PROCEDURE IF EXISTS createNewStudentDiary;
delimiter //
create procedure createNewStudentDiary(IN _content varchar(1000), in _studentID int)
begin
    insert into student_diary(content, studentID) value (_content,_studentID);
end //
delimiter ;


-- Class Diary
DROP PROCEDURE IF EXISTS createNewClassDiary;
delimiter //
create procedure createNewClassDiary(IN _content varchar(1000), in _classID int)
begin
    insert into class_diary(content, classID) value (_content,_classID);
end //
delimiter ;


-- Subject
DROP PROCEDURE IF EXISTS createNewSubject;
delimiter //
create procedure createNewSubject(in _subName varchar(30))
begin
    insert into subject(subName) value (_subName);
end //
delimiter ;


-- Mark
DROP PROCEDURE IF EXISTS createNewMark;
delimiter //
create procedure createNewMark(in _subID int,in _studentID int, in _practiceMark double, in _theoreticalMark double)
begin
    insert into mark(subID, studentID, practiceMark, theoreticalMark) value (_subID,_studentID,_practiceMark,_theoreticalMark);
end //
delimiter ;

-- Delete Student
DROP  PROCEDURE IF EXISTS deleteStudent;
delimiter //
create procedure deleteStudent(in _studentID int)
begin
    delete from student where id = _studentID;
end //
//
delimiter ;

-- Delete Student
DROP  PROCEDURE IF EXISTS updateStudent;
delimiter //
create procedure updateStudent(in _id int, in _name varchar(30), in _phonenumber varchar(30), in _address varchar(100),in _status bit, in _classID int)
begin
    update student set
                       name = _name,
                       phone_number = _phonenumber,
                       address = _address,
                       status = _status,
                       classID = _classID
    where id = _id;
end //
//
delimiter ;


-- Create Data
insert into user (username, password, role) VALUEs ('admin','admin','admin');

call createNewClass('C0720I1');
call createNewClass('C0720I2');
call createNewClass('C0520I1');
call createNewClass('C0520I2');
call createNewClass('C0520I3');
call createNewClass('C0820I1');
call createNewClass('C0820I2');

call createNewStudent('thanhdt','123456','Do Tien Thanh',2);
call createNewStudent('vietdq','123456','Do Quoc Viet',2);
call createNewStudent('minhnv','123456','Nguyen Van Minh',1);
call createNewStudent('duonghn','123456','Hoang Nhat Duong',3);
call createNewStudent('dungnv','123456','Nguyen Van Dung',5);

call createNewClassDiary('Viet la mot thang ngao',2);
call createNewClassDiary('Day la lop nao?',5);
call createNewClassDiary('Lop nay sap tot nghiep',4);

call createNewStudentDiary('Day la mot hoc sinh ngoan',2);
call createNewStudentDiary('Day la mot hoc sinh ngao',3);
call createNewStudentDiary('Who are you?',4);
call createNewStudentDiary('Hello World',5);
call createNewStudentDiary('Goodbye World',6);

call createNewAcademicStaffFullInformation('thuypt','000000','Pham Thi Thuy','0931825471','Sai Gon',1400);
call createNewAcademicStaffFullInformation('hanhnh','000000','Nguyen Hong Hanh','0931752468','Quang Nam',1200);
call createNewAcademicStaffFullInformation('thanggv','000000','Giang Van Thang','0915287635','Lang Son',300);

call createNewTeacherFullInformation('anhvtk','111111','Vu Kieu Anh','0935436952','Ha Noi',2000);
call createNewTeacherFullInformation('chault','111111','Le Thi Chau','0932563471','Thai Nguyen',2500);
call createNewTeacherFullInformation('thenk','111111','Nguyen Khac The','0982145786','Ca Mau',1000);
call createNewTeacherFullInformation('sonmc','111111','Mai Cong Son','0932361747','Da Nang',1500);
call createNewTeacherFullInformation('quannm','111111','Nguyen Minh Quan','0965141214','Thai Binh',500);