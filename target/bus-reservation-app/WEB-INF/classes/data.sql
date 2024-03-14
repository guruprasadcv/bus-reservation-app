drop table if exists bus_details;

create table bus_details (
bus_id varchar(45) primary key,
department_name varchar(45),
source varchar(95),
destination varchar(95),
fare double,
available_date date,
seats_available int
);

insert into bus_details values("KSRTC101", "KSRTC", "Bengaluru", "Chitradurga", "290", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "29");
insert into bus_details values("KSRTC102", "KSRTC", "Bengaluru", "Davangere", "390", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "14");
insert into bus_details values("KSRTC103", "KSRTC", "Bengaluru", "Mysuru", "160", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "09");
insert into bus_details values("KSRTC104", "KSRTC", "Bengaluru", "Mangaluru", "810", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "19");
insert into bus_details values("KSRTC105", "KSRTC", "Bengaluru", "Belagavi", "1260", DATE_ADD(CURDATE(), INTERVAL 2 DAY), "23");
insert into bus_details values("KSRTC106", "KSRTC", "Bengaluru", "Chitradurga", "290", DATE_ADD(CURDATE(), INTERVAL 3 DAY), "10");
insert into bus_details values("KSRTC107", "KSRTC", "Bengaluru", "Chitradurga", "590", DATE_ADD(CURDATE(), INTERVAL 3 DAY), "32");
insert into bus_details values("KSRTC108", "KSRTC", "Bengaluru", "Chitradurga", "550", DATE_ADD(CURDATE(), INTERVAL 5 DAY), "06");
insert into bus_details values("KSRTC109", "KSRTC", "Bengaluru", "Mysuru", "310", DATE_ADD(CURDATE(), INTERVAL 4 DAY), "14");
insert into bus_details values("KSRTC110", "KSRTC", "Bengaluru", "Mangaluru", "705", DATE_ADD(CURDATE(), INTERVAL 2 DAY), "09");
insert into bus_details values("KSRTC111", "KSRTC", "Bengaluru", "Davanagere", "650", DATE_ADD(CURDATE(), INTERVAL 7 DAY), "31");
insert into bus_details values("KSRTC112", "KSRTC", "Mysuru", "Bengaluru", "350", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "2");
insert into bus_details values("KSRTC113", "KSRTC", "Mysuru", "Hassan", "850", DATE_ADD(CURDATE(), INTERVAL 2 DAY), "29");
insert into bus_details values("KSRTC114", "KSRTC", "Mysuru", "Mangaluru", "950", DATE_ADD(CURDATE(), INTERVAL 5 DAY), "11");
insert into bus_details values("KSRTC115", "KSRTC", "Chitradurga", "Davanagere", "85", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "13");
insert into bus_details values("KSRTC116", "KSRTC", "Chitradurga", "Bengaluru", "389", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "24");
insert into bus_details values("KSRTC117", "KSRTC", "Chitradurga", "Bengaluru", "540", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "01");
insert into bus_details values("KSRTC118", "KSRTC", "Chitradurga", "Davanagere", "65", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "21");
insert into bus_details values("KSRTC119", "KSRTC", "Davanagere", "Chitradurga", "90", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "31");
insert into bus_details values("KSRTC120", "KSRTC", "Davanagere", "Chitradurga", "85", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "30");
insert into bus_details values("KSRTC121", "KSRTC", "Davanagere", "Bengaluru", "650", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "29");
insert into bus_details values("KSRTC122", "KSRTC", "Davanagere", "Bengaluru", "410", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "15");
insert into bus_details values("KSRTC123", "KSRTC", "Davanagere", "Bengaluru", "609", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "11");
insert into bus_details values("KSRTC124", "KSRTC", "Chitradurga", "Davanagere", "70", DATE_ADD(CURDATE(), INTERVAL 0 DAY), "11");
insert into bus_details values("KSRTC125", "KSRTC", "Chitradurga", "Mysuru", "710", DATE_ADD(CURDATE(), INTERVAL 3 DAY), "27");
insert into bus_details values("KSRTC126", "KSRTC", "Dharwad", "Belagaavi", "415", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "21");
insert into bus_details values("KSRTC127", "KSRTC", "Hubballi", "Dharwad", "110", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "27");
insert into bus_details values("KSRTC128", "KSRTC", "Kalburgi", "Bengaluru", "959", DATE_ADD(CURDATE(), INTERVAL 2 DAY), "28");
insert into bus_details values("KSRTC129", "KSRTC", "Goa", "Bengaluru", "1650", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "17");
insert into bus_details values("KSRTC130", "KSRTC", "Bengaluru", "Hubballi", "950", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "07");
insert into bus_details values("KSRTC131", "KSRTC", "Bengaluru", "Hubballi", "750", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "37");
insert into bus_details values("KSRTC132", "KSRTC", "Bengaluru", "Hubballi", "1050", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "29");
insert into bus_details values("KSRTC133", "KSRTC", "Bengaluru", "Hubballi", "750", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "13");
insert into bus_details values("KSRTC134", "KSRTC", "Bengaluru", "Hubballi", "590", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "27");
insert into bus_details values("KSRTC135", "KSRTC", "Bengaluru", "Hubballi", "550", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "18");
insert into bus_details values("KSRTC136", "KSRTC", "Bengaluru", "Hubballi", "750", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "39");
insert into bus_details values("KSRTC137", "KSRTC", "Bengaluru", "Hubballi", "750", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "01");
insert into bus_details values("KSRTC138", "KSRTC", "Bengaluru", "Hubballi", "550", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "09");
insert into bus_details values("KSRTC139", "KSRTC", "Bengaluru", "Chitradurga", "550", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "37");
insert into bus_details values("KSRTC140", "KSRTC", "Bengaluru", "Chitradurga", "590", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "16");
insert into bus_details values("KSRTC141", "KSRTC", "Bengaluru", "Chitradurga", "650", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "27");
insert into bus_details values("KSRTC142", "KSRTC", "Bengaluru", "Chitradurga", "650", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "07");
insert into bus_details values("KSRTC143", "KSRTC", "Bengaluru", "Chitradurga", "650", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "18");
insert into bus_details values("KSRTC144", "KSRTC", "Bengaluru", "Chitradurga", "650", DATE_ADD(CURDATE(), INTERVAL 1 DAY), "31");