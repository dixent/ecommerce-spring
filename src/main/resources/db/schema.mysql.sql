-- liquibase formatted sql

-- changeset dixent:1707432418121-1
CREATE TABLE `organization` (id BIGINT NOT NULL, name VARCHAR(255) NULL, CONSTRAINT PK_ORGANIZATION PRIMARY KEY (id));

-- changeset dixent:1707432418121-2
CREATE TABLE organization_seq (next_val BIGINT NULL);

-- changeset dixent:1707432418121-3
CREATE TABLE product (id BIGINT AUTO_INCREMENT NOT NULL, name VARCHAR(255) NOT NULL, price DOUBLE NOT NULL, `description` VARCHAR(255) NOT NULL, organization_id BIGINT NOT NULL, CONSTRAINT PK_PRODUCT PRIMARY KEY (id));

-- changeset dixent:1707432418121-4
CREATE TABLE product_seq (next_val BIGINT NULL);

-- changeset dixent:1707432418121-5
CREATE INDEX fk_product_organization ON product(organization_id);

-- changeset dixent:1707432418121-6
ALTER TABLE product ADD CONSTRAINT fk_product_organization FOREIGN KEY (organization_id) REFERENCES `organization` (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

