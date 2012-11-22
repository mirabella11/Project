package com.abc.kids;

public class Word {

	
		private long id;
		private String Indonesia = "";
		private String English = "";
		private String ImageFile = "";
		private long type;
		 
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public void setIndo(String indo) {
			this.Indonesia = indo;
		}

		public String getIndo() {
			return Indonesia;
		}
	 
		public void setEng(String eng) {
			this.English = eng;
		}

		public String getEng() {
			return English;
		}

		
		public void setImg(String img) {
			this.ImageFile = img;
		}

		public String getImg() {
			return ImageFile;
		}
		
		public void setType(long type) {
			this.type = type;
		}
		public long getType() {
			return type;
		}

		
		
		public String toString() {
			return getIndo()+" "+getEng()+" "+getImg()+" "+getType();
		}
	 

}
