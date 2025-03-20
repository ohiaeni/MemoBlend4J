DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
(
  id BIGSERIAL NOT NULL PRIMARY KEY, -- primary key column
  name VARCHAR(64) NOT NULL,
  is_deleted BOOLEAN NOT NULL DEFAULT FALSE
);

-- Drop and create the `diaries` table
DROP TABLE IF EXISTS diaries CASCADE;
CREATE TABLE diaries
(
  id BIGSERIAL NOT NULL PRIMARY KEY, -- primary key column
  user_id BIGSERIAL NOT NULL,
  title VARCHAR(64) NOT NULL,
  content VARCHAR NOT NULL,
  created_date TIMESTAMP NOT NULL,
  is_deleted BOOLEAN NOT NULL DEFAULT FALSE
);