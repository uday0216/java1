import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame {
    private JCheckBox carCheckBox;
    private JCheckBox truckCheckBox;

    public Main() {
        setTitle("Select Vehicle");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        carCheckBox = new JCheckBox("Car");
        carCheckBox.setBounds(50, 50, 100, 30);
        truckCheckBox = new JCheckBox("Truck");
        truckCheckBox.setBounds(150, 50, 100, 30);

        carCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (carCheckBox.isSelected()) {
                    truckCheckBox.setSelected(false);
                    new CarInfoGUI();
                }
            }
        });

        truckCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (truckCheckBox.isSelected()) {
                    carCheckBox.setSelected(false);
                    new TruckInfoGUI();
                }
            }
        });

        add(carCheckBox);
        add(truckCheckBox);

        setVisible(true);
    }

    
    class CarInfoGUI extends JFrame {
        private JTextField makeField, modelField, yearField, doorsField, fuelCapacityField, rangeField, extraLoadField;
        private JButton calcWithoutLoadButton, calcWithLoadButton;

        public CarInfoGUI() {
            setTitle("Car Information");
            setSize(400, 500);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(null);

            JLabel makeLabel = new JLabel("Make:");
            makeLabel.setBounds(20, 20, 100, 30);
            makeField = new JTextField();
            makeField.setBounds(150, 20, 150, 30);

            JLabel modelLabel = new JLabel("Model:");
            modelLabel.setBounds(20, 60, 100, 30);
            modelField = new JTextField();
            modelField.setBounds(150, 60, 150, 30);

            JLabel yearLabel = new JLabel("Year:");
            yearLabel.setBounds(20, 100, 100, 30);
            yearField = new JTextField();
            yearField.setBounds(150, 100, 150, 30);

            JLabel doorsLabel = new JLabel("Number of Doors:");
            doorsLabel.setBounds(20, 140, 150, 30);
            doorsField = new JTextField();
            doorsField.setBounds(150, 140, 150, 30);

            JLabel fuelCapacityLabel = new JLabel("Fuel Tank Capacity:");
            fuelCapacityLabel.setBounds(20, 180, 150, 30);
            fuelCapacityField = new JTextField();
            fuelCapacityField.setBounds(150, 180, 150, 30);

            JLabel rangeLabel = new JLabel("Driving Range:");
            rangeLabel.setBounds(20, 220, 100, 30);
            rangeField = new JTextField();
            rangeField.setBounds(150, 220, 150, 30);

            JLabel extraLoadLabel = new JLabel("Extra Load:");
            extraLoadLabel.setBounds(20, 260, 100, 30);
            extraLoadField = new JTextField();
            extraLoadField.setBounds(150, 260, 150, 30);

            calcWithoutLoadButton = new JButton("Calculate MPG (No Load)");
            calcWithoutLoadButton.setBounds(20, 300, 280, 30);
            calcWithoutLoadButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    calculateMPG(false);
                }
            });

            calcWithLoadButton = new JButton("Calculate MPG (With Load)");
            calcWithLoadButton.setBounds(20, 340, 280, 30);
            calcWithLoadButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    calculateMPG(true);
                }
            });

            add(makeLabel);
            add(makeField);
            add(modelLabel);
            add(modelField);
            add(yearLabel);
            add(yearField);
            add(doorsLabel);
            add(doorsField);
            add(fuelCapacityLabel);
            add(fuelCapacityField);
            add(rangeLabel);
            add(rangeField);
            add(extraLoadLabel);
            add(extraLoadField);
            add(calcWithoutLoadButton);
            add(calcWithLoadButton);

            setVisible(true);
        }

        private void calculateMPG(boolean withLoad) {
            try {
                String make = makeField.getText();
                String model = modelField.getText();
                int year = Integer.parseInt(yearField.getText());
                int doors = Integer.parseInt(doorsField.getText());
                double fuelCapacity = Double.parseDouble(fuelCapacityField.getText());
                int range = Integer.parseInt(rangeField.getText());
                int extraLoad = Integer.parseInt(extraLoadField.getText());
    
                // Check for empty input fields
                if (make.isEmpty() || model.isEmpty()) {
                    throw new IllegalArgumentException("Make and Model cannot be empty.");
                }
    
                Vehicle car = new Vehicle(make, model, year, doors, fuelCapacity, range);
                double mpg;
    
                if (withLoad) {
                    mpg = car.calcMPG(extraLoad);
                } else {
                    mpg = car.calcMPG();
                }
    
                JOptionPane.showMessageDialog(null, "Calculated MPG: " + mpg);
    
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numeric values for Year, Doors, Fuel Capacity, Range, and Extra Load.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    class TruckInfoGUI extends JFrame {
        private JTextField makeField, modelField, yearField, doorsField, fuelCapacityField, rangeField, towingCapacityField, payloadCapacityField, extraLoadField;
        private JButton calcWithoutLoadButton, calcWithLoadButton;

        public TruckInfoGUI() {
            setTitle("Truck Information");
            setSize(400, 500);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(null);

            JLabel makeLabel = new JLabel("Make:");
            makeLabel.setBounds(20, 20, 100, 30);
            makeField = new JTextField();
            makeField.setBounds(150, 20, 150, 30);

            JLabel modelLabel = new JLabel("Model:");
            modelLabel.setBounds(20, 60, 100, 30);
            modelField = new JTextField();
            modelField.setBounds(150, 60, 150, 30);

            JLabel yearLabel = new JLabel("Year:");
            yearLabel.setBounds(20, 100, 100, 30);
            yearField = new JTextField();
            yearField.setBounds(150, 100, 150, 30);

            JLabel doorsLabel = new JLabel("Number of Doors:");
            doorsLabel.setBounds(20, 140, 150, 30);
            doorsField = new JTextField();
            doorsField.setBounds(150, 140, 150, 30);

            JLabel fuelCapacityLabel = new JLabel("Fuel Tank Capacity:");
            fuelCapacityLabel.setBounds(20, 180, 150, 30);
            fuelCapacityField = new JTextField();
            fuelCapacityField.setBounds(150, 180, 150, 30);

            JLabel rangeLabel = new JLabel("Driving Range:");
            rangeLabel.setBounds(20, 220, 100, 30);
            rangeField = new JTextField();
            rangeField.setBounds(150, 220, 150, 30);

            JLabel towingCapacityLabel = new JLabel("Towing Capacity:");
            towingCapacityLabel.setBounds(20, 260, 150, 30);
            towingCapacityField = new JTextField();
            towingCapacityField.setBounds(150, 260, 150, 30);

            JLabel payloadCapacityLabel = new JLabel("Payload Capacity:");
            payloadCapacityLabel.setBounds(20, 300, 150, 30);
            payloadCapacityField = new JTextField();
            payloadCapacityField.setBounds(150, 300, 150, 30);

            JLabel extraLoadLabel = new JLabel("Extra Load:");
            extraLoadLabel.setBounds(20, 340, 100, 30);
            extraLoadField = new JTextField();
            extraLoadField.setBounds(150, 340, 150, 30);

            calcWithoutLoadButton = new JButton("Calculate MPG (No Load)");
            calcWithoutLoadButton.setBounds(20, 380, 280, 30);
            calcWithoutLoadButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    calculateMPG(false);
                }
            });

            calcWithLoadButton = new JButton("Calculate MPG (With Load)");
            calcWithLoadButton.setBounds(20, 420, 280, 30);
            calcWithLoadButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    calculateMPG(true);
                }
            });

            add(makeLabel);
            add(makeField);
            add(modelLabel);
            add(modelField);
            add(yearLabel);
            add(yearField);
            add(doorsLabel);
            add(doorsField);
            add(fuelCapacityLabel);
            add(fuelCapacityField);
            add(rangeLabel);
            add(rangeField);
            add(towingCapacityLabel);
            add(towingCapacityField);
            add(payloadCapacityLabel);
            add(payloadCapacityField);
            add(extraLoadLabel);
            add(extraLoadField);
            add(calcWithoutLoadButton);
            add(calcWithLoadButton);

            setVisible(true);
        }

        private void calculateMPG(boolean withLoad) {
            try {
                String make = makeField.getText();
                String model = modelField.getText();
                int year = Integer.parseInt(yearField.getText());
                int doors = Integer.parseInt(doorsField.getText());
                double fuelCapacity = Double.parseDouble(fuelCapacityField.getText());
                int range = Integer.parseInt(rangeField.getText());
                int towingCapacity = Integer.parseInt(towingCapacityField.getText());
                int payloadCapacity = Integer.parseInt(payloadCapacityField.getText());
                int extraLoad = Integer.parseInt(extraLoadField.getText());
    
                // Check for empty input fields
                if (make.isEmpty() || model.isEmpty()) {
                    throw new IllegalArgumentException("Make and Model cannot be empty.");
                }
    
                Truck truck = new Truck(make, model, year, doors, fuelCapacity, range, towingCapacity, payloadCapacity);
                double mpg;
    
                if (withLoad) {
                    mpg = truck.calcMPG(extraLoad);
                } else {
                    mpg = truck.calcMPG();
                }
    
                JOptionPane.showMessageDialog(null, "Calculated MPG: " + mpg);
    
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numeric values for Year, Doors, Fuel Capacity, Range, Towing Capacity, Payload Capacity, and Extra Load.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static void main(String[] args) {
        new Main();
    }
}
