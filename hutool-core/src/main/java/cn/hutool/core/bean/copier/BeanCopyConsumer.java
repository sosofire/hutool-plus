package cn.hutool.core.bean.copier;


/**
 * 源拷贝映射到目标
 *
 * @author lingengkeng
 */
@FunctionalInterface
public interface BeanCopyConsumer<TP, S, T, V> {

	/**
	 * 执行拷贝操作
	 *
	 * 此方法用于从源对象复制值到目标对象的指定属性上。
	 *
	 * @param targetProp 目标属性，类型为 {@link TargetProp} 类。
	 * @param source     源对象，从中提取值。
	 * @param target     目标对象，将值设置于此。
	 * @param value      要复制的值。
	 */
	void accept(TP targetProp, S source, T target, V value);
}
