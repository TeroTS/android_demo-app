package com.example.android.testing.notes.notes.pageObjects;

import com.example.android.testing.notes.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;

/**
 * Created by teststation on 25/04/2017.
 */

public class NewNotePage {

    public MainPage addNote(String title, String note) {
        addTitle(title);
        addNoteText(note);
        return new MainPage();
    }

    private void addTitle(String title) {
        onView(withId(R.id.add_note_title)).perform(scrollTo(), replaceText(title), closeSoftKeyboard());
    }

    private void addNoteText(String note) {
        onView(withId(R.id.add_note_description)).perform(scrollTo(), replaceText(note), closeSoftKeyboard());
        onView(withId(R.id.fab_add_notes)).perform(click());
    }

}
