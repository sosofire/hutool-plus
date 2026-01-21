
## 📚 Introduction

`Hutool-Plus` is an open-source project based on the original Hutool library, enhanced with additional functionalities. `Hutool-Plus` is a powerful and easy-to-use **Java utility library**, designed to help developers quickly and efficiently accomplish various programming tasks through a wide range of practical utility classes.  
These utilities cover operations such as strings, numbers, collections, encoding, dates, files, IO, encryption, database JDBC, JSON, HTTP clients, and more — meeting diverse development needs.

-------------------------------------------------------------------------------


## 📦 Installation

### 🍊 Maven

Add the following dependency to your project's `pom.xml` under `<dependencies>`:

```xml
<dependency>
    <groupId>io.gitee.ssoss</groupId>
    <artifactId>hutool-plus-all</artifactId>
    <version>5.9.0</version>
 </dependency>
```

### 🍐Gradle
```
implementation 'io.gitee.ssoss:hutool-plus-all:5.9.0'
```

### 📥 Download Jar

Click the link below to download the hutool-all-X.X.X.jar file:

- [Maven Central Repository](https://repo1.maven.org/maven2/cn/hutool-plus/hutool-all/5.9.0/)

> 🔔️Note
> Hutool-Plus 5.x supports JDK 8+, has not been tested on Android, and some tools or methods may not be compatible.

### 🚽Build and Install from Source

Visit the Hutool-Plus Gitee homepage: https://gitee.com/ssoss/hutool-plus

Download the full project source code (either v5-master or v5-dev branch), then navigate to the Hutool-Plus project directory and execute:

```sh
./hutool.sh install
```

After installation, you can import it into your Maven project.

-------------------------------------------------------------------------------

### ⌨️Usage

#### 1.Bean Copying: Custom and Default Property Conversion

```Java
/**
 * source obj
 */
@Data
static class SysUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private String depId;

	private String customerId;

	/**
	 * Double type value
	 */
	private Double value;
}

/**
 * target obj
 */
@Data
@Setter
static class SysUserVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long depart;

	private Double orgId;

	/**
	 * String type value
	 */
	private String value;
}

/**
 * bean copy
 * @author lingengkeng
 */
@Test
public void toBeanTest1(){
	// 创建源对象
	final SysUser sysUser = new SysUser();
	sysUser.setDepId("123");
	sysUser.setCustomerId("456");
	sysUser.setValue(1d);

	final SysUserVO sysUserVO = BeanUtil.toBean(sysUser, SysUserVO.class, (source, target) -> {
		target.setDepart(666L);
//			target.setValue(source.getValue());
		target.setOrgId(Double.valueOf(source.getCustomerId()));
	});
	Assert.assertEquals(Integer.valueOf(sysUser.getCustomerId()), Integer.valueOf(sysUserVO.getOrgId().intValue()));
}


```

#### 2. Bean List Copying: Custom and Default Property Conversion

```Java
	/**
 * bean list copy
 * @author lingengkeng
 */
@Test
public void copyToListTest(){
	// source obj
	final SysUser sysUser = new SysUser();
	sysUser.setDepId("123");
	sysUser.setCustomerId("456");
	sysUser.setValue(1d);

	final SysUser sysUser1 = new SysUser();
	sysUser1.setDepId("3333");
	sysUser1.setCustomerId("666");
	sysUser1.setValue(2d);

	// user list
	List<SysUser> sysUserList = Arrays.asList(sysUser, sysUser1);

	// setting
	List<SysUserVO> sysUserVOList = BeanUtil.copyToList(sysUserList, SysUserVO.class, (source, target) -> {
		target.setOrgId(Double.valueOf(source.getCustomerId()));
//			target.setValue(String.valueOf(source.getValue() + 1));
	});
	Assert.assertEquals(Integer.valueOf(sysUser.getCustomerId()), Integer.valueOf(sysUserVOList.get(0).getOrgId().intValue()));
}
```

#### 3. Summing Map Values

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
	
	// 1.求和：map的value为 数字类型，且存在null的情况
	Map<String, Integer> map = new HashMap() {{
		put("1", null);
		put("2", 2);
	}};
	double valuesSum = MapUtil.getValuesSum(map);
	// 结果：2
	Assert.assertEquals(2, valuesSum, 0);

	// 2.求和：map的value为Person对象，属性存在null的情况
	Map<String, Person> map1 = new HashMap() {{
		put("1", new Person(5.0));
		put("2", new Person(null));
	}};
	// 对对象weight属性求和
	double valuesSum3 = MapUtil.getValuesSum(map1, Person::getWeight); 
	// 结果：5
	Assert.assertEquals(5, valuesSum3, 0);

	double valuesSum4 = MapUtil.getValuesSum(new HashMap<String, Person1>() {{
		put("1", new Person1(6f, 3));
		put("2", new Person1(null, 3));
	}}, Person1::getWeight); // 对对象weight属性求和
	Assert.assertEquals(6, valuesSum4, 0);
}
```
### 4. Summing Map Values When Values Are Lists

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
### 5.Calculation Utility Class

```Java
@Test
public void calcTest() {
	// 在很多代码里面，如果参数是null，直接使用0(当分母为0时)，会导致程序异常，使用BigDecimalSupper，可以避免这个问题。
	// 或者使用Optional，但是Optional在处理null值时，代码会更长，而且需要引入额外的依赖。
	// BigDecimalSupper 可以处理null值，并且可以避免抛出异常，使得代码更加健壮。BigDecimal 不能处理null值，需要在代码中做空值判断。
	Float a = null;
	Double b = null;
	Long c = null;
	Integer t = null;
	BigDecimal subtract = new BigDecimalSupper(a).setScale(2).divide(new BigDecimalSupper(a).setScale(2)).add(BigDecimalSupper.valueOf(b)).add(BigDecimalSupper.valueOf(1));
	System.out.println(subtract);
	
			BigDecimal subtract1 = new BigDecimalSupper(c).multiply(new BigDecimalSupper(a)).add(BigDecimalSupper.valueOf(b)).add(BigDecimalSupper.valueOf(1));
			System.out.println(subtract1);
	
			BigDecimal subtract2 = new BigDecimalSupper(t).subtract(new BigDecimalSupper(a)).add(BigDecimalSupper.valueOf(b)).add(BigDecimalSupper.valueOf(1));
			System.out.println(subtract2);
	
	
	//        System.out.println(new BigDecimalSupper(4.503).setScale(2).divide(new BigDecimalSupper(a)));
	//        System.out.println(new BigDecimalSupper(4.503).setScale(2, RoundingMode.HALF_UP).divide(new BigDecimalSupper(4.503)));
	
			// BigDecimal 默认要求除法操作的结果必须是精确的，如果结果是一个无限循环小数，就会抛出异常。以下是报错示范
	//        System.out.println(BigDecimal.valueOf(4.503).divide(BigDecimal.valueOf(0)));
	//        System.out.println(BigDecimal.valueOf(4.503).setScale(2).divide(BigDecimal.valueOf(4.503)));

}
```

-------------------------------------------------------------------------------

## 🛠️Included Components
A foundational Java toolkit providing encapsulations for files, streams, encryption/decryption, encoding, regex, threading, XML, etc., as well as these additional modules:
| Module             | Description                                                                              |
| ------------------ | ---------------------------------------------------------------------------------------- |
| hutool-aop         | JDK dynamic proxy with AOP support outside IOC                                           |
| hutool-bloomFilter | Bloom filter with various hash algorithms                                                |
| hutool-cache       | Simple in-memory cache implementation                                                    |
| hutool-core        | Core module including Bean, Date, and other utilities                                    |
| hutool-cron        | Scheduler supporting Crontab-style expressions                                           |
| hutool-crypto      | Encryption and decryption (symmetric/asymmetric/digest)                                  |
| hutool-db          | ActiveRecord-style JDBC wrapper                                                          |
| hutool-dfa         | Multi-keyword search based on DFA                                                        |
| hutool-extra       | Extensions for third-party tools (templating, email, servlet, QR code, emoji, FTP, etc.) |
| hutool-http        | Lightweight HTTP client wrapper                                                          |
| hutool-log         | Logging facade with auto-detection of logging framework                                  |
| hutool-script      | Scripting support (e.g. JavaScript execution)                                            |
| hutool-setting     | Enhanced configuration file (Setting/Properties) handler                                 |
| hutool-system      | System and JVM information utilities                                                     |
| hutool-json        | JSON implementation                                                                      |
| hutool-captcha     | Image captcha generation                                                                 |
| hutool-poi         | POI-based Excel and Word utilities                                                       |
| hutool-socket      | Java NIO/AIO socket wrapper                                                              |
| hutool-jwt         | JSON Web Token (JWT) implementation                                                      |


You can import each module individually or include all at once using hutool-all.
-------------------------------------------------------------------------------


## 🏗️Contribution Guide

### 🎋Branch Structure


| Branch    | Description                                                                            |
| --------- | -------------------------------------------------------------------------------------- |
| v5-master | Main branch for release versions, matches central repository JARs, does not accept PRs |
| v5-dev    | Development branch for next SNAPSHOT version, accepts PRs and modifications            |


### 🐞Reporting Issues or Suggestions

When submitting feedback, please include your JDK version, Hutool-Plus version, and any relevant dependency versions.

- [Gitee issue](https://github.com/sosofire/hutool-plus/issue)


### 🧬Steps to Contribute
1. Fork the project on Gitee or GitHub
2. Clone your forked repository locally
3. Make changes (on the v5-dev branch)
4. Commit and push to your repository (v5-dev branch)
5. On Gitee or GitHub, open a Pull Request and describe your changes
6. Wait for maintainers to review and merge

### 📐Pull Request Guidelines
1. Include complete Javadoc-style comments (method, params, return value). Add unit tests if possible.
2. Use Tab for indentation.
3. Avoid using third-party dependencies unless in the extra module.
4. Always PR to the v5-dev branch.
5. If your PR or issue is closed, don’t worry — discussions can continue, and it may be reopened later if appropriate.

-------------------------------------------------------------------------------

## ⭐Support Hutool-Plus with a Star!
