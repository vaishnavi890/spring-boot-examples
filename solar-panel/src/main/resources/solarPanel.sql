CREATE DATABASE solarpaneldb;

USE solarpaneldb;

CREATE TABLE solar_panel (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    panel_name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    capacity DOUBLE,
    status VARCHAR(50)
);
