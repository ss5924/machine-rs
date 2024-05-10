package me.songha.rs.machiners.msg;

public interface MessageCallback {
    void onSuccess(String jsonObject, long offset);

    void onFailure(String jsonObject, String errorMessage);
}