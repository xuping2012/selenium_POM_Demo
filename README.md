# selenium_pom_demo项目：一句话介绍
[Java版]WEB自动化测试框架selenium采用PO思想与PageFactory设计模式结合，应用企业级UI自动化测试框架。

# 框架技术
### 运行环境
- 少不了的jdk环境：基本建议1.8以上
- - 分清楚：jre是java运行环境，jdk是java开发环境
- selenium框架支持java、python、ruby等等多种编程语言
- 注意各种浏览器驱动选择：
- - selenium与当前chrome浏览器的版本：http://chromedriver.storage.googleapis.com/index.html
- - 火狐、ie的driver驱动分windows和linux版本
- testng单元测试框架
- maven项目管理工具
- - pom中配置了testng依赖、selenium依赖、log依赖、poi依赖
- allure生成报告插件
- jenkins集成工具
- - 不要去浪费时间去开发发送邮件的工具类，只要好好生成测试报告，因为这些东西在集成jenkins之后都会迎刃而解。  

# java编程基础
### 开发环境搭建
- 这个不解释，eclipse或IDE或其他开发工具随自己喜爱选择即可。
### 基础语法
- 注释、标识符、变量/常量
- 基本数据类型
- - 整数型：int、long、short、byte
- - 小数型：float、double
- - 字符型：char
- - 布尔型：boolean
- 引用数据类型
- - 字符串String
- - 接口interface
- - 数组Array
- 运算符
- - 赋值运算：=、+=、-=、/=、%=
- - 逻辑运算：&、|、^、！、；顺序：!>&>^>|>&&>||
- - 三目运算：(表达式)?表达式1:表达式2
- - 算术运算：加减乘除、%取余；自增++、自减--：在前是选运算再自增自减，在后是先赋值再自增自减
- - 比较运算：==、!=、<、<=、>、>=
- - 位运算等
- 流程控制
- - 分支语句：if、switch
- - 循环控制：while、do while
- - 关键字：break、continue
##### 四大特性
- 抽象
```
就是对同一个事物共有的属性<特征>和方法<功能/行为>进行抽取、归纳、总结;如一辆汽车，都有轮子、发动机、方向盘等特征，它就是属性；汽车能开动、载人载物等就是它的功能。
那么咱们可以将汽车的这些属性和方法抽取出来写在一个类中,供汽车这一类事物使用。
```
- 继承
```
关键字：extends；
子类继承父类的方法和属性，但是不能继承私有属性和构造方法；
一个子类只能有一个父类，但是父类可以有多个子类；
子类有自己的属性和方法，也能重写父类的方法；
继承是能提高代码的重用性。
```
- 封装
```
在抽象中将属性与方法写在一个类中就是封装，而封装就是为了保证抽象出来的特征和方法的安全性，封装就是包装的过程，
注意封装不是绝对的封装，如果其他程序要获取已经封装好的数据，就要通过程序指定的接口或方法才能获取。
```
- 多态
```
多态就是指同一种事物在不同的情况下的多种表现形式；
多态的表现形式有：方法重写，方法重载，接口和接口的继承，类和类的继承。
```
- - 方法的重载：在同一个类中，有多个方法名相同，但参数列表不同的方法，这就是方法的重载，参数列表的不同包括：参数个数，类型，顺序的不同。普通方法和构造方法都可重载，方法重载会根据传递的参数来决定调用哪个方法，返回值不同，其他都相同的情况是构不成方法的重载
- - 方法的重写：发生在子类继承父类的关系中，父类中的方法被子类继承，方法名，返回值类型，参数完全一样，但是方法体不一样那么说明父类中的该方法被子类重写了。


# selenium基础API
### 八大元素定位
- id(String element)
- name(String element)
- tagName(String element)
- className(String element)
- linkText(String element)
- partialLinkText(String element)
- cssSelector(String element)
- xpath(String element)
### WebDriver常用API
- 访问地址：get(url)
- - navigate().to(url)
- 获取地址：getCurrentUrl()
- 获取页面标题：getTitle()
- 获取源码：getPageSource():用于爬虫或更有用
- 关闭当前窗口：close()
- 关闭所有窗口：quit()
- 查找单个元素：findElement(By)
- 查找所有元素：findElements(By)<返回列表>
- 获取当前句柄：getWindowHandle()
- 获取所有窗口句柄集合：getWindowHandles()
### WebELement常用API
- 元素单击操作：click()
- 清除文本框内容：clear()
- 写入及按键操作：sendKey(String)
- 元素是否已显示：isDisplayed()
- 元素是否启用：isEnabled()
- 元素是否已选择：isSelected()
- 获取元素标签名：getTagName()
- 获取元素属性值：getAttribute(属性名)
- 获取元素文本值：getText()
- 提交表单：submit()
### 浏览器其他操作
- 窗口位置及大小
- 导航常用操作:前进后退、跳转地址
- 元素等待机制：显示等待、隐式等待、等待元素显示的方法
- 特殊元素操作&场景处理：iframe、input等标签、JavaScript处理

# 基于UI自动化测试框架的设计模式
### 线性脚本
- 准备一个demo
```
见测试用例类：test_linear_script
```

### po设计模式
- 说明
```
po编程的本质，即页面元素数据与测试用例的分离及封装页面元素操作的过程，将可能动态的页面元素与对象<类>属性、操作页面元素的操作抽象成函数；
以面向对象的方式理解抽象<一个页面>，实际就是java编程中解耦思想的应用；从而达到简化测试用例代码及提高测试代码的可维护性。
```

### PageFactory设计模式
```
与po设计模式思想大致差不多，它只不过是通过注解来定位页面元素，反而没有单独封装浏览器通用操作方法；故而节省开发成本；
选择使用po模式设计的方法,随着元素定位的获取及数量递增，元素定位与元素操作方法都会在一个类里维护，会造成代码冗余度过高；
而页面工厂模式呢，基于注解的开发模式会提高开发效率，使得代码块变得相对整洁可维护性提升；主要是@FindBy与@CacheLookup。
```
### 关键字设计模式
- 说明
```
使用到的java技术是反射原理；即动态获取数据的方法名调用类中定义的方法。
```

### 混合设计模式：po+关键字/数据驱动
- 说明
```
顾名思义：采用java反射机制从excel或其他数据源读取数据进行动态调用，完成数据+关键字驱动
```

## Maven项目管理工具
- 一句话介绍

## TestNG单元测试框架
- 一句话介绍

## 项目实战
#### 案例步骤，即生产线性脚本
```
即按步骤定位页面元素操作的行为，逐行执行的测试用例，且一个测试用例为一个用例，不受任何外界因素的影响，只与元素是否变化及测试数据有关。
还用不上testng单元测试框架，可以使用类中的main函数进行测试即可。
```
#### 编写第一个测试用例代码
```
使用testng框架中的注解，将一些通用部分代码抽离出来，@Test注解在一个函数之前即为一个测试用例。
```
#### 优化测试用例代码
```
功能测试用例的设计方法中，有边界值、等价类划分等，可能一个测试用例无法覆盖应有的场景，那么就需要多个@Test注解组成。
```
#### 通过TestNG框架注解@DataProvider数据提供者优化代码
```
@DataProvider(name="是给测试用例的引用的数据源驱动")注解返回的是一个二位数组，可以通过poi工具类读取excel表格的数据返回一个二维数组，在@Test(dataprovider="写入@数据注解定义的name")。
```

#### 使用@Parameters注解优化代码
```
需要在测试套件中定义<parameter name="与@Parameters中name对应" value="测试数据" />
```

#### 编写测试套件：testng.xml
```xml
在工程根目录新建一个以.xml结尾的文件，其中将需要测试的类配置到xml中，如：
<?xml version="1.0" encoding="UTF-8" ?>
<suite>
<test>
<classes>
<class name="为测试类的包名+类名" />
</classes>
</test>
</suite>
```
#### 集成surefire插件
```
集成的是maven-surefire-plugin插件，在pom中定义，支持mvn命令操作。
```
# 项目持续集成
### jenkins环境搭建
- windows & linux安装有何不同？
- - windows可根据用户系统版本下载对应exe文件或war包文件
- - linux可根据用户系统版本下载对应tar.gz二进制文件或docker部署安装
- jenkins工具配置
- - java环境
- - maven
- - git 或者 svn
- - E-mail插件配置
- - HTML报告插件配置
- 项目构建
- - 不同环境下构建项目<无头模式>
- - 触发器管理：主动、被动式
- - 构建后操作：邮件配置、报告展示