@web
Feature: Login

  Scenario: Login berhasil
    Given pengguna membuka halaman login
    When pengguna memasukkan username "tomsmith"
    And pengguna memasukkan password "SuperSecretPassword!"
    And pengguna menekan tombol login
    Then login berhasil

  Scenario: Login gagal
    Given pengguna membuka halaman login
    When pengguna memasukkan username "admin"
    And pengguna memasukkan password "12345"
    And pengguna menekan tombol login
    Then muncul pesan login gagal

  Scenario: Username kosong
    Given pengguna membuka halaman login
    When pengguna memasukkan username ""
    And pengguna memasukkan password "password"
    And pengguna menekan tombol login
    Then muncul pesan login gagal

  Scenario: Username sangat panjang
    Given pengguna membuka halaman login
    When pengguna memasukkan username "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    And pengguna memasukkan password "password"
    And pengguna menekan tombol login
    Then muncul pesan login gagal