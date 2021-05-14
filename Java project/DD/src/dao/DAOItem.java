package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import metier.Item;

public class DAOItem implements IDAO<Item, Integer> { 

	public List<Item> findAll() {

		List<Item> items = new ArrayList<Item>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital", "root", "");

			PreparedStatement ps = conn.prepareStatement("select * from item");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				Item i = new Item(rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getInt("valeur"));
				items.add(i);
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	public Item findById(Integer id) {

		Item i = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital", "root", "");

			PreparedStatement ps = conn.prepareStatement("select * from item where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				i = new Item(rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getInt("valeur"));
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public Item insert(Item item) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital", "root", "");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO item VALUES (?,?,?,?)");
			ps.setInt(1, item.getId());
			ps.setString(2, item.getNom());
			ps.setString(3, item.getDescription());
			ps.setInt(4, item.getValeur());
			ps.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	public Item update(Item item) {

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");
			PreparedStatement ps = conn.prepareStatement("UPDATE Item set Nom=?,Description=?,Valeur=? where Id=?");

			ps.setString(1, item.getNom());
			ps.setString(2, item.getDescription());;
			ps.setInt(3, item.getValeur());
			ps.setInt(4, item.getId());

			ps.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}	

}
