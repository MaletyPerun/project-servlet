package com.tictactoe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(InitServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("doGet method of InitServlet");
        HttpSession currentSession = req.getSession(true);

        Field field = new Field();
        Map<Integer, Sign> fieldData = field.getField();

        List<Sign> data = field.getFieldData();

        logger.info("make field and data");

        currentSession.setAttribute("field", field);
        currentSession.setAttribute("data", data);
        logger.info("set attributes field and data");

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
