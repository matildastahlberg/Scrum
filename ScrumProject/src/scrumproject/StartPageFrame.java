/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumproject;

import java.sql.ResultSet;
import java.time.LocalDate;
import javafx.scene.control.DatePicker;
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
    }
    
    public void fyllListaMedInlagg(){
        try{
           DefaultTableModel inlaggsaModell = (DefaultTableModel) tbFormellaInlagg.getModel();
            inlaggsaModell.setRowCount(0);
            
            String kategori = cbKategori.getSelectedItem().toString();
            ResultSet rs = SQLConnection.getDatabas().executeQuery("select namn, titel, datum, text, FormelltInlagg.Id from FormelltInlagg join Anvandare on Anvandare.ID = FormelltInlagg.Forfattare where Kategori = '" + kategori + "'" + "Order by datum DESC");

            String namn = "";
            String titel = "";
            String datum = "";
            String text = "";
            String id = "";
            while(rs.next()) { 
                namn = rs.getString(1);
                titel = rs.getString(2);
                datum = rs.getString(3);
                text = rs.getString(4);
                id = rs.getString(5);
                inlaggsaModell.insertRow(tbFormellaInlagg.getRowCount(), new Object[] {namn, titel, datum, text, id});
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
        pnlInformellBlogg = new javax.swing.JPanel();
        pnlMoten = new javax.swing.JPanel();
        pnlBjudInTillMoten = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBjudInTillMote = new javax.swing.JTable();
        dpMote = new org.jdesktop.swingx.JXDatePicker();
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
        pnlForskning = new javax.swing.JPanel();
        pnlUtbildning = new javax.swing.JPanel();
        pnlProfil = new javax.swing.JPanel();
        pnlLoggaUt = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();
        pnlKalender = new javax.swing.JPanel();
        Kalender = new com.toedter.calendar.JCalendar();
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
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnSparaFormellFil = new javax.swing.JButton();
        btnTaBortFormelltInlagg = new javax.swing.JButton();
        txfFormellForfattare = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txfFormelltID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbdpStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbdpStartMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlInformellBloggLayout = new javax.swing.GroupLayout(pnlInformellBlogg);
        pnlInformellBlogg.setLayout(pnlInformellBloggLayout);
        pnlInformellBloggLayout.setHorizontalGroup(
            pnlInformellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 914, Short.MAX_VALUE)
        );
        pnlInformellBloggLayout.setVerticalGroup(
            pnlInformellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );

        tbdpStart.addTab("Informella bloggen", pnlInformellBlogg);

        pnlBjudInTillMoten.setBorder(javax.swing.BorderFactory.createTitledBorder("Här kan du skapa inbjudan till ett möte"));

        tblBjudInTillMote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Personer du kan bjuda in"
            }
        ));
        jScrollPane2.setViewportView(tblBjudInTillMote);

        dpMote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpMoteActionPerformed(evt);
            }
        });

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
                        .addGap(95, 95, 95)
                        .addComponent(btnBjudIn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlBjudInTillMotenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(dpMote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlBjudInTillMotenLayout.setVerticalGroup(
            pnlBjudInTillMotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBjudInTillMotenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBjudInTillMotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpMote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(pnlBjudInTillMotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlBjudInTillMotenLayout.createSequentialGroup()
                        .addComponent(lblTidMoten)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txfTidMoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(lblPlatsMoten)
                        .addGap(18, 18, 18)
                        .addComponent(txfPlatsMoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 133, Short.MAX_VALUE)))
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
                .addContainerGap(166, Short.MAX_VALUE))
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

        javax.swing.GroupLayout pnlForskningLayout = new javax.swing.GroupLayout(pnlForskning);
        pnlForskning.setLayout(pnlForskningLayout);
        pnlForskningLayout.setHorizontalGroup(
            pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 914, Short.MAX_VALUE)
        );
        pnlForskningLayout.setVerticalGroup(
            pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );

        tbdpStart.addTab("Forskning", pnlForskning);

        javax.swing.GroupLayout pnlUtbildningLayout = new javax.swing.GroupLayout(pnlUtbildning);
        pnlUtbildning.setLayout(pnlUtbildningLayout);
        pnlUtbildningLayout.setHorizontalGroup(
            pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 914, Short.MAX_VALUE)
        );
        pnlUtbildningLayout.setVerticalGroup(
            pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );

        tbdpStart.addTab("Utbildning", pnlUtbildning);

        javax.swing.GroupLayout pnlProfilLayout = new javax.swing.GroupLayout(pnlProfil);
        pnlProfil.setLayout(pnlProfilLayout);
        pnlProfilLayout.setHorizontalGroup(
            pnlProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 914, Short.MAX_VALUE)
        );
        pnlProfilLayout.setVerticalGroup(
            pnlProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );

        tbdpStart.addTab("Profil", pnlProfil);

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
            .addGroup(pnlLoggaUtLayout.createSequentialGroup()
                .addContainerGap(810, Short.MAX_VALUE)
                .addComponent(btnLogOut)
                .addGap(29, 29, 29))
        );
        pnlLoggaUtLayout.setVerticalGroup(
            pnlLoggaUtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoggaUtLayout.createSequentialGroup()
                .addContainerGap(439, Short.MAX_VALUE)
                .addComponent(btnLogOut)
                .addContainerGap())
        );

        tbdpStart.addTab("Logga ut", pnlLoggaUt);

        javax.swing.GroupLayout pnlKalenderLayout = new javax.swing.GroupLayout(pnlKalender);
        pnlKalender.setLayout(pnlKalenderLayout);
        pnlKalenderLayout.setHorizontalGroup(
            pnlKalenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKalenderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Kalender, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );
        pnlKalenderLayout.setVerticalGroup(
            pnlKalenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKalenderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Kalender, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbdpStart.addTab("Kalender", pnlKalender);

        pnlFormellBlogg.setToolTipText("");

        lblValjKategori.setText("Välj kategori:");

        cbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Forskning", "Utbildning" }));

        btnSkapaFormelltInlägg.setText("Skapa inlägg");

        tbFormellaInlagg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Författare", "Titel", "Datum", "Inlägg", "ID"
            }
        ));
        jScrollPane3.setViewportView(tbFormellaInlagg);

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
        txaFormellInlagg.setRows(10);
        txaFormellInlagg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane4.setViewportView(txaFormellInlagg);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormellBloggLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlFormellBloggLayout.createSequentialGroup()
                        .addComponent(lblValjKategori)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSkapaFormelltInlägg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFormellBloggLayout.createSequentialGroup()
                        .addComponent(btnVisaInlagg)
                        .addGap(266, 266, 266)
                        .addComponent(btnVisaValtInlagg))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormellBloggLayout.createSequentialGroup()
                        .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txfFormellTitel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(txfFormellForfattare, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfFormellDatum)))
                    .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnTaBortFormelltInlagg, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlFormellBloggLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txfFormelltID, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlFormellBloggLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSparaFormellFil)))))
                .addContainerGap(23, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormellBloggLayout.createSequentialGroup()
                        .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSkapaFormelltInlägg)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(132, 132, 132))
                    .addGroup(pnlFormellBloggLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txfFormelltID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txfFormellForfattare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(txfFormellTitel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfFormellDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFormellBloggLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(btnSparaFormellFil))
                        .addGap(18, 18, 18)
                        .addComponent(btnTaBortFormelltInlagg)
                        .addGap(68, 68, 68))))
        );

        tbdpStart.addTab("Formella bloggen", pnlFormellBlogg);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tbdpStart, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbdpStart, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        txfFormellTitel.setText(model.getValueAt(i, 0).toString());
        txfFormellDatum.setText(model.getValueAt(i, 1).toString());
        txfFormellDatum.setText(model.getValueAt(i, 2).toString());
        txaFormellInlagg.setText(model.getValueAt(i, 3).toString());
        txfFormelltID.setText(model.getValueAt(i, 4).toString());
        
          ResultSet rs = SQLConnection.getDatabas().executeQuery("Select ID from Anvandare Where Inloggad = 1");
          int ID = rs.getInt(1);
          String IDs = model.getValueAt(i, 4).toString();
          int IDi = Integer.parseInt(IDs);
          
          if(ID == IDi ){
            btnTaBortFormelltInlagg.setVisible(true);
        }
            
            
            

       }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
    }//GEN-LAST:event_btnVisaValtInlaggActionPerformed

    private void btnTaBortFormelltInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortFormelltInlaggActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTaBortFormelltInlaggActionPerformed

    private void tbdpStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdpStartMouseClicked
        btnTaBortFormelltInlagg.setVisible(false);
    }//GEN-LAST:event_tbdpStartMouseClicked

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
    private com.toedter.calendar.JCalendar Kalender;
    private javax.swing.JButton btnBjudIn;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnSkapaFormelltInlägg;
    private javax.swing.JButton btnSparaFormellFil;
    private javax.swing.JButton btnTaBortFormelltInlagg;
    private javax.swing.JButton btnVisaInlagg;
    private javax.swing.JButton btnVisaValtInlagg;
    private javax.swing.JComboBox<String> cbKategori;
    private javax.swing.JComboBox<String> cbxSvaraPaMoten;
    private org.jdesktop.swingx.JXDatePicker dpMote;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblPlatsMoten;
    private javax.swing.JLabel lblTidMoten;
    private javax.swing.JLabel lblValjKategori;
    private javax.swing.JPanel pnlBjudInTillMoten;
    private javax.swing.JPanel pnlFormellBlogg;
    private javax.swing.JPanel pnlForskning;
    private javax.swing.JPanel pnlInformellBlogg;
    private javax.swing.JPanel pnlKalender;
    private javax.swing.JPanel pnlLoggaUt;
    private javax.swing.JPanel pnlMoten;
    private javax.swing.JPanel pnlProfil;
    private javax.swing.JPanel pnlUtbildning;
    private javax.swing.JTable tbFormellaInlagg;
    private javax.swing.JTabbedPane tbdpStart;
    private javax.swing.JTable tblBjudInTillMote;
    private javax.swing.JTextArea txaFormellInlagg;
    private javax.swing.JTextField txfFormellDatum;
    private javax.swing.JTextField txfFormellForfattare;
    private javax.swing.JTextField txfFormellTitel;
    private javax.swing.JTextField txfFormelltID;
    private javax.swing.JTextField txfPlatsMoten;
    private javax.swing.JTextField txfTidMoten;
    // End of variables declaration//GEN-END:variables
}
