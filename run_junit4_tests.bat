@echo off
echo ========================================
echo Running JUnit 4 Tests for Library Project
echo ========================================

REM Set variables
set JUNIT_JAR=lib/junit-4.13.2.jar
set HAMCREST_JAR=lib/hamcrest-core-1.3.jar
set SRC_DIR=src
set TEST_DIR=test
set BIN_DIR=bin

REM Create bin directory if not exists
if not exist "%BIN_DIR%" mkdir "%BIN_DIR%"

REM Compile source files
echo Compiling source files...
javac -d "%BIN_DIR%" -cp "%SRC_DIR%" "%SRC_DIR%/services/*.java" "%SRC_DIR%/models/*.java" "%SRC_DIR%/controller/*.java" "%SRC_DIR%/library/*.java"

REM Compile test files
echo Compiling test files...
javac -d "%BIN_DIR%" -cp "%BIN_DIR%;%JUNIT_JAR%;%HAMCREST_JAR%" "%TEST_DIR%/services/*.java"

REM Run tests
echo Running tests...
java -cp "%BIN_DIR%;%JUNIT_JAR%;%HAMCREST_JAR%" org.junit.runner.JUnitCore test.services.DocumentServiceTest test.services.UserServiceTest

echo ========================================
echo Tests completed!
echo ========================================
pause
