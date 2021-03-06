CREATE TABLE ITEM(
    ID NUMBER PRIMARY KEY,
    NAME NVARCHAR2(50),
    DATE_CREATED TIMESTAMP,
    DATE_LAST_UPDATE TIMESTAMP,
    DESCRIPTION CLOB
);

CREATE SEQUENCE ITEM_SEQ MINVALUE 1 MAXVALUE 10000 START WITH 1 INCREMENT BY 1;