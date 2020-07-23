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

