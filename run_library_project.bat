@echo off
REM Script to compile and run the library project

REM Change directory to src
cd src

REM Compile all Java files in controller, services, and library packages
javac controller\*.java services\*.java library\*.java

IF ERRORLEVEL 1 (
    echo Compilation failed.
    pause
    exit /b 1
)

REM Run the Main class
java library.Main

pause
