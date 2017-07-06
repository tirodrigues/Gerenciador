package br.com.alura.gerenciador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.EmpresaDAO;
import br.com.alura.gerenciador.interfaces.Tarefa;

public class NovaEmpresa implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		Empresa empresa = new Empresa(req.getParameter("nome"));
		new EmpresaDAO().adiciona(empresa);
		
		req.setAttribute("empresa", empresa);
		return "/WEB-INF/paginas/novaEmpresa.jsp";
	}
}
