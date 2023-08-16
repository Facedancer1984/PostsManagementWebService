INSERT INTO TAG_TYPE (tag_name) VALUES ('sport');
INSERT INTO TAG_TYPE (tag_name) VALUES ('space');
INSERT INTO TAG_TYPE (tag_name) VALUES ('food');
INSERT INTO TAG_TYPE (tag_name) VALUES ('news');
INSERT INTO TAG_TYPE (tag_name) VALUES ('music');


INSERT INTO POST (title, content) VALUES ('New rocket fuel were developed', 'SpaceX is about to develop new solid rocket fuel that will increase the output capacity dramatically with the same volume');
INSERT INTO POST (title, content) VALUES ('Football championship 2026', 'The coming Football championship that ought to take part in New Zealand is likely to be moved to 2027 due to major earthquakes');
INSERT INTO POST (title, content) VALUES ('Shark fin soup poisoning', 'Recent food poisoning in one of the main seafood restaurants was due to the Shark fin soup was poorly prepared');
INSERT INTO POST (title, content) VALUES ('Weather', 'This autumn will be the warmest autumn since 1998');
INSERT INTO POST (title, content) VALUES ('Classic blues music', 'Next week a classic blues concert will be held in the city');


INSERT INTO POST_TAG (post_id, tag_id) VALUES (1, 2);
INSERT INTO POST_TAG (post_id, tag_id) VALUES (2, 1);
INSERT INTO POST_TAG (post_id, tag_id) VALUES (3, 3);
INSERT INTO POST_TAG (post_id, tag_id) VALUES (4, 4);
INSERT INTO POST_TAG (post_id, tag_id) VALUES (5, 5);
INSERT INTO POST_TAG (post_id, tag_id) VALUES (3, 4);
INSERT INTO POST_TAG (post_id, tag_id) VALUES (1, 4);