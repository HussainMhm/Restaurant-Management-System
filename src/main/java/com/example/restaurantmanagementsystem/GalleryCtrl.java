package com.example.restaurantmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GalleryCtrl implements Initializable {

    static public LinkedList<String> pathList = new LinkedList<>();

    @FXML
    HBox hBox;

    private ImageView imageView;
    private Button leftBtn;
    private Button rightBtn;

    private int currImageIndex = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hBox.setAlignment(Pos.CENTER);

        leftBtn = new Button("<");
        rightBtn = new Button(">");

        LinkedList<Image> images = new LinkedList<>();
        for (int i = 0; i < pathList.length(); i++)
            images.add(new Image(pathList.get(i)));

        this.imageView = new ImageView(images.get(currImageIndex));

        rightBtn.setOnAction(e -> {
            currImageIndex++;
            if (currImageIndex == pathList.length())
                currImageIndex = 0;

            this.imageView.setImage(images.get(currImageIndex));

        });

        leftBtn.setOnAction(e -> {
            currImageIndex--;
            if (currImageIndex > pathList.length() + 1 || currImageIndex == -1)
                currImageIndex = pathList.length() - 1;

            this.imageView.setImage(images.get(currImageIndex));
        });

        this.imageView.setFitHeight(275);
        this.imageView.setFitWidth(350);

        hBox.setSpacing(15);
        hBox.getChildren().addAll(leftBtn, imageView, rightBtn);
    }

    public void navigateBack(ActionEvent event){
        Load.navigate(event, "CustomerScreen.fxml");
    }
}
