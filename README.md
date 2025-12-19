# PortfolioApp

 A personal **Android Portfolio App** built using Kotlin and XML, designed to showcase your skills, experience, certificates, and projects — all in one elegant mobile interface.

 ---

 ## Features

- About Section – A brief introduction about yourself.
  
- Projects Section – Showcases your projects with brief details.
  
- Resume Section – Displays your resume in an interactive view.

- Certificates Section – Displays your achievements and certifications.

- Experience Section – Highlights your professional and technical experiences.

- Smooth Navigation – Implemented using ViewPager2 and Fragments for a clean UI experience.

- Full-Screen Image Viewer – Click on any certificate to view it in full screen with smooth fade transitions.

- Light & Dark Mode Toggle – Switch between light and dark themes for better visual comfort.

---

## Built With

- Language: Kotlin

- UI Design: XML

- Architecture: Fragment-based (ViewPager2 + Adapter)

- IDE: Android Studio

- Build System: Gradle (Kotlin DSL)

---

## Project Structure

```bash
app/
├── manifests/
│   └── AndroidManifest.xml
├── kotlin+java/com/example/portfolio/
│   ├── AboutFragment.kt
│   ├── CertificatesFragment.kt
│   ├── ExperiencesFragment.kt
│   ├── ProjectsFragment.kt
│   ├── ResumeFragment.kt
│   ├── ViewPagerAdapter.kt
│   ├── FadePageTransformer.kt
│   └── MainActivity.kt
├── res/
│   ├── layout/
│   │   ├── activity_main.xml
│   │   ├── dialog_fullscreen_image.xml
│   │   ├── fragment_about.xml
│   │   ├── fragment_certificates.xml
│   │   ├── fragment_experiences.xml
│   │   ├── fragment_projects.xml
│   │   ├── fragment_resume.xml
│   │   └── nav_header.xml
│   ├── drawable/
│   ├── mipmap/
│   ├── values/
│   └── xml/
└── build.gradle.kts
```

---

## Download the App

🔗 [**Click here to download the latest APK**](https://github.com/mrudulasadafule03/PortfolioApp/releases/download/v1.0/app-debug.apk)

 ---

 ## Screenshots


| About                                                                                    | Projects                                                                                           | Resume                                                                                         | Certificates                                                                                       |  Experiences                                                                                   |
| ---------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------ | -------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------ |
| <img src="https://github.com/mrudulasadafule03/PortfolioApp/blob/main/assets/AboutPage.jpg" width="420px"> | <img src="https://github.com/mrudulasadafule03/PortfolioApp/blob/main/assets/ProjectPage.jpg" width="350px"> | <img src="https://github.com/mrudulasadafule03/PortfolioApp/blob/main/assets/ResumePage.jpg" width="650px"> | <img src="https://github.com/mrudulasadafule03/PortfolioApp/blob/main/assets/CertificatePage.jpg" width="270px"> | <img src="https://github.com/mrudulasadafule03/PortfolioApp/blob/main/assets/ExperiencePage.jpg" width="350px">  |

