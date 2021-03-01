package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private ListView<String> listView;
    @FXML private TableView<Data> tableView;
    @FXML private DatePicker dateExit;

    private static WebDriver driver = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(FXCollections.observableArrayList(
                "광어 | 제주/양식", "우럭 | 국산/양식", "우럭 | 국산/자연산", "참돔 | 국산/양식", "연어 | 노르웨이/양식", "돌가자미(돌도다리) | 국산/자연산"
                , "블루 킹크랩 | 러시아/자연산", "레드 킹크랩 | 러시아/자연산", "수입 대게 | 러시아/자연산", "활새우(흰다리새우) | 국산/양식"
                , "산낙지 | 국산/자연산", "멍게(우렁쉥이) | 국산/양식", "해삼 | 동해/자연산", "전복 | 국산/양식", "가리비 | 국산/양식", "키조개 | 국산/자연산"));

    }

    public void handleBtnAllAction(ActionEvent e) {
        ObservableList<String> names1 = listView.getSelectionModel().getSelectedItems();
        String equal1 = "";
        String sql = "";
        PreparedStatement pstmt;

        for (String name : names1) {
            equal1 = name;
        }
        switch (equal1){
            case "광어 | 제주/양식":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "SELECT fl_standard, fl_size, fl_kg, fl_won, fl_date FROM flounder";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList flounderList = FXCollections.observableArrayList();
                    System.out.println("광어 | 제주/양식 모든 날짜 시세 검색!");
                    tableView.setItems(flounderList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("fl_standard"));
                        data.setSize(rs.getString("fl_size"));
                        data.setKg(rs.getString("fl_kg"));
                        data.setWon(rs.getString("fl_won"));
                        data.setDate(rs.getString("fl_date"));
                        flounderList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(flounderList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "우럭 | 국산/양식":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "SELECT rf1_standard, rf1_size, rf1_kg, rf1_won, rf1_date FROM rockFish1";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList rockFish1List = FXCollections.observableArrayList();
                    System.out.println("우럭 | 국산/양식 모든 날짜 시세 검색!");
                    tableView.setItems(rockFish1List);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("rf1_standard"));
                        data.setSize(rs.getString("rf1_size"));
                        data.setKg(rs.getString("rf1_kg"));
                        data.setWon(rs.getString("rf1_won"));
                        data.setDate(rs.getString("rf1_date"));
                        rockFish1List.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(rockFish1List);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "우럭 | 국산/자연산":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "SELECT rf2_standard, rf2_size, rf2_kg, rf2_won, rf2_date FROM rockFish2";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList rockFish2rList = FXCollections.observableArrayList();
                    System.out.println("우럭 | 국산/양식 모든 날짜 시세 검색!");
                    tableView.setItems(rockFish2rList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("rf2_standard"));
                        data.setSize(rs.getString("rf2_size"));
                        data.setKg(rs.getString("rf2_kg"));
                        data.setWon(rs.getString("rf2_won"));
                        data.setDate(rs.getString("rf2_date"));
                        rockFish2rList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(rockFish2rList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "참돔 | 국산/양식":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "SELECT rs_standard, rs_size, rs_kg, rs_won, rs_date FROM redSnapper";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList redSnapperList = FXCollections.observableArrayList();
                    System.out.println("참돔 | 국산/양식 모든 날짜 시세 검색!");
                    tableView.setItems(redSnapperList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("rs_standard"));
                        data.setSize(rs.getString("rs_size"));
                        data.setKg(rs.getString("rs_kg"));
                        data.setWon(rs.getString("rs_won"));
                        data.setDate(rs.getString("rs_date"));
                        redSnapperList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(redSnapperList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "연어 | 노르웨이/양식":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "SELECT salmon_standard, salmon_size, salmon_kg, salmon_won, salmon_date FROM salmon";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList salmonList = FXCollections.observableArrayList();
                    System.out.println("연어 | 노르웨이/양식 모든 날짜 시세 검색!");
                    tableView.setItems(salmonList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("salmon_standard"));
                        data.setSize(rs.getString("salmon_size"));
                        data.setKg(rs.getString("salmon_kg"));
                        data.setWon(rs.getString("salmon_won"));
                        data.setDate(rs.getString("salmon_date"));
                        salmonList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(salmonList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "돌가자미(돌도다리) | 국산/자연산":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "SELECT sf_standard, sf_size, sf_kg, sf_won, sf_date FROM stoneFlounder";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList stoneFlounderList = FXCollections.observableArrayList();
                    System.out.println("돌가자미(돌도다리) | 국산/자연산 모든 날짜 시세 검색!");
                    tableView.setItems(stoneFlounderList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("sf_standard"));
                        data.setSize(rs.getString("sf_size"));
                        data.setKg(rs.getString("sf_kg"));
                        data.setWon(rs.getString("sf_won"));
                        data.setDate(rs.getString("sf_date"));
                        stoneFlounderList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(stoneFlounderList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "블루 킹크랩 | 러시아/자연산":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "SELECT bc_standard, bc_size, bc_kg, bc_won, bc_date FROM blueCrab";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList blueCrabList = FXCollections.observableArrayList();
                    System.out.println("블루 킹크랩 | 러시아/자연산 모든 날짜 시세 검색!");
                    tableView.setItems(blueCrabList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("bc_standard"));
                        data.setSize(rs.getString("bc_size"));
                        data.setKg(rs.getString("bc_kg"));
                        data.setWon(rs.getString("bc_won"));
                        data.setDate(rs.getString("bc_date"));
                        blueCrabList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(blueCrabList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "레드 킹크랩 | 러시아/자연산":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "SELECT rc_standard, rc_size, rc_kg, rc_won, rc_date FROM redCrab";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList redCrabList = FXCollections.observableArrayList();
                    System.out.println("레드 킹크랩 | 러시아/자연산 모든 날짜 시세 검색!");
                    tableView.setItems(redCrabList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("rc_standard"));
                        data.setSize(rs.getString("rc_size"));
                        data.setKg(rs.getString("rc_kg"));
                        data.setWon(rs.getString("rc_won"));
                        data.setDate(rs.getString("rc_date"));
                        redCrabList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(redCrabList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "수입 대게 | 러시아/자연산":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "SELECT sc_standard, sc_size, sc_kg, sc_won, sc_date FROM snowCrab";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList snowCrabList = FXCollections.observableArrayList();
                    System.out.println("수입 대게 | 러시아/자연산 모든 날짜 시세 검색!");
                    tableView.setItems(snowCrabList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("sc_standard"));
                        data.setSize(rs.getString("sc_size"));
                        data.setKg(rs.getString("sc_kg"));
                        data.setWon(rs.getString("sc_won"));
                        data.setDate(rs.getString("sc_date"));
                        snowCrabList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(snowCrabList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "활새우(흰다리새우) | 국산/양식":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "SELECT shrimp_standard, shrimp_size, shrimp_kg, shrimp_won, shrimp_date FROM shrimp";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList shrimpList = FXCollections.observableArrayList();
                    System.out.println("활새우(흰다리새우) | 국산/양식 모든 날짜 시세 검색!");
                    tableView.setItems(shrimpList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("shrimp_standard"));
                        data.setSize(rs.getString("shrimp_size"));
                        data.setKg(rs.getString("shrimp_kg"));
                        data.setWon(rs.getString("shrimp_won"));
                        data.setDate(rs.getString("shrimp_date"));
                        shrimpList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(shrimpList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "산낙지 | 국산/자연산":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "SELECT lo_standard, lo_size, lo_kg, lo_won, lo_date FROM liveOctopus";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList liveOctopusList = FXCollections.observableArrayList();
                    System.out.println("산낙지 | 국산/자연산 모든 날짜 시세 검색!");
                    tableView.setItems(liveOctopusList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("lo_standard"));
                        data.setSize(rs.getString("lo_size"));
                        data.setKg(rs.getString("lo_kg"));
                        data.setWon(rs.getString("lo_won"));
                        data.setDate(rs.getString("lo_date"));
                        liveOctopusList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(liveOctopusList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "멍게(우렁쉥이) | 국산/양식":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "SELECT ss_standard, ss_size, ss_kg, ss_won, ss_date FROM seaSquirt";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList seaSquirtList = FXCollections.observableArrayList();
                    System.out.println("멍게(우렁쉥이) | 국산/양식 모든 날짜 시세 검색!");
                    tableView.setItems(seaSquirtList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("ss_standard"));
                        data.setSize(rs.getString("ss_size"));
                        data.setKg(rs.getString("ss_kg"));
                        data.setWon(rs.getString("ss_won"));
                        data.setDate(rs.getString("ss_date"));
                        seaSquirtList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(seaSquirtList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "해삼 | 동해/자연산":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "SELECT scc_standard, scc_size, scc_kg, scc_won, scc_date FROM seaCucumber";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList seaCucumberList = FXCollections.observableArrayList();
                    System.out.println("해삼 | 동해/자연산 모든 날짜 시세 검색!");
                    tableView.setItems(seaCucumberList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("scc_standard"));
                        data.setSize(rs.getString("scc_size"));
                        data.setKg(rs.getString("scc_kg"));
                        data.setWon(rs.getString("scc_won"));
                        data.setDate(rs.getString("scc_date"));
                        seaCucumberList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(seaCucumberList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "전복 | 국산/양식":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "SELECT ab_standard, ab_size, ab_kg, ab_won, ab_date FROM abalone";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList abaloneList = FXCollections.observableArrayList();
                    System.out.println("전복 | 국산/양식 모든 날짜 시세 검색!");
                    tableView.setItems(abaloneList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("ab_standard"));
                        data.setSize(rs.getString("ab_size"));
                        data.setKg(rs.getString("ab_kg"));
                        data.setWon(rs.getString("ab_won"));
                        data.setDate(rs.getString("ab_date"));
                        abaloneList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(abaloneList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "가리비 | 국산/양식":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "SELECT sca_standard, sca_size, sca_kg, sca_won, sca_date FROM scallop";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList scallopList = FXCollections.observableArrayList();
                    System.out.println("가리비 | 국산/양식 모든 날짜 시세 검색!");
                    tableView.setItems(scallopList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("sca_standard"));
                        data.setSize(rs.getString("sca_size"));
                        data.setKg(rs.getString("sca_kg"));
                        data.setWon(rs.getString("sca_won"));
                        data.setDate(rs.getString("sca_date"));
                        scallopList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(scallopList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "키조개 | 국산/자연산":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "SELECT clam_standard, clam_size, clam_kg, clam_won, clam_date FROM clam";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList clamList = FXCollections.observableArrayList();
                    System.out.println("키조개 | 국산/자연산 모든 날짜 시세 검색!");
                    tableView.setItems(clamList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("clam_standard"));
                        data.setSize(rs.getString("clam_size"));
                        data.setKg(rs.getString("clam_kg"));
                        data.setWon(rs.getString("clam_won"));
                        data.setDate(rs.getString("clam_date"));
                        clamList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(clamList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
        }
    }
    public void handleBtnDateAction (ActionEvent e){
        ObservableList<String> names1 = listView.getSelectionModel().getSelectedItems();
        String equal1 = "";
        String sql;
        String date = "";
        PreparedStatement pstmt;
        LocalDate localDate = dateExit.getValue();
        if(localDate != null){
            date = localDate.toString();
        }

        for (String name : names1) {
            equal1 = name;
        }
        switch (equal1){
            case "광어 | 제주/양식":
                TableColumn reset1 = tableView.getColumns().get(0);
                reset1.setCellValueFactory(new PropertyValueFactory(" "));
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "select * from flounder where LEFT(fl_date, 10) = '" + date + "'";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList flounderList = FXCollections.observableArrayList();
                    System.out.println("광어 | 제주/양식 " + date + " 시세 검색!");
                    tableView.setItems(flounderList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("fl_standard"));
                        data.setSize(rs.getString("fl_size"));
                        data.setKg(rs.getString("fl_kg"));
                        data.setWon(rs.getString("fl_won"));
                        data.setDate(rs.getString("fl_date"));
                        flounderList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(flounderList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "우럭 | 국산/양식":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "select * from rockFish1 where LEFT(rf1_date, 10) = '" + date + "'";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList rockFish1List = FXCollections.observableArrayList();
                    System.out.println("우럭 | 국산/양식 " + date + " 시세 검색!");
                    tableView.setItems(rockFish1List);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("rf1_standard"));
                        data.setSize(rs.getString("rf1_size"));
                        data.setKg(rs.getString("rf1_kg"));
                        data.setWon(rs.getString("rf1_won"));
                        data.setDate(rs.getString("rf1_date"));
                        rockFish1List.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(rockFish1List);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "우럭 | 국산/자연산":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "select * from rockFish2 where LEFT(rf2_date, 10) = '" + date + "'";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList rockFish2rList = FXCollections.observableArrayList();
                    System.out.println("우럭 | 국산/자연산 " + date + " 시세 검색!");
                    tableView.setItems(rockFish2rList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("rf2_standard"));
                        data.setSize(rs.getString("rf2_size"));
                        data.setKg(rs.getString("rf2_kg"));
                        data.setWon(rs.getString("rf2_won"));
                        data.setDate(rs.getString("rf2_date"));
                        rockFish2rList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(rockFish2rList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "참돔 | 국산/양식":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "select * from redSnapper where LEFT(rs_date, 10) = '" + date + "'";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList redSnapperList = FXCollections.observableArrayList();
                    System.out.println("참돔 | 국산/양식 " + date + " 시세 검색!");
                    tableView.setItems(redSnapperList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("rs_standard"));
                        data.setSize(rs.getString("rs_size"));
                        data.setKg(rs.getString("rs_kg"));
                        data.setWon(rs.getString("rs_won"));
                        data.setDate(rs.getString("rs_date"));
                        redSnapperList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(redSnapperList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "연어 | 노르웨이/양식":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "select * from salmon where LEFT(salmon_date, 10) = '" + date + "'";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList salmonList = FXCollections.observableArrayList();
                    System.out.println("연어 | 노르웨이/양식 " + date + " 시세 검색!");
                    tableView.setItems(salmonList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("salmon_standard"));
                        data.setSize(rs.getString("salmon_size"));
                        data.setKg(rs.getString("salmon_kg"));
                        data.setWon(rs.getString("salmon_won"));
                        data.setDate(rs.getString("salmon_date"));
                        salmonList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(salmonList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "돌가자미(돌도다리) | 국산/자연산":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "select * from stoneFlounder where LEFT(sf_date, 10) = '" + date + "'";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList stoneFlounderList = FXCollections.observableArrayList();
                    System.out.println("돌가자미(돌도다리) | 국산/자연산 " + date + " 시세 검색!");
                    tableView.setItems(stoneFlounderList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("sf_standard"));
                        data.setSize(rs.getString("sf_size"));
                        data.setKg(rs.getString("sf_kg"));
                        data.setWon(rs.getString("sf_won"));
                        data.setDate(rs.getString("sf_date"));
                        stoneFlounderList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(stoneFlounderList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "블루 킹크랩 | 러시아/자연산":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "select * from blueCrab where LEFT(bc_date, 10) = '" + date + "'";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList blueCrabList = FXCollections.observableArrayList();
                    System.out.println("블루 킹크랩 | 러시아/자연산 " + date + " 시세 검색!");
                    tableView.setItems(blueCrabList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("bc_standard"));
                        data.setSize(rs.getString("bc_size"));
                        data.setKg(rs.getString("bc_kg"));
                        data.setWon(rs.getString("bc_won"));
                        data.setDate(rs.getString("bc_date"));
                        blueCrabList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(blueCrabList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "레드 킹크랩 | 러시아/자연산":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "select * from redCrab where LEFT(rc_date, 10) = '" + date + "'";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList redCrabList = FXCollections.observableArrayList();
                    System.out.println("레드 킹크랩 | 러시아/자연산 " + date + " 시세 검색!");
                    tableView.setItems(redCrabList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("rc_standard"));
                        data.setSize(rs.getString("rc_size"));
                        data.setKg(rs.getString("rc_kg"));
                        data.setWon(rs.getString("rc_won"));
                        data.setDate(rs.getString("rc_date"));
                        redCrabList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(redCrabList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "수입 대게 | 러시아/자연산":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "select * from snowCrab where LEFT(sc_date, 10) = '" + date + "'";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList snowCrabList = FXCollections.observableArrayList();
                    System.out.println("수입 대게 | 러시아/자연산 " + date + " 시세 검색!");
                    tableView.setItems(snowCrabList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("sc_standard"));
                        data.setSize(rs.getString("sc_size"));
                        data.setKg(rs.getString("sc_kg"));
                        data.setWon(rs.getString("sc_won"));
                        data.setDate(rs.getString("sc_date"));
                        snowCrabList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(snowCrabList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "활새우(흰다리새우) | 국산/양식":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "select * from shrimp where LEFT(shrimp_date, 10) = '" + date + "'";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList shrimpList = FXCollections.observableArrayList();
                    System.out.println("활새우(흰다리새우) | 국산/양식 " + date + " 시세 검색!");
                    tableView.setItems(shrimpList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("shrimp_standard"));
                        data.setSize(rs.getString("shrimp_size"));
                        data.setKg(rs.getString("shrimp_kg"));
                        data.setWon(rs.getString("shrimp_won"));
                        data.setDate(rs.getString("shrimp_date"));
                        shrimpList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(shrimpList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "산낙지 | 국산/자연산":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "select * from liveOctopus where LEFT(lo_date, 10) = '" + date + "'";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList liveOctopusList = FXCollections.observableArrayList();
                    System.out.println("산낙지 | 국산/자연산 " + date + " 시세 검색!");
                    tableView.setItems(liveOctopusList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("lo_standard"));
                        data.setSize(rs.getString("lo_size"));
                        data.setKg(rs.getString("lo_kg"));
                        data.setWon(rs.getString("lo_won"));
                        data.setDate(rs.getString("lo_date"));
                        liveOctopusList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(liveOctopusList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "멍게(우렁쉥이) | 국산/양식":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "select * from seaSquirt where LEFT(ss_date, 10) = '" + date + "'";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList seaSquirtList = FXCollections.observableArrayList();
                    System.out.println("멍게(우렁쉥이) | 국산/양식 " + date + " 시세 검색!");
                    tableView.setItems(seaSquirtList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("ss_standard"));
                        data.setSize(rs.getString("ss_size"));
                        data.setKg(rs.getString("ss_kg"));
                        data.setWon(rs.getString("ss_won"));
                        data.setDate(rs.getString("ss_date"));
                        seaSquirtList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(seaSquirtList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "해삼 | 동해/자연산":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "select * from seaCucumber where LEFT(scc_date, 10) = '" + date + "'";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList seaCucumberList = FXCollections.observableArrayList();
                    System.out.println("해삼 | 동해/자연산 " + date + " 시세 검색!");
                    tableView.setItems(seaCucumberList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("scc_standard"));
                        data.setSize(rs.getString("scc_size"));
                        data.setKg(rs.getString("scc_kg"));
                        data.setWon(rs.getString("scc_won"));
                        data.setDate(rs.getString("scc_date"));
                        seaCucumberList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(seaCucumberList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "전복 | 국산/양식":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "select * from abalone where LEFT(ab_date, 10) = '" + date + "'";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList abaloneList = FXCollections.observableArrayList();
                    System.out.println("전복 | 국산/양식 " + date + " 시세 검색!");
                    tableView.setItems(abaloneList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("ab_standard"));
                        data.setSize(rs.getString("ab_size"));
                        data.setKg(rs.getString("ab_kg"));
                        data.setWon(rs.getString("ab_won"));
                        data.setDate(rs.getString("ab_date"));
                        abaloneList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(abaloneList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "가리비 | 국산/양식":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "select * from scallop where LEFT(sca_date, 10) = '" + date + "'";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList scallopList = FXCollections.observableArrayList();
                    System.out.println("가리비 | 국산/양식 " + date + " 시세 검색!");
                    tableView.setItems(scallopList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("sca_standard"));
                        data.setSize(rs.getString("sca_size"));
                        data.setKg(rs.getString("sca_kg"));
                        data.setWon(rs.getString("sca_won"));
                        data.setDate(rs.getString("sca_date"));
                        scallopList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(scallopList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
            case "키조개 | 국산/자연산":
                try {
                    Connection conn = Dbconn.getConnection();
                    sql = "select * from clam where LEFT(clam_date, 10) = '" + date + "'";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    ObservableList clamList = FXCollections.observableArrayList();
                    System.out.println("키조개 | 국산/자연산 " + date + " 시세 검색!");
                    tableView.setItems(clamList);
                    while (rs.next()) {
                        Data data = new Data();
                        data.setStandard(rs.getString("clam_standard"));
                        data.setSize(rs.getString("clam_size"));
                        data.setKg(rs.getString("clam_kg"));
                        data.setWon(rs.getString("clam_won"));
                        data.setDate(rs.getString("clam_date"));
                        clamList.add(data);
                        TableColumn tcDate = tableView.getColumns().get(0);
                        tcDate.setCellValueFactory(new PropertyValueFactory("date"));
                        tcDate.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcSize = tableView.getColumns().get(1);
                        tcSize.setCellValueFactory(new PropertyValueFactory("size"));
                        tcSize.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcKg = tableView.getColumns().get(2);
                        tcKg.setCellValueFactory(new PropertyValueFactory("kg"));
                        tcKg.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcStandard = tableView.getColumns().get(3);
                        tcStandard.setCellValueFactory(new PropertyValueFactory("standard"));
                        tcStandard.setStyle("-fx-alignment: CENTER;");
                        TableColumn tcWon = tableView.getColumns().get(4);
                        tcWon.setCellValueFactory(new PropertyValueFactory("won"));
                        tcWon.setStyle("-fx-alignment: CENTER;");
                        tableView.setItems(clamList);
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                break;
        }
    }
    public void handleBtnUpdateAction(ActionEvent e){
        String DRIVER_ID = "webdriver.chrome.driver";
        String DRIVER_PATH = "C:/asj/정규과정/java2/chromedriver.exe";

        System.setProperty(DRIVER_ID, DRIVER_PATH);
        String base_url = "https://www.tpirates.com/%EC%8B%9C%EC%84%B8";

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);

        try {
            driver = new ChromeDriver(options);
            driver.get(base_url);
            System.out.println("DB 업데이트 시작!");

            String s;

            // 광어 제주|양식 1kg 당
            // 특특대 있으면 i <= 10 , i < 5 로 변경
            // 특특대 없으면 i <= 9 , i < 4 로 변경
            String[] flounder_size = new String[5];
            String[] flounder_kg = new String[5];
            String[] flounder_won = new String[5];
            for(int i = 6; i <= 10; i++){
                List<WebElement> fl = driver.findElements(By.id("market-000000873" + i));
                if(i == 10){
                    fl = driver.findElements(By.id("market-0000017966"));
                }
                s = "";
                for(WebElement el : fl){
                    s += el.getText();
                }
                flounder_size[i - 6] = s.split("\n")[0];
                flounder_kg[i - 6] = s.split("\n")[1];
                flounder_won[i - 6] = s.split("\n")[2];
                flounder_won[i - 6] = flounder_won[i - 6].substring(0, flounder_won[i - 6].length() - 2);
            }

            String sql = "INSERT INTO flounder (fl_standard, fl_size, fl_kg, fl_won) " + "VALUES(?, ?, ?, ?)";
            Connection conn = Dbconn.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < 5; i++){
                pstmt.setString(1, "광어 1kg 당");
                pstmt.setString(2, flounder_size[i]);
                pstmt.setString(3, flounder_kg[i]);
                pstmt.setString(4, flounder_won[i]);
                int result = pstmt.executeUpdate();
                if(result >= 1){
                    System.out.println("광어 제주|양식 1kg 당 DB 등록 성공!");
                }else{
                    System.out.println("광어 제주|양식 1kg 당 DB 등록 실패.");
                }
            }
            System.out.println();
            // --------------------------------------------------------------------------------------
            // 우럭 국산|양식 1kg 당
            String[] rockFish_size1 = new String[3];
            String[] rockFish_kg1 = new String[3];
            String[] rockFish_won1 = new String[3];
            for(int i = 79; i <= 81; i++){
                List<WebElement> rf1 = driver.findElements(By.id("market-00000057" + i));
                if(i == 81){
                    rf1 = driver.findElements(By.id("market-0000008638"));
                }
                s = "";
                for(WebElement el : rf1){
                    s += el.getText();
                }
                rockFish_size1[i - 79] = s.split("\n")[0];
                rockFish_kg1[i - 79] = s.split("\n")[1];
                rockFish_won1[i - 79] = s.split("\n")[2];
                rockFish_won1[i - 79] = rockFish_won1[i - 79].substring(0, rockFish_won1[i - 79].length() - 2);
            }
            sql = "INSERT INTO rockFish1 (rf1_standard, rf1_size, rf1_kg, rf1_won) " + "VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < 3; i++){
                pstmt.setString(1, "우럭 1kg 당");
                pstmt.setString(2, rockFish_size1[i]);
                pstmt.setString(3, rockFish_kg1[i]);
                pstmt.setString(4, rockFish_won1[i]);
                int result = pstmt.executeUpdate();
                if(result >= 1){
                    System.out.println("우럭 국산|양식 1kg 당 DB 등록 성공!");
                }else{
                    System.out.println("우럭 국산|양식 1kg 당 DB 등록 실패.");
                }
            }
            System.out.println();
            // --------------------------------------------------------------------------------------
            // 우럭 국산|자연산 1kg 당
            String[] rockFish_size2 = new String[3];
            String[] rockFish_kg2 = new String[3];
            String[] rockFish_won2 = new String[3];
            for(int i = 5; i <= 7; i++){
                List<WebElement> rf2 = driver.findElements(By.id("market-000002531" + i));
                s = "";
                for(WebElement el : rf2){
                    s += el.getText();
                }
                rockFish_size2[i - 5] = s.split("\n")[0];
                rockFish_kg2[i - 5] = s.split("\n")[1];
                rockFish_won2[i - 5] = s.split("\n")[2];
                rockFish_won2[i - 5] = rockFish_won2[i - 5].substring(0, rockFish_won2[i - 5].length() - 2);
            }
            sql = "INSERT INTO rockFish2 (rf2_standard, rf2_size, rf2_kg, rf2_won) " + "VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < 3; i++){
                pstmt.setString(1, "우럭 1kg 당");
                pstmt.setString(2, rockFish_size2[i]);
                pstmt.setString(3, rockFish_kg2[i]);
                pstmt.setString(4, rockFish_won2[i]);
                int result = pstmt.executeUpdate();
                if(result >= 1){
                    System.out.println("우럭 국산|자연산 1kg 당 DB 등록 성공!");
                }else{
                    System.out.println("우럭 국산|자연산 1kg 당 DB 등록 실패.");
                }
            }
            System.out.println();
            // --------------------------------------------------------------------------------------
            // 참돔 국산|양식 1kg 당
            String[] redSnapper_size = new String[4];
            String[] redSnapper_kg = new String[4];
            String[] redSnapper_won = new String[4];
            for(int i = 7; i <= 10; i++){
                List<WebElement> rs;
                if(i == 10){
                    rs = driver.findElements(By.id("market-00000098" + i));
                } else{
                    rs = driver.findElements(By.id("market-000000980" + i));
                }
                s = "";
                for(WebElement el : rs){
                    s += el.getText();
                }
                redSnapper_size[i - 7] = s.split("\n")[0];
                redSnapper_kg[i - 7] = s.split("\n")[1];
                redSnapper_won[i - 7] = s.split("\n")[2];
                redSnapper_won[i - 7] = redSnapper_won[i - 7].substring(0, redSnapper_won[i - 7].length() - 2);
            }
            sql = "INSERT INTO redSnapper (rs_standard, rs_size, rs_kg, rs_won) " + "VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < 4; i++){
                pstmt.setString(1, "참돔 1kg 당");
                pstmt.setString(2, redSnapper_size[i]);
                pstmt.setString(3, redSnapper_kg[i]);
                pstmt.setString(4, redSnapper_won[i]);
                int result = pstmt.executeUpdate();
                if(result >= 1){
                    System.out.println("참돔 국산|양식 1kg 당 DB 등록 성공!");
                }else{
                    System.out.println("참돔 국산|양식 1kg 당 DB 등록 실패.");
                }
            }
            System.out.println();
            // --------------------------------------------------------------------------------------
            // 연어 노르웨이|양식 600g(순살) 당
            List<WebElement> sm = driver.findElements(By.id("market-0000006901"));

            s = "";
            for(WebElement el : sm){
                s += el.getText();
            }
            String salmon_won = s;
            salmon_won = salmon_won.substring(0, salmon_won.length() - 2);
            sql = "INSERT INTO salmon (salmon_standard, salmon_size, salmon_kg, salmon_won) " + "VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "연어 600g(순살) 당");
            pstmt.setString(2, "-");
            pstmt.setString(3, "-");
            pstmt.setString(4, salmon_won);
            int result = pstmt.executeUpdate();
            if(result >= 1){
                System.out.println("연어 노르웨이|양식 600g(순살) 당 DB 등록 성공!");
            }else{
                System.out.println("연어 노르웨이|양식 600g(순살) 당 DB 등록 실패.");
            }
            System.out.println();
            // --------------------------------------------------------------------------------------
            // 돌가자미 (돌도다리) 국산|자연산 1kg 당
            String[] stoneFlounder_size = new String[4];
            String[] stoneFlounder_kg = new String[4];
            String[] stoneFlounder_won = new String[4];
            for(int i = 3; i <= 6; i++){
                List<WebElement> sf = driver.findElements(By.id("market-000002588" + i));
                s = "";
                for(WebElement el : sf){
                    s += el.getText();
                }
                stoneFlounder_size[i - 3] = s.split("\n")[0];
                stoneFlounder_kg[i - 3] = s.split("\n")[1];
                stoneFlounder_won[i - 3] = s.split("\n")[2];
                stoneFlounder_won[i - 3] = stoneFlounder_won[i - 3].substring(0, stoneFlounder_won[i - 3].length() - 2);
            }
            sql = "INSERT INTO stoneFlounder (sf_standard, sf_size, sf_kg, sf_won) " + "VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < 4; i++){
                pstmt.setString(1, "돌가자미 1kg 당");
                pstmt.setString(2, stoneFlounder_size[i]);
                pstmt.setString(3, stoneFlounder_kg[i]);
                pstmt.setString(4, stoneFlounder_won[i]);
                result = pstmt.executeUpdate();
                if(result >= 1){
                    System.out.println("돌가자미 (돌도다리) 국산|자연산 1kg 당 DB 등록 성공!");
                }else{
                    System.out.println("돌가자미 (돌도다리) 국산|자연산 1kg 당 DB 등록 실패.");
                }
            }
            System.out.println();
            // --------------------------------------------------------------------------------------
            // 블루 킹크랩 러시아|자연산 1kg 당
            String[] blueCrab_size = new String[3];
            String[] blueCrab_kg = new String[3];
            String[] blueCrab_won = new String[3];

            for(int i = 6; i <= 8; i++){
                List<WebElement> bc = driver.findElements(By.id("market-000002237" + i));
                s = "";
                for(WebElement el : bc){
                    s += el.getText();
                }
                blueCrab_size[i - 6] = s.split("\n")[0];
                blueCrab_kg[i - 6] = s.split("\n")[1];
                blueCrab_won[i - 6] = s.split("\n")[2];
                blueCrab_won[i - 6] = blueCrab_won[i - 6].substring(0, blueCrab_won[i - 6].length() - 2);
            }
            sql = "INSERT INTO blueCrab (bc_standard, bc_size, bc_kg, bc_won) " + "VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < 3; i++){
                pstmt.setString(1, "블루 킹크랩 1kg 당");
                pstmt.setString(2, blueCrab_size[i]);
                pstmt.setString(3, blueCrab_kg[i]);
                pstmt.setString(4, blueCrab_won[i]);
                result = pstmt.executeUpdate();
                if(result >= 1){
                    System.out.println("블루 킹크랩 러시아|자연산 1kg 당 DB 등록 성공!");
                }else{
                    System.out.println("블루 킹크랩 러시아|자연산 1kg 당 DB 등록 실패.");
                }
            }
            System.out.println();
            // --------------------------------------------------------------------------------------
            // 레드 킹크랩 러시아|자연산 1kg 당
            String[] redCrab_size = new String[2];
            String[] redCrab_kg = new String[2];
            String[] redCrab_won = new String[2];

            int j = 0;
            for(int i = 4; i <= 6; i+=2){
                List<WebElement> rc = driver.findElements(By.id("market-000002230" + i));
                s = "";
                for(WebElement el : rc){
                    s += el.getText();
                }
                redCrab_size[j] = s.split("\n")[0];
                redCrab_kg[j] = s.split("\n")[1];
                redCrab_won[j] = s.split("\n")[2];
                redCrab_won[j] = redCrab_won[j].substring(0, redCrab_won[j].length() - 2);
                j++;
            }
            sql = "INSERT INTO redCrab (rc_standard, rc_size, rc_kg, rc_won) " + "VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < 2; i++){
                pstmt.setString(1, "레드 킹크랩 1kg 당");
                pstmt.setString(2, redCrab_size[i]);
                pstmt.setString(3, redCrab_kg[i]);
                pstmt.setString(4, redCrab_won[i]);
                result = pstmt.executeUpdate();
                if(result >= 1){
                    System.out.println("레드 킹크랩 러시아|자연산 1kg 당 DB 등록 성공!");
                }else{
                    System.out.println("레드 킹크랩 러시아|자연산 1kg 당 DB 등록 실패.");
                }
            }
            System.out.println();
            // --------------------------------------------------------------------------------------
            // 수입 대게 러시아|자연산 1kg 당
            String[] snowCrab_size = new String[4];
            String[] snowCrab_kg = new String[4];
            String[] snowCrab_won = new String[4];

            for(int i = 8; i <= 11; i++){
                List<WebElement> sc = driver.findElements(By.id("market-000002244" + i));
                if(i == 10){
                    sc = driver.findElements(By.id("market-0000022450"));
                }else if(i == 11){
                    sc = driver.findElements(By.id("market-0000022451"));
                }
                s = "";

                for(WebElement el : sc){
                    s += el.getText();
                }
                snowCrab_size[i - 8] = s.split("\n")[0];
                snowCrab_kg[i - 8] = s.split("\n")[1];
                snowCrab_won[i - 8] = s.split("\n")[2];
                snowCrab_won[i - 8] = snowCrab_won[i - 8].substring(0, snowCrab_won[i - 8].length() - 2);
            }
            sql = "INSERT INTO snowCrab (sc_standard, sc_size, sc_kg, sc_won) " + "VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < 4; i++){
                pstmt.setString(1, "수입 대게 1kg 당");
                pstmt.setString(2, snowCrab_size[i]);
                pstmt.setString(3, snowCrab_kg[i]);
                pstmt.setString(4, snowCrab_won[i]);
                result = pstmt.executeUpdate();
                if(result >= 1){
                    System.out.println("수입 대게 러시아|자연산 1kg 당 DB 등록 성공!");
                }else{
                    System.out.println("수입 대게 러시아|자연산 1kg 당 DB 등록 실패.");
                }
            }
            System.out.println();
            // --------------------------------------------------------------------------------------
            // 활새우 (흰다리새우) 국산|양식 1kg 당
            String[] shrimp_size = new String[3];
            String[] shrimp_won = new String[3];

            for(int i = 2; i <= 4; i++){
                List<WebElement> sr = driver.findElements(By.id("market-000002636" + i));
                if(2 < i){
                    sr = driver.findElements(By.id("market-000002636" + (i + 1)));
                }
                s = "";

                for(WebElement el : sr){
                    s += el.getText();
                }
                shrimp_size[i - 2] = s.split("\n")[0];
                shrimp_won[i - 2] = s.split("\n")[1];
                shrimp_won[i - 2] = shrimp_won[i - 2].substring(0, shrimp_won[i - 2].length() - 2);
            }
            sql = "INSERT INTO shrimp (shrimp_standard, shrimp_size, shrimp_kg, shrimp_won) " + "VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < 3; i++){
                pstmt.setString(1, "활새우 1kg 당");
                pstmt.setString(2, shrimp_size[i]);
                pstmt.setString(3, "-");
                pstmt.setString(4, shrimp_won[i]);
                result = pstmt.executeUpdate();
                if(result >= 1){
                    System.out.println("활새우 (흰다리새우) 국산|양식 1kg 당 DB 등록 성공!");
                }else{
                    System.out.println("활새우 (흰다리새우) 국산|양식 1kg 당 DB 등록 실패.");
                }
            }
            System.out.println();
            // --------------------------------------------------------------------------------------
            // 산낙지 국산|자연산 마리 당
            String[] liveOctopus_size = new String[3];
            String[] liveOctopus_won = new String[3];

            for(int i = 1; i <= 3; i++){
                List<WebElement> lo = driver.findElements(By.id("market-000000033" + i));
                if(1 < i){
                    lo = driver.findElements(By.id("market-000000033" + (i + 2)));
                }
                s = "";
                for(WebElement el : lo){
                    s += el.getText();
                }
                liveOctopus_size[i - 1] = s.split("\n")[0];
                liveOctopus_won[i - 1] = s.split("\n")[1];
                liveOctopus_won[i - 1] = liveOctopus_won[i - 1].substring(0, liveOctopus_won[i - 1].length() - 2);
            }
            sql = "INSERT INTO liveOctopus (lo_standard, lo_size, lo_kg, lo_won) " + "VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < 3; i++){
                pstmt.setString(1, "산낙지 마리 당");
                pstmt.setString(2, liveOctopus_size[i]);
                pstmt.setString(3, "-");
                pstmt.setString(4, liveOctopus_won[i]);
                result = pstmt.executeUpdate();
                if(result >= 1){
                    System.out.println("산낙지 국산|자연산 마리 당 DB 등록 성공!");
                }else{
                    System.out.println("산낙지 국산|자연산 마리 당 DB 등록 실패.");
                }
            }
            System.out.println();
            // --------------------------------------------------------------------------------------
            // 멍게 (우렁쉥이) 국산|양식 1kg 당
            List<WebElement> sq = driver.findElements(By.id("market-0000000311"));
            s = "";
            for(WebElement el : sq){
                s += el.getText();
            }
            String seaSquirt_won = s;
            seaSquirt_won = seaSquirt_won.substring(0, seaSquirt_won.length() - 2);

            sql = "INSERT INTO seaSquirt (ss_standard, ss_size, ss_kg, ss_won) " + "VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "멍게 1kg 당");
            pstmt.setString(2, "-");
            pstmt.setString(3, "-");
            pstmt.setString(4, seaSquirt_won);
            result = pstmt.executeUpdate();
            if(result >= 1){
                System.out.println("멍게 (우렁쉥이) 국산|양식 1kg 당 DB 등록 성공!");
            }else{
                System.out.println("멍게 (우렁쉥이) 국산|양식 1kg 당 DB 등록 실패.");
            }
            System.out.println();
            // --------------------------------------------------------------------------------------
            // 해삼 동해|자연산 400g 당
            List<WebElement> scc = driver.findElements(By.id("market-0000009433"));
            s = "";
            for(WebElement el : scc){
                s += el.getText();
            }
            String seaCucumber_won = s.split("\n")[1];
            seaCucumber_won = seaCucumber_won.substring(0, seaCucumber_won.length() - 2);

            sql = "INSERT INTO seaCucumber (scc_standard, scc_size, scc_kg, scc_won) " + "VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "해삼 400g 당");
            pstmt.setString(2, "-");
            pstmt.setString(3, "-");
            pstmt.setString(4, seaCucumber_won);
            result = pstmt.executeUpdate();
            if(result >= 1){
                System.out.println("해삼 동해|자연산 400g 당 DB 등록 성공!");
            }else{
                System.out.println("해삼 동해|자연산 400g 당 DB 등록 실패.");
            }
            System.out.println();
            // --------------------------------------------------------------------------------------
            // 전복 국산|양식 1kg 당
            String[] abalone_size = new String[4];
            String[] abalone_won = new String[4];

            for(int i = 0; i <= 3; i++){
                List<WebElement> ab = driver.findElements(By.id("market-0000007459"));
                if(i == 1){
                    ab = driver.findElements(By.id("market-0000007460"));
                }else if(i == 2){
                    ab = driver.findElements(By.id("market-0000007462"));
                }else if(i == 3){
                    ab = driver.findElements(By.id("market-0000007467"));
                }
                s = "";
                for(WebElement el : ab){
                    s += el.getText();
                }
                abalone_size[i] = s.split("\n")[0];
                abalone_won[i] = s.split("\n")[1];
                abalone_won[i] = abalone_won[i].substring(0, abalone_won[i].length() - 2);
            }
            sql = "INSERT INTO abalone (ab_standard, ab_size, ab_kg, ab_won) " + "VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < 4; i++){
                pstmt.setString(1, "전복 1kg 당");
                pstmt.setString(2, abalone_size[i]);
                pstmt.setString(3, "-");
                pstmt.setString(4, abalone_won[i]);
                result = pstmt.executeUpdate();
                if(result >= 1){
                    System.out.println("전복 국산|양식 1kg 당 DB 등록 성공!");
                }else{
                    System.out.println("전복 국산|양식 1kg 당 DB 등록 실패.");
                }
            }
            System.out.println();
            // --------------------------------------------------------------------------------------
            // 가리비 국산|양식 1kg 당
            String[] scallop_size = new String[3];
            String[] scallop_won = new String[3];

            for(int i = 6; i <= 8; i++){
                List<WebElement> sca = driver.findElements(By.id("market-000000356" + i));
                if(i == 7){
                    sca = driver.findElements(By.id("market-0000003568"));
                }else if(i == 8){
                    sca = driver.findElements(By.id("market-0000003567"));
                }
                s = "";
                for(WebElement el : sca){
                    s += el.getText();
                }
                scallop_size[i - 6] = s.split("\n")[0];
                scallop_won[i - 6] = s.split("\n")[1];
                scallop_won[i - 6] = scallop_won[i - 6].substring(0, scallop_won[i - 6].length() - 2);
            }
            sql = "INSERT INTO scallop (sca_standard, sca_size, sca_kg, sca_won) " + "VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < 3; i++){
                pstmt.setString(1, "가리비 1kg 당");
                pstmt.setString(2, scallop_size[i]);
                pstmt.setString(3, "-");
                pstmt.setString(4, scallop_won[i]);
                result = pstmt.executeUpdate();
                if(result >= 1){
                    System.out.println("가리비 국산|양식 1kg 당 DB 등록 성공!");
                }else{
                    System.out.println("가리비 국산|양식 1kg 당 DB 등록 실패.");
                }
            }
            System.out.println();
            // --------------------------------------------------------------------------------------
            // 키조개 국산|자연산 1kg 당
            String[] clam_size = new String[4];
            String[] clam_won = new String[4];

            // 키조개 중, 대 일 경우

//            for(int i = 0; i < 2; i++){
//                List<WebElement> cla = driver.findElements(By.id("market-0000003158"));
//                if(i == 1){
//                    cla = driver.findElements(By.id("market-0000003160"));
//                }
//                s = "";
//                for(WebElement el : cla){
//                    s += el.getText();
//                }
//                clam_size[i] = s.split("\n")[0];
//                clam_won[i] = s.split("\n")[1];
//                clam_won[i] = clam_won[i].substring(0, clam_won[i].length() - 2);
//            }



            // 키조개 소, 중, 대 일 경우
            for(int i = 0; i < 3; i++){
                List<WebElement> cla = driver.findElements(By.id("market-0000003159"));
                if(i == 1){
                    cla = driver.findElements(By.id("market-0000003158"));
                }else if(i == 2){
                    cla = driver.findElements(By.id("market-0000003160"));
                }
                s = "";
                for(WebElement el : cla){
                    s += el.getText();
                }
                clam_size[i] = s.split("\n")[0];
                clam_won[i] = s.split("\n")[1];
                clam_won[i] = clam_won[i].substring(0, clam_won[i].length() - 2);
            }

            sql = "INSERT INTO clam (clam_standard, clam_size, clam_kg, clam_won) " + "VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            // 소, 중, 대 일 경우 i < 3 로 변경
            // 중, 대 일 경우 i < 2 로 변경
            for(int i = 0; i < 3; i++){
                pstmt.setString(1, "키조개 1kg 당");
                pstmt.setString(2, clam_size[i]);
                pstmt.setString(3, "-");
                pstmt.setString(4, clam_won[i]);
                result = pstmt.executeUpdate();
                if(result >= 1){
                    System.out.println("키조개 국산|자연산 1kg 당 DB 등록 성공!");
                }else{
                    System.out.println("키조개 국산|자연산 1kg 당 DB 등록 실패.");
                }
            }
            System.out.println("\nDB 업데이트 완료!");
        }catch(Exception exception){
            exception.printStackTrace();
            System.out.println("DB 업데이트 실패");
        }
    }
    public void handleBtnCancelAction (ActionEvent e){
        Platform.exit();
    }
}