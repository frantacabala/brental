INSERT INTO Zamestnanec
        (jmeno, prijmeni, login,heslo,pracovni_pozice,ulice,mesto,psc)
VALUES
  ('Franta', 'Novak', 'fnovak',  'frantisekjenejlepsi','ridic','U Vyvorané myši 27','Praha',16000),
  ('Adela', 'Kohoutova', 'akohout', 'adelajede', 'operatorka','U Vyvorané myši 27','Praha',16000),
  ('Jan', 'Novotny', 'jnovotny', 'asdfghjkl', 'ridic','U Vyvorané myši 27','Praha',16000);  


INSERT INTO Kontrolni_bod
        (nazev, reka, km_reky)
VALUES
  ('Lipno', 'Vltava', 5 ),
  ('Český Krumlov', 'Vltava', 25 ),
  ('Praha', 'Vltava', 80 );


INSERT INTO Auto
        (SPZ, platnost_TK, lode_kapacita, datum_zakoupeni, cena_zakopeni)
VALUES
        ( 'AKR5489', '2014-01-01', 2, '2008-01-01', 259000  ),
        ( 'AHA1354', '2014-05-12', 3, '2008-01-01', 259000  ),
        ( 'UHA4643', '2014-04-01', 3, '2010-01-01', 299000  ),
        ( 'ASD4522', '2014-09-01', 5, '2012-01-01', 199000  );

INSERT INTO Zakaznik
        (jmeno, prijmeni, ulice,mesto,psc, cislo_op)
VALUES
        ('Jan', 'Kulišák', 'U Vyvorané myši 27','Praha',16000, 22222),
        ('Karel', 'Vomáčka', 'Na smetaně 569','Praha',16000, 555555),
        ('Lukáš', 'Heger', 'Lopatova 31','Praha',16000, 77777);

INSERT INTO Typ_vybaveni
        (nazev, vaha, barva, cena_za_pujceni_den)
VALUES
        ('Padlo RX2', 2.5, 'růžová', 20),
        ('Kanoe Pálava', 10, 'šmoulová', 150),
        ('AlaD', 50, 'strakatá', 1),
        ('Myšák', 100, 'vyblitá', 5),
        ('Titanic', 20, 'fialová', 3599),
        ('Čupr vestička', 0.5, 'červená', 10);

INSERT INTO Padlo 
        (padloID, delka, sirka_listu, typ)
VALUES
        ((SELECT typ_vybaveniID FROM Typ_vybaveni WHERE nazev = 'Padlo RX2' LIMIT 1), 153.5, 37.2, 'pádlo obouruční' ),
        ((SELECT typ_vybaveniID FROM Typ_vybaveni WHERE nazev = 'Myšák' LIMIT 1), 80.27,30.02, 'pádlo s listem ve tvaru Mickey Mouse' );


INSERT INTO Lod
        (lodID, delka, sirka, max_ponor, nosnost_osob, typ, vyrobce, model)
VALUES
        ((SELECT typ_vybaveniID FROM Typ_vybaveni WHERE nazev = 'Kanoe Pálava' LIMIT 1),
         258, 75, 30, 2, 'Kanoe', 'Voko s.r.o.', 'KP07' ),
        ((SELECT typ_vybaveniID FROM Typ_vybaveni WHERE nazev = 'AlaD' LIMIT 1),
         300, 100, 2, 3, 'Ponorka', 'Díra v lodi s.r.o.', 'PORKAS32' ),
        ((SELECT typ_vybaveniID FROM Typ_vybaveni WHERE nazev = 'Titanic' LIMIT 1),
         300, 200, 20, 2, 'Šlapadlo', 'Lodní výroba ČSR', 'KEDNU13' );

INSERT INTO Vesta
        (vestaID, velikost, typ, vyrobce)
VALUES
        ((SELECT typ_vybaveniID FROM Typ_vybaveni WHERE nazev = 'Čupr vestička' LIMIT 1),
         35.5, 'pro psy', 'Vesty Tonoucí a syn');

INSERT INTO Vybaveni
        (typ_vybaveniID, cena_zakoupeni, datum_zakoupeni, evid_cislo)
VALUES
        (
                (SELECT typ_vybaveniID FROM Typ_vybaveni WHERE nazev='Titanic' LIMIT 1),
                299,
                DATE('1912-4-15'),
                '549GSHODF7820435SG87H3'
        ),
        (
                (SELECT typ_vybaveniID FROM Typ_vybaveni WHERE nazev='Titanic' LIMIT 1),
                299,
                DATE('1912-4-15'),
                '549GSHODF7a20435SG87H3'
        ),
        (
                (SELECT typ_vybaveniID FROM Typ_vybaveni WHERE nazev='Myšák' LIMIT 1),
                199,
                DATE('1912-4-15'),
                '3498UC239T8U2435T-2V9A'
        ),
        (
                (SELECT typ_vybaveniID FROM Typ_vybaveni WHERE nazev='Čupr vestička' LIMIT 1),
                19800,
                DATE('2012-5-1'),
                'A290VMWPG982S-VMEJT9V'
        ),
        (
                (SELECT typ_vybaveniID FROM Typ_vybaveni WHERE nazev='AlaD' LIMIT 1),
                0,
                DATE('1993-5-1'),
                '03B92-QERULCMWOIVNWL'
        ),
        (
                (SELECT typ_vybaveniID FROM Typ_vybaveni WHERE nazev='Padlo RX2' LIMIT 1),
                133,
                DATE('2001-6-11'),
                '03B92-QERULCMWOIASWL'
        ),
        (
                (SELECT typ_vybaveniID FROM Typ_vybaveni WHERE nazev='Padlo RX2' LIMIT 1),
                133,
                DATE('2001-6-11'),
                '03B92-AASDFKMVASPOF'
        ),
        (
                (SELECT typ_vybaveniID FROM Typ_vybaveni WHERE nazev='Padlo RX2' LIMIT 1),
                13334,
                DATE('2001-6-11'),
                '84KFVNWODKV94820DK'
        );

INSERT INTO Rezervace
        (od_data, do_data, potvrzena, kontrolni_bodID, zamestnanecID, zakaznikID)
VALUES
        (
                DATE('2013-11-3'), 
                DATE('2013-11-5'), 
                FALSE, 
                (SELECT kontrolni_bodID FROM Kontrolni_bod WHERE nazev='Lipno' LIMIT 1),
                (SELECT zamestnanecID FROM Zamestnanec WHERE jmeno='Franta' LIMIT 1),
                (SELECT zakaznikID FROM Zakaznik WHERE prijmeni='Kulišák' LIMIT 1)
        ), 
        (
                DATE('2007-1-3'), 
                DATE('2012-4-5'), 
                FALSE, 
                (SELECT kontrolni_bodID FROM Kontrolni_bod WHERE nazev='Praha' LIMIT 1),
                (SELECT zamestnanecID FROM Zamestnanec WHERE jmeno='Adela' LIMIT 1),
                (SELECT zakaznikID FROM Zakaznik WHERE prijmeni='Lukáš' LIMIT 1)
        );

INSERT INTO Je_rezervovano
        (rezervaceID, vybaveniID)
VALUES
        (
                (SELECT rezervaceID from Rezervace WHERE od_data = DATE('2007-1-3') LIMIT 1),
                (SELECT vybaveniID from Vybaveni WHERE evid_cislo = '549GSHODF7820435SG87H3' LIMIT 1)
        ),
        (
                (SELECT rezervaceID from Rezervace WHERE od_data = DATE('2007-1-3') LIMIT 1),
                (SELECT vybaveniID from Vybaveni WHERE evid_cislo = '549GSHODF7a20435SG87H3' LIMIT 1)
        ),
        (
                (SELECT rezervaceID from Rezervace WHERE od_data = DATE('2013-11-3') LIMIT 1),
                (SELECT vybaveniID from Vybaveni WHERE evid_cislo = '3498UC239T8U2435T-2V9A' LIMIT 1)
        ),
        (
                (SELECT rezervaceID from Rezervace WHERE od_data = DATE('2013-11-3') LIMIT 1),
                (SELECT vybaveniID from Vybaveni WHERE evid_cislo = 'A290VMWPG982S-VMEJT9V' LIMIT 1)
        ),
        (
                (SELECT rezervaceID from Rezervace WHERE od_data = DATE('2013-11-3') LIMIT 1),
                (SELECT vybaveniID from Vybaveni WHERE evid_cislo = '03B92-QERULCMWOIVNWL' LIMIT 1)
        );
