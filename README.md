# Hamood's Library

Welcome to the Hamood's Library! This project is a library management system designed to streamline the process of managing books, readers, and transactions in a library setting. With Bibliotheque, librarians can efficiently track book loans, manage reader information, and monitor library inventory.

## Technologies Used

- **JavaFX**: For building the user interface and providing an interactive experience.
- **MySQL**: As the relational database management system for storing book, reader, and transaction data.
- **Java Database Connectivity (JDBC)**: For connecting Java applications with databases and executing SQL queries.
- **Maven**: For project management and dependency resolution.

## Features

- **Book Management**: Add, update, and delete books from the library inventory. Track book information such as title, author, ISBN, and number of copies.
- **Reader Management**: Maintain a database of library patrons, including their names, email addresses, and contact information.
- **Transaction Tracking**: Record book borrowing and returning transactions, including timestamps and status updates.
- **User-Friendly Interface**: Built with JavaFX for an intuitive and visually appealing user experience.

## Demo

Here are some snippets showcasing the Bibliotheque Project:
![Homepage](https://github.com/Ahmed-Amamou/Library-System-/assets/115194376/c7bb2f0e-840f-415b-87f6-c141bc5892ba)
![BooksPage](https://github.com/Ahmed-Amamou/Library-System-/assets/115194376/8f455eea-a391-4d2e-b82e-c06b1cfe7814)
![ReadersPage](https://github.com/Ahmed-Amamou/Library-System-/assets/115194376/a3aa8e5f-618c-43f4-bccf-ab2971069cb8)
![Lend a book](https://github.com/Ahmed-Amamou/Library-System-/assets/115194376/2b7211d8-fb67-4c1a-a3bd-350d222cf459)

## Getting Started

To get started with Bibliotheque, follow these steps:

1. Clone this repository to your local machine.
2. Set up the MySQL database using the provided SQL schema (`schema.sql`).
3. Make a package "com.example.bibliotheque_project.Connections", Now create a (`MySQLConnection.java`) and update the database connection properties.
   it should look something like this: 
````
   ```
    public class MySQLConnection {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Register the JDBC driver (optional for newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database URL, username, and password
            String url = "jdbc:mysql://localhost:3306/library";
            String username = "root";
            String password = "*****";

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to MySQL database!");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        // Use the connection for database operations
        // Remember to close the connection when done
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```
````
4. Build and run the project using Maven or your preferred IDE.



## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


