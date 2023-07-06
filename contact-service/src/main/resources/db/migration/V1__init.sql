CREATE SCHEMA IF NOT EXISTS public;

CREATE TABLE IF NOT EXISTS public.contact (
    contact_id uuid NOT NULL,
    contact_name varchar(100) NOT NULL,
    CONSTRAINT contact_contact_name_key UNIQUE (contact_name),
    CONSTRAINT contact_pkey PRIMARY KEY (contact_id)
);
