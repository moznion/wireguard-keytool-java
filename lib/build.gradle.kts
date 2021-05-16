plugins {
    `java-library`
    jacoco
    id("com.diffplug.spotless") version "5.12.5"
}

repositories {
    mavenCentral()
}

buildscript {
    repositories {
        mavenCentral()
    }
}

dependencies {
    implementation("com.google.crypto.tink:tink:1.5.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testImplementation("org.assertj:assertj-core:3.19.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.build {
    dependsOn("spotlessApply")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
}

spotless {
    java {
        importOrder()
        target("**/*.java")
    }
}
