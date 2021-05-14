package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import metier.Archetype;
import metier.Marchand;

public class DAOArchetype implements IDAO<Archetype,Integer> {

	@Override
	public List<Archetype> findAll() {
		
		List<Archetype> archetypes = new ArrayList<Archetype>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital", "root", "");

			PreparedStatement ps = conn.prepareStatement("select * from archetype");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				Archetype a = new Archetype(rs.getInt("id"), rs.getString("nom"), rs.getList("objectif"));
				archetypes.add(a);
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return archetypes;
	}

	@Override
	public Archetype findById(Integer id) {
		
		Archetype a = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital", "root", "");

			PreparedStatement ps = conn.prepareStatement("select * from archetype where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				a = new Archetype(rs.getInt("id"), rs.getString("nom"), rs.getList("objectif"));
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
		
	}

	@Override
	public Archetype insert(Archetype archetype) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital", "root", "");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO archetype VALUES (?,?,?)");

			ps.setInt(1, archetype.getId());
			ps.setString(2, archetype.getNom());
			ps.setList(3, archetype.getObjectifs());
			
			ps.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return archetype;
		
	}

	@Override
	public Archetype update(Archetype archetype) {
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");
			PreparedStatement ps = conn.prepareStatement("UPDATE Marchand set Nom=?,Objectifs=? where Id=?");

			ps.setString(1, archetype.getNom());
			ps.setlist(2, archetype.getObjectifs());;
			ps.setInt(6, archetype.getId());

			ps.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return archetype;
	}
	
}