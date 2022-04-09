create database airline;
use airline;


--
-- Data for table 'flights'
--
CREATE TABLE flights (
    id INT NOT NULL AUTO_INCREMENT,
    airline VARCHAR(16),
    flight_no VARCHAR(16),
    CONSTRAINT flight_id PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table 'flight_routes'
--
CREATE TABLE flight_routes (
    id INT(11) NOT NULL AUTO_INCREMENT,
    departure_location VARCHAR(16) NOT NULL,
    arrival_location VARCHAR(16) NOT NULL,
    departs_on DATETIME NOT NULL,
    arrive_on DATETIME NOT NULL,
    flight_d INT(11) NOT NULL,
    fare_id INT(11) NOT NULL,
    CONSTRAINT flight_routes_id PRIMARY KEY (id),
    CONSTRAINT flight_id_fk FOREIGN KEY (flight_d)
        REFERENCES flights (id),
    CONSTRAINT fare_id_fk FOREIGN KEY (fare_id)
        REFERENCES flight_fare (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table 'flight_fare'
--
CREATE TABLE flight_fare (
    id INT(5) NOT NULL AUTO_INCREMENT,
    class VARCHAR(16) NOT NULL,
    fare INT(8) NOT NULL,
    is_refundable BOOL,
    CONSTRAINT flight_fare_id PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
