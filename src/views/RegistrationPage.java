package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class RegistrationPage extends JPanel {
    private JTextField username, fullName;
    private JPasswordField password, confirmPassword;
    private JLabel errMsg;
    private JButton loginBtn, registerBtn;

    public RegistrationPage() {
        var inputBoxSize = new Dimension(MainWindow.widthFactor(0.2), MainWindow.heightFactor(0.06));
        setLayout(new GridBagLayout());
        setBorder(new EmptyBorder(20, 20, 20, 20));

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;

        // heading
        add(new JLabel("<html><h1><i><strong>Login to the Game</strong></i></h1></html>"), gridBagConstraints);

        // anchor items to the center
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        var grid = new JPanel();
        grid.setLayout(new GridBagLayout());

        var row1 = new JPanel();
        row1.setLayout(new FlowLayout());

        var usrLabel = new JLabel("Username: ");
        usrLabel.setFont(new Font("Serif", Font.BOLD, 20));
        row1.add(usrLabel);

        username = new JTextField();
        username.setFont(new Font("Serif", Font.BOLD, 20));
        username.setPreferredSize(inputBoxSize);
        row1.add(username);
        grid.add(row1, gridBagConstraints);

        var nameLabel = new JLabel("Full Name: ");
        nameLabel.setFont(new Font("Serif", Font.BOLD, 20));
        row1.add(nameLabel);

        fullName = new JTextField();
        fullName.setFont(new Font("Serif", Font.BOLD, 20));
        fullName.setPreferredSize(inputBoxSize);
        row1.add(fullName);
        grid.add(row1, gridBagConstraints);

        var row2 = new JPanel();
        row2.setLayout(new FlowLayout());

        var pwdLabel = new JLabel("Password: ");
        pwdLabel.setFont(new Font("Serif", Font.BOLD, 20));
        row2.add(pwdLabel);

        password = new JPasswordField();
        password.setFont(new Font("Serif", Font.BOLD, 20));
        password.setPreferredSize(inputBoxSize);
        row2.add(password);
        grid.add(row2, gridBagConstraints);

        var cnfLabel = new JLabel("Confirm Password: ");
        cnfLabel.setFont(new Font("Serif", Font.BOLD, 20));
        row2.add(cnfLabel);

        confirmPassword = new JPasswordField();
        confirmPassword.setFont(new Font("Serif", Font.BOLD, 20));
        confirmPassword.setPreferredSize(inputBoxSize);
        row2.add(confirmPassword);
        grid.add(row2, gridBagConstraints);

        gridBagConstraints.weighty = 1;
        add(grid, gridBagConstraints);

        errMsg = new JLabel("");
        errMsg.setFont(new Font("Serif", Font.BOLD, 15));
        errMsg.setHorizontalAlignment(JLabel.CENTER);
        errMsg.setForeground(Color.red);
        grid.add(errMsg, gridBagConstraints);

        var gap = new JLabel(" ");
        gap.setFont(new Font("Serif", Font.BOLD, 25));
        grid.add(gap, gridBagConstraints);

        registerBtn = new JButton("Sign Up");
        registerBtn.setPreferredSize(inputBoxSize);
        registerBtn.setFont(new Font("Serif", Font.BOLD, 25));
        grid.add(registerBtn, gridBagConstraints);

        loginBtn = new JButton("Log In");
        loginBtn.setPreferredSize(inputBoxSize);
        loginBtn.setFont(new Font("Serif", Font.BOLD, 25));
        grid.add(loginBtn, gridBagConstraints);
    }

    public JTextField getUsername() {
        return username;
    }

    public JTextField getPassword() {
        return password;
    }

    public JLabel getErrMsg() {
        return errMsg;
    }

    public JButton getLoginBtn() {
        return loginBtn;
    }

    public JTextField getFullName() {
        return fullName;
    }

    public JTextField getConfirmPassword() {
        return confirmPassword;
    }

    public JButton getRegisterBtn() {
        return registerBtn;
    }
}
