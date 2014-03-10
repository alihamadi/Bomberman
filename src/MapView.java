/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author abdullahadeeb
 */
public class MapView extends javax.swing.JFrame {

    /**
     * Creates new form mapView
     */
    MapModel model;
    private ImageIcon grassIcon;
    private ImageIcon wallIcon;
    private ImageIcon boxIcon;
    private ImageIcon exitIcon;

    public MapView(MapModel model) {
        this.model = model;
        initComponents();
        initImages();


        MapTableModel mapTableModel = new MapTableModel();
        mapTableModel.setColumnCount(10);
        mapTableModel.setRowCount(10);


        Entity[][] grid = model.getGrid();
        for (int y = 0; y < model.getGridSize(); y++) {
            for (int x = 0; x < model.getGridSize(); x++) {
                switch (grid[x][y].getType()) {
                    case Entity.BOX:
                        mapTableModel.setValueAt(boxIcon, x, y);
                        break;
                    case Entity.WALL:
                        mapTableModel.setValueAt(wallIcon, x, y);
                        break;
                    case Entity.PATH:
                        mapTableModel.setValueAt(grassIcon, x, y);
                        break;
                    case Entity.EXIT:
                        mapTableModel.setValueAt(exitIcon, x, y);
                        break;
                    default:
                        mapTableModel.setValueAt(grassIcon, x, y);
                        break;
                }
            }
        }// done for loop
        this.mapTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel columnModel = this.mapTable.getColumnModel();

        for (int i = 0; i < columnModel.getColumnCount(); i++) {
//            columnModel.getColumn(i).sizeWidthToFit();
            columnModel.setColumnSelectionAllowed(false);
//            columnModel.getColumn(i).setWidth(40);
//            mapTable.getColumnModel().getColumn(i).setWidth(40);
//            columnModel.getColumn(i).setMinWidth(50);
//            columnModel.getColumn(i).setMaxWidth(50);
        }
//        for (int i = 0; i < mapTableModel.getRowCount(); i++) {
            mapTable.setRowHeight(50);
            mapTable.setShowGrid(false);
            
//        }


        this.mapTable.setModel(mapTableModel);
    }

    private void initImages() {
        grassIcon = new ImageIcon("C:\\Users\\abdullahadeeb\\Pictures\\PATH1.JPG");
        wallIcon = new ImageIcon("C:\\Users\\abdullahadeeb\\Pictures\\WALL1.JPG");
        boxIcon = new ImageIcon("C:\\Users\\abdullahadeeb\\Pictures\\BOX1.JPG");
        exitIcon = new ImageIcon("C:\\Users\\abdullahadeeb\\Pictures\\EXIT1.JPG");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mapPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mapTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mapPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        mapTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(mapTable);

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bomber MAn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(72, 72, 72))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JTable mapTable;
    // End of variables declaration//GEN-END:variables

    class MapTableModel extends DefaultTableModel {

        @Override
        public Class<?> getColumnClass(int i) {
            return Icon.class;
        }
    }
}
