<<<<<<< HEAD
USE milestone_db;

SELECT id, first_name, last_name, email, phone_number username, password FROM users;
=======
-- Create database and select it
CREATE DATABASE IF NOT EXISTS milestone_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE milestone_db;

DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id           BIGINT NOT NULL AUTO_INCREMENT,
  first_name   VARCHAR(32)  NOT NULL,
  last_name    VARCHAR(32)  NOT NULL,
  email        VARCHAR(100) NOT NULL,
  phone_number VARCHAR(15)  NOT NULL,
  username     VARCHAR(32)  NOT NULL,
  password     VARCHAR(64)  NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uk_users_username (username),
  UNIQUE KEY uk_users_email (email)
) ENGINE=InnoDB;

CREATE TABLE books (
  id        BIGINT NOT NULL AUTO_INCREMENT,
  title     VARCHAR(255)  NOT NULL,
  author    VARCHAR(255)  NOT NULL,
  genre     VARCHAR(100),
  available TINYINT(1)    NOT NULL DEFAULT 1,
  PRIMARY KEY (id)
) ENGINE=InnoDB;

-- Optional: sample data for quick testing
INSERT INTO users (first_name, last_name, email, phone_number, username, password)
VALUES
('Test', 'User', 'testuser@example.com', '5551234567', 'admin', 'password');

INSERT INTO books (title, author, genre, available)
VALUES
('Effective Java', 'Joshua Bloch', 'Programming', 1),
('Clean Code', 'Robert C. Martin', 'Programming', 1);
>>>>>>> 89d1c399dd32c88b3f4aaa71c221fd83192f6e53
