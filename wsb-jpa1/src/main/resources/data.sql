--Address
insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'xx', 'yy', 'city', '62-030');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (2, 'aa', 'bb', 'city', '62-030');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (3, 'cc', 'dd', 'city', '62-010');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (4, 'ee', 'ff', 'city', '61-030');
insert into address (id, address_line1, address_line2, city, postal_code)          
            values (5, 'gg', 'hh', 'city', '62-020');

--Patient
insert into patient (id, first_name, last_name, address_id, date_of_birth, patient_number, telephone_number)
            values (1, 'John', 'Doe', 1, '1990-01-01', 1, '123456789');
insert into patient (id, first_name, last_name, address_id, date_of_birth, patient_number, telephone_number)
            values (2, 'Jane', 'Doo', 2, '1992-06-03', 2, '987654321');
insert into patient (id, first_name, last_name, address_id, date_of_birth, patient_number, telephone_number)
            values (3, 'Jack', 'Done', 3, '1995-12-31', 3, '123455789');
insert into patient (id, first_name, last_name, address_id, date_of_birth, patient_number, telephone_number)
            values (4, 'Jill', 'Dor', 4, '1998-02-14', 4, '987654121');
insert into patient (id, first_name, last_name, address_id, date_of_birth, patient_number, telephone_number, still_alive)
            values (5, 'Jim', 'Doe', 5, '2000-03-21', 5, '123456712', false);

--Doctor
insert into doctor (id, first_name, last_name, address_id, specialization, doctor_number, telephone_number)
            values (1, 'Jane', 'Doe', 1, 'SURGEON', 1, '987654321');
insert into doctor (id, first_name, last_name, address_id, specialization, doctor_number, telephone_number)
            values (2, 'John', 'Doe', 2, 'GP', 2, '123456789');
insert into doctor (id, first_name, last_name, address_id, specialization, doctor_number, telephone_number)
            values (3, 'Jack', 'Doe', 3, 'GP', 3, '123455789');
insert into doctor (id, first_name, last_name, address_id, specialization, doctor_number, telephone_number)
            values (4, 'Jill', 'Doe', 4, 'OCULIST', 4, '987654121');
insert into doctor (id, first_name, last_name, address_id, specialization, doctor_number, telephone_number)
            values (5, 'Jim', 'Doe', 5, 'DERMATOLOGIST', 5, '123456712');

--Visit
insert into visit (id, description, time, patient_id, doctor_id) values (1, 'First visit', '2018-01-01 12:00:00', 1, 1);
insert into visit (id, description, time, patient_id, doctor_id) values (2, 'Second visit', '2018-02-02 12:00:00', 2, 2);
insert into visit (id, description, time, patient_id, doctor_id) values (3, 'Third visit', '2019-03-03 16:00:00', 3, 3);
insert into visit (id, description, time, patient_id, doctor_id) values (4, 'Fourth visit', '2019-04-04 16:00:00', 4, 4);
insert into visit (id, description, time, patient_id, doctor_id) values (5, 'Fifth visit', '2019-05-05 16:00:00', 5, 5);
insert into visit (id, description, time, patient_id, doctor_id) values (6, 'Sixth visit', '2019-06-06 16:00:00', 1, 2);
insert into visit (id, description, time, patient_id, doctor_id) values (7, 'Seventh visit', '2019-07-07 16:00:00', 2, 3);
insert into visit (id, description, time, patient_id, doctor_id) values (8, 'Eighth visit', '2019-08-08 16:00:00', 3, 4);
insert into visit (id, description, time, patient_id, doctor_id) values (9, 'Ninth visit', '2019-09-09 16:00:00', 4, 5);
insert into visit (id, description, time, patient_id, doctor_id) values (10, 'Tenth visit', '2019-10-10 16:00:00', 5, 1);
insert into visit (id, description, time, patient_id, doctor_id) values (11, 'Eleventh visit', '2019-11-11 11:00:00', 1, 2);
insert into visit (id, description, time, patient_id, doctor_id) values (12, 'Twelfth visit', '2019-12-12 11:00:00', 2, 3);
insert into visit (id, description, time, patient_id, doctor_id) values (13, 'Thirteenth visit', '2020-01-01 11:00:00', 3, 4);
insert into visit (id, description, time, patient_id, doctor_id) values (14, 'Fourteenth visit', '2020-02-02 11:00:00', 4, 5);
insert into visit (id, description, time, patient_id, doctor_id) values (15, 'Fifteenth visit', '2020-03-03 11:00:00', 5, 1);


--MedicalTreatment
insert into medical_treatment (id, description, type) values (1, 'First treatment', 'RTG');
insert into medical_treatment (id, description, type) values (2, 'Second treatment', 'EKG');
insert into medical_treatment (id, description, type) values (3, 'Third treatment', 'RTG');