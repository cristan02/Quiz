/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.quiz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class Quiz extends javax.swing.JFrame {

    /*
     * String[] questions ={
     * "What is 150 divided by 5?",
     * "Which of the following is the national animal of India?",
     * "6500 + 500 + 250 + 90 + 5 = ",
     * "When do we celebrate Indian Independence day?",
     * "Katie's birthday is in 51 weeks and 2 days, how many days are there untill Katie's birthday?"
     * ,
     * "Which of the following month has 31 days?",
     * "What is 11 * 11 ?",
     * "Young cat is also called?",
     * "What is 100 - 151 ?",
     * "Kuchipuddi is the dance form of which state?",
     * "What number must you add to 79 make the sum of 121?",
     * "Who invented Computer?",
     * "How many degrees is the right angle?",
     * "Gir National park in Gujarat is famous for?",
     * "The surface area of a sphere of radius 7cm is ___cm.sq.?",
     * "Highest dam of India is?",
     * "In a triangle if angle A is 45 degrees and angle B is 90, how much degrees is angle C?"
     * ,
     * "Agra is situated on the bank of river?",
     * "Amy has 200 balloons, 25 percent of the balloons are green,10 percent are orange and the remaining are blue .Can you work out how many blue balloons Amy has?"
     * ,
     * "Cataract is the  disease of?",
     * "The volume of water completely filled in a cylinder of height 7cm and radius 8cm is ___cm.sq?"
     * ,
     * "Capital of Uttarkhand is?",
     * "If there are 23 boys and 21 girls in class A and 21 boys and 27 girls in class B,how many girls and boys in total are there?"
     * ,
     * "Hitler party which came into power in 1933 was known as?",
     * "Which is the first product of two odd prime numbers?",
     * "Longest river in the world is?",
     * "Which of the following number is completely divisible by 2,3,4, and 5?",
     * "LBW is related to which sports?",
     * "Your mom is in the market, she bought 22kg of fish and 24kg of chicken, you ate 12kg of chicken and 4kg of fish,how many kg in total is left of the the two foods?"
     * ,
     * "Which of the following is an example of an output device of a computer?",
     * "Which company created Java?",
     * "Which year was Java created?",
     * "What was Java originally called?",
     * "Who is credited with creating Java?"
     * };
     * String[][] options = {
     * {"20","25","30","35"},
     * {"Lion","Tiger","Elephant","Rhinoceros"},
     * {"7300","7345","7500","7545"},
     * {"15th January","26th January","26th August","15th August"},
     * {"350","360","359","369"},
     * {"October","February","June","April"},
     * {"121","131","141","151"},
     * {"Calf","Kitten","Puppy","Cub"},
     * {"-51","51","None","IDK"},
     * {"Tail Nadu","Andra Pradesh","Karnataka","Kerala"},
     * {"40","41","43","42"},
     * {"Thomas Alva Edison","Pascal","Alexander Graham Bell","Charles Babbage"},
     * {"80","180","90","360"},
     * {"Elephant","Rhinncerus","Lion","Tiger"},
     * {"616","150","165","151"},
     * {"Hirakud Dam","Idukki Dam","Bakra Nangal Dam","Tehri Dam"},
     * {"35","45","55","65"},
     * {"Ganga","Yamuna","Narmada","Gomti"},
     * {"130","140","120","110"},
     * {"Ears","Lungs","Eyes","Heart"},
     * {"1408","1508","1608","1708"},
     * {"Lucknow","Allahabad","Dehradun","Ranchi"},
     * {"91","92","93","94"},
     * {"Labour party","Nazi party","Ku-Klux-Klan","Democratic party"},
     * {"13","15","17","11"},
     * {"Amazon","South-China sea","Ganga","Nile"},
     * {"1000","1100","1200","1300"},
     * {"Football","Hockey","Badminton","Cricket"} ,
     * {"24","26","28","30"},
     * {"Printer","Keyboard","Scanner","Mouse"},
     * {"Sun Microsystems","Starbucks","Microsoft","Alphabet"},
     * {"1989","1996","1972","1492"},
     * {"Apple","Latte","Oak","Koffing"},
     * {"Steve Jobs","Bill Gates","James Gosling","Mark Zuckerburg"}
     * };
     * char[] answers = {
     * 'C',
     * 'B',
     * 'B',
     * 'D',
     * 'C',
     * 'A',
     * 'A',
     * 'B',
     * 'A',
     * 'B',
     * 'D',
     * 'D',
     * 'C',
     * 'C',
     * 'A',
     * 'D',
     * 'B',
     * 'B',
     * 'A',
     * 'C',
     * 'A',
     * 'C',
     * 'B',
     * 'B',
     * 'B',
     * 'D',
     * 'C',
     * 'D',
     * 'D',
     * 'A',
     * 'A',
     * 'B',
     * 'C',
     * 'C'
     * };
     */
    int i;
    int part2_quest;
    int result1;
    int result2;
    int seconds;
    int part;
    int[] random = new int[10];
    int max;
    int min = 1;
    int tot_quest = 10;
    String answer;
    String name1;
    String name2;
    Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if (seconds <= 0) {
                {
                    tdown.setVisible(true);
                    displayAnswer();
                }
            }
        }
    });
    Connection con = null;
    PreparedStatement insert = null;

    public Quiz() {
        initComponents();
        setSize(650, 700);
        setResizable(false);
        quest_disp.setEditable(false);
        tdown.setVisible(false);
        tup.setVisible(false);
        questionpanel.setVisible(false);
        resultpanel.setVisible(false);
        welcomepanel.setVisible(true);
        start.setVisible(false);
        p1.setVisible(false);
        p2.setVisible(false);
        p1name.setVisible(false);
        p2name.setVisible(false);
        rankingpanel.setVisible(false);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Quiz", "root", "Dcunha@2002");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(quest_no) as max_quest From questions");
            if (rs.next())
                ;
            max = rs.getInt(1);
            // System.out.println(" " + max);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    int rand(int hold) {
        int r = (int) (Math.random() * (max - min + 1) + min);
        for (int j = 0; j < hold; j++) {
            if (r >= max)
                r = 0;
            if (r == random[j]) {
                r = r + 1;
                j = 0;
            }
        }
        return r;
    }

    void next_question() throws SQLException {

        tdown.setVisible(false);
        tup.setVisible(false);
        if (i == tot_quest) {
            result();
        } else {
            random[i] = rand(i);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Quiz", "root", "Dcunha@2002");
                Statement st = con.createStatement();
                // String sql = "SELECT * FROM questions WHERE quest_no="+random[i];
                String sql = "select * from questions";
                ResultSet rs = st.executeQuery(sql);
                for (int j = 1; j <= random[i]; j++)
                    rs.next();
                answer = rs.getString("answer");
                if (part == 1) {
                    qestfor.setText("All the best " + name1 + " !");
                    quest_disp.setText("Q" + (i + 1) + ") " + rs.getString("question"));
                } else {
                    if (i % 2 == 0) {
                        qestfor.setText("Question for " + name1);
                        quest_disp.setText("Q" + part2_quest + ") " + rs.getString("question"));
                    } else {
                        qestfor.setText("Question for " + name2);
                        quest_disp.setText("Q" + part2_quest + ") " + rs.getString("question"));
                        part2_quest++;
                    }
                }
                answer_labelA.setText("A " + rs.getString("guess1"));
                answer_labelB.setText("B " + rs.getString("guess2"));
                answer_labelC.setText("C " + rs.getString("guess3"));
                answer_labelD.setText("D " + rs.getString("guess4"));

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, ex);
            }
            timer.start();
        }
    }

    public void displayAnswer() {

        timer.stop();

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (!(answer.equals("A")))
            answer_labelA.setForeground(new Color(255, 0, 0));
        if (!(answer.equals("B")))
            answer_labelB.setForeground(new Color(255, 0, 0));
        if (!(answer.equals("C")))
            answer_labelC.setForeground(new Color(255, 0, 0));
        if (!(answer.equals("D")))
            answer_labelD.setForeground(new Color(255, 0, 0));

        Timer pause = new Timer(2000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                answer_labelA.setForeground(new Color(25, 255, 0));
                answer_labelB.setForeground(new Color(25, 255, 0));
                answer_labelC.setForeground(new Color(25, 255, 0));
                answer_labelD.setForeground(new Color(25, 255, 0));

                seconds = 20;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                i++;
                try {
                    next_question();
                } catch (SQLException ex) {
                    Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        pause.setRepeats(false);
        pause.start();

    }

    void result() {
        welcomepanel.setVisible(false);
        questionpanel.setVisible(false);
        resultpanel.setVisible(true);
        float perc = 0;
        if (part == 1) {
            perc = (int) ((result1 / (double) 10) * 100);
            p1_score.setText("Score : " + result1);
            win_per.setText("Percentage : " + perc + "%");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Quiz", "root", "Dcunha@2002");
                insert = con.prepareStatement("INSERT INTO ranking(Name,points,percentage)values(?,?,?)");
                insert.setString(1, name1);
                insert.setInt(2, result1);
                insert.setFloat(3, perc);
                insert.executeUpdate();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            player1_mks.setText(name1 + " : " + result1 + " of 10");
            player2_mks.setText(name2 + " : " + result2 + " of 10");
            if (result1 > result2)
                win_per.setText("Winner : " + name1);
            else if (result2 > result1)
                win_per.setText("Winner : " + name2);
            else
                win_per.setText("DRAW");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rankingpanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        disp_rank = new javax.swing.JTable();
        back = new javax.swing.JButton();
        resultpanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        player2_mks = new javax.swing.JLabel();
        player1_mks = new javax.swing.JLabel();
        win_per = new javax.swing.JLabel();
        leave = new javax.swing.JToggleButton();
        restart = new javax.swing.JToggleButton();
        p1_score = new javax.swing.JLabel();
        rank = new javax.swing.JButton();
        welcomepanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        part2 = new javax.swing.JButton();
        start = new javax.swing.JButton();
        rule32 = new javax.swing.JLabel();
        part1 = new javax.swing.JButton();
        rule22 = new javax.swing.JLabel();
        rule1 = new javax.swing.JLabel();
        rule31 = new javax.swing.JLabel();
        rule21 = new javax.swing.JLabel();
        p2 = new javax.swing.JLabel();
        p1 = new javax.swing.JLabel();
        p2name = new javax.swing.JTextField();
        p1name = new javax.swing.JTextField();
        questionpanel = new javax.swing.JPanel();
        buttonD = new javax.swing.JButton();
        buttonA = new javax.swing.JButton();
        buttonB = new javax.swing.JButton();
        buttonC = new javax.swing.JButton();
        seconds_left = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        qestfor = new javax.swing.JLabel();
        answer_labelD = new javax.swing.JLabel();
        answer_labelA = new javax.swing.JLabel();
        answer_labelB = new javax.swing.JLabel();
        answer_labelC = new javax.swing.JLabel();
        quest_disp = new javax.swing.JTextArea();
        tup = new javax.swing.JLabel();
        tdown = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        rankingpanel.setOpaque(false);
        rankingpanel.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ranking");
        rankingpanel.add(jLabel3);
        jLabel3.setBounds(230, 70, 164, 51);

        disp_rank.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        disp_rank.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        disp_rank.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Rank", "ID", "Name", "Points", "Percentage"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        disp_rank.setIntercellSpacing(new java.awt.Dimension(5, 5));
        disp_rank.setRowHeight(36);
        disp_rank.setSelectionForeground(new java.awt.Color(153, 255, 255));
        jScrollPane1.setViewportView(disp_rank);

        rankingpanel.add(jScrollPane1);
        jScrollPane1.setBounds(70, 160, 500, 390);

        back.setBackground(new java.awt.Color(204, 204, 255));
        back.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        back.setText("Back");
        back.setBorder(null);
        back.setBorderPainted(false);
        back.setFocusable(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        rankingpanel.add(back);
        back.setBounds(280, 610, 70, 30);

        getContentPane().add(rankingpanel);
        rankingpanel.setBounds(0, 0, 650, 700);

        resultpanel.setOpaque(false);
        resultpanel.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Result");
        resultpanel.add(jLabel6);
        jLabel6.setBounds(230, 120, 164, 51);

        player2_mks.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        player2_mks.setForeground(new java.awt.Color(153, 255, 255));
        player2_mks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultpanel.add(player2_mks);
        player2_mks.setBounds(330, 250, 250, 40);

        player1_mks.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        player1_mks.setForeground(new java.awt.Color(153, 255, 255));
        player1_mks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultpanel.add(player1_mks);
        player1_mks.setBounds(40, 250, 250, 40);

        win_per.setBackground(new java.awt.Color(153, 255, 153));
        win_per.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        win_per.setForeground(new java.awt.Color(0, 102, 0));
        win_per.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        win_per.setOpaque(true);
        resultpanel.add(win_per);
        win_per.setBounds(180, 360, 300, 80);

        leave.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        leave.setText("Leave");
        leave.setMargin(new java.awt.Insets(2, 2, 2, 2));
        leave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveActionPerformed(evt);
            }
        });
        resultpanel.add(leave);
        leave.setBounds(370, 550, 140, 50);

        restart.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        restart.setText("Restart");
        restart.setMargin(new java.awt.Insets(2, 2, 2, 2));
        restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartActionPerformed(evt);
            }
        });
        resultpanel.add(restart);
        restart.setBounds(130, 550, 130, 50);

        p1_score.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        p1_score.setForeground(new java.awt.Color(153, 255, 255));
        p1_score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultpanel.add(p1_score);
        p1_score.setBounds(180, 250, 270, 50);

        rank.setBackground(new java.awt.Color(102, 0, 51));
        rank.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rank.setForeground(new java.awt.Color(255, 0, 0));
        rank.setText("Ranking");
        rank.setBorder(null);
        rank.setFocusable(false);
        rank.setMargin(new java.awt.Insets(2, 2, 2, 2));
        rank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankActionPerformed(evt);
            }
        });
        resultpanel.add(rank);
        rank.setBounds(570, 20, 60, 14);

        getContentPane().add(resultpanel);
        resultpanel.setBounds(0, 0, 650, 700);

        welcomepanel.setForeground(new java.awt.Color(255, 255, 255));
        welcomepanel.setOpaque(false);
        welcomepanel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome");
        welcomepanel.add(jLabel1);
        jLabel1.setBounds(220, 120, 164, 51);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 255));
        jLabel2.setText("Enter number of participants:");
        welcomepanel.add(jLabel2);
        jLabel2.setBounds(130, 210, 360, 34);

        part2.setBackground(new java.awt.Color(204, 204, 204));
        part2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        part2.setText("2");
        part2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,
                new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153),
                new java.awt.Color(153, 153, 153)));
        part2.setBorderPainted(false);
        part2.setMargin(new java.awt.Insets(2, 2, 2, 2));
        part2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                part2ActionPerformed(evt);
            }
        });
        welcomepanel.add(part2);
        part2.setBounds(370, 290, 50, 50);

        start.setBackground(new java.awt.Color(204, 204, 255));
        start.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        start.setText("Start");
        start.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,
                new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153),
                new java.awt.Color(153, 153, 153)));
        start.setBorderPainted(false);
        start.setMargin(new java.awt.Insets(2, 2, 2, 2));
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        welcomepanel.add(start);
        start.setBounds(260, 560, 110, 40);

        rule32.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        rule32.setForeground(new java.awt.Color(51, 255, 0));
        welcomepanel.add(rule32);
        rule32.setBounds(280, 510, 50, 30);

        part1.setBackground(new java.awt.Color(204, 204, 204));
        part1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        part1.setText("1");
        part1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,
                new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153),
                new java.awt.Color(153, 153, 153)));
        part1.setBorderPainted(false);
        part1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        part1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                part1ActionPerformed(evt);
            }
        });
        welcomepanel.add(part1);
        part1.setBounds(190, 290, 50, 50);

        rule22.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        rule22.setForeground(new java.awt.Color(51, 255, 0));
        welcomepanel.add(rule22);
        rule22.setBounds(240, 430, 150, 40);

        rule1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        rule1.setForeground(new java.awt.Color(51, 255, 0));
        welcomepanel.add(rule1);
        rule1.setBounds(110, 360, 480, 40);

        rule31.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        rule31.setForeground(new java.awt.Color(51, 255, 0));
        welcomepanel.add(rule31);
        rule31.setBounds(70, 480, 520, 30);

        rule21.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        rule21.setForeground(new java.awt.Color(51, 255, 0));
        welcomepanel.add(rule21);
        rule21.setBounds(70, 400, 520, 40);

        p2.setBackground(new java.awt.Color(255, 204, 204));
        p2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        p2.setForeground(new java.awt.Color(255, 0, 0));
        p2.setText("Participant 2 name :");
        welcomepanel.add(p2);
        p2.setBounds(400, 530, 160, 30);

        p1.setBackground(new java.awt.Color(255, 0, 0));
        p1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        p1.setForeground(new java.awt.Color(255, 0, 51));
        p1.setText("Participant 1 name :");
        welcomepanel.add(p1);
        p1.setBounds(70, 530, 160, 30);

        p2name.setBackground(new java.awt.Color(0, 0, 0));
        p2name.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        p2name.setForeground(new java.awt.Color(255, 153, 153));
        p2name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        p2name.setBorder(null);
        p2name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                p2nameKeyPressed(evt);
            }
        });
        welcomepanel.add(p2name);
        p2name.setBounds(400, 560, 160, 40);

        p1name.setBackground(new java.awt.Color(0, 0, 0));
        p1name.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        p1name.setForeground(new java.awt.Color(255, 153, 153));
        p1name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        p1name.setBorder(null);
        p1name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p1nameActionPerformed(evt);
            }
        });
        p1name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                p1nameKeyPressed(evt);
            }
        });
        welcomepanel.add(p1name);
        p1name.setBounds(70, 560, 160, 40);

        getContentPane().add(welcomepanel);
        welcomepanel.setBounds(0, 0, 650, 700);

        questionpanel.setBackground(new java.awt.Color(255, 255, 255));
        questionpanel.setOpaque(false);
        questionpanel.setLayout(null);

        buttonD.setBackground(new java.awt.Color(204, 204, 255));
        buttonD.setFont(new java.awt.Font("Comic Sans MS", 1, 26)); // NOI18N
        buttonD.setText("D");
        buttonD.setMargin(new java.awt.Insets(2, 2, 2, 2));
        buttonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDActionPerformed(evt);
            }
        });
        questionpanel.add(buttonD);
        buttonD.setBounds(170, 520, 60, 50);

        buttonA.setBackground(new java.awt.Color(204, 204, 255));
        buttonA.setFont(new java.awt.Font("Comic Sans MS", 1, 26)); // NOI18N
        buttonA.setText("A");
        buttonA.setMargin(new java.awt.Insets(2, 2, 2, 2));
        buttonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAActionPerformed(evt);
            }
        });
        questionpanel.add(buttonA);
        buttonA.setBounds(170, 310, 60, 50);

        buttonB.setBackground(new java.awt.Color(204, 204, 255));
        buttonB.setFont(new java.awt.Font("Comic Sans MS", 1, 26)); // NOI18N
        buttonB.setText("B");
        buttonB.setMargin(new java.awt.Insets(2, 2, 2, 2));
        buttonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBActionPerformed(evt);
            }
        });
        questionpanel.add(buttonB);
        buttonB.setBounds(170, 380, 60, 50);

        buttonC.setBackground(new java.awt.Color(204, 204, 255));
        buttonC.setFont(new java.awt.Font("Comic Sans MS", 1, 26)); // NOI18N
        buttonC.setText("C");
        buttonC.setMargin(new java.awt.Insets(2, 2, 2, 2));
        buttonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCActionPerformed(evt);
            }
        });
        questionpanel.add(buttonC);
        buttonC.setBounds(170, 450, 60, 50);

        seconds_left.setBackground(new java.awt.Color(255, 153, 153));
        seconds_left.setFont(new java.awt.Font("Times New Roman", 1, 54)); // NOI18N
        seconds_left.setForeground(new java.awt.Color(255, 0, 51));
        seconds_left.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seconds_left.setText("20");
        questionpanel.add(seconds_left);
        seconds_left.setBounds(520, 590, 90, 60);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("timer :)");
        questionpanel.add(jLabel4);
        jLabel4.setBounds(540, 570, 60, 30);

        qestfor.setFont(new java.awt.Font("Comic Sans MS", 1, 28)); // NOI18N
        qestfor.setForeground(new java.awt.Color(255, 255, 0));
        qestfor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        questionpanel.add(qestfor);
        qestfor.setBounds(70, 100, 480, 40);

        answer_labelD.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        answer_labelD.setForeground(new java.awt.Color(25, 255, 0));
        questionpanel.add(answer_labelD);
        answer_labelD.setBounds(250, 530, 270, 30);

        answer_labelA.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        answer_labelA.setForeground(new java.awt.Color(25, 255, 0));
        questionpanel.add(answer_labelA);
        answer_labelA.setBounds(250, 320, 270, 30);

        answer_labelB.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        answer_labelB.setForeground(new java.awt.Color(25, 255, 0));
        questionpanel.add(answer_labelB);
        answer_labelB.setBounds(250, 390, 270, 30);

        answer_labelC.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        answer_labelC.setForeground(new java.awt.Color(25, 255, 0));
        questionpanel.add(answer_labelC);
        answer_labelC.setBounds(250, 460, 270, 30);

        quest_disp.setBackground(new java.awt.Color(0, 0, 0));
        quest_disp.setColumns(22);
        quest_disp.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        quest_disp.setForeground(new java.awt.Color(153, 255, 255));
        quest_disp.setLineWrap(true);
        quest_disp.setRows(5);
        quest_disp.setWrapStyleWord(true);
        quest_disp.setBorder(null);
        quest_disp.setMargin(new java.awt.Insets(2, 4, 2, 2));
        quest_disp.setOpaque(false);
        questionpanel.add(quest_disp);
        quest_disp.setBounds(50, 160, 510, 140);

        tup.setIcon(new javax.swing.ImageIcon(
                "tup.PNG")); // NOI18N
        questionpanel.add(tup);
        tup.setBounds(460, 400, 100, 100);

        tdown.setIcon(new javax.swing.ImageIcon(
                "tdown.PNG")); // NOI18N
        questionpanel.add(tdown);
        tdown.setBounds(460, 400, 100, 100);

        getContentPane().add(questionpanel);
        questionpanel.setBounds(0, 0, 650, 700);

        background.setForeground(new java.awt.Color(255, 255, 0));
        background.setIcon(new javax.swing.ImageIcon("background.png")); // NOI18N
        background.setText("");
        getContentPane().add(background);
        background.setBounds(0, 0, 650, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_startActionPerformed
        name1 = p1name.getText();
        name2 = p2name.getText();
        if (part == 1 && name1.length() < 1) {
            JOptionPane.showMessageDialog(this, "Enter Participant 1 name", "Quiz", JOptionPane.PLAIN_MESSAGE);
        } else if (part == 2 && (name1.length() < 1 || name2.length() < 1 || name1.equals(name2))) {
            if (name1.length() < 1)
                JOptionPane.showMessageDialog(this, "Enter Participant 1 name", "Quiz", JOptionPane.PLAIN_MESSAGE);
            else if (name2.length() < 1)
                JOptionPane.showMessageDialog(this, "Enter Participant 2 name", "Quiz", JOptionPane.PLAIN_MESSAGE);
            else if (name1.equals(name2))
                JOptionPane.showMessageDialog(this, "Names cannot be same", "Quiz", JOptionPane.PLAIN_MESSAGE);
        } else {
            welcomepanel.setVisible(false);
            questionpanel.setVisible(true);
            resultpanel.setVisible(false);
            i = 0;
            seconds = 20;
            part2_quest = 1;
            result1 = 0;
            result2 = 0;
            try {
                next_question();
            } catch (SQLException ex) {
                Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }// GEN-LAST:event_startActionPerformed

    private void part1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_part1ActionPerformed
        rule1.setText("1) There will be 30 seconds between each question");
        rule21.setText("2) If partcipant fails to answer correct answer it will skip");
        rule22.setText("to next question");
        rule31.setText("");
        rule32.setText("");
        p1.setVisible(true);
        p2.setVisible(false);
        p1name.setVisible(true);
        p2name.setVisible(false);
        part = 1;
        start.setVisible(true);
    }// GEN-LAST:event_part1ActionPerformed

    private void part2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_part2ActionPerformed
        rule1.setText("1) There will be 30 seconds between each question");
        rule21.setText("2) If partcipant fails to answer correct answer it will skip");
        rule22.setText("to next question");
        rule31.setText("3) Questions for both participants will appear in alternate");
        rule32.setText("order");
        p1.setVisible(true);
        p2.setVisible(true);
        p1name.setVisible(true);
        p2name.setVisible(true);
        part = 2;
        start.setVisible(true);
    }// GEN-LAST:event_part2ActionPerformed

    private void buttonAActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonAActionPerformed
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answer.equals("A")) {
            if (part == 1)
                result1 += 1;
            else {
                if (i % 2 == 0)
                    result1 += 2;
                else
                    result2 += 2;
            }
            tup.setVisible(true);
        } else
            tdown.setVisible(true);

        displayAnswer();
    }// GEN-LAST:event_buttonAActionPerformed

    private void buttonBActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonBActionPerformed
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answer.equals("B")) {
            if (part == 1)
                result1 += 1;
            else {
                if (i % 2 == 0)
                    result1 += 2;
                else
                    result2 += 2;
            }
            tup.setVisible(true);
        } else
            tdown.setVisible(true);

        displayAnswer();
    }// GEN-LAST:event_buttonBActionPerformed

    private void buttonCActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonCActionPerformed
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answer.equals("C")) {
            if (part == 1)
                result1 += 1;
            else {
                if (i % 2 == 0)
                    result1 += 2;
                else
                    result2 += 2;
            }
            tup.setVisible(true);
        } else
            tdown.setVisible(true);

        displayAnswer();
    }// GEN-LAST:event_buttonCActionPerformed

    private void buttonDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonDActionPerformed
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answer.equals("D")) {
            if (part == 1)
                result1 += 1;
            else {
                if (i % 2 == 0)
                    result1 += 2;
                else
                    result2 += 2;
            }
            tup.setVisible(true);
        } else
            tdown.setVisible(true);

        displayAnswer();
    }// GEN-LAST:event_buttonDActionPerformed

    private void restartActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_restartActionPerformed
        resultpanel.setVisible(false);
        welcomepanel.setVisible(true);
        p1_score.setText("");
        player1_mks.setText("");
        player2_mks.setText("");
        rule1.setText("");
        rule21.setText("");
        rule22.setText("");
        rule31.setText("");
        rule32.setText("");
        p1.setVisible(false);
        p2.setVisible(false);
        p1name.setVisible(false);
        p2name.setVisible(false);
        p1name.setText("");
        p2name.setText("");
    }// GEN-LAST:event_restartActionPerformed

    private void leaveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_leaveActionPerformed
        System.exit(0);
    }// GEN-LAST:event_leaveActionPerformed

    private void p1nameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_p1nameActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_p1nameActionPerformed

    private void p1nameKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_p1nameKeyPressed
        char c = evt.getKeyChar();
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || (evt.getKeyChar() >= 'a' && evt.getKeyChar() <= 'z')
                || (evt.getKeyChar() >= 'A' && evt.getKeyChar() <= 'Z')) {
            p1name.setEditable(true);
        } else if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
                || evt.getExtendedKeyCode() == KeyEvent.VK_SPACE) {
            p1name.setEditable(true);
        } else if (evt.getExtendedKeyCode() == KeyEvent.VK_SHIFT || evt.getExtendedKeyCode() == KeyEvent.VK_CAPS_LOCK
                || evt.getExtendedKeyCode() == KeyEvent.VK_CONTROL) {
            p1name.setEditable(true);
        } else if (evt.getExtendedKeyCode() == KeyEvent.VK_UP || evt.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
            p1name.setEditable(true);
        } else if (evt.getExtendedKeyCode() == KeyEvent.VK_LEFT || evt.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
            p1name.setEditable(true);
        } else {
            p1name.setEditable(false);
            JOptionPane.showMessageDialog(this, "Error !! cannot input character", "Quiz", JOptionPane.PLAIN_MESSAGE);
        }
    }// GEN-LAST:event_p1nameKeyPressed

    private void p2nameKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_p2nameKeyPressed
        char c = evt.getKeyChar();
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || (evt.getKeyChar() >= 'a' && evt.getKeyChar() <= 'z')
                || (evt.getKeyChar() >= 'A' && evt.getKeyChar() <= 'Z')) {
            p1name.setEditable(true);
        } else if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE
                || evt.getExtendedKeyCode() == KeyEvent.VK_SPACE) {
            p1name.setEditable(true);
        } else if (evt.getExtendedKeyCode() == KeyEvent.VK_SHIFT || evt.getExtendedKeyCode() == KeyEvent.VK_CAPS_LOCK
                || evt.getExtendedKeyCode() == KeyEvent.VK_CONTROL) {
            p1name.setEditable(true);
        } else if (evt.getExtendedKeyCode() == KeyEvent.VK_UP || evt.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
            p1name.setEditable(true);
        } else if (evt.getExtendedKeyCode() == KeyEvent.VK_LEFT || evt.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
            p1name.setEditable(true);
        } else {
            p1name.setEditable(false);
            JOptionPane.showMessageDialog(this, "Error !! cannot input character", "Quiz", JOptionPane.PLAIN_MESSAGE);
        }
    }// GEN-LAST:event_p2nameKeyPressed

    private void rankActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rankActionPerformed
        // int c;
        resultpanel.setVisible(false);
        rankingpanel.setVisible(true);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Quiz", "root", "Dcunha@2002");
            insert = con.prepareStatement("SELECT * FROM ranking ORDER BY points DESC");
            ResultSet rs = insert.executeQuery();
            int j = 0, check1 = 0, check2 = -1;
            String jst;
            while (rs.next()) {
                if (j == 0)
                    check1 = rs.getInt("points");
                else
                    check2 = rs.getInt("points");
                if ((check1 != check2))
                    j++;
                jst = String.valueOf(j);
                String id = String.valueOf(rs.getInt("Id"));
                String name = rs.getString("Name");
                String pt = String.valueOf(rs.getInt("points"));
                String perc = String.valueOf(rs.getFloat("percentage"));

                String tbData[] = { jst, id, name, pt, perc };
                DefaultTableModel tbModel = (DefaultTableModel) disp_rank.getModel();
                tbModel.addRow(tbData);

                if (j > 1)
                    check1 = check2;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_rankActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_backActionPerformed
        resultpanel.setVisible(true);
        rankingpanel.setVisible(false);
        DefaultTableModel dm = (DefaultTableModel) disp_rank.getModel();
        while (dm.getRowCount() > 0)
            dm.removeRow(0);
    }// GEN-LAST:event_backActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel answer_labelA;
    public javax.swing.JLabel answer_labelB;
    public javax.swing.JLabel answer_labelC;
    public javax.swing.JLabel answer_labelD;
    private javax.swing.JButton back;
    public javax.swing.JLabel background;
    public javax.swing.JButton buttonA;
    public javax.swing.JButton buttonB;
    public javax.swing.JButton buttonC;
    public javax.swing.JButton buttonD;
    private javax.swing.JTable disp_rank;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JToggleButton leave;
    private javax.swing.JLabel p1;
    public javax.swing.JLabel p1_score;
    private javax.swing.JTextField p1name;
    private javax.swing.JLabel p2;
    private javax.swing.JTextField p2name;
    public javax.swing.JButton part1;
    public javax.swing.JButton part2;
    public javax.swing.JLabel player1_mks;
    public javax.swing.JLabel player2_mks;
    public javax.swing.JLabel qestfor;
    public javax.swing.JTextArea quest_disp;
    public javax.swing.JPanel questionpanel;
    private javax.swing.JButton rank;
    private javax.swing.JPanel rankingpanel;
    public javax.swing.JToggleButton restart;
    public javax.swing.JPanel resultpanel;
    public javax.swing.JLabel rule1;
    public javax.swing.JLabel rule21;
    public javax.swing.JLabel rule22;
    public javax.swing.JLabel rule31;
    public javax.swing.JLabel rule32;
    public javax.swing.JLabel seconds_left;
    public javax.swing.JButton start;
    private javax.swing.JLabel tdown;
    private javax.swing.JLabel tup;
    public javax.swing.JPanel welcomepanel;
    public javax.swing.JLabel win_per;
    // End of variables declaration//GEN-END:variables
}
