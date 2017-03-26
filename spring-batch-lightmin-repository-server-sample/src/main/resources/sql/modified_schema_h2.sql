CREATE TABLE job_configuration (
  job_configuration_id   NUMERIC IDENTITY PRIMARY KEY NOT NULL,
  application_name       VARCHAR(255)                 NOT NULL,
  job_name               VARCHAR(255)                 NOT NULL,
  job_incrementer        VARCHAR(255),
  job_configuration_type INT                          NOT NULL
);

CREATE TABLE configuration_value (
  id                   NUMERIC IDENTITY PRIMARY KEY NOT NULL,
  job_configuration_id NUMERIC                      NOT NULL,
  value_key            VARCHAR(255)                 NOT NULL,
  configuration_value  VARCHAR(255),
  FOREIGN KEY (job_configuration_id) REFERENCES job_configuration (job_configuration_id)
);


CREATE TABLE configuration_parameter (
  id                   NUMERIC IDENTITY PRIMARY KEY NOT NULL,
  job_configuration_id NUMERIC                      NOT NULL,
  parameter_name       VARCHAR(255)                 NOT NULL,
  parameter_value      VARCHAR(255)                 NOT NULL,
  parameter_type       INT                          NOT NULL,
  FOREIGN KEY (job_configuration_id) REFERENCES job_configuration (job_configuration_id)
);

