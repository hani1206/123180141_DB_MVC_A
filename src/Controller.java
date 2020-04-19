import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Controller implements ActionListener{
    Model model;
    View view;
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        if (model.getBanyakData() != 0){
            String data[][] = model.read();
            view.table.setModel(new JTable(data, view.namaKolom).getModel());
            updateDataCombo(model.readNo_hp());
        } else {
            JOptionPane.showMessageDialog(null, "Data Masih Kosong");
        }

        view.btnInsert.addActionListener(this);
        view.btnReset1.addActionListener(this);
        view.btnUpdate.addActionListener(this);
        view.btnReset2.addActionListener(this);

        view.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int baris = view.table.getSelectedRow();
                int kolom = view.table.getSelectedColumn();

                String data = view.table.getValueAt(baris, 0).toString();


                int input = JOptionPane.showConfirmDialog(null,
                        "Apa Anda Ingin Menghapus Data " + data + " ?",
                        "Pilih Opsi..." , JOptionPane.YES_NO_OPTION);

                if (input == 0){
                    model.delete(data);
                    String newData[][] = model.read();
                    view.table.setModel(new JTable(newData, view.namaKolom).getModel());
                    updateDataCombo(model.readNo_hp());
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnInsert) {
            String no_hp = view.getNo_hp();
            String nama = view.getNama();
            String umur = view.getUmur();
            String email = view.getEmail();

            if (no_hp.equals("")){
                JOptionPane.showMessageDialog(null, "Nomor hp Tidak Boleh Kosong");
            } else if (no_hp.length() != 12){
                JOptionPane.showMessageDialog(null, "Nomor Harus 12 Digit");
            } else {
                model.insert(no_hp, nama, umur, email);
                String newData[][] = model.read();
                view.table.setModel(new JTable(newData, view.namaKolom).getModel());
                updateDataCombo(model.readNo_hp());
            }
        } else if (e.getSource() == view.btnReset1){
            view.tfNo_hp.setText("");
            view.tfNama.setText("");
            view.tfUmur.setText("");
            view.tfEmail.setText("");
        } else if (e.getSource() == view.btnUpdate){
            String no_hp = view.getNo_hpCombo();
            String nama = view.getNama2();
            String umur = view.getUmur2();
            String email = view.getEmail2();

            if (nama.equals("") || umur.equals("") || email.equals("")){
                JOptionPane.showMessageDialog(null, "Form Tidak Boleh Kosong");
            } else {
                model.update(no_hp, nama, umur, email);
                String newData[][] = model.read();
                view.table.setModel(new JTable(newData, view.namaKolom).getModel());
                updateDataCombo(model.readNo_hp());
            }
        } else if (e.getSource() == view.btnReset2){
            view.tfNama2.setText("");
            view.tfUmur2.setText("");
            view.tfEmail2.setText("");
        }
    }

    public void updateDataCombo(ArrayList<String> data){
        view.daftarNo_hp.removeAllItems();
        for (String item : data) {
            view.daftarNo_hp.addItem(item);
        }
    }
}