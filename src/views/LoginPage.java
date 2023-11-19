package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class LoginPage extends JPanel {
    private JTextField username;
    private JPasswordField password;
    private JLabel errMsg;
    private JButton loginBtn;

    public LoginPage() {
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
}
