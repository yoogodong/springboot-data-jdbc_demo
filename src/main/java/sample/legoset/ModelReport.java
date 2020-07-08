package sample.legoset;

import lombok.Value;

/**
 * 值类型是不可修改的对象
 */
@Value
public class ModelReport {
	String modelName, description, setName;
}
