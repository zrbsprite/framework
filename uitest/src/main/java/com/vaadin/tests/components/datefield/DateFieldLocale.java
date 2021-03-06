package com.vaadin.tests.components.datefield;

import java.time.LocalDate;
import java.util.Locale;

import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.tests.components.TestBase;
import com.vaadin.tests.components.TestDateField;
import com.vaadin.ui.AbstractDateField;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class DateFieldLocale extends TestBase {

    @Override
    public void setup() {
        final AbstractDateField dateField = new TestDateField("DateField");
        dateField.setLocale(new Locale("fi", "FI"));
        dateField.setCaption(dateField.getLocale().toString());
        dateField.setValue(LocalDate.of(2013, 7, 27));
        dateField.setResolution(Resolution.DAY);

        addComponent(new Button("Change locale", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                if (dateField.getLocale().getCountry().equalsIgnoreCase("fi")) {
                    dateField.setLocale(new Locale("zh", "CN"));
                } else {
                    dateField.setLocale(new Locale("fi", "FI"));
                }
                dateField.setCaption(dateField.getLocale().toString());
            }
        }));

        addComponent(dateField);
    }

    @Override
    protected String getDescription() {
        return "Click change locale to switch between Finnish and Chinese locale for the DateField. The date string should be updated in addition to the caption.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 3935;
    }

}
