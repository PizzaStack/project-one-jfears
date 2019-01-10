create table employee(
	empid integer PRIMARY KEY,
	empusername varchar(20),
	emppassword varchar(20),
	empfirstname varchar(50),
	emplastname varchar (50),
	UNIQUE(empid, empusername)
);

create table manager(
	manid integer PRIMARY KEY,
	manusername varchar(20),
	manpassword varchar(20),
	UNIQUE(manid, manusername)
);

create table rcp(
	rcpid integer PRIMARY KEY,
	rcpimage bytea
);

create table requests(
	requestid integer PRIMARY KEY,
	empid integer,
	manid integer,
	rcpid integer,
	FOREIGN KEY(empid) REFERENCES employee(empid),
	FOREIGN KEY(manid) REFERENCES manager(manid),
	FOREIGN KEY(rcpid) REFERENCES rcp(rcpid)
);