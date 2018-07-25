CREATE TABLE CAMEL_TEST (
  ID BIGINT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  MSG VARCHAR(10240),
  STATUS CHAR(4) DEFAULT 'NEW',
  CREATE_TS TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);