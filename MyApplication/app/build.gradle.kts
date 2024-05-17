plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("com.google.zxing:core:3.4.1")
    implementation("com.journeyapps:zxing-android-embedded:4.2.0")
    implementation("com.rmtheis:tess-two:9.1.0")

    implementation ("com.google.code.gson:gson:2.8.6")
    implementation ("com.squareup.okhttp3:okhttp:4.9.0")
    implementation ("com.apollographql.apollo:apollo-runtime:2.5.9")
    implementation ("com.apollographql.apollo:apollo-android-support:2.5.9")


    implementation ("com.amplifyframework:aws-api:2.16.1")
    implementation ("com.amplifyframework:aws-datastore:2.16.0")
    implementation("com.amplifyframework:aws-auth-cognito:2.16.1")
    implementation ("com.amplifyframework:core:2.16.1")
    implementation("com.amplifyframework:aws-storage-s3:2.16.0")
    implementation("com.amplifyframework.ui:authenticator:1.2.0")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.3")
}