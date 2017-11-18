package com.sqlitesample.helper;

import android.content.Context;
import android.hardware.input.InputManager;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.regex.Pattern;

/**
 * Created by madhu on 17-Nov-17.
 */

public class InputValidation {
    private Context context;


    public InputValidation(Context context) {
        this.context = context;
    }

    public boolean isInputEditTextFilled(EditText editText, String message) {

        // boolean isEmpty = false;

        String value = editText.getText().toString();

        if (value.isEmpty()) {
            editText.setError(message);
            hideKeyboardFrom(editText);
            return false;
        }


        return true;
    }

    public boolean isInputEditTextEmailFilled(EditText editText, String message) {
        String value = editText.getText().toString();
        if (value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            hideKeyboardFrom(editText);
            editText.setError(message);
            hideKeyboardFrom(editText);
            return false;
        }

        return true;

    }
    public boolean isInputEditTextMatches(EditText editTextFirst,EditText editTextSecond ,String message) {


        String FirstValue = editTextFirst.getText().toString();
        String SecondValue = editTextSecond.getText().toString();
        if (!FirstValue.contentEquals(SecondValue)){
            hideKeyboardFrom(editTextSecond);

            return false;
        }


        return true;

    }

    private void hideKeyboardFrom(View view) {

        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromInputMethod(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);





    }
}
