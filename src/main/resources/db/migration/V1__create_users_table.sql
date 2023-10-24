-- Create the user info table
CREATE TABLE IF NOT EXISTS "users-info"
(
    id        bigint PRIMARY KEY,
    firstName varchar(255) NOT NULL,
    lastName  varchar(255) NOT NULL,
    age       numeric      NOT NULL
);


-- Create the user table
CREATE TABLE IF NOT EXISTS "users"
(
    id                     bigint PRIMARY KEY,
    user_info_id           bigint,
    email                  VARCHAR(255) NOT NULL UNIQUE,
    password               VARCHAR(255) NOT NULL,
    "role"                 VARCHAR(255) NOT NULL,
    enabled                BOOLEAN      NOT NULL DEFAULT false,
    credential_non_expired BOOLEAN      NOT NULL DEFAULT false,
    non_expired            BOOLEAN      NOT NULL DEFAULT false,
    non_locked             BOOLEAN      NOT NULL DEFAULT false,
    created_at             TIMESTAMP    NOT NULL DEFAULT now(),
    updated_at             TIMESTAMP    NOT NULL DEFAULT now(),
    FOREIGN KEY (user_info_id) REFERENCES "users-info" (id) ON DELETE CASCADE
);


