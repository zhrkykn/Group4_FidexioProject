package com.fidexio.step_defs;

import com.fidexio.pages.NotesPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NoteStepDefs {
    NotesPage notesPage = new NotesPage();

    @When("The user clicks the Notes Page")
    public void the_user_clicks_the_Notes_Page() {

        notesPage.nav("Notes");
    }

    @Then("Click on Create button for Notes")
    public void click_on_Create_button_for_Notes() {

        BrowserUtils.waitFor(2);
        notesPage.noteCreateButton.click();
    }

    @Then("The user select tags for notes")
    public void the_user_select_tags_for_notes() {
        BrowserUtils.waitFor(2);
       notesPage.fakerTag();

    }

    @Then("The user write a note")
    public void the_user_write_a_note() {
        BrowserUtils.waitFor(2);
        notesPage.fakerNote();
    }

    @Then("Click on Save button for Notes")
    public void click_on_Save_button_for_Notes() {
        BrowserUtils.waitFor(2);
       notesPage.saveButton.click();
    }

    @Then("The user should be able to see new note")
    public void the_user_should_be_able_to_see_new_note() {
       String actualNotes =notesPage.verifyNote.getText();
       notesPage.nav("Notes");
       BrowserUtils.waitFor(2);
       String expectedNotes =notesPage.verifyNote2.getText();
        Assert.assertEquals(expectedNotes,actualNotes);

    }

    @Then("Click on Kanban button for Notes")
    public void click_on_Kanban_button_for_Notes() {
        BrowserUtils.waitFor(2);
       notesPage.kanbanNoteButton.click();

    }

    @Then("The user should be able to see Kanban note list")
    public void the_user_should_be_able_to_see_Kanban_note_list() {
        BrowserUtils.waitFor(2);
        String url = Driver.get().getCurrentUrl();
        Assert.assertTrue(url.contains("kanban"));
    }

    @Then("Click on List button for Notes")
    public void click_on_List_button_for_Notes() {
        BrowserUtils.waitFor(2);
       notesPage.listNoteButton.click();
    }

    @Then("The user should be able to see List note list")
    public void the_user_should_be_able_to_see_List_note_list() {
        BrowserUtils.waitFor(2);
        String url = Driver.get().getCurrentUrl();
        Assert.assertTrue(url.contains("list"));
    }


    @Then("Click on Discard button for Notes")
    public void click_on_Discard_button_for_Notes() {
        notesPage.discardNoteButton.click();
    }

    @Then("Click on Ok button for notes")
    public void click_on_Ok_button_for_notes() {

        notesPage.OkNoteButton.click();
    }


    @Then("Select note to edit")
    public void select_note_to_edit() {
        notesPage.randomNote();

    }

    @Then("The user should be able to see edited note")
    public void the_user_should_be_able_to_see_edited_note() {
        notesPage.editVerifyNote();
    }

    @Then("Click the more button on the side of the note")
    public void click_the_more_button_on_the_side_of_the_note() {
        notesPage.listNoteButton.click();
        BrowserUtils.waitFor(2);
       notesPage.randomDeleteNote();

       notesPage.beforeNoteSize = notesPage.countNote.getText();
       System.out.println("notSize = " + notesPage.beforeNoteSize);


    }

    @Then("Click on delete button for notes")
    public void click_on_delete_button_for_notes() {
        BrowserUtils.waitFor(2);
        notesPage.actionNoteButton.click();
        notesPage.deleteNoteButton.click();
    }

    @Then("The user should be able to see that the note has been deleted")
    public void the_user_should_be_able_to_see_that_the_note_has_been_deleted() {
        BrowserUtils.waitFor(2);
        String afterNotSize = notesPage.countNote.getText();
        if(afterNotSize.equals(" ")){
            System.out.println("Not found note");
        }else{
        System.out.println("newNotSize = " + afterNotSize);
        Assert.assertNotEquals(afterNotSize,notesPage.beforeNoteSize);}
    }

}
