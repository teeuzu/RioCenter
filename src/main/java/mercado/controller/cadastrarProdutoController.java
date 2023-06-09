package mercado.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mercado.model.Produto;

import java.io.IOException;

/**
 * Servlet implementation class cadastrarProdutoController
 */
public class cadastrarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastrarProdutoController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String descricao = request.getParameter("descricao");
	
		String mensagem;
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("CadastrarProduto.jsp");
		
		if (descricao!= null && !descricao.isEmpty() && request.getParameter("quantidade")!= null 
				&& !request.getParameter("quantidade").isEmpty()) {
			
			 int quantidade;
			 double preco;
			 quantidade = Integer.parseInt(request.getParameter("quantidade"));
			 preco = Double.parseDouble(request.getParameter("preco"));
			 boolean online = false;
			 if (request.getParameter("online") != null && request.getParameter("online").equals("on")) 
				online = true;
			 Produto produto = new Produto(descricao, quantidade, preco, online);
			 produto.salvar();
			 mensagem = "Produto cadastrado com sucesso!";
			
			
		} else 
			mensagem = "Os campos precisam ser preenchidos!";
		request.setAttribute("mensagem", mensagem);
		dispatcher.forward(request, response);
	}

}
