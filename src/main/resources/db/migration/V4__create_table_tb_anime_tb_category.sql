CREATE TABLE tb_anime_category(
    anime_id INTEGER,
    category_id INTEGER,
    CONSTRAINT fk_anime_category_anime
        FOREIGN KEY(anime_id) REFERENCES tb_anime(id),
    CONSTRAINT fk_anime_category_category
        FOREIGN KEY(category_id) REFERENCES tb_category(id)
);