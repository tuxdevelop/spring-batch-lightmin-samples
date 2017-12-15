INSERT INTO BATCH_JOB_CONFIGURATION
(job_name, application_name, job_incrementer, job_configuration_type)
VALUES (
  'addressMigrationJob',
  'address-migrator',
  'DATE_INCREMENTER',
  1
);

INSERT INTO BATCH_JOB_CONFIGURATION
(job_name, application_name, job_incrementer, job_configuration_type)
VALUES (
  'UnknownJob',
  'address-migrator',
  'DATE_INCREMENTER',
  1
);

INSERT INTO BATCH_JOB_CONFIGURATION
(job_name, application_name, job_incrementer, job_configuration_type)
VALUES (
  'addressPrinterJob',
  'address-migrator',
  'NONE',
  1
);

INSERT INTO BATCH_JOB_CONFIGURATION
(job_name, application_name, job_incrementer, job_configuration_type)
VALUES (
  'addressImportJob',
  'address-migrator',
  'DATE_INCREMENTER',
  2
);

INSERT INTO BATCH_JOB_CONFIGURATION
(job_name, application_name, job_incrementer, job_configuration_type)
VALUES (
  'addressLogJob',
  'address-migrator',
  'DATE_INCREMENTER',
  2
);


-- scheduler configuration values 1

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  1,
  'scheduler_type',
  2
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  1,
  'initial_delay',
  10
);


INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  1,
  'fixed_delay',
  60000
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  1,
  'task_executor_type',
  1
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  1,
  'bean_name',
  'addressMigrationJobSYNCHRONOUSLY1'
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  1,
  'status',
  'RUNNING'
);

-- scheduler configuration values 2

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  2,
  'scheduler_type',
  2
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  2,
  'initial_delay',
  10
);


INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  2,
  'fixed_delay',
  10
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  2,
  'task_executor_type',
  1
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  2,
  'bean_name',
  'UnknownJobSYNCHRONOUSLY1'
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  2,
  'status',
  'RUNNING'
);

-- scheduler configuration values 2

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  3,
  'scheduler_type',
  2
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  3,
  'initial_delay',
  10
);


INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  3,
  'fixed_delay',
  6000
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  3,
  'task_executor_type',
  1
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  3,
  'bean_name',
  'addressPrinterJobSYNCHRONOUSLY1'
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  3,
  'status',
  'RUNNING'
);

-- listener configuration values 4

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  4,
  'listener_type',
  1
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  4,
  'source_folder',
  'input'
);


INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  4,
  'file_pattern',
  '*.txt'
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  4,
  'poller_period',
  600
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  4,
  'task_executor_type',
  1
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  4,
  'bean_name',
  'addressMigrationJobSYNCHRONOUSLY4'
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  4,
  'status',
  'ACTIVE'
);


-- listener configuration values 5

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  5,
  'listener_type',
  1
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  5,
  'source_folder',
  'input'
);


INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  5,
  'file_pattern',
  '*.txt'
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  5,
  'poller_period',
  1000
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  5,
  'task_executor_type',
  1
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  5,
  'bean_name',
  'addressMigrationJobSYNCHRONOUSLY5'
);

INSERT INTO BATCH_JOB_CONFIGURATION_VALUE
(job_configuration_id, value_key, configuration_value)
VALUES (
  5,
  'status',
  'ACTIVE'
);

