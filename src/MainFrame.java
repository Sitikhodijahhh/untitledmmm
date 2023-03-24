import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JTextField tfNamaBarang;
    private JTextField tfHargaBarang;
    private JButton btnOK;
    private JButton btnClear;
    private JLabel lbWelcome;
    private JPanel mainPanel;

    public MainFrame() {
        setContentPane(mainPanel);
        setTitle("welcome");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String NamaBarang = tfNamaBarang.getText();
                String HargaBarang = tfHargaBarang.getText();
                lbWelcome.setText("Welcoe " + NamaBarang + " " + HargaBarang);
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfHargaBarang.setText("");
                tfNamaBarang.setText("");
                lbWelcome.setText("");
            }
        });
    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
    }

}
