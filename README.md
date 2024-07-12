[//]: # (<p align="center">)

[//]: # (	<a href="https://hutool.cn/"><img src="https://cdn.jsdelivr.net/gh/looly/hutool-site/images/logo.jpg" width="45%"></a>)

[//]: # (</p>)
<p align="center">
	<strong>🍬A set of tools that keep Java sweet.</strong>
</p>

[//]: # (<p align="center">)

[//]: # (	👉 <a href="https://hutool.cn">https://hutool.cn/</a> 👈)

[//]: # (</p>)

<p align="center">
	<a target="_blank" href="https://search.maven.org/artifact/cn.hutool/hutool-all">
		<img src="https://img.shields.io/maven-central/v/cn.hutool/hutool-all.svg?label=Maven%20Central" />
	</a>
	<a target="_blank" href="https://license.coscl.org.cn/MulanPSL2">
		<img src="https://img.shields.io/:license-MulanPSL2-blue.svg" />
	</a>
	<a target="_blank" href="https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html">
		<img src="https://img.shields.io/badge/JDK-8+-green.svg" />
	</a>
	<a target="_blank" href="https://travis-ci.com/dromara/hutool">
		<img src="https://travis-ci.com/dromara/hutool.svg?branch=v5-master" />
	</a>
	<a href="https://www.codacy.com/gh/dromara/hutool/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=dromara/hutool&amp;utm_campaign=Badge_Grade">
		<img src="https://app.codacy.com/project/badge/Grade/8a6897d9de7440dd9de8804c28d2871d"/>
	</a>
	<a href="https://codecov.io/gh/dromara/hutool">
		<img src="https://codecov.io/gh/dromara/hutool/branch/v5-master/graph/badge.svg" />
	</a>
	<a target="_blank" href="https://gitter.im/hutool/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge">
		<img src="https://badges.gitter.im/hutool/Lobby.svg" />
	</a>
	<a target="_blank" href='https://gitee.com/dromara/hutool/stargazers'>
		<img src='https://gitee.com/dromara/hutool/badge/star.svg?theme=gvp' alt='star'/>
	</a>
	<a target="_blank" href='https://github.com/dromara/hutool'>
		<img src="https://img.shields.io/github/stars/dromara/hutool.svg?style=social" alt="github star"/>
	</a>
</p>

<br/>

[//]: # (<p align="center">)

[//]: # (	<a href="https://qm.qq.com/cgi-bin/qm/qr?k=QtsqXLkHpLjE99tkre19j6pjPMhSay1a&jump_from=webapi">)

[//]: # (	<img src="https://img.shields.io/badge/QQ%E7%BE%A4%E2%91%A6-715292493-orange"/></a>)

[//]: # (</p>)

[//]: # (-------------------------------------------------------------------------------)

[//]: # (<p align="center">)

[//]: # (	<a href="#"><img style="width: 45%" alt="" src="https://plus.hutool.cn/images/zanzhu.jpg"/></a>)

[//]: # (</p>)

-------------------------------------------------------------------------------

## 📚简介

`Hutool-Plus`是基于Hutool开源项目，进行功能增强的开源项目。 `Hutool-Plus`是一个功能丰富且易用的**Java工具库**，通过诸多实用工具类的使用，旨在帮助开发者快速、便捷地完成各类开发任务。
这些封装的工具涵盖了字符串、数字、集合、编码、日期、文件、IO、加密、数据库JDBC、JSON、HTTP客户端等一系列操作，
可以满足各种不同的开发需求。

-------------------------------------------------------------------------------

## 🛠️包含组件
一个Java基础工具类，对文件、流、加密解密、转码、正则、线程、XML等JDK方法进行封装，组成各种Util工具类，同时提供以下组件：

| 模块                |     介绍                                                                          |
| -------------------|---------------------------------------------------------------------------------- |
| hutool-aop         |     JDK动态代理封装，提供非IOC下的切面支持                                              |
| hutool-bloomFilter |     布隆过滤，提供一些Hash算法的布隆过滤                                                |
| hutool-cache       |     简单缓存实现                                                                     |
| hutool-core        |     核心，包括Bean操作、日期、各种Util等                                               |
| hutool-cron        |     定时任务模块，提供类Crontab表达式的定时任务                                          |
| hutool-crypto      |     加密解密模块，提供对称、非对称和摘要算法封装                                          |
| hutool-db          |     JDBC封装后的数据操作，基于ActiveRecord思想                                         |
| hutool-dfa         |     基于DFA模型的多关键字查找                                                         |
| hutool-extra       |     扩展模块，对第三方封装（模板引擎、邮件、Servlet、二维码、Emoji、FTP、分词等）            |
| hutool-http        |     基于HttpUrlConnection的Http客户端封装                                            |
| hutool-log         |     自动识别日志实现的日志门面                                                         |
| hutool-script      |     脚本执行封装，例如Javascript                                                      |
| hutool-setting     |     功能更强大的Setting配置文件和Properties封装                                        |
| hutool-system      |     系统参数调用封装（JVM信息等）                                                      |
| hutool-json        |     JSON实现                                                                       |
| hutool-captcha     |     图片验证码实现                                                                   |
| hutool-poi         |     针对POI中Excel和Word的封装                                                       |
| hutool-socket      |     基于Java的NIO和AIO的Socket封装                                                   |
| hutool-jwt         |     JSON Web Token (JWT)封装实现                                                    |

可以根据需求对每个模块单独引入，也可以通过引入`hutool-all`方式引入所有模块。

-------------------------------------------------------------------------------

## 📝文档

[**🌎English Documentation**](README-EN.md)

-------------------------------------------------------------------------------

[📘中文文档](https://doc.hutool.cn/pages/index/)

[📘中文备用文档](https://plus.hutool.cn/)

[📙参考API](https://apidoc.gitee.com/dromara/hutool/)

[🎬视频介绍](https://www.bilibili.com/video/BV1bQ4y1M7d9?p=2)

-------------------------------------------------------------------------------

[//]: # (## 🪙支持Hutool)

[//]: # ()
[//]: # (### 💳捐赠)

[//]: # ()
[//]: # (如果你觉得Hutool不错，可以捐赠请维护者吃包辣条~，在此表示感谢^_^。)

[//]: # ()
[//]: # ([Gitee上捐赠]&#40;https://gitee.com/dromara/hutool&#41;)

[//]: # ()
[//]: # (### 👕周边商店)

[//]: # ()
[//]: # (你也可以通过购买Hutool的周边商品来支持Hutool维护哦！)

[//]: # ()
[//]: # (我们提供了印有Hutool Logo的周边商品，欢迎点击购买支持：)

[//]: # ()
[//]: # (👉 [Hutool 周边商店]&#40;https://market.m.taobao.com/apps/market/content/index.html?wh_weex=true&contentId=331724720170&#41; 👈)

-------------------------------------------------------------------------------

## 📦安装

### 🍊Maven
在项目的pom.xml的dependencies中加入以下内容:

```xml
<dependency>
    <groupId>cn.hutool.plus</groupId>
    <artifactId>hutool-all</artifactId>
    <version>5.8.30</version>
</dependency>
```

### 🍐Gradle
```
implementation 'cn.hutool.plus:hutool-all:5.8.30'
```

### 📥下载jar

点击以下链接，下载`hutool-all-X.X.X.jar`即可：

- [Maven中央库](https://repo1.maven.org/maven2/cn/hutool-plus/hutool-all/5.8.30/)

> 🔔️注意
> Hutool-Plus 5.x支持JDK8+，对Android平台没有测试，不能保证所有工具类或工具方法可用。

### 🚽编译安装

访问Hutool-Plus的Gitee主页：[https://gitee.com/ssoss/hutool](https://gitee.com/ssoss/hutool-plus) 下载整个项目源码（v5-master或v5-dev分支都可）然后进入Hutool-Plus项目目录执行：

```sh
./hutool.sh install
```

然后就可以使用Maven引入了。

-------------------------------------------------------------------------------

### ⌨️使用例子

#### 1. Bean拷贝：自定义属性拷贝 与 默认属性转换

```Java
@Data
static class SysUserFb implements Serializable {

	private static final long serialVersionUID = 1L;

	private String depId;

	private String customerId;

	/**
	 * 估值 Double类型
	 */
	private Double value;
}

@Data
@Setter
static class SysUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long depart;

	private Double orgId;

	/**
	 * 估值 String类型
	 */
	private String value;
}

@Test
public void toBeanTest1(){
	// 创建源对象
	final SysUserFb sysUserFb = new SysUserFb();
	sysUserFb.setDepId("123");
	sysUserFb.setCustomerId("456");
	sysUserFb.setValue(1d);

	final SysUser sysUser = BeanUtil.toBean(sysUserFb, SysUser.class, (targetProp, source, target, sourceValue) -> {
		// 相同属性不同类型：把属性值进行逻辑运算，并赋值给目标属性
		targetProp.set(source::getValue, target::getValue, Double.valueOf(sourceValue.toString()) + 1);
		// 不同属性，不同类型：直接赋值给目标属性
		targetProp.set(source::getCustomerId, target::getOrgId, sourceValue);
	});
}

```

#### 2. Bean列表拷贝：自定义属性拷贝 与 默认属性转换

```Java
@Test
public void copyToListTest(){
	// 创建源对象
	final SysUserFb sysUserFb = new SysUserFb();
	sysUserFb.setDepId("123");
	sysUserFb.setCustomerId("456");
	sysUserFb.setValue(1d);
	// 列表
	List<SysUserFb> sysUserFbList = Arrays.asList(sysUserFb);
	
	// 列表中的对象属性值转换
	List<SysUser> sysUsers = BeanUtil.copyToList(sysUserFbList, SysUser.class, (targetProp, source, target, sourceValue) -> {
		// 不同属性，不同类型：直接赋值给目标属性
		targetProp.set(source::getCustomerId, target::getOrgId, sourceValue);
		// 相同属性不同类型：把属性值进行逻辑运算，并赋值给目标属性
		targetProp.set(source::getValue, target::getValue, Double.valueOf(sourceValue.toString()) + 1);
	});
}
```

#### 3. 对Map的value求和

```Java
@Data
@AllArgsConstructor
static class Person {
	private Double weight;
}

@Data
@AllArgsConstructor
static class Person1 {
	private Float weight;
	private int height;
}

@Test
public void valueSumTest() {
	
	// 求和：map的value为 数字类型，且存在null的情况
	double valuesSum2 = MapUtil.getValuesSum(new HashMap<String, Integer>() {{
		put("1", null);
		put("2", 2);
	}});
	// 结果：2
	Assert.assertEquals(2, valuesSum2, 0);

	// 求和：map的value为Person对象，存在null的情况
	double valuesSum3 = MapUtil.getValuesSum(new HashMap<String, Person>() {{
		put("1", new Person(5.0));
		put("2", new Person(null));
	}}, Person::getWeight); // 对对象weight属性求和
	// 结果：5
	Assert.assertEquals(5, valuesSum3, 0);

	double valuesSum4 = MapUtil.getValuesSum(new HashMap<String, Person1>() {{
		put("1", new Person1(6f, 3));
		put("2", new Person1(null, 3));
	}}, Person1::getWeight); // 对对象weight属性求和
	Assert.assertEquals(6, valuesSum4, 0);
}
```
### 4. 对Map的value求和，且value为列表对象

```Java
@Test
public void valueSumTest() {
	// 求和：map的value，value为列表的情况
	
	// map value为列表的情况
	Map<String, List<Person1>> person1Map = new HashMap(){{
		put("1", new ArrayList<Person1>() {{
			add(new Person1(10f, 4));
			add(new Person1(10f, 5));
		}});
		put("2", new ArrayList<Person1>() {{
			add(new Person1(10f, 4));
			add(null);
			add(new Person1(null, 4));
		}});
	}};
	
	double valuesSum = MapUtil.getValuesSum(person1Map, Person1::getWeight);
	Assert.assertEquals(30, valuesSum, 0);
}
```


-------------------------------------------------------------------------------

## 🏗️添砖加瓦

### 🎋分支说明

Hutool-Plus的源码分为两个分支，功能如下：

| 分支       | 作用                                                          |
|-----------|---------------------------------------------------------------|
| v5-master | 主分支，release版本使用的分支，与中央库提交的jar一致，不接收任何pr或修改 |
| v5-dev    | 开发分支，默认为下个版本的SNAPSHOT版本，接受修改或pr                 |

### 🐞提供bug反馈或建议

提交问题反馈请说明正在使用的JDK版本呢、Hutool-Plus版本和相关依赖库版本。

- [Gitee issue](https://gitee.com/dromara/hutool/issues)
- [Github issue](https://github.com/dromara/hutool/issues)


### 🧬贡献代码的步骤

1. 在Gitee或者Github上fork项目到自己的repo
2. 把fork过去的项目也就是你的项目clone到你的本地
3. 修改代码（记得一定要修改v5-dev分支）
4. commit后push到自己的库（v5-dev分支）
5. 登录Gitee或Github在你首页可以看到一个 pull request 按钮，点击它，填写一些说明信息，然后提交即可。
6. 等待维护者合并

### 📐PR遵照的原则

Hutool-Plus欢迎任何人为Hutool-Plus添砖加瓦，贡献代码。需要提交的pr（pull request）符合一些规范，规范如下：

1. 注释完备，尤其每个新增的方法应按照Java文档规范标明方法说明、参数说明、返回值说明等信息，必要时请添加单元测试，如果愿意，也可以加上你的大名。
2. Hutool-Plus的缩进，使用Tab键缩进。
3. 新加的方法不要使用第三方库的方法，Hutool-Plus遵循无依赖原则（除非在extra模块中加方法工具）。
4. 请pull request到`v5-dev`分支。Hutool-Plus在5.x版本后使用了新的分支：`v5-master`是主分支，表示已经发布中央库的版本，这个分支不允许pr，也不允许修改。
5. 我们如果关闭了你的issue或pr，请不要诧异，这是我们保持问题处理整洁的一种方式，你依旧可以继续讨论，当有讨论结果时我们会重新打开。

[//]: # (### 📖文档源码地址)

[//]: # ()
[//]: # ([文档源码地址]&#40;https://gitee.com/loolly_admin/hutool-doc-handy&#41; 点击前往添砖加瓦)

-------------------------------------------------------------------------------

[//]: # (## ⭐Star Hutool-Plus)

[//]: # ()
[//]: # ([![Stargazers over time]&#40;https://starchart.cc/dromara/hutool.svg&#41;]&#40;https://starchart.cc/dromara/hutool&#41;)
