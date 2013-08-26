package org.granite.example.vectors.flex {

    [RemoteClass(alias="org.granite.example.vectors.java.VectorBean")]
    public class VectorBean {

		public var intArray:Vector.<int>;

		public var uintArray:Vector.<uint>;

		public var numberArray:Vector.<Number>;

		public var stringArray:Vector.<String>;

		public var intCollection:Vector.<int>;

		public var uintCollection:Vector.<uint>;

		public var numberCollection:Vector.<Number>;

		public var stringCollection:Vector.<String>;
		
		public var itemArray:Vector.<VectorItem>;
		
		public function VectorBean(init:Boolean = false) {
			if (init) {
				intArray = new <int>[int.MAX_VALUE, 1, 0, -1, int.MIN_VALUE];
				uintArray = new <uint>[uint.MAX_VALUE, uint(int.MAX_VALUE) + 1, uint(int.MAX_VALUE), 1, uint.MIN_VALUE];
				numberArray = new <Number>[Number.POSITIVE_INFINITY, Number.MAX_VALUE, 1.0, Number.MIN_VALUE, 0.0, -1.0, Number.NEGATIVE_INFINITY, Number.NaN];
				stringArray = new <String>["fed", "ba", "", null];
		
				intCollection = intArray.concat();
				uintCollection = uintArray.concat();
				numberCollection = numberArray.concat();
				stringCollection = stringArray.concat();
				
				itemArray = new <VectorItem>[new VectorItem(true), new VectorItem()];
			}
		}
	}
}