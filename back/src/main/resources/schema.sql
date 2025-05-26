DROP TABLE IF EXISTS noticia_orgao_institucional;
DROP TABLE IF EXISTS noticia_area_tematica;
DROP TABLE IF EXISTS orgao_institucional;
DROP TABLE IF EXISTS area_tematica;
DROP TABLE IF EXISTS noticia;


CREATE TABLE orgao_institucional (
    id SERIAL PRIMARY KEY,
    titulo TEXT NOT NULL
);

CREATE TABLE area_tematica (
    id SERIAL PRIMARY KEY,
    titulo TEXT NOT NULL
);

CREATE TABLE noticia (
    id SERIAL PRIMARY KEY,
    titulo TEXT NOT NULL,
    atualizado_em TIMESTAMPTZ DEFAULT now(),
    minutos_leitura INTEGER,
    autor TEXT,
    img BYTEA
);

CREATE TABLE noticia_orgao_institucional (
    id SERIAL PRIMARY KEY,
    id_noticia INTEGER NOT NULL,
    id_orgao_institucional INTEGER NOT NULL,

    FOREIGN KEY (id_noticia) REFERENCES noticia(id),
    FOREIGN KEY (id_orgao_institucional) REFERENCES orgao_institucional(id)
);

CREATE TABLE noticia_area_tematica (
    id SERIAL PRIMARY KEY,
    id_noticia INTEGER NOT NULL,
    id_area_tematica INTEGER NOT NULL,

    FOREIGN KEY (id_noticia) REFERENCES noticia(id),
    FOREIGN KEY (id_area_tematica) REFERENCES area_tematica(id)
);

CREATE INDEX idx_noticia_orgao_noticia ON noticia_orgao_institucional(id_noticia);
CREATE INDEX idx_noticia_orgao_orgao ON noticia_orgao_institucional(id_orgao_institucional);

CREATE INDEX idx_noticia_area_noticia ON noticia_area_tematica(id_noticia);
CREATE INDEX idx_noticia_area_area ON noticia_area_tematica(id_area_tematica);