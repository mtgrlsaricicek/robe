/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.robe.hibernate.crud;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.ImportDeclaration;
import japa.parser.ast.Node;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.expr.AnnotationExpr;
import japa.parser.ast.expr.NameExpr;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;

import org.apache.tools.ant.DirectoryScanner;

public class RobeCrudGUI extends javax.swing.JFrame {
    public static final String JAVA_IO_TMP_DIR = "user.home";
    public static String OUTPUT_PATH;
    public static Map<String,String> imports= new HashMap<String, String>();
    public static CompilationUnit compilationUnit;
    /**
     * Creates new form RobeCrudGUI
     */
    public RobeCrudGUI() {
    	setResizable(false);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfProjectPath = new javax.swing.JTextField();
        tfProjectOutputPath = new javax.swing.JTextField();
        tfProjectOutputPath.setText("None");
        btnProjectPath = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnGenerate = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Select Project:");

        tfProjectPath.setText("None");

        btnProjectPath.setText("Select");
        btnProjectPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProjectPathActionPerformed(evt);
            }
        });

        jLabel2.setText("Entities:");

        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("(Please configure)");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        //{"Empty", false, false, false, false},
                },
                new String[]{
                        "Entitiy", "Dao", "Resource", "Inject", "Auth"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(204, 204, 204));
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        btnGenerate.setText("Generate");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });
        
        JLabel lblSelectOutput = new JLabel();
        lblSelectOutput.setText("Select Output:");
        
        JButton btnOutputPath = new JButton();
        btnOutputPath.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		
        		btnProjectOutputPathActionPerformed(evt);
        		
        	}
        });
        btnOutputPath.setText("Select");
        
        
        
        txtPackageName = new javax.swing.JTextField();
        txtPackageName.setColumns(10);
        
        JLabel lblPackage = new JLabel();
        lblPackage.setText("Package:");
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(11)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addGap(19)
        					.addComponent(tfProjectPath, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(btnProjectPath, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(lblSelectOutput, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
        					.addGap(11)
        					.addComponent(tfProjectOutputPath, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(btnOutputPath, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(lblPackage, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
        					.addGap(11)
        					.addComponent(txtPackageName, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(jLabel2)
        					.addGap(50)
        					.addComponent(jLabel3))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 629, GroupLayout.PREFERRED_SIZE)
        						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 525, GroupLayout.PREFERRED_SIZE))
        					.addComponent(btnGenerate))))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(11)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(4)
        					.addComponent(jLabel1))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(1)
        					.addComponent(tfProjectPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addComponent(btnProjectPath))
        			.addGap(6)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(4)
        					.addComponent(lblSelectOutput))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(1)
        					.addComponent(tfProjectOutputPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addComponent(btnOutputPath))
        			.addGap(6)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(3)
        					.addComponent(lblPackage))
        				.addComponent(txtPackageName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(23)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel2)
        				.addComponent(jLabel3))
        			.addGap(14)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
        					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(240)
        					.addComponent(btnGenerate))))
        );
        getContentPane().setLayout(groupLayout);

        pack();
    }// </editor-fold>                        

    private void btnProjectPathActionPerformed(java.awt.event.ActionEvent evt) {

        JFileChooser dialog = new JFileChooser("D:\\mebitech\\robe\\robe-crud");
        
        dialog.setMultiSelectionEnabled(false);
        dialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int retval = dialog.showOpenDialog(this);
        if (retval == JFileChooser.APPROVE_OPTION) {
            File file = dialog.getSelectedFile();
            tfProjectPath.setText(file.getAbsolutePath());

            fillEntityList(file.getAbsolutePath());
        }
    }

    private void btnProjectOutputPathActionPerformed(java.awt.event.ActionEvent evt) {

        JFileChooser dialog = new JFileChooser("C:\\Users\\acedemand\\Desktop\temp");
        
        dialog.setMultiSelectionEnabled(false);
        dialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int retval = dialog.showSaveDialog(this);
        if (retval == JFileChooser.APPROVE_OPTION) {
            File file = dialog.getSelectedFile();
            tfProjectOutputPath.setText(file.getAbsolutePath());
            OUTPUT_PATH=file.getAbsolutePath();
        }
    }
    
    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {

   
     Object[][] tableData= getTableData(jTable1);
     progressBar.setIndeterminate(true);
     
        for (Object[] data : tableData) {
            String entity=(String)data[0];
            Boolean dao=(Boolean)data[1];
            Boolean resource=(Boolean)data[2];
            Boolean inject=(Boolean)data[3];
            Boolean auth=(Boolean)data[4];

            String fileDaoLocation = OUTPUT_PATH+File.separator+"dao";
            new File(fileDaoLocation).mkdirs();

            String fileResourceLocation = OUTPUT_PATH+File.separator+"resource";
            new File(fileResourceLocation).mkdirs();

            try {

            	String daoName=entity+"Dao";
                String newDaoClassName=fileDaoLocation+File.separator+daoName+".java";

                List<String> fieldGet=ClassVisitor.allColumns.get(entity);
                List<String> uniqueFields=ClassVisitor.uniqueColumns.get(entity);
                
                String findBy="findById";
                if (uniqueFields!=null) {
                    for (String string : uniqueFields) {
                        findBy += "Or" + CrudUtility.capitalizeToUpper(string);
                    }
                }
                String importEntity=imports.get(entity);
                String packageName=txtPackageName.getText();
                
                if(dao) {
                    List<ImportDeclaration> importDeclarations = new ArrayList<ImportDeclaration>();

                    String []imports={
                            "com.google.common.base.Optional",
                            "com.google.inject.Inject",
                            "org.hibernate.Criteria",
                            "org.hibernate.SessionFactory",
                            "org.hibernate.criterion.Restrictions",
                            "io.robe.hibernate.dao.BaseDao"
                    };
                    importDeclarations.add(new ImportDeclaration(new NameExpr(importEntity), false, false));
                    importDeclarations.addAll(CrudUtility.getImports(imports));

                    File fileDao = new File(newDaoClassName);
                    if (!fileDao.exists()) {
                        fileDao.createNewFile();
                    }
                 
                    FileWriter fwDao = null;
                    fwDao = new FileWriter(fileDao.getAbsoluteFile());
                    BufferedWriter bwDao = new BufferedWriter(fwDao);
                    bwDao.write(DaoCrud.createDao(entity, packageName+".dao", importDeclarations, uniqueFields, findBy));
                    bwDao.close();

                }
                if(resource) {

                	String resourceName=entity+"Resource";
                    String newResourceClassName = fileResourceLocation + File.separator + resourceName + ".java";
                    File fileResource = new File(newResourceClassName);
                    if (!fileResource.exists()) {
                        fileResource.createNewFile();
                    }
                    
                    FileWriter fwResource = new FileWriter(fileResource.getAbsoluteFile());
                    BufferedWriter bwResource = new BufferedWriter(fwResource);
                    List<BodyDeclaration> bodyDeclarations = new ArrayList<BodyDeclaration>();

                    bodyDeclarations.add(ResourceCrud.getAll(entity, daoName, "findAll",auth));
                    bodyDeclarations.add(ResourceCrud.get(entity, daoName, findBy,auth));
                    bodyDeclarations.add(ResourceCrud.create(entity, daoName, uniqueFields, "create",auth));
                    bodyDeclarations.add(ResourceCrud.update(entity, daoName, fieldGet, "getOid", findBy, "update", "detach",auth));
                    bodyDeclarations.add(ResourceCrud.delete(entity, daoName, "getOid", findBy, "delete",auth));
                    List<ImportDeclaration> importDeclarationsResource = new ArrayList<ImportDeclaration>();
                    String []imports={
                            "com.google.common.base.Optional",
                            "com.google.inject.Inject",
                            "com.yammer.dropwizard.auth.Auth",
                            "com.yammer.dropwizard.hibernate.UnitOfWork",
                            packageName+".dao."+entity+"Dao",
                            "io.robe.auth.Credentials",
                            "io.robe.common.exception.RobeRuntimeException",
                            "org.hibernate.Hibernate",
                            "javax.validation.Valid",
                            importEntity
                    };
                    importDeclarationsResource.addAll(CrudUtility.getImports(imports));
                    bwResource.write(ResourceCrud.ResourceGenerate(resourceName, entity, daoName, bodyDeclarations, importDeclarationsResource, packageName+".resource", inject));
                    bwResource.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        progressBar.setIndeterminate(false);
        javax.swing.JOptionPane.showMessageDialog(this, "created successfull!");

    }
    
    public Object[][] getTableData (JTable table) {
        javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel) table.getModel();
        int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
        Object[][] tableData = new Object[nRow][nCol];
        for (int i = 0 ; i < nRow ; i++)
            for (int j = 0 ; j < nCol ; j++)
                tableData[i][j] = dtm.getValueAt(i,j);
        return tableData;
    }

    private void fillEntityList(String absolutePath) {
    			
    	DirectoryScanner scanner = new DirectoryScanner();
    	scanner.setIncludes(new String[]{"**/*.java"});
    	scanner.setBasedir(absolutePath);
    	scanner.setCaseSensitive(false);
    	scanner.scan();
    	String[] files = scanner.getIncludedFiles();

    	ClassVisitor.classes.clear();
    	for (String string : files) {
				try {
					compilationUnit = JavaParser.parse(new File(absolutePath+"\\"+string));
				} catch (ParseException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				new ClassVisitor().visit(compilationUnit, null);
				
		}
    	
        Object[][] list = null;
        list=new Object[ClassVisitor.classes.size()][5];
        
        
        int i = 0;
        for (String entityClass : ClassVisitor.classes) {
            list[i][0] = entityClass;
            list[i][1] = true;
            list[i][2] = true;
            list[i][3] = true;
            list[i++][4] = true;
        }
       
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                list,
                new String[]{
                        "Entitiy", "Dao", "Resource", "Inject", "Auth"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
    }
    
    private static class ClassVisitor extends VoidVisitorAdapter {

    	public static List<String> classes= new ArrayList<String>();    	
    	public static Map<String, List<String>> allColumns = new HashMap<String, List<String>>();
    	public static Map<String, List<String>> uniqueColumns = new HashMap<String, List<String>>();    	
    	
    	@Override
        public void visit(ClassOrInterfaceDeclaration n, Object arg) {
     	
        	List<AnnotationExpr> list=n.getAnnotations();
        	
        	if(list!=null){
	        	for (AnnotationExpr annotationExpr : list) {
					if(annotationExpr.toString().equals("@Entity")){
						
						RobeCrudGUI.imports.put(n.getName(), RobeCrudGUI.compilationUnit.getPackage().getName().toString());
						List<BodyDeclaration> body=n.getMembers();
						
						List<String> allList = new ArrayList<String>();
						List<String> uniqueList = new ArrayList<String>();
						
						for (BodyDeclaration bodyDeclaration : body) {
							
							if(bodyDeclaration instanceof FieldDeclaration)
							{
								FieldDeclaration fieldDeclaration =(FieldDeclaration)bodyDeclaration;
								List<AnnotationExpr> fieldExp=fieldDeclaration.getAnnotations();
								
								if(fieldExp!=null){
						
									VariableDeclarator variableDeclarator = fieldDeclaration.getVariables().get(0);
									
									for (AnnotationExpr expr : fieldExp) {
										
										if(expr.getName().toString().equals("Column")){
											allList.add(variableDeclarator.getId().toString());
											List<Node> nodes = expr.getChildrenNodes();
											if(nodes!=null){
												for (Node node : nodes) {
													if(node.toString().contains("unique")){
														if(node.toString().contains("true")){															
															uniqueList.add(variableDeclarator.getId().toString());															
														}
													}
												}
											}
										}
									}
									allColumns.put(n.getName(), allList);
									uniqueColumns.put(n.getName(), uniqueList);
								}
							}
						}
						classes.add(n.getName());
						return;
					}
				}
        	}
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RobeCrudGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RobeCrudGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RobeCrudGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RobeCrudGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RobeCrudGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnProjectPath;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tfProjectPath;
    private javax.swing.JTextField tfProjectOutputPath;
    private javax.swing.JTextField txtPackageName;
    private javax.swing.JProgressBar progressBar;
}
