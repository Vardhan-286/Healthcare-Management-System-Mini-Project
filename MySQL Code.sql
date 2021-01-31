//Database creation ->
create database healthcare;
use healthcare;

//Tables Creation Code ->
create table Hospital (
   hospitalID int not null,
   name varchar(40),
   address varchar(50),
   phone varchar(11),
   PRIMARY KEY (hospitalID)
);
create table staff (
   staffID int not null,
   name varchar(20),
   dept varchar(20),
   gender char(1),
   phone varchar(11),
   hospitalID int,
   PRIMARY KEY (staffID),
   Foreign key (hospitalID) references Hospital(hospitalID)
);
create table Doctor (
   doctorID int not null,
   name varchar(25),
   gender char(1),
   phone varchar(11),
   speciality varchar(25),
   hospitalID int,
   PRIMARY KEY (doctorID),
   FOREIGN KEY (hospitalID) references Hospital(hospitalID)
);
create table Nurse (
   nurseID int not null,
   name varchar(25),
   gender char(1),
   phone varchar(11),
   hospitalID int,
   PRIMARY KEY (nurseID),
   FOREIGN KEY (hospitalID) references Hospital(hospitalID)
);
create table patient (
   patientID int not null auto_increment,
   name varchar(25),
   gender char(1),
   phone varchar(11),
   illness varchar(30),
   nurseID int,
   doctorID int,
   hospitalID int,
   PRIMARY KEY (patientID),
   FOREIGN KEY (nurseID) references Nurse(nurseID),
   FOREIGN KEY (doctorID) references Doctor(doctorID),
   FOREIGN KEY (HospitalID) references Hospital(hospitalID)
);
alter table patient auto_increment=60;












//Data Insertion Code  ->
INSERT INTO Hospital VALUES
(1,'John Hopkins Hospital','Dunbar-Broadway,21287','5616555511'),
(2,'Maryland General Hospital','Mount Vernon,21201','2565392728'),
(3,'Bon Secours Hospital','Penrose/Fayette Street Outreach,21223','6145380527');

 

INSERT INTO Staff values
(1,'edwin aburio','operating theatre','M','8546959665',1),
(2,'adames santos','emergency department','M','4989596657',1),
(3,'adamo edmund','intensive care unit','F','8547896658',1),
(4,'adams anthony','operating theatre','M','7695966589',1),
(5,'adams arnold','intensive care unit','M','7859596658',1),
(6,'acevedo carlos','emergency department','F','3659596658',1),
(7,'edwin asablio','general ward','M','8546754765',1),
(8,'edaan abufeo','intensive care unit','F','8547844576',1),
(9,'edwan atbrio','general ward','M','7746959665',1),
(10,'edwern afrurio','emergency department','M','8546959660',1),
(11,'edwin aburio','operating theatre','M','8546959665',1),
(12,'adames santos','emergency department','M','4989596658',1),
(13,'adamo edmund','intensive care unit','F','8547896658',1),
(14,'adams anthony','operating theatre','M','7695966584',1),
(15,'adams arnold','intensive care unit','M','7859596658',1),
(16,'acevedo carlos','emergency department','M','3659596658',1),
(17,'edwin asablio','general ward','M','8546754765',1),
(18,'edaan abufeo','intensive care unit','M','8547844576',1),
(19,'edwan atbrio','general ward','M','7746959665',1),
(20,'edwern afrurio','emergency department','M','8546959665',1),
(21,'edwin aburio','operating theatre','M','8546959665',2),
(22,'adames santos','emergency department','M','4989596658',2),
(23,'adamo edmund','intensive care unit','M','8547896658',2),
(24,'adams anthony','operating theatre','M','7695966581',2),
(25,'adams arnold','intensive care unit','M','7859596658',2),
(26,'acevedo carlos','emergency department','F','3659596658',2),
(27,'edwin asablio','general ward','M','8546754765',2),
(28,'edaan abufeo','intensive care unit','M','8547844576',2),
(29,'edwan atbrio','general ward','M','7746959665',2),
(30,'edwern afrurio','emergency department','M','8546959665',2),
(31,'edwin aburio','operating theatre','M','8546959665',2),
(32,'adames santos','emergency department','M','4989596658',2),
(33,'adamo edmund','intensive care unit','M','8547896658',2),
(34,'adams anthony','operating theatre','M','7695966581',2),
(35,'adams arnold','intensive care unit','M','7859596658',2),
(36,'acevedo carlos','emergency department','M','3659596658',2),
(37,'edwin asablio','general ward','M','8546754765',2),
(38,'edaan abufeo','intensive care unit','M','8547844576',2),
(39,'edwan atbrio','general ward','F','7746959665',2),
(40,'edwern afrurio','emergency department','M','8546959665',2),
(41,'edwin aburio','operating theatre','M','8546959665',3),
(42,'adames santos','emergency department','M','4989596658',3),
(43,'adamo edmund','intensive care unit','M','8547896658',3),
(44,'adams betny','operating theatre','F','7695966581',3),
(45,'adams arnold','intensive care unit','M','7859596658',3),
(46,'acevedo carlos','emergency department','M','3659596658',3),
(47,'edasin asablio','general ward','M','8546754765',3),
(48,'edsn abufeo','intensive care unit','M','8547844576',3),
(49,'eaan atbrio','general ward','M','7746959665',3),
(50,'eawern afrurio','emergency department','M','8546959665',3),
(51,'edwin aburio','operating theatre','M','8546959665',3),
(52,'ames santos','emergency department','F','4989596658',3),
(53,'bamo edmund','intensive care unit','M','8547896658',3),
(54,'sams anthony','operating theatre','M','7695966585',3),
(55,'some arnold','intensive care unit','M','7859596658',3),
(56,'devedo carlos','emergency department','F','3659596658',3),
(57,'eflon asablio','general ward','M','8546754765',3),
(58,'eddn abufeo','intensive care unit','M','8547844576',3),
(59,'essan atbrio','general ward','F','7746959665',3),
(60,'essern afrurio','emergency department','M','8546959665',3);
 

INSERT INTO Doctor VALUES
(1,'Ismail Sendi','M','5616555511','Internal medicine',1),
(2,'Donald Watren','F','2565392728',' Physician',1),
(3,'Tammy Jackson','M','5616555511','Orthopaedic',1),
(4,'Kimvir Dhillon','M','2565392728','Family Practice',1),
(5,'Barry George','F','5616555511','Cardiology',1),
(6,'Carol Pollack-rundle','M','2565392728','Ophthalmology',1),
(7,'Debbie Fink','M','5616555511','Family Practice',1),
(8,'Melissa Nitya','F','5616555511','PT/OT',1),
(9,'Jea Bocage','F','2565392728','General Surgery',2),
(10,'Fay Hatter','M','6145380527','Neurology',2),
(11,'Anand Gundakaram','M','6145380527','Internal medicine',2),
(12,'Gina Durham','M','2565392728','Optometry',2),
(13,'Howard Axe','F','5616555511','Pathology',2),
(14,'Sally Amsel','F','2565392728','Oncology',2),
(15,'David Cochran','M','2565392728','Physician',2),
(16,'Ronald Battiata','M','6145380527','Family Practice',2),
(17,'Patrick Ethington','M','5616555511','Pediatrics',3),
(18,'Jane Dacks','M','6145380527','Internal medicine',3),
(19,'Claudia Buser','F','5616555511','Internal medicine',3),
(20,'Warren Daniel','F','2565392728','Radiology',3),
(21,'Mazen Ganim','F','2565392728','Cardiology',3),
(22,'Kathleen Schwartz','M','6145380527','Obstetrics & Gynecology',3),
(23,'Guillermo Quetell','M','5616555511','Internal medicine',3);
 

INSERT INTO Nurse VALUES
(1,'Kathleen Schwartz','F','545896548',1),
(2,'Guillermo Quetell','M','887878989',1),
(3,'John Fleming','M','225443333',1),
(4,'S CaleKiDo','F','8484848545',1),
(5,'Virginia Alvarado','F','898988888',1),
(6,'Antoine Ferneini','M','4565544455',1),
(7,'David Oneil','M','758889578',2),
(8,'Don Doman','M','785788788',2),
(9,'Stephanie Neukum','F','78888999',2),
(10,'Alyssa Muellner','F','48478488',2),
(11,'David Donsker','M','48557848',2),
(12,'Mateen Aliniazee','M','8985745585',2),
(13,'Jan Slezak','F','9887878785',3),
(14,'Susanne Powell','F','878789799',3),
(15,'Mark Barry','M','898989875',3),
(16,'Luther Brady','F','879878888',3),
(17,'Michael Houlihan','M','84546444',3),
(18,'Rosanne Brunham','F','87877777',3),
(19,'Floyd Goodman','M','8776655555',3),
(20,'Anthony Chiodi','F','88777777',3);
 

INSERT INTO Patient VALUES
(1,'billy aaron','F','9598502043','Anemia',3,1,1),
(2,'charles aaron','M','8466436696','Anemia',2,8,1),
(3,'clarence aaron','F','8115338918','Obesity',1,3,1),
(4,'justin aaron','M','9899959982','Nephritis',4,6,1),
(5,'roy aaron','M','9982338608','Diabetes',6,7,1),
(6,'william aaron','M','8994351070','Anemia',5,2,1),
(7,'cary aaronson','M','8450493362','Anemia',1,4,1),
(8,'manuel abate','F','9384318984','Diabetes',5,5,1),
(9,'eric abaza','M','8253645566','Diabetes',3,4,1),
(10,'kareem abbas','M','9655702574','Anemia',6,1,1),
(11,'gary abbate','M','8815084520','Tuberculosis',2,7,1),
(12,'vito abbate','F','8041525089','Obesity',2,8,1),
(13,'william abbate','M','9085981127','Obesity',3,2,1),
(14,'christopher abberger','F','8946693962','Anemia',4,8,1),
(15,'earl abbey','F','8628838405','Obesity',1,3,1),
(16,'erik abbott','M','9785749264','Anemia',6,5,1),
(17,'james abbott','M','7961098999','Obesity',2,6,1),
(18,'jerry abbott','M','9095163242','Obesity',3,3,1),
(19,'jerry abbott','F','9807456050','Anemia',1,1,1),
(20,'john abbott','M','9442680973','Obesity',5,7,1),
(21,'michael abbott','M','8386317612','Anemia',7,9,2),
(22,'robert abbott','M','8614827038','Anemia',9,10,2),
(23,'john abdal','M','9567860124','Obesity',10,11,2),
(24,'issa abdallah','F','8949192301','Diabetes',9,12,2),
(25,'dane abdool','M','8166690211','Nephritis',8,13,2),
(26,'gary abel','M','9700479994','Anemia',12,14,2),
(27,'jacky abel','F','8934360866','Nephritis',11,15,2),
(28,'robert abel','M','9284503720','Diabetes',12,16,2),
(29,'simon abel','M','9727152289','Tuberculosis',7,15,2),
(30,'deryl abercrombie','M','8955822655','Tuberculosis',9,13,2),
(31,'gregory abercrombie','M','7899270320','Obesity',10,16,2),
(32,'jesse abercrombie','F','9439320852','Anemia',8,9,2),
(33,'justin abercrombie','M','9211180717','Diabetes',11,11,2),
(34,'william abercrombie','M','9855817360','Tuberculosis',7,12,2),
(35,'christopher abernathy','F','8885536634','Tuberculosis',12,10,2),
(36,'marc abernathy','M','7993467841','Tuberculosis',9,14,2),
(37,'scott abernathy','M','8794418380','Anemia',8,15,2),
(38,'jonathan abernethy','M','9356726793','Nephritis',10,9,2),
(39,'peter abitante','M','9598036110','Anemia',7,14,2),
(40,'joshua abler','F','9301018864','Diabetes',8,10,2),
(41,'anthony abney','M','8358191594','Obesity',15,17,3),
(42,'oliver abney','M','9598316349','Obesity',18,18,3),
(43,'moises abonza','M','9054083923','Nephritis',13,19,3),
(44,'juny abraham','F','8184712678','Obesity',14,20,3),
(45,'sean abraham','M','9183595933','Nephritis',16,21,3),
(46,'william iiabraham','M','9307199717','Anemia',20,22,3),
(47,'michael abramo','M','8278015782','Nephritis',19,23,3),
(48,'jeffrey abramowski','M','8809927061','Nephritis',17,17,3),
(49,'eugene abrams','F','9575160763','Obesity',19,18,3),
(50,'jack abrams','M','8689833696','Nephritis',13,19,3),
(51,'joe abrams','M','7969818077','Obesity',20,20,3),
(52,'lowell abrams','M','9898017211','Obesity',14,21,3),
(53,'samuel abrams','M','7971832038','Tuberculosis',15,22,3),
(54,'marty abramson','F','9876513377','Nephritis',18,23,3),
(55,'emilo abrea','M','9185595053','Diabetes',17,17,3),
(56,'alex abreu','F','8085843081','Anemia',16,18,3),
(57,'jose abreu','M','9628809391','Anemia',19,19,3),
(58,'julio abreu','F','8655153182','Tuberculosis',14,20,3),
(59,'samuel abreu','M','9054128319','Nephritis',13,21,3),
(60,'zachariah abreu','M','8336559307','Anemia',20,22,3);
