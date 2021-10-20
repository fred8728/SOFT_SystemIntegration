DROP TABLE IF EXISTS EXAM;

CREATE TABLE EXAM (
                      sid INT NOT NULL PRIMARY KEY,
                      course ENUM('SI', 'TEST', 'DLS'),
                      examType ENUM('ORAL', 'WRITTEN'),
                      examDate DATE NOT NULL
);