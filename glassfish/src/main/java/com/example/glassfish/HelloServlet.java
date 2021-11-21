package com.example.glassfish;

import java.io.*;
import java.sql.*;
import java.util.List;

import com.example.glassfish.Students.Rest;
import com.example.glassfish.Students.Student;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.sql.DataSource;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        InitialContext ctx = null;
        StringBuilder sb = new StringBuilder();
        //try {
        //    ctx = new InitialContext();
        //    NamingEnumeration<NameClassPair> list = ctx.list("");
        //    while (list.hasMore()) {
        //        sb.append(list.next().getName() + "<br>");
        //    }
        //} catch (NamingException e) {
        //    e.printStackTrace();
        //}


        DataSource db = null;
        try {
            ctx = new InitialContext();
            db = (DataSource)ctx.lookup("NavidDB01");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        try (Connection conn = db.getConnection())
        {
            System.out.println("Connected to jdbc via: " + conn);

            try (Statement stmt = conn.createStatement()) {

                // Execute a SELECT Statement
                ResultSet rsContactList = stmt.executeQuery(
                        "SELECT first_name, last_name, email " +
                                "FROM test.contacts");

                while (rsContactList.next()) {
                    sb.append(
                            String.format(
                                    "- %s %s <%s> <br>",
                                    rsContactList.getString("first_name"),
                                    rsContactList.getString("last_name"),
                                    rsContactList.getString("email")));
                }


                if (rsContactList != null) rsContactList.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            }
            // Catch SQL Exceptions for Queries
            catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
        // Catch SQL Exceptions from Connection
        catch (SQLException e) {
            e.printStackTrace();
        }



        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println(sb.toString());
        out.println("</html></body>");
    }

    public void destroy() {
    }
}