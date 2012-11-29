package com.abc.kids;

import java.io.Serializable;

public class Word implements Serializable{

	
		private long id;
		private String Indonesia = "";
		private String English = "";
		private int ImageFile = 0;
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

		
		public void setImg(int img) {
			this.ImageFile = img;
		}

		public int getImg() {
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
