# Android App with LiveData and MVVM
## Android Studio Version
Android Studio Ladybug | 2024.2.1 Patch 2

## Language
Kotlin with JetPack Compose

## Purpose
This app is a demo of the use of **LiveData** and **MVVM** pattern

---

# Gradle dependencies
It is necessary to add the following dependencies in the file [`app/build.gradle.kts`](app/build.gradle.kts):

``` bash
dependencies {
    //This dependency provides the core components for using LiveData, ViewModel, and other lifecycle-aware components in your Android app. It's essential for implementing the MVVM architecture.
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    //This dependency is crucial for observing LiveData objects within your Compose UI. It provides the observeAsState() function, which allows you to convert LiveData values into Compose state, enabling your UI to automatically update when the LiveData changes. Explanation:
    implementation("androidx.compose.runtime:runtime-livedata:1.7.5")
}
```

# Screenshot
<img src="app/screenshots/Screenshot_20241120_164629.png" alt="App activity" width="300"/>

---
# References
- Example quotes: https://cursokotlin.com/mvvm-en-android-con-kotlin-livedata-y-view-binding-android-architecture-components/
- Example user: https://medium.com/@kevinhomorales/usa-mvvm-en-tus-apps-con-kotlin-2d337c619431
- Official doc about ViewModel: https://developer.android.com/topic/libraries/architecture/viewmodel?hl=es-419#jetpack-compose_1

---
# Official Course
https://developer.android.com/courses/jetpack-compose/course?gclid=Cj0KCQiAhomtBhDgARIsABcaYym0EHsDfz7aJLKopqZ3VUztWyIg5x_16ED13T62_WZfqsGLYQQicKMaAvExEALw_wcB&gclsrc=aw.ds
