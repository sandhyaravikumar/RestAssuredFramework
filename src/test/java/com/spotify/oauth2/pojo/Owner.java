package com.spotify.oauth2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Jacksonized
@Getter
@Setter
@Builder

public class Owner{

	@JsonProperty("href")
	private String href;

	@JsonProperty("id")
	private String id;

	@JsonProperty("display_name")
	private String displayName;

	@JsonProperty("type")
	private String type;

	@JsonProperty("external_urls")
	private ExternalUrls externalUrls;

	@JsonProperty("uri")
	private String uri;
}