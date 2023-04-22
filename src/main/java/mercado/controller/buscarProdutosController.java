package mercado.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mercado.model.Produto;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class buscarProdutosController
 */
public class buscarProdutosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buscarProdutosController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String descricao = request.getParameter("descricao");
		ArrayList<Produto> produtos = new Produto().buscarProdutoPorDescricao(descricao);
		
		request.setAttribute("produtos", produtos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ConsultarProduto.jsp");
		dispatcher.forward(request, response);
	}

}
