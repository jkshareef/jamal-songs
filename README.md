# jamal-songs

Clone the repository to a target folder

The following instructions are for VSCode, other IDE will have different extensions and packages, please refer to them.

## Prerequisites
PostMan
A working Java environment with essential extensions installed is needed, including:

Java Development Kit (JDK), version 1.8.

Apache Maven, version 3.0 or later.

Java Extension Pack

Java Test Runner Extension

https://code.visualstudio.com/docs/java/java-spring-boot


Testing Java in Visual Studio Code is enabled by the Java Test Runner extension. It's a lightweight extension to run and debug Java test cases. The extension supports the following test frameworks:

JUnit 4 (v4.8.0+)
JUnit 5 (v5.1.0+)
TestNG (v6.8.0+)

Click run on the inAtticusMusicApplication.java file jamal-songs/atticus-music/src/main/java/io/jamalshareef/

### NOTE: The Java Test Runner Extension is not currently recognizing the JUnit imports and testing is currently not working in VSCode. I am able to run these tests in my local environment using the SpringToolSuite IDE which was used to create the project. Will work on troubleshooting this.

## Usage

Using Postman
Check the address of the local server in the console after running. 
This normally defaults to localhost:8080

## Get All Songs
localhost:8080/songs

## Play Song
localhost:8080/songs/id

## Add Songs
to the POST localhost:8080/songs address add songs with the body formatted as such:

{
        "name": "Alright",
        "genre": "RAP",
        "artist": "Kendrick Lamar",
        "length": 320,
        "filepath": "users/Jamal/documents/music/to_pimp_a_butterfly/alright.mp3",
        "ranking": 5
 }
 
 ## Update/Delete Songs
 TO localhost:8080/songs/id
 
 ensure body includes id
 
 {
        "id": "3a808207053445ea8ff7c8031ea60868",
        "name": "Alright",
        "genre": "RAP",
        "artist": "Kendrick Lamar",
        "length": 320,
        "filepath": "users/Jamal/documents/music/to_pimp_a_butterfly/alright.mp3",
        "ranking": 5
  }
  
  ### Thank You
 
 
 
 




