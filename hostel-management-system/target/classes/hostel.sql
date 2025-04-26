-- Database: hostel_db
CREATE DATABASE IF NOT EXISTS hostel_db;
USE hostel_db;

-- Room Table
CREATE TABLE rooms (
    id BIGINT NOT NULL AUTO_INCREMENT,
    room_number VARCHAR(50) NOT NULL,
    type VARCHAR(50),
    occupied BOOLEAN,
    PRIMARY KEY (id)
);

-- Student Table (If needed later)
CREATE TABLE students (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    room_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (room_id) REFERENCES rooms(id)
);
