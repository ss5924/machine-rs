package me.songha.rs.machiners.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NOT_FOUND(404, "NOT-FOUND-404", "NOT FOUND"),
    INTER_SERVER_ERROR(500, "INTER-SERVER-ERROR-500", "INTERNAL SERVER ERROR"),
    INVALID_REQUEST(400, "INVALID-REQUEST-400", "INVALID REQUEST");

    private int status;
    private String errorCode;
    private String message;
}