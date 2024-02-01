CREATE TABLE IF NOT EXISTS "CustomerTable" (
    "CustomerID"    TEXT NOT NULL,
    "CustomerFN"    TEXT NULL,
    "CustomerLN"    TEXT NULL,
    "CustomerEmail" TEXT NULL,
    "CustomerStreetLine"    TEXT NULL,
    "CustomerCity"  TEXT NULL,
    "CustomerPostCode"  TEXT NULL,
   PRIMARY KEY("CustomerID")
);

INSERT INTO "CustomerTable" VALUES ('555444','John','Marsh','JM@Yahoo.com','22 StreetWise','TheStreetCity','SC1 22A5');
INSERT INTO "CustomerTable" VALUES ('111222','Rachel','Stars','RS2@cdcfe.ie','11 Road','RoadManCity','RMC 7F29');
INSERT INTO "CustomerTable" VALUES ('694832','Robert','Garfield','RG@gmail.com','492 Kilmore rd','Dublin','D17 S8J9');
INSERT INTO "CustomerTable" VALUES ('453231','Amy','O Reily','AOR@Yahoo.com','321 Artane Rd.','Dublin','D05 D32F');
INSERT INTO "CustomerTable" VALUES ('333999','V','Chan','VC@Cyber.net','354 GoodVile Ave.','NightCity','NCS B125');
INSERT INTO "CustomerTable" VALUES ('564427','Molly','Mccan','MM@Mirco.co.uk','32 Donaghmede Ln.','Dublin','D13 4DF4');
INSERT INTO "CustomerTable" VALUES ('354221','Polly','Banks','PBG@yahoo.co.uk','243 swords ln.','Dublin','D18 r469');
INSERT INTO "CustomerTable" VALUES ('363234','Violet','Myres','VM@Gmail.com','45 Batman Ave.','America','BMA 4V11');
INSERT INTO "CustomerTable" VALUES ('444888','Jessica','Jones','JJKSI@yahoo.co.uk','545 Goodyman St.','GOODMAN','GOM 342G');
INSERT INTO "CustomerTable" VALUES ('777909','Davey','Stars','DS@gmail.com','11 Road','RoadManCity','RMC 7F29');


CREATE TABLE IF NOT EXISTS "CustomerCreditCard" (
	"CustomerCreditCardNum"	varchar NOT NULL,
	"CustomerCreditCardName"	varchar,
	"CustomerCreditCardExpDate"	varchar,
	"CustomerID" TEXT, 
        PRIMARY KEY("CustomerCreditCardNum")
        FOREIGN KEY ("CustomerID") REFERENCES CustomerTable("CustomerID")
);

INSERT INTO "CustomerCreditCard" VALUES ('4444 2222 0000 1111','John Marsh','02/27','555444');
INSERT INTO "CustomerCreditCard" VALUES ('0000 6666 3333 2222','Rachel Stars','03/23','111222');
INSERT INTO "CustomerCreditCard" VALUES ('4682 2346 1357 2569','Robert Garfield','05/22', '694832');
INSERT INTO "CustomerCreditCard" VALUES ('5678 1122 3421 9999','Amy O Reily','09/25', '453231');
INSERT INTO "CustomerCreditCard" VALUES ('3521 2342 3532 7685','V Chan','08/77', '333999');
INSERT INTO "CustomerCreditCard" VALUES ('4562 2121 3332 3241','Molly Mccan','02/23', '564427');
INSERT INTO "CustomerCreditCard" VALUES ('3421 3552 2421 3699','Polly Banks','10/24','354221');
INSERT INTO "CustomerCreditCard" VALUES ('7777 8888 9999 3333','Violet Myres','12/25','363234');
INSERT INTO "CustomerCreditCard" VALUES ('9999 9808 4747 3434','Jessica Jones','11/24', '444888');
INSERT INTO "CustomerCreditCard" VALUES ('5555 2222 1111 4559','Davey Stars','04/23', '777909');




CREATE TABLE IF NOT EXISTS "ProductTable" (
	"ProductID"	TEXT NOT NULL,
	"ProductName" TEXT,
        "ProductCost" TEXT,  
	"ProductExpDate" TEXT,
	"ProductQty" TEXT,
	"ProductDescription" TEXT,
	"ProductCategory" TEXT,
	PRIMARY KEY("ProductID")
);

INSERT INTO "ProductTable" VALUES ('30442', ' TopsPotato', '2.50£', '21/11/22' , '50', 'text', 'root');
INSERT INTO "ProductTable" VALUES ('10333', 'M&B', '1.20£', '10/11/22 ', '30', 'text', 'root');
INSERT INTO "ProductTable" VALUES ('47718',  'Bananas', '1£',  '22/11/21', '60',  'bananas are good for you', 'exotic');
INSERT INTO "ProductTable" VALUES ('23142', 'Carrots', '80c', '23/11/23', '90', 'good for your eyes', 'root');
INSERT INTO "ProductTable" VALUES ('12312', 'brussels', '100c', '31/04/23', '80', 'good iron', 'root');
INSERT INTO "ProductTable" VALUES ('54312', 'cabbage', '60c', '22/02.23', '10', 'text', 'roots');
INSERT INTO "ProductTable" VALUES ('78912', 'cauliflower', '95c', '22/01/23', '48', 'taste good', 'root');
INSERT INTO "ProductTable" VALUES ('23311', 'Strawberries', '50c', '22/03/23', '21', 'good source of vitamins', 'bush');
INSERT INTO "ProductTable" VALUES ('22222', 'pears', '43c', '14/02/23', '60', 'good', 'tree');
INSERT INTO "ProductTable" VALUES ('22211', 'mango', '56c', '23/04/23', '98', 'great for smoothies', 'exotic'); 
INSERT INTO "ProductTable" VALUES ('1001','Apple','24c', '22/02/23', '451', 'keeps the doctor away', 'tree');
INSERT INTO "ProductTable" VALUES ('1003' ,'grape','57c', '31/04/23', '242', 'fresh', 'tree');
INSERT INTO "ProductTable" VALUES ('1004','kiwi','58c', '25/03/23', '688', 'kiwi good for you', 'exotic');
INSERT INTO "ProductTable" VALUES ('1005','orange','58c', '15/04/23', '450', 'Vitamin c to stop scruvy', 'exotic');
                




CREATE TABLE IF NOT EXISTS "ColleagueTable" (
	"ColleagueID"	TEXT NOT NULL,
	"ColleagueName"	TEXT,
	"ColleagueAddress"  TEXT,
	"ColleaguePostCode"	TEXT,
	"ColleagueDOB"	TEXT,
	"ColleagueEmail"    TEXT,
	"ColleaguePhoneNum" TEXT,
	PRIMARY KEY("ColleagueID")
);

INSERT INTO "ColleagueTable" VALUES ('66978','Gon Freecss','129 NoWhere St., HustleTimeSq.','NW 4K22','11/09/97','GF@NOGF.uk','7878889090');
INSERT INTO "ColleagueTable" VALUES ('77898','Derick Shmuel','13 Coolock Ln., Dublin','D17 33H9','22/07/89','DB@cdcfe.ie','0817278899');
INSERT INTO "ColleagueTable" VALUES ('34126','Rachel Beans','33 dublin rd., Dublin','D2 33R1','13/02/92','RB@Yahoo.ie','414 222 1111');
INSERT INTO "ColleagueTable" VALUES ('22124','Connor Rivers','18 Cork bine, Cork','CC 14CP','31/10/1989','CR@gmail.com','333 215 7898');
INSERT INTO "ColleagueTable" VALUES ('45629','Derick Ryhmes','49 hel park, Dublin','D7 5h9P','30/03/2000','DR@GGG.com','657 282 2013');
INSERT INTO "ColleagueTable" VALUES ('33912','Rick Chimes','345 Carlton Ipad st., Tippeary','CI 4A32','22/02/1975','RG@cloud.com','999 343 2101');
INSERT INTO "ColleagueTable" VALUES ('45321','Cahoo Moo','32 Farway, Belfast','FF 4D31','12/10/96','Cah@yahoo.co.uk','545 432 5678');
INSERT INTO "ColleagueTable" VALUES ('56735','Mary Fairy','29 London st, Belfast','LB 3GF3','23/12/89','MF@gmail.com','322 212 4681');
INSERT INTO "ColleagueTable" VALUES ('45728','Sherry Woman','34 London st, Belfast','LB 47G1','22/09/99','SW@micro.com','898 377 2121');
INSERT INTO "ColleagueTable" VALUES ('11115','Far Gar','11 Tokyo ave, Kerry','KI 56T1','12/09/95','FarG@gmail.com','346 241 4544');


Create table AdminTable( 
"AdminID" varchar, 
"AdminName" varchar, 
"AdminAddress" varchar,  
"AdminPostCode" varchar, 
"AdminDOB" varchar, 
"AdminEmail" varchar,  
"AdminPhoneNum" varchar, 
PRIMARY KEY (AdminID)); 

INSERT INTO "AdminTable" VALUES ('2121', 'Dave Fang', '22 HustleRd., HustleTimeSq', 'HT 3P6O', '22/02/98', 'Dave@AD.ie ', '222 444 9809' );
INSERT INTO "AdminTable" VALUES ('0909 ', 'Daisy Jam ', '98 Time Ave., HustleTimeSq.', 'HT 2T9A', '10/04/99', 'DJ10@Bing.ie', '999 777 8080');
INSERT INTO "AdminTable" VALUES ('3452', 'Rachel Hynes', '34 dublin rd., Dublin', 'D2 D3R1', '10/02/91', 'RH@Yahoo.ie', '444 222 1111');
INSERT INTO "AdminTable" VALUES ('2234', 'Connor Dune', '11 Cork pine, Cork', 'CC 44CP', '31/12/1989', 'CD@gmail.com', '333 212 7898');
INSERT INTO "AdminTable" VALUES ('4562', 'Derick Grimes', '45 hel park, Norway', 'NH 5h9P', '30/03/2001', 'DG@GGG.com', '657 242 2313');
INSERT INTO "AdminTable" VALUES ('3421', 'Rick Grimes', '345 Carlton Ipad st., America', 'CI 4A32', '22/02/1975', 'RG@cloud.com', '999 343 2121');
INSERT INTO "AdminTable" VALUES ('4532', 'Yahoo Boo', '32 Farway, Finland', 'FF 4D21', '12/12/96', 'Yah@yahoo.co.uk', '545 432 5678');
INSERT INTO "AdminTable" VALUES ('5673', 'Mary Berry', '22 London st, Belfast', 'LB 35F3', '23/09/89', 'MB@gmail.com', '322 212 4681');
INSERT INTO "AdminTable" VALUES ('4572', 'Cherry Man', '34 London st, Belfast', 'LB 47G1', '22/09/89', 'CH@micro.com', '898 377 2121');
INSERT INTO "AdminTable" VALUES ('1111', 'Gar Far', '11 Tokyo ave, Japan', 'TA 56T1', '12/09/99', 'GarF@gmail.com', '346 211 4544'); 


Create Table IF NOT EXISTS "OrderTable"(
"OrderID" Text Null,
"ProductID" TEXT, 
"QTY"   Int,
"Price" int,
"PurchaseDate" TEXT,
FOREIGN KEY ("ProductID") REFERENCES ProductTable("ProductID"),
Primary KEY ("OrderID"));


INSERT INTO "OrderTable" VALUES ('3442', '30442', '1', '2.50£', '31/04/22');

Create Table IF NOT EXISTS "PreviousOrder"(
"OrderID" int  null,
"ProductID" TEXT, 
"QTY"   Int,
"Price" int,
"PurchaseDate" TEXT null,
FOREIGN KEY ("ProductID") REFERENCES ProductTable("ProductID"),
Primary KEY ("OrderID"));

INSERT INTO "PreviousOrder" VALUES ('3242', '1001', '1', '24c', '31/04/21');
INSERT INTO "PreviousOrder" VALUES ('4532', '1005', '1', '58c', '31/04/21');
INSERT INTO "PreviousOrder" VALUES ('9999', '22211', '1', '56c', '31/04/21');
INSERT INTO "PreviousOrder" VALUES ('3333', '54312', '1', '60c', '29/04/20');
INSERT INTO "PreviousOrder" VALUES ('4444', '1001', '1', '2.50£', '31/04/21');
INSERT INTO "PreviousOrder" VALUES ('1111', '1001', '1', '2.50£', '31/04/21');
INSERT INTO "PreviousOrder" VALUES ('5555', 'grape', '1', '57c', '31/04/21');
INSERT INTO "PreviousOrder" VALUES ('8975', '1001', '1', '2.50£', '30/04/21');
INSERT INTO "PreviousOrder" VALUES ('3475', '1001', '1', '2.50£', '29/04/20');
INSERT INTO "PreviousOrder" VALUES ('13242', '1004', '1', '58c', '29/04/21');
INSERT INTO "PreviousOrder" VALUES ('23242', '1003', '1', '57c£', '31/04/21');




