CREATE TABLE `siswa` 
( 
	`NIS` INT NOT NULL , 
	`Namalengkap` VARCHAR(25) NOT NULL , 
	`Username` VARCHAR(20) NOT NULL , 
	`Password` VARCHAR(32) NOT NULL , 
	`Angkatan` INT NOT NULL , 
	PRIMARY KEY (`NIS`)
) ENGINE = MyISAM;

ALTER TABLE `siswa` ADD `id_sekolah` INT(10) NOT NULL AFTER `Angkatan`;