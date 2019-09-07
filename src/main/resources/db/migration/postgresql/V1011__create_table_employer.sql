

CREATE TABLE employer (
	id uuid NOT NULL,
	company_id uuid NOT NULL,
	name varchar(235) NOT NULL,
	email varchar(235) NOT NULL,
	pass varchar(235) NOT NULL,
	code varchar(15) NOT NULL,
	hour_value numeric(15,2) NOT NULL,
	hour_worked numeric(15,2) NOT NULL,
	hour_lunch numeric(15,2) NOT NULL,
	profile varchar(30) NOT NULL,
	date_created timestamp NOT NULL,	
	date_updated timestamp NOT NULL,		
	CONSTRAINT pk_employer_id PRIMARY KEY (id)
);


