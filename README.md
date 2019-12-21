### 一、 个人理解gradle
1.gradle能自动下载jar包，又可以写脚本。
2.功能更强大,可以很方便的自定义任务。
3.与maven相比依赖添加更简洁方便。
4.多模块化构建
5.约定优于配置
6.依赖管理
生命周期:
总的执行顺序 初始化->配置->执行阶段
### 二、 搭建项目中遇到的问题
1.多模块打包子项目出现问题
FAILURE: Build failed with an exception.
* What went wrong:
Execution failed for task ':vevor-erp:bootJar'.
解决方法：
需在子项目，或者子模块配置：
bootJar.enabled = false
//这里一定得要。在多模块下，不然编译失败，因为不会把信赖模块给打包。
jar.enabled = true

### 三、 项目实践解决的方案
1.项目启动出现WARN：No URLs will be polled as dynamic configuration sources.
解决方案：.在src/main/resources下添加空的config.properties
2.项目启动出现Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
解决方案：整合spring boot项目过程中出现的，用了最新的mysql 连接驱动
需要将 com.mysql.jdbc.Driver  改为  com.mysql.cj.jdbc.Driver
3.项目多模块引用各个模块，需如下配置
  compile project(":vevor-core")
  compile project(":vevor-erp:vevor-erp-service")
4.项目使用consul作为服务注册中心及配置文件中心，需引用如下包：
 implementation "org.springframework.boot:spring-boot-starter-actuator"
 implementation "org.springframework.cloud:spring-cloud-starter-consul-discovery"
 implementation "org.springframework.cloud:spring-cloud-starter-consul-config"
5.数据库连接池配置，需添加依赖如下：
 compile group: 'com.alibaba', name: 'druid-spring-boot-starter', version: '1.1.18'

### 四、 项目注意配置事项
1.任务的编码格式
    //指定编码格式
    tasks.withType(JavaCompile) {
        options.encoding = "UTF-8"
}
说明：
指定编码格式，这是一种方式。也可以在IDEA中，需要打开File->Other Settings->Default Settings->Gradle，在Gradle Vm Options中设置-Dfile.encoding=utf-8
2.使用Gradle依赖配置作用域compile，implementation和api的区别
api：当其他模块依赖于此模块时，此模块使用api声明的依赖包是可以被其他模块使用
implementation：当其他模块依赖此模块时，此模块使用implementation声明的依赖包只限于模块内部使用，不允许其他模块使用。
### 五、 一些基本配置说明
1.allprojects{} 配置整个项目公用的属性与插件。
2.subprojects{} 配置的是子模块的公用属性与插件
3.archivesBaseName = 'core'  jar包的名称

### 六、待解决的问题
1.Springboot版本及Springcloud版本兼容问题。
2.项目中配置swagger的使用
3.单元测试的配置及使用