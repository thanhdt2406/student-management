CREATE DATABASE case3;


use  case3;

CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `username` varchar(30) NOT NULL,
                        `password` varchar(30) NOT NULL,
                        `name` varchar(30) NOT NULL,
                        `role` varchar(30) NOT NULL,
                        `phone_number` varchar(30) DEFAULT NULL,
                        `status` bit(1) DEFAULT b'1',
                        PRIMARY KEY (`id`)
);

CREATE TABLE `teacher` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `salary` int DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           CONSTRAINT `teacher_id` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
);

CREATE TABLE `classroom` (
                             `classID` int NOT NULL AUTO_INCREMENT,
                             `name` varchar(30) NOT NULL,
                             `startDate` date DEFAULT NULL,
                             PRIMARY KEY (`classID`)
);

CREATE TABLE `student` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `classID` int NOT NULL,
                           PRIMARY KEY (`id`),
                           KEY `student_id2` (`classID`),
                           CONSTRAINT `student_id` FOREIGN KEY (`id`) REFERENCES `user` (`id`),
                           CONSTRAINT `student_id2` FOREIGN KEY (`classID`) REFERENCES `classroom` (`classID`)
);

CREATE TABLE `classdiary` (
                              `diaryID` int NOT NULL AUTO_INCREMENT,
                              `content` varchar(1000) DEFAULT NULL,
                              `date` date DEFAULT NULL,
                              `classID` int NOT NULL,
                              PRIMARY KEY (`diaryID`),
                              KEY `class_diary` (`classID`),
                              CONSTRAINT `class_diary` FOREIGN KEY (`classID`) REFERENCES `classroom` (`classID`)
);
CREATE TABLE `studentdiary` (
                                `diaryID` int NOT NULL AUTO_INCREMENT,
                                `content` varchar(1000) DEFAULT NULL,
                                `date` date DEFAULT NULL,
                                `studentID` int NOT NULL,
                                PRIMARY KEY (`diaryID`),
                                KEY `student_diary` (`studentID`),
                                CONSTRAINT `student_diary` FOREIGN KEY (`studentID`) REFERENCES `student` (`id`)
);

CREATE TABLE `academic_staff` (
                                  `asID` int NOT NULL AUTO_INCREMENT,
                                  `salary` int DEFAULT NULL,
                                  PRIMARY KEY (`asID`),
                                  CONSTRAINT `academic_id` FOREIGN KEY (`asID`) REFERENCES `user` (`id`)
);

CREATE TABLE `acedemic_classroom` (
                                      `classID` int NOT NULL,
                                      `asID` int NOT NULL,
                                      PRIMARY KEY (`classID`,`asID`),
                                      KEY `academic_classroom` (`asID`),
                                      CONSTRAINT `academic_classroom` FOREIGN KEY (`asID`) REFERENCES `academic_staff` (`asID`),
                                      CONSTRAINT `classroom_academic` FOREIGN KEY (`classID`) REFERENCES `classroom` (`classID`)
);
CREATE TABLE `subject` (
                           `subId` int NOT NULL AUTO_INCREMENT,
                           `name` varchar(30) NOT NULL,
                           PRIMARY KEY (`subId`)
);
CREATE TABLE `mark` (
                        `markID` int NOT NULL AUTO_INCREMENT,
                        `subID` int NOT NULL,
                        `studentID` int NOT NULL,
                        `praticeMark` double DEFAULT NULL,
                        `theoreticalMark` double DEFAULT NULL,
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
                                 CONSTRAINT `class_id` FOREIGN KEY (`classID`) REFERENCES `classroom` (`classID`),
                                 CONSTRAINT `teacher_id2` FOREIGN KEY (`teacherID`) REFERENCES `teacher` (`id`)
);

insert into user(username, password, name, role) VALUES ('admin','admin','Admin','admin');