# Gradle 依赖

> 以下的 gradle 依赖示例中，可能并非最新的 MyBatis-Flex 版本，请自行查看最新版本，并修改版本号。

> 建议配置 annotationProcessor，那么可以省略 mybatis-flex-processor 的依赖


1、只用到了 MyBatis，没用到 Spring 的场景：

**【Kotlin】**

```kotlin
dependencies {
    implementation("com.mybatis-flex:mybatis-flex-core:1.5.7")
    compileOnly("com.mybatis-flex:mybatis-flex-processor:1.5.7")
}
```

**【Groovy】**

```groovy
dependencies {
    implementation 'com.mybatis-flex:mybatis-flex-core:1.5.7'
    compileOnly 'com.mybatis-flex:mybatis-flex-processor:1.5.7'
}
```

2、用到了 Spring 的场景

**【Kotlin】**
```kotlin
dependencies {
    implementation("com.mybatis-flex:mybatis-flex-spring:1.5.7")
    compileOnly("com.mybatis-flex:mybatis-flex-processor:1.5.7")
}
```

**【Groovy】**
```groovy
dependencies {
    implementation 'com.mybatis-flex:mybatis-flex-spring:1.5.7'
    compileOnly 'com.mybatis-flex:mybatis-flex-processor:1.5.7'
}
```

3、用到了 Spring Boot 的场景

**【Kotlin】**

```kotlin
dependencies {
    implementation("com.mybatis-flex:mybatis-flex-spring-boot-starter:1.5.7")
    compileOnly("com.mybatis-flex:mybatis-flex-processor:1.5.7")
}
```

**【Groovy】**

```groovy
dependencies {
    implementation 'com.mybatis-flex:mybatis-flex-spring-boot-starter:1.5.7'
    compileOnly 'com.mybatis-flex:mybatis-flex-processor:1.5.7'
}
```

4、配置 annotationProcessor

`mybatis-flex-processor` 提供 APT 服务，可以配置到 annotationProcessorPaths 中，配置后，无需在依赖中声明 `mybatis-flex-processor` 依赖。

参考：[APT 设置-和 Lombok、Mapstruct 整合](../others/apt.md)

> 在 Kotlin 中使用时，请参考[在 Kotlin 中使用注解处理器](../others/kapt.md)

**【Kotlin】**

```kotlin
dependencies {
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:1.5.7")
}
```

**【Groovy】**

```groovy
dependencies {
    annotationProcessor 'org.springframework.boot:spring-boot-configuration-processor:1.5.7'
}
```
