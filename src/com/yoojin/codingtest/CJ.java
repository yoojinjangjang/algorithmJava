package com.yoojin.codingtest;

import java.util.ArrayList;

public class CJ {
	static class Folder {
		Folder parent;
		ArrayList<File> files = new ArrayList<>();
		public Folder(Folder parent) {
			super();
			this.parent = parent;
		}
		
		
	}
	static class File {
		Folder parent;
		String name;
		int size;
		public File(Folder parent, String name, String size) {
			super();
			this.parent = parent;
			this.name = name;
			
			if(size.charAt(size.length()-2) == 'K') {
				// KB임
				this.size = Integer.parseInt(size.substring(0,size.length()-2));
			} else {
				this.size = Integer.parseInt(size.substring(0,size.length()-1));
			}

		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			File other = (File) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		
		
	}
	
	
	static ArrayList<Folder> folders = new ArrayList<>();
	static ArrayList<File> files = new ArrayList<>();
	public static void main(String[] args) {

	}
}
