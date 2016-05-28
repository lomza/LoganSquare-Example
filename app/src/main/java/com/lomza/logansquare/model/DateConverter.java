package com.lomza.logansquare.model;

import com.bluelinelabs.logansquare.typeconverters.DateTypeConverter;
import com.fasterxml.jackson.core.JsonParser;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter extends DateTypeConverter {

    private DateFormat mDateFormatSerialized;
    private DateFormat mDateFormatParsed;

    public DateConverter() {
        mDateFormatSerialized = new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault());
        mDateFormatParsed = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
    }

    @Override
    public Date parse(JsonParser jsonParser) throws IOException {
        try {
            return mDateFormatParsed.parse(jsonParser.getText());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public DateFormat getDateFormat() {
        return mDateFormatSerialized;
    }
}