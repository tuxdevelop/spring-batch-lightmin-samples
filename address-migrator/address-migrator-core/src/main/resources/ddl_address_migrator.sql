CREATE TABLE  batch_task_address(
  batch_task_id IDENTITY PRIMARY KEY NOT NULL,
  processing_state NUMERIC,
  street VARCHAR(255),
  house_number VARCHAR(255),
  zip_code VARCHAR(255),
  city VARCHAR(255)
);

CREATE TABLE address(
	id NUMERIC NOT NULL  PRIMARY KEY,
  street_line VARCHAR(255),
  city_line VARCHAR(255)
);

