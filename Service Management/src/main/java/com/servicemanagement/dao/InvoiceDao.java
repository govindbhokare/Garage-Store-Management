package com.servicemanagement.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.servicemanagement.model.Invoice;
import com.servicemanagement.util.DBUtil;



public class InvoiceDao {
    private Connection connection;

    // Constructor to initialize connection
    public InvoiceDao() {
        connection = DBUtil.getConnection();
    }

    // Method to add a new invoice to the database
    public void addInvoice(Invoice invoice) {
        try {
            String query = "INSERT INTO invoices (customer_id, amount) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, invoice.getCustomerId());
            preparedStatement.setDouble(2, invoice.getAmount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all invoices from the database
    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        try {
            String query = "SELECT * FROM invoices";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Invoice invoice = new Invoice();
                invoice.setId(resultSet.getInt("id"));
                invoice.setCustomerId(resultSet.getInt("customer_id"));
                invoice.setAmount(resultSet.getDouble("amount"));
                // Add more fields if needed
                invoices.add(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoices;
    }

    // Method to retrieve an invoice by ID
    public Invoice getInvoiceById(int invoiceId) {
        Invoice invoice = null;
        try {
            String query = "SELECT * FROM invoices WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, invoiceId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                invoice = new Invoice();
                invoice.setId(resultSet.getInt("id"));
                invoice.setCustomerId(resultSet.getInt("customer_id"));
                invoice.setAmount(resultSet.getDouble("amount"));
                // Add more fields if needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoice;
    }

    // Method to update an existing invoice in the database
    public void updateInvoice(Invoice invoice) {
        try {
            String query = "UPDATE invoices SET customer_id=?, amount=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, invoice.getCustomerId());
            preparedStatement.setDouble(2, invoice.getAmount());
            preparedStatement.setInt(3, invoice.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete an invoice from the database
    public void deleteInvoice(int invoiceId) {
        try {
            String query = "DELETE FROM invoices WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, invoiceId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
