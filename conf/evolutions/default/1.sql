# --- !Ups

-- create table "suppliers" ("id" BIGSERIAL NOT NULL PRIMARY KEY,"name" VARCHAR(254) NOT NULL,"desc" VARCHAR(254) NOT NULL);

Christoph Knabe (knabe@beuth-hochschule.de)
create table "users" (
  "id" BIGSERIAL NOT NULL PRIMARY KEY,
  "login" VARCHAR(254) NOT NULL UNIQUE --unique username
);

create table "users" (
  "id" BIGSERIAL NOT NULL PRIMARY KEY,
  "login" VARCHAR(254) NOT NULL UNIQUE --unique username
);

# --- !Downs
;
drop table "suppliers";