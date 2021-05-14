package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import metier.Reponse;

public class DAOReponse implements IDAO<Reponse, Integer>{

	public List<Reponse> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Reponse findById(Integer id) {

		Reponse r = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital", "root", "");

			PreparedStatement ps = conn.prepareStatement("select * from reponse where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				r = new Reponse(rs.getInt("id"), rs.getString("libelle"));
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	public Reponse insert(Reponse object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Reponse update(Reponse object) {
		// TODO Auto-generated method stub
		return null;
	}
	
}