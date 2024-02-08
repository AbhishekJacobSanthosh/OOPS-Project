import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Abstract Currency class representing a currency
abstract class Currency {
    private String code;
    private String name;
    private String symbol;

    public Currency(String code, String name,String symbol) {
        this.code = code;
        this.name = name;
        this.symbol=symbol;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbol(){
        return symbol;
    }

    // Abstract method to convert from this currency to another
    public abstract double convertTo(Currency targetCurrency, double amount);

    // Abstract method to get conversion rate from this currency to another
    public abstract double getConversionRateTo(Currency targetCurrency);

    // Abstract method to get conversion rate from another currency to this
    public abstract double getConversionRateFrom(Currency sourceCurrency);
}

// Concrete classes for different currencies
class USDollar extends Currency {
    public USDollar() {
        super("USD", "US Dollar","$");
    }

    @Override
    public double convertTo(Currency targetCurrency, double amount) {
        return amount * targetCurrency.getConversionRateFrom(this);
    }

    @Override
    public double getConversionRateTo(Currency targetCurrency) {
        // Replace with actual conversion rates
        if (targetCurrency instanceof IndianRupee) {
            return 83.12; // 1 USD = 73.55 INR
        } else if (targetCurrency instanceof Euro) {
            return 0.92; // 1 USD = 0.90 EUR
        } else if (targetCurrency instanceof JapaneseYen) {
            return 147.63; // 1 USD = 110.00 JPY
        } else if (targetCurrency instanceof BritishPound) {
            return 0.78; // 1 USD = 0.75 GBP
        } else {
            // Add more conversion rates as needed
            return 0.0;
        }
    }

    @Override
    public double getConversionRateFrom(Currency sourceCurrency) {
        // Replace with actual conversion rates
        if (sourceCurrency instanceof IndianRupee) {
            return 1 / 83.12; // 1 INR = 0.014 USD
        } else if (sourceCurrency instanceof Euro) {
            return 1 / 0.92; // 1 EUR = 1.11 USD
        } else if (sourceCurrency instanceof JapaneseYen) {
            return 1 / 147.63; // 1 JPY = 0.0091 USD
        } else if (sourceCurrency instanceof BritishPound) {
            return 1 / 0.78; // 1 GBP = 1.33 USD
        } else {
            // Add more conversion rates as needed
            return 0.0;
        }
    }
}

class IndianRupee extends Currency {
    public IndianRupee() {
        super("INR", "Indian Rupee","₹");
    }

    @Override
    public double convertTo(Currency targetCurrency, double amount) {
        return amount / targetCurrency.getConversionRateTo(this);
    }

    @Override
    public double getConversionRateTo(Currency targetCurrency) {
        // Replace with actual conversion rates
        if (targetCurrency instanceof USDollar) {
            return 1 / 83.55; // 1 USD = 73.55 INR
        } else if (targetCurrency instanceof Euro) {
            return 1 / 90.43; // 1 EUR = 88.50 INR
        } else if (targetCurrency instanceof JapaneseYen) {
            return 1 / 0.56; // 1 JPY = 0.66 INR
        } else if (targetCurrency instanceof BritishPound) {
            return 1 / 106.00; // 1 GBP = 100.40 INR
        } else {
            // Add more conversion rates as needed
            return 0.0;
        }
    }

    @Override
    public double getConversionRateFrom(Currency sourceCurrency) {
        // Replace with actual conversion rates
        if (sourceCurrency instanceof USDollar) {
            return 83.55; // 1 INR = 0.014 USD
        } else if (sourceCurrency instanceof Euro) {
            return 90.43; // 1 INR = 0.011 EUR
        } else if (sourceCurrency instanceof JapaneseYen) {
            return 0.56; // 1 INR = 1.52 JPY
        } else if (sourceCurrency instanceof BritishPound) {
            return 106.00; // 1 INR = 0.0099 GBP
        } else {
            // Add more conversion rates as needed
            return 0.0;
        }
    }
}

class Euro extends Currency {
    public Euro() {
        super("EUR", "Euro","€");
    }

    @Override
    public double convertTo(Currency targetCurrency, double amount) {
        return amount * targetCurrency.getConversionRateFrom(this);
    }

    @Override
    public double getConversionRateTo(Currency targetCurrency) {
        // Replace with actual conversion rates
        if (targetCurrency instanceof USDollar) {
            return 1.09; // 1 USD = 0.90 EUR
        } else if (targetCurrency instanceof IndianRupee) {
            return 90.41; // 1 EUR = 88.50 INR
        } else if (targetCurrency instanceof JapaneseYen) {
            return 160.54; // 1 EUR = 127.95 JPY
        } else if (targetCurrency instanceof BritishPound) {
            return 0.85; // 1 EUR = 0.86 GBP
        } else {
            // Add more conversion rates as needed
            return 0.0;
        }
    }

    @Override
    public double getConversionRateFrom(Currency sourceCurrency) {
        // Replace with actual conversion rates
        if (sourceCurrency instanceof USDollar) {
            return 1 / 1.09; // 1 USD = 0.90 EUR
        } else if (sourceCurrency instanceof IndianRupee) {
            return 1 / 90.41; // 1 INR = 0.011 EUR
        } else if (sourceCurrency instanceof JapaneseYen) {
            return 1 / 160.54; // 1 JPY = 0.0078 EUR
        } else if (sourceCurrency instanceof BritishPound) {
            return 1 / 0.85; // 1 GBP = 1.16 EUR
        } else {
            // Add more conversion rates as needed
            return 0.0;
        }
    }
}

class JapaneseYen extends Currency {
    public JapaneseYen() {
        super("JPY", "Japanese Yen","¥");
    }

    @Override
    public double convertTo(Currency targetCurrency, double amount) {
        return amount * targetCurrency.getConversionRateFrom(this);
    }

    @Override
    public double getConversionRateTo(Currency targetCurrency) {
        // Replace with actual conversion rates
        if (targetCurrency instanceof USDollar) {
            return 1 / 147.59; // 1 USD = 110.00 JPY
        } else if (targetCurrency instanceof IndianRupee) {
            return 0.56; // 1 INR = 1.52 JPY
        } else if (targetCurrency instanceof Euro) {
            return 1 / 160.54; // 1 EUR = 127.95 JPY
        } else if (targetCurrency instanceof BritishPound) {
            return 1 / 188.23; // 1 GBP = 151.85 JPY
        } else {
            // Add more conversion rates as needed
            return 0.0;
        }
    }

    @Override
    public double getConversionRateFrom(Currency sourceCurrency) {
        // Replace with actual conversion rates
        if (sourceCurrency instanceof USDollar) {
            return 147.59; // 1 JPY = 0.0091 USD
        } else if (sourceCurrency instanceof IndianRupee) {
            return 1.78; // 1 JPY = 1.52 INR
        } else if (sourceCurrency instanceof Euro) {
            return 160.54; // 1 JPY = 0.0078 EUR
        } else if (sourceCurrency instanceof BritishPound) {
            return 188.23; // 1 JPY = 0.0066 GBP
        } else {
            // Add more conversion rates as needed
            return 0.0;
        }
    }
}

class BritishPound extends Currency {
    public BritishPound() {
        super("GBP", "British Pound","£");
    }

    @Override
    public double convertTo(Currency targetCurrency, double amount) {
        return amount * targetCurrency.getConversionRateFrom(this);
    }

    @Override
    public double getConversionRateTo(Currency targetCurrency) {
        // Replace with actual conversion rates
        if (targetCurrency instanceof USDollar) {
            return 1.27; // 1 USD = 0.75 GBP
        } else if (targetCurrency instanceof IndianRupee) {
            return 105.98; // 1 INR = 0.0099 GBP
        } else if (targetCurrency instanceof Euro) {
            return 1.17; // 1 EUR = 0.86 GBP
        } else if (targetCurrency instanceof JapaneseYen) {
            return 188.23; // 1 JPY = 0.0066 GBP
        } else {
            // Add more conversion rates as needed
            return 0.0;
        }
    }

    @Override
    public double getConversionRateFrom(Currency sourceCurrency) {
        // Replace with actual conversion rates
        if (sourceCurrency instanceof USDollar) {
            return 1 / 1.27; // 1 GBP = 1.33 USD
        } else if (sourceCurrency instanceof IndianRupee) {
            return 1 / 105.98; // 1 GBP = 0.0099 INR
        } else if (sourceCurrency instanceof Euro) {
            return 1 / 1.17; // 1 GBP = 1.16 EUR
        } else if (sourceCurrency instanceof JapaneseYen) {
            return 1 / 188.23; // 1 GBP = 151.85 JPY
        } else {
            // Add more conversion rates as needed
            return 0.0;
        }
    }
}

// Class representing the Currency Converter
class CurrencyConverterOOP extends JFrame {

    Currency[] currencies = { new USDollar(), new IndianRupee(), new Euro(), new JapaneseYen(), new BritishPound() };
    String[] currencynames = { "US Dollar", "Indian Rupee", "Euro", "Japanese Yen", "British Pounds" };

    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JTextField amountTextField;
    private JTextField resultTextField;

    public CurrencyConverterOOP() {
        setTitle("Currency Converter (OOP)");
        setLayout(null);

        // Creating labels
        JLabel fromLabel = new JLabel("From Currency:");
        fromLabel.setBounds(20, 40, 100, 30);
        JLabel toLabel = new JLabel("To Currency:");
        toLabel.setBounds(300, 40, 100, 30);
        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(100, 80, 100, 30);
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(100, 120, 100, 30);

        // Creating combo boxes

        fromCurrencyComboBox = new JComboBox<>(currencynames);
        fromCurrencyComboBox.setBounds(120, 40, 100, 30);
        toCurrencyComboBox = new JComboBox<>(currencynames);
        toCurrencyComboBox.setBounds(375, 40, 100, 30);

        // Creating text fields
        amountTextField = new JTextField("0");
        amountTextField.setBounds(165, 80, 200, 30);
        resultTextField = new JTextField("0");
        resultTextField.setBounds(165, 120, 200, 30);
        resultTextField.setEditable(false);

        // Creating buttons
        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(185, 160, 100, 30);
        JButton closeButton = new JButton("Close");
        closeButton.setBounds(185, 200, 100, 30);

        // Adding action listeners
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Adding components to the frame
        add(fromLabel);
        add(fromCurrencyComboBox);
        add(toLabel);
        add(toCurrencyComboBox);
        add(amountLabel);
        add(amountTextField);
        add(resultLabel);
        add(resultTextField);
        add(convertButton);
        add(closeButton);

        setSize(510, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void convert() {
        int fromCurrencyIndex = fromCurrencyComboBox.getSelectedIndex();
        int toCurrencyIndex = toCurrencyComboBox.getSelectedIndex();
        double amount = Double.parseDouble(amountTextField.getText());

        Currency fromCurrency = currencies[fromCurrencyIndex];
        Currency toCurrency = currencies[toCurrencyIndex];

        double result = fromCurrency.convertTo(toCurrency, amount);

        // Display the result with currency symbol
        amountTextField.setText(fromCurrency.getSymbol() + " " + String.valueOf(amount));
        resultTextField.setText(toCurrency.getSymbol() + " " + String.valueOf(result));
    }
}


public class CurrencyConverterStartPage extends JFrame {

    public CurrencyConverterStartPage() {
        setTitle("Currency Converter Start Page");
        setLayout(new BorderLayout());

        // Logo panel
        JPanel logoPanel = new JPanel();
        ImageIcon logoIcon = new ImageIcon("/home/guest1/Downloads/Ramaiah.png"); // Change "logo.png" to the path of your logo file
        JLabel logoLabel = new JLabel(logoIcon);
        logoPanel.add(logoLabel);
        add(logoPanel, BorderLayout.NORTH);

        // Title
        JLabel titleLabel = new JLabel("Welcome to Currency Converter");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.CENTER);

        // Continue button
        JPanel buttonPanel = new JPanel();
        JButton continueButton = new JButton("Continue");
        buttonPanel.add(continueButton);
        add(buttonPanel, BorderLayout.SOUTH);

        continueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the start page
                new CurrencyConverterOOP(); // Open the currency converter GUI
            }
        });

        setSize(400, 300); // Adjust size to accommodate the logo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CurrencyConverterStartPage();
    }
}