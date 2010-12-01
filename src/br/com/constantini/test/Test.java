package br.com.constantini.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import br.com.constantini.yql.Item;
import br.com.constantini.yql.Results;
import br.com.constantini.yql.YQLQuery;

import com.thoughtworks.xstream.XStream;

public class Test {

	public static void main(String[] args) throws IOException {

		/* TESTE DE CRIACAO DO OBJETO */
		createQuery();
		
		/* TESTE DE RECUPERACAO DO OBJETO VIA HTTP */
		getHttpObject();
		
	}


	private static void getHttpObject() throws IOException {
		XStream stream = new XStream();
		stream.autodetectAnnotations(true);
		
		stream.omitField(Item.class, "pubDate");
		stream.omitField(Item.class, "guid");
		stream.omitField(Item.class, "dc:creator");
		stream.omitField(Item.class, "wfw:commentRss");
		stream.omitField(Item.class, "source");
		stream.omitField(Item.class, "comments");
		
		String xmlRequest = httpRequest("http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20delicious.feeds%20where%20username%20%3D%20%20%22torquatro%22&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys" ); 
		
		stream.alias("query", YQLQuery.class);
		
		YQLQuery retorno = (YQLQuery) stream.fromXML( xmlRequest );
		
		List<Item> itens = retorno.getResults().getItens();
		for (Item item : itens) {
			System.out.println( " -----/-----  " );
			System.out.println( "TITLE:    " + item.getTitle() );
			System.out.println( "LINK:     " + item.getLink() );
			for (String categoria : item.getCategoryList())
				System.out.println( "	CATEGORY: " + categoria );
		}
	}


	private static YQLQuery createQuery() {
		Item item1 = new Item();
		item1.setTitle("titulo 1");
		
		Item item2 = new Item();
		item2.setTitle("titulo 2");
		
		Results results = new Results();
		results.addItem( item1 );
		results.addItem( item2 );
		
		YQLQuery query = new YQLQuery();
		query.setResults( results );
		
		XStream stream = new XStream();
		stream.autodetectAnnotations(true);
		
		String xml = stream.toXML( query );
		System.out.println( xml );
		
		return query;
	}
	
	
	private static String httpRequest(String url) throws IOException{
		URL theUrl = new URL( url );
        URLConnection yc = theUrl.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream())
                            );
        
        
        StringBuffer sb = new StringBuffer();
        
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            sb.append( inputLine );

        in.close();

        return sb.toString();
	}
}
