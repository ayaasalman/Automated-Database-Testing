import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestCases {

    Connection conn;
    Statement stmt; // the query we will send
    ResultSet rs;
    String url = "jdbc:mysql://localhost:3306/classicmodels"; // mysql server
    // jdbc is mysql's driver
    String username = "root";
    String password = "";

    String webUrl = "https://magento.softwaretestingboard.com/customer/account/create/";
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setup() throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    @Test(priority = 3)
    public void getData() throws SQLException {
        stmt = conn.createStatement();
        // String query = "SELECT * FROM CUSTOMERS WHERE CUSTOMERNUMBER = 1";
        rs = stmt.executeQuery("SELECT * FROM CUSTOMERS WHERE CUSTOMERNUMBER = 1");

        String customerName = null;
        while (rs.next()) {
            int customerNumber = rs.getInt("CUSTOMERNUMBER");
            customerName = rs.getString("CUSTOMERNAME");
        }

        driver.get(webUrl);
        driver.findElement(By.id("firstname")).sendKeys(customerName);
    }

    @Test(priority = 1)
    public void postData() throws SQLException {
        String query = "INSERT INTO CUSTOMERS (CUSTOMERNUMBER, CUSTOMERNAME, CONTACTLASTNAME, CONTACTFIRSTNAME, PHONE, ADDRESSLINE1, CITY, COUNTRY) VALUES(1, 'Aya', 'Salman', 'Aya', 07913121908, 'Um Uthaina', 'Amman', 'Jordan')";
        stmt = conn.createStatement();
        int rowInserted = stmt.executeUpdate(query);
        Assert.assertTrue(rowInserted == 1);
    }

    @Test(priority = 2)
    public void updateData() throws SQLException {
        stmt = conn.createStatement();
        String query = "UPDATE CUSTOMERS SET CUSTOMERNAME = 'SQA' WHERE CUSTOMERNUMBER = 1";
        int rowUpdated = stmt.executeUpdate(query);
        Assert.assertTrue(rowUpdated == 1);
    }

    @Test(priority = 4)
    public void deleteData() throws SQLException {
        stmt = conn.createStatement();
        String query = "DELETE FROM CUSTOMERS WHERE CUSTOMERNUMBER = 1";
        int rowDeleted = stmt.executeUpdate(query);
        Assert.assertTrue(rowDeleted == 1);
    }

    @AfterTest
    public void closeConnection() throws SQLException {
        conn.close();
        driver.quit();
    }
}
