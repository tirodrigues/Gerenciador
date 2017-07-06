package br.com.alura.gerenciador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.interfaces.Tarefa;

@WebServlet(urlPatterns="/executa")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tarefa = req.getParameter("tarefa");
		
		if(tarefa == null) { 
			throw new IllegalArgumentException("Você esqueceu de passar a tarefa");
		}
		
		tarefa = "br.com.alura.gerenciador." + tarefa;
		try {
			Class<?> tipo = Class.forName(tarefa);
			Tarefa instancia = (Tarefa)tipo.newInstance();
			String pagina = instancia.executa(req, resp);
			req.getRequestDispatcher(pagina).forward(req, resp);
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}

}
