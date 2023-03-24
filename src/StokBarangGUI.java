import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StokBarangGUI extends JFrame {
    // Membuat komponen GUI
    private JTable table;

    public StokBarangGUI() {
        super("Stok Barang");

        // Mengatur layout
        setLayout(new BorderLayout());

        // Mendapatkan data stok barang dari database
        String[] columns = {"ID Barang", "Nama Barang", "Stok", "Harga"};
        Object[][] data = getData();

        // Membuat tabel untuk menampilkan data stok barang
        table = new JTable(data, columns);

        // Menambahkan tabel ke dalam scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Menambahkan scroll pane ke dalam frame
        add(scrollPane, BorderLayout.CENTER);

        // Menampilkan frame
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private Object[][] getData() {
        // Mendapatkan data stok barang dari database
        String url = "https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM";
        String username = "nama_pengguna";
        String password = "kata_sandi";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT id_barang, nama_barang, stok, harga FROM stok_barang WHERE nama_barang LIKE 'S%' AND harga <= 7000";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            // Menyimpan data stok barang dalam array 2 dimensi
            ArrayList<Object[]> dataList = new ArrayList<>();
            while (result.next()) {
                Object[] row = new Object[4];
                row[0] = result.getString("id_barang");
                row[1] = result.getString("nama_barang");
                row[2] = result.getInt("stok");
                row[3] = result.getInt("harga");
                dataList.add(row);
            }
            Object[][] data = new Object[dataList.size()][4];
            for (int i = 0; i < dataList.size(); i++) {
                data[i] = dataList.get(i);
            }
            return data;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        new StokBarangGUI();
    }
}


