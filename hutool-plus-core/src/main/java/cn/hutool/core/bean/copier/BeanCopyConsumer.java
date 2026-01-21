package cn.hutool.core.bean.copier;


/**
 * 源拷贝映射到目标
 *
 * @param <S>  源对象类型
 * @param <T>  目标对象类型
 * @author lingengkeng
 */
@FunctionalInterface
public interface BeanCopyConsumer<S, T> {

	/**
	 * 执行拷贝操作
	 *
	 * 此方法用于从源对象复制值到目标对象的指定属性上。
	 *
	 * @param source     源对象，从中提取值。
	 * @param target     目标对象，将值设置于此。
	 */
	void accept(S source, T target);
}
