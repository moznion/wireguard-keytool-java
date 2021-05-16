plugins {
    `java-library`
    jacoco
    `maven-publish`
    signing
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
    withJavadocJar()
    withSourcesJar()
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

publishing {
    publications {
        create<MavenPublication>("maven") {
            group = "net.moznion"
            artifactId = "wireguard-keytool"
            version = "0.0.1"
            from(components["java"])
            pom {
                name.set("wireguard-keytool")
                description.set("An utility library for WireGuard keys")
                url.set("https://github.com/moznion/wireguard-keytool-java")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("moznion")
                        name.set("Taiki Kawakami")
                        email.set("moznion@mail.moznion.net")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/moznion/wireguard-keytool-java.git")
                    developerConnection.set("scm:git:ssh://github.com/moznion/wireguard-keytool-java.git")
                    url.set("https://github.com/moznion/wireguard-keytool-java")
                }
            }
        }
    }
    repositories {
        maven {
            val releasesRepoUrl: String = "https://oss.sonatype.org/service/local/staging/deploy/maven2"
            val snapshotsRepoUrl: String = "https://oss.sonatype.org/content/repositories/snapshots"
            setUrl(uri(if ((version as String).endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl))
            credentials {
                username = findProperty("sonatypeUsername") as String
                password = findProperty("sonatypePassword") as String
            }
        }
    }
}

signing {
    sign(publishing.publications["maven"])
}
