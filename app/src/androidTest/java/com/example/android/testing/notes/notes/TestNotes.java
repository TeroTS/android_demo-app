package com.example.android.testing.notes.notes;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.*;
import org.junit.runner.RunWith;
import com.example.android.testing.notes.notes.pageObjects.*;


@RunWith(AndroidJUnit4.class)
public class TestNotes {

    private MainPage mainPage;
    private NewNotePage newNotePage;

    @Rule
    public ActivityTestRule<NotesActivity> mActivityTestRule = new ActivityTestRule<>(NotesActivity.class);

    @Before
    public void setup() {
        mainPage = new MainPage();
    }

    @Test
    public void addNote() {
        // Given application is open
        //When user adds a note
        newNotePage = mainPage.clickAddNote();
        mainPage = newNotePage.addNote("Test note 0", "This is test note 0");
        //Then user should see the note in main page
        mainPage.checkNoteTitle("Test note 0");
    }

    @Test
    public void addTwoNotes() {
        // Given application is open
        //When user adds two notes
        newNotePage = mainPage.clickAddNote();
        mainPage = newNotePage.addNote("Test note 1", "This is test note 1");
        newNotePage = mainPage.clickAddNote();
        mainPage = newNotePage.addNote("Test note 2", "This is test note 2");
        //Then user should see notes in main page
        mainPage.checkNoteTitle("Test note 1");
        mainPage.checkNoteTitle("Test note 2");
    }

}
