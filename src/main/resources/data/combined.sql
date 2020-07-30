DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_role;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    email character varying(255) NOT NULL UNIQUE,
    password character varying(255) NOT NULL,
	address character varying(255) NULL,
	user_role integer NOT NULL
);

CREATE TABLE user_role (
    id SERIAL PRIMARY KEY,
	role character varying(255) NOT NULL
);

INSERT INTO users VALUES (1, 'admin', 'admin', 'admin', 'admin', '1970 Napa Ct. Bothell 98027', 1);
INSERT INTO users VALUES (2, 'Jemima', 'Foreman', 'magna@etultrices.net', '@gX;&UhU7e', '5203 Virginia Lane Kenmore 98055', 3);
INSERT INTO users VALUES (3, 'Zeph', 'Massey', 'a.feugiat.tellus@montesnasceturridiculus.co.uk', '<MFGvj$8E{', '9833 Mt. Dias Blv. Issaquah 92625', 3);
INSERT INTO users VALUES (4, 'Joseph', 'Crawford', 'lacinia.mattis@arcu.co.uk', '#kns*C5FEW', '390 Ridgewood Ct. Carnation 63301', 3);
INSERT INTO users VALUES (5, 'Ifeoma', 'Bird', 'diam.duis.mi@orcitinciduntadipiscing.com', 'RJ7~B{dP.', '7166 Brock Lane Seattle T2P 2G8', 3);
INSERT INTO users VALUES (6, 'Arsenio', 'Matthews', 'semper.pretium.neque@mauriseu.net', 'GZD!{&hs8(', '8152 Claudia Dr. Edmonds L4E 3M5', 3);
INSERT INTO users VALUES (7, 'Jemima', 'Cantu', 'et.risus.quisque@mollis.co.uk', 'j[zaKv*N6_', '2466 Clearland Circle Edmonds G1W', 3);
INSERT INTO users VALUES (8, 'Carol', 'Arnold', 'dapibus.rutrum@litoratorquent.com', '5{7V{fN&tW', '6871 Thornwood Dr. Sammamish H1Y 2H8', 3);
INSERT INTO users VALUES (9, 'Jane', 'Forbes', 'janiebaby@adipiscingenimmi.edu', 'z"4eu5z!VF', '9605 Pheasant Circle Gold Bar Montreal 98011',3);
INSERT INTO users VALUES (10, 'Ursa', 'William', 'malesuada@mauriseu.net', '/GHL6zJ(j', '7985 Center Street Renton 75201', 3);
INSERT INTO users VALUES (11, 'Carl', 'Massey', 'carl77901@lege4h.com', 'u4^DxytZkR', '9833 Mt. Dias Blv. Issaquah 92625', 2);
INSERT INTO users VALUES (12, 'Chris', 'Davids', 'cdavids.kailash@andyes.net', '8tb2B!85$7', '390 Ridgewood Ct. Carnation 63301', 3);
INSERT INTO users VALUES (13, 'Tom', 'Bird', 'tom.bird@googleappmail.com', '9j_Fx^jB9e', '7166 Brock Lane Seattle T2P 2G8', 3);
INSERT INTO users VALUES (14, 'Ezakaria', 'Ramirez', 'ezakaria-aabiratk@odegda-store.ru', 'T3!t*mj7SD', '8152 Claudia Dr. Edmonds L4E 3M5', 3);
INSERT INTO users VALUES (15, 'Carlos', 'Cantu', 'tme.shbeebi@treesoflifefarm.com', 'DxQrYQD+9N', '2466 Clearland Circle Edmonds G1W', 2);
INSERT INTO users VALUES (16, 'Dennis', 'Cantrell', 'cdenis.lyakhov9@petsday.org', '4_=aQCdWcn', '6871 Thornwood Dr. Sammamish H1Y 2H8', 3);
INSERT INTO users VALUES (17, 'Toub', 'Forbes', 'toub.f7@besltd.net', 'N%dr-k5nH4', '9605 Pheasant Circle Gold Bar Montreal 98011',2);
INSERT INTO users VALUES (18, 'Anna', 'Williams', 'anna.williams@petsday.org', '4?eR%@2-QE', '7985 Center Street Renton 75201', 3);
SELECT pg_catalog.setval('users_id_seq', 18, true);

INSERT INTO user_role VALUES (1, 'admin'), (2, 'employee'), (3, 'customer');
SELECT pg_catalog.setval('user_role_id_seq', 3, true);


DROP TABLE IF EXISTS products;

CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    product_name character varying(30) NOT NULL,
    gender character varying(6) NOT NULL,
    type character varying(15) NOT NULL,
    colour character varying(25) NOT NULL,
    sizes character varying(3) NOT NULL,
    prices integer NOT NULL,
    quantity_on_stock integer NOT NULL
);

INSERT INTO products VALUES (4369, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'white', 'XS', 30, 245);
INSERT INTO products VALUES (8323, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'white', 'S', 30, 178);
INSERT INTO products VALUES (2610, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'white', 'M', 30, 206);
INSERT INTO products VALUES (8170, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'white', 'L', 30, 14);
INSERT INTO products VALUES (7043, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'white', 'XL', 30, 177);
INSERT INTO products VALUES (2679, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'white', 'XXL', 30, 42);
INSERT INTO products VALUES (2824, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'white', '3XL', 30, 87);
INSERT INTO products VALUES (1335, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'blue', 'XS', 30, 22);
INSERT INTO products VALUES (1673, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'blue', 'S', 30, 47);
INSERT INTO products VALUES (9088, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'blue', 'M', 30, 45);
INSERT INTO products VALUES (2454, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'blue', 'L', 30, 80);
INSERT INTO products VALUES (384, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'blue', 'XL', 30, 100);
INSERT INTO products VALUES (9698, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'blue', 'XXL', 30, 138);
INSERT INTO products VALUES (2094, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'blue', '3XL', 30, 245);
INSERT INTO products VALUES (2471, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'navy', 'XS', 30, 108);
INSERT INTO products VALUES (2284, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'navy', 'S', 30, 205);
INSERT INTO products VALUES (1930, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'navy', 'M', 30, 237);
INSERT INTO products VALUES (4594, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'navy', 'L', 30, 43);
INSERT INTO products VALUES (6630, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'navy', 'XL', 30, 75);
INSERT INTO products VALUES (7585, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'navy', 'XXL', 30, 204);
INSERT INTO products VALUES (6066, 'Woman T-Shirt model 1', 'Female', 'T-Shirt', 'navy', '3XL', 30, 150);
INSERT INTO products VALUES (4916, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'cold light grey melange', 'XS', 30, 84);
INSERT INTO products VALUES (342, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'cold light grey melange', 'S', 30, 234);
INSERT INTO products VALUES (7036, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'cold light grey melange', 'M', 30, 174);
INSERT INTO products VALUES (175, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'cold light grey melange', 'L', 30, 180);
INSERT INTO products VALUES (1912, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'cold light grey melange', 'XL', 30, 38);
INSERT INTO products VALUES (6733, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'cold light grey melange', 'XXL', 30, 74);
INSERT INTO products VALUES (4070, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'cold light grey melange', '3XL', 30, 119);
INSERT INTO products VALUES (4253, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'white', 'XS', 30, 107);
INSERT INTO products VALUES (3234, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'white', 'S', 30, 181);
INSERT INTO products VALUES (8801, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'white', 'M', 30, 21);
INSERT INTO products VALUES (9501, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'white', 'L', 30, 161);
INSERT INTO products VALUES (7984, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'white', 'XL', 30, 18);
INSERT INTO products VALUES (247, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'white', 'XXL', 30, 93);
INSERT INTO products VALUES (8451, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'white', '3XL', 30, 111);
INSERT INTO products VALUES (7129, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'deep black', 'XS', 30, 222);
INSERT INTO products VALUES (2351, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'deep black', 'S', 30, 81);
INSERT INTO products VALUES (1538, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'deep black', 'M', 30, 219);
INSERT INTO products VALUES (4346, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'deep black', 'L', 30, 22);
INSERT INTO products VALUES (3793, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'deep black', 'XL', 30, 162);
INSERT INTO products VALUES (2884, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'deep black', 'XXL', 30, 8);
INSERT INTO products VALUES (9266, 'Woman T-Shirt model 2', 'Female', 'T-Shirt', 'deep black', '3XL', 30, 97);
INSERT INTO products VALUES (8368, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'cold light grey melange', 'XS', 30, 98);
INSERT INTO products VALUES (7161, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'cold light grey melange', 'S', 30, 138);
INSERT INTO products VALUES (6175, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'cold light grey melange', 'M', 30, 46);
INSERT INTO products VALUES (4625, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'cold light grey melange', 'L', 30, 30);
INSERT INTO products VALUES (8975, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'cold light grey melange', 'XL', 30, 236);
INSERT INTO products VALUES (6856, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'cold light grey melange', 'XXL', 30, 136);
INSERT INTO products VALUES (449, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'deep black', 'XS', 30, 128);
INSERT INTO products VALUES (1081, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'deep black', 'S', 30, 11);
INSERT INTO products VALUES (6768, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'deep black', 'M', 30, 21);
INSERT INTO products VALUES (3137, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'deep black', 'L', 30, 118);
INSERT INTO products VALUES (2233, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'deep black', 'XL', 30, 149);
INSERT INTO products VALUES (5066, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'deep black', 'XXL', 30, 218);
INSERT INTO products VALUES (5094, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'red', 'XS', 30, 206);
INSERT INTO products VALUES (6592, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'red', 'S', 30, 26);
INSERT INTO products VALUES (2500, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'red', 'M', 30, 35);
INSERT INTO products VALUES (3146, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'red', 'L', 30, 168);
INSERT INTO products VALUES (1862, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'red', 'XL', 30, 29);
INSERT INTO products VALUES (4175, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'red', 'XXL', 30, 238);
INSERT INTO products VALUES (3860, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'white', 'XS', 30, 65);
INSERT INTO products VALUES (734, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'white', 'S', 30, 54);
INSERT INTO products VALUES (8899, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'white', 'M', 30, 247);
INSERT INTO products VALUES (3281, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'white', 'L', 30, 52);
INSERT INTO products VALUES (491, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'white', 'XL', 30, 73);
INSERT INTO products VALUES (8214, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'white', 'XXL', 30, 180);
INSERT INTO products VALUES (915, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'cobalt', 'XS', 30, 47);
INSERT INTO products VALUES (7614, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'cobalt', 'S', 30, 30);
INSERT INTO products VALUES (922, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'cobalt', 'M', 30, 171);
INSERT INTO products VALUES (4609, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'cobalt', 'L', 30, 73);
INSERT INTO products VALUES (5338, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'cobalt', 'XL', 30, 112);
INSERT INTO products VALUES (9362, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'cobalt', 'XXL', 30, 224);
INSERT INTO products VALUES (235, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'blue', 'XS', 30, 156);
INSERT INTO products VALUES (4892, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'blue', 'S', 30, 127);
INSERT INTO products VALUES (8457, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'blue', 'M', 30, 152);
INSERT INTO products VALUES (9976, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'blue', 'L', 30, 98);
INSERT INTO products VALUES (9407, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'blue', 'XL', 30, 50);
INSERT INTO products VALUES (9722, 'Woman T-Shirt model 3', 'Female', 'T-Shirt', 'blue', 'XXL', 30, 161);
INSERT INTO products VALUES (5486, 'Men T-Shirt model 1', 'Male', 'T-Shirt', 'cobalt', 'S', 35, 116);
INSERT INTO products VALUES (2209, 'Men T-Shirt model 1', 'Male', 'T-Shirt', 'cobalt', 'M', 35, 171);
INSERT INTO products VALUES (1622, 'Men T-Shirt model 1', 'Male', 'T-Shirt', 'cobalt', 'L', 35, 72);
INSERT INTO products VALUES (7745, 'Men T-Shirt model 1', 'Male', 'T-Shirt', 'cobalt', 'XL', 35, 52);
INSERT INTO products VALUES (3456, 'Men T-Shirt model 1', 'Male', 'T-Shirt', 'cobalt', 'XXL', 35, 172);
INSERT INTO products VALUES (608, 'Men T-Shirt model 1', 'Male', 'T-Shirt', 'cobalt', '3XL', 35, 205);
INSERT INTO products VALUES (3090, 'Men T-Shirt model 1', 'Male', 'T-Shirt', 'middle grey melange', 'S', 35, 117);
INSERT INTO products VALUES (9388, 'Men T-Shirt model 1', 'Male', 'T-Shirt', 'middle grey melange', 'M', 35, 224);
INSERT INTO products VALUES (7669, 'Men T-Shirt model 1', 'Male', 'T-Shirt', 'middle grey melange', 'L', 35, 158);
INSERT INTO products VALUES (2769, 'Men T-Shirt model 1', 'Male', 'T-Shirt', 'middle grey melange', 'XL', 35, 203);
INSERT INTO products VALUES (9079, 'Men T-Shirt model 1', 'Male', 'T-Shirt', 'middle grey melange', 'XXL', 35, 120);
INSERT INTO products VALUES (5779, 'Men T-Shirt model 1', 'Male', 'T-Shirt', 'middle grey melange', '3XL', 35, 201);
INSERT INTO products VALUES (6042, 'Men T-Shirt model 2', 'Male', 'T-Shirt', 'navy', '3XL', 35, 13);
INSERT INTO products VALUES (5310, 'Men T-Shirt model 2', 'Male', 'T-Shirt', 'navy', 'L', 35, 124);
INSERT INTO products VALUES (1845, 'Men T-Shirt model 2', 'Male', 'T-Shirt', 'navy', 'M', 35, 106);
INSERT INTO products VALUES (910, 'Men T-Shirt model 2', 'Male', 'T-Shirt', 'navy', 'S', 35, 157);
INSERT INTO products VALUES (7799, 'Men T-Shirt model 2', 'Male', 'T-Shirt', 'navy', 'XL', 35, 17);
INSERT INTO products VALUES (4252, 'Men T-Shirt model 2', 'Male', 'T-Shirt', 'navy', 'XXL', 35, 157);
INSERT INTO products VALUES (9673, 'Men T-Shirt model 3', 'Male', 'T-Shirt', 'cold light grey melange', 'L', 35, 115);
INSERT INTO products VALUES (6518, 'Men T-Shirt model 3', 'Male', 'T-Shirt', 'cold light grey melange', 'M', 35, 245);
INSERT INTO products VALUES (3316, 'Men T-Shirt model 3', 'Male', 'T-Shirt', 'cold light grey melange', 'S', 35, 43);
INSERT INTO products VALUES (9121, 'Men T-Shirt model 3', 'Male', 'T-Shirt', 'cold light grey melange', 'XL', 35, 125);
INSERT INTO products VALUES (2199, 'Men T-Shirt model 3', 'Male', 'T-Shirt', 'cold light grey melange', 'XXL', 35, 243);
INSERT INTO products VALUES (3148, 'Men T-Shirt model 3', 'Male', 'T-Shirt', 'cold light grey melange', '3XL', 35, 202);
INSERT INTO products VALUES (3410, 'Men T-Shirt model 4', 'Male', 'T-Shirt', 'white', 'L', 35, 75);
INSERT INTO products VALUES (3728, 'Men T-Shirt model 4', 'Male', 'T-Shirt', 'white', 'M', 35, 241);
INSERT INTO products VALUES (7437, 'Men T-Shirt model 4', 'Male', 'T-Shirt', 'white', 'S', 35, 186);
INSERT INTO products VALUES (6612, 'Men T-Shirt model 4', 'Male', 'T-Shirt', 'white', 'XL', 35, 117);
INSERT INTO products VALUES (2237, 'Men T-Shirt model 4', 'Male', 'T-Shirt', 'white', 'XXL', 35, 92);
INSERT INTO products VALUES (8768, 'Men T-Shirt model 4', 'Male', 'T-Shirt', 'white', '3XL', 35, 198);
INSERT INTO products VALUES (5631, 'Men T-Shirt model 4', 'Male', 'T-Shirt', 'deep black', 'L', 35, 12);
INSERT INTO products VALUES (2849, 'Men T-Shirt model 4', 'Male', 'T-Shirt', 'deep black', 'M', 35, 111);
INSERT INTO products VALUES (6271, 'Men T-Shirt model 4', 'Male', 'T-Shirt', 'deep black', 'S', 35, 101);
INSERT INTO products VALUES (4215, 'Men T-Shirt model 4', 'Male', 'T-Shirt', 'deep black', 'XL', 35, 156);
INSERT INTO products VALUES (9764, 'Men T-Shirt model 4', 'Male', 'T-Shirt', 'deep black', 'XXL', 35, 111);
INSERT INTO products VALUES (2509, 'Men T-Shirt model 4', 'Male', 'T-Shirt', 'deep black', '3XL', 35, 47);
INSERT INTO products VALUES (5490, 'Men T-Shirt model 5', 'Male', 'T-Shirt', 'white', 'L', 35, 175);
INSERT INTO products VALUES (949, 'Men T-Shirt model 5', 'Male', 'T-Shirt', 'white', 'M', 35, 43);
INSERT INTO products VALUES (8939, 'Men T-Shirt model 5', 'Male', 'T-Shirt', 'white', 'S', 35, 22);
INSERT INTO products VALUES (6246, 'Men T-Shirt model 5', 'Male', 'T-Shirt', 'white', 'XL', 35, 183);
INSERT INTO products VALUES (5002, 'Men T-Shirt model 5', 'Male', 'T-Shirt', 'white', 'XXL', 35, 25);
INSERT INTO products VALUES (3896, 'Men T-Shirt model 5', 'Male', 'T-Shirt', 'white', '3XL', 35, 172);
INSERT INTO products VALUES (2366, 'Men T-Shirt model 5', 'Male', 'T-Shirt', 'deep black', 'L', 35, 40);
INSERT INTO products VALUES (2918, 'Men T-Shirt model 5', 'Male', 'T-Shirt', 'deep black', 'M', 35, 8);
INSERT INTO products VALUES (8507, 'Men T-Shirt model 5', 'Male', 'T-Shirt', 'deep black', 'S', 35, 162);
INSERT INTO products VALUES (3387, 'Men T-Shirt model 5', 'Male', 'T-Shirt', 'deep black', 'XL', 35, 56);
INSERT INTO products VALUES (2828, 'Men T-Shirt model 5', 'Male', 'T-Shirt', 'deep black', 'XXL', 35, 116);
INSERT INTO products VALUES (2017, 'Men T-Shirt model 5', 'Male', 'T-Shirt', 'deep black', '3XL', 35, 172);
INSERT INTO products VALUES (8383, 'Men T-Shirt model 6', 'Male', 'T-Shirt', 'red', 'L', 35, 152);
INSERT INTO products VALUES (5385, 'Men T-Shirt model 6', 'Male', 'T-Shirt', 'red', 'M', 35, 95);
INSERT INTO products VALUES (4565, 'Men T-Shirt model 6', 'Male', 'T-Shirt', 'red', 'S', 35, 25);
INSERT INTO products VALUES (6156, 'Men T-Shirt model 6', 'Male', 'T-Shirt', 'red', 'XL', 35, 64);
INSERT INTO products VALUES (1642, 'Men T-Shirt model 6', 'Male', 'T-Shirt', 'red', 'XXL', 35, 125);
INSERT INTO products VALUES (9795, 'Men T-Shirt model 6', 'Male', 'T-Shirt', 'red', '3XL', 35, 54);
INSERT INTO products VALUES (6713, 'Men T-Shirt model 6', 'Male', 'T-Shirt', 'white', 'L', 35, 177);
INSERT INTO products VALUES (9515, 'Men T-Shirt model 6', 'Male', 'T-Shirt', 'white', 'M', 35, 249);
INSERT INTO products VALUES (6378, 'Men T-Shirt model 6', 'Male', 'T-Shirt', 'white', 'S', 35, 38);
INSERT INTO products VALUES (546, 'Men T-Shirt model 6', 'Male', 'T-Shirt', 'white', 'XL', 35, 76);
INSERT INTO products VALUES (5931, 'Men T-Shirt model 6', 'Male', 'T-Shirt', 'white', 'XXL', 35, 148);
INSERT INTO products VALUES (2620, 'Men T-Shirt model 6', 'Male', 'T-Shirt', 'white', '3XL', 35, 143);
INSERT INTO products VALUES (4029, 'Men T-Shirt model 7', 'Male', 'T-Shirt', 'white', 'L', 35, 47);
INSERT INTO products VALUES (1390, 'Men T-Shirt model 7', 'Male', 'T-Shirt', 'white', 'M', 35, 3);
INSERT INTO products VALUES (4602, 'Men T-Shirt model 7', 'Male', 'T-Shirt', 'white', 'S', 35, 64);
INSERT INTO products VALUES (7918, 'Men T-Shirt model 7', 'Male', 'T-Shirt', 'white', 'XL', 35, 88);
INSERT INTO products VALUES (5451, 'Men T-Shirt model 7', 'Male', 'T-Shirt', 'white', 'XXL', 35, 104);
INSERT INTO products VALUES (80, 'Men T-Shirt model 7', 'Male', 'T-Shirt', 'white', '3XL', 35, 165);
INSERT INTO products VALUES (7878, 'Men T-Shirt model 7', 'Male', 'T-Shirt', 'deep black', 'L', 35, 130);
INSERT INTO products VALUES (3664, 'Men T-Shirt model 7', 'Male', 'T-Shirt', 'deep black', 'M', 35, 7);
INSERT INTO products VALUES (6433, 'Men T-Shirt model 7', 'Male', 'T-Shirt', 'deep black', 'S', 35, 210);
INSERT INTO products VALUES (1289, 'Men T-Shirt model 7', 'Male', 'T-Shirt', 'deep black', 'XL', 35, 81);
INSERT INTO products VALUES (3412, 'Men T-Shirt model 7', 'Male', 'T-Shirt', 'deep black', 'XXL', 35, 105);
INSERT INTO products VALUES (1506, 'Men T-Shirt model 7', 'Male', 'T-Shirt', 'deep black', '3XL', 35, 85);
INSERT INTO products VALUES (803, 'Men T-Shirt model 8', 'Male', 'T-Shirt', 'white', 'L', 35, 73);
INSERT INTO products VALUES (1406, 'Men T-Shirt model 8', 'Male', 'T-Shirt', 'white', 'M', 35, 148);
INSERT INTO products VALUES (4582, 'Men T-Shirt model 8', 'Male', 'T-Shirt', 'white', 'S', 35, 250);
INSERT INTO products VALUES (2760, 'Men T-Shirt model 8', 'Male', 'T-Shirt', 'white', 'XL', 35, 41);
INSERT INTO products VALUES (7691, 'Men T-Shirt model 8', 'Male', 'T-Shirt', 'white', 'XXL', 35, 109);
INSERT INTO products VALUES (2808, 'Men T-Shirt model 8', 'Male', 'T-Shirt', 'white', '3XL', 35, 218);
INSERT INTO products VALUES (2180, 'Men T-Shirt model 8', 'Male', 'T-Shirt', 'deep black', 'XXL', 35, 216);
INSERT INTO products VALUES (9752, 'Men T-Shirt model 8', 'Male', 'T-Shirt', 'deep black', 'L', 35, 247);
INSERT INTO products VALUES (401, 'Men T-Shirt model 8', 'Male', 'T-Shirt', 'deep black', 'M', 35, 198);
INSERT INTO products VALUES (5459, 'Men T-Shirt model 8', 'Male', 'T-Shirt', 'deep black', 'S', 35, 147);
INSERT INTO products VALUES (7163, 'Men T-Shirt model 8', 'Male', 'T-Shirt', 'deep black', 'XL', 35, 149);
INSERT INTO products VALUES (2711, 'Men T-Shirt model 8', 'Male', 'T-Shirt', 'deep black', '3XL', 35, 61);
INSERT INTO products VALUES (8688, 'Men T-Shirt model 8', 'Male', 'T-Shirt', 'cobalt', 'S', 35, 12);
INSERT INTO products VALUES (4797, 'Men T-Shirt model 8', 'Male', 'T-Shirt', 'cobalt', 'XL', 35, 163);
INSERT INTO products VALUES (9272, 'Men T-Shirt model 8', 'Male', 'T-Shirt', 'cobalt', 'XXL', 35, 82);
INSERT INTO products VALUES (204, 'Men T-Shirt model 8', 'Male', 'T-Shirt', 'cobalt', 'L', 35, 218);
INSERT INTO products VALUES (6328, 'Men T-Shirt model 8', 'Male', 'T-Shirt', 'cobalt', 'M', 35, 34);
INSERT INTO products VALUES (8733, 'Men T-Shirt model 8', 'Male', 'T-Shirt', 'cobalt', '3XL', 35, 113);
INSERT INTO products VALUES (847, 'Woman Leggins model 1', 'Female', 'Pants', 'grey melange', '122', 31.2, 204);
INSERT INTO products VALUES (9952, 'Woman Leggins model 1', 'Female', 'Pants', 'grey melange', '128', 31.2, 10);
INSERT INTO products VALUES (943, 'Woman Leggins model 1', 'Female', 'Pants', 'grey melange', '134', 31.2, 42);
INSERT INTO products VALUES (8990, 'Woman Leggins model 1', 'Female', 'Pants', 'grey melange', '140', 31.2, 195);
INSERT INTO products VALUES (6123, 'Woman Leggins model 1', 'Female', 'Pants', 'grey melange', '146', 31.2, 133);
INSERT INTO products VALUES (4174, 'Woman Leggins model 1', 'Female', 'Pants', 'grey melange', '152', 31.2, 117);
INSERT INTO products VALUES (6511, 'Woman Leggins model 1', 'Female', 'Pants', 'grey melange', '158', 31.2, 110);
INSERT INTO products VALUES (9193, 'Woman Leggins model 1', 'Female', 'Pants', 'grey melange', '164', 31.2, 4);
INSERT INTO products VALUES (7516, 'Woman Leggins model 2', 'Female', 'Pants', 'navy', '122', 31.2, 146);
INSERT INTO products VALUES (9395, 'Woman Leggins model 2', 'Female', 'Pants', 'navy', '128', 31.2, 0);
INSERT INTO products VALUES (9618, 'Woman Leggins model 2', 'Female', 'Pants', 'navy', '134', 31.2, 75);
INSERT INTO products VALUES (3776, 'Woman Leggins model 2', 'Female', 'Pants', 'navy', '140', 31.2, 221);
INSERT INTO products VALUES (8540, 'Woman Leggins model 2', 'Female', 'Pants', 'navy', '146', 31.2, 115);
INSERT INTO products VALUES (6574, 'Woman Leggins model 2', 'Female', 'Pants', 'navy', '152', 31.2, 120);
INSERT INTO products VALUES (7311, 'Woman Leggins model 2', 'Female', 'Pants', 'navy', '158', 31.2, 113);
INSERT INTO products VALUES (9629, 'Woman Leggins model 2', 'Female', 'Pants', 'navy', '164', 31.2, 69);
INSERT INTO products VALUES (3230, 'Men Sweatshirt model 1', 'Male', 'Sweatshirt', 'cold light grey melange', '122', 65.4, 250);
INSERT INTO products VALUES (6795, 'Men Sweatshirt model 1', 'Male', 'Sweatshirt', 'cold light grey melange', '128', 65.4, 130);
INSERT INTO products VALUES (8831, 'Men Sweatshirt model 1', 'Male', 'Sweatshirt', 'cold light grey melange', '134', 65.4, 4);
INSERT INTO products VALUES (3661, 'Men Sweatshirt model 1', 'Male', 'Sweatshirt', 'cold light grey melange', '140', 65.4, 22);
INSERT INTO products VALUES (4943, 'Men Sweatshirt model 1', 'Male', 'Sweatshirt', 'cold light grey melange', '146', 65.4, 87);
INSERT INTO products VALUES (6376, 'Men Sweatshirt model 1', 'Male', 'Sweatshirt', 'cold light grey melange', '152', 65.4, 58);
INSERT INTO products VALUES (8639, 'Men Sweatshirt model 1', 'Male', 'Sweatshirt', 'cold light grey melange', '158', 65.4, 72);
INSERT INTO products VALUES (8770, 'Men Sweatshirt model 1', 'Male', 'Sweatshirt', 'cold light grey melange', '164', 65.4, 91);
INSERT INTO products VALUES (3121, 'Men Sweatshirt model 2', 'Male', 'Sweatshirt', 'navy', '122', 65.4, 25);
INSERT INTO products VALUES (9898, 'Men Sweatshirt model 2', 'Male', 'Sweatshirt', 'navy', '128', 65.4, 170);
INSERT INTO products VALUES (8638, 'Men Sweatshirt model 2', 'Male', 'Sweatshirt', 'navy', '134', 65.4, 129);
INSERT INTO products VALUES (6114, 'Men Sweatshirt model 2', 'Male', 'Sweatshirt', 'navy', '140', 65.4, 176);
INSERT INTO products VALUES (8050, 'Men Sweatshirt model 2', 'Male', 'Sweatshirt', 'navy', '146', 65.4, 238);
INSERT INTO products VALUES (5252, 'Men Sweatshirt model 2', 'Male', 'Sweatshirt', 'navy', '152', 65.4, 169);
INSERT INTO products VALUES (7784, 'Men Sweatshirt model 2', 'Male', 'Sweatshirt', 'navy', '158', 65.4, 117);
INSERT INTO products VALUES (1469, 'Men Sweatshirt model 2', 'Male', 'Sweatshirt', 'navy', '164', 65.4, 126);
INSERT INTO products VALUES (7618, 'Men Pants model 1', 'Male', 'Pants', 'grey melange', '122', 62.4, 39);
INSERT INTO products VALUES (4650, 'Men Pants model 1', 'Male', 'Pants', 'grey melange', '128', 62.4, 232);
INSERT INTO products VALUES (823, 'Men Pants model 1', 'Male', 'Pants', 'grey melange', '134', 62.4, 197);
INSERT INTO products VALUES (6466, 'Men Pants model 1', 'Male', 'Pants', 'grey melange', '140', 62.4, 72);
INSERT INTO products VALUES (5732, 'Men Pants model 1', 'Male', 'Pants', 'grey melange', '146', 62.4, 67);
INSERT INTO products VALUES (607, 'Men Pants model 1', 'Male', 'Pants', 'grey melange', '152', 62.4, 88);
INSERT INTO products VALUES (5919, 'Men Pants model 1', 'Male', 'Pants', 'grey melange', '158', 62.4, 6);
INSERT INTO products VALUES (6893, 'Men Pants model 1', 'Male', 'Pants', 'grey melange', '164', 62.4, 41);
INSERT INTO products VALUES (6248, 'Men Pants model 2', 'Male', 'Pants', 'cobalt', '122', 62.4, 176);
INSERT INTO products VALUES (9122, 'Men Pants model 2', 'Male', 'Pants', 'cobalt', '128', 62.4, 96);
INSERT INTO products VALUES (9156, 'Men Pants model 2', 'Male', 'Pants', 'cobalt', '134', 62.4, 85);
INSERT INTO products VALUES (8431, 'Men Pants model 2', 'Male', 'Pants', 'cobalt', '140', 62.4, 150);
INSERT INTO products VALUES (5046, 'Men Pants model 2', 'Male', 'Pants', 'cobalt', '146', 62.4, 84);
INSERT INTO products VALUES (1298, 'Men Pants model 2', 'Male', 'Pants', 'cobalt', '152', 62.4, 46);
INSERT INTO products VALUES (2402, 'Men Pants model 2', 'Male', 'Pants', 'cobalt', '158', 62.4, 26);
INSERT INTO products VALUES (5294, 'Men Pants model 2', 'Male', 'Pants', 'cobalt', '164', 62.4, 140);
INSERT INTO products VALUES (2780, 'Men Pants model 3', 'Male', 'Pants', 'navy', '122', 62.4, 144);
INSERT INTO products VALUES (6577, 'Men Pants model 3', 'Male', 'Pants', 'navy', '128', 62.4, 32);
INSERT INTO products VALUES (6599, 'Men Pants model 3', 'Male', 'Pants', 'navy', '134', 62.4, 80);
INSERT INTO products VALUES (5598, 'Men Pants model 3', 'Male', 'Pants', 'navy', '140', 62.4, 92);
INSERT INTO products VALUES (2506, 'Men Pants model 3', 'Male', 'Pants', 'navy', '146', 62.4, 14);
INSERT INTO products VALUES (3061, 'Men Pants model 3', 'Male', 'Pants', 'navy', '152', 62.4, 241);
INSERT INTO products VALUES (1073, 'Men Pants model 3', 'Male', 'Pants', 'navy', '158', 62.4, 247);
INSERT INTO products VALUES (9745, 'Men Pants model 3', 'Male', 'Pants', 'navy', '164', 62.4, 143);
INSERT INTO products VALUES (5827, 'Men Jacket model 1', 'Male', 'Jacket', 'khaki', '122', 264, 105);
INSERT INTO products VALUES (4941, 'Men Jacket model 1', 'Male', 'Jacket', 'khaki', '128', 264, 137);
INSERT INTO products VALUES (7418, 'Men Jacket model 1', 'Male', 'Jacket', 'khaki', '134', 264, 142);
INSERT INTO products VALUES (6793, 'Men Jacket model 1', 'Male', 'Jacket', 'khaki', '140', 264, 96);
INSERT INTO products VALUES (8111, 'Men Jacket model 1', 'Male', 'Jacket', 'khaki', '146', 264, 147);
INSERT INTO products VALUES (6434, 'Men Jacket model 1', 'Male', 'Jacket', 'khaki', '152', 264, 200);
INSERT INTO products VALUES (275, 'Men Jacket model 1', 'Male', 'Jacket', 'khaki', '158', 264, 27);
INSERT INTO products VALUES (8324, 'Men Jacket model 1', 'Male', 'Jacket', 'khaki', '164', 264, 191);
INSERT INTO products VALUES (923, 'Men Jacket model 2', 'Male', 'Jacket', 'navy', '122', 264, 234);
INSERT INTO products VALUES (650, 'Men Jacket model 2', 'Male', 'Jacket', 'navy', '128', 264, 174);
INSERT INTO products VALUES (9975, 'Men Jacket model 2', 'Male', 'Jacket', 'navy', '134', 264, 33);
INSERT INTO products VALUES (9145, 'Men Jacket model 2', 'Male', 'Jacket', 'navy', '140', 264, 1);
INSERT INTO products VALUES (2562, 'Men Jacket model 2', 'Male', 'Jacket', 'navy', '146', 264, 126);
INSERT INTO products VALUES (4306, 'Men Jacket model 2', 'Male', 'Jacket', 'navy', '152', 264, 192);
INSERT INTO products VALUES (8416, 'Men Jacket model 2', 'Male', 'Jacket', 'navy', '158', 264, 68);
INSERT INTO products VALUES (5765, 'Men Jacket model 2', 'Male', 'Jacket', 'navy', '164', 264, 108);
INSERT INTO products VALUES (556, 'Woman Jacket model 1', 'Female', 'Jacket', 'grey melange', '122', 270, 120);
INSERT INTO products VALUES (6741, 'Woman Jacket model 1', 'Female', 'Jacket', 'grey melange', '128', 270, 220);
INSERT INTO products VALUES (2603, 'Woman Jacket model 1', 'Female', 'Jacket', 'grey melange', '134', 270, 180);
INSERT INTO products VALUES (6642, 'Woman Jacket model 1', 'Female', 'Jacket', 'grey melange', '140', 270, 218);
INSERT INTO products VALUES (514, 'Woman Jacket model 1', 'Female', 'Jacket', 'grey melange', '146', 270, 214);
INSERT INTO products VALUES (6237, 'Woman Jacket model 1', 'Female', 'Jacket', 'grey melange', '152', 270, 156);
INSERT INTO products VALUES (6686, 'Woman Jacket model 2', 'Female', 'Jacket', 'grey melange', '122', 178.8, 202);
INSERT INTO products VALUES (945, 'Woman Jacket model 2', 'Female', 'Jacket', 'grey melange', '128', 178.8, 136);
INSERT INTO products VALUES (6890, 'Woman Jacket model 2', 'Female', 'Jacket', 'grey melange', '134', 178.8, 91);
INSERT INTO products VALUES (6546, 'Woman Jacket model 2', 'Female', 'Jacket', 'grey melange', '140', 178.8, 232);
INSERT INTO products VALUES (9823, 'Woman Jacket model 2', 'Female', 'Jacket', 'grey melange', '146', 178.8, 26);
INSERT INTO products VALUES (5137, 'Woman Jacket model 2', 'Female', 'Jacket', 'grey melange', '152', 178.8, 22);
INSERT INTO products VALUES (6735, 'Woman Jacket model 2', 'Female', 'Jacket', 'grey melange', '158', 178.8, 16);
INSERT INTO products VALUES (9500, 'Woman Jacket model 2', 'Female', 'Jacket', 'grey melange', '164', 178.8, 27);
INSERT INTO products VALUES (352, 'Woman Jacket model 3', 'Female', 'Jacket', 'red', '122', 178.8, 199);
INSERT INTO products VALUES (8686, 'Woman Jacket model 3', 'Female', 'Jacket', 'red', '128', 178.8, 69);
INSERT INTO products VALUES (1165, 'Woman Jacket model 3', 'Female', 'Jacket', 'red', '134', 178.8, 54);
INSERT INTO products VALUES (1856, 'Woman Jacket model 3', 'Female', 'Jacket', 'red', '140', 178.8, 165);
INSERT INTO products VALUES (1780, 'Woman Jacket model 3', 'Female', 'Jacket', 'red', '146', 178.8, 58);
INSERT INTO products VALUES (3876, 'Woman Jacket model 3', 'Female', 'Jacket', 'red', '152', 178.8, 176);
INSERT INTO products VALUES (2424, 'Woman Jacket model 3', 'Female', 'Jacket', 'red', '158', 178.8, 161);
INSERT INTO products VALUES (4480, 'Woman Jacket model 3', 'Female', 'Jacket', 'red', '164', 178.8, 233);
INSERT INTO products VALUES (9636, 'Men Sweatshirt model 3', 'Male', 'Sweatshirt', 'cold light grey melange', 'L', 102.6, 137);
INSERT INTO products VALUES (4793, 'Men Sweatshirt model 3', 'Male', 'Sweatshirt', 'cold light grey melange', 'M', 102.6, 198);
INSERT INTO products VALUES (8432, 'Men Sweatshirt model 3', 'Male', 'Sweatshirt', 'cold light grey melange', 'S', 102.6, 227);
INSERT INTO products VALUES (5657, 'Men Sweatshirt model 3', 'Male', 'Sweatshirt', 'cold light grey melange', 'XL', 102.6, 11);
INSERT INTO products VALUES (5646, 'Men Sweatshirt model 3', 'Male', 'Sweatshirt', 'cold light grey melange', 'XXL', 102.6, 123);
INSERT INTO products VALUES (5361, 'Men Sweatshirt model 3', 'Male', 'Sweatshirt', 'cold light grey melange', '3XL', 102.6, 34);
INSERT INTO products VALUES (2232, 'Men Sweatshirt model 3', 'Male', 'Sweatshirt', 'deep black', 'L', 102.6, 41);
INSERT INTO products VALUES (2709, 'Men Sweatshirt model 3', 'Male', 'Sweatshirt', 'deep black', 'M', 102.6, 94);
INSERT INTO products VALUES (3380, 'Men Sweatshirt model 3', 'Male', 'Sweatshirt', 'deep black', 'S', 102.6, 244);
INSERT INTO products VALUES (3184, 'Men Sweatshirt model 3', 'Male', 'Sweatshirt', 'deep black', 'XL', 102.6, 102);
INSERT INTO products VALUES (9492, 'Men Sweatshirt model 3', 'Male', 'Sweatshirt', 'deep black', 'XXL', 102.6, 13);
INSERT INTO products VALUES (5497, 'Men Sweatshirt model 3', 'Male', 'Sweatshirt', 'deep black', '3XL', 102.6, 42);
INSERT INTO products VALUES (3280, 'Men Sweatshirt model 3', 'Male', 'Sweatshirt', 'red', 'L', 102.6, 248);
INSERT INTO products VALUES (1609, 'Men Sweatshirt model 3', 'Male', 'Sweatshirt', 'red', 'M', 102.6, 217);
INSERT INTO products VALUES (3731, 'Men Sweatshirt model 3', 'Male', 'Sweatshirt', 'red', 'S', 102.6, 72);
INSERT INTO products VALUES (8535, 'Men Sweatshirt model 3', 'Male', 'Sweatshirt', 'red', 'XL', 102.6, 87);
INSERT INTO products VALUES (8501, 'Men Sweatshirt model 3', 'Male', 'Sweatshirt', 'red', 'XXL', 102.6, 221);
INSERT INTO products VALUES (3154, 'Men Sweatshirt model 3', 'Male', 'Sweatshirt', 'red', '3XL', 102.6, 165);
INSERT INTO products VALUES (3457, 'Woman Sweatshirt model 1', 'Female', 'Sweatshirt', 'light pink', '122', 67.8, 6);
INSERT INTO products VALUES (3464, 'Woman Sweatshirt model 1', 'Female', 'Sweatshirt', 'light pink', '128', 67.8, 103);
INSERT INTO products VALUES (3471, 'Woman Sweatshirt model 1', 'Female', 'Sweatshirt', 'light pink', '134', 67.8, 141);
INSERT INTO products VALUES (3488, 'Woman Sweatshirt model 1', 'Female', 'Sweatshirt', 'light pink', '140', 67.8, 162);
INSERT INTO products VALUES (3495, 'Woman Sweatshirt model 1', 'Female', 'Sweatshirt', 'light pink', '146', 67.8, 64);
INSERT INTO products VALUES (3501, 'Woman Sweatshirt model 1', 'Female', 'Sweatshirt', 'light pink', '152', 67.8, 97);
INSERT INTO products VALUES (3518, 'Woman Sweatshirt model 1', 'Female', 'Sweatshirt', 'light pink', '158', 67.8, 139);
INSERT INTO products VALUES (3525, 'Woman Sweatshirt model 1', 'Female', 'Sweatshirt', 'light pink', '164', 67.8, 79);
INSERT INTO products VALUES (3532, 'Woman Sweatshirt model 2', 'Female', 'Sweatshirt', 'navy', '122', 66, 121);
INSERT INTO products VALUES (3549, 'Woman Sweatshirt model 2', 'Female', 'Sweatshirt', 'navy', '128', 66, 246);
INSERT INTO products VALUES (3556, 'Woman Sweatshirt model 2', 'Female', 'Sweatshirt', 'navy', '134', 66, 98);
INSERT INTO products VALUES (3563, 'Woman Sweatshirt model 2', 'Female', 'Sweatshirt', 'navy', '140', 66, 68);
INSERT INTO products VALUES (3570, 'Woman Sweatshirt model 2', 'Female', 'Sweatshirt', 'navy', '146', 66, 56);
INSERT INTO products VALUES (3587, 'Woman Sweatshirt model 2', 'Female', 'Sweatshirt', 'navy', '152', 66, 21);
INSERT INTO products VALUES (3594, 'Woman Sweatshirt model 2', 'Female', 'Sweatshirt', 'navy', '158', 66, 176);
INSERT INTO products VALUES (3600, 'Woman Sweatshirt model 2', 'Female', 'Sweatshirt', 'navy', '164', 66, 58);
INSERT INTO products VALUES (1494, 'Woman Sweatshirt model 3', 'Female', 'Sweatshirt', 'grey melange', '122', 68.4, 167);
INSERT INTO products VALUES (7694, 'Woman Sweatshirt model 3', 'Female', 'Sweatshirt', 'grey melange', '128', 68.4, 207);
INSERT INTO products VALUES (9639, 'Woman Sweatshirt model 3', 'Female', 'Sweatshirt', 'grey melange', '134', 68.4, 177);
INSERT INTO products VALUES (7273, 'Woman Sweatshirt model 3', 'Female', 'Sweatshirt', 'grey melange', '140', 68.4, 148);
INSERT INTO products VALUES (9625, 'Woman Sweatshirt model 3', 'Female', 'Sweatshirt', 'grey melange', '146', 68.4, 200);
INSERT INTO products VALUES (6647, 'Woman Sweatshirt model 3', 'Female', 'Sweatshirt', 'grey melange', '152', 68.4, 167);
INSERT INTO products VALUES (7581, 'Woman Sweatshirt model 3', 'Female', 'Sweatshirt', 'grey melange', '158', 68.4, 207);
INSERT INTO products VALUES (4233, 'Woman Sweatshirt model 3', 'Female', 'Sweatshirt', 'grey melange', '164', 68.4, 6);
INSERT INTO products VALUES (3938, 'Woman Sweatshirt model 4', 'Female', 'Sweatshirt', 'red', '122', 69.96, 82);
INSERT INTO products VALUES (3945, 'Woman Sweatshirt model 4', 'Female', 'Sweatshirt', 'red', '128', 69.96, 52);
INSERT INTO products VALUES (3952, 'Woman Sweatshirt model 4', 'Female', 'Sweatshirt', 'red', '134', 69.96, 150);
INSERT INTO products VALUES (3969, 'Woman Sweatshirt model 4', 'Female', 'Sweatshirt', 'red', '140', 69.96, 66);
INSERT INTO products VALUES (3976, 'Woman Sweatshirt model 4', 'Female', 'Sweatshirt', 'red', '146', 69.96, 86);
INSERT INTO products VALUES (3983, 'Woman Sweatshirt model 4', 'Female', 'Sweatshirt', 'red', '152', 69.96, 174);
INSERT INTO products VALUES (3991, 'Woman Sweatshirt model 4', 'Female', 'Sweatshirt', 'red', '158', 69.96, 25);
INSERT INTO products VALUES (4003, 'Woman Sweatshirt model 4', 'Female', 'Sweatshirt', 'red', '164', 69.96, 213);
INSERT INTO products VALUES (9443, 'Woman Pants model 1', 'Female', 'Pants', 'cobalt', 'S', 77, 227);
INSERT INTO products VALUES (5932, 'Woman Pants model 1', 'Female', 'Pants', 'cobalt', 'M', 77, 210);
INSERT INTO products VALUES (7895, 'Woman Pants model 1', 'Female', 'Pants', 'cobalt', 'L', 77, 186);
INSERT INTO products VALUES (7213, 'Woman Pants model 1', 'Female', 'Pants', 'deep black', 'XS', 77, 114);
INSERT INTO products VALUES (3466, 'Woman Pants model 1', 'Female', 'Pants', 'deep black', 'S', 77, 127);
INSERT INTO products VALUES (6780, 'Woman Pants model 1', 'Female', 'Pants', 'deep black', 'M', 77, 145);
INSERT INTO products VALUES (6972, 'Woman Pants model 1', 'Female', 'Pants', 'deep black', 'L', 77, 124);
INSERT INTO products VALUES (4873, 'Woman Pants model 1', 'Female', 'Pants', 'deep black', 'XL', 77, 145);
INSERT INTO products VALUES (9929, 'Woman Pants model 1', 'Female', 'Pants', 'red neon', 'S', 77, 149);
INSERT INTO products VALUES (1942, 'Woman Pants model 1', 'Female', 'Pants', 'red neon', 'M', 77, 72);
INSERT INTO products VALUES (3990, 'Woman Pants model 1', 'Female', 'Pants', 'red neon', 'L', 77, 212);
INSERT INTO products VALUES (6074, 'Woman Pants model 1', 'Female', 'Pants', 'white', 'XS', 77, 143);
INSERT INTO products VALUES (5713, 'Woman Pants model 1', 'Female', 'Pants', 'white', 'S', 77, 118);
INSERT INTO products VALUES (6222, 'Woman Pants model 1', 'Female', 'Pants', 'white', 'M', 77, 202);
INSERT INTO products VALUES (1549, 'Woman Pants model 1', 'Female', 'Pants', 'white', 'L', 77, 76);
INSERT INTO products VALUES (3370, 'Woman Pants model 1', 'Female', 'Pants', 'white', 'XL', 77, 192);
INSERT INTO products VALUES (7797, 'Woman Pants model 1', 'Female', 'Pants', 'white', 'XXL', 77, 46);
INSERT INTO products VALUES (4044, 'Woman Pants model 2', 'Female', 'Pants', 'deep black', 'XS', 94.6, 235);
INSERT INTO products VALUES (9011, 'Woman Pants model 2', 'Female', 'Pants', 'deep black', 'S', 94.6, 31);
INSERT INTO products VALUES (9463, 'Woman Pants model 2', 'Female', 'Pants', 'deep black', 'M', 94.6, 16);
INSERT INTO products VALUES (3385, 'Woman Pants model 2', 'Female', 'Pants', 'deep black', 'L', 94.6, 133);
INSERT INTO products VALUES (8754, 'Woman Pants model 2', 'Female', 'Pants', 'deep black', 'XL', 94.6, 125);
INSERT INTO products VALUES (8020, 'Woman Pants model 2', 'Female', 'Pants', 'deep black', 'XXL', 94.6, 198);

DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    sales_order_id SERIAL PRIMARY KEY,
    order_date date NOT NULL,
    due_date date NOT NULL,
    status character(20) NOT NULL,
    sales_order_number character(10) NOT NULL,
    user_id integer NOT NULL,
    total_due integer NOT NULL

);

INSERT INTO orders VALUES (1, '2020-07-21', '2020-08-25', 'submited', 'SO44102', 2, 30);
INSERT INTO orders VALUES (2, '2020-07-21', '2020-08-25', 'shipped', 'SO44114', 2, 15);
INSERT INTO orders VALUES (3, '2020-07-22', '2020-08-26', 'shipped', 'SO44147', 3, 20);
INSERT INTO orders VALUES (4, '2020-07-23', '2020-08-26', 'submited', 'SO44153', 12, 15);
SELECT pg_catalog.setval('orders_sales_order_id_seq', 4, true);

INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-06-21', '2020-07-21', 'shipped', 'SO43665', 13, 30);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-06-25', '2020-07-25', 'shipped', 'SO43671', 18, 20);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-05-21', '2020-06-21', 'shipped', 'SO43674', 15, 20);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-05-21', '2020-06-21', 'shipped', 'SO43678', 2, 14);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-05-21', '2020-06-25', 'shipped', 'SO43679', 6, 30);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-05-21', '2020-07-21', 'shipped', 'SO43680', 9, 20);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-25', 'shipped', 'SO43687', 11, 25);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-25', 'shipped', 'SO43689', 11, 25);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-25', 'shipped', 'SO43700', 14, 22);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-25', 'shipped', 'SO43704', 18, 22);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-20', '2020-08-20', 'shipped', 'SO43713', 17, 22);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-19', '2020-06-19', 'shipped', 'SO43721', 3, 12);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-21', 'shipped', 'SO43731', 2, 12);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-30', '2020-08-21', 'confirmed', 'SO43741', 9, 17);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-04-21', '2020-05-21', 'shipped', 'SO43750', 9, 15);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-21', 'cancelled', 'SO43753', 9, 22);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-04-07', '2020-05-07', 'submited', 'SO43760', 7, 23);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-21', 'submited', 'SO43765', 2, 22);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-21', 'cancelled', 'SO43774', 13, 20);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-21', 'shipped', 'SO43785', 12, 30);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-29', '2020-08-29', 'shipped', 'SO43794', 13, 30);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-28', '2020-08-28', 'shipped', 'SO43804', 10, 30);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-21', 'shipped', 'SO43806', 10, 30);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-21', 'shipped', 'SO43811', 10, 25);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-30', '2020-08-30', 'shipped', 'SO43812', 9, 30);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-21', 'shipped', 'SO43820', 7, 20);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-06-21', '2020-07-21', 'shipped', 'SO43971', 3, 20);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-06-21', '2020-07-21', 'shipped', 'SO43974', 16, 30);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-06-21', '2020-07-21', 'shipped', 'SO43994', 15, 15);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-06-21', '2020-07-21', 'shipped', 'SO44019', 11, 30);

DROP TABLE IF EXISTS orderdetails;

CREATE TABLE orderdetails
(
    sales_order_detail_id SERIAL PRIMARY KEY,
    sales_order_id integer NOT NULL,
    qty integer NOT NULL,
    product_id integer NOT NULL,
    unit_price integer NOT NULL

);

INSERT INTO orderdetails VALUES (1, 2, 1, 4369, 30);
INSERT INTO orderdetails VALUES (2, 4, 1, 2679, 30);
INSERT INTO orderdetails VALUES (3, 1, 1, 9088, 30);
INSERT INTO orderdetails VALUES (4, 1, 1, 384, 30);







DROP TABLE IF EXISTS cart;

CREATE TABLE cart (
    user_id integer NOT NULL,
    product_id integer NOT NULL,
    quantity integer NOT NULL
);

INSERT INTO cart VALUES (2, 8323, 1);
INSERT INTO cart VALUES (2, 4253, 2);
INSERT INTO cart VALUES (5, 5486, 1);
INSERT INTO cart VALUES (6, 803, 4);

