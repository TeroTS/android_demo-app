package com.example.android.testing.notes.notes;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.example.android.testing.notes.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;


@RunWith(AndroidJUnit4.class)
public class TestNotes {

    @Rule
    public ActivityTestRule<NotesActivity> mActivityTestRule = new ActivityTestRule<>(NotesActivity.class);

    @Test
    public void addNotes() {
        for(int i=0;i<=7;i++) {
            addNote(i);
        }
        ViewInteraction notesList = onView(withId(R.id.notes_list));
        notesList.perform(swipeUp());
        notesList.perform(swipeDown());
    }

    private void addNote(int idx) {
        onView(withId(R.id.fab_add_notes)).perform(click());

        String title = String.format("Test note %s", idx);
        onView(withId(R.id.add_note_title)).perform(scrollTo(), replaceText(title), closeSoftKeyboard());

        String note = String.format("This is test note %s", idx);
        onView(withId(R.id.add_note_description)).perform(scrollTo(), replaceText(note), closeSoftKeyboard());

        onView(withId(R.id.fab_add_notes)).perform(click());
    }


}
