/*drop sequence if exists post_seq;
drop sequence  if exists tag_seq;
create sequence post_seq increment 1;
create sequence tag_seq increment 1;

DROP TABLE IF EXISTS POST;
CREATE TABLE POST (
                      id INT not null unique PRIMARY KEY,
                      title VARCHAR(250) NOT NULL,
                      content VARCHAR(500) NOT NULL
);

DROP TABLE IF EXISTS TAG_TYPE;
CREATE TABLE TAG_TYPE (
                          id INT not null unique PRIMARY KEY ,
                          tag_name VARCHAR(250) UNIQUE
);

DROP TABLE IF EXISTS POST_TAG;
CREATE TABLE POST_TAG (
                          post_id INT not null constraint post_const references POST,
                          tag_id INT not null constraint tag_const references TAG_TYPE,
                          PRIMARY KEY (post_id, tag_id)
);*/