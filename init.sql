create database if not exists demo;
drop table if exists demo.backend;
CREATE TABLE if not exists demo.backend(
    id VARCHAR(50) PRIMARY KEY,
    value VARCHAR(50) NOT NULL,
    expiry_at BIGINT NULL
);

-- mysql cron to delete old data
CREATE EVENT delete_old_data
ON SCHEDULE EVERY 1 DAY
DO
  DELETE FROM your_table WHERE expiry_at < UNIX_TIMESTAMP() limit 5000
