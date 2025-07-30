@echo off
REM Script to compile and run JUnit tests

REM Check if lib directory exists with junit jar
if not exist lib (
    echo Please download junit-platform-console-standalone.jar and place it in the lib folder.
    pause
    exit /b 1
)

REM Change directory to src
cd src

REM Compile all Java files including tests with JUnit in classpath
javac -cp ../lib/junit-platform-console-standalone.jar controller\*.java services\*.java library\*.java tests\*.java

if errorlevel 1 (
    echo Compilation failed.
    pause
    exit /b 1
)

REM Run JUnit tests using Console Launcher
java -jar ../lib/junit-platform-console-standalone.jar --class-path . --scan-class-path

pause
