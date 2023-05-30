CREATE TABLE product_category (
id int NOT NULL AUTO_INCREMENT,
category_name VARCHAR(255) DEFAULT NULL,
CONSTRAINT PRIMARY KEY (id));
  
CREATE TABLE product (
id INT NOT NULL AUTO_INCREMENT,
sku VARCHAR(255) DEFAULT NULL,
`name` VARCHAR(255) DEFAULT NULL,
`description` VARCHAR(255) DEFAULT NULL,
unit_price Double DEFAULT NULL,
image_url VARCHAR(255) DEFAULT NULL,
`active` BIT DEFAULT 1,
units_in_stock INT DEFAULT NULL,
date_created DATE DEFAULT NULL,
last_updated DATE DEFAULT NULL,
category_id INT NOT NULL,
PRIMARY KEY (id),
CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES product_category (id)
);