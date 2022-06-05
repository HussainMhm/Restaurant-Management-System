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
    @FXML
    HBox hBox;
    @FXML
    private ImageView imageView;
    @FXML
    private Button leftBtn;
    @FXML
    private Button rightBtn;

    static public LinkedList<String> pathList = new LinkedList<>();
    private int currImageIndex = 0;


    // Set the settings for gallery viewer
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hBox.setAlignment(Pos.CENTER);


        // Take images paths from pathList and add them to linkedList
        LinkedList<Image> images = new LinkedList<>();
        for (int i = 0; i < pathList.length(); i++)
            images.add(new Image(pathList.get(i)));

        this.imageView = new ImageView(images.get(currImageIndex));

        // Right arrow
        rightBtn.setOnAction(e -> {
            currImageIndex++;
            if (currImageIndex == pathList.length())
                currImageIndex = 0;

            this.imageView.setImage(images.get(currImageIndex));

        });

        // Left arrow
        leftBtn.setOnAction(e -> {
            currImageIndex--;
            if (currImageIndex > pathList.length() + 1 || currImageIndex == -1)
                currImageIndex = pathList.length() - 1;

            this.imageView.setImage(images.get(currImageIndex));
        });

        // Width & Height
        this.imageView.setFitHeight(275);
        this.imageView.setFitWidth(350);

        hBox.setSpacing(15);
        hBox.getChildren().addAll(leftBtn, imageView, rightBtn);
    }

    // navigate to previous page
    public void navigateBack(ActionEvent event){
        Load.navigate(event, "CustomerScreen.fxml");
    }
}
