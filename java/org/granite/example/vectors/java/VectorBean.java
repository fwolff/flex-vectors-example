package org.granite.example.vectors.java;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.granite.messaging.amf.types.AMFVectorInt;
import org.granite.messaging.amf.types.AMFVectorNumber;
import org.granite.messaging.amf.types.AMFVectorObject;
import org.granite.messaging.amf.types.AMFVectorUint;

public class VectorBean {
	
	@AMFVectorInt(fixed=true)
	public int[] intArray;

	@AMFVectorUint(fixed=true)
	public long[] uintArray;
	
	@AMFVectorNumber(fixed=true)
	public double[] numberArray;

	@AMFVectorObject(fixed=true)
	public String[] stringArray;
	
	@AMFVectorInt
	public Collection<Integer> intCollection;

	@AMFVectorUint
	public Collection<Long> uintCollection;
	
	@AMFVectorNumber
	public Collection<Double> numberCollection;

	@AMFVectorObject
	public Collection<String> stringCollection;

	@AMFVectorObject
	public VectorItem[] itemArray;

	public VectorBean() {
		this(false);
	}

	public VectorBean(boolean init) {
		if (init) {
			intArray = new int[] {
				Integer.MIN_VALUE,
				-1,
				0,
				1,
				Integer.MAX_VALUE
			};
			
			uintArray = new long[] {
				0L,
				1L,
				(long)Integer.MAX_VALUE,
				(long)Integer.MAX_VALUE + 1L,
				0xFFFFFFFFL
			};
			
			numberArray = new double[] {
				Double.NaN,
				Double.NEGATIVE_INFINITY,
				-1.0,
				0.0,
				Double.MIN_VALUE,
				1.0,
				Double.MAX_VALUE,
				Double.POSITIVE_INFINITY
			};
			
			stringArray = new String[] {
				null,
				"",
				"a",
				"bc",
				"def"
			};
			
			intCollection = asCollection(intArray);
			uintCollection = asCollection(uintArray);
			numberCollection = asCollection(numberArray);
			stringCollection = asCollection(stringArray);
			
			itemArray = new VectorItem[] {
				new VectorItem(),
				new VectorItem(true)
			};
		}
	}
	
	@SuppressWarnings("unchecked")
	private static <T> Collection<T> asCollection(Object array) {
		final int length = Array.getLength(array);
		List<T> collection = new ArrayList<T>(length);
		for (int i = 0; i < length; i++)
			collection.add((T)Array.get(array, i));
		return collection;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(getClass().getSimpleName()).append(" {\n");

		Field[] fields = VectorBean.class.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			sb.append("    ").append(field.getName()).append(" = ");
			try {
				Object value = field.get(this);
				if (value != null && value.getClass().isArray()) {
					final int length = Array.getLength(value);
					sb.append("[");
					for (int j = 0; j < length; j++) {
						if (j > 0)
							sb.append(", ");
						sb.append(Array.get(value, j));
					}
					sb.append("]");
				}
				else
					sb.append(value);
				if (i < fields.length - 1)
					sb.append(",");
				sb.append("\n");
			}
			catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		return sb.append("}").toString();
	}
}
