DROP TABLE IF EXISTS flights;
CREATE TABLE flights (
  flight_id INTEGER NOT NULL AUTO_INCREMENT,
  direction VARCHAR(45) NOT NULL,
  date_flight DATE,
  PRIMARY KEY (flight_id)
);
DROP TABLE IF EXISTS passengers;
CREATE TABLE passengers (
  passenger_id INTEGER NOT NULL AUTO_INCREMENT,
  firstname VARCHAR(45) NOT NULL,
  lastname VARCHAR(45) NOT NULL,
  flight_id INTEGER NOT NULL,
  PRIMARY KEY (passenger_id),
 	FOREIGN KEY (flight_id)
	REFERENCES flights (flight_id)

);
