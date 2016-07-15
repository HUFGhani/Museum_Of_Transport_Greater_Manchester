CREATE DATABASE IF NOT EXISTS GMTS;
use GMTS;

Drop Table if exists Vehicle_key_info;
Create Table Vehicle_key_info (
    Registration_number_ID Varchar(9) Not Null Primary Key,
    Vehicle_type Varchar(30) Not Null,
    Fleet_Number Varchar(15),
    Commission_year Varchar(4) Not Null,
    Decommission_year Year,
    Vehicle_image varchar(150),
	Video varchar(150)
    );

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('PTE 944C', 'Doube deck bus', '44', '1965');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year, Decommission_year, Vehicle_image)
Values ('LTC 774', 'Trolley bus', '80', '1950', '1966', 'http://www.gmts.co.uk/images/vehiclecollection/80.jpg');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('D63 N0F', 'Minibus', '63', '1986');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year, Decommission_year, Vehicle_image)
Values ('CWH 717', 'Tower Wagon', '2', '1948', '1976', 'http://www.gmts.co.uk/images/vehiclecollection/2.jpg');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year, Decommission_year, Vehicle_image)
Values ('JBN153', 'Double deck bus', '77', '1956', '1976', 'http://www.gmts.co.uk/images/vehiclecollection/77.jpg');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Commission_year)
Values ('LMA 284', 'Single deck bus','1949');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('REN 116','Double deck bus','116','1963');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('BEN 177','Double deck bus','177','1952');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Commission_year)
Values ('SDK 442', 'Single deck coach','1958');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year, Decommission_year, Vehicle_image)
Values ('D676 NN£','Minibus','1676','1987','1997', 'http://www.gmts.co.uk/images/vehiclecollection/1676.jpg');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('GNC 276N','Single deck bus','EX62','1975');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year, Decommission_year, Vehicle_image)
Values ('XVU 352M','Midibus','1722','1974','1986','http://www.gmts.co.uk/images/vehiclecollection/1722.jpg');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year, Decommission_year, Vehicle_image)
Values ('B65 PJA','Double deck bus','3065','1984','2005','http://www.gmts.co.uk/images/vehiclecollection/3065.jpg');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('ORJ 83W','Double deck bus','5083','1981');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year, Decommission_year, Vehicle_image)
Values ('C208 FVU','Double deck bus','5208','1986','2003','http://www.gmts.co.uk/images/vehiclecollection/5208.jpg');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('KJA 871F','Double deck bus','5871','1968');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year, Decommission_year, Vehicle_image)
Values ('A706 LNC','Double deck bus','8706','1984','1997','http://www.gmts.co.uk/images/vehiclecollection/8706.jpg');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('122 JTD','Double deck bus','27','1959');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('LSU 282','Recovery vehicle','Matador','1943');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('PTC 114C','Double deck bus','15','1965');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('FTB 11','Double deck bus','84','1941');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('Horse','Horse bus','L2','1890');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('Tram','Tram','173','1901');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('NNB 125','Single deck bus','25','1953');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('VR 5742','Single deck bus','28','1930');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('3655 NE','Single deck bus','55','1962');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('BND 874C','Single deck bus','74','1965');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year, Decommission_year, Vehicle_image)
Values ('ANB 851','Double deck bus','436','1934','1950','http://www.gmts.co.uk/images/vehiclecollection/436.jpg');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('AXJ 857','Chassis','526','1934');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year, Decommission_year, Vehicle_image)
Values ('HVM 901F','Double deck bus','1001','1968','1981','http://www.gmts.co.uk/images/vehiclecollection/1001.jpg');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year, Decommission_year, Vehicle_image)
Values ('JVU 755','Trolleybus','1250','1951','1963','http://www.gmts.co.uk/images/vehiclecollection/1250.jpg');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('JND 791','Double deck bus','2150','1949');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('JNA 467','Double deck bus','3166','1949');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year, Decommission_year, Vehicle_image)
Values ('JND 646','Double deck bus','3245','1951','1971','http://www.gmts.co.uk/images/vehiclecollection/3245.jpg');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('PND 460','Double deck bus','3460','1956');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year, Decommission_year, Vehicle_image)
Values ('TNA 496','Double deck bus','3496','1958','1975','http://www.gmts.co.uk/images/vehiclecollection/3496.jpg');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('TNA 520','Double deck bus','3520','1958');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year, Decommission_year, Vehicle_image)
Values ('UNB 629','Double deck bus','3629','1960','1972','http://www.gmts.co.uk/images/vehiclecollection/3629.jpg');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('4632 VM','Double deck bus','4632','1963');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Fleet_Number, Commission_year)
Values ('HVM 93','Tower wagon','A118','1947');

Insert into Vehicle_key_info (Registration_number_ID, Vehicle_type, Commission_year)
Values ('8860 VR','Double deck bus','1964');

Drop table if exists Additional_vehicle_info;
Create table Additional_vehicle_info (
	Additional_Vehicle_ID Int Not Null Primary Key,
    Body_Manufacturer varchar(40),
    Chassis_Manufacturer varchar(50),
    Chassis_model  Varchar(100),
    District varchar(60),
    Operator varchar(60),
    Registration_number_ID varchar(9) Not Null, Foreign key (Registration_number_ID) references Vehicle_key_info(Registration_number_ID)
    );

    Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (1, 'Leyland', 'Titan PD2/37', 'Tameside, Manchester', 'Ashton Corporation Passanger Transport', 'PTE 944C');

    Insert into Additional_vehicle_info (Additional_Vehicle_ID, Body_Manufacturer, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
	Values (2, 'Crossley', 'Crossley', 'Empire TDP42/2', 'Tameside', 'Ashton Corporation Passenger Transport', 'LTC 774');

    Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (3, 'Freight Rover', 'Sherpa 350', 'Manchester', 'The Bee Line Buzz Company', 'D63 N0F');

    Insert into Additional_vehicle_info values (4,'Tower Wagon','Leyland','Titan PD2/4','Bolton','Bolton Corporation Transport', 'CWH 717');

    Insert into Additional_vehicle_info values (5, 'Metro-Cammell','Leyland','Titan PD2/4','Bolton','Bolton Corporation Transport', 'JBN153');

	Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (6, 'Foden', 'PVSC6','Stockport','R Bullock', 'LMA 284');

    Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (7, 'Leyland','Atlantean PDR1/1','Bury, Bolton, Rochdale, Manchester, Salford','Bury Corporation Transport','REN 116');

    Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (8, 'AEC','Regent III 9613A','Bury, Bolton, Rochdale, Manchester, Salford', 'Bury Corporation Transport', 'BEN 177');

    Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (9, 'Leyland','Worldmaster RT3/2','Rochdale','Ellen Smith', 'SDK 442');

    Insert into Additional_vehicle_info values (10, 'MCW Integral','MCW','Metrorider MF151/3','Greater Manchester County','GM Buses','D676 NN£');

	Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, District, Operator, Registration_number_ID)
    Values (11, 'Seddon/ Lucas','Greater Manchester County','Greater Manchester Transport','GNC 276N');

    Insert into Additional_vehicle_info values (12,'Pennine','Seddon','Pennine IV-236','Greater Manchester County', 'Greater Manchester Transport','XVU 352M');

    Insert into Additional_vehicle_info values (13,'Northern Counties','Leyland','Olympian ONLXB/1R','Greater Manchester County','Greater Manchester Transport','B65 PJA');

	Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (14,'MCW','Metrobus DR102/21','Greater Manchester County','Greater Manchester Transport','ORJ 83W');

    Insert into Additional_vehicle_info values (15,'Northern Counties','MCW','Metrobus DR132/8','Greater Manchester Country','Greater Manchester Transport','C208 FVU');

	Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (16,'Leyland','Titan PD3/14','Greater Manchester County','Greater Manchester Transport','KJA 871F');

    Insert into Additional_vehicle_info values (17,'Northern Counties','Leyland','Atlantean AN68D/1R','Greater Manchester County','Greater Manchester Transport','A706 LNC');

	Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (18,'Guy','Arab IV','Wigan, Bolton, Bury, Salford','Lancashire United Transport','122 JTD');

	Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (19,'AEC','Matador 0853','Wigan, Bolton, Bury, Salford','Lancashire United Transport','LSU 282');

    Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (20,'AEC','Renown 3B3RA','Wigan','Leigh Corporation Motors','PTC 114C');

    Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (21,'Leyland','Titan TD7','Wigan','Leigh Corporation Motors','FTB 11');

	Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, District, Operator, Registration_number_ID)
    Values (22,'Manchester Carriage & Tramways Company','Manchester, Salford','Manchester Carriage & Tramways Company','Horse');

    Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, District, Operator, Registration_number_ID)
    Values (23,'Brush','Manchester','Manchester Corporation Tramways','Tram');

    Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (24,'Leyland','Royal Tiger PSU1/13','Manchester','Manchester Corporation Transport','NNB 125');

	Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (25,'Leyland','Tiger TS2','Manchester','Manchester Corporation Transport','VR 5742');

	Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (26,'Leyland','Tiger Club PSUC1/12','Manchester','Manchester Corporation Transport','3655 NE');

	Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (27,'Leyland','Panther Club','Manchester','Manchester Corporation Transport','BND 874C');

    Insert into Additional_vehicle_info values (28,'Crossley/ MCT Car Works','Crossley','Mancunian','Manchester','Manchester Corporation Transport','ANB 851');

    Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (29,'Leyland','Titan TD3','Manchester','Manchester Corporation Transport','AXJ 857');

    Insert into Additional_vehicle_info values (30,'Park Royal','Leyland','Atlantean PDR1/1','Manchester','Manchester Transport Corporation','HVM 901F');

    Insert into Additional_vehicle_info value (31,'Crossley','Crossley','Dominion TDD64/1','Manchester','Manchester Transport Corporation','JVU 755');

	Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (32,'Crossley','DD42/8S','Manchester','Manchester Corporation Transport','JND 791');

    Insert into Additional_vehicle_info values (33,'Metro-Cammell','Leyland','Titan PD2/3','Manchester','Manchester Corporation Transport','JND 646');

    Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (34,'Leyland','Titan PD2/12','Manchester','Manchester Corporation Transport','PND 460');

	Insert into Additional_vehicle_info values (35,'Burlingham','Leyland','Titan PD2/40','Manchester','Manchester Corporation Transport','TNA 496');

    Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (36,'Leyland','Titan PD2/34','Manchester','Manchester Corporation Transport','TNA 520');

	Insert into Additional_vehicle_info values (37,'Metro-Cammell, Orion','Leyland','Atlantean PDR1/1','Manchester','Manchester Corporation Transport','UNB 629');

    Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (38,'Daimier','CVG6K','Manchester','Manchester Corporation Transport','4632 VM');

    Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (39,'Thornycroft','Sturdy','Manchester','Manchester Corporation Transport','HVM 93');

    Insert into Additional_vehicle_info (Additional_Vehicle_ID, Chassis_Manufacturer, Chassis_model, District, Operator, Registration_number_ID)
    Values (40,'AEC','Regent V 2D3RA','Manchester, Tameside','A Mayne & Son','8860 VR');

Drop table if exists Customers_MTM;
Create Table Customers_MTM(
  Customer_ID Int Not Null Primary Key,
  Customer_First_name Varchar(30) Not Null,
  Customer_Last_name Varchar(30) Not Null,
  Customer_Email Text(50) Not Null
  );
