plugins {
	java
	id("org.springframework.boot") version "2.2.1.RELEASE" // Upgrade Spring Boot
	id("io.spring.dependency-management") version "1.0.11.RELEASE" // Upgrade Plugin
}

group = "org.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(11))
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {

	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	runtimeOnly("io.micrometer:micrometer-registry-prometheus")

	implementation("com.github.loki4j:loki-logback-appender:1.5.2")

//	implementation("io.micrometer:micrometer-tracing-bridge-brave")
//	implementation("io.zipkin.reporter2:zipkin-reporter-brave")

	// Tracing
	implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
	implementation("org.springframework.cloud:spring-cloud-starter-zipkin")

}

tasks.withType<Test> {
	useJUnitPlatform()
}



dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR12")
	}
}
