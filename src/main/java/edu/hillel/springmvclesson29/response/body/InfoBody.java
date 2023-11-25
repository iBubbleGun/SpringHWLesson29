package edu.hillel.springmvclesson29.response.body;

import edu.hillel.springmvclesson29.response.ResponseBodyInterface;
import edu.hillel.springmvclesson29.response.enums.InfoCode;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class InfoBody implements ResponseBodyInterface {

    private final String code;
    private final String details;

    @Contract(pure = true)
    public InfoBody(@NotNull InfoCode code, String details) {
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
