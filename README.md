# data-marketplace

### How to install and run the program
1. Install MySQL database, and create a new database called tempdb in the program "MySQL 8.0 Command Line Client".
   Enter password to start MySQL. The password used for the "root" in the program is "pass".
   The SQL information used by the program (username, password, port etc.) can be changed in the class "SQLInformationMapper" and the file "application.properties", though this is not encouraged. Remember to change both if you need to.
   If "MySQL 8.0 Command Line Client" crushed right after entering password, check the password entered and make sure it is correct.
   Or there might be some problems with the setting. Follow the steps in "https://www.youtube.com/watch?v=-OVokMpoDPE" to get it work.
   The command of creating the database is "create database tempdb;", and to make sure the database is created, use "show databases;" to view all the databases.

2. After doing all things above, the database is established and existing right now for the program to connect.
   Remember do not close the SQL client window to let the SQL run.
   Now use "cd" to enter the program directory (where the directory "src" is located), and then run the program by the command "mvn spring-boot:run".
   After starting Spring Boot, enter "localhost:8080" in a browser to enter our first web page. The server port number "8080" can be changed directly in "SQLInformationMapper", though it is not encouraged.
   When seeing the welcome information, the start of the program is successful.