CREATE DATABASE scheduler OWNER postgres;

CREATE TABLE task
(
    id          BIGSERIAL PRIMARY KEY,
    date        DATE NOT NULL,
    description TEXT
);

INSERT INTO task (date, description)
VALUES ('2021-10-10', 'Make test app');

ALTER TABLE task
    ADD COLUMN done BOOLEAN NOT NULL DEFAULT FALSE;

SELECT *
FROM task;


--date & done has to be indexed
SELECT *
FROM task
WHERE date >= '2020-12-28'
  AND date <= '2021-01-03'
  AND done = FALSE;

CREATE INDEX task_date_idx ON task (date);

CREATE INDEX task_done_idx ON task (done);

CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    login    TEXT NOT NULL,
    password TEXT NOT NULL
);











