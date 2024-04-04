
create schema if not exists catalogue;

create table catalogue.t_product
(
    id        serial primary key,
    c_title   varchar(50) not null check (length(trim(c_title)) >= 3),
    c_details varchar(1000)
);

/*
 DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_namespace WHERE nspname = 'catalogue') THEN
CREATE SCHEMA catalogue;
END IF;
END $$;

 */
