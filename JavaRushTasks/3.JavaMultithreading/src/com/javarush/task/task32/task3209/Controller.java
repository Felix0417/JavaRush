package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void init(){
        createNewDocument();
    }

    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("Редактор");
        currentFile = null;
        init();
    }

    public void openDocument(){

    }

    public void saveDocument(){

    }

    public void saveDocumentAs(){

    }

    public void exit(){
        System.exit(0);
    }


    public void resetDocument(){
        UndoListener undoListener = view.getUndoListener();
        if (document != null){
            document.removeUndoableEditListener(undoListener);
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(undoListener);
        view.update();
    }

    public void setPlainText(String text){
        try {
            resetDocument();
            StringReader reader = new StringReader(text);
            new HTMLEditorKit().read(reader, document, 0);
        }catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText(){
        StringWriter writer = new StringWriter();
        try {
            new HTMLEditorKit().write(writer ,document,0, document.getLength());
        }catch (Exception e){
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }



    public static void main(String[] args) {
        View view1 = new View();
        Controller controller = new Controller(view1);
        view1.setController(controller);
        view1.init();
        controller.init();
    }
}
