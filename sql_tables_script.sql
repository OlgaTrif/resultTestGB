CREATE TABLE `animal`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `animal_name` Varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
)
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

ALTER TABLE `pets` ADD CONSTRAINT `pets_to_animal` FOREIGN KEY (`pet_id`) REFERENCES `animal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `pack_animals` ADD CONSTRAINT `pack_to_animal` FOREIGN KEY (`pack_id`) REFERENCES `animal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `cats` ADD CONSTRAINT `cat_to_pets` FOREIGN KEY (`cat_id`) REFERENCES `pets` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `dogs` ADD CONSTRAINT `dog_to_pets` FOREIGN KEY (`dog_id`) REFERENCES `pets` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `hamsters` ADD CONSTRAINT `hamster_to_pet` FOREIGN KEY (`hamster_id`) REFERENCES `pets` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `camels` ADD CONSTRAINT `camel_to_pack` FOREIGN KEY (`camel_id`) REFERENCES `pack_animals` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `horses` ADD CONSTRAINT `horse_to_pack` FOREIGN KEY (`horse_id`) REFERENCES `pack_animals` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `donkeys` ADD CONSTRAINT `donkey_to_pack` FOREIGN KEY (`donkey_id`) REFERENCES `pack_animals` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;