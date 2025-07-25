plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "cc.jtogashi.mapboxnavuxsupporthelper"
    compileSdk = 35

    defaultConfig {
        applicationId = "cc.jtogashi.mapboxnavuxsupporthelper"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        resValue(
            "string",
            "mapbox_access_token",
            providers.gradleProperty("MAPBOX_PUBLIC_TOKEN").get()
        )

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

    packaging {
        resources {
            excludes += setOf(
                // To compile the current version of UX Framework you need to add only these three lines:
                "META-INF/DEPENDENCIES",
                "META-INF/INDEX.LIST",
                "dash-sdk.properties",
            )
        }
    }

}


dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation(libs.mapbox.navux)

    // workaround for NavUX
    implementation(libs.protobuf)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}