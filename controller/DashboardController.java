package controller;

import view.*;

public class DashboardController {

    private String role;
    private DashboardStaffView dashboardView;

    public DashboardController(DashboardStaffView view, String role) {
        this.dashboardView = view;
        this.role = role;
    }

    public void openAddProductView() {
        new AddProductView(role);
        dashboardView.dispose();
    }

    public void openViewProductView() {
        new ViewProductView(role);
        dashboardView.dispose();
    }

    public void openStockInView() {
        new StockInView(role);
        dashboardView.dispose();
    }

    public void openStockOutView() {
        new StockOutView(role);
        dashboardView.dispose();
    }

    public void logout() {
        new LoginView().setVisible(true);
        dashboardView.dispose();
    }
}
