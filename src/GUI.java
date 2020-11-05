import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private static String[] temperatureTypes = {"Celsius", "Kelvin", "Fahrenheit"};

    private static JLabel temperatureInputType;
    private static JLabel temperatureOutputType;
    private static JLabel temperatureValue;
    private static JLabel temperatureResult;
    private static JLabel stateResult;

    private static JComboBox temperatureInputTypeUser;
    private static JComboBox temperatureOutputTypeUser;

    private static JTextField temperatureValueUser;

    // variables for main method functionality w/ temp conversions
    private static int mainTemperatureInputType;
    private static int mainTemperatureOutputType;
    private static double mainTemperatureValue;

    public static void main(String[] args) {
        // set up basic frame/panel
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setSize(450, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);

        // set up any buttons/labels/input areas
        //temperature value input
        temperatureValue = new JLabel("Temperature value: ");
        temperatureValue.setBounds(20, 20, 200, 20);
        panel.add(temperatureValue);

        temperatureValueUser = new JTextField();
        temperatureValueUser.setBounds(20, 50, 200, 20);
        temperatureValueUser.addActionListener(new GUI());
        panel.add(temperatureValueUser);

        // temperature input type
        temperatureInputType = new JLabel("Temperature unit: ");
        temperatureInputType.setBounds(20, 100, 200, 20);
        panel.add(temperatureInputType);

        temperatureInputTypeUser = new JComboBox(temperatureTypes);
        temperatureInputTypeUser.setBounds(20, 130, 200, 20);
        temperatureInputTypeUser.addActionListener(new GUI());
        panel.add(temperatureInputTypeUser);

        // temperature output type
        temperatureOutputType = new JLabel("Temperature output type: ");
        temperatureOutputType.setBounds(20, 200, 200, 20);
        panel.add(temperatureOutputType);

        temperatureOutputTypeUser = new JComboBox(temperatureTypes);
        temperatureOutputTypeUser.setBounds(20, 230, 200, 20);
        temperatureOutputTypeUser.addActionListener(new GUI());
        panel.add(temperatureOutputTypeUser);

        // temperature results
        temperatureResult = new JLabel("");
        temperatureResult.setBounds(20, 300, 200, 20);
        panel.add(temperatureResult);

        stateResult = new JLabel();
        stateResult.setBounds(20, 330, 200, 20);
        panel.add(stateResult);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == temperatureValueUser) {
            mainTemperatureValue = Double.parseDouble(temperatureValueUser.getText());
            System.out.println(mainTemperatureValue);
        }
        else if (e.getSource() == temperatureInputTypeUser) {
            mainTemperatureInputType = temperatureInputTypeUser.getSelectedIndex();
        }
        else {
            mainTemperatureOutputType = temperatureOutputTypeUser.getSelectedIndex();
            System.out.println(mainTemperatureOutputType);
        }

        if (mainTemperatureInputType == mainTemperatureOutputType) {
            // will not change if the type is the same
            temperatureResult.setText(Math.round(mainTemperatureValue) + " in " + temperatureTypes[mainTemperatureOutputType]);
        }
        else if (mainTemperatureInputType == 0 && mainTemperatureOutputType == 1) {
            // Celsius to Kelvin
            temperatureResult.setText(Math.round(mainTemperatureValue + 273.15) + " in " + temperatureTypes[mainTemperatureOutputType]);
        }
        else if (mainTemperatureInputType == 1 && mainTemperatureOutputType == 0) {
            // Kelvin to Celsius
            temperatureResult.setText(Math.round(mainTemperatureValue - 273.15) + " in " + temperatureTypes[mainTemperatureOutputType]);
        }
        else if (mainTemperatureInputType == 1 && mainTemperatureOutputType == 2) {
            // Kelvin to Fahrenheit
            temperatureResult.setText(Math.round((mainTemperatureValue * (1.8)) - 459.67) + " in " + temperatureTypes[mainTemperatureOutputType]);
        }
        else if (mainTemperatureInputType == 2 && mainTemperatureOutputType == 1) {
            // Fahrenheit to Kelvin
            temperatureResult.setText(Math.round((mainTemperatureValue + 459.67) * (0.56)) + " in " + temperatureTypes[mainTemperatureOutputType]);
        }
        else if (mainTemperatureInputType == 0 && mainTemperatureOutputType == 2) {
            // Celsius to Fahrenheit
            temperatureResult.setText(Math.round((1.8 * mainTemperatureValue + 32)) + " in " + temperatureTypes[mainTemperatureOutputType]);
        }
        else if (mainTemperatureInputType == 2 && mainTemperatureOutputType == 0) {
            // Fahrenheit to celsius
            temperatureResult.setText(Math.round((mainTemperatureValue - 32) * (0.56)) + " in " + temperatureTypes[mainTemperatureOutputType]);

        }

        double convertedTemperature;
        if (mainTemperatureInputType == 1) {
            convertedTemperature = mainTemperatureValue - 273.15;
        }
        else if (mainTemperatureInputType == 2) {
            convertedTemperature = (mainTemperatureValue - 32) * (0.56);
        }
        else {
            convertedTemperature = mainTemperatureValue;
        }

        if (convertedTemperature <= 0) {
            stateResult.setText("The water is freezing");
        } else if (convertedTemperature < 100) {
            stateResult.setText("The water is liquid");
        } else {
            stateResult.setText("The water is a gas");
        }
    }
}
