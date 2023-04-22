package mercado.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.util.ArrayList;



import java.sql.ResultSet;


import mercado.model.Produto;

public class ProdutoDAO {
	
	public void CadastrarProduto(Produto produto) {
		
		
		String sql = "INSERT INTO PRODUTO VALUES (null,?,?,?,?)";
		PreparedStatement pStatement = null;
		Connection conex = null;
		
		try {
			
			conex = new ConexaoMysql().getConnection();
			pStatement = conex.prepareStatement(sql);
			pStatement.setString(1, produto.getDescricao());
			pStatement.setInt(2, produto.getQuantidade());
			pStatement.setDouble(3, produto.getPreco());
			pStatement.setBoolean(4, produto.isOnline());
			pStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement!=null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if (conex!=null)
					conex.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} 
	}
	
	public Produto BuscarProdutoporId(int id) {
		String sql = "SELECT * FROM PRODUTO WHERE idProduto = ?";
		ResultSet res = null;
		Connection conex = null;
		PreparedStatement pStatement = null;
		Produto produto = null;
		
		try {
			conex = new ConexaoMysql().getConnection();
			pStatement = conex.prepareStatement(sql);
			pStatement.setInt(1, id);
			res = pStatement.executeQuery();
			if(res!=null && res.next()) {
				produto = new Produto();
				produto.setIdProduto(res.getInt("idProduto"));
				produto.setDescricao(res.getString("descricao"));
				produto.setQuantidade(res.getInt("quantidade"));
				produto.setPreco(res.getDouble("preco"));
				produto.setOnline(res.getBoolean("online"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement!=null) {
					pStatement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (conex!=null) {
					conex.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return produto;
	}
	
	
	public ArrayList<Produto> BuscarProdutosPorDescricao(String descricao) {
		String sql = "SELECT * FROM PRODUTO WHERE descricao Like '%" + descricao + "%'";
		ResultSet res = null;
		Connection conex = null;
		PreparedStatement pStatement = null;
		Produto produto = null;
		ArrayList<Produto> produtos = null;
		
		try {
			conex = new ConexaoMysql().getConnection();
			pStatement = conex.prepareStatement(sql);
			res =  pStatement.executeQuery();
			if(res!=null) {
				produtos = new ArrayList<Produto>();
				
				while(res.next()) {
					produto = new Produto();
					produto.setIdProduto(res.getInt("idProduto"));
					produto.setDescricao(res.getString("descricao"));
					produto.setQuantidade(res.getInt("quantidade"));
					produto.setPreco(res.getDouble("preco"));
					produto.setOnline(res.getBoolean("online"));
					produtos.add(produto);
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement!=null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if (conex!=null)
					conex.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} 
		
		
		return produtos;
 	}
	


public void ExcluirProduto(int idProduto) {
	String sql = "DELETE FROM PRODUTO WHERE idProduto = ?";
	PreparedStatement pStatement = null;
	Connection conex = null;
	try {
		conex = new ConexaoMysql().getConnection();
		pStatement = conex.prepareStatement(sql);
		pStatement .setInt(1, idProduto);
		pStatement.execute();
	} catch (Exception e) {
	  e.printStackTrace();
	} finally {
		try {
			if (pStatement!=null)
				pStatement.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		try {
			if (conex!=null)
				conex.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}  
}

public void AlterarProduto(Produto produto) {
	String sql = "UPDATE PRODUTO SET descricao = ?, quantidade= ?, preco= ?, online = ? WHERE idProduto = ?";
	PreparedStatement pStatement = null;
	Connection conex =null;
	
	try {
		conex = new ConexaoMysql().getConnection();
		pStatement = conex.prepareStatement(sql);
		pStatement.setString(1, produto.getDescricao());
		pStatement.setInt(2, produto.getQuantidade());
		pStatement.setDouble(3, produto.getPreco());
		pStatement.setBoolean(4, produto.isOnline());
		pStatement.setInt(5, produto.getIdProduto());
		pStatement.execute();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if (pStatement!=null)
				pStatement.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		try {
			if (conex!=null)
				conex.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}  
	
	
}


}
