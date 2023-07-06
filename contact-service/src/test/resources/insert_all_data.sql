--- Contacts
INSERT INTO public.contact
(contact_id, contact_name, owner_id)
VALUES('a6e4197c-b4f7-4fec-bf49-ca3a89d63676'::uuid, 'John Smith', '004ceabe-f4e3-44b5-a4d0-2a8d5d386a70'::uuid);
INSERT INTO public.contact
(contact_id, contact_name, owner_id)
VALUES('15409cf2-c887-4c37-ab4e-79e11a6f6833'::uuid, 'Black Jack', 'bd8626d6-0949-44fd-881b-e34ddd8102aa'::uuid);

--- PhoneNumbers
INSERT INTO public.phone_number
(phone_id, phone, contact_id)
VALUES('403c1212-7ffd-478d-8baf-c69122720cd8'::uuid, '+380-67-777-13-54', 'a6e4197c-b4f7-4fec-bf49-ca3a89d63676'::uuid);

INSERT INTO public.phone_number
(phone_id, phone, contact_id)
VALUES('657c67ab-9dc5-45fa-9102-9b4e563b8362'::uuid, '+380-564-99-13-54', 'a6e4197c-b4f7-4fec-bf49-ca3a89d63676'::uuid);

INSERT INTO public.phone_number
(phone_id, phone, contact_id)
VALUES('74a7e565-295c-4dae-ad04-110e11e3bfc8'::uuid, '+380-44-546-44-00', '15409cf2-c887-4c37-ab4e-79e11a6f6833'::uuid);

INSERT INTO public.phone_number
(phone_id, phone, contact_id)
VALUES('10241959-9d94-4c4f-8fb4-b6fa7243eba4'::uuid, '+380-99-000-99-22', '15409cf2-c887-4c37-ab4e-79e11a6f6833'::uuid);

--- Emails
INSERT INTO public.email_address
(email_id, email, contact_id)
VALUES('3e4fd283-a4a8-4aa4-a6da-c726e2a6febf'::uuid, 'john.smith@gmail.com', 'a6e4197c-b4f7-4fec-bf49-ca3a89d63676'::uuid);

INSERT INTO public.email_address
(email_id, email, contact_id)
VALUES('09589f31-4035-41d7-a946-0bacbe12e73b'::uuid, 'john.smith@hotmail.com', 'a6e4197c-b4f7-4fec-bf49-ca3a89d63676'::uuid);

INSERT INTO public.email_address
(email_id, email, contact_id)
VALUES('fa9ed412-f8ba-4956-8833-5fc4cf38e309'::uuid, 'black.jack@gmail.com', '15409cf2-c887-4c37-ab4e-79e11a6f6833'::uuid);

INSERT INTO public.email_address
(email_id, email, contact_id)
VALUES('bf608e0f-c47f-4575-8537-5b16b3531263'::uuid, 'black.jack@hotmail.com', '15409cf2-c887-4c37-ab4e-79e11a6f6833'::uuid);


