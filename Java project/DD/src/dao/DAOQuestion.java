package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import metier.Question;

public class DAOQuestion implements IDAO<Question, Integer>{

    public List<Question> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    public Question findById(Integer id) {

        Question q = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital", "root", "");

            PreparedStatement ps = conn.prepareStatement("select * from question where id=?");
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) 
            {
                q = new Question(rs.getInt("id"), rs.getString("libelle"), rs.getList("reponses"));
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return q;
    }

    public Question insert(Question object) {
        // TODO Auto-generated method stub
        return null;
    }

    public Question update(Question object) {
        // TODO Auto-generated method stub
        return null;
    }

}