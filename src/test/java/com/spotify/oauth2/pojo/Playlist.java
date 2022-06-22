package com.spotify.oauth2.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;


@Getter @Setter
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Playlist{

	@JsonProperty("owner")
	private Owner owner;

	@JsonProperty("images")
	private List<Object> images;

	@JsonProperty("snapshot_id")
	private String snapshotId;

	@JsonProperty("collaborative")
	private boolean collaborative;

	@JsonProperty("description")
	private String description;

	@JsonProperty("primary_color")
	private Object primaryColor;

	@JsonProperty("type")
	private String type;

	@JsonProperty("uri")
	private String uri;

	@JsonProperty("tracks")
	private Tracks tracks;

	@JsonProperty("followers")
	private Followers followers;

	@JsonProperty("public")
	private boolean jsonMemberPublic;

	@JsonProperty("name")
	private String name;

	@JsonProperty("href")
	private String href;

	@JsonProperty("id")
	private String id;

	@JsonProperty("external_urls")
	private ExternalUrls externalUrls;

}