create database airline;
use airline;

CREATE TABLE flights (
    id INT NOT NULL,
    airline VARCHAR(16),
    flight_no VARCHAR(16),
    CONSTRAINT flight_id PRIMARY KEY (id)
);

CREATE TABLE flight_routes (
    id INT NOT NULL,
    departure_location VARCHAR(16),
    arrival_location VARCHAR(16),
    departs_on DATETIME,
    arrive_on DATETIME,
    flight_d INT NOT NULL,
    fare_id INT NOT NULL,
    CONSTRAINT flight_routes_id PRIMARY KEY (id),
    CONSTRAINT flight_id_fk FOREIGN KEY (flight_d)
        REFERENCES flights (id),
    CONSTRAINT fare_id_fk FOREIGN KEY (fare_id)
        REFERENCES flight_fare (id)
);

CREATE TABLE flight_fare (
    id INT NOT NULL,
    class VARCHAR(16) NOT NULL,
    fare INT NOT NULL,
    is_refundable BOOL,
    CONSTRAINT flight_fare_id PRIMARY KEY (id)
);
