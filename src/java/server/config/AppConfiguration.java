package server.config;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;


/**
 * Application Configuration
 */
public class AppConfiguration extends Configuration
{
	//This was going to be used if I could figure out the issue with getting the classes I need from Dropwizard
	/*@Valid
	@NotNull
	private DataSourceFactory database = new DataSourceFactory();*/
	
	@NotEmpty
	private String template;
	
	@NotEmpty
	private String defaultName = "No Title";
	
	@JsonProperty
	public String getDefaultName()
	{
		return defaultName;
	}
	
	@JsonProperty
	public void setDefaultName(String name)
	{
		this.defaultName = name;
	}
	
	
}
