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

CREATE TABLE country (
    id INT NOT NULL,
    code VARCHAR(2) DEFAULT NULL,
    name VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE state (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) DEFAULT NULL,
    country_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_country FOREIGN KEY (country_id) REFERENCES country (id)
) ENGINE=InnoDB AUTO_INCREMENT=1;


CREATE TABLE address (
  id INT NOT NULL AUTO_INCREMENT,
  block_number VARCHAR(64) DEFAULT NULL,
  street_name VARCHAR(128) DEFAULT NULL,
  unit_number VARCHAR(64) DEFAULT NULL,
  country VARCHAR(64) DEFAULT NULL,
  post_code INT DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE customer (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(128) DEFAULT NULL,
  last_name VARCHAR(64) DEFAULT NULL,
  email VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE orders (
  id INT NOT NULL AUTO_INCREMENT,
  order_tracking_number VARCHAR(255) DEFAULT NULL,
  total_price DECIMAL(19,2) DEFAULT NULL,
  total_quantity INT DEFAULT NULL,
  customer_id INT DEFAULT NULL,
  shipping_address_id INT DEFAULT NULL,
  status VARCHAR(128) DEFAULT NULL,
  date_created DATETIME(6) DEFAULT NULL,
  last_updated DATETIME(6) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_customer_id FOREIGN KEY (customer_id) REFERENCES customer (id),
  CONSTRAINT FK_shipping_address_id FOREIGN KEY (shipping_address_id) REFERENCES address (id)
) ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE order_item (
  id INT NOT NULL AUTO_INCREMENT,
  image_url VARCHAR(255) DEFAULT NULL,
  quantity INT DEFAULT NULL,
  unit_price DECIMAL(19,2) DEFAULT NULL,
  order_id INT DEFAULT NULL,
  product_id INT DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_order_id FOREIGN KEY (order_id) REFERENCES orders (id),
  CONSTRAINT FK_product_id FOREIGN KEY (product_id) REFERENCES product (id)
) ENGINE=InnoDB AUTO_INCREMENT=1;





INSERT INTO product_category(category_name) VALUES ('Apple');
INSERT INTO product_category(category_name) VALUES ('Samsung');
INSERT INTO product_category(category_name) VALUES ('HuaWei');
INSERT INTO product_category(category_name) VALUES ('Google');


INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Apple-iphone-1401', 'Apple iPhone 14 Pro MAX','Brand	Apple
Model name	iPhone 14 Pro Max
Operating system	iOS
Cellular technology	5G
Memory storage capacity	512 GB
Connectivity technology	Bluetooth, Wi-Fi
Colour	Space Black
Screen size	6.7 Inches
GSM, LTE',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Iphone14promax.png'
,1,99,1800,1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Apple-iphone-1402', 'Apple iPhone 14 Pro', 'Brand	Apple
Model name	iPhone 14 Pro
Operating system	iOS
Cellular technology	5G
Memory storage capacity	128 GB
Connectivity technology	Bluetooth, Wi-Fi
Colour	Silver
Screen size	6.1 Inches',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Iphone14pro.png'
,1,99,1600,1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Apple-iphone-1403', 'Apple iPhone 14 Plus', 'Brand	Apple
Model name	iPhone 14 Plus
Wireless service provider	Unlocked
Operating system	iOS
Cellular technology	5G
Memory storage capacity	512 GB
Connectivity technology	Lightning
Colour	Blue
Screen size	6.7 Inches
Wireless network technology	GSM, LTE',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Iphone14plus.png'
,1,99,1600,1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Apple-iphone-1404', 'Apple iPhone 14', 'Brand	Apple
Model name	iPhone 14
Operating system	iOS
Cellular technology	5G
Memory storage capacity	512 GB
Connectivity technology	Bluetooth, Wi-Fi, USB
Colour	Starlight
Screen size	6.1 Inches GSM, LTE',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Iphone14.png'
,1,99,1200,1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Apple-iphone-1301', 'Apple iPhone 13, 128GB, Midnight', 'Apple iPhone 13, 128GB, Midnight',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/iphone13.png'
,1,99,600,1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Apple-iphone-se2022','2022 Apple iPhone SE', 'Brand	Apple
Model name	iPhone SE
Operating system	iOS 15
Cellular technology	5G
Memory storage capacity	64 GB
Connectivity technology	Bluetooth, Wi-Fi, USB
Colour	Midnight
Screen size	4.7 Inches
Wireless network technology	GSM, LTE',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/iphoneSE.png'
,1,99,700,1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Apple-iphone-1201','Apple iPhone 12', 'Apple iPhone 12 (128 GB) - Green
6.1" Super Retina XDR display 
Emergency SOS 
Dual-camera system 12MP Main | Ultra Wide
TrueDepth front camera
Up to 19 hours video playback
A15 Bionic chip with 4-core GPU
Face ID  Superfast 5G cellularfootnote',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/iphone12.png'
,1,99,700,1, NOW());











INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Apple-airpods-0001','Apple AirPods (2nd Generation)', 'Brand	Apple
Model name	MV7N2ZA/A
Colour	White
Form factor	In Ear
Wireless communication technologies	Bluetooth
Fast Charging, Microphone Included, iOS Phone Control
AirPods, Charging Case, Lightning to USB-A Cable
Plastic
Lightning',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/AppleAirPods2ndGeneration.png'
,1,99,166,1, NOW());
INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Apple-airpods-0002','Apple AirPods Pro (2nd generation)', 'Brand	Apple
Model name	AirPods Pro
Colour	White
Form factor	In Ear
Connectivity technology	Wireless
Special features	Sweatproof	Plastic
lightning
Noise control	Active Noise Cancellation',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/AppleAirPodsPro2ndgeneration.png'
,1,99,316,1, NOW());
INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Apple-airpods-0003','Apple AirPods (3rd generation)', 'Brand	Apple
Model Name	AirPods
Color	White
Form Factor	In Ear
Connectivity Technology	Bluetooth',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/AppleAirPods3rdgeneration.png'
,1,99,271,1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Apple-airpods-0004','Apple AirPods Max - Silver', 'Brand	Apple
Model name	MGYJ3ZA/A
Colour	Silver
Form factor	Over Ear
Fast Charging, Microphone Included, iOS Phone Control
Included components	AirPods Max, Smart Case, Lightning to USB-C Cable
Material	Leather
lightning',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/AppleAirPodsMax.png'
,1,99,800,1, NOW());







INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Apple-watch-0001','Apple Watch Ultra', 'Brand	Apple
Style	Trail Loop
Colour	Black/Grey
Special features	GPS, Heart Rate Monitor
Shape	Square
Compatible devices	Smartphone
titanium
Band colour	Black',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/AppleWatchUltra.png'
,1,99,1200,1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Apple-watch-0002','Apple Watch Series 8', 'Brand	Apple
Model name	Series 8
Style	GPS + Cellular
Colour	Gold Stainless Steel: Gold Milanese Loop
Special features	GPS, Notifications, Heart Rate Monitor
Shape	Square
Compatible devices	Smartphone
Band material type	Stainless Steel',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/AppleWatchSeries8.png'
,1,99,1000,1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Apple-watch-0003','Apple Watch SE', 'Brand	Apple
Style	GPS + Cellular
Colour	Silver/White
Special features	GPS, Notifications, Heart Rate Monitor
Shape	Square
Compatible devices	Smartphone
Band material type	Fluoroelastomer
Band colour	White Sport',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/AppleWatchSE.png'
,1,99,453,1, NOW());



INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Apple-ipad-0001','2022 Apple 12.9-inch iPad Pro', '
Brand	Apple
Model name	MNXR3ZP/A
Memory storage capacity	256 GB
Screen size	12.9 Inches
Operating system	iPad OS
Colour	Space Grey
Installed RAM memory size	256 GB
Generation	6th Generation
Hardware interface	USB Type C, Thunderbolt',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/ipadpro2022.png'
,1,99,1866,1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Apple-ipad-0002','Apple iPad miniApple iPad mini', 'Brand	Apple
Model name	iPad mini
Memory storage capacity	64 GB
Screen size	8.3 Inches
Operating system	iPadOS
Colour	Pink
Installed RAM memory size	6 GB
Generation	6th Generation
Special features	Stereo Speakers',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/AppleiPadmini.png'
,1,99,978,1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Apple-ipad-0003','Apple iPad Air', 'Brand	Apple
Model name	MYFP2ZP/A
Memory storage capacity	64 GB
Screen size	10.9 Inches
Operating system	iPad OS
Colour	Rose Gold
Installed RAM memory size	8 GB
Generation	4th Generation
Hardware interface	USB Type C',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/AppleiPadAir.png'
,1,99,879,1, NOW());




INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Samsung-Galaxy-0001','Samsung Galaxy S22 Ultra', 'Brand SAMSUNG
Model name	Samsung Galaxy S22 Ultra
Operating system	Android
Cellular technology	5G
Memory storage capacity	256 GB
Colour	Burgundy
Screen size	6.8 Inches
Wireless network technology	GSM',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/SamsungGalaxyS22Ultra.png'
,1,99,1160,2, NOW());


INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Samsung-Galaxy-0002','SAMSUNG Galaxy, Z Flip4', 'Wireless charging is supported
Dynamic AMOLED 2x Screen
Powered by 3.2 GHz Octa Core Qualcomm 8+ Gen1 processor
8GB of RAM, and 128GB of storage
3700mAh Li-Ion battery
Camera description: Front
manufacturer: Samsung',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/SAMSUNGGalaxyZ%20Flip4.png'
,1,99,1110,2, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Samsung-Galaxy-0003','SAMSUNG Galaxy S23 Ultra', 'Brand	SAMSUNG
Model name	Samsung Galaxy S23 Ultra
Operating system	Android 13.0
Cellular technology	5G
Memory storage capacity	256 GB
Connectivity technology	Bluetooth, Wi-Fi, USB, NFC
Colour	Green
Screen size	6.8 Inches
Wireless network technology',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/SAMSUNGGalaxyS23Ultra.png'
,1,99,1555,2, NOW());


INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Samsung-Galaxy-0004','Samsung A53 5G', 'Brand	SAMSUNG
Model name	A53 5G
Operating system	Android 12.0
Cellular technology	LTE
Memory storage capacity	128 GB
Connectivity technology	Bluetooth, Wi-Fi, USB, NFC
Colour	Blue
Screen size	6.5 Inches
Wireless network technology	GSM, LTE',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Samsung%20A53%205G.png'
,1,99,550,2, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Samsung-Galaxy-0005','Samsung Galaxy A13 LTE', 'Brand	SAMSUNG
Model name	Samsung Galaxy A13
Operating system	Android 11.0
Cellular technology	LTE
Memory storage capacity	128 GB
Connectivity technology	Bluetooth, Wi-Fi, USB
Colour	Awesome Orange
Screen size	6.6 Inches
Wireless network technology	GSM',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Samsung%20Galaxy%20A13%20LTE.png'
,1,99,238,2, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Samsung-Galaxy-0006','Samsung Galaxy A14', 'Brand	SAMSUNG
Model name	Samsung Galaxy A14 5G
Operating system	Android 13.0
Cellular technology	5G
Memory storage capacity	128 GB
Connectivity technology	Wi-Fi
Colour	Black
Screen size	6.6 Inches',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Samsung%20Galaxy%20A14.png'
,1,99,275,2, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Samsung-Galaxy-0007','Samsung Galaxy A22 ', 'Samsung Galaxy A22 5G (SM-A226B/DS) Dual SIM 128GB/ 8GB RAM, 6.6” GSM Unlocked International Version - No Warranty - Mint',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Samsung%20Galaxy%20A22.png'
,1,99,290,2, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Samsung-watch-0001','SAMSUNG Galaxy Watch4', 'SAMSUNG Galaxy Watch4 44mm LTE Aluminium Black Samsung Galaxy Watch 4 LTE 44mm
Weight: 30.3g (44mm)
Battery: 361 mAh non removable',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/SAMSUNG%20Galaxy%20Watch4.png'
,1,99,260,2, NOW());


INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Samsung-watch-0002','SAMSUNG Galaxy Watch 5 BT', 'SAMSUNG Galaxy Watch 5 BT 40mm - Pink GoldBody temperature sensor
Scratch Resistant, Dust Proof
FDA approval for blood pressure monitoring
Support wireless charging',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/SAMSUNG%20Galaxy%20Watch%205.png'
,1,99,260,2, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Samsung-watch-0003','Samsung Galaxy Watch 5 Pro', 'SAMSUNG Galaxy Watch 5 Pro 45mm Bluetooth Smartwatch w/Body, Health, Fitness and Sleep Tracker, Improved Battery, Sapphire Crystal Glass, GPS Route Tracking, Titanium Frame, US Version, Black',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/SAMSUNG%20Galaxy%20Watch%205%20Pro.png'
,1,99,640,2, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Samsung-buds-0001','Samsung Galaxy Buds Pro', 'Samsung Galaxy Buds Pro Phantom Violet Batteries	1 Lithium Ion batteries required. (included)',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Samsung%20Galaxy%20Buds%20Pro.png'
,1,99,150,2, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Samsung-buds-0002','SAMSUNG SM-R180 Galaxy Buds', 'SAMSUNG SM-R180NZKAXSP Galaxy Buds Live Mystic Black Medium Sits softly inside the ear, giving you a fit for all-day comfort with less fatigue
12mm Speakers',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Galaxy%20Buds%20Live.png'
,1,99,66,2, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Samsung-tab-0001','Samsung Galaxy Tab S8 Ultra', 'Samsung SM-X906BZAJXSP Galaxy Tab S8 Ultra 5G, 12GB RAM, 256GB ROM, Graphite',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Galaxy%20Tab%20S8%20Ultra.png'
,1,99,1684,2, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Samsung-tab-0002','SAMSUNG Galaxy Tab S7', 'SAMSUNG SM-T733NLGAXSP Galaxy Tab S7 FE 12.4" Tablet, 4GB RAM, 64GB Storage, Light Green',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Galaxy%20Tab%20S7.png'
,1,99,1100,2, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Samsung-tab-0003','SAMSUNG Galaxy Tab A7', 'SAMSUNG SM-T505NZDEXSP Galaxy Tab A7 LTE, 10.4" TFT LCD, 3GB RAM, 64GB ROM, Qualcomm SM6115 Processors, Android, Gold',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Galaxy%20Tab%20A7.png'
,1,99,388,2, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Samsung-tab-0004','SAMSUNG Galaxy Tab A8', 'SAMSUNG SM-X205NZAEXSP Galaxy Tab A8 10.5" Tablet, 4GB RAM, 64GB Storage, Gray',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Galaxy%20Tab%20A8.png'
,1,99,388,2, NOW());


INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-phone-0021','Huawei P9 Lite', 'Huawei P9 Lite (GSM) Black 5.2-inch 16M colors, HiSilicon Kirin 650, Quad-core 2.0 GHz Cortex-A53 And quad-core 1.7 GHz Cortex-A53. 16 GB ROM, 2 GB RAM. Main Camera: 13 MP, f/2.0, autofocus, LED flash; Front Camera: 8 MP, f/2.0, LED flash.',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Huawei%20P9%20Lite.png'
,1,99,224,3, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-phone-0002','HUAWEI P50 Pocket', 'HUAWEI HW-BALI-L49C-PG P50 Pocket Premium Edition Dual SIM Smartphone, 12GB RAM, 512GB ROM, Premium Gold',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/HuaWei%20P50%20Pocket.png'
,1,99,2389,3, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-phone-0003','Huawei Nova 5T', 'Huawei Nova 5T (128GB, 6GB) 6.26" LCD, Kirin 980, 48MP Quad Camera, 22.5W Fast Charge, Dual SIM GSM Unlocked Global 4G LTE International Model YAL-L21...',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Huawei%20Nova%205T.png'
,1,99,573,3, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-phone-0004','Huawei Mate XS 2', 'Huawei Mate XS 2 Dual-SIM 512GB ROM + 8GB RAM (GSM Only | No CDMA) Factory Unlocked 4G/LTE Smartphone (White) - International Version',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Huawei%20Mate%20XS%202.png'
,1,99,3599,3, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-phone-0005','Huawei P20', 'Huawei P20 128GB Single-SIM Factory Unlocked 4G/LTE Smartphone (Black),(GSM Only, No CDMA)',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Huawei%20P20.png'
,1,99,339,3, NOW());
INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-phone-0006','Huawei Mate 20 Pro', 'Huawei Mate 20 Pro Smartphone Unlocked 6.39" 128G 6GB Black Google Store Preloaded',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/%20Huawei%20Mate%2020%20Pro.png'
,1,99,830,3, NOW());
INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-phone-0007','Huawei P30', 'Huawei P30 Single-SIM 128GB (GSM Only, No CDMA) Factory Unlocked 4G/LTE Smartphone - International Version (Midnight Black)',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/%20Huawei%20P30.png'
,1,99,977,3, NOW());


INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-phone-0008','Huawei Mate 50 Pro', 'Huawei Mate 50 Pro Dual-SIM 256GB ROM + 8GB RAM (Only GSM | No CDMA) Factory Unlocked 4G/LTE Smartphone (Silver) - International Version',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Huawei%20Mate%2050%20Pro.png'
,1,99,2599,3, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-phone-0009','HUAWEI Mate X3', 'HUAWEI Mate X3 4G (Dark Green) ALT-L29 512GB + 12GB RAM Unlocked EMUI 13.1 Smartphone',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/HUAWEI%20Mate%20X3.png'
,1,99,3999,3, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-phone-0010','Huawei P40 Lite', 'Huawei P40 Lite Dual SIM 4G JNY-LX2 128GB 6GB RAM International Version - Crush Green',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Huawei%20P40%20Lite.png'
,1,99,796,3, NOW());



INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-watch-0001','HUAWEI WATCH GT 3 PRO', '
HUAWEI WATCH GT 3 PRO 46mm LIGHT TITANIUM CASE
Colour Name:Black
Size Name:One Size
Style Name:Modern',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/HUAWEI%20WATCH%20GT%203%20PRO.png'
,1,99,418,3, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-watch-0002','HUAWEI LTN-B19-BRN', '
HUAWEI LTN-B19-BRN Classic Edition Smartwatch, Pebble Brown',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/HUAWEI%20LTN-B19-BRN.png'
,1,99,211,3, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-watch-0003','HUAWEI Watch GT 3', '
HUAWEI Watch GT 3 (46mm) GPS + Bluetooth Smartwatch (Black) - International Version',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/HUAWEI%20Watch%20GT%203.png'
,1,99,309,3, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-watch-0004','HUAWEI Watch GT 3 SE', '
HUAWEI Watch GT 3 SE Smartwatch, Sleek and Stylish, Science-Based Workouts, Sleep Monitoring, Two-Week Battery Life, Diverse Watch Face Designs, Compatible...',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/HUAWEI%20Watch%20GT%203%20SE.png'
,1,99,296,3, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-watch-0005','HUAWEI Watch GT 2 ', '
HUAWEI Watch GT 2 (42 mm) Smart Watch, 1.2 Inch AMOLED Display, 1 Week Battery Life, GPS, 3D Glass Screen, Real-time Heart Rate Monitoring, International...',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/HUAWEI%20Watch%20GT%202.png'
,1,99,549,3, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-watch-0006','HUAWEI WATCH Ultimate', 'HUAWEI WATCH Ultimate (Voyage Blue) 1.5" Bluetooth Smart Watch - HarmonyOS',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/HUAWEI%20WATCH%20Ultimate.png'
,1,99,1549,3, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-freebuds-0001','Huawei Freebuds Pro', 'Huawei Freebuds Pro Earbuds with Redefine Noise Cancellation, Ceramic White
Colour:Ceramic White',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Huawei%20Freebuds%20Pro.png'
,1,99,238,3, NOW());
INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-freebuds-0002','Huawei ROC-CU02', '
Huawei ROC-CU02 Freebuds Studio Headphones with Active Noise Cancellation, Black',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Huawei%20ROC-CU02%20Freebuds.png'
,1,99,268,3, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-freebuds-0003','Huawei FreeBuds 3', '
Huawei FreeBuds 3 Intelligent Noise Cancellation, True Wireless Earbuds
Colour:Black',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Huawei%20FreeBuds%203%20.png'
,1,99,160,3, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('HuaWei-freebuds-0004','Huawei Freebuds 4i', '
Huawei Freebuds 4i Earbuds, White
Colour:White',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Huawei%20Freebuds%204i.png'
,1,99,112,3, NOW());


INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Google-pixel-0001','Google Pixel 7 Pro', 'Google Pixel 7 Pro – Unlocked Android 5G Smartphone with 12 megapixel camera and 24-hour battery – Obsidian(128GB)',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Google%20Pixel%207%20Pro.png'
,1,99,1299,4, NOW());
INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Google-pixel-0002','Google Pixel 7', '
Google Pixel 7 – Unlocked Android 5G Smartphone with 12 megapixel camera and 24-hour battery – Snow
Size Name:128GB
Colour:Snow',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Google%20Pixel%207.png'
,1,99,938,4, NOW());
INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Google-pixel-0003','Google Pixel 6a', 'Google Pixel 6a – Unlocked Android 5G Smartphone with 12 megapixel camera and 24-hour battery – Chalk
Colour:Chalk
Size Name:Smartphone',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Google%20Pixel%206a.png'
,1,99,575,4, NOW());
INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Google-pixel-0004','Google Pixel 5', 'Google Pixel 5 128GB + 8GB RAM - 6 inch Android 5G Phone, Water Resistant (IPX8) - GSM Unlocked Smartphone (Sorta Sage) - UK Version',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Google%20Pixel%205.png'
,1,99,980,4, NOW());
INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Google-pixel-0005','Google Pixel 4a', 'Google Pixel 4a with 5G - Android Phone - New Unlocked Smartphone with Night Sight and Ultrawide Lens - Clearly White',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Google%20Pixel%204a.png'
,1,99,598,4, NOW());


INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Google-pixelbuds-0001','Google Pixel Buds A Series', 'Google GA02213-GB Pixel Buds A Series, Clearly White',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Google%20PixelBuds%20A%20Series.png'
,1,99,129,4, NOW());
INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('Google-pixelbuds-0002','Google Pixel Buds Pro', 'Google Pixel Buds Pro - Wireless Headphones - Bluetooth Headphones - Fog',
'https://guangzuibfcsf.sgp1.digitaloceanspaces.com/Google%20Pixel%20Buds%20Pro.png'
,1,99,324,4, NOW());
