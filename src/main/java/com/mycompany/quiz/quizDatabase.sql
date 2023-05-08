create database quiz;
use quiz;
create table ranking(
	Id int auto_increment,
    Name varchar(20),
    points int ,
    percentage float,
    primary key(Id)
);

create table questions(
	quest_no int auto_increment,
    question varchar(500),
    answer varchar(200),
    guess1 varchar(200),
    guess2 varchar(200),
    guess3 varchar(200),
    guess4 varchar(200),
    primary key(quest_no)
);

insert into questions values(null ,"What is 150 divided by 5?","C","20"," 25","30","35");
insert into questions values(null ,"Which of the following is the national animal of India?","B","Lion"," Tiger","Elephant","Rhinoceros");
insert into questions values(null ,"6500 + 500 + 250 + 90 + 5 = ","B","7300"," 7345","7500","7545");
insert into questions values(null ,"When do we celebrate Indian Independence day?","D","15th January"," 26th January","26th August","15th August");
insert into questions values(null ,"Katie's birthday is in 51 weeks and 2 days, how many days are there untill Katie's birthday?","C","350"," 360","359","369");
insert into questions values(null ,"Which of the following month has 31 days?","A","October"," February","June","April");
insert into questions values(null ,"What is 11 11 ?","A","121"," 131","141","151");
insert into questions values(null ,"Young cat is also called?","B","Calf"," Kitten","Puppy","Cub");
insert into questions values(null ,"What is 100 - 151 ?","A","-51"," 51","None","IDK");
insert into questions values(null ,"Kuchipuddi is the dance form of which state?","B","Tail Nadu"," Andra Pradesh","Karnataka","Kerala");
insert into questions values(null ,"What number must you add to 79 make the sum of 121?","D","40"," 41","43","42");
insert into questions values(null ,"Who invented Computer?","D","Thomas Alva Edison"," Pascal","Alexander Graham Bell","Charles Babbage");
insert into questions values(null ,"How many degrees is the right angle?","C","80"," 180","90","360");
insert into questions values(null ,"Gir National park in Gujarat is famous for?","C","Elephant"," Rhinncerus","Lion","Tiger");
insert into questions values(null ,"The surface area of a sphere of radius 7cm is ___cm.sq.?","A","616"," 150","165","151");
insert into questions values(null ,"Highest dam of India is?","D","Hirakud Dam"," Idukki Dam","Bakra Nangal Dam","Tehri Dam");
insert into questions values(null ,"In a triangle if angle A is 45 degrees and angle B is 90, how much degrees is angle C?","B","35"," 45","55","65");
insert into questions values(null ,"Agra is situated on the bank of river?","B","Ganga"," Yamuna","Narmada","Gomti");
insert into questions values(null ,"Amy has 200 balloons, 25 percent of the balloons are green,10 percent are orange and the remaining are blue .Can you work out how many blue balloons Amy has?","A","130"," 140","120","110");
insert into questions values(null ,"Cataract is the  disease of?","C","Ears"," Lungs","Eyes","Heart");
insert into questions values(null ,"The volume of water completely filled in a cylinder of height 7cm and radius 8cm is ___cm.sq?","A","1408"," 1508","1608","1708");       
insert into questions values(null ,"Capital of Uttarkhand is?","C","Lucknow"," Allahabad","Dehradun","Ranchi");
insert into questions values(null ,"If there are 23 boys and 21 girls in class A and 21 boys and 27 girls in class B,how many girls and boys in total are there?","B","91"," 92","93","94");
insert into questions values(null ,"Hitler party which came into power in 1933 was known as?","B","Labour party"," Nazi party","Ku-Klux-Klan","Democratic party");
insert into questions values(null ,"Which is the first product of two odd prime numbers?","B","13"," 15","17","11");
insert into questions values(null ,"Longest river in the world is?","D","Amazon"," South-China sea","Ganga","Nile");
insert into questions values(null ,"Which of the following number is completely divisible by 2,3,4, and 5?","C","1000"," 1100","1200","1300");
insert into questions values(null ,"LBW is related to which sports?","D","Football"," Hockey","Badminton","Cricket");
insert into questions values(null ,"Your mom is in the market, she bought 22kg of fish and 24kg of chicken, you ate 12kg of chicken and 4kg of fish,how many kg in total is 
left of the the two foods?","D","24"," 26","28","30");
insert into questions values(null ,"Which of the following is an example of an output device of a computer?","A","Printer"," Keyboard","Scanner","Mouse");
insert into questions values(null ,"Which company created Java?","A","Sun Microsystems"," Starbucks","Microsoft","Alphabet");
insert into questions values(null ,"Which year was Java created?","B","1989"," 1996","1972","1492");
insert into questions values(null ,"What was Java originally called?","C","Apple"," Latte","Oak","Koffing");
insert into questions values(null ,"Who is credited with creating Java?","C","Steve Jobs"," Bill Gates","James Gosling","Mark Zuckerburg");

select * from questions;
