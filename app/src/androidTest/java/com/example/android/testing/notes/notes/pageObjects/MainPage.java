package com.example.android.testing.notes.notes.pageObjects;

import android.support.test.espresso.ViewInteraction;

import com.example.android.testing.notes.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;


/**
 * Created by teststation on 25/04/2017.
 */

public class MainPage {

    public NewNotePage clickAddNote() {
        onView(withId(R.id.fab_add_notes)).perform(click());
        return new NewNotePage();
    }

    public void checkNoteTitle(String title) {
        onView(withText(title)).check(matches(isDisplayed()));
    }




}
