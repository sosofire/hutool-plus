package cn.hutool.core.bean;

import cn.hutool.core.lang.func.Func0;
import cn.hutool.core.lang.func.LambdaUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;

import java.util.HashMap;

/**
 * 目标属性
 *
 * @author lingengkeng
 */
public class TargetProp<S, T> extends HashMap {

	public TargetProp() {
	}

	/**
	 * 设置目标属性值
	 * @param targetPropFunc 目标属性函数
	 * @param value          值
	 * @return 目标属性
	 */
	public TargetProp set(Func0<T> targetPropFunc, Object value) {
		String targetFieldName = LambdaUtil.getFieldName(targetPropFunc);
		this.put(targetFieldName, value);
		return this;
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
		// 函数入参对象的方法名
		String sourceFieldName = LambdaUtil.getFieldName(sourcePropFunc);
		String targetFieldName = LambdaUtil.getFieldName(targetPropFunc);

//		// 获取源对象(位于函数入参) . 通过反射的方法，获取该方法中的参数对象
		Object lambdaArg = LambdaUtil.getSerializedLambdaArgs(sourcePropFunc, 0);
//		// 通过反射获取源对象的属性值(方法返回值)  方法返回值
		Object fieldValue = ReflectUtil.invoke(lambdaArg, "get" + StrUtil.upperFirst(sourceFieldName));

		this.put(targetFieldName, value);
		return this;
	}

}
