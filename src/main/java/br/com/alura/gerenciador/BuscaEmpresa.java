package br.com.alura.gerenciador;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.EmpresaDAO;
import br.com.alura.gerenciador.interfaces.Tarefa;


public class BuscaEmpresa implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(req.getParameter("filtro"));
		req.setAttribute("empresas", empresas);
		
		return "/WEB-INF/paginas/buscaEmpresa.jsp";
	}
}
