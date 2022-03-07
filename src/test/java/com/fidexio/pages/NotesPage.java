package com.fidexio.pages;

import com.fidexio.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NotesPage extends BasePage{
    Faker faker = new Faker();
    Random random = new Random();

    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement noteCreateButton;

    @FindBy(css="input.o_input.ui-autocomplete-input")
    public WebElement tagSelect;

    @FindBy(xpath = "//a[contains(text(),'Create and Edit')]")
    public WebElement tagCreate;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    public WebElement tagSave;

    @FindBy(css="div.note-editable.panel-body")
    public WebElement noteText;

    @FindBy(xpath = "//div[@class='o_readonly']//p")
    public WebElement verifyNote;

    @FindBy(css="span.oe_kanban_content")
    public WebElement verifyNote2;

    @FindBy(xpath = "//button[@accesskey='k']")
    public WebElement kanbanNoteButton;

    @FindBy(xpath = "//button[@accesskey='l']")
    public WebElement listNoteButton;

    @FindBy(xpath = "//button[@accesskey='j']")
    public WebElement discardNoteButton;

    @FindBy(xpath = "//span[contains(text(),'Ok')]")
    public WebElement OkNoteButton;

    @FindBy(xpath = "//div[@class='oe_kanban_color_0 oe_kanban_global_click_edit oe_semantic_html_override oe_kanban_card o_kanban_record ui-sortable-handle']")
    public List<WebElement> noteCounter;

    @FindBy(xpath = "//span[@class='oe_kanban_content ']//span")
    public List<WebElement> notesText;

    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    public WebElement deleteNoteButton;

    @FindBy(xpath = "//tr[@class='o_data_row']")
    public List<WebElement> checkboxNote;

    @FindBy(xpath = "//button[contains(text(),'Action')]")
    public WebElement actionNoteButton;

    @FindBy(xpath = "//span[@class='o_pager_limit']")
    public WebElement countNote;

    public static String beforeNoteSize;


    public void randomNote(){
        if(noteCounter.size() != 0){
        int randomNotes = random.nextInt(noteCounter.size());
        noteCounter.get(randomNotes).click();}else{
            createNewNote2();
            int randomNotes = random.nextInt(noteCounter.size());
            noteCounter.get(randomNotes).click();
            System.out.println("New note created.");

        }
    }


    public void randomDeleteNote(){


        if(checkboxNote.size()!= 0){
        int randomDeleteNotes = random.nextInt(checkboxNote.size());
        checkboxNote.get(randomDeleteNotes).click();}
        else{


            createNewNote();
            int randomDeleteNotes = random.nextInt(checkboxNote.size());
            checkboxNote.get(randomDeleteNotes).click();
            System.out.println("New note created.");

        }

    }

    public void createNewNote(){

        noteCreateButton.click();
        fakerTag();
        fakerNote();
        saveButton.click();
        nav("Notes");
        listNoteButton.click();
    }

    public void createNewNote2(){
        noteCreateButton.click();
        fakerTag();
        fakerNote();
        saveButton.click();
        nav("Notes");
    }


    public void editVerifyNote(){
        String actualNote = verifyNote.getText();
        nav("Notes");
        BrowserUtils.waitFor(2);
        for (WebElement notes : notesText) {
            if(notes.getText().equals(actualNote)){
                System.out.println("notes.getText() = " + notes.getText());
                System.out.println("actualNote = " + actualNote);
                Assert.assertEquals(notes.getText(),actualNote);
            }
        }
    }

    public void fakerTag(){
        String tag = faker.address().city();
        tagSelect.sendKeys(tag);
        tagCreate.click();
        tagSave.click();

    }
    public void fakerNote(){
        String note = faker.lorem().paragraph(3);
        noteText.sendKeys(note);
    }




}
