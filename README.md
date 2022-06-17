# Employee Reimbursement

## Description

 An Employee Reimbursement API. This application allows employees to submit a reimbursement for expenses that they obtained while on company time or company required tasks. Employees may submit a request, view their own pending, denied and approved requests. Finanance Managers can login and view all reimbursement tickets, approve and deny reimbursements as well as see reimbursements by type. The API is modeled after REST principles.

## Technologies

1. Java 8
2. Javalin (Jetty Server)
3. JDBC
2. PostgresSQL
3. Docker 
4. Docker Compose 
5. Prometheus 
6. Grafana 
7. ERS

# Application Features

## Constraints
Will reject invalid reimbursements submitted
Negative amounts
Will not allow unauthenticated users to submit a request or access data

## Employees

Login, Logout
Submit Reimbursement
-Reimbursement Type: Lodging, Travel, Food, Other
View past Reimbursements
View past Reimbursements by status
-Reimbursement Status: Approved, Denied, Pending
View all their past Reimbursements

## Finance Manager

Login, Logout
View all Reimbursements by Status (All Employees)
View Reimbursements for all employees by status
View Reimbursement for a select employee
Approve or Deny Reimbursements

### Improvements that can be made:
Use hashed passwords
Implement Email or SMS alerts
Implement Web GUI that uses the API

### Getting Started:

Install git
Install Docker
git clone https://github.com/2205JavaSRE/expense-reimbursement-system-ZacBRev.git
docker build . -t expense:latest
docker-compose up -d

### To demo please use an application that can connect to API platforms.

