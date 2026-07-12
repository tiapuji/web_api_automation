@echo off
title Automation Test + Allure Report

echo =====================================
echo Running Automation Test...
echo =====================================

call gradlew clean test

echo.
echo =====================================
echo Opening Allure Report...
echo =====================================

allure serve build\allure-results

pause