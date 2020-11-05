import javax.swing.*;

public class GUI {

    private static JLabel temperatureInputType;
    private static JLabel temperatureOutputType;
    private static JLabel temperatureValue;
    private static JLabel temperatureResult;

    private static JComboBox temperatureInputTypeUser;
    private static JComboBox temperatureOutputTypeUser;

    private static JTextField temperatureValueUser;

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
        panel.add(temperatureValueUser);

        // temperature input type
        temperatureInputType = new JLabel("Temperature unit: ");
        temperatureInputType.setBounds(20, 100, 200, 20);
        panel.add(temperatureInputType);

        String[] temperatureTypes = {"Celsius", "Kelvin", "Rankine", "Fahrenheit"};
        temperatureInputTypeUser = new JComboBox(temperatureTypes);
        temperatureInputTypeUser.setBounds(20, 130, 200, 20);
        panel.add(temperatureInputTypeUser);

        // temperature output type
        temperatureOutputType = new JLabel("Temperature output type: ");
        temperatureOutputType.setBounds(20, 200, 200, 20);
        panel.add(temperatureOutputType);

        temperatureOutputTypeUser = new JComboBox(temperatureTypes);
        temperatureOutputTypeUser.setBounds(20, 230, 200, 20);
        panel.add(temperatureOutputTypeUser);

        // temperature results
        temperatureResult = new JLabel("");
        frame.setVisible(true);
    }
}
