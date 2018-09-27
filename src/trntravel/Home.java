/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trntravel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ACER
 */
public class Home extends javax.swing.JFrame {
koneksi conn=new koneksi();
private DefaultTableModel model;
    /**
     * Creates new form Homing
     */
    
    
    
    public Home() {
        initComponents();
        viewPlg();
        viewJur();
        viewTrans();
        idplg();
        idjur();
        idtrans();
        
    }
    
    
    //Auto id
    public void idplg(){
        
        Connection c = koneksi.getKoneksi();
        try (Statement s = c.createStatement()) {
            String sql = "select max(id_pelanggan) as nmr from pelanggan";
            try (ResultSet r = s.executeQuery(sql)) {
                while (r.next()) {
                    String n = r.getString("nmr");
                    if (n == null) {
                        int id = 0 + 1;
                        txtId.setText(""+id);
                    }else{
                        int idd = Integer.parseInt(r.getString("nmr"));
                        int id = idd + 1;
                        txtId.setText(""+id);
                    }
                }
            }  
        } catch (SQLException e) {
      }
    }
    public void idjur(){
        
        Connection c = koneksi.getKoneksi();
        try (Statement s = c.createStatement()) {
            String sql = "select max(id_jurusan) as nmr from jurusan";
            try (ResultSet r = s.executeQuery(sql)) {
                while (r.next()) {
                    String n = r.getString("nmr");
                    if (n == null) {
                        int id = 0 + 1;
                        txtIdJur.setText(""+id);
                    }else{
                        int idd = Integer.parseInt(r.getString("nmr"));
                        int id = idd + 1;
                        txtIdJur.setText(""+id);
                    }
                }
            }  
        } catch (SQLException e) {
      }
    }
    public void idtrans(){
        
        Connection c = koneksi.getKoneksi();
        try (Statement s = c.createStatement()) {
            String sql = "select max(id_transaksi) as nmr from pemesanan";
            try (ResultSet r = s.executeQuery(sql)) {
                while (r.next()) {
                    String n = r.getString("nmr");
                    if (n == null) {
                        int id = 1;
                        idTrans.setText(" "+id);
                    }else{
                        int idd = Integer.parseInt(r.getString("nmr"));
                        int id = idd + 1;
                        idTrans.setText(""+id);
                    }
                }
            }  
        } catch (SQLException e) {
      }
    }
    
    
    //view data from database to table
    public void viewPlg(){
        DefaultTableModel tbl=new DefaultTableModel();
        tbl.addColumn("ID Pelanggan");
        tbl.addColumn("Nama Pelanggan");
        tbl.addColumn("No Telepon");
        tbl.addColumn("Email");
        
        try{
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql="SELECT * FROM pelanggan ORDER BY id_pelanggan asc";
            ResultSet rs=s.executeQuery(sql);
            
            while(rs.next()){
                tbl.addRow (new Object []{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
                });
            }
            tabPelanggan.setModel(tbl);
        } catch (SQLException ex) {
    }
}
    public void viewJur(){
        DefaultTableModel tbk=new DefaultTableModel();
        tbk.addColumn("No");
        tbk.addColumn("Jurusan");
        tbk.addColumn("Harga");
        tbk.addColumn("Jadwal");
        
        try{
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql="SELECT * FROM Jurusan ORDER BY id_jurusan asc";
            ResultSet rs=s.executeQuery(sql);
            
            while(rs.next()){
                tbk.addRow (new Object []{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
                });
            }
            tabJurusan.setModel(tbk);
        } catch (SQLException ex) {
    }
}
    public void viewTrans(){
        DefaultTableModel tbj=new DefaultTableModel();
        tbj.addColumn("No");
        tbj.addColumn("Nama");
        tbj.addColumn("Jurusan");
        tbj.addColumn("Kelas");
        tbj.addColumn("Jumlah");
        tbj.addColumn("Total");
        
        try{
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql="SELECT * FROM pemesanan ORDER BY id_Transaksi asc";
            ResultSet rs=s.executeQuery(sql);
            
            while(rs.next()){
                tbj.addRow (new Object []{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
                });
            }
            tabTransaksi.setModel(tbj);
        } catch (SQLException ex) {
    }
}
     
    //Combo box transaksi from database
    public void comboNama(){
    
        try{
            Connection c = koneksi.getKoneksi();
            Statement st=c.createStatement();
            String sql="Select nama_pelanggan from pelanggan";
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                txtNamaTrans.addItem(rs.getString("nama_pelanggan"));
            } 
                
            
        }catch(Exception ex){
            
        }
        
}
    public void comboJurusan(){
    
        try{
            Connection c = koneksi.getKoneksi();
            Statement st=c.createStatement();
            String sql="Select 'jurusan' from Jurusan";
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                jurusanCombo.addItem(rs.getString("'jurusan'"));
            } 
                
            
        }catch(Exception ex){
            
        }
        
}
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Kelas = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Pelanggan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNoTelp = new javax.swing.JTextField();
        addPel = new javax.swing.JLabel();
        delPel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabPelanggan = new javax.swing.JTable();
        bg_tab = new javax.swing.JLabel();
        Jurusan = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        delJur = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        addJur = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        txtJadwal = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtAsal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtIdJur = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabJurusan = new javax.swing.JTable();
        bg = new javax.swing.JLabel();
        Pemesanan = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabTransaksi = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        idTrans = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jurusanCombo = new javax.swing.JComboBox<>();
        Eksekutif = new javax.swing.JRadioButton();
        Ekonomi = new javax.swing.JRadioButton();
        Bisnis = new javax.swing.JRadioButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        SpinJumlah = new javax.swing.JSpinner();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        Harga = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        delTrans = new javax.swing.JLabel();
        addTrans = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtNamaTrans = new javax.swing.JComboBox<>();
        bg_trans = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 128, 525, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Header.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 150));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Modern No. 20", 1, 24)); // NOI18N

        Pelanggan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        jLabel1.setText("Nama");
        Pelanggan.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 50, 30));
        Pelanggan.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 230, 30));
        Pelanggan.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 230, 30));

        jLabel2.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        jLabel2.setText("Email");
        Pelanggan.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 50, 30));

        jLabel4.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        jLabel4.setText("No Telp");
        Pelanggan.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 60, 30));
        Pelanggan.add(txtNoTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 230, 30));

        addPel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-80.png"))); // NOI18N
        addPel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addPel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addPel.setName(""); // NOI18N
        addPel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addPelMouseClicked(evt);
            }
        });
        Pelanggan.add(addPel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, 40));

        delPel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-trash-96 (1).png"))); // NOI18N
        delPel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delPel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delPel.setDisabledIcon(null);
        delPel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delPelMouseClicked(evt);
            }
        });
        Pelanggan.add(delPel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, 40));

        jLabel8.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 255, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Reset");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        Pelanggan.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 60, 20));

        jLabel9.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 255, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Add");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        Pelanggan.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 40, 23));

        jLabel10.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 255, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Delete");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        Pelanggan.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 40, 23));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image00004.png"))); // NOI18N
        jLabel28.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        Pelanggan.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, 40));

        jLabel3.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        jLabel3.setText("No");
        Pelanggan.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 30));

        txtId.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        Pelanggan.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 130, 30));

        tabPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tabPelanggan);

        Pelanggan.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 560, 170));

        bg_tab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgw.jpg"))); // NOI18N
        Pelanggan.add(bg_tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 340));

        jTabbedPane1.addTab("Pelanggan", Pelanggan);

        Jurusan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        jLabel11.setText("Jadwal ");
        Jurusan.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 60, 30));

        jLabel12.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        jLabel12.setText("Harga");
        Jurusan.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 60, 30));

        jLabel14.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 255, 102));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Reset");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        Jurusan.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 60, 20));

        delJur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-trash-96 (1).png"))); // NOI18N
        delJur.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delJur.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delJur.setDisabledIcon(null);
        delJur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delJurMouseClicked(evt);
            }
        });
        Jurusan.add(delJur, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, 40));

        jLabel16.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 255, 102));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Delete");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        Jurusan.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 40, 23));

        addJur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-80.png"))); // NOI18N
        addJur.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addJur.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addJur.setName(""); // NOI18N
        addJur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addJurMouseClicked(evt);
            }
        });
        Jurusan.add(addJur, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, 40));

        jLabel18.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 255, 102));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Add");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        Jurusan.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 40, 23));

        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
            }
        });
        Jurusan.add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 230, 30));

        txtJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJadwalActionPerformed(evt);
            }
        });
        Jurusan.add(txtJadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 230, 30));

        jLabel27.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        jLabel27.setText("Jurusan");
        Jurusan.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, 30));
        Jurusan.add(txtAsal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 230, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image00004.png"))); // NOI18N
        jLabel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        Jurusan.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, 40));

        txtIdJur.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        Jurusan.add(txtIdJur, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 70, 30));

        jLabel30.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        jLabel30.setText("No");
        Jurusan.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 30));

        tabJurusan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tabJurusan);

        Jurusan.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 560, 170));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgw.jpg"))); // NOI18N
        Jurusan.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 340));

        jTabbedPane1.addTab("Jurusan", Jurusan);

        Pemesanan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabTransaksi);

        Pemesanan.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 560, 140));

        jLabel31.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        jLabel31.setText("No");
        Pemesanan.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 30));

        idTrans.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        Pemesanan.add(idTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 70, 30));

        jLabel25.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        jLabel25.setText("Nama");
        Pemesanan.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, 30));

        jLabel29.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        jLabel29.setText("Jurusan");
        Pemesanan.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 70, 30));
        Pemesanan.add(jurusanCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 230, 29));

        Eksekutif.setBackground(new java.awt.Color(255, 255, 255));
        Kelas.add(Eksekutif);
        Eksekutif.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        Eksekutif.setText("Eksekutif");
        Eksekutif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EksekutifActionPerformed(evt);
            }
        });
        Pemesanan.add(Eksekutif, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        Ekonomi.setBackground(new java.awt.Color(255, 255, 255));
        Kelas.add(Ekonomi);
        Ekonomi.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        Ekonomi.setText("Ekonomi");
        Ekonomi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EkonomiActionPerformed(evt);
            }
        });
        Pemesanan.add(Ekonomi, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        Bisnis.setBackground(new java.awt.Color(255, 255, 255));
        Kelas.add(Bisnis);
        Bisnis.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        Bisnis.setText("Bisnis");
        Bisnis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BisnisActionPerformed(evt);
            }
        });
        Pemesanan.add(Bisnis, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        jLabel32.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        jLabel32.setText("Kelas");
        Pemesanan.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 70, 30));

        jLabel33.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        jLabel33.setText("Jumlah");
        Pemesanan.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 70, 30));

        SpinJumlah.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        SpinJumlah.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        Pemesanan.add(SpinJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 39, 30));
        SpinJumlah.getAccessibleContext().setAccessibleName("");

        jLabel34.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        jLabel34.setText("Harga");
        Pemesanan.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 70, 30));

        jLabel35.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel35.setText("Rp");
        Pemesanan.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, 30));

        Harga.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        Harga.setText("\"Click here\"");
        Harga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HargaMouseClicked(evt);
            }
        });
        Pemesanan.add(Harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 130, 30));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image00004.png"))); // NOI18N
        jLabel36.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });
        Pemesanan.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, 40));

        jLabel37.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 255, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Reset");
        jLabel37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel37.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        Pemesanan.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 60, 20));

        jLabel38.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 255, 102));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Delete");
        jLabel38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel38.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        Pemesanan.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 40, 23));

        delTrans.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-trash-96 (1).png"))); // NOI18N
        delTrans.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delTrans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delTrans.setDisabledIcon(null);
        delTrans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delTransMouseClicked(evt);
            }
        });
        Pemesanan.add(delTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, 40));

        addTrans.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-80.png"))); // NOI18N
        addTrans.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addTrans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addTrans.setName(""); // NOI18N
        addTrans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTransMouseClicked(evt);
            }
        });
        Pemesanan.add(addTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, 40));

        jLabel41.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(102, 255, 102));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Add");
        jLabel41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel41.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        Pemesanan.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 40, 23));
        Pemesanan.add(txtNamaTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 230, 29));

        bg_trans.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgw.jpg"))); // NOI18N
        bg_trans.setText("jLabel42");
        Pemesanan.add(bg_trans, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 340));

        jTabbedPane1.addTab("Pemesanan", Pemesanan);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 570, 380));

        jMenu1.setText("File");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image00003.png"))); // NOI18N
        jMenuItem4.setText("Exit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image00001.png"))); // NOI18N
        jMenuItem2.setText("Check for Updates");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image00002.png"))); // NOI18N
        jMenuItem5.setText("About");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // Updates Menu

        Update date;
        date = new Update();

        date.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // About Menu

        About bout;
        bout = new About();

        bout.show();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // Jurusan Reset Button

        idjur();
        txtAsal.setText("");
        txtJadwal.setText("");
        txtHarga.setText("");
    }//GEN-LAST:event_jLabel13MouseClicked

    private void txtJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJadwalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJadwalActionPerformed

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaActionPerformed

    private void addJurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addJurMouseClicked
        // add jurusan

        

        String id = txtIdJur.getText();
        String asal = txtAsal.getText();
        String harga = txtHarga.getText();
        String jadwal = txtJadwal.getText();

        try {
            Connection c = koneksi.getKoneksi();
            String sql = "insert into jurusan values (?, ?, ?, ?)";
            try (PreparedStatement p = c.prepareStatement(sql)){

                p.setString(1, id);
                p.setString(2, asal);
                p.setString(3, jadwal);
                p.setString(4, harga);

                p.executeUpdate();
            }
        viewJur();
            idjur();
            txtAsal.setText("");
            txtJadwal.setText("");
            txtHarga.setText("");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(this, "Tesrjadi Error!~");
        }
        finally {
            viewJur();
            JOptionPane.showMessageDialog(this, "Sukses Menambah Data");
        }
    }//GEN-LAST:event_addJurMouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // Reset Button
       idplg();
        txtNama.setText("");
        txtEmail.setText("");
        txtNoTelp.setText("");
    }//GEN-LAST:event_jLabel28MouseClicked

    private void addPelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPelMouseClicked
        // Add Button pelanggan
        
        String id = txtId.getText();
        String nama = txtNama.getText();
        String email = txtEmail.getText();
        String hp = txtNoTelp.getText();

        try {
            Connection c = koneksi.getKoneksi();
            String sql = "insert into pelanggan values (?, ?, ?, ?)";
            try (PreparedStatement p = c.prepareStatement(sql)){

                p.setString(1, id);
                p.setString(2, nama);
                p.setString(3, hp);
                p.setString(4, email);

                p.executeUpdate();
            }
            viewPlg();
        
            idplg();
            txtNama.setText("");
            txtEmail.setText("");
            txtNoTelp.setText("");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(this, "Terkena exception e");
        }
        finally {
            viewPlg();
            JOptionPane.showMessageDialog(this, "Sukses Menambah Data");
        }
    }//GEN-LAST:event_addPelMouseClicked

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
        // Reset Button transaksi
        
        idtrans();
        comboNama();
        comboJurusan();
        Kelas.clearSelection();
        
        Harga.setText("");
    }//GEN-LAST:event_jLabel36MouseClicked

    private void addTransMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addTransMouseClicked
        // add button transaksi
        
        String id = idTrans.getText();
        String nama = (String) txtNamaTrans.getSelectedItem();
        String jurusan = (String) jurusanCombo.getSelectedItem();
        String kelas = (String)Kelas.getSelection().getActionCommand();
        String jumlah = (String)SpinJumlah.getValue();
        String total = Harga.getText();

        try {
            Connection c = koneksi.getKoneksi();
            String sql = "insert into pemesanan values (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement p = c.prepareStatement(sql)){

                p.setString(1, id);
                p.setString(2, nama);
                p.setString(3, jurusan);
                p.setString(4, kelas);
                p.setString(5, jumlah);
                p.setString(6, total);

                p.executeUpdate();
            }
            viewTrans();
            idtrans();
            Kelas.clearSelection();
            
            Harga.setText("");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan~");
        }
        finally {
            viewTrans();
            JOptionPane.showMessageDialog(this, "Sukses Menambah Data");
        }
    }//GEN-LAST:event_addTransMouseClicked

    private void EksekutifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EksekutifActionPerformed
        Eksekutif.setActionCommand("Eksekutif");
    }//GEN-LAST:event_EksekutifActionPerformed

    private void EkonomiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EkonomiActionPerformed
        Ekonomi.setActionCommand("Ekonomi");
    }//GEN-LAST:event_EkonomiActionPerformed

    private void BisnisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BisnisActionPerformed
        Bisnis.setActionCommand("Bisnis");
    }//GEN-LAST:event_BisnisActionPerformed

    private void delPelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delPelMouseClicked
        // Delete pelanggan
                
        int a = tabPelanggan.getSelectedRow();
         if (a==-1){
            return;
        }
        String id = (String) tabPelanggan.getValueAt(a,0);
        
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "delete FROM pelanggan WHERE id_pelanggan=?";
            try (PreparedStatement p = c.prepareStatement(sql)) {
                
                p.setString(1, id);
                p.executeUpdate();
            }
        }catch (SQLException e){
            System.err.println ("Terjadi Error");
        }finally {
            viewPlg();
        }
        
        txtNama.setText(null);
        txtNoTelp.setText(null);
        txtEmail.setText(null);
        idplg();
    }//GEN-LAST:event_delPelMouseClicked

    private void delJurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delJurMouseClicked
        // Delete Jurusan
        
                
        int a = tabJurusan.getSelectedRow();
         if (a==-1){
            return;
        }
        String id = (String) tabJurusan.getValueAt(a,0);
        
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "delete FROM jurusan WHERE id_jurusan=?";
            try (PreparedStatement p = c.prepareStatement(sql)) {
                
                p.setString(1, id);
                p.executeUpdate();
            }
        }catch (SQLException e){
            System.err.println ("Terjadi Error");
        }finally {
            viewJur();
        }
        
        txtAsal.setText(null);
        txtJadwal.setText(null);
        txtHarga.setText(null);
        idjur();
    }//GEN-LAST:event_delJurMouseClicked

    private void delTransMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delTransMouseClicked
        // Delete transaksi
        
        int a = tabTransaksi.getSelectedRow();
         if (a==-1){
            return;
        }
        String id = (String) tabTransaksi.getValueAt(a,0);
        
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "delete FROM pemesanan WHERE id_transaksi=?";
            try (PreparedStatement p = c.prepareStatement(sql)) {
                
                p.setString(1, id);
                p.executeUpdate();
            }
        }catch (SQLException e){
            System.err.println ("Terjadi Error");
        }finally {
            viewJur();
        }
        
       
        txtNamaTrans.setSelectedItem(null);
        jurusanCombo.setSelectedItem(null);
        Kelas.getSelection().getActionCommand();
        SpinJumlah.setValue(null);
        Harga.setText(null);
       
        idtrans();
    }//GEN-LAST:event_delTransMouseClicked

    private void HargaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HargaMouseClicked
        // Harga
        
        int tot=0;
        try{
            Connection c =koneksi.getKoneksi();
            Statement s=c.createStatement();
            String sql="select * from Jurusan";
            ResultSet rs=s.executeQuery(sql);
            if(rs.next()){
                tot=rs.getInt("harga");
            }
            
        if(Eksekutif.isSelected()){
            tot=tot+10000;
        }else if(Ekonomi.isSelected()){
            tot=tot+8000;
        }else if(Bisnis.isSelected()){
            tot=tot+6000;
        }
        int ss=(Integer)SpinJumlah.getValue();
        tot=tot*ss;
        }catch(Exception e){
            
        }
        Harga.setText(""+tot);
    }//GEN-LAST:event_HargaMouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Bisnis;
    private javax.swing.JRadioButton Ekonomi;
    private javax.swing.JRadioButton Eksekutif;
    private javax.swing.JLabel Harga;
    private javax.swing.JPanel Jurusan;
    private javax.swing.ButtonGroup Kelas;
    private javax.swing.JPanel Pelanggan;
    private javax.swing.JPanel Pemesanan;
    private javax.swing.JSpinner SpinJumlah;
    private javax.swing.JLabel addJur;
    private javax.swing.JLabel addPel;
    private javax.swing.JLabel addTrans;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg_tab;
    private javax.swing.JLabel bg_trans;
    private javax.swing.JLabel delJur;
    private javax.swing.JLabel delPel;
    private javax.swing.JLabel delTrans;
    javax.swing.JLabel idTrans;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jurusanCombo;
    public javax.swing.JTable tabJurusan;
    public javax.swing.JTable tabPelanggan;
    public javax.swing.JTable tabTransaksi;
    private javax.swing.JTextField txtAsal;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHarga;
    javax.swing.JLabel txtId;
    javax.swing.JLabel txtIdJur;
    private javax.swing.JTextField txtJadwal;
    private javax.swing.JTextField txtNama;
    private javax.swing.JComboBox<String> txtNamaTrans;
    private javax.swing.JTextField txtNoTelp;
    // End of variables declaration//GEN-END:variables
}
