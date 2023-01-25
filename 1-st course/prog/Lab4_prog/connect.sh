javac -d classes -cp "src" src/Story.java
jar -cfm Lab4_prog.jar src/MANIFEST.mf -C ./classes .
java -jar Lab4_prog.jar
