CREATE TABLE `human_friends`.`animals`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `animal_id` Int,
  `animal_name` Varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
)
;
CREATE INDEX `animal_idx` ON `human_friends`.`animals` (`animal_id`)
;

CREATE TABLE `pets`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `pet_id` Int,
  `pet_name` Varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
)
;
CREATE INDEX `pet_idx` ON `pets` (`pet_id`)
;

CREATE TABLE `cats`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `cat_id` Int,
  `cat_name` Varchar(45) NOT NULL,
  `birth_date` Date NOT NULL,
  `death_date` Date,
  `commands` Varchar(255),
  PRIMARY KEY (`id`)
)
;
CREATE INDEX `cat_idx` ON `cats` (`cat_id`)
;

CREATE TABLE `dogs`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `dog_id` Int,
  `dog_name` Varchar(45) NOT NULL,
  `birth_date` Date NOT NULL,
  `death_date` Date,
  `commands` Varchar(255),
  PRIMARY KEY (`id`)
)
;
CREATE INDEX `dog_idx` ON `dogs` (`dog_id`)
;

CREATE TABLE `hamsters`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `hamster_id` Int,
  `hamster_name` Varchar(45) NOT NULL,
  `birth_date` Date NOT NULL,
  `death_date` Date,
  `commands` Varchar(255),
  PRIMARY KEY (`id`)
)
;
CREATE INDEX `hamster_idx` ON `hamsters` (`hamster_id`)
;

drop table `pack_animals`;
CREATE TABLE `pack_animals`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `pack_id` Int,
  `pack_name` Varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
)
;
CREATE INDEX `pack_idx` ON `pack_animals` (`pack_id`)
;

CREATE TABLE `horses`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `horse_id` Int,
  `horse_name` Varchar(45) NOT NULL,
  `birth_date` Date NOT NULL,
  `death_date` Date,
  `commands` Varchar(255),
  PRIMARY KEY (`id`)
)
;
CREATE INDEX `hourse_idx` ON `horses` (`horse_id`)
;

CREATE TABLE `camels`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `camel_id` Int,
  `camel_name` Varchar(45) NOT NULL,
  `birth_date` Date NOT NULL,
  `death_date` Date,
  `commands` Varchar(255),
  PRIMARY KEY (`id`)
)
;
CREATE INDEX `camel_idx` ON `camels` (`camel_id`)
;

CREATE TABLE `donkeys`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `donkey_id` Int,
  `donkey_name` Varchar(45) NOT NULL,
  `birth_date` Date NOT NULL,
  `death_date` Date,
  `commands` Varchar(255),
  PRIMARY KEY (`id`)
)
;
CREATE INDEX `donkey_idx` ON `donkeys` (`donkey_id`)
;

-- Create foreign keys (relationships) section -------------------------------------------------

ALTER TABLE `human_friends`.`pets` ADD CONSTRAINT `pets_to_animal` FOREIGN KEY (`pet_id`) REFERENCES `human_friends`.`animals` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;
-- ALTER TABLE `human_friends`.`pets` DROP FOREIGN KEY pets_to_animal

ALTER TABLE `human_friends`.`pack_animals` ADD CONSTRAINT `pack_to_animal` FOREIGN KEY (`pack_id`) REFERENCES `human_friends`.`animals` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;
-- ALTER TABLE `human_friends`.`pack_animals` DROP FOREIGN KEY pack_to_animal

ALTER TABLE `human_friends`.`cats` ADD CONSTRAINT `cat_to_pets` FOREIGN KEY (`cat_id`) REFERENCES `human_friends`.`pets` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;
-- ALTER TABLE `human_friends`.`cats` DROP FOREIGN KEY cat_to_pets

ALTER TABLE `human_friends`.`dogs` ADD CONSTRAINT `dog_to_pets` FOREIGN KEY (`dog_id`) REFERENCES `human_friends`.`pets` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;
-- ALTER TABLE `human_friends`.`dogs` DROP FOREIGN KEY dog_to_pets

ALTER TABLE `human_friends`.`hamsters` ADD CONSTRAINT `hamster_to_pets` FOREIGN KEY (`hamster_id`) REFERENCES `human_friends`.`pets` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;
-- ALTER TABLE `human_friends`.`hamsters` DROP FOREIGN KEY hamster_to_pets

ALTER TABLE `human_friends`.`camels` ADD CONSTRAINT `camel_to_pack` FOREIGN KEY (`camel_id`) REFERENCES `human_friends`.`pack_animals` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;
-- ALTER TABLE `human_friends`.`camels` DROP FOREIGN KEY camel_to_pack

ALTER TABLE `human_friends`.`horses` ADD CONSTRAINT `horse_to_pack` FOREIGN KEY (`horse_id`) REFERENCES `human_friends`.`pack_animals` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;
-- ALTER TABLE `human_friends`.`horses` DROP FOREIGN KEY horse_to_pack

ALTER TABLE `human_friends`.`donkeys` ADD CONSTRAINT `donkey_to_pack` FOREIGN KEY (`donkey_id`) REFERENCES `human_friends`.`pack_animals` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;
-- ALTER TABLE `human_friends`.`donkeys` DROP FOREIGN KEY donkey_to_pack


-- Insertions -------------------------------------------------------------------------
INSERT INTO `human_friends`.`animals`
(`animal_id`,`animal_name`)
VALUES
(1,"pets"),
(2,"pack_animals");
select * from `human_friends`.`animals`;

INSERT INTO `human_friends`.`pets`
(`pet_id`,`pet_name`)
VALUES
(1,"cats"),
(1,"dogs"),
(1,"hamsters");
select * from `human_friends`.`pets`;

INSERT INTO `human_friends`.`cats`
(`cat_id`,`cat_name`,`birth_date`,`death_date`,`commands`)
VALUES
(6,"Мурка",'2020-06-23',null,"лоток, прыжки"),
(6,"Мурзик",'2023-07-02',null,""),
(6,"Царь",'2021-05-05',null,"лоток, ночной тыгыдык");
select * from `human_friends`.`cats`;

INSERT INTO `human_friends`.`dogs`
(`dog_id`,`dog_name`,`birth_date`,`death_date`,`commands`)
VALUES
(7,"Дог",'2024-01-01',null,"сидеть, лежать"),
(7,"Граф",'2023-01-02',null,"сидеть, лежать, служить, апорт"),
(7,"Лапочка",'2021-11-05',null,"нельзя");

INSERT INTO `human_friends`.`hamsters`
(`hamster_id`,`hamster_name`,`birth_date`,`death_date`,`commands`)
VALUES
(8,"Пушок",'2024-01-10',null,"ко мне"),
(8,"Стишок",'2023-12-11',null,""),
(8,"Хрюня",'2022-11-05',null,"");

INSERT INTO `human_friends`.`pack_animals`
(`pack_id`,`pack_name`)
VALUES
(2,"horses"),
(2,"camels"),
(2,"donkeys");
select * from `human_friends`.`pack_animals`;

INSERT INTO `human_friends`.`horses`
(`horse_id`,`horse_name`,`birth_date`,`death_date`,`commands`)
VALUES
(4,"Легенда",'2000-01-01',null,"рысь, свеча"),
(4,"Муран",'1996-12-01',null,"кругом, рысь, галоп"),
(4,"Марс",'2012-06-05',null,"");

INSERT INTO `human_friends`.`camels`
(`camel_id`,`camel_name`,`birth_date`,`death_date`,`commands`)
VALUES
(5,"Махмут",'1992-06-02',null,""),
(5,"Айран",'1992-03-18',null,""),
(5,"Мурала",'2012-06-05',null,"");

INSERT INTO `human_friends`.`donkeys`
(`donkey_id`,`donkey_name`,`birth_date`,`death_date`,`commands`)
VALUES
(6,"Сахарок",'2003-08-15',null,"ко мне, бегом"),
(6,"Упертыш",'1999-07-10',null,"нельзя, вон"),
(6,"Тягач",'2016-03-05',null,"пшол вон");

select * from `human_friends`.`donkeys`;
SET SQL_SAFE_UPDATES = 0;
delete from `human_friends`.`camels`;

select id, horse_id as pack_id, horse_name as name from `human_friends`.`horses`
union
select id, donkey_id as pack_id, donkey_name as name from `human_friends`.`donkeys`;

-- new table ----------------------------------------------------------------
CREATE TABLE `human_friends`.`young_animals`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `animal_id` Int,
  `animal_name` Varchar(45) NOT NULL,
  `birth_date` Date NOT NULL,
  `commands` Varchar(255),
  `age` Varchar(45),
  PRIMARY KEY (`id`)
)
;
CREATE INDEX `animal_idx` ON `human_friends`.`young_animals` (`animal_id`)
;

INSERT INTO `human_friends`.`young_animals`
(`animal_id`,`animal_name`,`birth_date`,`commands`,`age`)
select id, cat_name, birth_date, commands,
concat("years: ", cast(timestampdiff(year, birth_date, now()) as char),
   "; monthes: ", cast(mod(timestampdiff(month, birth_date, now()), 12) as char)) as age
from `human_friends`.cats
where timestampdiff(month, birth_date, now()) between 12 and 36;

INSERT INTO `human_friends`.`young_animals`
(`animal_id`,`animal_name`,`birth_date`,`commands`,`age`)
select id, dog_name, birth_date, commands,
concat("years: ", cast(timestampdiff(year, birth_date, now()) as char),
   "; monthes: ", cast(mod(timestampdiff(month, birth_date, now()), 12) as char)) as age
from `human_friends`.dogs
where timestampdiff(month, birth_date, now()) between 12 and 36;

INSERT INTO `human_friends`.`young_animals`
(`animal_id`,`animal_name`,`birth_date`,`commands`,`age`)
select id, hamster_name, birth_date, commands,
concat("years: ", cast(timestampdiff(year, birth_date, now()) as char),
   "; monthes: ", cast(mod(timestampdiff(month, birth_date, now()), 12) as char)) as age
from `human_friends`.hamsters
where timestampdiff(month, birth_date, now()) between 12 and 36;

INSERT INTO `human_friends`.`young_animals`
(`animal_id`,`animal_name`,`birth_date`,`commands`,`age`)
select id, camel_name, birth_date, commands,
concat("years: ", cast(timestampdiff(year, birth_date, now()) as char),
   "; monthes: ", cast(mod(timestampdiff(month, birth_date, now()), 12) as char)) as age
from `human_friends`.camels
where timestampdiff(month, birth_date, now()) between 12 and 36;

INSERT INTO `human_friends`.`young_animals`
(`animal_id`,`animal_name`,`birth_date`,`commands`,`age`)
select id, donkey_name, birth_date, commands,
concat("years: ", cast(timestampdiff(year, birth_date, now()) as char),
   "; monthes: ", cast(mod(timestampdiff(month, birth_date, now()), 12) as char)) as age
from `human_friends`.donkeys
where timestampdiff(month, birth_date, now()) between 12 and 36;

INSERT INTO `human_friends`.`young_animals`
(`animal_id`,`animal_name`,`birth_date`,`commands`,`age`)
select id, horse_name, birth_date, commands,
concat("years: ", cast(timestampdiff(year, birth_date, now()) as char),
   "; monthes: ", cast(mod(timestampdiff(month, birth_date, now()), 12) as char)) as age
from `human_friends`.horses
where timestampdiff(month, birth_date, now()) between 12 and 36;

select * from `human_friends`.young_animals;

-- all tables ---------------------------------------------------------------------
-- pets
select c.id as id, c.cat_name as name, p.pet_name as type, c.birth_date, c.commands
from `human_friends`.cats c
left join `human_friends`.pets p on c.cat_id = p.id
union
select d.id as id, d.dog_name as name, p.pet_name as type, d.birth_date, d.commands
from `human_friends`.dogs d
left join `human_friends`.pets p on d.dog_id = p.id
union
select h.id as id, h.hamster_name as name, p.pet_name as type, h.birth_date, h.commands
from `human_friends`.hamsters h
left join `human_friends`.pets p on h.hamster_id = p.id
order by id; 

-- pack_animals
-- pets
-- camels was deleted
select h.id as id, horse_name as name, p.pack_name as type, h.birth_date, h.commands
from `human_friends`.horses h
left join `human_friends`.pack_animals p on h.horse_id = p.id
union
select d.id as id, d.donkey_name as name, p.pack_name as type, d.birth_date, d.commands
from `human_friends`.donkeys d
left join `human_friends`.pack_animals p on d.donkey_id = p.id
order by id 