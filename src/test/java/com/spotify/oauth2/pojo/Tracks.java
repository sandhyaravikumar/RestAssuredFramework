package com.spotify.oauth2.pojo;

import java.util.List;

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

public class Tracks{

	@JsonProperty("next")
	private Object next;

	@JsonProperty("total")
	private int total;

	@JsonProperty("offset")
	private int offset;

	@JsonProperty("previous")
	private Object previous;

	@JsonProperty("limit")
	private int limit;

	@JsonProperty("href")
	private String href;

	@JsonProperty("items")
	private List<Object> items;

}