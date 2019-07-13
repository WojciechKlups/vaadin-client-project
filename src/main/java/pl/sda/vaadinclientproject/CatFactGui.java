package pl.sda.vaadinclientproject;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("cat")
public class CatFactGui extends HorizontalLayout {

    @Autowired
    public CatFactGui(CatFactClient catFactClient, CatGifClient catGifClient) {
        Label label = new Label(catFactClient.getCatFactFormApi().getText());

        Image image = new Image(catGifClient.getCatGifFromApi(), "Ładowanie...");

        add(label);
        add(image);
    }

}
