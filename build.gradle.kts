import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.9"
    id("io.spring.dependency-management") version "1.1.4"
    id ("com.apollographql.apollo3") version "3.8.3"
    kotlin("plugin.spring") version "1.9.23"
    kotlin("jvm") version "1.9.23"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation ("com.apollographql.apollo3:apollo-runtime")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

apollo {
    service("github") {
        srcDir("src/main/graphql/github")
        packageName.set("com.github")
        generateKotlinModels.set(true)
    }
}
