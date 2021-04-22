# Java Projekt-Template fuer OOP/PLAB, PRG, AD und SWDE

GitLab: [![build status](https://intern-gitlab.enterpriselab.ch/oop/oop_maven_template/badges/develop/build.svg)](https://intern-gitlab.enterpriselab.ch/oop/oop_maven_template/commits/develop)
Jenkins: [![Build Status](https://jenkins-global.el.eee.intern/jenkins/buildStatus/icon?job=oop_maven_template-develop)](https://jenkins-global.el.eee.intern/jenkins/view/1-OOP/job/oop_maven_template-develop/)

## Zweck
Dieses Projekt dient in den Modulen OOP/PLAB, PRG, AD, SWDE, VSK und APPE als 
Template fuer einfache Java-Projekte. Es nutzt einen auf 
[Apache Maven](https://maven.apache.org/) basierenden (und somit IDE-unabhaengigen) 
Build und definiert die dafür notwendige, standardisierte Verzeichnisstruktur.

## Distribution / Download
Die jeweils aktuelle Version steht auf [SWITCHdrive](https://drive.switch.ch/) zur Verfügung:
https://drive.switch.ch/index.php/s/nz0UdWDlSQ9ogDX?path=%2F15_maven_template

## Verwendung
Das Projekt kann einfach kopiert und umbenannt werden. In NetBeans kann es 
**direkt** geoeffnet werden, in Eclipse und IntelliJ IDEA ist ein **Import** des
Projektes notwendig.

Nach dem Kopieren in ein neues Verzeichnis empfehlen wir, den Namen
des Verzeichnisses, den Namen des Projektes in der IDE sowie die 
`ArtifactID` und `Name` (zwei Elemente im `pom.xml`) **synchron** zu halten.
In NetBeans erreichen Sie das durch ein einfaches "Rename"-Refactoring. 
Sie koennen es aber auch direkt mit einem Texteditor (z.B. notepad) erledigen.

Sobald Sie eigene Klassen und Testfaelle ergaenzt haben, sollten Sie die
fuer Demozwecke enthaltenen Demo-Klassen entfernen.

## Enhaltene Libraries (Dependencies)
* JUnit 5 - https://junit.org/junit5/
* JUnit Pioneer - https://junit-pioneer.org/
* AssertJ - https://assertj.github.io/doc/
* EqualsVerifier - https://jqno.nl/equalsverifier/
* Logging Framework - https://logging.apache.org/log4j/2.x/
* MutabilityDetector - https://github.com/MutabilityDetector/MutabilityDetector

## Integrierte Analysewerkzeuge
* Checkstyle - https://checkstyle.sourceforge.io/
* PMD - https://pmd.github.io/
* JaCoCo - https://www.eclemma.org/jacoco/
* Spotbugs - https://spotbugs.github.io/
