--user "root" senha "" (vazio)

CREATE SCHEMA "banco" ;

CREATE TABLE "banco"."conta" (
  "id" INT NOT NULL,
  "cpf" VARCHAR(45) NULL,
  "valor" DECIMAL(6,2) NULL,
  "nome" VARCHAR(45) NULL,
  PRIMARY KEY ("id"));

  
  CREATE TABLE "banco"."extrato" (
  "id" INT NOT NULL,
  "valor" VARCHAR(45) NULL,
  "operacao" VARCHAR(45) NULL,
  "id_conta" INT NULL,
  PRIMARY KEY ("id"),
  INDEX "fk_conta_idx" ("id_conta" ASC),
  CONSTRAINT "fk_conta"
    FOREIGN KEY ("id_conta")
    REFERENCES "banco"."conta" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

	ALTER TABLE "banco"."extrato" 
CHANGE COLUMN "valor" "valor" DECIMAL(6,2) NULL DEFAULT NULL ;

ALTER TABLE "banco"."conta" 
CHANGE COLUMN "id" "id" INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE "banco"."extrato" 
CHANGE COLUMN "id" "id" INT(11) NOT NULL AUTO_INCREMENT ;
