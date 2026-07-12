@api
Feature: Register API

  Scenario: Register user successfully
    Given Register API tersedia
    When User register menggunakan data dari "Register.json"
    Then Response status code adalah 201
    And Response success bernilai true

  Scenario: Register gagal
    Given Register API tersedia
    When User register menggunakan data dari "Registernegative.json"
    Then Response status code error
    And Response success bernilai false