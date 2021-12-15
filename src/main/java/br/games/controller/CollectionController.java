package br.games.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.games.model.Collection;

// ESSA CLASSE PROVE OPERAÇÕES CRUD DE DB PARA A TABELA GAMESDB
public class CollectionController {
    private String host = "localhost";
    private String port = "3306";
    private String dbName = "game-collection";
    private String user = "root";
    private String pass = "root";
    
    private static final String INSERT_GAMES_SQL = "INSERT INTO gamesdb" + "  (nome, desenv, estilo, plataforma) VALUES " + " (?, ?, ?, ?);";
    private static final String SELECT_GAMES_ID  = "SELECT id, nome, desenv, estilo, plataforma FROM gamesdb WHERE id =?";
    private static final String SELECT_GAMES_ALL = "SELECT * FROM gamesdb";
    private static final String DELETE_GAMES_SQL = "DELETE FROM gamesdb where id = ?;";
    private static final String UPDATE_GAMES_SQL = "UPDATE gamesdb SET nome = ?, desenv = ?, estilo = ?, plataforma = ? WHERE id = ?;";

    public CollectionController() {
    	
    }
    
    protected Connection getConexao() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dbName + "?user=" + user
					+ "&password=" + pass + "&useTimezone=true&serverTimezone=UTC");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    // CRIA OU INSERE UM JOGO
    public void insertJogo(Collection collection) throws SQLException{
    	try(Connection conn = getConexao();
    			PreparedStatement ps = conn.prepareStatement(INSERT_GAMES_SQL)){
    		ps.setString(1, collection.getNome());
    		ps.setString(2, collection.getDesenv());
    		ps.setString(3, collection.getEstilo());
    		ps.setString(4, collection.getPlataforma());
    		ps.executeUpdate();
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    // ATUALIZA UM JOGO
    public boolean updateJogo(Collection collection) throws SQLException {
    	boolean lineAtualizada;
    	try(Connection conn = getConexao();
    			PreparedStatement ps = conn.prepareStatement(UPDATE_GAMES_SQL)){
    		ps.setString(1, collection.getNome());
    		ps.setString(2, collection.getDesenv());
    		ps.setString(3, collection.getEstilo());
    		ps.setString(4, collection.getPlataforma());
    		ps.setInt(5, collection.getId());
    		
    		lineAtualizada = ps.executeUpdate() > 0;
    	}
    	return lineAtualizada;
    }
    
    // SELECIONA UM JOGO POR ID
    public Collection selectJogo(int id) {
    	Collection collection = null;
    	try(Connection conn = getConexao();
    			PreparedStatement ps = conn.prepareStatement(SELECT_GAMES_ID)){
    		ps.setInt(1, id);
    		ResultSet rs = ps.executeQuery();
    		
    		while (rs.next()) {
    			String nome = rs.getString("nome");
    			String desenv = rs.getString("desenv");
    			String estilo = rs.getString("estilo");
    			String plataforma = rs.getString("plataforma");
    			collection = new Collection(id, nome, desenv, estilo, plataforma);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return collection;
    }
    
    // SELECIONA TODOS OS JOGOS
    public List<Collection> selectTodosJogos() {
    	List<Collection> collections = new ArrayList<>();

    	try(Connection conn = getConexao();
    			PreparedStatement ps = conn.prepareStatement(SELECT_GAMES_ALL);) {
    		ResultSet rs = ps.executeQuery();
    		
    		while (rs.next()) {
    			int id = rs.getInt("id");
    			String nome = rs.getString("nome");
    			String desenv = rs.getString("desenv");
    			String estilo = rs.getString("estilo");
    			String plataforma = rs.getString("plataforma");
    			collections.add(new Collection(id, nome, desenv, estilo, plataforma));
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return collections;
    }
    
    // EXCLUI UM JOGO
    public boolean deleteJogo(int id) throws SQLException {
    	boolean lineExcluida;
    	try(Connection conn = getConexao();
    			PreparedStatement ps = conn.prepareStatement(DELETE_GAMES_SQL);) {
    		ps.setInt(1, id);
    		
    		lineExcluida = ps.executeUpdate() > 0;
    	}
    	return lineExcluida;
    }
}
