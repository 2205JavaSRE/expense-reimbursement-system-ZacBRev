package com.revature.models;

public class ReimbursementTicket {
        private int reimbursementID;
        private int employeeID;
        private String reimbursementStatus;
        private double reimbursementAmount;
        private String reimbursementCategory;

        public ReimbursementTicket(int reimbursementID, int employeeID, String reimbursementStatus, double reimbursementAmount, String reimbursementCategory) {
                this.reimbursementID = reimbursementID;
                this.employeeID = employeeID;
                this.reimbursementStatus = reimbursementStatus;
                this.reimbursementAmount = reimbursementAmount;
                this.reimbursementCategory = reimbursementCategory;
        }

        public int getReimbursementID() {
                return reimbursementID;
        }

        public void setReimbursementID(int reimbursementID) {
                this.reimbursementID = reimbursementID;
        }

        public int getEmployeeID() {
                return employeeID;
        }

        public void setEmployeeID(int employeeID) {
                this.employeeID = employeeID;
        }

        public String getReimbursementStatus() {
                return reimbursementStatus;
        }

        public void setReimbursementStatus(String reimbursementStatus) {
                this.reimbursementStatus = reimbursementStatus;
        }

        public double getReimbursementAmount() {
                return reimbursementAmount;
        }

        public void setReimbursementAmount(double reimbursementAmount) {
                this.reimbursementAmount = reimbursementAmount;
        }

        public String getReimbursementCategory() {
                return reimbursementCategory;
        }

        public void setReimbursementCategory(String reimbursementCategory) {
                this.reimbursementCategory = reimbursementCategory;
        }

        @Override
        public String toString() {
                return "ReimbursementTicket{" +
                        "reimbursementID=" + reimbursementID +
                        ", employeeID=" + employeeID +
                        ", reimbursementStatus='" + reimbursementStatus + '\'' +
                        ", reimbursementAmount=" + reimbursementAmount +
                        ", reimbursementCategory='" + reimbursementCategory + '\'' +
                        '}';
        }
}
