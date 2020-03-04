DROP TABLE IF EXISTS flights;
CREATE TABLE flights (
  flight_id   INTEGER NOT NULL AUTO_INCREMENT,
  flight VARCHAR(45) NOT NULL,
  date_flight DATE,
  PRIMARY KEY (flight_id)
);
DROP TABLE IF EXISTS passengers;
CREATE TABLE passengers (
  passenger_id    INTEGER NOT NULL AUTO_INCREMENT,
  firstname VARCHAR(45) NOT NULL,
  lastname VARCHAR(45) NOT NULL,
  flight_id   INTEGER NOT NULL,
  PRIMARY KEY (passenger_id),
  CONSTRAINT passengers_to_flight_schedule_fk
	FOREIGN KEY (flight_id)
	REFERENCES passengers (flight_id)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
);
