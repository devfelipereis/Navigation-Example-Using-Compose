### libs.version.toml

```
[versions]
navigationCompose = "2.8.0-beta05"
kotlinxSerializationJson = "1.7.1"

[libraries]
androidx-navigation-compose = { module = "androidx.navigation:navigation-compose", version.ref = "navigationCompose" }
kotlinx-serialization-json = { module = "org.jetbrains.kotlinx:kotlinx-serialization-json", version.ref = "kotlinxSerializationJson" }
```

### build.gradle.kts (:app)

```kotlin
plugins {
    ....
    kotlin("plugin.serialization") version "1.9.23"
}
```

```kotlin
dependencies {
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)
    ...
}
```
