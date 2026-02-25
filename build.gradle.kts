import org.jreleaser.model.Active

plugins {
    glass(JAVA)
    glass(PUBLISHING)
    glass(SIGNING)
    spotless(GRADLE)
    spotless(JAVA)
    alias(libs.plugins.jreleaser)
}

group = "team.idealstate.sugar.boot"
version = "0.1.1-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
        vendor.set(JvmVendorSpec.AZUL)
    }
}

glass {
    release.set(8)

    withCopyright()
    withMavenPom()

    withSourcesJar()
    withJavadocJar()

    withInternal()
    withShadow()

    withJUnitTest()
}

repositories {
    mavenLocal()
    aliyun()
    sonatype()
    sonatype(SNAPSHOT)
    mavenCentral()
}

dependencies {
    compileOnly(libs.sugar.next)
    annotationProcessor(libs.sugar.next)
    testCompileOnly(libs.sugar.next)
    testAnnotationProcessor(libs.sugar.next)

    api(libs.jedis)

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    testCompileOnly(libs.lombok)
    testAnnotationProcessor(libs.lombok)
}

publishing {
    repositories {
        project(project)
        maven {
            name = "nustar-snapshots"
            url = uri("https://maven.nustar.top/repository/nustar-snapshots/")
            properties(project).login()
        }
    }
}
