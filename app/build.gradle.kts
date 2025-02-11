

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("ru.ok.tracer").version("1.0.2")
}

android {
    namespace = "com.example.rantekscalc"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.rantekscalc"
        minSdk = 24
        targetSdk = 35
        versionCode = 5
        versionName = "1.1.2"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("debug")

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true

    }



}

tracer {
    create("defaultConfig") {

        pluginToken = "QmRZItCJnTJCkHfJAlengvuzEhvSwRjGn2VpyMuVg2D2"
        appToken = "66jiYegGmQs5zdLVubReuKVCFOulvcSe2Rx2SuS3YWR0"

        // Включает загрузку маппингов для билда. По умолчанию включена
        uploadMapping = true

        // Включает загрузку отладочной информации из native-библиотек для обработки нативных крешей
        // Обрабатывает всё, что попадает в build/intermediates/merged_native_libs
        // т.е. модули с NDK-кодом, библиотеки из зависимостей, библиотеки из jniLibs, ...
        // Не загружает отладочную информацию для библиотек, у которых нет отладочной информации
        //
        // Без сборщика нативных крешей включать не очень осмысленно
        // По умолчанию выключено
        uploadNativeSymbols = true


    }
}


dependencies {


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.inappmessaging)
    implementation(libs.androidx.cardview)
    implementation(libs.firebase.crashlytics.buildtools)

//Tracer
    implementation(platform("ru.ok.tracer:tracer-platform:1.0.2"))
    // Сбор и анализ крешей и ANR
    implementation("ru.ok.tracer:tracer-crash-report")
    // Сбор и анализ нативных крешей
    implementation("ru.ok.tracer:tracer-crash-report-native")
    // Сбор и анализ хипдапмов при OOM
    implementation("ru.ok.tracer:tracer-heap-dumps")
    // Семплирующий профайлер
    implementation("ru.ok.tracer:tracer-profiler-sampling")
    // Систрейс
    implementation("ru.ok.tracer:tracer-profiler-systrace")
    //noinspection GradlePath


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
