package br.com.constantini.yql;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * <diagnostics>
        <publiclyCallable>true</publiclyCallable>
        <url execution-time="184"><![CDATA[http://api.flickr.com/services/rest/?method=flickr.photos.search&text=Cat&page=1&per_page=10]]></url>
        <user-time>185</user-time>
        <service-time>184</service-time>
        <build-version>8771</build-version>
    </diagnostics> 
 *
 */
@XStreamAlias("diagnostics")
public class Diagnostics {

	@XStreamAlias("publiclyCallable")
	private Boolean publiclyCallable;
	
	@XStreamAlias("user-time")
	private Long userTime;
	
	@XStreamAlias("service-time")
	private Long serviceTime;
	
	@XStreamAlias("build-version")
	private String buildVersion;

	@XStreamImplicit(itemFieldName="url")
	private List<String> urlList;
	
	public Boolean getPubliclyCallable() {
		return publiclyCallable;
	}

	public void setPubliclyCallable(Boolean publiclyCallable) {
		this.publiclyCallable = publiclyCallable;
	}

	public Long getUserTime() {
		return userTime;
	}

	public void setUserTime(Long userTime) {
		this.userTime = userTime;
	}

	public Long getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Long serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getBuildVersion() {
		return buildVersion;
	}

	public void setBuildVersion(String buildVersion) {
		this.buildVersion = buildVersion;
	}

	public List<String> getUrlList() {
		return urlList;
	}

	public void setUrlList(List<String> urlList) {
		this.urlList = urlList;
	}
}
