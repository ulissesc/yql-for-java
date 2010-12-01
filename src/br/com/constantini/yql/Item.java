package br.com.constantini.yql;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class Item {

	private String title;
	
	@XStreamImplicit(itemFieldName="category")
	private List<String> categoryList;

	private String link;

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
