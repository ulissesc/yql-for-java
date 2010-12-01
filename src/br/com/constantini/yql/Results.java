package br.com.constantini.yql;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class Results {

	@XStreamImplicit(itemFieldName="item")
	private List<Item> itens;

	
	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> item) {
		this.itens = item;
	}
	
	public void addItem(Item item){
		if (this.itens == null)
			this.itens = new ArrayList<Item>();
		this.itens.add( item );
	}
}
