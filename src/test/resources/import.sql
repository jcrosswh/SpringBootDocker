insert into COUNTRY (country_id, country, last_update) values (1, 'United States', sysdate);

insert into CITY (city_id, city, country_id, last_update) values (1, 'Denver', 1, sysdate);

insert into ADDRESS (address_id, address, district, city_id, phone, location, last_update) values (1, '123 Main St', 'Colorado', 1, '8885551212', RAWTOHEX('Location'), sysdate);

-- For circular reference
SET REFERENTIAL_INTEGRITY FALSE;

insert into STORE (store_id, manager_staff_id, address_id, last_update) values (1, 1, 1, sysdate);
insert into STORE (store_id, manager_staff_id, address_id, last_update) values (2, 2, 1, sysdate);

insert into STAFF (staff_id, first_name, last_name, address_id, store_id, active, username, last_update) values (1, 'Joel', 'Crosswhite', 1, 1, 1, 'Joel', sysdate);
insert into STAFF (staff_id, first_name, last_name, address_id, store_id, active, username, last_update) values (2, 'Bob', 'Smith', 1, 2, 1, 'Bob', sysdate);

SET REFERENTIAL_INTEGRITY TRUE;

insert into LANGUAGE (language_id, name, last_update) values (1, 'English', sysdate);

insert into FILM (film_id, title, language_id, rental_duration, rental_rate, replacement_cost, last_update) values (1, 'ACADEMY DINOSAUR', 1, 6, 0.99, 20.99, '2006-02-15 05:03:42');
insert into FILM (film_id, title, language_id, rental_duration, rental_rate, replacement_cost, last_update) values (2, 'ACE GOLDFINGER', 1, 6, 0.99, 20.99, '2006-02-15 05:03:42');
insert into FILM (film_id, title, language_id, rental_duration, rental_rate, replacement_cost, last_update) values (3, 'ADAPTATION HOLES', 1, 6, 0.99, 20.99, '2006-02-15 05:03:42');
insert into FILM (film_id, title, language_id, rental_duration, rental_rate, replacement_cost, last_update) values (4, 'AFFAIR PREJUDICE', 1, 6, 0.99, 20.99, '2006-02-15 05:03:42');
insert into FILM (film_id, title, language_id, rental_duration, rental_rate, replacement_cost, last_update) values (5, 'AFRICAN EGG', 1, 6, 0.99, 20.99, '2006-02-15 05:03:42');

insert into INVENTORY (inventory_id, film_id, store_id, last_update) values (1, 1, 1, sysdate);
insert into INVENTORY (inventory_id, film_id, store_id, last_update) values (2, 2, 1, sysdate);
insert into INVENTORY (inventory_id, film_id, store_id, last_update) values (3, 3, 1, sysdate);
insert into INVENTORY (inventory_id, film_id, store_id, last_update) values (4, 4, 2, sysdate);
insert into INVENTORY (inventory_id, film_id, store_id, last_update) values (5, 5, 2, sysdate);
insert into INVENTORY (inventory_id, film_id, store_id, last_update) values (6, 3, 1, sysdate);

insert into CATEGORY (category_id, name, last_update) values (1, 'Action', sysdate);
insert into CATEGORY (category_id, name, last_update) values (2, 'Sci-fi', sysdate);
insert into CATEGORY (category_id, name, last_update) values (3, 'Horror', sysdate);

insert into FILM_CATEGORY (film_id, category_id, last_update) values (1, 1, sysdate);
insert into FILM_CATEGORY (film_id, category_id, last_update) values (2, 1, sysdate);
insert into FILM_CATEGORY (film_id, category_id, last_update) values (3, 1, sysdate);
insert into FILM_CATEGORY (film_id, category_id, last_update) values (4, 1, sysdate);
insert into FILM_CATEGORY (film_id, category_id, last_update) values (5, 1, sysdate);

insert into CUSTOMER (customer_id, store_id, first_name, last_name, address_id, active, create_date) values (1 ,1, 'Joel', 'Crosswhite', 1, 1, sysdate);
insert into CUSTOMER (customer_id, store_id, first_name, last_name, address_id, active, create_date) values (2, 2, 'Bob', 'Smith', 1, 1, sysdate);

insert into RENTAL (rental_id, rental_date, inventory_id, customer_id, return_date, staff_id, last_update) values (1, sysdate, 1, 1, sysdate, 1, sysdate);
insert into RENTAL (rental_id, rental_date, inventory_id, customer_id, return_date, staff_id, last_update) values (2, sysdate, 1, 1, null, 1, sysdate);
insert into RENTAL (rental_id, rental_date, inventory_id, customer_id, return_date, staff_id, last_update) values (3, sysdate, 2, 1, null, 1, sysdate);
insert into RENTAL (rental_id, rental_date, inventory_id, customer_id, return_date, staff_id, last_update) values (4, sysdate, 4, 2, null, 2, sysdate);
insert into RENTAL (rental_id, rental_date, inventory_id, customer_id, return_date, staff_id, last_update) values (5, sysdate, 5, 2, null, 2, sysdate);
insert into RENTAL (rental_id, rental_date, inventory_id, customer_id, return_date, staff_id, last_update) values (6, sysdate, 6, 1, sysdate, 1, sysdate);
