package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lable;

    @FXML
    private Button clearBtn;

    @FXML
    private Button plusMinusBtn;

    @FXML
    private Button parcentBtn;

    @FXML
    private Button divideBtn;

    @FXML
    private Button btn7;

    @FXML
    private Button multiplyBtn;

    @FXML
    private Button btn9;

    @FXML
    private Button btn8;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button minusBtn;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button plusBtn;

    @FXML
    private Button btn0;

    @FXML
    private Button commaBtn;

    @FXML
    private Button equalBtn;

    private String strNum = "";
    private float firstNum = 0;
    private char operation = 'A';
    @FXML
    void initialize() {
        btn0.setOnAction(event -> {
            addNumber(0);
        });
        btn1.setOnAction(event -> {
            addNumber(1);
        });
        btn2.setOnAction(event -> {
            addNumber(2);
        });
        btn3.setOnAction(event -> {
            addNumber(3);
        });
        btn4.setOnAction(event -> {
            addNumber(4);
        });
        btn5.setOnAction(event -> {
            addNumber(5);
        });
        btn6.setOnAction(event -> {
            addNumber(6);
        });
        btn7.setOnAction(event -> {
            addNumber(7);
        });
        btn8.setOnAction(event -> {
            addNumber(8);
        });
        btn9.setOnAction(event -> {
            addNumber(9);
        });
        plusBtn.setOnAction(event -> {
            mathAction('+');
        });
        minusBtn.setOnAction(event -> {
            mathAction('-');
        });
        multiplyBtn.setOnAction(event -> {
            mathAction('*');
        });
        divideBtn.setOnAction(event -> {
            mathAction('/');
        });
        equalBtn.setOnAction(event -> {
            equalMethod();
        });
    }


    private void equalMethod() {
        float res =0;
        switch (this.operation){
            case '+':
                res=this.firstNum+Float.parseFloat(this.strNum);
                break;
            case '-':
                res=this.firstNum-Float.parseFloat(this.strNum);
                break;
            case '*':
                res=this.firstNum*Float.parseFloat(this.strNum);
                break;
            case '/':
                if(Integer.parseInt(this.strNum) == 0){
                    lable.setText("Error");
                    break;
                }
                res=this.firstNum/Float.parseFloat(this.strNum);
                break;
        }
        this.strNum="";
        if (lable.getText()!="Error"){

            lable.setText(Float.toString(res));
        }
        this.firstNum=res;
        this.operation='A';
    }

//    private void mathAction(char operation) {
//       if (this.operation!='+'&&this.operation!='-'&&this.operation!='*'&&this.operation!='/') {
//           this.firstNum = Integer.parseInt(this.strNum);
//           lable.setText(String.valueOf(operation));
//           this.strNum = "";
//           this.operation = operation;
//       }
//    }

    private void mathAction(char operation) {
        if (this.operation == 'A'){
            mathActionNext(operation);
        }else {char tempOperation=operation;
            equalMethod();
            this.operation=tempOperation;
        }
    }


    private void mathActionNext(char operation) {
        if (this.operation =='+'||this.operation =='-'||this.operation =='*'||this.operation =='/') {
            lable.setText(String.valueOf(operation));
            this.operation = operation;
        }else {
            if (this.firstNum == 0) {

                this.firstNum = Float.parseFloat(this.strNum);
                this.strNum="";
                this.operation = operation;
            }
            this.operation = operation;
            lable.setText(String.valueOf(operation));
        }

    }

    private void addNumber (float number){
        if (this.operation=='A'){
            this.firstNum=0;
        }
        this.strNum+=Float.toString(number);
        lable.setText(strNum);
        //lable.setText(Integer.toString(number));

    }
}
