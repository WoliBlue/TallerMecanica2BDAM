module com.derrap {
    requires java.sql;       // For JDBC
    requires java.desktop;   // For Swing/AWT
    requires mysql.connector.java;   // Automatic module name

    opens com.derrap to java.desktop; // For resource access (fonts, images)
}