create extension hstore;
create schema airports;
create table if not exists airports."Airport" ("airport_id" VARCHAR NOT NULL PRIMARY KEY, "ident" VARCHAR, "airport_type" VARCHAR, "name" VARCHAR, "latitude_deg" VARCHAR, "longitude_deg" VARCHAR, "elevation_ft" VARCHAR, "continent" VARCHAR, "iso_country" VARCHAR, "iso_region" VARCHAR, "municipality" VARCHAR, "scheduled_service" VARCHAR, "gps_code" VARCHAR, "iata_code" VARCHAR, "local_code" VARCHAR, "home_link" VARCHAR, "wikipedia_link" VARCHAR, "keywords" VARCHAR);
