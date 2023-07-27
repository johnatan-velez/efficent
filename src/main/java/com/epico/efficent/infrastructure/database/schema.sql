ALTER ROLE efficent
    SUPERUSER
    CREATEDB
    CREATEROLE;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE "security"."user" (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO "security"."user" (email, password) VALUES ('admin@localhost', 'admin');

COMMIT;