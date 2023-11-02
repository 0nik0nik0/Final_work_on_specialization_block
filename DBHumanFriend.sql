## Create schema `humanFriendsdb`;
## drop schema `humanFriendsdb`;
use `humanFriendsdb`;

## Создать таблицы с иерархией из диаграммы в БД
create table cat (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);


create table dog (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);


create table hamster (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);



create table horse (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	liftWeight INT,
    Name VARCHAR(45),
    Command VARCHAR(45),
	Birthday DATE
);


create table camel (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	liftWeight INT,
    Name VARCHAR(45),
    Command VARCHAR(45),
	Birthday DATE
);


create table donkey (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	liftWeight INT,
    Name VARCHAR(45),
    Command VARCHAR(45),
	Birthday DATE
);

## Создаем таблицы видов животных
create table pet (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);


create table packAnimal (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);

## Создаем общую
create table humanFriend(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday Date
    );
    
## Заполнить низкоуровневые таблицы именами(животных), командами
   которые они выполняют и датами рождения
    
    insert into cat (Name, Command, Birthday) values
    ('Абрикос', 'Sleep', '2022-01-01'),
    ('Анфиса', 'Sleep', '2017-06-06'),
	('Арчибальд', 'Sleep', '2023-01-06'),
    ('Арго', 'Sleep', '2021-03-17');
    
    select * from cat;

    insert into dog (Name, Command, Birthday) values
    ('Барс', 'Lie', '2022-01-01'),
    ('Бегемот', 'Lie', '2017-06-06'),
	('Белянка', 'Lie', '2023-01-06'),
    ('Берендей', 'Lie', '2021-03-17');
	
    select * from dog;
 
	insert into hamster (Name, Command, Birthday) values
    ('Василий', 'Run', '2022-01-01'),
    ('Дунай', 'Run', '2017-06-06'),
	('Дымок', 'Run', '2023-01-06'),
    ('Кеша', 'Run', '2021-03-17');
	
    select * from hamster;
     
	insert into camel (camelName, camelCommand, camelBirthday) values
    ('Кузя', 'Raise', '2022-01-01'),
    ('Леопольд', 'Raise', '2017-06-06'),
	('Маркиз', 'Raise', '2023-01-06'),
    ('Мурзик', 'Raise', '2021-03-17');
	
    select * from camel;
     
	insert into horse (Name, Command, Birthday) values
    ('Муся', 'Gallop', '2022-01-01'),
    ('Персик', 'Gallop', '2017-06-06'),
	('Пушок', 'Gallop', '2023-01-06'),
    ('Рыжик', 'Gallop', '2021-03-17');
	
    select * from horse;    
     
	insert into donkey (Name, Command, Birthday) values
    ('Снежок', 'Chew', '2022-01-01'),
    ('Степан', 'Chew', '2017-06-06'),
	('Тимофей', 'Chew', '2023-01-06'),
    ('Тиша', 'Chew', '2021-03-17');
	
    select * from donkey;  	
 
 ## Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
    питомник на зимовку.

 delete from camel where id > 0;
 select * from camel;
 
## Объединить таблицы лошади, и ослы в одну таблицу.
create table packAnimalNew (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
select  Name, 
        Command, 
        Birthday
from horse union 
select  Name, 
        Command, 
        Birthday
from donkey;

select * from packAnimalNew;

## Создать новую таблицу “молодые животные” в которую попадут все
   животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
   до месяца подсчитать возраст животных в новой таблице

INSERT into pet (Name, Command, Birthday)
select  Name, 
        Command, 
        Birthday
from cat union 
select  Name, 
        Command, 
        Birthday
from dog union
select  Name, 
        Command, 
        Birthday
from hamster;
select * from pet;

INSERT into humanFriend (Name, Command, Birthday)
select  Name, 
        Command, 
        Birthday
from pet union 
select  Name, 
        Command, 
        Birthday
from packAnimalNew;
select * from humanFriend;

create table youngAnimals (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
select Name, 
        Command, 
        Birthday,
        Round((year(current_date()) - year(Birthday)) + (month(current_date() - month(Birthday)))/10, 2) as age
from humanFriend
where Round((year(current_date()) - year(Birthday)) + (month(current_date() - month(Birthday)))/10, 2) > 1 
	and Round((year(current_date()) - year(Birthday)) + (month(current_date() - month(Birthday)))/10, 2) < 3;
select * from youngAnimals;

## Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
   прошлую принадлежность к старым таблицам.

create table newhumanFriend (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
select  Name, 
        Command,
        Birthday,
        'cat' as oldTable
from cat union 
select  Name, 
        Command, 
        Birthday,
        'dog' as oldTable
from dog union
select  Name, 
        Command, 
        Birthday,
        'hamster' as oldTable
from hamster union 
select  Name, 
        Command, 
        Birthday,
        'horse' as oldTable
from horse union 
select  Name, 
        Command, 
        Birthday,
        'donkey' as oldTable
from donkey;

select * from newhumanFriend;

