package view;

import controller.ReportController;
import javax.swing.*;
import java.awt.*;

public class ReportView extends JFrame {

    private JTextArea txtReport;
    private JButton btnGenerateReport;
    private ReportController reportController;

    public ReportView() {
        // Setup controller
        this.reportController = new ReportController();

        // Setup window properties
        setTitle("Report Viewer");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create UI components
        txtReport = new JTextArea(20, 40);
        txtReport.setEditable(false);
        txtReport.setLineWrap(true);
        txtReport.setWrapStyleWord(true);

        btnGenerateReport = new JButton("Generate Report");

        // Layout setup
        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(txtReport);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);
        add(btnGenerateReport, BorderLayout.SOUTH);

        // Action listener tanpa generateReport
        btnGenerateReport.addActionListener(e -> {
            txtReport.setText("This is a placeholder for the report.\nFungsi generateReport telah dihapus.");
        });

        setVisible(true);
    }
}
