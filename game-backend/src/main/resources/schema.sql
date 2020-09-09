DROP TABLE IF EXISTS GAME;
 
CREATE TABLE GAME
(
    ID            bigint auto_increment primary key not null,
    VICTORIES_PLAYER_1 INT NULL,
    VICTORIES_PLAYER_2 INT NULL,
	DRAWS INT NULL,
	NUMBER_ROWS INT NULL
);

DROP TABLE IF EXISTS ROUND;

CREATE TABLE ROUND
(
    ID            bigint auto_increment primary key not null,
    HAND_PLAYER_1 INT NULL,
    HAND_PLAYER_2 INT NULL,
	GAME_ID bigint not null,
	WINNER INT NULL
);



DROP TABLE IF EXISTS DSC_HAND_TYPE;

CREATE TABLE DSC_HAND_TYPE
(
	ID INT NOT NULL,
	DESC VARCHAR(100) NOT NULL
);

insert into DSC_HAND_TYPE (ID, DESC) values (1, 'Random');
insert into DSC_HAND_TYPE (ID, DESC) values (2, 'Rock');
insert into DSC_HAND_TYPE (ID, DESC) values (3, 'Paper');
insert into DSC_HAND_TYPE (ID, DESC) values (4, 'Scissors');