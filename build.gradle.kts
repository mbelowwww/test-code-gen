group = "ru.belov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

plugins {
    kotlin("jvm") version "1.9.21"
    id("org.openapi.generator") version "7.0.1"
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.moshi:moshi:1.15.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.15.0")

    testImplementation("org.jetbrains.kotlin:kotlin-test:1.9.22")
}

tasks.register<Copy>("generateApiJar") {
    dependsOn("generateJar")
    from(layout.buildDirectory.dir("generated/build/libs"))
    include("*.jar")
    into(layout.buildDirectory)
}

task<Exec>("generateJar") {
    dependsOn("openApiGenerate")
    commandLine("sh", "./generate-jar.sh")
}

openApiGenerate {
    inputSpec.set("$rootDir/openapi/spec.yaml")
    outputDir.set("$rootDir/build/generated")
    generatorName.set("kotlin")
    groupId = "ru.belov"
    id = "api"
    version = "1.0.0"
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}