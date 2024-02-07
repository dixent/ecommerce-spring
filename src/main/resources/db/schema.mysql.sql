-- liquibase formatted sql

-- changeset dixent:1707338783721-1
CREATE TABLE `organization` (id BIGINT NOT NULL, name VARCHAR(255) NULL, CONSTRAINT PK_ORGANIZATION PRIMARY KEY (id));

-- changeset dixent:1707338783721-2
CREATE TABLE organization_seq (next_val BIGINT NULL);

-- changeset dixent:1707338783721-3
CREATE TABLE product (id BIGINT AUTO_INCREMENT NOT NULL, name VARCHAR(255) NOT NULL, price DOUBLE NOT NULL, `description` VARCHAR(255) NOT NULL, organizationId BIGINT NOT NULL, organization_id BIGINT NOT NULL, CONSTRAINT PK_PRODUCT PRIMARY KEY (id));

-- changeset dixent:1707338783721-4
CREATE TABLE product_seq (next_val BIGINT NULL);

-- changeset dixent:1707338783721-5
CREATE INDEX FKd7o25pueh2dsexxvtu2hia4i3 ON product(organization_id);

-- changeset dixent:1707338783721-6
CREATE INDEX fk_product_organization ON product(organizationId);

-- changeset dixent:1707338783721-7
ALTER TABLE product ADD CONSTRAINT FKd7o25pueh2dsexxvtu2hia4i3 FOREIGN KEY (organization_id) REFERENCES `organization` (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

-- changeset dixent:1707338783721-8
ALTER TABLE product ADD CONSTRAINT fk_product_organization FOREIGN KEY (organizationId) REFERENCES `organization` (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

