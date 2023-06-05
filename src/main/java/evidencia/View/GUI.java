package evidencia.View;
import evidencia.model.Oddelenie;
import evidencia.model.Pohlavie;
import evidencia.model.SetGet;
import evidencia.service.Service;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Timer;
import javax.swing.*;
public class GUI implements ActionListener {



    private SetGet vybranyList;
    private DefaultListModel<SetGet> Zoznam;
    private JList<SetGet> jList;
    public static final SimpleDateFormat timeFormat = new SimpleDateFormat("EEEE, d MMM HH:mm:ss");
    public static JLabel timeLabel;
    private ArrayList<SetGet> CelkovyZoznam;

    public void Frame() throws RuntimeException {


        JPanel loginPanel = new JPanel();
        JFrame loginFrame = new JFrame();
        loginFrame.setSize(350,200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setVisible(true);
        loginFrame.setResizable(false);
        loginPanel.setLayout(null);
        loginFrame.setLocationRelativeTo(null);

        loginFrame.add(loginPanel);

        JLabel user = new JLabel("User");
        user.setBounds(10,20,80,25);
        loginPanel.add(user);

        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        loginPanel.add(userText);

        JLabel password = new JLabel("Password");
        password.setBounds(10,50,80,25);
        loginPanel.add(password);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        loginPanel.add(passwordText);

        JButton login = new JButton("Login");
        login.setBounds(10,80,80,25);
        loginPanel.add(login);

        JLabel wrong = new JLabel("");
        wrong.setBounds(10,110,300,25);
        loginPanel.add(wrong);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = passwordText.getText();

                if (user.equals("123") && password.equals("123")) {
                    loginFrame.dispose();


                    JFrame frame = new JFrame("Evidencia pracovnikov GUI");
                    frame.setMinimumSize(new Dimension(950, 400));
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLocationRelativeTo(null);

                    JPanel panel = new JPanel();
                    panel.setLayout(null);
                    frame.setContentPane(panel);

                    frame.pack();
                    frame.setResizable(false);
                    frame.setVisible(true);

                    //OSOBNECISLO,DATUMNARODENIA,TITUL,MENO,PRIEZVISKO,POHLAVIE,ODDELENIE

                    JButton ulozZmeny = new JButton("Ulož zmeny");
                    ulozZmeny.setBounds(260, 335, 100, 15);
                    panel.add(ulozZmeny);
                    ulozZmeny.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Service ulozDoListu = new Service();
                            System.out.println("zmeny v liste sa ulozili.");
                            try {
                                ulozDoListu.ulozDoSuboru(CelkovyZoznam, "zoznam.ser");
                            } catch (IOException e1) {
                                throw new RuntimeException(e1);
                            }

                        }
                    });

                    JButton skuska = new JButton("Načítaj");
                    skuska.setBounds(370, 335, 100, 15);
                    panel.add(skuska);
                    skuska.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Service list = new Service();
                            try {
                                CelkovyZoznam = list.orvorZoSuboru("zoznam.ser");
                                Zoznam.clear();
                                for (SetGet listZoznamu : CelkovyZoznam) {
                                    Zoznam.addElement(listZoznamu);
                                }
                                jList.updateUI();
                            } catch (IOException e1) {
                                throw new RuntimeException(e1);
                            } catch (ClassNotFoundException e2) {
                                throw new RuntimeException(e2);
                            }
                        }
                    });
                    Zoznam = new DefaultListModel<>();
                    jList = new JList<>(Zoznam);

                    JButton pridaj = new JButton("Pridaj");
                    pridaj.setBounds(40, 335, 100, 15);

                    panel.add(pridaj);
                    pridaj.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame framelEZ = new JFrame("nová evidencia");
                            framelEZ.setMinimumSize(new Dimension(900, 150));
                            framelEZ.setResizable(false);
                            framelEZ.setLocationRelativeTo(null);
                            framelEZ.setVisible(true);
                            JPanel panelEZ = new JPanel();
                            panelEZ.setLayout(null);
                            framelEZ.setContentPane(panelEZ);

                            JLabel labelOsobneCislo = new JLabel("Osobné číslo");
                            labelOsobneCislo.setBounds(10, 2, 100, 20);
                            panelEZ.add(labelOsobneCislo);

                            JTextField osobneCislo = new JTextField();
                            osobneCislo.setBounds(10, 20, 100, 20);
                            osobneCislo.setHorizontalAlignment(JTextField.LEFT);
                            panelEZ.add(osobneCislo);

                            JLabel labelDatumNarodenia = new JLabel("Datum narodenia");
                            labelDatumNarodenia.setBounds(120, 2, 100, 20);
                            panelEZ.add(labelDatumNarodenia);

                            JTextField datumNarodenia = new JTextField();
                            datumNarodenia.setBounds(120, 20, 100, 20);
                            datumNarodenia.setHorizontalAlignment(JTextField.LEFT);
                            panelEZ.add(datumNarodenia);

                            JLabel labelDatumNastupu = new JLabel("Datum nastupu");
                            labelDatumNastupu.setBounds(230, 2, 100, 20);
                            panelEZ.add(labelDatumNastupu);

                            JTextField datumNastupu = new JTextField();
                            datumNastupu.setBounds(230, 20, 100, 20);
                            datumNastupu.setHorizontalAlignment(JTextField.LEFT);
                            panelEZ.add(datumNastupu);

                            JLabel labelTitul = new JLabel("Titul");
                            labelTitul.setBounds(340, 2, 100, 20);
                            panelEZ.add(labelTitul);

                            String[] Titul = {"BC", "MGR", "MUDR", "PHD", "ING"};
                            JComboBox comboTitul = new JComboBox<>(Titul);
                            comboTitul.setBounds(340, 20, 100, 20);
                            panelEZ.add(comboTitul);

                            JLabel labelMeno = new JLabel("Meno");
                            labelMeno.setBounds(450, 2, 100, 20);
                            panelEZ.add(labelMeno);

                            JTextField meno = new JTextField();
                            meno.setBounds(450, 20, 100, 20);
                            meno.setHorizontalAlignment(JTextField.LEFT);
                            panelEZ.add(meno);

                            JLabel labelPriezvisko = new JLabel("Priezvisko");
                            labelPriezvisko.setBounds(560, 2, 100, 20);
                            panelEZ.add(labelPriezvisko);

                            JTextField priezvisko = new JTextField();
                            priezvisko.setBounds(560, 20, 100, 20);
                            priezvisko.setHorizontalAlignment(JTextField.LEFT);
                            panelEZ.add(priezvisko);

                            JLabel labelPohlavie = new JLabel("Pohlavie");
                            labelPohlavie.setBounds(670, 2, 100, 20);
                            panelEZ.add(labelPohlavie);

                            String[] Spohlavie = {"ZENA", "MUZ"};
                            JComboBox comboPohlavie = new JComboBox<>(Spohlavie);
                            comboPohlavie.setBounds(670, 20, 100, 20);
                            panelEZ.add(comboPohlavie);

                            JLabel labelOdddelenie = new JLabel("Odddelenie");
                            labelOdddelenie.setBounds(780, 2, 100, 20);
                            panelEZ.add(labelOdddelenie);

                            String[] Soddelenie = {"PROGRAMATOR", "SOFTWARE_ARCHITEKT", "TESTER", "UX_UI", "DEVOPS", "MANAZER", "DATA_SCIENTIS"};
                            JComboBox comboOddelenie = new JComboBox<>(Soddelenie);
                            comboOddelenie.setBounds(780, 20, 100, 20);
                            panelEZ.add(comboOddelenie);

                            JButton uloz = new JButton("Ulož");
                            uloz.setBounds(5, 50, 100, 20);
                            panelEZ.add(uloz);
                            uloz.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    SetGet novyList = new SetGet(osobneCislo.getText(), datumNarodenia.getText(), datumNastupu.getText(),
                                            evidencia.model.Titul.valueOf(Objects.requireNonNull(comboTitul.getSelectedItem()).toString()), meno.getText(), priezvisko.getText(),
                                            Pohlavie.valueOf(Objects.requireNonNull(comboPohlavie.getSelectedItem().toString())), Oddelenie.valueOf(Objects.requireNonNull(comboOddelenie.getSelectedItem().toString())));
                                    Zoznam.addElement(novyList);
                                    CelkovyZoznam.add(novyList);
                                    jList.updateUI();
                                    framelEZ.dispatchEvent(new WindowEvent(framelEZ, WindowEvent.WINDOW_CLOSING));
                                }
                            });

                            JButton zrus = new JButton("Zruš");
                            zrus.setBounds(110, 50, 100, 20);
                            panelEZ.add(zrus);
                            zrus.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    framelEZ.dispatchEvent(new WindowEvent(framelEZ, WindowEvent.WINDOW_CLOSING));
                                }
                            });
                        }
                    });
                    JButton Potvrd = new JButton("Edit"); // tlacidlo
                    Potvrd.setBounds(150, 335, 100, 15); // x, y, sirka, vyska
                    panel.add(Potvrd);
                    Potvrd.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame framelEZ = new JFrame("úprava evidencie");
                            framelEZ.setMinimumSize(new Dimension(900, 150));
                            framelEZ.setResizable(false);
                            framelEZ.setLocationRelativeTo(null);
                            framelEZ.setVisible(true);
                            JPanel panelEZ = new JPanel();
                            panelEZ.setLayout(null);
                            framelEZ.setContentPane(panelEZ);

                            JLabel labelOsobneCislo = new JLabel("Osobné číslo");
                            labelOsobneCislo.setBounds(10, 2, 100, 20);
                            panelEZ.add(labelOsobneCislo);

                            JTextField osobneCislo = new JTextField();
                            osobneCislo.setBounds(10, 20, 100, 20);
                            osobneCislo.setHorizontalAlignment(JTextField.LEFT);
                            panelEZ.add(osobneCislo);

                            JLabel labelDatumNarodenia = new JLabel("Datum narodenia");
                            labelDatumNarodenia.setBounds(120, 2, 100, 20);
                            panelEZ.add(labelDatumNarodenia);

                            JTextField datumNarodenia = new JTextField();
                            datumNarodenia.setBounds(120, 20, 100, 20);
                            datumNarodenia.setHorizontalAlignment(JTextField.LEFT);
                            panelEZ.add(datumNarodenia);

                            JLabel labelDatumNastupu = new JLabel("Datum nastupu");
                            labelDatumNastupu.setBounds(230, 2, 100, 20);
                            panelEZ.add(labelDatumNastupu);

                            JTextField datumNastupu = new JTextField();
                            datumNastupu.setBounds(230, 20, 100, 20);
                            datumNastupu.setHorizontalAlignment(JTextField.LEFT);
                            panelEZ.add(datumNastupu);

                            JLabel labelTitul = new JLabel("Titul");
                            labelTitul.setBounds(340, 2, 100, 20);
                            panelEZ.add(labelTitul);

                            String[] Titul = {"BC", "MGR", "MUDR", "PHD", "ING"};
                            JComboBox comboTitul = new JComboBox<>(Titul);
                            comboTitul.setBounds(340, 20, 100, 20);
                            panelEZ.add(comboTitul);

                            JLabel labelMeno = new JLabel("Meno");
                            labelMeno.setBounds(450, 2, 100, 20);
                            panelEZ.add(labelMeno);

                            JTextField meno = new JTextField();
                            meno.setBounds(450, 20, 100, 20);
                            meno.setHorizontalAlignment(JTextField.LEFT);
                            panelEZ.add(meno);

                            JLabel labelPriezvisko = new JLabel("Priezvisko");
                            labelPriezvisko.setBounds(560, 2, 100, 20);
                            panelEZ.add(labelPriezvisko);

                            JTextField priezvisko = new JTextField();
                            priezvisko.setBounds(560, 20, 100, 20);
                            priezvisko.setHorizontalAlignment(JTextField.LEFT);
                            panelEZ.add(priezvisko);

                            JLabel labelPohlavie = new JLabel("Pohlavie");
                            labelPohlavie.setBounds(670, 2, 100, 20);
                            panelEZ.add(labelPohlavie);

                            String[] Spohlavie = {"ZENA", "MUZ"};
                            JComboBox comboPohlavie = new JComboBox<>(Spohlavie);
                            comboPohlavie.setBounds(670, 20, 100, 20);
                            panelEZ.add(comboPohlavie);

                            JLabel labelOdddelenie = new JLabel("Odddelenie");
                            labelOdddelenie.setBounds(780, 2, 100, 20);
                            panelEZ.add(labelOdddelenie);

                            String[] Soddelenie = {"PROGRAMATOR", "SOFTWARE_ARCHITEKT", "TESTER", "UX_UI", "DEVOPS", "MANAZER", "DATA_SCIENTIS"};
                            JComboBox comboOddelenie = new JComboBox<>(Soddelenie);
                            comboOddelenie.setBounds(780, 20, 100, 20);
                            panelEZ.add(comboOddelenie);

                            JButton uloz = new JButton("Ulož");
                            uloz.setBounds(5, 50, 100, 20);
                            panelEZ.add(uloz);

                            vybranyList = jList.getSelectedValue();
                            osobneCislo.setText(vybranyList.getOsobnecislo());
                            datumNarodenia.setText(vybranyList.getDatumNarodenia());
                            datumNastupu.setText(vybranyList.getDatumNastupu());
                           // titul.setText(vybranyList.getTitul().toString());
                            comboTitul.setSelectedItem(vybranyList.getTitul());
                            meno.setText(vybranyList.getMeno());
                            priezvisko.setText(vybranyList.getPriezvisko());
                            // pohlavie.setText(vybranyList.getPohlavie().toString());
                            // oddelenie.setText(vybranyList.getOddelenie().toString());
                            uloz.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    vybranyList.setOsobnecislo(osobneCislo.getText());
                                    vybranyList.setDatumNarodenia(datumNarodenia.getText());
                                    vybranyList.setDatumNastupu(datumNastupu.getText());
                                    vybranyList.setTitul(evidencia.model.Titul.valueOf(Objects.requireNonNull(comboTitul.getSelectedItem()).toString()));
                                    vybranyList.setMeno(meno.getText());
                                    vybranyList.setPriezvisko(priezvisko.getText());
                                    vybranyList.setPohlavie(evidencia.model.Pohlavie.valueOf(Objects.requireNonNull(comboPohlavie.getSelectedItem()).toString()));
                                    vybranyList.setOddelenie(evidencia.model.Oddelenie.valueOf(Objects.requireNonNull(comboOddelenie.getSelectedItem()).toString()));
                                    jList.updateUI();
                                    framelEZ.dispatchEvent(new WindowEvent(framelEZ, WindowEvent.WINDOW_CLOSING));
                                }
                            });
                            JButton zrus = new JButton("Zruš");
                            zrus.setBounds(110, 50, 100, 20);
                            panelEZ.add(zrus);
                            zrus.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    framelEZ.dispatchEvent(new WindowEvent(framelEZ, WindowEvent.WINDOW_CLOSING));
                                }
                            });
                        }
                    });
                    JScrollPane Scroll = new JScrollPane(jList);
                    Scroll.setBounds(40, 50, 850, 250);
                    panel.add(Scroll);
                    jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                    timeLabel = new JLabel();
                    timeLabel.setBounds(780,315,150,50);
                    frame.add(timeLabel);

                    java.util.Timer timer = new Timer();
                    timer.scheduleAtFixedRate(new Service.UpdateTimeTask(), 0, 1000);

                }else if (!user.equals("123") && !password.equals("123")) {
                    wrong.setText("zadal si nespávne meno a heslo");

                } else if (!user.equals("123")) {
                    wrong.setText("zadal si nespávne meno");

                } else {
                    wrong.setText("zadal si nesprávne heslo");
                }

            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }


    }
    //TODO vymazat evidenciu z listu
    //TODO fixnut comboBox v edite
    //TODO upravit nacitaj na log in




