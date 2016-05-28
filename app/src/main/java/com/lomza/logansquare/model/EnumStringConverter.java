package com.lomza.logansquare.model;

import com.bluelinelabs.logansquare.typeconverters.StringBasedTypeConverter;

public class EnumStringConverter extends StringBasedTypeConverter<Status> {
    @Override
    public Status getFromString(String status) {
        return Status.valueOf(status);
    }

    public String convertToString(Status object) {
        return object.toString();
    }
}