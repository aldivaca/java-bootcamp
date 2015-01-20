package com.tdd.exercise3;

import java.util.ArrayList;

public class RecentFileList {

	public ArrayList<String> recentFile;
	public int maxLength;

	public RecentFileList(int maxLength) {
		recentFile = new ArrayList<String>();
		this.maxLength = maxLength;
	}

	public void openFile(String fileName) {
		if (recentFile.size() == maxLength) {
			recentFile.remove(maxLength - 1);
		}
		if (recentFile.contains(fileName)) {
			recentFile.remove(fileName);
		} else {
		}
		recentFile.add(0, fileName);
	}

	public String printLastElement() {
		return recentFile.get(recentFile.size() - 1);
	}

	public String printFirstElement() {
		return recentFile.get(0);
	}

	public boolean contains(String fileName) {
		return recentFile.contains(fileName);
	}
}
