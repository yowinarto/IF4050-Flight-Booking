CREATE DATABASE IF NOT EXISTS flight_booking;

USE flight_booking;

DROP TABLE IF EXISTS passenger;
CREATE TABLE passenger(
	id INT NOT NULL AUTO_INCREMENT,
	fullname VARCHAR(100),
	phone_number VARCHAR(20),
	email VARCHAR(100),
	birthdate DATE,
	gender VARCHAR(1),
	PRIMARY KEY (id)
);
DELETE FROM passenger;
INSERT INTO 
	passenger (fullname, phone_number, email, birthdate, gender)
VALUES 
	('jerry', '085823290000', 'jerry@gmail.com', '1997-05-14', 1),
	('donna', '085823294440', 'donna@gmail.com', '1993-05-14', 0);

DROP TABLE IF EXISTS flight;
CREATE TABLE flight(
	id INT NOT NULL AUTO_INCREMENT,
	date_flight DATE NOT NULL,
	class varchar(10) NOT NULL,
	origin varchar(100) NOT NULL,
	destination varchar(100) NOT NULL,
	time_flight TIME NOT NULL,
	price FLOAT NOT NULL,
	capacity INT NOT NULL
	PRIMARY KEY (id)
);
DELETE FROM flight;
INSERT INTO 
	flight (date_flight, class, origin, destination, time_flight, price, capacity)
VALUES 
	(NOW(), 'economy', 'BDO', 'JOG', '16:25', 900000, 200),
	(NOW(), 'economy', 'BDO', 'DPS', '14:25', 970000, 200);

DROP TABLE IF EXISTS promotion;
CREATE TABLE promotion(
	promo_code VARCHAR(20) NOT NULL,
	available_from DATE NOT NULL,
	available_until DATE NOT NULL,
	discount FLOAT NOT NULL,
	PRIMARY KEY (promo_code)
);
DELETE FROM promotion;
INSERT INTO 
	promotion (promo_code, available_from, available_until, discount)
VALUES 
	('BAKULBDG', NOW(), '2018-12-31', 15),
	('BAKULBDGOVO', NOW(), '2018-12-31', 20);

DROP TABLE IF EXISTS booking;
CREATE TABLE booking(
	id INT NOT NULL AUTO_INCREMENT,
	passenger_id INT NOT NULL REFERENCES passenger(id),
	num_of_passenger INT NOT NULL,
	total_price FLOAT NOT NULL,
	flight_id INT NOT NULL REFERENCES flight(id),
	PRIMARY KEY (id)
);
DELETE FROM booking;
INSERT INTO 
	booking (passenger_id, num_of_passenger, total_price, flight_id)
VALUES 
	(1, 2, 180000, 1),
	(2, 1, 970000, 2);

DROP TABLE IF EXISTS ticket;
CREATE TABLE ticket(
	ticket_code VARCHAR (20) NOT NULL,
	passenger_id INT NOT NULL REFERENCES passenger(id),
	booking_id INT NOT NULL REFERENCES booking(id),
	PRIMARY KEY (ticket_code)
);
DELETE FROM ticket;
INSERT INTO 
	ticket (ticket_code, passenger_id, booking_id)
VALUES 
	('g1bb3r15h1a1awdww', 1, 1),
	('1a2s2dj39fjorefem', 2, 2);
