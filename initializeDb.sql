
connect 'jdbc:derby:RentalData;create=true;user=student; password=student';

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
	AvailableDate DATE,
	TenantID VARCHAR(10),
	Description VARCHAR (255),
	 PRIMARY KEY (PropertyID),
	 FOREIGN KEY (TenantID) REFERENCES Tenants(TenantID)
);
