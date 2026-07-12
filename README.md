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
└── build
    └── reports
        └── cucumber
            ├── api-report.html      ✅
            ├── api-report.json
            ├── web-report.html      ✅
            └── web-report.json

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

## Report

```text
Report yang digunakan yaitu cucumber report. Lokasi hasil report :

└── build
    └── reports
        └── cucumber
            ├── api-report.html   ✅
            ├── api-report.json
            ├── web-report.html   ✅
            └── web-report.json

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
