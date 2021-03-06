/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumproject;

import java.sql.ResultSet;
import java.time.LocalDate;
import javafx.scene.control.DatePicker;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.bind.ParseConversionEvent;
import sqlconnection.SQLConnection;

/**
 *
 * @author Tomas
 */
public class StartPageFrame extends javax.swing.JFrame {

    /**
     * Creates new form StartPageFrame
     */
    public StartPageFrame() {
        initComponents();
        fillCB();
    }
    private void fillCB() {
        try {
            ResultSet rs = SQLConnection.getDatabas().executeQuery("SELECT namn FROM underkategori");
            while(rs.next()){
                String category = rs.getString(1);
                    cbUnderkategori.addItem(category); 
                }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
     public void fyllListaMedForskningsInlagg(){
        try{
           DefaultTableModel inlaggsaModell = (DefaultTableModel) tblForskning.getModel();
            inlaggsaModell.setRowCount(0);
            
            String underkategori = cbUnderkategori.getSelectedItem().toString();
            ResultSet rs = SQLConnection.getDatabas().executeQuery("select Forskning.ID, Anvandare.namn, titel, datum, text, filvag from Forskning \n" +
                    "join Anvandare on Anvandare.ID = Forskning.Forfattare\n" +
                    "join Underkategori on Underkategori.ID = Forskning.UnderkategoriID\n" +
                    "where  Underkategori.NAMN = '" + underkategori + "'\n" +
                    "Order by datum DESC");

            String namn = "";
            String titel = "";
            String datum = "";
            String text = "";
            String filvag = "";
            String id = "";
            while(rs.next()) { 
                id = rs.getString(1);
                namn = rs.getString(2);
                titel = rs.getString(3);
                datum = rs.getString(4);
                text = rs.getString(5);
                filvag = rs.getString(6);
                inlaggsaModell.insertRow(tblForskning.getRowCount(), new Object[] { id, namn, titel, datum, text, filvag});
            } 
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    public void fyllListaMedInlagg(){
        try{
           DefaultTableModel inlaggsaModell = (DefaultTableModel) tbFormellaInlagg.getModel();
            inlaggsaModell.setRowCount(0);
            
            String kategori = cbKategori.getSelectedItem().toString();
            ResultSet rs = SQLConnection.getDatabas().executeQuery("select FormelltInlagg.Id, namn, titel, datum, text, filvag from FormelltInlagg join Anvandare on Anvandare.ID = FormelltInlagg.Forfattare where Kategori = '" + kategori + "'" + "Order by datum DESC");

            String namn = "";
            String titel = "";
            String datum = "";
            String text = "";
            String filvag = "";
            String id = "";
            while(rs.next()) { 
                id = rs.getString(1);
                namn = rs.getString(2);
                titel = rs.getString(3);
                datum = rs.getString(4);
                text = rs.getString(5);
                filvag = rs.getString(6);
                inlaggsaModell.insertRow(tbFormellaInlagg.getRowCount(), new Object[] {id, namn, titel, datum, text, filvag});
            } 
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
        public void fyllUtbildningsListaMedInlagg(){
        try{
           DefaultTableModel inlaggsaModell = (DefaultTableModel) tblUtbildning.getModel();
            inlaggsaModell.setRowCount(0);
            
            ResultSet rs = SQLConnection.getDatabas().executeQuery("select Utbildning.Id, namn, titel, datum, text, filvag from Utbildning join Anvandare on Anvandare.ID = Utbildning.Forfattare Order by datum DESC");

            String namn = "";
            String titel = "";
            String datum = "";
            String text = "";
            String filvag = "";
            String id = "";
            while(rs.next()) { 
                id = rs.getString(1);
                namn = rs.getString(2);
                titel = rs.getString(3);
                datum = rs.getString(4);
                text = rs.getString(5);
                filvag = rs.getString(6);
                inlaggsaModell.insertRow(tblUtbildning.getRowCount(), new Object[] {id, namn, titel, datum, text, filvag});
            } 
        }
        catch(Exception e){
            System.out.println(e.getMessage());
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

        tbdpStart = new javax.swing.JTabbedPane();
        pnlMoten = new javax.swing.JPanel();
        pnlBjudInTillMoten = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBjudInTillMote = new javax.swing.JTable();
        btnBjudIn = new javax.swing.JButton();
        lblTidMoten = new javax.swing.JLabel();
        lblPlatsMoten = new javax.swing.JLabel();
        txfTidMoten = new javax.swing.JTextField();
        txfPlatsMoten = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cbxSvaraPaMoten = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pnlFormellBlogg = new javax.swing.JPanel();
        lblValjKategori = new javax.swing.JLabel();
        cbKategori = new javax.swing.JComboBox<>();
        btnSkapaFormelltInlägg = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbFormellaInlagg = new javax.swing.JTable();
        btnVisaInlagg = new javax.swing.JButton();
        btnVisaValtInlagg = new javax.swing.JButton();
        txfFormellTitel = new javax.swing.JTextField();
        txfFormellDatum = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaFormellInlagg = new javax.swing.JTextArea();
        txfFormellFilvag = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnSparaFormellFil = new javax.swing.JButton();
        btnTaBortFormelltInlagg = new javax.swing.JButton();
        txfFormellForfattare = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txfFormelltID = new javax.swing.JTextField();
        pnlInformellBlogg = new javax.swing.JPanel();
        pnlForskning = new javax.swing.JPanel();
        lblUnderkategori = new javax.swing.JLabel();
        cbUnderkategori = new javax.swing.JComboBox<>();
        btnForskningVisaInlagg = new javax.swing.JButton();
        btnForskningSkapaInlagg = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblForskning = new javax.swing.JTable();
        btnForskningVisaValtInlagg = new javax.swing.JButton();
        lblForskningID = new javax.swing.JLabel();
        lblForskningForfattare = new javax.swing.JLabel();
        lblForskningTitel = new javax.swing.JLabel();
        lblForskningDatum = new javax.swing.JLabel();
        lblForskningInlagg = new javax.swing.JLabel();
        txfForskningID = new javax.swing.JTextField();
        txfForskningForfattare = new javax.swing.JTextField();
        txfForskningTitel = new javax.swing.JTextField();
        txfForskningDatum = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        txaForskningInlagg = new javax.swing.JTextArea();
        lblForskningFil = new javax.swing.JLabel();
        txfForskningFil = new javax.swing.JTextField();
        btnForskningTabort = new javax.swing.JButton();
        btnForskningSpara = new javax.swing.JButton();
        pnlUtbildning = new javax.swing.JPanel();
<<<<<<< HEAD
=======
        jScrollPane6 = new javax.swing.JScrollPane();
        tblUtbildning = new javax.swing.JTable();
        btnUtbildningSkapaInlagg = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txaUtbildningInlagg = new javax.swing.JTextArea();
        txfUtbildningID = new javax.swing.JTextField();
        txfUtbildningForfattare = new javax.swing.JTextField();
        txfUtbildningTitel = new javax.swing.JTextField();
        txfUtbildningDatum = new javax.swing.JTextField();
        txfUtbildningFil = new javax.swing.JTextField();
        btnUtbildningSpara = new javax.swing.JButton();
        btnVisaValtUtbildningInlagg = new javax.swing.JButton();
        btnUtbildningTaBort = new javax.swing.JButton();
        pnlProfil = new javax.swing.JPanel();
        pnlKalender = new javax.swing.JPanel();
>>>>>>> origin/master
        pnlLoggaUt = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();
        pnlProfil = new javax.swing.JPanel();
        lblProfilBild = new javax.swing.JLabel();
        pnlProfilInfo = new javax.swing.JPanel();
        lblProfilFornamn = new javax.swing.JLabel();
        lblProfilEfternamn = new javax.swing.JLabel();
        lblProfilTitel = new javax.swing.JLabel();
        btnProfilRedigera = new javax.swing.JButton();
        btnProfilSkickaMail = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbdpStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbdpStartMouseClicked(evt);
            }
        });

        pnlBjudInTillMoten.setBorder(javax.swing.BorderFactory.createTitledBorder("Här kan du skapa inbjudan till ett möte"));

        tblBjudInTillMote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Personer du kan bjuda in"
            }
        ));
        jScrollPane2.setViewportView(tblBjudInTillMote);

        btnBjudIn.setText("Bjud In");
        btnBjudIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBjudInActionPerformed(evt);
            }
        });

        lblTidMoten.setText("Tid:");

        lblPlatsMoten.setText("Plats:");

        jLabel1.setText("Välj datum för mötet:");

        javax.swing.GroupLayout pnlBjudInTillMotenLayout = new javax.swing.GroupLayout(pnlBjudInTillMoten);
        pnlBjudInTillMoten.setLayout(pnlBjudInTillMotenLayout);
        pnlBjudInTillMotenLayout.setHorizontalGroup(
            pnlBjudInTillMotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBjudInTillMotenLayout.createSequentialGroup()
                .addGroup(pnlBjudInTillMotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBjudInTillMotenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlBjudInTillMotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfTidMoten)
                            .addGroup(pnlBjudInTillMotenLayout.createSequentialGroup()
                                .addGroup(pnlBjudInTillMotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTidMoten)
                                    .addComponent(lblPlatsMoten))
                                .addGap(0, 125, Short.MAX_VALUE))
                            .addComponent(txfPlatsMoten)))
                    .addGroup(pnlBjudInTillMotenLayout.createSequentialGroup()
                        .addGroup(pnlBjudInTillMotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBjudInTillMotenLayout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(btnBjudIn))
                            .addGroup(pnlBjudInTillMotenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlBjudInTillMotenLayout.setVerticalGroup(
            pnlBjudInTillMotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBjudInTillMotenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(pnlBjudInTillMotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addGroup(pnlBjudInTillMotenLayout.createSequentialGroup()
                        .addComponent(lblTidMoten)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txfTidMoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(lblPlatsMoten)
                        .addGap(18, 18, 18)
                        .addComponent(txfPlatsMoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 211, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(btnBjudIn)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inbjudan till möten"));

        jLabel2.setText("Svara på om du kan komma på dessa möten:");

        jButton1.setText("Tacka ja");

        jButton2.setText("Tacka nej");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxSvaraPaMoten, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2)
                        .addGap(63, 63, 63))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cbxSvaraPaMoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMotenLayout = new javax.swing.GroupLayout(pnlMoten);
        pnlMoten.setLayout(pnlMotenLayout);
        pnlMotenLayout.setHorizontalGroup(
            pnlMotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMotenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBjudInTillMoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
        );
        pnlMotenLayout.setVerticalGroup(
            pnlMotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMotenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBjudInTillMoten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tbdpStart.addTab("Möten", pnlMoten);

        pnlFormellBlogg.setToolTipText("");

        lblValjKategori.setText("Välj kategori:");

        cbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Forskning", "Utbildning" }));

        btnSkapaFormelltInlägg.setText("Skapa inlägg");

        tbFormellaInlagg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Författare", "Titel", "Datum", "Inlägg", "Fil"
            }
        ));
        tbFormellaInlagg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFormellaInlaggMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbFormellaInlagg);
        tbFormellaInlagg.getAccessibleContext().setAccessibleName("");

        btnVisaInlagg.setText("Visa inlägg");
        btnVisaInlagg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaInlaggActionPerformed(evt);
            }
        });

        btnVisaValtInlagg.setText("Visa valt inlägg");
        btnVisaValtInlagg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaValtInlaggActionPerformed(evt);
            }
        });

        txfFormellTitel.setEditable(false);

        txfFormellDatum.setEditable(false);

        jLabel3.setText("Författare:");

        jLabel4.setText("Titel:");

        jLabel5.setText("Datum:");

        jLabel6.setText("Inlägg:");

        txaFormellInlagg.setEditable(false);
        txaFormellInlagg.setColumns(20);
        txaFormellInlagg.setLineWrap(true);
        txaFormellInlagg.setRows(10);
        txaFormellInlagg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane4.setViewportView(txaFormellInlagg);

        txfFormellFilvag.setEditable(false);

        jLabel7.setText("Fil:");

        btnSparaFormellFil.setText("Spara");

        btnTaBortFormelltInlagg.setText("Ta bort inlägg");
        btnTaBortFormelltInlagg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortFormelltInlaggActionPerformed(evt);
            }
        });

        txfFormellForfattare.setEditable(false);

        jLabel8.setText("ID:");

        txfFormelltID.setEditable(false);

        javax.swing.GroupLayout pnlFormellBloggLayout = new javax.swing.GroupLayout(pnlFormellBlogg);
        pnlFormellBlogg.setLayout(pnlFormellBloggLayout);
        pnlFormellBloggLayout.setHorizontalGroup(
            pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormellBloggLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlFormellBloggLayout.createSequentialGroup()
                        .addComponent(lblValjKategori)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
<<<<<<< HEAD
                        .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSkapaFormelltInlägg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
=======
                        .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVisaInlagg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVisaValtInlagg))
                    .addGroup(pnlFormellBloggLayout.createSequentialGroup()
                        .addComponent(btnSkapaFormelltInlägg, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(5, 5, 5)
                .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTaBortFormelltInlagg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addComponent(txfFormellDatum)
                    .addComponent(txfFormellTitel)
                    .addComponent(txfFormellForfattare)
                    .addComponent(txfFormelltID)
                    .addGroup(pnlFormellBloggLayout.createSequentialGroup()
                        .addComponent(txfFormellFilvag, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSparaFormellFil)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
>>>>>>> origin/master
        );
        pnlFormellBloggLayout.setVerticalGroup(
            pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormellBloggLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValjKategori)
                    .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVisaInlagg)
                    .addComponent(btnVisaValtInlagg))
                .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormellBloggLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormellBloggLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txfFormelltID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txfFormellForfattare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txfFormellTitel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txfFormellDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txfFormellFilvag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(btnSparaFormellFil)))
                            .addGroup(pnlFormellBloggLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addComponent(btnTaBortFormelltInlagg)
                        .addGap(46, 46, 46))
                    .addGroup(pnlFormellBloggLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnSkapaFormelltInlägg)
<<<<<<< HEAD
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)))
=======
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
>>>>>>> origin/master
        );

        tbdpStart.addTab("Formella bloggen", pnlFormellBlogg);

        javax.swing.GroupLayout pnlInformellBloggLayout = new javax.swing.GroupLayout(pnlInformellBlogg);
        pnlInformellBlogg.setLayout(pnlInformellBloggLayout);
        pnlInformellBloggLayout.setHorizontalGroup(
            pnlInformellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
            .addGap(0, 804, Short.MAX_VALUE)
=======
            .addGap(0, 954, Short.MAX_VALUE)
>>>>>>> origin/master
        );
        pnlInformellBloggLayout.setVerticalGroup(
            pnlInformellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
            .addGap(0, 471, Short.MAX_VALUE)
=======
            .addGap(0, 493, Short.MAX_VALUE)
>>>>>>> origin/master
        );

        tbdpStart.addTab("Informella bloggen", pnlInformellBlogg);

<<<<<<< HEAD
        javax.swing.GroupLayout pnlMotenLayout = new javax.swing.GroupLayout(pnlMoten);
        pnlMoten.setLayout(pnlMotenLayout);
        pnlMotenLayout.setHorizontalGroup(
            pnlMotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        pnlMotenLayout.setVerticalGroup(
            pnlMotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );
=======
        lblUnderkategori.setText("Välj underkategori:");
>>>>>>> origin/master

        btnForskningVisaInlagg.setText("Visa inlägg");
        btnForskningVisaInlagg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForskningVisaInlaggActionPerformed(evt);
            }
        });

        btnForskningSkapaInlagg.setText("Skapa inlägg");

        tblForskning.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Författare", "Titel", "Datum", "Inlägg", "Fil"
            }
        ));
        tblForskning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblForskningMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblForskning);

        btnForskningVisaValtInlagg.setText("Visa valt inlägg");
        btnForskningVisaValtInlagg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForskningVisaValtInlaggActionPerformed(evt);
            }
        });

        lblForskningID.setText("ID:");

        lblForskningForfattare.setText("Författare:");

        lblForskningTitel.setText("Titel:");

        lblForskningDatum.setText("Datum:");

        lblForskningInlagg.setText("Inlägg:");

        txfForskningID.setEditable(false);

        txfForskningForfattare.setEditable(false);

        txfForskningTitel.setEditable(false);

        txfForskningDatum.setEditable(false);

        txaForskningInlagg.setEditable(false);
        txaForskningInlagg.setColumns(20);
        txaForskningInlagg.setLineWrap(true);
        txaForskningInlagg.setRows(5);
        jScrollPane5.setViewportView(txaForskningInlagg);

        lblForskningFil.setText("Fil:");

        txfForskningFil.setEditable(false);

        btnForskningTabort.setText("Ta bort inlägg");
        btnForskningTabort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForskningTabortActionPerformed(evt);
            }
        });

        btnForskningSpara.setText("Spara");

        javax.swing.GroupLayout pnlForskningLayout = new javax.swing.GroupLayout(pnlForskning);
        pnlForskning.setLayout(pnlForskningLayout);
        pnlForskningLayout.setHorizontalGroup(
            pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
            .addGap(0, 804, Short.MAX_VALUE)
=======
            .addGroup(pnlForskningLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlForskningLayout.createSequentialGroup()
                        .addComponent(lblUnderkategori)
                        .addGap(4, 4, 4)
                        .addComponent(cbUnderkategori, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnForskningVisaInlagg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnForskningVisaValtInlagg))
                    .addGroup(pnlForskningLayout.createSequentialGroup()
                        .addComponent(btnForskningSkapaInlagg)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblForskningDatum)
                    .addGroup(pnlForskningLayout.createSequentialGroup()
                        .addGroup(pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblForskningForfattare)
                            .addComponent(lblForskningID)
                            .addComponent(lblForskningTitel)
                            .addComponent(lblForskningInlagg)
                            .addComponent(lblForskningFil))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnForskningTabort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txfForskningDatum)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlForskningLayout.createSequentialGroup()
                                .addComponent(txfForskningFil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnForskningSpara, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txfForskningForfattare)
                            .addComponent(txfForskningID)
                            .addComponent(txfForskningTitel))))
                .addContainerGap(86, Short.MAX_VALUE))
>>>>>>> origin/master
        );
        pnlForskningLayout.setVerticalGroup(
            pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
            .addGap(0, 471, Short.MAX_VALUE)
=======
            .addGroup(pnlForskningLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnderkategori)
                    .addComponent(cbUnderkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnForskningVisaInlagg)
                    .addComponent(btnForskningVisaValtInlagg))
                .addGroup(pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlForskningLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlForskningLayout.createSequentialGroup()
                                .addComponent(btnForskningSkapaInlagg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 368, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(pnlForskningLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblForskningID)
                            .addComponent(txfForskningID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblForskningForfattare)
                            .addComponent(txfForskningForfattare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblForskningTitel)
                            .addComponent(txfForskningTitel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblForskningDatum)
                            .addComponent(txfForskningDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblForskningInlagg)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblForskningFil)
                            .addGroup(pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txfForskningFil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnForskningSpara)))
                        .addGap(18, 18, 18)
                        .addComponent(btnForskningTabort)))
                .addGap(42, 42, 42))
>>>>>>> origin/master
        );

        tbdpStart.addTab("Forskning", pnlForskning);

        tblUtbildning.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Författare", "Titel", "Datum", "Inlägg", "Fil"
            }
        ));
        tblUtbildning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUtbildningMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblUtbildning);

        btnUtbildningSkapaInlagg.setText("Skapa inlägg");
        btnUtbildningSkapaInlagg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUtbildningSkapaInlaggActionPerformed(evt);
            }
        });

        jLabel9.setText("ID:");

        jLabel10.setText("Författare:");

        jLabel11.setText("Titel:");

        jLabel12.setText("Datum:");

        jLabel13.setText("Inlägg:");

        jLabel14.setText("Fil:");

        txaUtbildningInlagg.setEditable(false);
        txaUtbildningInlagg.setColumns(20);
        txaUtbildningInlagg.setLineWrap(true);
        txaUtbildningInlagg.setRows(5);
        jScrollPane7.setViewportView(txaUtbildningInlagg);

        txfUtbildningID.setEditable(false);

        txfUtbildningForfattare.setEditable(false);

        txfUtbildningTitel.setEditable(false);

        txfUtbildningDatum.setEditable(false);

        txfUtbildningFil.setEditable(false);

        btnUtbildningSpara.setText("Spara");
        btnUtbildningSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUtbildningSparaActionPerformed(evt);
            }
        });

        btnVisaValtUtbildningInlagg.setText("Visa valt inlägg");
        btnVisaValtUtbildningInlagg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaValtUtbildningInlaggActionPerformed(evt);
            }
        });

        btnUtbildningTaBort.setText("Ta bort inlägg");
        btnUtbildningTaBort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUtbildningTaBortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUtbildningLayout = new javax.swing.GroupLayout(pnlUtbildning);
        pnlUtbildning.setLayout(pnlUtbildningLayout);
        pnlUtbildningLayout.setHorizontalGroup(
            pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
            .addGap(0, 804, Short.MAX_VALUE)
=======
            .addGroup(pnlUtbildningLayout.createSequentialGroup()
                .addGroup(pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlUtbildningLayout.createSequentialGroup()
                        .addComponent(btnUtbildningSkapaInlagg, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVisaValtUtbildningInlagg))
                .addGap(29, 29, 29)
                .addGroup(pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUtbildningTaBort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13)
                    .addGroup(pnlUtbildningLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txfUtbildningFil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUtbildningSpara))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addGroup(pnlUtbildningLayout.createSequentialGroup()
                        .addGroup(pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfUtbildningForfattare, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(txfUtbildningID)
                            .addComponent(txfUtbildningTitel)
                            .addComponent(txfUtbildningDatum))))
                .addContainerGap(95, Short.MAX_VALUE))
>>>>>>> origin/master
        );
        pnlUtbildningLayout.setVerticalGroup(
            pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
            .addGap(0, 471, Short.MAX_VALUE)
=======
            .addGroup(pnlUtbildningLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txfUtbildningID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txfUtbildningForfattare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txfUtbildningTitel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txfUtbildningDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txfUtbildningFil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUtbildningSpara))
                .addGap(28, 28, 28)
                .addComponent(btnUtbildningTaBort)
                .addGap(87, 87, 87))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUtbildningLayout.createSequentialGroup()
                .addComponent(btnVisaValtUtbildningInlagg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUtbildningSkapaInlagg)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(199, 199, 199))
>>>>>>> origin/master
        );

        tbdpStart.addTab("Utbildning", pnlUtbildning);
<<<<<<< HEAD
=======

        javax.swing.GroupLayout pnlProfilLayout = new javax.swing.GroupLayout(pnlProfil);
        pnlProfil.setLayout(pnlProfilLayout);
        pnlProfilLayout.setHorizontalGroup(
            pnlProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 954, Short.MAX_VALUE)
        );
        pnlProfilLayout.setVerticalGroup(
            pnlProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );

        tbdpStart.addTab("Profil", pnlProfil);

        javax.swing.GroupLayout pnlKalenderLayout = new javax.swing.GroupLayout(pnlKalender);
        pnlKalender.setLayout(pnlKalenderLayout);
        pnlKalenderLayout.setHorizontalGroup(
            pnlKalenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 954, Short.MAX_VALUE)
        );
        pnlKalenderLayout.setVerticalGroup(
            pnlKalenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );

        tbdpStart.addTab("Kalender", pnlKalender);
>>>>>>> origin/master

        btnLogOut.setText("Logga ut");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLoggaUtLayout = new javax.swing.GroupLayout(pnlLoggaUt);
        pnlLoggaUt.setLayout(pnlLoggaUtLayout);
        pnlLoggaUtLayout.setHorizontalGroup(
            pnlLoggaUtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoggaUtLayout.createSequentialGroup()
<<<<<<< HEAD
                .addContainerGap(680, Short.MAX_VALUE)
=======
                .addContainerGap(490, Short.MAX_VALUE)
>>>>>>> origin/master
                .addComponent(btnLogOut)
                .addGap(389, 389, 389))
        );
        pnlLoggaUtLayout.setVerticalGroup(
            pnlLoggaUtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoggaUtLayout.createSequentialGroup()
<<<<<<< HEAD
                .addContainerGap(426, Short.MAX_VALUE)
=======
                .addContainerGap(239, Short.MAX_VALUE)
>>>>>>> origin/master
                .addComponent(btnLogOut)
                .addGap(229, 229, 229))
        );

        tbdpStart.addTab("Logga ut", pnlLoggaUt);

        lblProfilBild.setText("Profilbild");

        lblProfilFornamn.setText("Förnamn");

        lblProfilEfternamn.setText("Efternamn");

        lblProfilTitel.setText("Titel");

        btnProfilRedigera.setText("Redigera profil");

        btnProfilSkickaMail.setText("Skicka mail");
        btnProfilSkickaMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfilSkickaMailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProfilInfoLayout = new javax.swing.GroupLayout(pnlProfilInfo);
        pnlProfilInfo.setLayout(pnlProfilInfoLayout);
        pnlProfilInfoLayout.setHorizontalGroup(
            pnlProfilInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProfilEfternamn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblProfilTitel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlProfilInfoLayout.createSequentialGroup()
                .addGroup(pnlProfilInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProfilFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProfilRedigera, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProfilSkickaMail, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 152, Short.MAX_VALUE))
        );
        pnlProfilInfoLayout.setVerticalGroup(
            pnlProfilInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfilInfoLayout.createSequentialGroup()
                .addComponent(lblProfilFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProfilEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProfilTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(btnProfilSkickaMail, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProfilRedigera, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlProfilLayout = new javax.swing.GroupLayout(pnlProfil);
        pnlProfil.setLayout(pnlProfilLayout);
        pnlProfilLayout.setHorizontalGroup(
            pnlProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfilLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(lblProfilBild, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(pnlProfilInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        pnlProfilLayout.setVerticalGroup(
            pnlProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfilLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblProfilBild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlProfilInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        tbdpStart.addTab("Profil", pnlProfil);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbdpStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
            .addComponent(tbdpStart)
=======
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addComponent(tbdpStart, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
>>>>>>> origin/master
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        try {
            SQLConnection.getDatabas().executeUpdate("UPDATE Anvandare SET Inloggad = 0");
            
            this.dispose();
            LoginFrame s = new LoginFrame();
            s.setVisible(true);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }//GEN-LAST:event_btnLogOutActionPerformed

<<<<<<< HEAD
    private void btnProfilSkickaMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfilSkickaMailActionPerformed
       new MailFrame().setVisible(true);
    }//GEN-LAST:event_btnProfilSkickaMailActionPerformed
=======
    private void dpMoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpMoteActionPerformed
        try {
            
            DefaultTableModel anstalldaModel = (DefaultTableModel) tblBjudInTillMote.getModel();
            anstalldaModel.setRowCount(0);
            
            ResultSet rs = SQLConnection.getDatabas().executeQuery("SELECT Namn FROM Anvandare");

            String namn = "";
            while(rs.next()) { 
                namn = rs.getString("Namn");
                anstalldaModel.insertRow(tblBjudInTillMote.getRowCount(), new Object[] {namn});
            } 
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_dpMoteActionPerformed

    private void btnBjudInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBjudInActionPerformed
        try {
            DatePicker datePicker = new DatePicker(LocalDate.now());
            LocalDate localDate = datePicker.getValue();
            //cbxSvaraPaMoten.addItem(MÖTEN);
            txfTidMoten.getText();
            txfPlatsMoten.getText();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnBjudInActionPerformed

    private void btnVisaInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaInlaggActionPerformed
        fyllListaMedInlagg();
    }//GEN-LAST:event_btnVisaInlaggActionPerformed

    private void btnVisaValtInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaValtInlaggActionPerformed
        try{
               
        int i = tbFormellaInlagg.getSelectedRow();
        TableModel model = tbFormellaInlagg.getModel();
        txfFormelltID.setText(model.getValueAt(i, 0).toString());
        txfFormellForfattare.setText(model.getValueAt(i, 1).toString());
        txfFormellTitel.setText(model.getValueAt(i, 2).toString());
        txfFormellDatum.setText(model.getValueAt(i, 3).toString());
        txaFormellInlagg.setText(model.getValueAt(i, 4).toString());
        if(model.getValueAt(i, 5) == null){
            txfFormellFilvag.setText("Ingen fil finns");
        }else{
        txfFormellFilvag.setText(model.getValueAt(i, 5).toString());
        }
        
        String inlaggsId = txfFormelltID.getText();
        int inlaggsIdInt = Integer.parseInt(inlaggsId);
        
          ResultSet rs = SQLConnection.getDatabas().executeQuery("select Anvandare.ID from Anvandare\n" +
                                                                    "join FormelltInlagg\n" +
                                                                    "on Forfattare = Anvandare.ID\n" +
                                                                    "where FormelltInlagg.ID =" + inlaggsIdInt + "\n" +
                                                                    "and Inloggad = 1;");  
          
          if(rs.next()){
            btnTaBortFormelltInlagg.setVisible(true);
            }
          else{
              btnTaBortFormelltInlagg.setVisible(false);
            }     
    }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
    }//GEN-LAST:event_btnVisaValtInlaggActionPerformed

    private void btnTaBortFormelltInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortFormelltInlaggActionPerformed
        try{
            String id = txfFormelltID.getText();
            int intId = Integer.parseInt(id);
            SQLConnection.getDatabas().executeUpdate("delete from FormelltInlagg where id =" + intId);  
            
            txfFormellForfattare.setText("");
            txfFormellTitel.setText("");
            txfFormellDatum.setText("");
            txaFormellInlagg.setText("");
            txfFormellFilvag.setText("");
             txfFormelltID.setText("");
             
            JOptionPane.showMessageDialog(this, "Inlägget är nu borttaget");
            fyllListaMedInlagg();
        }
        catch(Exception e){
           System.out.println(e.getMessage()); 
        }
    }//GEN-LAST:event_btnTaBortFormelltInlaggActionPerformed

    private void tbdpStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdpStartMouseClicked
        btnTaBortFormelltInlagg.setVisible(false);
        btnForskningTabort.setVisible(false);
        btnUtbildningTaBort.setVisible(false);
        fyllUtbildningsListaMedInlagg();
    }//GEN-LAST:event_tbdpStartMouseClicked

    private void tbFormellaInlaggMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFormellaInlaggMouseClicked
        txfFormelltID.setText("");
        txfFormellForfattare.setText("");
        txfFormellTitel.setText("");
        txfFormellDatum.setText("");
        txfFormellFilvag.setText("");
        txaFormellInlagg.setText("");
    }//GEN-LAST:event_tbFormellaInlaggMouseClicked

    private void btnForskningVisaInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForskningVisaInlaggActionPerformed
        fyllListaMedForskningsInlagg();
    }//GEN-LAST:event_btnForskningVisaInlaggActionPerformed

    private void btnForskningVisaValtInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForskningVisaValtInlaggActionPerformed
       try{
               
        int i = tblForskning.getSelectedRow();
        TableModel model = tblForskning.getModel();
        txfForskningForfattare.setText(model.getValueAt(i, 1).toString());
        txfForskningTitel.setText(model.getValueAt(i, 2).toString());
        txfForskningDatum.setText(model.getValueAt(i, 3).toString());
        txaForskningInlagg.setText(model.getValueAt(i, 4).toString());
        txfForskningID.setText(model.getValueAt(i, 0).toString());
        if(model.getValueAt(i, 5) == null){
        txfForskningFil.setText("Ingen fil finns");
        }else{
          txfForskningFil.setText(model.getValueAt(i, 5).toString());  
        }
        String inlaggsId = txfForskningID.getText();
        int inlaggsIdInt = Integer.parseInt(inlaggsId);
        
          ResultSet rs = SQLConnection.getDatabas().executeQuery("select Anvandare.ID from Anvandare\n" +
                                                                    "join Forskning\n" +
                                                                    "on Forfattare = Anvandare.ID\n" +
                                                                    "where Forskning.ID =" + inlaggsIdInt + "\n" +
                                                                    "and Inloggad = 1;");  
          
          if(rs.next()){
            btnForskningTabort.setVisible(true);
            }
          else{
              btnForskningTabort.setVisible(false);
            }     
    }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
    }//GEN-LAST:event_btnForskningVisaValtInlaggActionPerformed

    private void tblForskningMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblForskningMouseClicked
        txfForskningID.setText("");
        txfForskningForfattare.setText("");
        txfForskningTitel.setText("");
        txfForskningDatum.setText("");
        txaForskningInlagg.setText("");
        txfForskningFil.setText("");
    }//GEN-LAST:event_tblForskningMouseClicked

    private void btnForskningTabortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForskningTabortActionPerformed
         try{
            String id = txfForskningID.getText();
            int intId = Integer.parseInt(id);
            SQLConnection.getDatabas().executeUpdate("delete from Forskning where id =" + intId);  
            
            txfForskningForfattare.setText("");
            txfForskningTitel.setText("");
            txfForskningDatum.setText("");
            txaForskningInlagg.setText("");
            txfForskningID.setText("");
            txfForskningFil.setText("");
             
            JOptionPane.showMessageDialog(this, "Inlägget är nu borttaget");
            fyllListaMedForskningsInlagg();
        }
        catch(Exception e){
           System.out.println(e.getMessage()); 
        }
    }//GEN-LAST:event_btnForskningTabortActionPerformed

    private void btnUtbildningSkapaInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUtbildningSkapaInlaggActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUtbildningSkapaInlaggActionPerformed

    private void btnUtbildningSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUtbildningSparaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUtbildningSparaActionPerformed

    private void btnVisaValtUtbildningInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaValtUtbildningInlaggActionPerformed
       try{
               
        int i = tblUtbildning.getSelectedRow();
        TableModel model = tblUtbildning.getModel();
        txfUtbildningForfattare.setText(model.getValueAt(i, 1).toString());
        txfUtbildningTitel.setText(model.getValueAt(i, 2).toString());
        txfUtbildningDatum.setText(model.getValueAt(i, 3).toString());
        txaUtbildningInlagg.setText(model.getValueAt(i, 4).toString());
        txfUtbildningID.setText(model.getValueAt(i, 0).toString());
        if(model.getValueAt(i, 5) == null){
          txfUtbildningFil.setText("Ingen fil finns");  
        }else{
        txfUtbildningFil.setText(model.getValueAt(i, 5).toString());
        }
        String inlaggsId = txfUtbildningID.getText();
        int inlaggsIdInt = Integer.parseInt(inlaggsId);
        
          ResultSet rs = SQLConnection.getDatabas().executeQuery("select Anvandare.ID from Anvandare\n" +
                                                                    "join Utbildning\n" +
                                                                    "on Forfattare = Anvandare.ID\n" +
                                                                    "where Utbildning.ID =" + inlaggsIdInt + "\n" +
                                                                    "and Inloggad = 1;"); 
          
          if(rs.next()){
            btnUtbildningTaBort.setVisible(true);
            }
          else{
              btnUtbildningTaBort.setVisible(false);
            }     
    }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
    }//GEN-LAST:event_btnVisaValtUtbildningInlaggActionPerformed

    private void btnUtbildningTaBortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUtbildningTaBortActionPerformed
               try{
            String id = txfUtbildningID.getText();
            int intId = Integer.parseInt(id);
            SQLConnection.getDatabas().executeUpdate("delete from Utbildning where id =" + intId);  
            
            txfUtbildningForfattare.setText("");
            txfUtbildningTitel.setText("");
            txfUtbildningDatum.setText("");
            txaUtbildningInlagg.setText("");
            txfUtbildningFil.setText("");
            txfUtbildningID.setText("");
             
            JOptionPane.showMessageDialog(this, "Inlägget är nu borttaget");
            fyllUtbildningsListaMedInlagg();
        }
        catch(Exception e){
           System.out.println(e.getMessage()); 
        }
    }//GEN-LAST:event_btnUtbildningTaBortActionPerformed

    private void tblUtbildningMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUtbildningMouseClicked
        txfUtbildningID.setText("");
        txfUtbildningForfattare.setText("");
        txfUtbildningTitel.setText("");
        txfUtbildningDatum.setText("");
        txaUtbildningInlagg.setText("");
        txfUtbildningFil.setText("");
    }//GEN-LAST:event_tblUtbildningMouseClicked
>>>>>>> origin/master

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartPageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartPageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartPageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartPageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartPageFrame().setVisible(true);
            }
        });
        
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBjudIn;
    private javax.swing.JButton btnForskningSkapaInlagg;
    private javax.swing.JButton btnForskningSpara;
    private javax.swing.JButton btnForskningTabort;
    private javax.swing.JButton btnForskningVisaInlagg;
    private javax.swing.JButton btnForskningVisaValtInlagg;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnProfilRedigera;
    private javax.swing.JButton btnProfilSkickaMail;
    private javax.swing.JButton btnSkapaFormelltInlägg;
    private javax.swing.JButton btnSparaFormellFil;
    private javax.swing.JButton btnTaBortFormelltInlagg;
    private javax.swing.JButton btnUtbildningSkapaInlagg;
    private javax.swing.JButton btnUtbildningSpara;
    private javax.swing.JButton btnUtbildningTaBort;
    private javax.swing.JButton btnVisaInlagg;
    private javax.swing.JButton btnVisaValtInlagg;
    private javax.swing.JButton btnVisaValtUtbildningInlagg;
    private javax.swing.JComboBox<String> cbKategori;
    private javax.swing.JComboBox<String> cbUnderkategori;
    private javax.swing.JComboBox<String> cbxSvaraPaMoten;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
<<<<<<< HEAD
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblProfilBild;
    private javax.swing.JLabel lblProfilEfternamn;
    private javax.swing.JLabel lblProfilFornamn;
    private javax.swing.JLabel lblProfilTitel;
=======
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblForskningDatum;
    private javax.swing.JLabel lblForskningFil;
    private javax.swing.JLabel lblForskningForfattare;
    private javax.swing.JLabel lblForskningID;
    private javax.swing.JLabel lblForskningInlagg;
    private javax.swing.JLabel lblForskningTitel;
    private javax.swing.JLabel lblPlatsMoten;
    private javax.swing.JLabel lblTidMoten;
    private javax.swing.JLabel lblUnderkategori;
>>>>>>> origin/master
    private javax.swing.JLabel lblValjKategori;
    private javax.swing.JPanel pnlBjudInTillMoten;
    private javax.swing.JPanel pnlFormellBlogg;
    private javax.swing.JPanel pnlForskning;
    private javax.swing.JPanel pnlInformellBlogg;
    private javax.swing.JPanel pnlKalender;
    private javax.swing.JPanel pnlLoggaUt;
    private javax.swing.JPanel pnlMoten;
    private javax.swing.JPanel pnlProfil;
    private javax.swing.JPanel pnlProfilInfo;
    private javax.swing.JPanel pnlUtbildning;
    private javax.swing.JTable tbFormellaInlagg;
    private javax.swing.JTabbedPane tbdpStart;
    private javax.swing.JTable tblBjudInTillMote;
    private javax.swing.JTable tblForskning;
    private javax.swing.JTable tblUtbildning;
    private javax.swing.JTextArea txaFormellInlagg;
    private javax.swing.JTextArea txaForskningInlagg;
    private javax.swing.JTextArea txaUtbildningInlagg;
    private javax.swing.JTextField txfFormellDatum;
    private javax.swing.JTextField txfFormellFilvag;
    private javax.swing.JTextField txfFormellForfattare;
    private javax.swing.JTextField txfFormellTitel;
    private javax.swing.JTextField txfFormelltID;
    private javax.swing.JTextField txfForskningDatum;
    private javax.swing.JTextField txfForskningFil;
    private javax.swing.JTextField txfForskningForfattare;
    private javax.swing.JTextField txfForskningID;
    private javax.swing.JTextField txfForskningTitel;
    private javax.swing.JTextField txfPlatsMoten;
    private javax.swing.JTextField txfTidMoten;
    private javax.swing.JTextField txfUtbildningDatum;
    private javax.swing.JTextField txfUtbildningFil;
    private javax.swing.JTextField txfUtbildningForfattare;
    private javax.swing.JTextField txfUtbildningID;
    private javax.swing.JTextField txfUtbildningTitel;
    // End of variables declaration//GEN-END:variables
}
