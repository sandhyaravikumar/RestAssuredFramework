package com.spotify.oauth2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Setter
@Getter
@Jacksonized
@Builder

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExternalUrls{

	@JsonProperty("spotify")
	private String spotify;

	ExternalUrls(String spotify) {
		this.spotify = spotify;
	}

	public static ExternalUrlsBuilder builder() {
		return new ExternalUrlsBuilder();
	}

	public static class ExternalUrlsBuilder {
		private String spotify;

		ExternalUrlsBuilder() {
		}

		public ExternalUrlsBuilder spotify(String spotify) {
			this.spotify = spotify;
			return this;
		}

		public ExternalUrls build() {
			return new ExternalUrls(spotify);
		}

		public String toString() {
			return "ExternalUrls.ExternalUrlsBuilder(spotify=" + this.spotify + ")";
		}
	}
}