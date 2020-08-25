/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.micromanager.ndviewer.internal.gui;

import org.micromanager.ndviewer.internal.gui.contrast.ContrastPanel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;
import mmcorej.org.json.JSONObject;
import org.micromanager.ndviewer.api.ControlsPanelInterface;
import org.micromanager.ndviewer.main.NDViewer;

/**
 *
 * @author henrypinkard
 */
class DisplayWindowControls extends javax.swing.JPanel {

   private NDViewer display_;
 private ContrastPanel cpMagellan_;
   private ArrayList<ControlsPanelInterface> customPanels_ = new ArrayList<ControlsPanelInterface>();

   /**
    * Creates new form DisplayWindowControls
    */
   public DisplayWindowControls(NDViewer disp, List<JPanel> additionalPanels, boolean nullAcq) {
      display_ = disp;
      initComponents();
      metadataPanelMagellan_.setSummaryMetadata(disp.getSummaryMD());
      this.setFocusable(false); //think this is good 

      //Always start showing contrast
      tabbedPane_.setSelectedIndex(0);
      if (nullAcq) {
         abortButton_.setVisible(false);
         pauseButton_.setVisible(false);
      }
   }

   void addControlPanel(ControlsPanelInterface panel) {
      tabbedPane_.addTab(panel.getTitle(), (JPanel) panel);
      customPanels_.add(panel);
      tabbedPane_.revalidate();
   }

   public void onDisplayClose() {
      for (int i = 0; i < customPanels_.size(); i++) {
         customPanels_.get(i).close();
      }
      cpMagellan_.onDisplayClose();
   }

   void updateHistogramData(HashMap<String, int[]> hists) {
      cpMagellan_.updateHistogramData(hists);
   }

   public void addContrastControls(String channelName) {
      cpMagellan_.addContrastControls(channelName);
   }

   public MetadataPanel getMetadataPanelMagellan() {
      return metadataPanelMagellan_;
   }

   void displaySettingsChanged() {
      cpMagellan_.displaySettingsChanged();
   }

   void setImageMetadata(JSONObject imageMD) {
      metadataPanelMagellan_.updateImageMetadata(imageMD);
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      tabbedPane_ = new javax.swing.JTabbedPane();
      contrastPanelPanel_ = new javax.swing.JPanel();
      metadataPanel_ = new javax.swing.JPanel();
      metadataPanelMagellan_ = new org.micromanager.ndviewer.internal.gui.MetadataPanel();
      topControlPanel_ = new javax.swing.JPanel();
      showInFolderButton_ = new javax.swing.JButton();
      abortButton_ = new javax.swing.JButton();
      pauseButton_ = new javax.swing.JButton();
      fpsLabel_ = new javax.swing.JLabel();
      animationFPSSpinner_ = new javax.swing.JSpinner();
      lockScrollbarsCheckBox_ = new javax.swing.JCheckBox();
      scaleBarCheckBox_ = new javax.swing.JCheckBox();
      timeCheckBox_ = new javax.swing.JCheckBox();
      zPositiionCheckBox_ = new javax.swing.JCheckBox();

      tabbedPane_.setToolTipText("");
      tabbedPane_.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            tabbedPane_StateChanged(evt);
         }
      });

      contrastPanelPanel_.setLayout(new java.awt.BorderLayout());

      cpMagellan_ = new ContrastPanel(display_);
      contrastPanelPanel_.add(cpMagellan_);

      tabbedPane_.addTab("Contrast", contrastPanelPanel_);

      javax.swing.GroupLayout metadataPanel_Layout = new javax.swing.GroupLayout(metadataPanel_);
      metadataPanel_.setLayout(metadataPanel_Layout);
      metadataPanel_Layout.setHorizontalGroup(
         metadataPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(metadataPanelMagellan_, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
      );
      metadataPanel_Layout.setVerticalGroup(
         metadataPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(metadataPanelMagellan_, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
      );

      tabbedPane_.addTab("Metadata", metadataPanel_);

      showInFolderButton_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/micromanager/ndviewer/folder.png"))); // NOI18N
      showInFolderButton_.setToolTipText("Show in folder");
      showInFolderButton_.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            showInFolderButton_ActionPerformed(evt);
         }
      });

      abortButton_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/micromanager/ndviewer/abort.png"))); // NOI18N
      abortButton_.setToolTipText("Abort acquisition");
      abortButton_.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            abortButton_ActionPerformed(evt);
         }
      });

      pauseButton_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/micromanager/ndviewer/pause.png"))); // NOI18N
      pauseButton_.setToolTipText("Pause/resume acquisition");
      pauseButton_.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            pauseButton_ActionPerformed(evt);
         }
      });

      fpsLabel_.setText("Animate FPS:");

      animationFPSSpinner_.setModel(new javax.swing.SpinnerNumberModel(7.0d, 1.0d, 1000.0d, 1.0d));
      animationFPSSpinner_.setToolTipText("Speed of the scrollbar animation button playback");
      animationFPSSpinner_.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            animationFPSSpinner_StateChanged(evt);
         }
      });

      lockScrollbarsCheckBox_.setText("Lock scrollbars");
      lockScrollbarsCheckBox_.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            lockScrollbarsCheckBox_ActionPerformed(evt);
         }
      });

      scaleBarCheckBox_.setText("Scale Bar");
      scaleBarCheckBox_.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            scaleBarCheckBox_ActionPerformed(evt);
         }
      });

      timeCheckBox_.setText("Time");
      timeCheckBox_.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            timeCheckBox_ActionPerformed(evt);
         }
      });

      zPositiionCheckBox_.setText("Z position");
      zPositiionCheckBox_.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            zPositiionCheckBox_ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout topControlPanel_Layout = new javax.swing.GroupLayout(topControlPanel_);
      topControlPanel_.setLayout(topControlPanel_Layout);
      topControlPanel_Layout.setHorizontalGroup(
         topControlPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(topControlPanel_Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fpsLabel_)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(animationFPSSpinner_, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lockScrollbarsCheckBox_)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(scaleBarCheckBox_)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(timeCheckBox_)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(zPositiionCheckBox_)
            .addContainerGap())
         .addGroup(topControlPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topControlPanel_Layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(showInFolderButton_)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addComponent(abortButton_)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addComponent(pauseButton_)
               .addContainerGap(516, Short.MAX_VALUE)))
      );
      topControlPanel_Layout.setVerticalGroup(
         topControlPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(topControlPanel_Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(topControlPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(animationFPSSpinner_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(fpsLabel_)
               .addComponent(lockScrollbarsCheckBox_)
               .addComponent(scaleBarCheckBox_)
               .addComponent(timeCheckBox_)
               .addComponent(zPositiionCheckBox_))
            .addContainerGap(22, Short.MAX_VALUE))
         .addGroup(topControlPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topControlPanel_Layout.createSequentialGroup()
               .addContainerGap()
               .addGroup(topControlPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(showInFolderButton_)
                  .addComponent(abortButton_)
                  .addComponent(pauseButton_))
               .addContainerGap(16, Short.MAX_VALUE)))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(tabbedPane_)
         .addComponent(topControlPanel_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(topControlPanel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(tabbedPane_))
      );

      tabbedPane_.getAccessibleContext().setAccessibleName("Contrast");
   }// </editor-fold>//GEN-END:initComponents

   private void tabbedPane_StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbedPane_StateChanged

      for (int i = 0; i < customPanels_.size(); i++) {
         if (tabbedPane_.getSelectedIndex() - 2 == i) {
            customPanels_.get(i).selected();
         } else {
            customPanels_.get(i).deselected();
         }
      }
   }//GEN-LAST:event_tabbedPane_StateChanged

   private void showInFolderButton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showInFolderButton_ActionPerformed
      display_.showFolder();
   }//GEN-LAST:event_showInFolderButton_ActionPerformed

   private void abortButton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abortButton_ActionPerformed
      display_.abortAcquisition();
   }//GEN-LAST:event_abortButton_ActionPerformed

   private void pauseButton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButton_ActionPerformed
      display_.togglePauseAcquisition();
      pauseButton_.setIcon(new javax.swing.ImageIcon(getClass().getResource(
              display_.isAcquisitionPaused() ? "/org/micromanager/ndviewer/play.png" : "/org/micromanager/ndviewer/pause.png")));
      repaint();
   }//GEN-LAST:event_pauseButton_ActionPerformed

   private void animationFPSSpinner_StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_animationFPSSpinner_StateChanged
      display_.setAnimateFPS(((Number) animationFPSSpinner_.getValue()).doubleValue());
   }//GEN-LAST:event_animationFPSSpinner_StateChanged

   private void lockScrollbarsCheckBox_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lockScrollbarsCheckBox_ActionPerformed
      if (!lockScrollbarsCheckBox_.isSelected()) {
         display_.unlockAllScroller();
      } else {
         display_.superlockAllScrollers();
      }
   }//GEN-LAST:event_lockScrollbarsCheckBox_ActionPerformed

   private void scaleBarCheckBox_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaleBarCheckBox_ActionPerformed
      display_.showScaleBar(scaleBarCheckBox_.isSelected());
      display_.redrawOverlay();
   }//GEN-LAST:event_scaleBarCheckBox_ActionPerformed

   private void timeCheckBox_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeCheckBox_ActionPerformed
      display_.showTimeLabel(timeCheckBox_.isSelected());
      display_.redrawOverlay();
   }//GEN-LAST:event_timeCheckBox_ActionPerformed

   private void zPositiionCheckBox_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zPositiionCheckBox_ActionPerformed
      display_.showZPositionLabel(zPositiionCheckBox_.isSelected());
      display_.redrawOverlay();
   }//GEN-LAST:event_zPositiionCheckBox_ActionPerformed


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton abortButton_;
   private javax.swing.JSpinner animationFPSSpinner_;
   private javax.swing.JPanel contrastPanelPanel_;
   private javax.swing.JLabel fpsLabel_;
   private javax.swing.JCheckBox lockScrollbarsCheckBox_;
   private org.micromanager.ndviewer.internal.gui.MetadataPanel metadataPanelMagellan_;
   private javax.swing.JPanel metadataPanel_;
   private javax.swing.JButton pauseButton_;
   private javax.swing.JCheckBox scaleBarCheckBox_;
   private javax.swing.JButton showInFolderButton_;
   private javax.swing.JTabbedPane tabbedPane_;
   private javax.swing.JCheckBox timeCheckBox_;
   private javax.swing.JPanel topControlPanel_;
   private javax.swing.JCheckBox zPositiionCheckBox_;
   // End of variables declaration//GEN-END:variables

}