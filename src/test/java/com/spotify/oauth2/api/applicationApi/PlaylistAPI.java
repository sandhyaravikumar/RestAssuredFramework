package com.spotify.oauth2.api.applicationApi;

import com.spotify.oauth2.Utils.ConfigLoader;
import com.spotify.oauth2.Utils.DataLoader;
import com.spotify.oauth2.api.RestResource;
import com.spotify.oauth2.pojo.Playlist;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static com.spotify.oauth2.api.Route.*;
import static com.spotify.oauth2.api.TokenManager.getToken;

public class PlaylistAPI {

    @Step("Then User creates a playlist")
    public static Response post(Playlist requestPlaylist){
        return RestResource.post(getToken(),
                USERS + "/" + ConfigLoader.getConfigLoader().getUserId() + PLAYLISTS,requestPlaylist);
    }

    public static Response post(String token, Playlist requestPlaylist){

        return RestResource.post(token,
                USERS + "/" + ConfigLoader.getConfigLoader().getUserId() + PLAYLISTS,requestPlaylist);
    }

    public static Response get(String playlistId){

        return RestResource.get(getToken(),
                PLAYLISTS +"/"+ DataLoader.getInstance().getPlaylistId());

    }

    public static Response update(String playlistId, Playlist requestPlaylist){

        return RestResource.update(getToken(),PLAYLISTS +
                "/"+DataLoader.
                        getInstance().
                        getUpdatePlaylistId(),
                requestPlaylist);

    }


}
