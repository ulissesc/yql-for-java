package br.com.constantini.yql;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *<query xmlns:yahoo="http://www.yahooapis.com/v1/base.rng"
    yahoo:count="10" yahoo:created="2010-08-31T04:39:55Z" yahoo:lang="en-US">
    <diagnostics>
        <publiclyCallable>true</publiclyCallable>
        <url execution-time="184"><![CDATA[http://api.flickr.com/services/rest/?method=flickr.photos.search&text=Cat&page=1&per_page=10]]></url>
        <user-time>185</user-time>
        <service-time>184</service-time>
        <build-version>8771</build-version>
    </diagnostics> 
    <results>
        <photo farm="5" id="4945723022" isfamily="0" isfriend="0"
            ispublic="1" owner="35046186@N00" secret="9a95e111bf"
            server="4075" title="Mac &amp; the cat"/>
        <photo farm="5" id="4945714586" isfamily="0" isfriend="0"
            ispublic="1" owner="47561644@N03" secret="5fa10e93cc"
            server="4109" title="Cat-Eye Sunnies"/>
     ....
    </results>
</query> 
 *
 */

@XStreamAlias("query")
public class YQLQuery {

	@XStreamAlias("diagnostics")
	private Diagnostics diagnostics;
	
	@XStreamAlias("results")
	private Results results;

	
	public Diagnostics getDiagnostics() {
		return diagnostics;
	}

	public void setDiagnostics(Diagnostics diagnostics) {
		this.diagnostics = diagnostics;
	}

	public Results getResults() {
		return results;
	}

	public void setResults(Results results) {
		this.results = results;
	}
	
}
