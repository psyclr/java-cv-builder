-- Create the skills table
CREATE TABLE IF NOT EXISTS "skills"
(
    id          bigint PRIMARY KEY,
    name        varchar(255) NOT NULL,
    description varchar(255) NOT NULL
);

ALTER TABLE "users"
    ADD COLUMN skill_id bigint NOT NULL default 0;

ALTER TABLE "users"
    ADD CONSTRAINT fk_clients_created_by
        FOREIGN KEY (skill_id) REFERENCES "users" (id) ON DELETE CASCADE;

