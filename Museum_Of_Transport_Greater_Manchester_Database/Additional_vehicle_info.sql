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
    
    
    