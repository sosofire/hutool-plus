package cn.hutool.core.bean;

import cn.hutool.core.lang.func.Func0;
import cn.hutool.core.lang.func.LambdaUtil;

/**
 * 目标属性
 *
 * @author lingengkeng
 */
public class TargetProp<S, T> {

	/**
	 * 源属性名
	 */
	private final String sourceFieldName;

	/**
	 * 目标属性名
	 */
	private String targetFieldName;

	/**
	 * 目标属性值
	 */
	private Object targetFieldValue;


	public TargetProp(String sourceFieldName) {
		this.sourceFieldName = sourceFieldName;
	}

	/**
	 * 设置目标属性值
	 *
	 * @param sourcePropFunc 源属性函数
	 * @param targetPropFunc 目标属性函数
	 * @param value          值
	 * @return 目标属性
	 */
	public TargetProp set(Func0<S> sourcePropFunc, Func0<T> targetPropFunc, Object value) {
		String sourceFieldName = LambdaUtil.getFieldName(sourcePropFunc);
		String targetFieldName = LambdaUtil.getFieldName(targetPropFunc);
		if (!this.sourceFieldName.equals(sourceFieldName)) {
			return this;
		}

		this.targetFieldName = targetFieldName;
		this.targetFieldValue = value;
		return this;
	}

	public String getTargetFieldName() {
		return this.targetFieldName;
	}

	public Object getTargetFieldValue() {
		return this.targetFieldValue;
	}

}
