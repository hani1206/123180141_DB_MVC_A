import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {
    JLabel title;

    JLabel lNo_hp = new JLabel("No_hp : ");
    JTextField tfNo_hp = new JTextField();
    JLabel lNama = new JLabel("Nama : ");
    JTextField tfNama = new JTextField();
    JLabel lUmur = new JLabel("Umur : ");
    JTextField tfUmur = new JTextField();
    JLabel lEmail = new JLabel("Email : ");
    JTextField tfEmail = new JTextField();

    JLabel lNo_hp2 = new JLabel("No_hp : ");
    JLabel lNama2 = new JLabel("Nama : ");
    JTextField tfNama2 = new JTextField();
    JLabel lUmur2 = new JLabel("Umur : ");
    JTextField tfUmur2 = new JTextField();
    JLabel lEmail2 = new JLabel("Email : ");
    JTextField tfEmail2 = new JTextField();

    JComboBox daftarNo_hp = new JComboBox();

    JButton btnInsert = new JButton("Insert");
    JButton btnReset1 = new JButton("Reset");
    JButton btnUpdate = new JButton("Update");
    JButton btnReset2 = new JButton("Reset");

    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    Object namaKolom[] = {"No_hp", "Nama", "Umur", "Email"};

    public View() {
        tableModel = new DefaultTableModel(namaKolom, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(530, 550);

        title = new JLabel("Data Contact");
        add(title);
        title.setBounds(200, 5, 100, 20);

        title = new JLabel("Insert Data");
        add(title);
        title.setBounds(100, 35, 100, 20);

        title = new JLabel("Update Data");
        add(title);
        title.setBounds(350, 35, 100, 20);

        add(scrollPane);
        scrollPane.setBounds(20, 195, 480, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(lNo_hp);
        lNo_hp.setBounds(20, 65, 90, 20);
        add(tfNo_hp);
        tfNo_hp.setBounds(110, 65, 120, 20);
        add(lNama);
        lNama.setBounds(20, 90, 90, 20);
        add(tfNama);
        tfNama.setBounds(110, 90, 120, 20);
        add(lUmur);
        lUmur.setBounds(20, 115, 90, 20);
        add(tfUmur);
        tfUmur.setBounds(110, 115, 120, 20);
        add(lEmail);
        lEmail.setBounds(20, 140, 90, 20);
        add(tfEmail);
        tfEmail.setBounds(110, 140, 120, 20);

        add(lNo_hp2);
        lNo_hp2.setBounds(270, 65, 90, 20);
        add(daftarNo_hp);
        daftarNo_hp.setBounds(360, 65, 120, 20);
        add(lNama2);
        lNama2.setBounds(270, 90, 90, 20);
        add(tfNama2);
        tfNama2.setBounds(360, 90, 120, 20);
        add(lUmur2);
        lUmur2.setBounds(270, 115, 90, 20);
        add(tfUmur2);
        tfUmur2.setBounds(360, 115, 120, 20);
        add(lEmail2);
        lEmail2.setBounds(270, 140, 90, 20);
        add(tfEmail2);
        tfEmail2.setBounds(360, 140, 120, 20);

        add(btnInsert);
        btnInsert.setBounds(20, 170, 90, 20);
        add(btnReset1);
        btnReset1.setBounds(130, 170, 90, 20);
        add(btnUpdate);
        btnUpdate.setBounds(270, 170, 90, 20);
        add(btnReset2);
        btnReset2.setBounds(380, 170, 90, 20);
    }

    public String getNo_hp(){
        return tfNo_hp.getText();
    }

    public String getNama(){
        return tfNama.getText();
    }

    public String getUmur(){
        return tfUmur.getText();
    }

    public String getEmail(){
        return tfEmail.getText();
    }

    public String getNo_hpCombo(){
        return daftarNo_hp.getSelectedItem().toString();
    }

    public String getNama2(){
        return tfNama2.getText();
    }

    public String getUmur2(){
        return tfUmur2.getText();
    }

    public String getEmail2(){
        return tfEmail2.getText();
    }
}