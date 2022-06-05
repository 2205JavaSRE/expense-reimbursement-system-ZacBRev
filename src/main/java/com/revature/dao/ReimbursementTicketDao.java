package com.revature.dao;

import com.revature.models.ReimbursementTicket;
import com.revature.util.ConnectionFactory;

import javax.sql.PooledConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementTicketDao implements ReimbursementTicketDaoInterface {

    @Override
    public void createReimbursement(ReimbursementTicket rt) {
        PooledConnection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO reimbursementTicket (employee_id, finance_manager_id," +
                " status, amount, category) values ( ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, rt.getEmployeeID());
            ps.setInt(2, rt.getFinanceManagerID());
            ps.setString(3, rt.getReimbursementStatus());
            ps.setDouble(4, rt.getReimbursementAmount());
            ps.setString(5, rt.getReimbursementCategory());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ReimbursementTicket> getReimbursementByEmployeeID(int employeeID) {
        PooledConnection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM reimbursementTicket WHERE employee_id = ?";
        List<ReimbursementTicket> reimbursementTicketList = new ArrayList<>();


        try (PreparedStatement ps = connection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, employeeID);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            ReimbursementTicket rt = new ReimbursementTicket(rs.getInt("reimbursement_id"),
                    rs.getInt("employee_id"), rs.getInt("finance_manager_id"),
                    rs.getString("status"), rs.getDouble("amount"),
                    rs.getString("category"));

                    reimbursementTicketList.add(rt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursementTicketList;
    }

    @Override
    public List<ReimbursementTicket> getReimbursementByStatus(String status) {
        PooledConnection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM reimbursementTicket WHERE status iLIKE ?";
        List<ReimbursementTicket> reimbursementTicketList = new ArrayList<>();


        try (PreparedStatement ps = connection.getConnection().prepareStatement(sql)) {
            ps.setString(1, status);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ReimbursementTicket rt = new ReimbursementTicket(rs.getInt("reimbursement_id"),
                        rs.getInt("employee_id"), rs.getInt("finance_manager_id"),
                        rs.getString("status"), rs.getDouble("amount"),
                        rs.getString("category"));

                reimbursementTicketList.add(rt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursementTicketList;
    }

    @Override
    public List<ReimbursementTicket> getAllReimbursementTickets() {
        PooledConnection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM reimbursementTicket;";
        List<ReimbursementTicket> reimbursementTicketList = new ArrayList<>();


        try (PreparedStatement ps = connection.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ReimbursementTicket rt = new ReimbursementTicket(rs.getInt("reimbursement_id"),
                        rs.getInt("employee_id"), rs.getInt("finance_manager_id"),
                        rs.getString("status"), rs.getDouble("amount"),
                        rs.getString("category"));

                reimbursementTicketList.add(rt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursementTicketList;
    }

    @Override
    public void updateReimbursementStatus(int reimbursementTicketID,  int managerID, String status) {
        PooledConnection connection = ConnectionFactory.getConnection();
        String sql = "UPDATE reimbursementTicket SET status = ?, finance_manager_id = ? WHERE reimbursement_id = ?;";

        try (PreparedStatement ps = connection.getConnection().prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, managerID);
            ps.setInt(3, reimbursementTicketID);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
