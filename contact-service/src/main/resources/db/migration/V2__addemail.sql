CREATE TABLE public.email_address (
    email_id uuid NOT NULL,
    email varchar(100) NOT NULL,
    contact_id uuid NOT NULL,
    CONSTRAINT email_address_pk PRIMARY KEY (email_id),
    CONSTRAINT email_address_fk FOREIGN KEY (contact_id) REFERENCES public.contact(contact_id)
);