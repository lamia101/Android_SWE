plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
    id("org.jetbrains.dokka") version "1.9.0"

}

android {
    namespace = "com.devdroid.kikinbo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.devdroid.kikinbo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    packaging {
        resources {
            // Exclude conflicting files
            excludes += "META-INF/NOTICE.md"
            excludes += "META-INF/LICENSE.md" // Optional, if similar conflicts occur
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
tasks.dokkaHtml.configure { outputDirectory.set(file("../documentation/html")) }

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)
    testImplementation(libs.junit)
    testImplementation(libs.junit.jupiter)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("org.jetbrains.dokka:dokka-core:1.9.0")
    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")

    // Mockito for mocking
    testImplementation ("org.mockito:mockito-core:3.6.28")
    testImplementation ("org.mockito:mockito-inline:3.6.28")
}