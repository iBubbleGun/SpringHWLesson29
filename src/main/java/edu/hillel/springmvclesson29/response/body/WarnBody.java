package edu.hillel.springmvclesson29.response.body;

import edu.hillel.springmvclesson29.response.ResponseBodyInterface;
import edu.hillel.springmvclesson29.response.enums.WarnCode;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class WarnBody implements ResponseBodyInterface {

    private final String code;
    private final String details;

    @Contract(pure = true)
    public WarnBody(@NotNull WarnCode code, String details) {
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
