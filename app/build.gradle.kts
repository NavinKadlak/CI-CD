plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.nsk.testcicd"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.nsk.testcicd"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)


// ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")

    // LiveData (optional, if you use LiveData)
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")

    // Lifecycle runtime (needed for lifecycle awareness)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")

    // Optional: For observing lifecycle in non-UI classes
    implementation("androidx.lifecycle:lifecycle-common-java8:2.8.4")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // JUnit
  //  testImplementation("junit:junit:4.13.2")
// Mockito
    testImplementation("org.mockito:mockito-core:5.7.0")
// Kotlin coroutine testing
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
// AndroidX test
    testImplementation("androidx.arch.core:core-testing:2.2.0")
// Turbine (Flow testing)
    testImplementation("app.cash.turbine:turbine:1.0.0")

}