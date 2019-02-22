CREATE DATABASE  IF NOT EXISTS `Soccer_Game`;
           USE `Soccer_Game`;
             -- 4danh sach cac tran ca 
                  DROP TABLE IF EXISTS `matches`;
           CREATE TABLE `matches` (
             `id_match` int(20) NOT NULL AUTO_INCREMENT,
             `name_match` nvarchar(50),
            `ended_date` nvarchar(20)
            ,`status` int(20),
             PRIMARY KEY (`id_match`)
           ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

           -- 3thong tin nguoi choi
               DROP TABLE IF EXISTS `player`;
           CREATE TABLE `player` (
             `id` int(20) NOT NULL AUTO_INCREMENT,
             `name` nvarchar(50)
             ,`username` nvarchar(20)
             , `password` nvarchar(20)
             ,`balance` int
             , `role_id` int(20),
             PRIMARY KEY ( `id`),
                CONSTRAINT `fk_role` FOREIGN KEY (`role_id`) 
                REFERENCES `user_role` (`role_id`)  
                ON DELETE CASCADE ON UPDATE CASCADE
           ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
       insert into `player` values("{bcrypt}$2a$10$pQQoo9gN6JmqsbVtWPLpUulDf2EVCC4utw0L/kFdJEFNHnJAB8p3u")
           
           -- 2 thong tin ve ti so cua moi tran ca
             DROP TABLE IF EXISTS `score`;
           CREATE TABLE `score` (
             `id_score` int(20) NOT NULL AUTO_INCREMENT,
             `score1` int, 
             `score2` int,
             `ratio` double ,
             `price` int, 
             `is_win` int(20) ,
             `id_match` int(20),
             PRIMARY KEY ( `id_score`),
                CONSTRAINT `fk_match` FOREIGN KEY (`id_match`) 
                REFERENCES `matches` (`id_match`)  
                ON DELETE CASCADE ON UPDATE CASCADE
           ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
	
    
           -- 1 danh sach nguoi choi tham gia ca cuoc cho moi ti so, cho moi tran ca
             DROP TABLE IF EXISTS `bets`;
              CREATE TABLE `bets` (`stt` int(20), 
             `id_score` int(20) ,
             `id_player` int(20) ,`id_match` int(20),
             PRIMARY KEY ( `stt`),
  CONSTRAINT `fk_score` FOREIGN KEY (`id_score`) REFERENCES `score` (`id_score`)
  ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_player` FOREIGN KEY (`id_player`) REFERENCES `player` (`id`)
  ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


 
       DROP TABLE IF EXISTS `user_role`;
           CREATE TABLE `user_role` (
             `role_id` int(20) NOT NULL AUTO_INCREMENT,
             `role_name` nvarchar(50)
             ,PRIMARY KEY ( `role_id`)
           ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
     
        
             DROP TABLE IF EXISTS `manage_privilege`;
           CREATE TABLE `manage_privilege` (`stt` int(20) NOT NULL AUTO_INCREMENT,
             `role_id` int(20) ,
             `path` nvarchar(50),
             `insert` int(10),
              `update` int(10),
               `delete` int(10), 
               `retrieve` int(10),PRIMARY KEY ( `stt`),
              CONSTRAINT `fk_priv` FOREIGN KEY (`role_id`) 
                REFERENCES `user_role` (`role_id`)  
                ON DELETE CASCADE ON UPDATE CASCADE
           ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
           --  LOCK TABLES `manage_privilege` WRITE;
         --  INSERT INTO `manage_privilege` VALUES 
         --  (1,'/soccer/player',0,0,0,1)
         --   ,(1,'/soccer/choose',0,0,0,1)
         -- ,(1,'/soccer/chooseMatch',0,0,0,1)
         -- ,(1,'/soccer/acceptRecharge',0,0,0,1)
         -- ,(1,'/soccer/listMatches',0,0,0,1)
         -- ,(1,'/soccer/createMatch',1,0,0,0)
         -- ,(1,'/soccer/createScore',1,0,0,0)
         -- ,(1,'/soccer/scores',0,0,0,1)
         -- ,(2,'/soccer/player',0,0,0,1)
		 -- ,(2,'/soccer/choose',0,0,0,1)
          -- ,(2,'/soccer/chooseMatch',0,0,0,1)
         -- ,(2,'/soccer/acceptRecharge',0,0,0,0)
        --  ,(2,'/soccer/listMatches',0,0,0,1)
         -- ,(2,'/soccer/createMatch',0,0,0,0)
         -- ,(2,'/soccer/createScore',0,0,0,0)
         -- ,(2,'/soccer/scores',0,0,0,1);
          -- UNLOCK TABLES;
          
          
           DROP TABLE IF EXISTS `RegisterBookie`;
           CREATE TABLE `RegisterBookie` (
             `id` int(20) ,
             `id_match` int(20)
             ,`status` int(20)
             ,PRIMARY KEY ( `id`),
              CONSTRAINT `fk_i` FOREIGN KEY (`id`) 
                REFERENCES `player` (`id`),
                 CONSTRAINT `fk_m` FOREIGN KEY (`id_match`) 
                REFERENCES `matches` (`id_match`)
                ON DELETE CASCADE ON UPDATE CASCADE
           ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
       