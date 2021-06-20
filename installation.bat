dir /s /B *.java > sources.txt
chcp 65001
javac -encoding UTF-8 -d out -cp lib\jfreechart-1.5.3.jar;out @sources.txt
