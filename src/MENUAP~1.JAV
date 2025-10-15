package com.example.menu_application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MenuApplication extends Application {

    public String menuColor = "#808080";
    public String managementColor = "#dcdcdc";
    Pane pne_base, pne_cards;
    MenuPane pne_menu;
    ManagementPane pne_management;
    OutputPane pne_output;
    HelpPane pne_help;


    @Override
    public void start(Stage stage) throws IOException {
        pne_cards = new StackPane();
        pne_menu = new MenuPane();
        pne_management = new ManagementPane();
        pne_output = new OutputPane();
        pne_help = new HelpPane();


        //Adding individual pages to the card manager panel
        pne_cards.getChildren().addAll(pne_help,pne_management);
        //Adding card stack, menu, and footer panel
        pne_base = new VBox(7);
        pne_base.getChildren().addAll(pne_menu,pne_cards,pne_output);


        Scene scene = new Scene(pne_base, 880, 785);

        scene.setFill(Color.DARKGRAY);

        FileInputStream inputStream  = new FileInputStream("Icons/Icon.png");
        Image icon = new Image(inputStream);


//        //Setting icon
        stage.getIcons().add(icon);
        //Setting stage title
        stage.setTitle("Menu Management V1.0");
        //Adding scene to stage
        stage.setScene(scene);
        //Displaying the content of the stage
        stage.show();


    }


    private class MenuPane extends HBox{

        Button btn_menu, btn_exit, btn_help;

        public MenuPane () throws FileNotFoundException {

            FileInputStream inputStream = new FileInputStream("Logos/Logo.png");
            Image image = new Image(inputStream);
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitWidth(220);
            imageView.setFitHeight(60);
            imageView.setPreserveRatio(true);


            btn_help = new Button("Help");
            btn_menu = new Button("Menu");
            btn_exit = new Button("Exit");


            // Setting all nodes
            btn_help.setStyle("-fx-background-color: White;");
            btn_help.setFont(Font.font(null, FontWeight.BOLD, 14));
            btn_menu.setStyle("-fx-background-color: White;");
            btn_menu.setFont(Font.font(null, FontWeight.BOLD, 14));

            btn_exit.setStyle("-fx-background-color: White;");
            btn_exit.setFont(Font.font(null, FontWeight.BOLD, 14));

            btn_menu.setTextFill(Paint.valueOf(menuColor));
            btn_exit.setTextFill(Paint.valueOf(menuColor));
            btn_help.setTextFill(Paint.valueOf(menuColor));




            btn_help.setMinHeight(40);
            btn_menu.setMinHeight(40);

            btn_help.setMinWidth(60);
            btn_menu.setMinWidth(100);

            btn_exit.setMinHeight(40);


            btn_exit.setMinWidth(80);
            

            btn_menu.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    btn_menu.setStyle("-fx-background-color: LightBlue");

                }
            });

            btn_menu.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    btn_menu.setStyle("-fx-background-color: White");
                }
            });

            btn_menu.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    btn_menu.setStyle("-fx-background-color: White");
                    pne_cards.getChildren().clear();
                    pne_cards.getChildren().add(pne_management);

                }
            });



            btn_help.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    btn_help.setStyle("-fx-background-color: LightBlue");

                }
            });

            btn_help.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    btn_help.setStyle("-fx-background-color: White");
                    pne_cards.getChildren().clear();
                    pne_cards.getChildren().add(pne_help);
                }
            });


            btn_help.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    btn_help.setStyle("-fx-background-color: White");
                }
            });


            btn_exit.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    btn_exit.setStyle("-fx-background-color: LightBlue");

                }
            });


            btn_exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    System.exit(0);
                    btn_exit.setStyle("-fx-background-color: LightBlue");

                }
            });

            btn_exit.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    btn_exit.setStyle("-fx-background-color: White");
                }
            });



            //Arranging all nodes
            this.setAlignment(Pos.TOP_CENTER);
            this.setStyle("-fx-background-color:"+menuColor);

            this.getChildren().addAll(imageView, btn_menu, btn_exit, btn_help);
            this.setMargin(imageView,new Insets(30,100,0,0));
            this.setMargin(btn_menu,new Insets(30,40,0,100));
            this.setMargin(btn_exit,new Insets(30,40,0,0));
            this.setMargin(btn_help,new Insets(30,40,0,0));

            this.setMinSize(90,100);
        }
    }



    private class ManagementPane extends GridPane {

        Label lbl_size_of_bread, lbl_type_of_bread, lbl_type_of_sandwich, lbl_vegetables, lbl_sauces,lbl_extras;
        RadioButton rbtn_size_of_bread_one, rbtn_size_of_bread_two, rbtn_type_of_bread_one,rbtn_type_of_bread_two,rbtn_type_of_bread_three,rbtn_type_of_bread_four,
                   rbtn_type_of_sandwich_one, rbtn_type_of_sandwich_two, rbtn_type_of_sandwich_three, rbtn_type_of_sandwich_four, rbtn_type_of_sandwich_five, rbtn_type_of_sandwich_six, rbtn_type_of_sandwich_seven, rbtn_type_of_sandwich_eight;
        ToggleGroup tg_selection_bread_size, tg_selection_bread_type, tg_selection_sandwich_type;
        Button btn_make_sandwich, btn_calculate_price;

        private String bread_size, bread_type, sandwich_type, vegetable_selection, extra_checkbox_selection, sauce_checkbox_selection;
        Bread bread;
        Sandwich sandwich;
        Vegetable vegetable;
        Extra extra;
        Sauces sauces;

        public ManagementPane () throws FileNotFoundException {

            FileInputStream inputStream = new FileInputStream("Graphics/Line.png");
            Image image = new Image(inputStream);
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitWidth(680);
            imageView.setPreserveRatio(true);


            tg_selection_bread_size = new ToggleGroup();
            tg_selection_bread_type = new ToggleGroup();
            tg_selection_sandwich_type = new ToggleGroup();

            lbl_size_of_bread = new Label("Size of Bread");
            lbl_type_of_bread = new Label("Type of Bread");

            lbl_type_of_sandwich = new Label("Type of Sandwich");
            lbl_vegetables = new Label("Vegetables");
            lbl_extras = new Label("Extra");
            lbl_sauces = new Label("Sauces");




            rbtn_size_of_bread_one = new RadioButton("Six Inch $20.00");
            rbtn_size_of_bread_two = new RadioButton("Foot Long $30.00");

            rbtn_type_of_bread_one = new RadioButton("Wheat");
            rbtn_type_of_bread_two = new RadioButton("Italian");
            rbtn_type_of_bread_three = new RadioButton("Parmesan Orgeano");
            rbtn_type_of_bread_four = new RadioButton("Honey Oat");




            rbtn_type_of_sandwich_one = new RadioButton("Italian B.M.T");
            rbtn_type_of_sandwich_two = new RadioButton("Mainway Club");
            rbtn_type_of_sandwich_three = new RadioButton("Steak & Cheese");
            rbtn_type_of_sandwich_four = new RadioButton("Chicken Teriyaki");
            rbtn_type_of_sandwich_five = new RadioButton("Mainway Melt");
            rbtn_type_of_sandwich_six = new RadioButton("Tuna");
            rbtn_type_of_sandwich_seven = new RadioButton("Roast Beef");
            rbtn_type_of_sandwich_eight = new RadioButton("Veggie Delite");


            rbtn_size_of_bread_one.setToggleGroup(tg_selection_bread_size);
            rbtn_size_of_bread_two.setToggleGroup(tg_selection_bread_size);

            rbtn_type_of_bread_one.setToggleGroup(tg_selection_bread_type);
            rbtn_type_of_bread_two.setToggleGroup(tg_selection_bread_type);
            rbtn_type_of_bread_three.setToggleGroup(tg_selection_bread_type);
            rbtn_type_of_bread_four.setToggleGroup(tg_selection_bread_type);


            rbtn_type_of_sandwich_one.setToggleGroup(tg_selection_sandwich_type);
            rbtn_type_of_sandwich_two.setToggleGroup(tg_selection_sandwich_type);
            rbtn_type_of_sandwich_three.setToggleGroup(tg_selection_sandwich_type);
            rbtn_type_of_sandwich_four.setToggleGroup(tg_selection_sandwich_type);
            rbtn_type_of_sandwich_five.setToggleGroup(tg_selection_sandwich_type);
            rbtn_type_of_sandwich_six.setToggleGroup(tg_selection_sandwich_type);
            rbtn_type_of_sandwich_seven.setToggleGroup(tg_selection_sandwich_type);
            rbtn_type_of_sandwich_eight.setToggleGroup(tg_selection_sandwich_type);




            tg_selection_bread_size.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                @Override
                public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldVal, Toggle newVal) {
                    if(newVal == null) {
                        return;
                    }

                    RadioButton rmi = (RadioButton) newVal;

                    if(rmi.getText().equals(rbtn_size_of_bread_one.getText())){
                        bread_size = "Six Inch ";
                        System.out.println("Six Inch ");

                    }else if (rmi.getText().equals(rbtn_size_of_bread_two.getText())){
                        bread_size = "Foot Long ";
                        System.out.println("Foot Long");
                    }

                }
            });



            tg_selection_bread_type.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                @Override
                public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValTwo, Toggle newValTwo) {
                    if(newValTwo == null) {
                        return;
                    }

                    RadioButton rmi = (RadioButton) newValTwo;

                    if(rmi.getText().equals(rbtn_type_of_bread_one.getText())){
                        bread_type = rbtn_type_of_bread_one.getText();
                    }else if (rmi.getText().equals(rbtn_type_of_bread_two.getText())){
                        bread_type = rbtn_type_of_bread_two.getText();
                    }else if (rmi.getText().equals(rbtn_type_of_bread_three.getText())){
                        bread_type = rbtn_type_of_bread_three.getText();
                    }else if (rmi.getText().equals(rbtn_type_of_bread_four.getText())){
                          bread_type = rbtn_type_of_bread_one.getText();
                    }

                }
            });



            tg_selection_sandwich_type.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                @Override
                public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldVal, Toggle newVal) {
                    if(newVal == null) {
                        return;
                    }

                    RadioButton rmi = (RadioButton) newVal;

                    if(rmi.getText().equals(rbtn_type_of_sandwich_one.getText())){
                        sandwich_type = rbtn_type_of_sandwich_one.getText();
                    }else if (rmi.getText().equals(rbtn_type_of_sandwich_two.getText())){
                        sandwich_type = rbtn_type_of_sandwich_two.getText();
                    }else if (rmi.getText().equals(rbtn_type_of_sandwich_three.getText())){
                        sandwich_type = rbtn_type_of_sandwich_three.getText();
                    }else if (rmi.getText().equals(rbtn_type_of_sandwich_four.getText())){
                        sandwich_type = rbtn_type_of_sandwich_four.getText();
                    }else if (rmi.getText().equals(rbtn_type_of_sandwich_five.getText())){
                        sandwich_type = rbtn_type_of_sandwich_five.getText();
                    }else if (rmi.getText().equals(rbtn_type_of_sandwich_six.getText())){
                        sandwich_type = rbtn_type_of_sandwich_six.getText();
                    }else if (rmi.getText().equals(rbtn_type_of_sandwich_seven.getText())){
                        sandwich_type = rbtn_type_of_sandwich_seven.getText();
                    }else if (rmi.getText().equals(rbtn_type_of_sandwich_eight.getText())){
                        sandwich_type = rbtn_type_of_sandwich_eight.getText();
                    }

                }
            });


            btn_make_sandwich = new Button("Make Sandwich");
            btn_calculate_price = new Button("Calculate Price");




            String [] vegitableStrings = {"Cucumbers", "Green Bell Peppers", "Lettuce", "Red Onions", "Tomatoes", "Pickles","Cheese"};

            ComboBox comboBox = new ComboBox();
            comboBox.setPromptText("Select");
            comboBox.getItems().addAll(vegitableStrings);
//            comboBox.setEditable(true);


            comboBox.valueProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observableValue, Object o, Object t1) {

                    vegetable_selection = (String) t1;
                    System.out.println(t1);

                }
            });



            CheckBox checkBoxOne = new CheckBox("Jalapenos");
            checkBoxOne.setIndeterminate(false);

            CheckBox checkBoxTwo = new CheckBox("Pineapples");
            checkBoxTwo.setIndeterminate(false);


            CheckBox checkBoxThree = new CheckBox("Black Olives");
            checkBoxThree.setIndeterminate(false);


            CheckBox checkBoxFour = new CheckBox("Mayonnaise");
            checkBoxFour.setIndeterminate(false);


            CheckBox checkBoxFive = new CheckBox("Honey Mustard");
            checkBoxFive.setIndeterminate(false);


            CheckBox checkBoxSix = new CheckBox("Sweet Onion");
            checkBoxSix.setIndeterminate(false);


            CheckBox checkBoxSeven = new CheckBox("Garlic Sauce");
            checkBoxSeven.setIndeterminate(false);



            checkBoxOne.selectedProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observableValue, Object o, Object t1) {

                    if(true){
                        extra_checkbox_selection = checkBoxOne.getText();
                        System.out.println(t1);
                    }

                }
            });

            checkBoxTwo.selectedProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observableValue, Object o, Object t1) {

                    if(true){
                        extra_checkbox_selection = checkBoxTwo.getText();
                        System.out.println(t1);
                    }


                }
            });


            checkBoxThree.selectedProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observableValue, Object o, Object t1) {

                    if(true){
                    extra_checkbox_selection = checkBoxThree.getText();
                    System.out.println(t1);
                   }
                }
            });


            checkBoxFour.selectedProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observableValue, Object o, Object t1) {

                    if(true){
                        sauce_checkbox_selection= checkBoxFour.getText();
                        System.out.println(t1);
                    }

                }
            });


            checkBoxFive.selectedProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observableValue, Object o, Object t1) {

                    if(true){
                        sauce_checkbox_selection = checkBoxFive.getText();
                        System.out.println(t1);
                    }


                }
            });


            checkBoxSix.selectedProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observableValue, Object o, Object t1) {

                    if(true){
                        sauce_checkbox_selection= checkBoxSix.getText();
                        System.out.println(t1);
                    }

                }
            });


            checkBoxSeven.selectedProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observableValue, Object o, Object t1) {

                    if(true){
                        sauce_checkbox_selection = checkBoxSeven.getText();
                        System.out.println(t1);
                    }

                }
            });

            lbl_size_of_bread.setFont(Font.font(null, FontWeight.BOLD, 14));
            lbl_type_of_bread.setFont(Font.font(null, FontWeight.BOLD, 14));
            lbl_type_of_sandwich.setFont(Font.font(null, FontWeight.BOLD, 14));
            lbl_vegetables.setFont(Font.font(null, FontWeight.BOLD, 14));
            lbl_extras.setFont(Font.font(null, FontWeight.BOLD, 14));
            lbl_sauces.setFont(Font.font(null, FontWeight.BOLD, 14));


            lbl_size_of_bread.setTextFill(Paint.valueOf("#6a5acd"));
            lbl_type_of_bread.setTextFill(Paint.valueOf("#2e8b57"));
            lbl_type_of_sandwich.setTextFill(Paint.valueOf("#ff00ff"));
            lbl_vegetables.setTextFill(Paint.valueOf("#dc143c"));
            lbl_extras.setTextFill(Paint.valueOf("#ffa500"));
            lbl_sauces.setTextFill(Paint.valueOf("#1e90ff"));





            GridPane gridPane = new GridPane();
            GridPane.setConstraints(lbl_size_of_bread, 1,1);
            GridPane.setConstraints(rbtn_size_of_bread_one, 4,1);
            GridPane.setConstraints(rbtn_size_of_bread_two, 5,1);

            GridPane.setConstraints(lbl_type_of_bread, 1,2);
            GridPane.setConstraints(rbtn_type_of_bread_one, 2,2);
            GridPane.setConstraints(rbtn_type_of_bread_two, 3,2);
            GridPane.setConstraints(rbtn_type_of_bread_three, 4,2);
            GridPane.setConstraints(rbtn_type_of_bread_four, 5,2);


            GridPane.setConstraints(lbl_type_of_sandwich, 1,3);
            GridPane.setConstraints(rbtn_type_of_sandwich_one, 2,3);
            GridPane.setConstraints(rbtn_type_of_sandwich_two, 3,3);
            GridPane.setConstraints(rbtn_type_of_sandwich_three, 4,3);
            GridPane.setConstraints(rbtn_type_of_sandwich_four, 5,3);

            GridPane.setConstraints(rbtn_type_of_sandwich_five, 2,4);
            GridPane.setConstraints(rbtn_type_of_sandwich_six, 3,4);
            GridPane.setConstraints(rbtn_type_of_sandwich_seven, 4,4);
            GridPane.setConstraints(rbtn_type_of_sandwich_eight, 5,4);


            GridPane.setConstraints(lbl_vegetables, 1,4);
            GridPane.setConstraints(comboBox, 2,4);


            GridPane.setConstraints(lbl_extras, 3,4);
            GridPane.setConstraints(checkBoxOne, 3,5);
            GridPane.setConstraints(checkBoxTwo, 4,5);
            GridPane.setConstraints(checkBoxThree, 5,5);


            GridPane.setConstraints(lbl_sauces, 1,6);
            GridPane.setConstraints(checkBoxFour, 2,6);
            GridPane.setConstraints(checkBoxFive, 3,6);
            GridPane.setConstraints(checkBoxSix, 4,6);
            GridPane.setConstraints(checkBoxSeven, 5,6);


            GridPane.setConstraints(btn_make_sandwich, 2,7);
            GridPane.setConstraints(btn_calculate_price, 4,7);



            setMargin(rbtn_size_of_bread_one,new Insets(0,0,20,20));
            setMargin(rbtn_size_of_bread_two,new Insets(0,0,20,20));


            setMargin(rbtn_type_of_bread_one,new Insets(0,0,20,20));
            setMargin(rbtn_type_of_bread_two,new Insets(0,0,20,20));
            setMargin(rbtn_type_of_bread_three,new Insets(0,0,20,20));
            setMargin(rbtn_type_of_bread_four,new Insets(0,0,20,20));


            setMargin(rbtn_type_of_sandwich_one,new Insets(20,0,20,20));
            setMargin(rbtn_type_of_sandwich_two,new Insets(20,0,20,20));
            setMargin(rbtn_type_of_sandwich_three,new Insets(20,0,20,20));
            setMargin(rbtn_type_of_sandwich_four,new Insets(20,0,20,20));
            setMargin(rbtn_type_of_sandwich_five,new Insets(-70,0,20,20));
            setMargin(rbtn_type_of_sandwich_six,new Insets(-70,0,20,20));
            setMargin(rbtn_type_of_sandwich_seven,new Insets(-70,0,20,20));
            setMargin(rbtn_type_of_sandwich_eight,new Insets(-70,0,20,20));


            setMargin(comboBox,new Insets(40,0,20,20));


            setMargin(checkBoxOne,new Insets(-30,0,0,50));
            setMargin(checkBoxTwo,new Insets(-30,0,0,50));
            setMargin(checkBoxThree,new Insets(-30,0,0,50));


            setMargin(checkBoxFour,new Insets(20,0,0,0));
            setMargin(checkBoxFive,new Insets(20,0,0,0));
            setMargin(checkBoxSix,new Insets(20,0,0,0));
            setMargin(checkBoxSeven,new Insets(20,0,0,0));


            setMargin(btn_make_sandwich,new Insets(60,0,0,0));
            setMargin(btn_calculate_price,new Insets(60,0,0,0));


            setMargin(lbl_size_of_bread,new Insets(0,0,20,50));

            setMargin(lbl_type_of_bread,new Insets(0,0,20,50));


            setMargin(lbl_type_of_sandwich,new Insets(0,0,0,50));

            setMargin(lbl_vegetables,new Insets(0,0,0,50));

            setMargin(lbl_extras,new Insets(0,0,0,50));


            setMargin(lbl_sauces,new Insets(0,0,0,50));



            gridPane.getChildren().addAll(lbl_size_of_bread,rbtn_size_of_bread_one,rbtn_size_of_bread_two,lbl_type_of_bread,rbtn_type_of_bread_one,rbtn_type_of_bread_two,rbtn_type_of_bread_three,rbtn_type_of_bread_four,
                    lbl_type_of_sandwich,rbtn_type_of_sandwich_one,rbtn_type_of_sandwich_two,rbtn_type_of_sandwich_three,rbtn_type_of_sandwich_four,rbtn_type_of_sandwich_five,rbtn_type_of_sandwich_six,rbtn_type_of_sandwich_seven,rbtn_type_of_sandwich_eight,lbl_vegetables,comboBox, lbl_extras,
                    checkBoxOne,checkBoxTwo,checkBoxThree,lbl_sauces,checkBoxFour,checkBoxFive,checkBoxSix,checkBoxSeven,btn_make_sandwich,btn_calculate_price);


            btn_calculate_price.setStyle("-fx-background-color: White");
            btn_make_sandwich.setStyle("-fx-background-color: White");

            btn_calculate_price.setFont(Font.font(null, FontWeight.BOLD, 14));
            btn_make_sandwich.setFont(Font.font(null, FontWeight.BOLD, 14));

            btn_calculate_price.setTextFill(Paint.valueOf(menuColor));
            btn_make_sandwich.setTextFill(Paint.valueOf(menuColor));

            btn_make_sandwich.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {


                    //Type of bread
                    if(bread_type.equals(rbtn_type_of_bread_one.getText())){
                        bread = new Wheat(bread_size);
                        System.out.println("Wheat");
                    }else if (bread_type.equals(rbtn_type_of_bread_two.getText())){
                        bread = new Italian(bread_size);
                        System.out.println("Italian");
                    }else if (bread_type.equals(rbtn_type_of_bread_three.getText())){
                        bread = new ParmesanOrgeano(bread_size);
                    }else if (bread_type.equals(rbtn_type_of_bread_four.getText())){
                        bread_type = rbtn_type_of_bread_one.getText();
                        bread = new HoneyOat(bread_size);
                    }



                    //Type of sandwich
                    if(sandwich_type.equals(rbtn_type_of_sandwich_one.getText())){
                        sandwich = new ItalianBMT(bread);
                        System.out.println("\n"+sandwich.getDescription());

                    }else if (sandwich_type.equals(rbtn_type_of_sandwich_two.getText())){
                        sandwich = new MainWayClub(bread);
                    }else if (sandwich_type.equals(rbtn_type_of_sandwich_three.getText())){
                        sandwich = new SteakAndCheese(bread);
                    }else if (sandwich_type.equals(rbtn_type_of_sandwich_four.getText())){
                        sandwich = new ChickenTeriyaki(bread);
                    }else if (sandwich_type.equals(rbtn_type_of_sandwich_five.getText())){
                        sandwich = new MainWayMelt(bread);
                    }else if (sandwich_type.equals(rbtn_type_of_sandwich_six.getText())){
                        sandwich = new Tuna(bread);
                    }else if (sandwich_type.equals(rbtn_type_of_sandwich_seven.getText())){
                        sandwich = new RoastBeef(bread);
                    }else if (sandwich_type.equals(rbtn_type_of_sandwich_eight.getText())){
                        sandwich = new VeggieDelite(bread);
                    }



                    //Vegetable selection
                    if(vegetable_selection!= null && vegetable_selection.equals(vegitableStrings[0])){
                          vegetable = new Cucumbers(sandwich);
                        System.out.println(vegetable.getDescription());
                    }else if (vegetable_selection!= null && vegetable_selection.equals(vegitableStrings[1])){
                          vegetable = new GreenBellPeppers(sandwich);
                    }else if (vegetable_selection!= null && vegetable_selection.equals(vegitableStrings[2])){
                          vegetable = new Lettuce(sandwich);
                    }else if (vegetable_selection!= null && vegetable_selection.equals(vegitableStrings[3])){
                          vegetable = new RedOnions(sandwich);
                    }else if (vegetable_selection!= null && vegetable_selection.equals(vegitableStrings[4])){
                          vegetable = new Tomatoes(sandwich);
                    }else if (vegetable_selection!= null && vegetable_selection.equals(vegitableStrings[5])){
                          vegetable = new Pickles(sandwich);
                    }else if (vegetable_selection!= null && vegetable_selection.equals(vegitableStrings[6])){
                        vegetable = new Cheese(sandwich);
                    }




                    //Extra selection
                    if(extra_checkbox_selection!=null && extra_checkbox_selection.equals(checkBoxOne.getText())){
                          extra = new Jalapenos(sandwich);
                        System.out.println("\n"+extra.getDescription());

                    }else if (extra_checkbox_selection!=null && extra_checkbox_selection.equals(checkBoxTwo.getText())){
                        extra = new Pineapple(sandwich);
                    }else if (extra_checkbox_selection!=null && extra_checkbox_selection.equals(checkBoxThree.getText())){
                        extra = new BlackOlives(sandwich);
                    }




                    //Sauce selection
                    if (sauce_checkbox_selection!=null && sauce_checkbox_selection.equals(checkBoxFour.getText())){
                          sauces = new Mayonnaise(sandwich);
                    }else if (sauce_checkbox_selection!=null && sauce_checkbox_selection.equals(checkBoxFive.getText())){
                          sauces = new HoneyMustard(sandwich);
                    }else if (sauce_checkbox_selection!=null && sauce_checkbox_selection.equals(checkBoxSix.getText())){
                          sauces = new SweetOnion(sandwich);
                    }else if (sauce_checkbox_selection!=null && sauce_checkbox_selection.equals(checkBoxSeven.getText())){
                          sauces = new GarlicSauce(sandwich);
                    }

                    pne_output.txa_output.appendText("\n|  "+sandwich.getDescription()+vegetable.getDescription()+extra.getDescription()+sauces.getDescription());
                }
            });


            btn_make_sandwich.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                    btn_make_sandwich.setStyle("-fx-background-color: White");
                }
            });


            btn_make_sandwich.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    btn_make_sandwich.setStyle("-fx-background-color: LightBlue");

                }
            });



            btn_calculate_price.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                    pne_output.txa_output.appendText( "\n\nTotal \n"+"$"+String.valueOf(extra.cost())+"0"+"\n");
                }
            });


            btn_calculate_price.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                    btn_calculate_price.setStyle("-fx-background-color: White");
                }
            });


            btn_calculate_price.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    btn_calculate_price.setStyle("-fx-background-color: LightBlue");

                }
            });




            //Arranging all nodes
            this.setAlignment(Pos.CENTER);
            this.setStyle("-fx-background-color:"+managementColor);
            this.setMargin(gridPane, new Insets(0,0,0,0));
            this.setMargin(imageView, new Insets(-190,0,0,50));
            this.getChildren().addAll(gridPane,imageView);
            this.setMinSize(90,500);
        }
    }



    private class OutputPane extends HBox {
        TextArea txa_output;

        public OutputPane (){

            txa_output = new TextArea();
            txa_output.setFont(Font.font(null, FontWeight.BOLD, 12));
            txa_output.setPrefHeight(160);
            txa_output.setPrefWidth(855);
            txa_output.setEditable(false);

            //Arranging all nodes
            this.setAlignment(Pos.CENTER);
            this.getChildren().addAll(txa_output);
        }
    }



    private class HelpPane extends VBox{
        Label menu_title;
        TitledPane tp1,tp2,tp3, tp4,tp5;


        public HelpPane (){

            tp1 = new TitledPane();
            tp2 = new TitledPane();
            tp3 = new TitledPane();
            tp4 = new TitledPane();
            tp5 = new TitledPane();


            // Setting all nodes
            tp1.setText("How to create a sandwich?");
            tp2.setText("How to make a sandwich?");
            tp3.setText("How to calculate price?");


            tp1.setContent(new Text("Select the bread size, type, sandwich type, vegetable, extra, and sauces.     "));

            tp2.setContent(new Text("Select the make sandwich button, and a list of your sandwiches will be displayed."));


            tp3.setContent(new Text("Select the calculate price button, and your sandwich price will be displayed.  "));


            tp1.setMinHeight(86);
            tp1.setMaxWidth(500);
            tp1.setMinWidth(500);
            tp2.setMinHeight(86);
            tp2.setMaxWidth(500);
            tp2.setMinWidth(500);
            tp3.setMinHeight(86);
            tp3.setMaxWidth(500);
            tp3.setMinWidth(500);


            menu_title = new Label("Help");

            tp1.setFont(Font.font(null, FontWeight.BOLD, 14));
            tp2.setFont(Font.font(null, FontWeight.BOLD, 14));
            tp3.setFont(Font.font(null, FontWeight.BOLD, 14));
            tp4.setFont(Font.font(null, FontWeight.BOLD, 14));
            tp5.setFont(Font.font(null, FontWeight.BOLD, 14));
            menu_title.setFont(Font.font(null, FontWeight.BOLD, 30));
            menu_title.setTextFill(Paint.valueOf(menuColor));


            //Arranging all nodes
            this.setAlignment(Pos.CENTER);
            this.setStyle("-fx-background-color:"+managementColor);
            this.setMargin(menu_title, new Insets(0,0,30,0));
            this.getChildren().addAll(menu_title,tp1,tp2,tp3);
            this.setMinSize(90,500);
        }
    }


    /**
     *
     * @param args the command line arguments<br>
     * Developed: 15/10/2024<br>
     * Name: Menu Management<br>
     * Developer: Kerry Mannette<br>
     * Version: 1.0<br>
     *
     * <h1>Program Description</h1>
     * <p> Menu Management is a menu application that allows users to manage menus.
     * Adding items to create the desired menu combination while calculating the price.
     * </p>
     *
     *
     *
     */
    public static void main(String[] args) {
        launch();
    }
}