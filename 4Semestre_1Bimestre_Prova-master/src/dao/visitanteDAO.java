package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import db.ConexaoHSQLDB;
import entity.Visitante;

public class visitanteDAO extends ConexaoHSQLDB{
	final String SQL_INSERT_VISITANTE = "INSERT INTO VISITANTE(NOME, RG, CPF, TELEFONE, EMAIL, DATAVISITA) VALUES (?,?,?,?,?,?)";
	final String SQL_SELECT_VISITANTE = "SELECT * FROM VISITANTE";
	final String SQL_SELECT_VISITANTE_ID = "SELECT * FROM VISITANTE WHERE ID = ?";
	final String SQL_ALTERA_VISITANTE = "UPDATE VISITANTE SET NOME=?, RG=? , CPF=?, TELEFONE=?, EMAIL=?, DATAVISITA=? WHERE ID = ?";
	final String SQL_DELETA_VISITANTE = "DELETE FROM VISITANTE WHERE ID = ?";

public int inserir(Visitante visitante) {
	int quantidade = 0;

	//INSERIR
	try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_INSERT_VISITANTE);) {
		pst.setString(1, visitante.getNome());
		pst.setString(2, visitante.getRG());
		pst.setString(3, visitante.getCPF());
		pst.setString(4, visitante.getTelefone());
		pst.setString(5, visitante.getEmail());
		pst.setDate(6, java.sql.Date.valueOf(visitante.getDataVisita().toString()));
		quantidade = pst.executeUpdate();
		

	} catch (SQLException e) {
		e.printStackTrace();
	}

	return quantidade;
	}


	//To List
public List<Visitante> listAll(){
	List<Visitante> listaVisitante = new ArrayList<Visitante>();
	
	try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_SELECT_VISITANTE);){

		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			Visitante visitante = new Visitante();
			
			visitante.setId(rs.getInt("ID"));
			visitante.setNome(rs.getString("NOME"));
			visitante.setRG(rs.getString("RG"));
			visitante.setCPF(rs.getString("CPF"));
			visitante.setTelefone(rs.getString("TELEFONE"));
			visitante.setEmail(rs.getString("EMAIL"));
			visitante.setDataVisita(java.sql.Date.valueOf((rs.getString("DATAVISITA"))));
			
			listaVisitante.add(visitante);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return listaVisitante;
	}
	
	//Find by ID
public Visitante findByID(int Id) {
	Visitante visitante = null;
	try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_SELECT_VISITANTE_ID);){

		pst.setInt(1, Id);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			visitante = new Visitante();
			
			visitante.setId(rs.getInt("ID"));
			visitante.setNome(rs.getString("NOME"));
			visitante.setRG(rs.getString("RG"));
			visitante.setCPF(rs.getString("CPF"));
			visitante.setTelefone(rs.getString("TELEFONE"));
			visitante.setEmail(rs.getString("EMAIL"));
			visitante.setDataVisita(rs.getDate("DATAVISITA"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return visitante;
	}

	//Change
public int alterar(Visitante visitante) {
	int quantidade = 0;

	try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_ALTERA_VISITANTE);) {
		pst.setString(1, visitante.getNome());
		pst.setString(2,visitante.getRG());
		pst.setString(3,  visitante.getCPF());
		pst.setString(4, visitante.getTelefone());
		pst.setString(5, visitante.getEmail());
		pst.setDate(6, java.sql.Date.valueOf(visitante.getDataVisita().toString()));
		pst.setInt(7, visitante.getId());

		quantidade = pst.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	}

	return quantidade;
	}

	//Delete
public int deletar(int Id) {
        int quantidade = 0;
        try (Connection connection = this.conectar();
                PreparedStatement pst = connection.prepareStatement(SQL_DELETA_VISITANTE);) {
            pst.setInt(1, Id);
            
            quantidade = pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return quantidade;
    }

}
