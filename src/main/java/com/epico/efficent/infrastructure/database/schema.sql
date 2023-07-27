CREATE DATABASE efficent
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

ALTER ROLE efficent
    SUPERUSER
    CREATEDB
    CREATEROLE;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE "security"."user"
(
    id       UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO "security"."user" (email, password)
VALUES ('admin@localhost', 'admin');

COMMIT;