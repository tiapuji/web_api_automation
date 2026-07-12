# UI & API Test Automation Framework

Framework automation testing menggunakan **Java**, **Selenium WebDriver**, **Rest Assured**, **Cucumber**, **JUnit**, dan **Allure Report** untuk melakukan pengujian **UI Web** dan **API**.

---

# Struktur Project

```text
├───src
│   ├───main
│   │   ├───java
│   │   │   └───org
│   │   │       └───example
│   │   │           ├───pages
│   │   │           └───utils
│   │   └───resources
│   └───test
│       ├───java
│       │   ├───hooks
│       │   ├───runners
│       │   └───stepdefinitions
│       └───resources
│           └───features
└───target

```

---

# Cara Menjalankan

## Clone Repository

```bash
git clone https://github.com/username/nama-repository.git
```

Masuk ke folder project

```bash
cd nama-repository
```

---

## Menjalankan API Test

```bash
./gradlew clean test --tests runners.ApiRunner
```

---

## Menjalankan UI Web Test

```bash
./gradlew clean test --tests runners.WebRunner
```

---

# Laporan Hasil Test

## HTML Report

Setelah test selesai dijalankan, laporan dapat dilihat pada:

```text
build/reports/tests/test/index.html
```

---

## Allure Report

Generate report

```bash
./gradlew allureReport
```

Menampilkan report

```bash
./gradlew allureServe
```

Lokasi hasil report

```text
build/reports/allure-report/
```

---

# Test Case

## API Automation

| No | Test Case | Status |
|----|-----------|--------|
| 1 | Register User Successfully | ✅ |
| 2 | Register User Failed | ✅ |

---

## UI Web Automation

| No | Test Case               | Status |
|----|-------------------------|--------|
| 1 | Login Successfully      | ✅ |
| 2 | Login Login Gagal       | ✅ |
| 3 | Username Kosong         | ✅ |
| 4 | Username Sangat Panjang | ✅ |

---

# Continuous Integration

Project ini telah dikonfigurasi menggunakan **GitHub Actions**.

Workflow akan berjalan secara otomatis ketika:

- Push ke repository
- Pull Request dibuat atau di-merge

GitHub Actions akan:

- Build project
- Menjalankan automation test
- Menghasilkan laporan test
- Mengunggah hasil report sebagai artifact
