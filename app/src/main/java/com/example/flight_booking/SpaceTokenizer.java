package com.example.flight_booking;

import android.widget.MultiAutoCompleteTextView;

public class SpaceTokenizer implements MultiAutoCompleteTextView.Tokenizer {
    @Override
    public int findTokenStart(CharSequence text, int cursor) {
        int i = cursor;
        while (i > 0 && text.charAt(i - 1) != ' ') {
            i--;
        }
        return i;
    }

    @Override
    public int findTokenEnd(CharSequence text, int cursor) {
        int i = cursor;
        int len = text.length();

        while (i < len) {
            if (text.charAt(i) == ' ') {
                return i;
            } else {
                i++;
            }
        }
        return len;
    }

    @Override
    public CharSequence terminateToken(CharSequence text) {
        return text;
    }
}
