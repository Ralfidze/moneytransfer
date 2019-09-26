DROP TABLE IF EXISTS Account;

CREATE TABLE Account (AccountId LONG PRIMARY KEY AUTO_INCREMENT NOT NULL,
UserName VARCHAR(100),
Balance DECIMAL(19,4),
CurrencyCode VARCHAR(5)
);

CREATE UNIQUE INDEX idx_acc on Account(UserName,CurrencyCode);

INSERT INTO Account (UserName,Balance,CurrencyCode) VALUES ('yangluo',100.0000,'USD');
INSERT INTO Account (UserName,Balance,CurrencyCode) VALUES ('qinfran',200.0000,'USD');
INSERT INTO Account (UserName,Balance,CurrencyCode) VALUES ('yangluo',500.0000,'EUR');
INSERT INTO Account (UserName,Balance,CurrencyCode) VALUES ('qinfran',500.0000,'EUR');
INSERT INTO Account (UserName,Balance,CurrencyCode) VALUES ('yangluo',500.0000,'GBP');
INSERT INTO Account (UserName,Balance,CurrencyCode) VALUES ('qinfran',500.0000,'GBP');