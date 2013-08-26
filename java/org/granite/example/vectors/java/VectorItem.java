package org.granite.example.vectors.java;

import java.util.Arrays;
import java.util.Date;

import org.granite.messaging.amf.types.AMFVectorObject;

public class VectorItem {

	private Date[] dateArray;
	
	public VectorItem() {
	}
	
	public VectorItem(boolean init) {
		if (init) {
			final long now = System.currentTimeMillis();
			dateArray = new Date[] {
				new Date(0L),
				new Date(now - (24 * 60 * 60 * 1000L)),
				new Date(now)
			};
		}
	}

	@AMFVectorObject
	public Date[] getDateArray() {
		return dateArray;
	}

	public void setDateArray(Date[] dateArray) {
		this.dateArray = dateArray;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " {dateArray = " + Arrays.toString(dateArray) + "}";
	}
}
