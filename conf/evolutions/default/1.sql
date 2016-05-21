# --- !Ups

-- create table "suppliers" ("id" BIGSERIAL NOT NULL PRIMARY KEY,"name" VARCHAR(254) NOT NULL,"desc" VARCHAR(254) NOT NULL);

create table "users" (
  "id" BIGSERIAL NOT NULL PRIMARY KEY,
  "login" VARCHAR(254) NOT NULL UNIQUE --unique username
);

create table "parking_slots" (
  "id" BIGSERIAL NOT NULL PRIMARY KEY,
  "lat" DOUBLE NOT NULL,
  "lon" DOUBLE NOT NULL,
  "user_id" INT REFERENCES "users"("id"),
  "free_from" TIMESTAMP
);

# --- !Downs
;
drop table "users", "parking_slots";