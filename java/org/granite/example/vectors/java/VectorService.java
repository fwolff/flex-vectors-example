package org.granite.example.vectors.java;

import java.util.Arrays;
import java.util.List;

import org.granite.messaging.amf.types.AMFBasicVectorObjectAliaser;
import org.granite.messaging.amf.types.AMFVectorIntValue;
import org.granite.messaging.amf.types.AMFVectorObjectAliaser;
import org.granite.messaging.amf.types.AMFVectorObjectValue;

public class VectorService {

	private static final AMFVectorObjectAliaser aliaser = new AMFBasicVectorObjectAliaser();
	
	private VectorBean vectorBean;
	private int[] vectorInt;
	private String[] vectorString;
	
	public VectorService() {
		reset();
	}
	
	public VectorBean getVectorBean() {
		return vectorBean;
	}
	
	public void setVectorBean(VectorBean vectorBean) {
		this.vectorBean = vectorBean;
		System.out.println(vectorBean);
	}
	
	public Object getVectorInt() {
		return new AMFVectorIntValue(vectorInt, true);
	}
	
	public void setVectorInt(int[] vectorInt) {
		this.vectorInt = vectorInt;
		System.out.println(Arrays.toString(this.vectorInt));
	}
	
	public Object getVectorString() {
		return new AMFVectorObjectValue(vectorString, aliaser.aliasFor(String.class), true);
	}
	
	public void setVectorString(List<Object> vectorString) {
		this.vectorString = (vectorString != null ? vectorString.toArray(new String[0]) : null);
		System.out.println(Arrays.toString(this.vectorString));
	}
	
	public void reset() {
		vectorBean = new VectorBean(true);
		vectorInt = new int[] {1, 2, 3, 4, 5, 6, 7};
		vectorString = new String[] {null, "abc", "def"};
	}
}
