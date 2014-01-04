SET FOREIGN_KEY_CHECKS=0;



DROP TABLE IF EXISTS Auto
;
DROP TABLE IF EXISTS Faktura
;
DROP TABLE IF EXISTS Je_rezervovano
;
DROP TABLE IF EXISTS Kontrolni_bod
;
DROP TABLE IF EXISTS Lod
;
DROP TABLE IF EXISTS Padlo
;
DROP TABLE IF EXISTS Rezervace
;
DROP TABLE IF EXISTS Typ_vybaveni
;
DROP TABLE IF EXISTS Vesta
;
DROP TABLE IF EXISTS Vybaveni
;
DROP TABLE IF EXISTS Zakaznik
;
DROP TABLE IF EXISTS Zamestnanec
;

CREATE TABLE Auto
(
        cena_zakopeni DOUBLE NOT NULL,
        datum_zakoupeni DATE NOT NULL,
        lode_kapacita INTEGER NOT NULL,
        platnost_TK DATE,
        SPZ VARCHAR(7) NOT NULL,
        autoID INTEGER NOT NULL AUTO_INCREMENT,
        PRIMARY KEY (autoID)
) 
;


CREATE TABLE Faktura
(
        cislo INTEGER NOT NULL,
        soubor VARCHAR(255),
        splatnost DATE NOT NULL,
        vystaveni DATE NOT NULL,
        fakturaID INTEGER NOT NULL AUTO_INCREMENT,
        zamestnanecID INTEGER,
        PRIMARY KEY (fakturaID),
        KEY (zamestnanecID)
) 
;


CREATE TABLE Je_rezervovano
(
        rezervaceID INTEGER,
        vybaveniID INTEGER,
        KEY (rezervaceID),
        KEY (vybaveniID)
) 
;


CREATE TABLE Kontrolni_bod
(
        km_reky DOUBLE NOT NULL,
        nazev VARCHAR(50),
        reka VARCHAR(50),
        kontrolni_bodID INTEGER NOT NULL AUTO_INCREMENT,
        PRIMARY KEY (kontrolni_bodID)
) 
;


CREATE TABLE Lod
(
        delka DOUBLE NOT NULL,
        max_ponor DOUBLE NOT NULL,
        model VARCHAR(50) NOT NULL,
        nosnost_osob INTEGER NOT NULL,
        sirka DOUBLE NOT NULL,
        typ VARCHAR(50) NOT NULL,
        vyrobce VARCHAR(50) NOT NULL,
        lodID INTEGER NOT NULL,
        PRIMARY KEY (lodID)
) 
;


CREATE TABLE Padlo
(
        delka DOUBLE NOT NULL,
        sirka_listu DOUBLE NOT NULL,
        typ VARCHAR(50) NOT NULL,
        padloID INTEGER NOT NULL,
        PRIMARY KEY (padloID)
) 
;


CREATE TABLE Rezervace
(
        do_data DATE NOT NULL,
        od_data DATE NOT NULL,
        potvrzena BOOL NOT NULL,
        rezervaceID INTEGER NOT NULL AUTO_INCREMENT,
        fakturaID INTEGER,
        kontrolni_bodID INTEGER,
        zamestnanecID INTEGER,
        zakaznikID INTEGER,
        PRIMARY KEY (rezervaceID),
        KEY (fakturaID),
        KEY (kontrolni_bodID),
        KEY (kontrolni_bodID),
        KEY (zamestnanecID),
        KEY (zakaznikID)
) 
;


CREATE TABLE Typ_vybaveni
(
        barva VARCHAR(15) NOT NULL,
        cena_za_pujceni_den DOUBLE NOT NULL,
        nazev VARCHAR(50) NOT NULL,
        vaha DOUBLE NOT NULL,
        typ_vybaveniID INTEGER NOT NULL AUTO_INCREMENT,
        PRIMARY KEY (typ_vybaveniID)
) 
;


CREATE TABLE Vesta
(
        typ VARCHAR(50) NOT NULL,
        velikost DOUBLE NOT NULL,
        vyrobce VARCHAR(50) NOT NULL,
        vestaID INTEGER NOT NULL,
        PRIMARY KEY (vestaID)
) 
;


CREATE TABLE Vybaveni
(
        cena_zakoupeni DOUBLE,
        datum_zakoupeni DATE,
        evid_cislo VARCHAR (100) NOT NULL,
        vybaveniID INTEGER NOT NULL AUTO_INCREMENT,
        typ_vybaveniID INTEGER,
        PRIMARY KEY (vybaveniID),
        KEY (typ_vybaveniID)
) 
;


CREATE TABLE Zakaznik
(
        adresa VARCHAR(150),
        cislo_op long,
        jmeno VARCHAR(50) NOT NULL,
        prijmeni VARCHAR(50) NOT NULL,
        zakaznikID INTEGER NOT NULL AUTO_INCREMENT,
		ulice VARCHAR (100) NOT NULL,
		mesto VARCHAR (100) NOT NULL,
		psc INTEGER NOT NULL,
        PRIMARY KEY (zakaznikID)
) 
;


CREATE TABLE Zamestnanec
(
        heslo VARCHAR(50) NOT NULL,
        jmeno VARCHAR(50) NOT NULL,
        login VARCHAR(50) NOT NULL,
        pracovni_pozice VARCHAR(50) NOT NULL,
		ulice VARCHAR (100) NOT NULL,
		mesto VARCHAR (100) NOT NULL,
		psc INTEGER NOT NULL,
        prijmeni VARCHAR(50) NOT NULL,
        zamestnanecID INTEGER NOT NULL AUTO_INCREMENT,
        PRIMARY KEY (zamestnanecID)
) 
;



SET FOREIGN_KEY_CHECKS=1;


ALTER TABLE Faktura ADD CONSTRAINT Vystavil 
        FOREIGN KEY (zamestnanecID) REFERENCES Zamestnanec (zamestnanecID)
;

ALTER TABLE Je_rezervovano ADD CONSTRAINT Rezervace 
        FOREIGN KEY (rezervaceID) REFERENCES Rezervace (rezervaceID)
;

ALTER TABLE Je_rezervovano ADD CONSTRAINT Vybaveni 
        FOREIGN KEY (vybaveniID) REFERENCES Vybaveni (vybaveniID)
;

ALTER TABLE Lod ADD CONSTRAINT FK_Lod_Typ_vybaveni 
        FOREIGN KEY (lodID) REFERENCES Typ_vybaveni (typ_vybaveniID)
;

ALTER TABLE Padlo ADD CONSTRAINT FK_Padlo_Typ_vybaveni 
        FOREIGN KEY (padloID) REFERENCES Typ_vybaveni (typ_vybaveniID)
;

ALTER TABLE Rezervace ADD CONSTRAINT Je_fakturovana 
        FOREIGN KEY (fakturaID) REFERENCES Faktura (fakturaID)
;

ALTER TABLE Rezervace ADD CONSTRAINT Do_bodu 
        FOREIGN KEY (kontrolni_bodID) REFERENCES Kontrolni_bod (kontrolni_bodID)
;

ALTER TABLE Rezervace ADD CONSTRAINT Od_bodu 
        FOREIGN KEY (kontrolni_bodID) REFERENCES Kontrolni_bod (kontrolni_bodID)
;

ALTER TABLE Rezervace ADD CONSTRAINT Zadal 
        FOREIGN KEY (zamestnanecID) REFERENCES Zamestnanec (zamestnanecID)
;

ALTER TABLE Rezervace ADD CONSTRAINT Rezervuje 
        FOREIGN KEY (zakaznikID) REFERENCES Zakaznik (zakaznikID)
;

ALTER TABLE Vesta ADD CONSTRAINT FK_Vesta_Typ_vybaveni 
        FOREIGN KEY (vestaID) REFERENCES Typ_vybaveni (typ_vybaveniID)
;

ALTER TABLE Vybaveni ADD CONSTRAINT Je_typu 
        FOREIGN KEY (typ_vybaveniID) REFERENCES Typ_vybaveni (typ_vybaveniID)
;