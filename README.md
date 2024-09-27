This project contains artifacts built in the context of research, which aims to understand the influence of AI on people, taking into account their deep-rooted beliefs.. 
 * Author: Jean Gabriel Nguema Ngomo (mvojgnn@gmail.com).
 * Licence: Apache License, Version 2.0.

# Description
## Web Experimet
Web interface presenting experiment steps:
*  [Persistence Layer]( https://github.com/JeanGabrielNguemaN/ETL4DBpedia/tree/master/Kettle4DBpediaPersistenceLayer)


## Installation

1.	Download and Install Kettle, Pentaho Data Integration (pdi-ce-8.2.0.0-342 or latest version).

2.	Download and Install MySQL database (8.0 version ). 
    * Create the database by the following queries: ETL4DBpedia/Kettle4DBpediaPersistenceLayer/Database/SQL/DDL.sql
	
3.	Add jars into  PDI_HOME\data-integration\lib directory, where PDI is the root directory of Pentaho Data Integration.
     * MySQL driver (mysql-connector-5.1.18.jar)
     * Apache Jena jars (3.10.0 or latest version) 
	 
4.	Download, install and settup Maven.

5.	Install KettlePluginTools.jar in maven local repository: From Command Prompt, run a batch maven_install_local_libs.bat from the ETL4DBpedia\Kettele4DBpediaPlugins\libs directory
    ```sh
     $ mvn install:install-file -Dfile=./KettlePluginTools.jar -DgroupId=br.ufrj.ppgi.greco.kettle -DartifactId=KettlePluginTools -Dversion=1.0 -Dpackaging=jar
	```
	Or run:
	 ```sh
     $ ./maven_install_local_libs.bat   
	 ```
	
6.	Adjust  pdi.home property in ETL4DBpedia\pom.xml file.

7.	Build PersitenceLayer plugins:
	```sh
     $ mvn clean package
	```
	
8.	Register Persistence Layer's artefacts into directory publication layer:
	* Copy ETL4DBpedia\Kettle4DBpediaPersistenceLayer\target\Kettle4DBpediaPersistenceLayer-1.0.jar  file  to  ETL4DBpedia\Kettele4DBpediaPlugins\libs directory

9.	Install ET4DBpedia in PDI:
	```sh
     $ mvn clean install
	```

