CREATE DATABASE IF NOT EXISTS `trending`;
CREATE DATABASE IF NOT EXISTS `subscription`;

GRANT ALL ON `trending`.* TO 'todo'@'%';
GRANT ALL ON `subscription`.* TO 'todo'@'%';