package com.spotify.oauth2.tests;

import com.spotify.oauth2.Utils.DataLoader;
import com.spotify.oauth2.api.StatusCode;
import com.spotify.oauth2.api.applicationApi.PlaylistAPI;
import com.spotify.oauth2.pojo.Error;
import com.spotify.oauth2.pojo.Playlist;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.spotify.oauth2.Utils.FakerUtil.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class PlaylistTests extends Base {




    @Description("This is scenario where user is trying to create a new playlist")
    @Test(description = "User should be able to create a new playlist")
    public void ShouldBeAbleToCreateAPlaylist() {

        Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(), true);

        Response response = PlaylistAPI.post(requestPlaylist);

        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertEqual(response.as(Playlist.class), requestPlaylist);

    }

    @Test
    public void ShouldBeAbleToGetAPlaylist() {

        Playlist requestPlaylist = playlistBuilder("Updated twice Playlist Name", "Updated playlist description", true);

        Response response = PlaylistAPI.get(DataLoader.getInstance().getPlaylistId());


        assertStatusCode(response.statusCode(), StatusCode.CODE_200);

        assertEqual(response.as(Playlist.class), requestPlaylist);
    }

    @Test
    public void ShouldBeAbleToChangeAPlaylist() {

        Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(), true);

        Response response = PlaylistAPI.update(DataLoader.getInstance().getUpdatePlaylistId(), requestPlaylist);

        assertStatusCode(response.statusCode(), StatusCode.CODE_200);

    }

    //Negativecase

    @Test
    public void ShouldNotBeAbleToCreateAPlaylistWithoutName() {

        Playlist requestPlaylist = playlistBuilder("", generateDescription(), true);

        Response response = PlaylistAPI.post(requestPlaylist);
        assertThat(response.statusCode(), equalTo(StatusCode.CODE_400.code));

        Error error = response.as(Error.class);
        assertError(error, StatusCode.CODE_400);

    }

    @Test
    public void ShouldNotBeAbleToCreateAPlaylistWithInvalidToken() {

        String invalid_token = "12345";
        Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(), true);

        Response response = PlaylistAPI.post(invalid_token, requestPlaylist);
        assertThat(response.statusCode(), equalTo(StatusCode.CODE_401.code));

        Error error = response.as(Error.class);

        assertError(error, StatusCode.CODE_401);

    }

    //other methods
    @Step("User provides name and description")
    public Playlist playlistBuilder(String name, String description, boolean _public) {
        return Playlist.builder().name(name).description(description).jsonMemberPublic(_public).build();
    }

    @Step("validating if the playlist is created successfully")
    public void assertEqual(Playlist responsePlaylist, Playlist requestPlaylist) {
        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.isJsonMemberPublic(), equalTo(requestPlaylist.isJsonMemberPublic()));

    }

    public void assertStatusCode(int expectedStatusCode, StatusCode statusCode) {
        assertThat(expectedStatusCode, equalTo(statusCode.code));
    }

    public void assertError(Error error, StatusCode statusCode) {

        assertThat(error.getError().getStatus(), equalTo(statusCode.code));
        assertThat(error.getError().getMessage(), equalTo(statusCode.msg));

    }
}

