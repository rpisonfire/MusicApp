CREATE TABLE `artist`
(
    `id`         int          NOT NULL AUTO_INCREMENT,
    `first_name` varchar(255) NOT NULL,
    `last_name`  varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `track`
(
    `id`        int          NOT NULL AUTO_INCREMENT,
    `title`     varchar(255) NOT NULL,
    `cover_url` varchar(255),
    `rating`    float        DEFAULT NULL,
    `artist_id` int          DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `playlist`
(
    `id`       int          NOT NULL AUTO_INCREMENT,
    `name`     varchar(255) NOT NULL,
    `logo_url` varchar(255),
    PRIMARY KEY (`id`)
);

CREATE TABLE `track_playlist`
(
    `track_id`    int DEFAULT NULL,
    `playlist_id` int DEFAULT NULL
);

INSERT INTO `artist`(`id`, `first_name`, `last_name`) VALUES ('1', 'Kendrick', 'Lamar');
INSERT INTO `artist`(`id`, `first_name`, `last_name`) VALUES ('2', 'Travis', 'Scott');
INSERT INTO `artist`(`id`, `first_name`, `last_name`) VALUES ('3', 'The', 'Weeknd');
INSERT INTO `artist`(`id`, `first_name`, `last_name`) VALUES ('4', 'Taco', 'Hemingway');

INSERT INTO `track`(`id`, `title`, `cover_url`, `rating`, `artist_id`) VALUES ('1', 'Not Like Us', 'https://covers.example.com/nlu.jpg', '9.5', '1');
INSERT INTO `track`(`id`, `title`, `cover_url`, `rating`, `artist_id`) VALUES ('2', 'FE!N', 'https://covers.example.com/fein.jpg', '9.0', '2');
INSERT INTO `track`(`id`, `title`, `cover_url`, `rating`, `artist_id`) VALUES ('3', 'Blinding Lights', 'https://covers.example.com/bl.jpg', '9.8', '3');
INSERT INTO `track`(`id`, `title`, `cover_url`, `rating`, `artist_id`) VALUES ('4', 'Humble', 'https://covers.example.com/humble.jpg', '9.3', '1');
INSERT INTO `track`(`id`, `title`, `cover_url`, `rating`, `artist_id`) VALUES ('5', 'DNA', 'https://covers.example.com/dna.jpg', '9.1', '1');
INSERT INTO `track`(`id`, `title`, `cover_url`, `rating`, `artist_id`) VALUES ('6', 'Café Belga', 'https://covers.example.com/cafe.jpg', '9.0', '4');
INSERT INTO `track`(`id`, `title`, `cover_url`, `rating`, `artist_id`) VALUES ('7', 'Trójkąt Warszawski', 'https://covers.example.com/trojkat.jpg', '8.7', '4');
INSERT INTO `track`(`id`, `title`, `cover_url`, `rating`, `artist_id`) VALUES ('8', 'Dym', 'https://covers.example.com/dym.jpg', '8.5', '4');

INSERT INTO `playlist`(`id`, `name`, `logo_url`) VALUES ('1', 'Rap Bangers', 'https://logos.example.com/rap.jpg');
INSERT INTO `playlist`(`id`, `name`, `logo_url`) VALUES ('2', 'Polskie Tango', 'https://logos.example.com/pltango.jpg');
INSERT INTO `playlist`(`id`, `name`, `logo_url`) VALUES ('3', 'Top Hits 2025', 'https://logos.example.com/top.jpg');
INSERT INTO `playlist`(`id`, `name`, `logo_url`) VALUES ('4', 'Kendrick Only', 'https://logos.example.com/kdot.jpg');

INSERT INTO `track_playlist`(`track_id`, `playlist_id`) VALUES ('1', '1');
INSERT INTO `track_playlist`(`track_id`, `playlist_id`) VALUES ('2', '1');
INSERT INTO `track_playlist`(`track_id`, `playlist_id`) VALUES ('4', '1');
INSERT INTO `track_playlist`(`track_id`, `playlist_id`) VALUES ('6', '2');
INSERT INTO `track_playlist`(`track_id`, `playlist_id`) VALUES ('7', '2');
INSERT INTO `track_playlist`(`track_id`, `playlist_id`) VALUES ('8', '2');
INSERT INTO `track_playlist`(`track_id`, `playlist_id`) VALUES ('1', '3');
INSERT INTO `track_playlist`(`track_id`, `playlist_id`) VALUES ('3', '3');
INSERT INTO `track_playlist`(`track_id`, `playlist_id`) VALUES ('1', '4');
INSERT INTO `track_playlist`(`track_id`, `playlist_id`) VALUES ('4', '4');

CREATE TABLE user
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE role
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    role     VARCHAR(255)
);

INSERT INTO user(username, password)
VALUES ('dbuser1', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser2', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser3', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS');

INSERT INTO role(username, role)
VALUES ('dbuser1', 'USER_ADMIN'),
       ('dbuser2', 'AUTHOR_ADMIN'),
       ('dbuser3', 'BOOK_ADMIN');