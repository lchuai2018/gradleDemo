## 一、简介
### 1.1 概述
Gradle是基于JVM构建工具的新一代版本，它使用一种强大且具有表达性的基于Groovy的领域特定语言(DSL)，
而不是XML(Ant、Maven基于xml)，允许使用Java或者Groovy语言编写定制逻辑，其实Gradle就是Groovy，
它提供了基于Java的语法糖，你编写的所有脚本都是Groovy，能够以编程语言来表达你需要的构建是Gradle的一大亮点。
Gradle的座右铭：“让不可能成为可能，让可能变得简单，让简单变得优雅”
### 1.2 特性
①可表达性的构建语言和底层API：在Gradle脚本中每一个元素都有一个与Java类一对一的映射，如每一个构建脚本映射成Gradle API中的Project类型的一个实例，
dependencies配置块触发project实例的dependencies()方法。
②灵活的约定：Gradle最主要的思想之一就是针对你的项目给予引导和有意义的默认值，Gradle具有统一的项目结构布局（如图），Gradle中的每个Java项目都确切的知道源码和测试类文件的位置，
知道如何编译源码，运行单元测试，发布代码，这些任务都被完全集成到了构建的生命周期中。
③鲁棒和强大的依赖管理：Gradle提供了一个基础设施去管理解析、获取和存储依赖的复杂性，一旦相关的依赖被下载到本地缓存中，那么在你的项目中就可以使用了。
4．配置相关依赖代码量少，不会像maven一样xml过多 
5．打包编译测试发布都有，而且使用起来方便 
6．利用自定义的任务可以完成自己想要的功能
### 1.3 安装
gradle下载地址：https://services.gradle.org/distributions/
gradle安装参考地址：https://www.cnblogs.com/wumz/p/10948908.html
gradle指定配置本地仓库：https://blog.csdn.net/qq_22172133/article/details/81513955
### 1.4 基本使用
1.简单使用，从HelloWorld开始：创建一个build.gradle文件，定义一个helloWorld的任务(task)，将打印语句添加到action中(doLast)。
task helloWorld{
    doLast{
        println('Hello World!')
    }
}
运行该task：
gradle -q helloWorld
Hello World!
2.Gradle命令行：我们是通过命令行来执行gradle脚本的，如之前gradle helloWorld就直接可以运行helloWorld task。
  ①tasks 命令：gradle -q tasks命令可以显示该脚本所有可用的task，gradle -q tasks –all 可以获得关于task的更多信息。
  ②gradle命令可以一次执行多个任务，gradle yayGradle0 groupTherapy命令会先执行yayGradle0 任务在执行groupTherapy任务，但是任务只会执行一次，yayGradle0 作为groupTherapy的依赖也只会执行一次。
  ③gradle可以以守护进程开启，gradle helloWorld –daemon，启动后，gradle会在后续的构建中重用之前创建的守护进程，避免启动时造成开销。

3.构建Java项目。
运行gradle build命令，
UP-TO-DATE意味着任务被跳过,Gradle增量式构建支持自动鉴别不需要被运行的任务。
NO-SOURCE因为我没有建相关目录。
>gradle build
> Task :compileJava UP-TO-DATE   //编译Java产品代码
> Task :processResources NO-SOURCE
> Task :classes UP-TO-DATE
> Task :jar UP-TO-DATE           //组装JAR文件
> Task :assemble UP-TO-DATE
> Task :compileTestJava NO-SOURCE  //编译测试代码，我没有编写相关测试代码
> Task :testClasses UP-TO-DATE     
> Task :test NO-SOURCE           //运行测试
> Task :check UP-TO-DATE
> Task :build UP-TO-DATE

>
### 1.5 gradle配置详细说明
1、setting.gradle
此配置文件位于根目录下，用于指示Gradle在构建应用时应将哪些模块包含在内；多个模块之间用空格隔开。
例1：
//根项目名称
rootProject.name = 'vevor-parent'
include ':app', ':lib'
例2：
 //根项目名称
rootProject.name = 'vevor-parent'
include 'vevor-admin'
include 'vevor-core'
include 'vevor-elasticsearch'
build.gradle文件属性详细说明，如下：
//创建项目输入groupId
group 'pers.gradle'
//创建项目所输入的版本
version '1.0-SNAPSHOT'
//指定运行环境，java
apply plugin: 'java'
//jdk的版本，1.8
sourceCompatibility = 1.8
/**
 * 指定所使用仓库的路径
 * mavenCentral()，中央仓库，项目中所使用的jar包都会从中央仓库下载到本地仓库。
 *                 若本地仓库已经拥有相应的jar包，则不会重复下载
 *                 可以使用命令maven { url "http://maven.aliyun.com/nexus/content/groups/public" }指定maven的远程仓库地址
 * mavenLocal()本地仓库，与GRADLE_USER_HOME配置的路径一致。
 * */
repositories {
    mavenLocal()
    maven { url "http://maven.aliyun.com/nexus/content/groups/public" }
    mavenCentral()
}
/**
 * gradle所有的jar包文件坐标都在dependencies属性内放置
 * 每一个jar包都具备以下特点
 * 1.scope（作用域）：gradle支持compile、runtime、testCompile、testRuntime四种scope
 *   compile：jar包在编译期与运行期依赖。
 *   runtime：jar包在运行期依赖。
 *   testCompile：jar包在测试编译期与运行期依赖。
 *   testRuntime：jar包在测试运行期依赖。
 *   补充：
 *   providedCompile：jar包/依赖代码 仅在编译的时候需要，但是在运行时不需要依赖。
 *   providedCompile与compile,runtime区别：
 *   compile: 前提：apply plugin: 'war'或者apply plugin: 'java'
 *   providedCompile:前提：apply plugin: 'war'，若前提为'java',则使用compileOnly
 *   runtime:前提：apply plugin: 'war'
 *   以上所说的前提，如果不正确配置的话，就会遇到依赖包无法导入，以及runtime以及providedCompile无法使用的情况。
 * 2. group:与maven的groupId一致。
 *    name:与maven的artifactId一致。
 *    version:与maven的version一致。
 */
 
 dependencies {
     //gradle jar包坐标可以访问，maven中央仓库[https://mvnrepository.com]，找到相对应的jar包，选择[gradle]选项卡，复制该地址即可。
     testCompile group: 'junit', name: 'junit', version: '4.12'
     //引入spring依赖
     compile group: 'org.springframework', name: 'spring-context', version: '5.1.5.RELEASE'
     //引入lombok依赖
     //@Data注解在类上，会为类的所有属性自动生成setter/getter、equals、canEqual、hashCode、toString方法，如为final属性，则不会为该属性生成setter方法。
     compileOnly group: 'org.projectlombok', name: 'lombok', version: '1.18.2'
 
 }
2、buildscript{ }
  主要配置Gradle代码托管库和依赖项；
3、repositories{ }
//详细说明：指定所使用的仓库
mavenLocal()//添加maven本地资源库，以上配置先本地仓库寻找依赖，如果没有在从中央仓库下载
mavenCentral()//表示使用中央仓库，此刻项目中需要的jar包都会默认从中央仓库下载到本地指定目录
如果只配置中央仓库，表示直接从中央仓库下载jar包。但是如果指定下载的位置已经有了，就不会再次下载了。
Gradle引用代码托管库，Gradle预先配置了远程支持JCenter、Maven、Central和lvy等存储区，当然也可以指定本地自定义的远程存储库,eg:google()；
JCenter():就可以使用JCenJCenter上托管的开源项目；
4、dependencies{ }
说明：gradle工程所有的jar包的坐标都在dependencies属性内放置
每一个jar包的坐标都有三个基本元素组成
group，name，version
testCompile：表示该jar包在测试的时候起作用，该属性为jar包的作用域
我们在gradle里面添加坐标的时候都要带上jar包的作用域
//作用域，testCompile，testCompile，
testCompile group: 'junit', name: 'junit', version: '4.12'
//引入spring依赖
compile group: 'org.springframework', name: 'spring-context', version: '5.1.5.RELEASE'
项目依赖Gradle的插件版本路径；
5、allprojects{ }
父子模块拆分与整合，全局配置依赖；子模块都能用。
引用子模块：dependencies{ compile project(":gradle_dao")}
配置所有模块中使用的依赖项，例如第三方插件或libraries；

### 1.6 gradle命令应用详解
1.命令详解
清理命令：gradle clean
构建打包命令：gradle clean build
编译时跳过测试，使用-x,-x参数用来排除不需要执行的任务：gradle clean build -x test
创建缓存依赖：执行命令gradle clean build --refresh-dependencies或删除.gradle/caches目录，构建的时候它会下载所有依赖并加入到缓存中。
2.查看项目已定义的所有task以及含义
gradle tasks
assemble: 编译
build：编译并执行测试
clean：删除build目录
jar： 生成jar包
test：执行单元测试
3.maven项目转换为gradle项目
根目录执行：gradle init --type pom
### 1.7 项目gradle的文件说明
.gradle，gradle的相关支持文件，不用管
.idea，IntelliJ IDEA的相关文件，不用管
build，构建生成物，存放项目构建中生成的class和jar包
gradle，一个gradle的包装程序，貌似直接用gradle不太好，得再包一层，这个其实我们也不用管
src，我们写代码的地方，不用说了吧
build.gradle，gradle的构建配置，这是我们要关心的，相当于Maven的pom.xml
GradleLearn.iml，IntelliJ IDEA的项目文件
gradlew，一段gradle wrapper的运行脚本，For *nix
gradlew.bat，一段gradle wrapper的运行脚本，For Windows