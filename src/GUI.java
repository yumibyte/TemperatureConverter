import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private static JLabel temperatureInputType;
    private static JLabel temperatureOutputType;
    private static JLabel temperatureValue;
    private static JLabel temperatureResult;

    private static JComboBox temperatureInputTypeUser;
    private static JComboBox temperatureOutputTypeUser;

    private static JTextField temperatureValueUser;

    // variables for main method functionality w/ temp conversions
    private static String mainTemperatureInputType;
    private static String mainTemperatureOutputType;
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

        String[] temperatureTypes = {"Celsius", "Kelvin", "Rankine", "Fahrenheit"};
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



        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == temperatureValueUser) {
            mainTemperatureValue = Double.parseDouble(temperatureValueUser.getText());
            System.out.println(mainTemperatureValue);

        }
        else if (e.getSource() == temperatureInputTypeUser) {
            mainTemperatureInputType = (String) temperatureInputTypeUser.getSelectedItem();
            System.out.println(mainTemperatureInputType);
        }
        else {
            mainTemperatureOutputType = (String) temperatureOutputTypeUser.getSelectedItem();
            System.out.println(mainTemperatureOutputType);

        }


    }
}
