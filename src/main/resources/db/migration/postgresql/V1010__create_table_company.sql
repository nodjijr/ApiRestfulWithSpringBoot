

CREATE TABLE company (
	id uuid NOT NULL,
	description varchar(235) NOT NULL,
	code varchar(15) NOT NULL,
	date_created timestamp NOT NULL,	
	date_updated timestamp NOT NULL,		
	CONSTRAINT pk_company_id PRIMARY KEY (id)
);


