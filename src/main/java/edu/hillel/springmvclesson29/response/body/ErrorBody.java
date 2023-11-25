package edu.hillel.springmvclesson29.response.body;

import edu.hillel.springmvclesson29.response.ResponseBodyInterface;
import edu.hillel.springmvclesson29.response.enums.ErrorCode;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ErrorBody implements ResponseBodyInterface {

    private final String code;
    private final String details;

    @Contract(pure = true)
    public ErrorBody(@NotNull ErrorCode code, String details) {
        this.code = code.name();
        this.details = details;
    }

    @Override
    public String getDetails() {
        return details;
    }

    @Override
    public String getCode() {
        return code;
    }
}
