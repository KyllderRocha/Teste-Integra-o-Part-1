package com.ifpe.ts.testes.piramide;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.ifpe.ado.item.RepositorioItem;
import com.ifpe.ado.professor.RepositorioProfessor;
import com.ifpe.excecoes.SiapeInvalidoException;
import com.ifpe.excecoes.TelefoneInvalidoException;
import com.ifpe.item.Item;
import com.ifpe.professor.Professor;
import com.ifpe.utils.DbUtils;

@RunWith(value = BlockJUnit4ClassRunner.class)
public class RepositorioItemTest {
	
	private static DbUtils db = new DbUtils();
	
	@Before
	public void init() throws Exception {
		db.abrirConexao();
	}
	
	@Test(expected = SQLException.class)
	public void insertTest() throws TelefoneInvalidoException, SiapeInvalidoException, SQLException  {
		
        Item item = new Item("123456", "Teste");
        RepositorioItem rep = new RepositorioItem();
        int i = rep.inserir(item);
        assertFalse(throwException());
	}
	
	@Test(expected = SQLException.class)
	public void deleteTest() throws TelefoneInvalidoException, SiapeInvalidoException, SQLException  {

        Item item = new Item("123456", "Teste");
        RepositorioItem rep = new RepositorioItem();
        int i = rep.inserir(item);
        rep.remover(item.getCodigoItem());
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
