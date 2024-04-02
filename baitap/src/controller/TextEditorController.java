package controller;

import model.TextEditorModel;
import view.TextEditorView;

public class TextEditorController {
    public static void main(String[] args) {
        TextEditorModel model = new TextEditorModel();
        TextEditorView view = new TextEditorView(model);

        view.run();
    }
}