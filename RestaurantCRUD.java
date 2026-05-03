import java.sql.*;

public class RestaurantCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/RestaurantDB";
    static final String USER = "root";
    static final String PASS = "rajat123"; // change if needed

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            insertRestaurants(con);
            insertMenuItems(con);

            System.out.println("\n--- Menu Items with Price <= 100 ---");
            selectPriceLessThan100(con);

            System.out.println("\n--- Items in Cafe Java ---");
            selectCafeJavaItems(con);

            updatePrices(con);

            System.out.println("\n--- After Update (Price <=100 → 200) ---");
            selectAllMenu(con);

            deleteItems(con);

            System.out.println("\n--- After Deleting Items Starting with P ---");
            selectAllMenu(con);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 Insert Restaurants
    static void insertRestaurants(Connection con) throws SQLException {
        String query = "INSERT INTO Restaurant (Name, Address) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(query);

        String[][] data = {
                {"Cafe Java", "Pune"},
                {"Food Hub", "Mumbai"},
                {"Spice Villa", "Delhi"},
                {"Urban Bites", "Bangalore"},
                {"Quick Eats", "Chennai"},
                {"Royal Dine", "Hyderabad"},
                {"Taste Town", "Kolkata"},
                {"Snack Corner", "Nagpur"},
                {"City Food", "Surat"},
                {"Dine Fine", "Jaipur"}
        };

        for (String[] row : data) {
            ps.setString(1, row[0]);
            ps.setString(2, row[1]);
            ps.executeUpdate();
        }
    }

    // 🔹 Insert Menu Items (FIXED)
    static void insertMenuItems(Connection con) throws SQLException {
        String query = "INSERT INTO MenuItem (Name, Price, ResId) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);

        Object[][] items = {
                {"Pizza", 90, 1},
                {"Burger", 80, 1},
                {"Pasta", 120, 2},
                {"Sandwich", 70, 3},
                {"Fries", 60, 4},
                {"Paneer Roll", 110, 5},
                {"Coffee", 50, 1},
                {"Tea", 30, 2},
                {"Noodles", 95, 3},
                {"Pancake", 85, 1}
        };

        for (Object[] item : items) {
            ps.setString(1, (String) item[0]);
            ps.setDouble(2, ((Number) item[1]).doubleValue()); // ✅ FIX
            ps.setInt(3, (Integer) item[2]);
            ps.executeUpdate();
        }
    }

    // 🔹 Select price <=100
    static void selectPriceLessThan100(Connection con) throws SQLException {
        String query = "SELECT * FROM MenuItem WHERE Price <= 100";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        printMenu(rs);
    }

    // 🔹 Select items in Cafe Java
    static void selectCafeJavaItems(Connection con) throws SQLException {
        String query = "SELECT m.* FROM MenuItem m " +
                       "JOIN Restaurant r ON m.ResId = r.Id " +
                       "WHERE r.Name = 'Cafe Java'";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        printMenu(rs);
    }

    // 🔹 Update prices
    static void updatePrices(Connection con) throws SQLException {
        String query = "UPDATE MenuItem SET Price = 200 WHERE Price <= 100";
        Statement st = con.createStatement();
        int rows = st.executeUpdate(query);

        System.out.println("\nUpdated Rows: " + rows);
    }

    // 🔹 Delete items starting with P
    static void deleteItems(Connection con) throws SQLException {
        String query = "DELETE FROM MenuItem WHERE Name LIKE 'P%'";
        Statement st = con.createStatement();
        int rows = st.executeUpdate(query);

        System.out.println("\nDeleted Rows: " + rows);
    }

    // 🔹 Select all
    static void selectAllMenu(Connection con) throws SQLException {
        String query = "SELECT * FROM MenuItem";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        printMenu(rs);
    }

    // 🔹 Print table
    static void printMenu(ResultSet rs) throws SQLException {
        System.out.printf("%-5s %-15s %-10s %-5s\n", "ID", "Name", "Price", "ResId");
        System.out.println("------------------------------------------");

        while (rs.next()) {
            System.out.printf("%-5d %-15s %-10.2f %-5d\n",
                    rs.getInt("Id"),
                    rs.getString("Name"),
                    rs.getDouble("Price"),
                    rs.getInt("ResId"));
        }
    }
}