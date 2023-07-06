CREATE TABLE if not exists public.phone_number (
    phone_id uuid NOT NULL,
    phone varchar(100) NOT NULL,
    contact_id uuid NOT NULL,
    CONSTRAINT phone_number_pk PRIMARY KEY (phone_id),
    CONSTRAINT phone_number_fk FOREIGN KEY (contact_id) REFERENCES public.contact(contact_id)
);