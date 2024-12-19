package cn.hutool.core.math;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 算术单元测试
 * @author lingengkeng
 *
 */
public class BigDecimalSupperTest {

	@Test
	public void bigDecimalSupperTest() {
		// 在很多代码里面，如果参数是null，直接使用0(当分母为0时)，会导致程序异常，使用BigDecimalSupper，可以避免这个问题。
		// 或者使用Optional，但是Optional在处理null值时，代码会更长，而且需要引入额外的依赖。
		// BigDecimalSupper 可以处理null值，并且可以避免抛出异常，使得代码更加健壮。BigDecimal 不能处理null值，需要在代码中做空值判断。
		Float a = null;
		Double b = null;
		Long c = null;
		Integer t = null;
		BigDecimal subtract = new BigDecimalSupper(a).setScale(2).divide(new BigDecimalSupper(a).setScale(2)).add(BigDecimalSupper.valueOf(b)).add(BigDecimalSupper.valueOf(1));
		Assert.assertEquals(subtract.intValue(), 1);

		BigDecimal subtract1 = new BigDecimalSupper(c).multiply(new BigDecimalSupper(a)).add(BigDecimalSupper.valueOf(b)).add(BigDecimalSupper.valueOf(1));
		Assert.assertEquals(subtract1.intValue(), 1);

		BigDecimal subtract2 = new BigDecimalSupper(t).subtract(new BigDecimalSupper(a)).add(BigDecimalSupper.valueOf(b)).add(BigDecimalSupper.valueOf(1));
		Assert.assertEquals(subtract2.intValue(), 1);

		BigDecimalSupper divide = BigDecimalSupper.valueOf(a).setScale(2).divide(BigDecimalSupper.valueOf(a));
		Assert.assertEquals(divide.intValue(), 0);

		BigDecimalSupper bigDecimalSupper = BigDecimalSupper.valueOf(new BigDecimalSupper(a)).setScale(2, RoundingMode.HALF_UP);
		Assert.assertEquals(bigDecimalSupper.intValue(), 0);

		BigDecimal sum = BigDecimalSupper.valueOf(a).divide(new BigDecimalSupper(3))

			// 除以 null
			.divide(null)
			// 除以 变量null
			.divide(a)
			.divide(0)

			// 乘以 null
			.multiply(null)
			// 乘以 变量null
			.multiply(a)
			.multiply(0)

			// 加上 null
			.add(null)
			// 加上 变量null
			.add(a)
			.add(0)

			// 减去 null
			.subtract(null)
			// 减去 变量null
			.subtract(t)
			.add(1)

			.add(BigDecimalSupper.valueOf(3).divide(BigDecimalSupper.valueOf(a)))
			.add(BigDecimalSupper.valueOf(a).multiply(BigDecimalSupper.valueOf(8)))
			.add(BigDecimalSupper.valueOf(99).divide(BigDecimalSupper.valueOf(b))).add(BigDecimalSupper.valueOf(a)).divide(2);
		Assert.assertEquals(sum.floatValue() + "", "0.5");

//        System.out.println(new BigDecimalSupper(4.503).setScale(2).divide(new BigDecimalSupper(a)));
//        System.out.println(new BigDecimalSupper(4.503).setScale(2, RoundingMode.HALF_UP).divide(new BigDecimalSupper(4.503)));

		// BigDecimal 默认要求除法操作的结果必须是精确的，如果结果是一个无限循环小数，就会抛出异常。以下是报错示范
//        System.out.println(BigDecimal.valueOf(4.503).divide(BigDecimal.valueOf(0)));
//        System.out.println(BigDecimal.valueOf(4.503).setScale(2).divide(BigDecimal.valueOf(4.503)));

		// 无限循环小数，报错
//		// 含税金额
//		BigDecimal inclusiveTaxAmount = new BigDecimal("1000");
//		// 税率
//		BigDecimal taxRate = new BigDecimal("0.13");
//		// 不含税金额 = 含税金额 / (1+税率)
//		BigDecimal exclusiveTaxAmount = inclusiveTaxAmount.divide(BigDecimal.ONE.add(taxRate));
//		System.out.println(exclusiveTaxAmount);

	}

	@Test
	public void newDoubleFloatTest(){
		// 避免小数精度问题
		double value1 = 1.010;
		double value2 = 1.010;
		BigDecimalSupper objectByDouble1 = new BigDecimalSupper(value1);
		Assert.assertEquals(Double.valueOf(value1), Double.valueOf(objectByDouble1.doubleValue()));

		BigDecimalSupper objectByDouble2 = new BigDecimalSupper(value2);
		Assert.assertEquals(Double.valueOf(value2), Double.valueOf(objectByDouble2.doubleValue()));
		// 测试是否相等
		Assert.assertEquals(objectByDouble1, objectByDouble2);
	}
}
