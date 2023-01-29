plugins {
    java
    id("io.freefair.lombok") version "6.5.1"
}

group = "com.cognizant.payments"
version = "1.0.0"


object Versions {
    val guava_version = "30.1-jre"
    val hamcrest_version="2.2"
    val junit_version="5.7.2"
    val lombok_version="1.18.20"
    val mockito_version="4.8.1"
}

object Deps {
    val guava = "com.google.guava:guava:${Versions.guava_version}"

	val hamcrest_library = "org.hamcrest:hamcrest-library:${Versions.hamcrest_version}"

    val junit_jupiter_api = "org.junit.jupiter:junit-jupiter-api:${Versions.junit_version}"
    val junit_jupiter_engine="org.junit.jupiter:junit-jupiter-engine:${Versions.junit_version}"
    val junit_jupiter_vintage="org.junit.vintage:junit-vintage-engine:${Versions.junit_version}"

    val lombok_library = "org.projectlombok:lombok:${Versions.lombok_version}"
    val mockito_core = "org.mockito:mockito-core:${Versions.mockito_version}"
    val mockito_junit_jupiter="org.mockito:mockito-junit-jupiter:${Versions.mockito_version}"
}


allprojects {
    repositories {
        mavenCentral()
	    gradlePluginPortal()
    }
}


dependencies {
    compileOnly(Deps.lombok_library)

    testImplementation(Deps.junit_jupiter_api)
    testImplementation(Deps.junit_jupiter_engine)
    testImplementation(Deps.hamcrest_library)

    testImplementation(Deps.mockito_core)

    testImplementation(Deps.mockito_junit_jupiter)

}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}


tasks.withType<Test> {
    useJUnitPlatform()
    this.testLogging {
        this.showStandardStreams = true
        this.events("PASSED", "SKIPPED", "FAILED")
    }
}

