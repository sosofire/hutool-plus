package cn.hutool.core.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * BigDecimal 封装，自动处理 null 值、除法运算分母为零为null, 减少了代码中的 null 检查，使代码更加简洁
 * <p>
 * 使用GPT比较BigDecimal与BigDecimalSupper:
 * 结论
 * BigDecimalSupper 更适合写业务代码，特别是当业务逻辑中频繁处理 null 值且希望代码更加简洁和健壮时。
 * BigDecimal 适用于对异常处理有严格要求和性能敏感的应用。
 * 根据具体的业务需求和场景选择合适的类，可以更好地平衡代码的简洁性、健壮性和性能。
 * </p>
 *
 * @author lingengkeng
 */
public class BigDecimalSupper extends BigDecimal {
	private static final Logger log = LoggerFactory.getLogger(BigDecimalSupper.class);

	public BigDecimalSupper(char[] in, int offset, int len) {
		super(in, offset, len);
	}

	public BigDecimalSupper(char[] in, int offset, int len, MathContext mc) {
		super(in, offset, len, mc);
	}

	public BigDecimalSupper(char[] in) {
		super(in);
	}

	public BigDecimalSupper(char[] in, MathContext mc) {
		super(in, mc);
	}

	public BigDecimalSupper(String val) {
		super(val);
	}

	public BigDecimalSupper(String val, MathContext mc) {
		super(val, mc);
	}

	public BigDecimalSupper(Double val) {
		super(val == null ? "0" : Double.toString(val));
	}

	public BigDecimalSupper(Float val) {
		super(val == null ? 0F : val);
	}

	public BigDecimalSupper(double val, MathContext mc) {
		super(Double.toString(val), mc);
	}

	public BigDecimalSupper(Double val, MathContext mc) {
		super(val == null ? "0" : Double.toString(val), mc);
	}

	public BigDecimalSupper(BigInteger val) {
		super(val);
	}

	public BigDecimalSupper(BigInteger val, MathContext mc) {
		super(val, mc);
	}

	public BigDecimalSupper(BigInteger unscaledVal, int scale) {
		super(unscaledVal, scale);
	}

	public BigDecimalSupper(BigInteger unscaledVal, int scale, MathContext mc) {
		super(unscaledVal, scale, mc);
	}

	public BigDecimalSupper(int val) {
		super(val);
	}

	public BigDecimalSupper(Integer val) {
		super(val == null ? 0 : val);
	}

	public BigDecimalSupper(int val, MathContext mc) {
		super(val, mc);
	}

	public BigDecimalSupper(Integer val, MathContext mc) {
		super(val == null ? 0 : val, mc);
	}

	public BigDecimalSupper(long val) {
		super(val);
	}

	public BigDecimalSupper(Long val) {
		super(val == null ? 0L : val);
	}

	public BigDecimalSupper(long val, MathContext mc) {
		super(val, mc);
	}

	public BigDecimalSupper(Long val, MathContext mc) {
		super(val == null ? 0L : val, mc);
	}

	@Override
	public BigDecimalSupper add(BigDecimal augend) {
		if (null == augend) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return BigDecimalSupper.valueOf(super.add(augend));
	}

	public <T extends Number> BigDecimalSupper add(T augend) {
		if (null == augend) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return this.add(new BigDecimalSupper(augend.toString()));
	}

	@Override
	public BigDecimalSupper add(BigDecimal augend, MathContext mc) {
		if (null == augend) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return BigDecimalSupper.valueOf(super.add(augend, mc));
	}

	public <T extends Number> BigDecimalSupper add(T augend, MathContext mc) {
		if (null == augend) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return this.add(new BigDecimalSupper(augend.toString()), mc);
	}

	@Override
	public BigDecimalSupper subtract(BigDecimal subtrahend) {
		if (null == subtrahend) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return BigDecimalSupper.valueOf(super.subtract(subtrahend));
	}

	public <T extends Number> BigDecimalSupper subtract(T subtrahend) {
		if (null == subtrahend) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return this.subtract(new BigDecimalSupper(subtrahend.toString()));
	}

	@Override
	public BigDecimalSupper subtract(BigDecimal subtrahend, MathContext mc) {
		if (null == subtrahend) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return BigDecimalSupper.valueOf(super.subtract(subtrahend, mc));
	}

	public <T extends Number> BigDecimalSupper subtract(T subtrahend, MathContext mc) {
		if (null == subtrahend) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return this.subtract(new BigDecimalSupper(subtrahend.toString()), mc);
	}

	@Override
	public BigDecimalSupper multiply(BigDecimal multiplicand) {
		if (null == multiplicand) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return BigDecimalSupper.valueOf(super.multiply(multiplicand));
	}

	public <T extends Number> BigDecimalSupper multiply(T multiplicand) {
		if (null == multiplicand) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return this.multiply(new BigDecimalSupper(multiplicand.toString()));
	}

	@Override
	public BigDecimalSupper multiply(BigDecimal multiplicand, MathContext mc) {
		if (null == multiplicand) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return BigDecimalSupper.valueOf(super.multiply(multiplicand, mc));
	}

	public <T extends Number> BigDecimalSupper multiply(T multiplicand, MathContext mc) {
		if (null == multiplicand) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return this.multiply(new BigDecimalSupper(multiplicand.toString(), mc));
	}

	@Override
	public BigDecimalSupper divide(BigDecimal divisor) {
		if (null == divisor) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		if (BigDecimal.ZERO.intValue() == divisor.intValue()) {
			logDivisionByZeroError();
			// 避免抛出异常，很多情況下，是因为参数没有数据，为null,而构造处设置为0，除法分母不能为0
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		// BigDecimal 默认要求除法操作的结果必须是精确的，如果结果是一个无限循环小数，就会抛出异常。
		//要解决这个问题，可以在 divide 方法中指定一个舍入模式（Rounding Mode）
		// 指定精度为10位小数，并使用HALF_UP舍入模式
		return BigDecimalSupper.valueOf(super.divide(divisor, 10, RoundingMode.HALF_UP));
	}

	public <T extends Number> BigDecimalSupper divide(T divisor) {
		if (null == divisor) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return this.divide(new BigDecimalSupper(divisor.toString()));
	}

	@Override
	public BigDecimalSupper divide(BigDecimal divisor, RoundingMode roundingMode){
		if (null == divisor) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		if (BigDecimal.ZERO.intValue() == divisor.intValue()) {
			logDivisionByZeroError();
			// 避免抛出异常，很多情況下，是因为参数没有数据，为null,而构造处设置为0，除法分母不能为0
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		// BigDecimal 默认要求除法操作的结果必须是精确的，如果结果是一个无限循环小数，就会抛出异常。
		//要解决这个问题，可以在 divide 方法中指定一个舍入模式（Rounding Mode）
		return BigDecimalSupper.valueOf(super.divide(divisor, roundingMode));
	}

	public <T extends Number> BigDecimalSupper divide(T divisor, RoundingMode roundingMode){
		if (null == divisor) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return this.divide(new BigDecimalSupper(divisor.toString()), roundingMode);
	}

	@Override
	public BigDecimalSupper divide(BigDecimal divisor, int roundingMode) {
		if (null == divisor) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return BigDecimalSupper.valueOf(super.divide(divisor, roundingMode));
	}

	public <T extends Number> BigDecimalSupper divide(T divisor, int roundingMode) {
		if (null == divisor) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return this.divide(new BigDecimalSupper(divisor.toString()), roundingMode);
	}

	@Override
	public BigDecimalSupper divide(BigDecimal divisor, int scale, RoundingMode roundingMode) {
		if (null == divisor) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return BigDecimalSupper.valueOf(super.divide(divisor, scale, roundingMode));
	}

	public <T extends Number> BigDecimalSupper divide(T divisor, int scale, RoundingMode roundingMode) {
		if (null == divisor) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return this.divide(new BigDecimalSupper(divisor.toString()), scale, roundingMode);
	}

	@Override
	public BigDecimalSupper divide(BigDecimal divisor, int scale, int roundingMode) {
		if (null == divisor) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return BigDecimalSupper.valueOf(super.divide(divisor, scale, roundingMode));
	}

	public <T extends Number> BigDecimalSupper divide(T divisor, int scale, int roundingMode) {
		if (null == divisor) {
			return BigDecimalSupper.valueOf(BigDecimal.ZERO);
		}
		return this.divide(new BigDecimalSupper(divisor.toString()), scale, roundingMode);
	}

	public static BigDecimalSupper valueOf(Double unscaledVal, int scale) {
		return new BigDecimalSupper(Double.valueOf(unscaledVal == null ? 0D : unscaledVal), new MathContext(scale));
	}

	public static BigDecimalSupper valueOf(Float unscaledVal, int scale) {
		return new BigDecimalSupper(Double.valueOf(unscaledVal == null ? 0F : unscaledVal), new MathContext(scale));
	}

	public static BigDecimalSupper valueOf(Long unscaledVal, int scale) {
		return new BigDecimalSupper(Long.valueOf(unscaledVal == null ? 0L : unscaledVal), new MathContext(scale));
	}

	public static BigDecimalSupper valueOf(Integer unscaledVal, int scale) {
		return new BigDecimalSupper(Integer.valueOf(unscaledVal == null ? 0 : unscaledVal), new MathContext(scale));
	}

	public static BigDecimalSupper valueOf(Short unscaledVal, int scale) {
		return new BigDecimalSupper(Short.valueOf(unscaledVal == null ? 0 : unscaledVal), new MathContext(scale));
	}

	public static BigDecimalSupper valueOf(double unscaledVal, int scale) {
		return new BigDecimalSupper(Double.toString(unscaledVal), new MathContext(scale));
	}

	public static BigDecimalSupper valueOf(float unscaledVal, int scale) {
		return new BigDecimalSupper(Float.toString(unscaledVal), new MathContext(scale));
	}

	public static BigDecimalSupper valueOf(long unscaledVal, int scale) {
		return new BigDecimalSupper(unscaledVal, new MathContext(scale));
	}

	public static BigDecimalSupper valueOf(int unscaledVal, int scale) {
		return new BigDecimalSupper(unscaledVal, new MathContext(scale));
	}

	public static BigDecimalSupper valueOf(short unscaledVal, int scale) {
		return new BigDecimalSupper(Short.toString(unscaledVal), new MathContext(scale));
	}

	public static BigDecimalSupper valueOf(Double val) {
		return new BigDecimalSupper(Double.toString(val == null ? 0D : val));
	}

	public static BigDecimalSupper valueOf(Float val) {
		return new BigDecimalSupper(Float.toString(val == null ? 0F : val));
	}

	public static BigDecimalSupper valueOf(Long val) {
		return new BigDecimalSupper(Long.valueOf(val == null ? 0L : val));
	}

	public static BigDecimalSupper valueOf(Integer val) {
		return new BigDecimalSupper(Integer.toString(val == null ? 0 : val));
	}

	public static BigDecimalSupper valueOf(Short val) {
		return new BigDecimalSupper(Short.toString(val == null ? 0 : val));
	}

	public static BigDecimalSupper valueOf(double val) {
		return new BigDecimalSupper(Double.toString(val));
	}

	public static BigDecimalSupper valueOf(float val) {
		return new BigDecimalSupper(Float.toString(val));
	}

	public static BigDecimalSupper valueOf(long val) {
		return new BigDecimalSupper(val);
	}

	public static BigDecimalSupper valueOf(int val) {
		return new BigDecimalSupper(val);
	}

	public static BigDecimalSupper valueOf(short val) {
		return new BigDecimalSupper(String.valueOf(val));
	}

	public static BigDecimalSupper valueOf(BigDecimal val) {
		if (val == null || val.compareTo(BigDecimal.ZERO) == 0) {
			return new BigDecimalSupper(BigDecimal.ZERO.toPlainString());
		}
		return new BigDecimalSupper(val.toPlainString());
	}

	@Override
	public BigDecimalSupper setScale(int newScale) {
		BigDecimal bigDecimal = super.setScale(newScale, RoundingMode.HALF_UP);
		return BigDecimalSupper.valueOf(bigDecimal);
	}

	@Override
	public BigDecimalSupper setScale(int newScale, RoundingMode roundingMode) {
		BigDecimal bigDecimal = super.setScale(newScale, roundingMode);
		return BigDecimalSupper.valueOf(bigDecimal);
	}

	private void logDivisionByZeroError() {
		log.error("除数不能为0");
	}
}
