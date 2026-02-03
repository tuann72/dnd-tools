package com.example.application.characterSheet.characterSheetWidgets;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public abstract class characterSheetWidget extends Composite<Div> {
    private final Div header;
    private final Div body;
    private final Div footer;
    private final String colorScheme;
    private final ArrayList<String> tags;

    public characterSheetWidget(Div header, Div body, Div footer, String colorScheme, ArrayList<String> tags) {
        this.header = header;
        this.body = body;
        this.footer = footer;
        this.colorScheme = colorScheme;
        this.tags = tags;
    }
}
