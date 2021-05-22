//package pl.paczka;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

import static java.awt.BorderLayout.CENTER;

public class  notepad implements ActionListener {

    public static void  main (String [] args) throws IOException {

        //Runtime.getRuntime().exec("explorer.exe /select," + path);
        File plik;
        //String txt= plik;
        JFrame f = new JFrame("Notepad--");
        // okno

        JMenuBar mb = new JMenuBar();
        JMenuItem prawyklik = new JMenuItem("click");
        JTextArea tf = new JTextArea();
        tf.setBounds(0, 50, 1920, 1180); // całość 1920 x 1080
        tf.setAutoscrolls(true);

        String fileName = "z tytułem.txt";
        String buffer = tf.getText();


        JPanel contentPane;
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.add(tf, BorderLayout.CENTER);
        // notepad.setContentPane(contentPane);

        JScrollPane sc = new JScrollPane(tf, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        contentPane.add(sc);


        //prawyklik.addDefaultContextMenu(tf);

        //saveButton.addActionlistener(new ActionListener());
        // ------------------------------------------------------------------
        // 1 menu pliów
        JMenu menu = new JMenu("plik");
        JMenuItem zapis = new JMenuItem("Zapisz");
        JMenuItem zapiszjako = new JMenuItem("zapisz jako");
        JMenuItem open = new JMenuItem("otwórz");
        JMenuItem newfile = new JMenuItem("nowy plik");
        menu.setVisible(true);
        menu.add(zapis);
        menu.add(zapiszjako);
        menu.add(open);
        menu.add(newfile);
        f.add(menu);
        zapis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Runtime.getRuntime().exec("explorer.exe /select, path");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        zapiszjako.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser explorer = new JFileChooser();
                try (FileWriter fw = new FileWriter(new File(fileName))) {

                    fw.write(buffer);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }


            }
        });
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // tf.setText(txt);
                JFileChooser fc = new JFileChooser();
                int retunrnvalue = fc.showOpenDialog(null);
                if (retunrnvalue == JFileChooser.APPROVE_OPTION) {
                    File f = fc.getSelectedFile();
                    String filepath = fc.getSelectedFile().getAbsolutePath();//f.getPath();
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(filepath));
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    BufferedReader br = null;
                    try {
                        br = new BufferedReader(new FileReader(filepath));
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    String s1 = "", s2 = "";
                    while (true) {
                        try {
                            if ((s1 = br.readLine()) == null) break;
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        s2 += s1 + "\n";
                    }
                    tf.setText(s2);
                }


            }
        });
        newfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // ----------------------------------------------------------------------------
        // drugie menu plików
        JMenu edycja = new JMenu("edycja");
        JMenuItem undo = new JMenuItem("cofnij (Ctrl + z)");
        JMenuItem redo = new JMenuItem("ponów (ctrl + y)");
        JMenuItem kopioj = new JMenuItem("kopiój (ctrl + c)");
        JMenuItem wklej = new JMenuItem("wklej (ctrl + v)");
        JMenuItem CTRLA = new JMenuItem("zaznacz wszystko (ctrl + a)");
        JMenuItem Dataigodz = new JMenuItem("Data i godzina (ctrl + h)");
        JMenuItem cut = new JMenuItem("wytnij");
        //JMenuItem przejdzdo = new JMenuItem("przejdź do");

        edycja.add(undo);
        edycja.add(redo);
        edycja.add(kopioj);
        edycja.add(wklej);
        edycja.add(CTRLA);
        edycja.add(Dataigodz);
        edycja.add(cut);//edycja.add(przejdzdo);
        // actionlistinig-------------------------------------------------------------
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        //
        redo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        kopioj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        wklej.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        CTRLA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        Dataigodz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        cut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

// ------------------------------------------------------------------------------------
// menu aplikacji
        JMenu ustawienia = new JMenu("ustawienia");
        JMenuItem motywJasny = new JMenuItem("tryb jasny");
        JMenuItem motywCiemny = new JMenuItem("tryb ciemny");
        JMenuItem pasek_stanu = new JMenuItem("pasek stanu pokaż");
        JMenuItem pasek_schowaj = new JMenuItem("pasek stanu ukryj");
        ustawienia.add(motywCiemny);
        ustawienia.add(motywJasny);
        ustawienia.add(pasek_stanu);
        ustawienia.add(pasek_schowaj);
        f.add(ustawienia);
// -----------------------------------------------------------------------------------------
//  pasek stanu
        JTable pasekStanu = new JTable();
        pasekStanu.setBounds(1080, 990, 1080, 20);


        // koniec linii
        tf.setLineWrap(true);
        tf.setWrapStyleWord(true);

        // Desktop desktop =  Desktop.getDesktop();
        //desktop.browseFileDirectory(file);
        //   if (isPressing(//any))
        //   {
        //        //do somthing
        //  }
        Image icon = Toolkit.getDefaultToolkit().getImage("E:\\programy\\java\\Notatnik\\ikona.png");
        f.setIconImage(icon);
        f.add(tf);
        f.add(pasekStanu);
        f.add(sc, CENTER);// wstawianie przycisków do okna
        f.setSize(600, 400);
        f.setLayout(null);
        f.setVisible(true);
        mb.add(menu);
        mb.add(edycja);
        mb.add(ustawienia);
        f.setJMenuBar(mb);


        final JPopupMenu popupmenu = new JPopupMenu("Edit");
        JMenuItem cut2 = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        popupmenu.add(cut);
        popupmenu.add(copy);
        popupmenu.add(paste);
        tf.add(popupmenu);
        tf.setComponentPopupMenu(popupmenu);
        f.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                popupmenu.show(f, e.getX(), e.getY());


            }




            private void actionPerformed(ActionEvent actionEvent) {
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}