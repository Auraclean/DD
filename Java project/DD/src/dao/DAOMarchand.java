package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import metier.Marchand;

public class DAOMarchand implements IDAO<Marchand, Integer>{

	public List<Marchand> findAll() {

		List<Marchand> marchands = new ArrayList<Marchand>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital", "root", "");

			PreparedStatement ps = conn.prepareStatement("select * from marchand");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				Marchand m = new Marchand(rs.getInt("id"), rs.getInt("solde"), rs.getList("inventaire"),
						rs.getString("nomMagasin"), rs.getInt("affinite"), rs.getList("questions"));
				marchands.add(m);
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return marchands;
	}
	
	public Marchand findById(Integer id) {

		Marchand m = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital", "root", "");

			PreparedStatement ps = conn.prepareStatement("select * from marchand where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				m = new Marchand(rs.getInt("id"), rs.getInt("solde"), rs.getList("inventaire"), 
						rs.getString("nomMagasin"), rs.getInt("affinite"), rs.getList("questions"));
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public Marchand insert(Marchand marchand) {

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital", "root", "");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO marchand VALUES (?,?,?,?,?,?)");

			ps.setInt(1, marchand.getId());
			ps.setInt(2, marchand.getSolde());
			ps.setList(3, marchand.getInventaire());
			ps.setString(4, marchand.getNomMagasin());
			ps.setInt(5, marchand.getAffinite());
			ps.setList(6, marchand.getQuestions());
			ps.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return marchand;
	}

	@Override
	public Marchand update(Marchand marchand) {

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");
			PreparedStatement ps = conn.prepareStatement("UPDATE Marchand set Solde=?,Inventaire=?,NomMagasin=?,Affinite=?,Questions=?  where Id=?");

			ps.setInt(1, marchand.getSolde());
			ps.setlist(2, marchand.getInventaire());;
			ps.setString(3, marchand.getNomMagasin());
			ps.setInt(5, marchand.getAffinite());
			ps.setList(5, marchand.getQuestions());
			ps.setInt(6, marchand.getId());

			ps.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return marchand;

	}

}
