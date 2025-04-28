CREATE DATABASE solarpaneldb;

USE solarpaneldb;

CREATE TABLE solar_panel (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    panel_name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    capacity DOUBLE,
    status VARCHAR(50)
);

INSERT INTO solar_panel (panel_name, location, capacity, status)
VALUES
('Alpha Solar', 'Rooftop A1', 5.0, 'Active'),
('Beta Solar', 'Ground Field B2', 10.0, 'Inactive');
