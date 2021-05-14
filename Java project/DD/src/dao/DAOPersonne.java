package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import metier.Personne;

public class DAOPersonne implements IDAO<Personne, Integer> {

	public List<Personne> findAll() {

		List<Personne> personnes = new ArrayList<Personne>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital", "root", "");

			PreparedStatement ps = conn.prepareStatement("select * from Personne");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				Personne p = new Personne(rs.getInt("id"), rs.getString("nom"), rs.getInt("solde"), rs.getList("inventaire"));// impossible d'importer une liste depuis SQL
				personnes.add(p);
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return personnes;
	}

	@Override
	public Personne findById(Integer id) {

		Personne p = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital", "root", "");

			PreparedStatement ps = conn.prepareStatement("select * from personne where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				p = new Personne(rs.getInt("id"), rs.getString("nom"), rs.getInt("solde"), rs.getList("inventaire"));// impossible d'importer une liste depuis SQL
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}


	@Override
	public Personne insert(Personne personne) {

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital", "root", "");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO personne VALUES (?,?,?,?)");
			ps.setInt(1, personne.getId());
			ps.setString(2, personne.getNom());
			ps.setInt(3, personne.getSolde());
			ps.setList(4, personne.getInventaire());// impossible d'importer une liste depuis SQL
			ps.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return personne;
	}

	@Override
	public Personne update(Personne personne) {

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");
			PreparedStatement ps = conn.prepareStatement("UPDATE Personne set Nom=?,Solde=?,inventaire=? where Id=?");

			ps.setString(1, personne.getNom());
			ps.setInt(2, personne.getSolde());;
			ps.setList(3, personne.getInventaire());// impossible d'importer une liste depuis SQL
			ps.setInt(4, personne.getId());

			ps.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return personne;
	}	
	
}
