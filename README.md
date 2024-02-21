# FISA_ITIC_23_24

Groupe:
- Nom1 Prenom1 (à modifier)
- Nom2 Prenom2 (à modifier)
- Nom3 Prenom3 (à modifier)

Copyright (C) 2023-2024

Contact: denisse.munantearzapalo[at]ensiie.fr

Structure du projet:

├── Code                 // le code du logiciel dans un module Maven

├── Conception-Tests     // le dossier où vous allez ajouter la conception de tests

├── Rapport              // le dossier qui contient le rapport

├── README.md            // ce fichier

└── Suivi
    └── readme.md        // les messages échangés lors du suivi entre séances

================================================================================

Software prerequisites:
-----------------------
	1. JAVA Version >= 9.0
	   (https://openjdk.java.net/install/index.html)
	2. Maven Version >= 3.0.4
	   (http://maven.apache.org/)

Shell variables to set in your ~/.bashrc file:
----------------------------------------------
	1. if JAVA is not installed from an archive file,
$
export JAVA_HOME=<the root directory of your Java installation>
export CLASSPATH=$JAVA_HOME/lib

Compilation and installation:
-----------------------------
	To compile and install the modules, execute the following command.
$
(cd Code; mvn install)
$

	(Note: this could be useful once you have created JUnit files, for the moment the project does not contain any JUnit file) Use the following options if you do not want to compile and execute the JUnit tests  and do not want to generate the JavaDoc files.
        Then, the build process is much more rapid.
$
(cd Code; mvn install -Dmaven.test.skip=true -DskipTests -Dmaven.javadoc.skip=true -Dcheckstyle.skip)
$

In Eclipse:
-----------
	To load the project in Eclipse, either use the maven plugin (File >
	Import > Maven > Existing maven project), or create the Eclipse project
	using the following command and then create a Java project in Eclipse:
$
(cd Code; mvn eclipse:clean eclipse:eclipse)
$
