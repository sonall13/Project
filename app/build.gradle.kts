import org.gradle.internal.impldep.bsh.commands.dir
import java.util.regex.Pattern.compile

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.serene"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.serene"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        multiDexEnabled
        true
        viewBinding
        true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {


    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    api("com.theartofdev.edmodo:android-image-cropper:2.8.+")
    //implementation("'com.squareup.okhttp:okhttp:3.0.0'")


    implementation("com.android.support:multidex:1.0.3")
// for adding cardview
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
//noinspection GradleCompatible
    compile("com.android.support:cardview-v7:21.0.0-rc1")
    implementation("com.makeramen:roundedimageview:2.3.0")

    val dynamicanimation_version = "1.0.0"
    implementation("androidx.dynamicanimation:dynamicanimation:$dynamicanimation_version")
// otpview
    implementation ("io.github.chaosleung:pinview:1.4.4")
//horizontal calander view
    implementation ("devs.mulham.horizontalcalendar:horizontalcalendar:1.1.7")
//lottie animation
    implementation ("com.airbnb.android:lottie:6.4.0")
//media player


//glide
    implementation ("com.github.bumptech.glide:glide:4.9.0")


}