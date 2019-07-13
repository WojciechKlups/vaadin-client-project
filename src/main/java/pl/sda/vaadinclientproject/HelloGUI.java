package pl.sda.vaadinclientproject;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("hello")
public class HelloGUI extends VerticalLayout {

    public HelloGUI() {

        TextField textFieldName = new TextField("Your name:");
        Button buttonOk = new Button("Proceed",new Icon(VaadinIcon.THUMBS_UP));
        Label labelHello = new Label();
        buttonOk.addClickListener(click -> {
            labelHello.setText("Hello " + textFieldName.getValue());
            Image image = new Image ("https://media.tenor.com/images/1170597818a37a7c6e3e1d4baeb6e2eb/tenor.gif",
                    "Nie można pobrać obrazka :(");
            add(image);
        });
        add(textFieldName);
        add(buttonOk);
        add(labelHello);
    }
}
