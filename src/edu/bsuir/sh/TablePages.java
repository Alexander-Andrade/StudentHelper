package edu.bsuir.sh;

public class TablePages {
	private String browsablePage;
	private String editablePage;
	
	
	public TablePages(String browsablePage, String editablePage){
		this.browsablePage = browsablePage;
		this.editablePage = editablePage;
	}
	
	public String getBrowseablePage() {
		return browsablePage;
	}
	public void setBrowseablePage(String browseablePage) {
		this.browsablePage = browseablePage;
	}
	public String getEditablePage() {
		return editablePage;
	}
	public void setEditablePage(String editablePage) {
		this.editablePage = editablePage;
	}
}
