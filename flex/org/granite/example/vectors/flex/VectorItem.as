package org.granite.example.vectors.flex {

    [RemoteClass(alias="org.granite.example.vectors.java.VectorItem")]
    public class VectorItem {

		private var _dateArray:Vector.<Date>;
		
		public function VectorItem(init:Boolean = false) {
			if (init) {
				var now:Date = new Date();
				var oneDayBefore:Date = new Date();
				oneDayBefore.setTime(now.getTime() - (24 * 60 * 60 * 1000));
				var epoch:Date = new Date();
				epoch.setTime(0);
				
				_dateArray = new <Date>[now, oneDayBefore, epoch];
			}
		}
		
		public function get dateArray():Vector.<Date> {
			return _dateArray;
		}
		
		public function set dateArray(dateArray:Vector.<Date>):void {
			_dateArray = dateArray;
		}
	}
}