package main;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/items"})
public class ItemController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private ItemDAO itemDAO;

    public void init() throws ServletException {
        try {
            itemDAO = new ItemDAO();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
    
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemName = req.getParameter("item");
        String category = req.getParameter("category");

        if ("Khác".equals(req.getParameter("category"))) {
            category = req.getParameter("otherCategory");
        }

        String damageCondition = req.getParameter("damageCondition");
        double price = Double.parseDouble(req.getParameter("price"));
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        Item newItem = new Item();
        newItem.setItem(itemName);
        newItem.setCategory(category);
        newItem.setDamageCondition(damageCondition);
        newItem.setPrice(price);
        newItem.setPhone(phone);
        newItem.setEmail(email);

        try {
            itemDAO.addItem(newItem);
            req.setAttribute("successMessage", "Đăng bán thành công!");
        } catch (Exception e) {
            throw new ServletException(e);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

}