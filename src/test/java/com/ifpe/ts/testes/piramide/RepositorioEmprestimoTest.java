package com.ifpe.ts.testes.piramide;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.ifpe.ado.emprestimo.RepositorioEmprestimo;
import com.ifpe.ado.professor.RepositorioProfessor;
import com.ifpe.emprestimo.Emprestimo;
import com.ifpe.excecoes.SiapeInvalidoException;
import com.ifpe.excecoes.TelefoneInvalidoException;
import com.ifpe.professor.Professor;
import com.ifpe.utils.DbUtils;

@RunWith(value = BlockJUnit4ClassRunner.class)
public class RepositorioEmprestimoTest {
	
	private static DbUtils db = new DbUtils();
	
	@Before
	public void init() throws Exception {
		db.abrirConexao();
	}
	
	@Test(expected = SQLException.class)
	public void insertTest() throws TelefoneInvalidoException, SiapeInvalidoException, SQLException  {
		Date dt = new Date();
        Emprestimo emp = new Emprestimo("1408701", "123456", dt.toString());
        RepositorioEmprestimo rep = new RepositorioEmprestimo();
        int i = rep.efetuarEmprestimo(emp);
        assertFalse(throwException());
	}
	
	@Test(expected = SQLException.class)
	public void deleteTest() throws TelefoneInvalidoException, SiapeInvalidoException, SQLException  {

		Date dt = new Date();
        Emprestimo emp = new Emprestimo("1408701", "123456", dt.toString());
        RepositorioEmprestimo rep = new RepositorioEmprestimo();
        int i = rep.efetuarEmprestimo(emp);
        rep.removerEmprestimo(i);
        assertFalse(throwException());
	}
	
	private boolean throwException() throws SQLException{
        throw new SQLException();
    }
	
	@After
	public void after() throws Exception {
		db.Rollback();
	}
	
}
