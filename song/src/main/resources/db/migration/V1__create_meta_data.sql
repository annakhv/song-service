CREATE TABLE IF NOT EXISTS song_data (
  id BIGINT NOT NULL,
   name VARCHAR(255),
   artist VARCHAR(255),
   album VARCHAR(255),
   length DOUBLE PRECISION,
   resource_id BIGINT,
   year INTEGER,
   CONSTRAINT pk_songdata PRIMARY KEY (id)
);

ALTER TABLE song_data ADD CONSTRAINT uc_songdata_resourceid UNIQUE (resource_id);
