package org.eclipse.wb.swt;



import org.eclipse.swt.widgets.Display; 
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import swing2swt.layout.BorderLayout;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class DiveTable {

	 protected Shell DiveTable;
	 private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	 
	 private int diveCounter = 0;
        

        /**
         * Launch the application.
         * @param args
         */
        public static void main(String[] args) {
                try {
                        DiveTable window = new DiveTable();
                        window.open();
                } catch (Exception e) {
                        e.printStackTrace();
                }
         
        }

        /**
         * Open the window.
         */
        public void open() {
                Display display = Display.getDefault();
                createContents();
                DiveTable.open();
                DiveTable.layout();
                while (!DiveTable.isDisposed()) {
                        if (!display.readAndDispatch()) {
                                display.sleep();
                        }
                }
        }

        /**
         * Create contents of the window.
         */
        protected void createContents() {
                DiveTable = new Shell();
                DiveTable.setMinimumSize(new Point(69, 52));
                DiveTable.setTouchEnabled(true);
                DiveTable.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
                DiveTable.setText("DiveTable");
                DiveTable.setSize(512, 525);
                DiveTable.setEnabled(true);
                DiveTable.setLayout(new BorderLayout(0, 0));
                
                TabFolder tabFolder = new TabFolder(DiveTable, SWT.NONE);
                tabFolder.setLayoutData(BorderLayout.CENTER);
                formToolkit.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
                formToolkit.adapt(tabFolder);
                formToolkit.paintBordersFor(tabFolder);
                
                TabItem tbtmDivePlanner = new TabItem(tabFolder, SWT.NONE);
                tbtmDivePlanner.setText("Dive Planner");
                
                Composite divePlannerPanel = new Composite(tabFolder, SWT.NONE);
                tbtmDivePlanner.setControl(divePlannerPanel);
                divePlannerPanel.setForeground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                divePlannerPanel.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
                formToolkit.paintBordersFor(divePlannerPanel);
                divePlannerPanel.setLayout(new BorderLayout(0, 0));
                
                Composite btngroup = new Composite(divePlannerPanel, SWT.NONE);
                btngroup.setLayoutData(BorderLayout.CENTER);
                btngroup.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
                formToolkit.adapt(btngroup);
                formToolkit.paintBordersFor(btngroup);
                btngroup.setLayout(null);
                
                
                /********************
                 * create dive button
                 ********************/
                final Button btnCreateDive = formToolkit.createButton(btngroup, "Create Dive", SWT.CENTER);
                btnCreateDive.setFont(SWTResourceManager.getFont("Microsoft YaHei", 18, SWT.BOLD));
                btnCreateDive.setBounds(72, 100, 150, 113);
                Listener createListener = new Listener() {
                    public void handleEvent(Event event) {
                		diveCounter = diveCounter + 1; 
                    	createDive();
                    }
                  };
                  btnCreateDive.setEnabled(true);
                btnCreateDive.addListener(SWT.Selection, createListener);
                btnCreateDive.pack();
                
                
                /********************
                 * create edit button
                 ********************/
                Button btnEditDive = formToolkit.createButton(btngroup, "Edit Dive", SWT.CENTER);
                btnEditDive.setFont(SWTResourceManager.getFont("Microsoft YaHei", 18, SWT.BOLD));
                btnEditDive.setBounds(283, 100, 151, 41);
                Listener editListener = new Listener() {
                    public void handleEvent(Event event) {
                      //link to the dive edit gui
                    }
                  };
                btnCreateDive.addListener(SWT.Selection, createListener);
                btnCreateDive.pack();
                
                Label lblPrototype = new Label(btngroup, SWT.NONE);
                lblPrototype.setBounds(10, 10, 358, 15);
                formToolkit.adapt(lblPrototype, true, true);
                lblPrototype.setText("This is a Prototype and CANNOT be used for real dives");
                
                Composite table = new Composite(divePlannerPanel, SWT.NONE);
                table.setLayoutData(BorderLayout.SOUTH);
                table.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
                formToolkit.adapt(table);
                formToolkit.paintBordersFor(table);
                table.setLayout(new GridLayout(5, false));
                
                Label lblDiveNum = formToolkit.createLabel(table, "Dive Number", SWT.BORDER);
                lblDiveNum.setFont(SWTResourceManager.getFont("@Microsoft YaHei", 9, SWT.BOLD));
                lblDiveNum.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                GridData gd_lblDiveNum = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
                gd_lblDiveNum.heightHint = 12;
                lblDiveNum.setLayoutData(gd_lblDiveNum);
                
                Label lblMaxDepth = formToolkit.createLabel(table, "Max Depth", SWT.BORDER);
                lblMaxDepth.setAlignment(SWT.CENTER);
                lblMaxDepth.setFont(SWTResourceManager.getFont("@Microsoft YaHei", 9, SWT.BOLD));
                lblMaxDepth.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                lblMaxDepth.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
                
                Label lblBottomTime = formToolkit.createLabel(table, "Bottom Time", SWT.BORDER);
                lblBottomTime.setFont(SWTResourceManager.getFont("@Microsoft YaHei", 9, SWT.BOLD));
                lblBottomTime.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                lblBottomTime.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label lblSurfInt = formToolkit.createLabel(table, "Surface Interval", SWT.BORDER);
                lblSurfInt.setFont(SWTResourceManager.getFont("@Microsoft YaHei", 9, SWT.BOLD));
                lblSurfInt.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                lblSurfInt.setAlignment(SWT.CENTER);
                lblSurfInt.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label lblResNitro = formToolkit.createLabel(table, "Residual Nitrogen", SWT.BORDER);
                lblResNitro.setFont(SWTResourceManager.getFont("@Microsoft YaHei", 9, SWT.BOLD));
                lblResNitro.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                lblResNitro.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label dive1 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                dive1.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                dive1.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                GridData gd_dive1 = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
                gd_dive1.heightHint = 17;
                dive1.setLayoutData(gd_dive1);
                
                Label maxDepth1 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                maxDepth1.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                maxDepth1.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                maxDepth1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label botTime1 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                botTime1.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                botTime1.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                botTime1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label surfInt1 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                surfInt1.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                surfInt1.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                surfInt1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label resNitro1 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                resNitro1.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                resNitro1.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                resNitro1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label dive2 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                dive2.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                dive2.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                GridData gd_dive2 = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
                gd_dive2.heightHint = 15;
                dive2.setLayoutData(gd_dive2);
                
                Label maxDepth2 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                maxDepth2.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                maxDepth2.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                maxDepth2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label botTime2 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                botTime2.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                botTime2.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                botTime2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label surfInt2 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                surfInt2.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                surfInt2.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                surfInt2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label resNitro2 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                resNitro2.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                resNitro2.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                resNitro2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label dive3 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                dive3.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                dive3.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                GridData gd_dive3 = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
                gd_dive3.heightHint = 15;
                dive3.setLayoutData(gd_dive3);
                
                Label maxDepth3 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                maxDepth3.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                maxDepth3.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                maxDepth3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label botTime3 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                botTime3.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                botTime3.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                botTime3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label surfInt3 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                surfInt3.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                surfInt3.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                surfInt3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label resNitro3 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                resNitro3.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                resNitro3.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                resNitro3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label dive4 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                dive4.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                dive4.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                dive4.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
                
                Label maxDepth4 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                maxDepth4.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                maxDepth4.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                maxDepth4.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label botTime4 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                botTime4.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                botTime4.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                botTime4.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label surfInt4 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                surfInt4.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                surfInt4.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                surfInt4.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label resNitro4 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                resNitro4.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                resNitro4.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                resNitro4.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label dive5 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                dive5.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                dive5.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                GridData gd_dive5 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
                gd_dive5.heightHint = 21;
                dive5.setLayoutData(gd_dive5);
                
                Label maxDepth5 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                maxDepth5.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                maxDepth5.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                GridData gd_maxDepth5 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
                gd_maxDepth5.heightHint = 19;
                maxDepth5.setLayoutData(gd_maxDepth5);
                
                Label botTime5 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                botTime5.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                botTime5.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                GridData gd_botTime5 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
                gd_botTime5.heightHint = 22;
                botTime5.setLayoutData(gd_botTime5);
                
                Label surfInt5 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                surfInt5.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));	
                surfInt5.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                surfInt5.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
                
                Label resNitro5 = formToolkit.createLabel(table, "", SWT.BORDER | SWT.CENTER);
                resNitro5.setFont(SWTResourceManager.getFont("Terminal", 28, SWT.NORMAL));
                resNitro5.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
                resNitro5.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));                
                
                TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
                tabItem.setText("New Item");
                
                Composite composite = new Composite(tabFolder, SWT.NONE);
                tabItem.setControl(composite);
                formToolkit.paintBordersFor(composite);
                composite.setLayout(new GridLayout(1, false));
        }
       
        
        
        

        public void createDive() {
        	if(diveCounter < 5){
        		MessageBox createPopup = new MessageBox(DiveTable, SWT.ICON_INFORMATION | SWT.OK);                   
                createPopup.setText("Create Dive " + diveCounter);
                createPopup.setMessage("Plan your dive");
                createPopup.open();
                System.out.println(diveCounter);
        	}
        	else{
        		MessageBox createErrorPopup = new MessageBox(DiveTable, SWT.ICON_INFORMATION | SWT.OK);                   
                createErrorPopup.setText("Error");
                createErrorPopup.setMessage("You have created too many dives");
                createErrorPopup.open();
        	}               
       }
        
        public void editDive(){
        	//add logic to edit dive
        }
}