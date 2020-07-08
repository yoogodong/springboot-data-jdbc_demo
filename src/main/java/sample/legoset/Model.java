package sample.legoset;

import lombok.AccessLevel;
import lombok.Value;
import lombok.With;

/**
 * 乐高积木可以搭建的模型
 *
 * @Value 修饰的类型的实例不可变更
 */
@Value
@With(AccessLevel.PACKAGE)
public class Model {
	String name, description;
}
