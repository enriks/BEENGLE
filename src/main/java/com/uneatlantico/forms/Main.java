/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uneatlantico.forms;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import com.uneatlantico.database.*;
import com.uneatlantico.data.*;
import java.sql.SQLException;
import org.apache.commons.lang.StringUtils;
import org.apache.tika.exception.TikaException;

/**
 *
 * @author manuel.coto
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private int initWidt,initheight;
    private Conexion conn = new Conexion();
    private List<Thread> hilos = new ArrayList<>();
    private List<List> datosPalabras = new ArrayList<>();
    public Main() throws IOException, TikaException, SQLException {
        initComponents();
        this.initWidt=this.getWidth();
        this.initheight=this.getHeight();
        this.setSize(418, 224);
        JLabel fondo = new JLabel();
        fondo.setSize(this.PaneImage.getWidth(), this.PaneImage.getHeight());
        try {
            BufferedImage image = ImageIO.read(new File("src/main/resources/files/logo.png"));
            fondo.setIcon(new ImageIcon(image));
            this.PaneImage.add(fondo);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
<<<<<<< HEAD
        List<List> todo = conn.Indexacion(datosPalabras);
        /*
        if(todo.size()!=0){
            datosPalabras=todo.get(1);
                   conn.CalculoPalabra(datosPalabras);
                  
        
        }*/
=======
        List<List> todo = conn.Indexacion(hilos,datosPalabras);
        hilos = todo.get(0);
        datosPalabras=todo.get(1);
        if(hilos.size()!=0){
        hilos.forEach(item->{
            item.start();});
        Thread terminated = new Thread(()->{
           while(true){
               int terminatedThreads=0;
               for(Thread hilo : hilos){
                   if(hilo.getState()==Thread.State.TERMINATED){
                       terminatedThreads++;
                   }
               }
               if(terminatedThreads==hilos.size()){
                   conn.CalculoPalabra(datosPalabras);
                   break;
               }
           } 
        });
        terminated.start();
        }
>>>>>>> parent of f530aab... reverse
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        PanelBusqueda = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        PaneImage = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        itemIndexarCarpeta = new javax.swing.JMenuItem();
        itemIndexarArchivo = new javax.swing.JMenuItem();
        menuOpciones = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jScrollPane1.setViewportView(jTree1);

        PanelBusqueda.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnBuscar.setText("Buscar");

        PaneImage.setBackground(new java.awt.Color(255, 153, 102));
        PaneImage.setForeground(new java.awt.Color(255, 153, 51));

        javax.swing.GroupLayout PaneImageLayout = new javax.swing.GroupLayout(PaneImage);
        PaneImage.setLayout(PaneImageLayout);
        PaneImageLayout.setHorizontalGroup(
            PaneImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );
        PaneImageLayout.setVerticalGroup(
            PaneImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelBusquedaLayout = new javax.swing.GroupLayout(PanelBusqueda);
        PanelBusqueda.setLayout(PanelBusquedaLayout);
        PanelBusquedaLayout.setHorizontalGroup(
            PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(PanelBusquedaLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(PaneImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelBusquedaLayout.setVerticalGroup(
            PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PaneImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap())
        );

        menuArchivo.setText("Archivo");

        itemIndexarCarpeta.setText("Indexar Carpeta");
        itemIndexarCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemIndexarCarpetaActionPerformed(evt);
            }
        });
        menuArchivo.add(itemIndexarCarpeta);

        itemIndexarArchivo.setText("Indexar Archivo");
        menuArchivo.add(itemIndexarArchivo);

        jMenuBar1.add(menuArchivo);

        menuOpciones.setText("Opciones");

        jMenuItem1.setText("Borrar todo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuOpciones.add(jMenuItem1);

        jMenuBar1.add(menuOpciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemIndexarCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemIndexarCarpetaActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory( new File("."));
        chooser.setDialogTitle("Elige el directorio");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        
        if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            File fiel = chooser.getSelectedFile();
            /*String[] directories = fiel.list(new FilenameFilter() {
  @Override
  public boolean accept(File current, String name) {
    return new File(current, name).canRead();
  }
});
            System.out.println(Arrays.toString(directories));*/
          
        List<String> padres = new ArrayList();
        if(!conn.CarpetExist(fiel.getName())){
        padres.add(0, fiel.getName());
        conn.InsertCarpeta(fiel.getName(), 1, "");
        listFilesForFolder(fiel,0,padres);
        }
        }
    }//GEN-LAST:event_itemIndexarCarpetaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       conn.borrarTodo();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public void listFilesForFolder(final File folder, int index,List<String>padres) {
        int indexx=index;
        System.out.println(index);
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
                padres.add( fileEntry.getName());
                if(conn.InsertCarpeta(fileEntry.getName(), 0, padres.get(index)))
                    System.out.println((StringUtils.repeat("    ",indexx+1))+"-"+fileEntry.getName());
                indexx++;
            listFilesForFolder(fileEntry,indexx,padres);
        } else {
            System.out.println(padres.get(indexx));
            if(conn.InsertArchivo(fileEntry.getName(), fileEntry.getPath(), padres.get(index)))
             System.out.println(StringUtils.repeat("   ",indexx+2)+">"+fileEntry.getName());
        }
    }
}
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TikaException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PaneImage;
    private javax.swing.JPanel PanelBusqueda;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JMenuItem itemIndexarArchivo;
    private javax.swing.JMenuItem itemIndexarCarpeta;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuOpciones;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables

  
}
