-- RENTER
insert into USERS (EMAIL, FIRST_NAME, LAST_NAME, USER_NAME, PASSWORD, AGE, MOBILE) values ('emcbeath0@yahoo.com', 'Elle', 'McBeath', 'test1', '$2a$10$pZ2bf1ssb/ye9v7oVa5Mt.Gf/Yn6vs27UjqYLe3ukzrci9Q1MRmDG', 25, '12343423');

-- LEASER
insert into USERS (EMAIL, FIRST_NAME, LAST_NAME, USER_NAME, PASSWORD, AGE, MOBILE) values ('oplaunch1@multiply.com', 'Otho', 'Plaunch', 'test2', '$2a$10$lW1Qj4Aw0ZOL2R6A1MCgDOye4UhdjNNgeGjCo0PDGevHsWQp9PNse', 30, '720394982');

insert into RENTER(YEARS_DRIVING, ID) values (5, 1);
insert into LEASER(ID) values (2);

-- USER_ROLES
insert into USER_ROLES (USER_ID, USERROLES) values (1, 'ROLE_USER');
insert into USER_ROLES (USER_ID, USERROLES) values (2, 'ROLE_LEASER');

INSERT INTO CAR (MODEL, PLATE, USER_ID, IS_AVAILABLE, FROM_DATE, TO_DATE, PICTURE_URL, LAT, LONG) VALUES ('Toyota Camry', 'ABC123', 2, true, '2024-01-01', '2024-01-10', 'https://hips.hearstapps.com/hmg-prod/images/vehicle-types-1548954237.jpg?crop=1.00xw:1.00xh;0,0&resize=1200:*', 37.9715, 23.7266);
INSERT INTO CAR (MODEL, PLATE, USER_ID, IS_AVAILABLE, FROM_DATE, TO_DATE, PICTURE_URL, LAT, LONG) VALUES ('Honda Civic', 'DEF456', 2, false, '2024-02-05', '2024-02-15', 'https://hips.hearstapps.com/hmg-prod/images/vehicle-types-1548954237.jpg?crop=1.00xw:1.00xh;0,0&resize=1200:*', 37.9755, 23.7340);
INSERT INTO CAR (MODEL, PLATE, USER_ID, IS_AVAILABLE, FROM_DATE, TO_DATE, PICTURE_URL, LAT, LONG) VALUES ('Ford Mustang', 'GHI789', 2, true, '2024-03-10', '2024-03-20', 'https://hips.hearstapps.com/hmg-prod/images/2019-volkswagen-golf-gti-1548698211.jpg?crop=1xw:1xh;center,top&resize=980:*', 37.9714, 23.7292);
INSERT INTO CAR (MODEL, PLATE, USER_ID, IS_AVAILABLE, FROM_DATE, TO_DATE, PICTURE_URL, LAT, LONG) VALUES ('Chevrolet Tahoe', 'JKL012', 2, true, '2024-04-15', '2024-04-25', 'https://hips.hearstapps.com/hmg-prod/images/2019-honda-ridgeline-1548198293.jpg?crop=1xw:1xh;center,top&resize=980:*', 37.9767, 23.7258);
INSERT INTO CAR (MODEL, PLATE, USER_ID, IS_AVAILABLE, FROM_DATE, TO_DATE, PICTURE_URL, LAT, LONG) VALUES ('BMW X5', 'MNO345', 2, false, '2024-11-20', '2024-11-30', 'https://hips.hearstapps.com/hmg-prod/images/2019-bmw-x4-108-1530311134.jpg?crop=0.830xw:0.830xh;0,0.170xh&resize=980:*', 37.9870, 23.7325);
INSERT INTO CAR (MODEL, PLATE, USER_ID, IS_AVAILABLE, FROM_DATE, TO_DATE, PICTURE_URL, LAT, LONG) VALUES ('Mercedes-Benz E-Class', 'PQR678', 2, true, '2024-06-25', '2024-07-05', 'https://hips.hearstapps.com/hmg-prod/images/2019-chrysler-pacifica-1548198350.jpg?crop=1xw:1xh;center,top&resize=980:*', 37.9795, 23.7454);
INSERT INTO CAR (MODEL, PLATE, USER_ID, IS_AVAILABLE, FROM_DATE, TO_DATE, PICTURE_URL, LAT, LONG) VALUES ('Audi Q7', 'STU901', 2, true, '2024-11-20', '2024-11-30', 'https://hips.hearstapps.com/hmg-prod/images/2019-mercedes-benz-e-class-coupe-1548703839.jpg?crop=1xw:0.9997727789138833xh;center,top&resize=980:*', 37.9753, 23.7222);
INSERT INTO CAR (MODEL, PLATE, USER_ID, IS_AVAILABLE, FROM_DATE, TO_DATE, PICTURE_URL, LAT, LONG) VALUES ('Tesla Model S', 'VWX234', 2, false, '2024-09-10', '2024-09-20', 'https://images.cars.com/in/v2/stock_photos/77aeca88-d0af-4824-bbfd-d84ce2538524/1af0ca3f-5236-47a5-a487-32b49ec94f27.png?w=1000', 37.9695, 23.7349);
INSERT INTO CAR (MODEL, PLATE, USER_ID, IS_AVAILABLE, FROM_DATE, TO_DATE, PICTURE_URL, LAT, LONG) VALUES ('Nissan Altima', 'YZA567', 2, true,'2024-11-20', '2024-11-30', 'https://cdni.autocarindia.com/utils/imageresizer.ashx?n=https://cms.haymarketindia.net/model/uploads/modelimages/Hyundai-Grand-i10-Nios-200120231541.jpg', 37.9756, 23.7354);
INSERT INTO CAR (MODEL, PLATE, USER_ID, IS_AVAILABLE, FROM_DATE, TO_DATE, PICTURE_URL, LAT, LONG) VALUES ('Hyundai Sonata', 'BCD890', 2, true, '2024-11-20', '2024-11-30', 'https://www.usnews.com/dims4/USNEWS/e55f385/2147483647/crop/5439x3628+0+0/resize/970x647/quality/85/?url=https%3A%2F%2Fwww.usnews.com%2Fcmsmedia%2F41%2F74%2F25c541714a69b1f25951577ac23d%2F2023-hyundai-kona-electric-2.jpg', 37.9685, 23.7413);