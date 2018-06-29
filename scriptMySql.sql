CREATE database scsvDB;

use scsvDb;

CREATE TABLE animal (
id BIGINT(10) AUTO_INCREMENT,
lbName VARCHAR(255) NOT NULL UNIQUE,
origin VARCHAR(255),
pawsQuantity SmallInt,
class VARCHAR(255),
reproduction VARCHAR(255) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE vegetable (
id BIGINT(10) AUTO_INCREMENT,
lbName VARCHAR(255) NOT NULL UNIQUE,
origin VARCHAR(255),
size VARCHAR(255),
fruitful bool,
reproduction VARCHAR(255) NOT NULL,
PRIMARY KEY (id)
);

