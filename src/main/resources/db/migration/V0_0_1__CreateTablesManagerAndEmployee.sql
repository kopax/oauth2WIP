
CREATE TABLE `MANAGER` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `LOGIN` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `ROLES` tinyblob,
  PRIMARY KEY (`ID`),
  CONSTRAINT manager_unique UNIQUE (`LOGIN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `EMPLOYEE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `VERSION` bigint(20) DEFAULT NULL,
  `MANAGER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKfemnv0llvsjg4adl4xl1m0cxv` (`MANAGER_ID`),
  CONSTRAINT `FKfemnv0llvsjg4adl4xl1m0cxv` FOREIGN KEY (`MANAGER_ID`) REFERENCES `MANAGER` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- CREATE TABLE `USER` (
--   `ID` int(11) NOT NULL AUTO_INCREMENT,
--   `FIRSTNAME` varchar(45) DEFAULT NULL,
--   `LASTNAME` varchar(45) DEFAULT NULL,
--   `CREATION_DATETIME` datetime DEFAULT CURRENT_TIMESTAMP,
--   `CREATION_USER_ID` int(11) DEFAULT NULL,
--   `MODIFICATION_DATETIME` datetime DEFAULT NULL,
--   `MODIFICATION_USER_ID` int(11) DEFAULT NULL,
--   PRIMARY KEY (`ID`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--
-- CREATE TABLE `EMPLOYEE` (
--   `ID` int(11) NOT NULL AUTO_INCREMENT,
--   `USER_ID` int(11) DEFAULT NOT NULL,
--   `PASSWORD` varchar(45) DEFAULT NOT NULL,
--   `CREATION_DATETIME` datetime DEFAULT CURRENT_TIMESTAMP,
--   `CREATION_USER_ID` int(11) DEFAULT NULL,
--   `MODIFICATION_DATETIME` datetime DEFAULT NULL,
--   `MODIFICATION_USER_ID` int(11) DEFAULT NULL,
--   PRIMARY KEY (`ID`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- CREATE TABLE `REF_TYPE_EMPLOYEE` (
--   `ID` int(11) NOT NULL AUTO_INCREMENT,
--   `DESCRIPTION` varchar(45) DEFAULT NULL,
--   PRIMARY KEY (`ID`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--
--
-- CREATE TABLE `REF_PERSON_TYPE` (
--   `ID` int(11) NOT NULL AUTO_INCREMENT,
--   `DESCRIPTION` varchar(45) DEFAULT NULL,
--   PRIMARY KEY (`ID`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--