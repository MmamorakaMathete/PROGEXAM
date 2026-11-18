/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.question2;

/**
 *
 * @author Student
 */
public class ProductApp extends JFrame { 

 

    private static final String[] PRODUCTS =  {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"}; 
    private static final String STAR_LINE = "******************************"; 
    private static final String FILE_NAME = "data.txt";
    private final JTextField txtCustomerName = new JTextField(); 
    private final JComboBox<String> cmbProduct = new JComboBox<>(PRODUCTS); 
    private final JTextField txtPrice = new JTextField(); 

   public ProductApp() { 

        setTitle("Product App"); 
        setSize(450, 250); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setLocationRelativeTo(null)
        setJMenuBar(createMenuBar()); 
        add(createFormPanel()); 
    } 

      private JPanel createFormPanel() { 
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10)); 
        panel.setBorder(new EmptyBorder(15, 15, 15, 15)); 

        JButton btnProcess = new JButton("PROCESS"); 
        btnProcess.addActionListener(e -> processSale()); 
        
        panel.add(new JLabel("Customer Name:"));
          panel.add(txtCustomerName); 

        panel.add(new JLabel("Select Product:")); 
        panel.add(cmbProduct); 
        panel.add(new JLabel("Enter Price:")); 
        panel.add(txtPrice); 
        panel.add(new JLabel("")); 
        panel.add(btnProcess); 

        return panel; 
    } 

  private JMenuBar createMenuBar() { 

        JMenuBar menuBar = new JMenuBar(); 

 

        JMenu fileMenu = new JMenu("File"); 
        JMenuItem exitItem = new JMenuItem("Exit"); 
        exitItem.addActionListener(e -> System.exit(0)); 
        fileMenu.add(exitItem); 

 

        JMenu toolsMenu = new JMenu("Tools"); 

        JMenuItem processItem = new JMenuItem("Process"); 
        processItem.addActionListener(e -> processSale()); 
        
        JMenuItem clearItem = new JMenuItem("Clear"); 
        clearItem.addActionListener(e -> clearForm()); 
        toolsMenu.add(processItem); 
        toolsMenu.add(clearItem);
          menuBar.add(fileMenu); 

        menuBar.add(toolsMenu); 

        return menuBar; 

    }
  
private void processSale() { 

        String customerName = txtCustomerName.getText().trim(); 
        String product = (String) cmbProduct.getSelectedItem(); 

           if (customerName.isEmpty()) { 
            showError("Please enter the customer's name."); 

            return; 
        }
           
           double price; 

        try { 

            price = Double.parseDouble(txtPrice.getText().trim()); 

        } catch (NumberFormatException ex) { 

            showError("Please enter the price as a number, for example 3500."); 

            return; 

        } 

        if (price <= 0){
            showError("The price must be more than 0."); 

            return; 

        } 

        ProductCalculations calculations = new ProductCalculations(price); 

        String details = "Customer Name: " + customerName + "\n"  + "Product: " + product + "\n"  + "VAT: R " + calculations.GetVat() + "\n" + "COMMISSION: R " + calculations.GetCommission() + "\n" + "TOTAL: R " + calculations.GetTotal(); 

 

        JOptionPane.showMessageDialog(this, details); 
        saveToFile(details); 

    } 

      private void saveToFile(String details) { 

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) { 

            writer.println("DATA LOG"); 
            writer.println(STAR_LINE); 
            writer.println(details); 
            writer.println(STAR_LINE); 

        } catch (IOException ex) { 
            showError("The data could not be saved to " + FILE_NAME + "."); 
            }
        } 
      
         private void clearForm() { 

        txtCustomerName.setText(""); 

        txtPrice.setText(""); 

        cmbProduct.setSelectedIndex(0); 

    } 

 


    private void showError(String message) { 

        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE); 

    } 

 

    public static void main(String[] args) { 

        new ProductApp().setVisible(true); 

  
    }
    } 

    
        

 