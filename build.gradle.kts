plugins {
    kotlin("jvm") version "1.3.72"
}

version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("net.portswigger.burp.extender:burp-extender-api:2.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.3.7")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")
}

targetCompatibility = '1.8'
sourceCompatibility = '1.8'

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

tasks.withType<Jar> {
    from(configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}
