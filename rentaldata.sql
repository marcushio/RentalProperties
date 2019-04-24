
connect 'jdbc:derby:RentalData;create=true;user=student; password=student';

DROP TABLE Properties;
CREATE TABLE Properties
(
    PropertyID VARCHAR(12) NOT NULL, 
	Address VARCHAR (80) NOT NULL, 
    Bedrooms INT NOT NULL, 
	Bathrooms FLOAT (2) NOT NULL, 
	AdditionalInfo VARCHAR (80), 
	RentAmount FLOAT (2) NOT NULL, 
	RentType VARCHAR (10) NOT NULL, 
	Available VARCHAR (4) NOT NULL, 
	AvailableDate DATE NOT NULL,
	TenantId VARCHAR(12) NOT NULL,
	Description VARCHAR (255),
	 PRIMARY KEY (PropertyID)
);

INSERT INTO Properties (PropertyID, Address, Bedrooms,Bathrooms,AdditionalInfo , 
	RentAmount ,RentType ,Available ,AvailableDate, TenantId ,Description )
	VALUES ('SABQ111','12 Cactus Dr', 2, 1.5, 'w/d included', 800.00, 'monthly', 'yes', '2019-05-05', '11111',
	 'A nice small family residence'),
	('SABQ112','508 Superstition Dr', 3, 2, 'big yard', 1200.00, 'monthly', 'yes', '2019-05-05', '323232',
	 'Near golf course');

DROP TABLE Tenants;

CREATE TABLE Tenants
(
	TenantID VARCHAR(10) NOT NULL PRIMARY KEY,
	FirstName VARCHAR(45) NOT NULL,
	LastName VARCHAR(45) NOT NULL,
	PhoneNumber CHAR(12),
	RentPaid DATE,
	Email VARCHAR(60)
);

INSERT INTO Tenants (TenantID, FirstName, LastName, PhoneNumber, RentPaid, Email)
	VALUES ('111', 'Frank', 'Delano', '505-555-5555', '2019-04-04', 'fd@gmail.com'),
			('112', 'Mary', 'Xao', '575-444-4444', '2019-09-09', 'xaoxao@gmail.com');


