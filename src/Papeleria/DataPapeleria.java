package Papeleria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DataPapeleria {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/hospital";
	private static final String user = "root";
	private static final String pass = "";

	static {
		try {
			Class.forName(driver);
			System.out.print("se cargó el controlador");
		} catch (ClassNotFoundException e) {
			System.out.print("error");
			e.printStackTrace();
		
		}
	}

	public Connection conectar() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(url, user, pass);
			System.out.print("conexión correcta");
		} catch (SQLException e) {
			System.out.print("error");
			e.printStackTrace();
		}
		return conexion;
	}
	public static void main (String args[]) {
		DataPapeleria y = new DataPapeleria();
		y.conectar();
	}

public boolean insertar(NegocioPapeleria ne) {
	PreparedStatement ps=null;
	try {
		ps=conectar().prepareStatement("INSERT INTO productos VALUES (?,?,?,?,?)");
		ps.setString(1,ne.getId());
		ps.setString(2,ne.getNom());
		ps.setString(3,ne.getPre());
		ps.setString(4,ne.getCan());
		ps.setString(5,ne.getTotal());
		
		ps.execute();
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
}
public boolean actualizar(NegocioPapeleria ne) {
	PreparedStatement ps=null;
	try {
		ps=conectar().prepareStatement("UPDATE productos SET nom=?,pre=?,can=?,total=? WHERE id=?");
		ps.setString(1,ne.getNom());
		ps.setString(2,ne.getPre());
		ps.setString(3,ne.getCan());
		ps.setString(4,ne.getTotal());
		ps.setString(5,ne.getId());
		
		ps.execute();
		return ps.executeUpdate()>0;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
}
public boolean cargar(NegocioPapeleria ne) {
	PreparedStatement ps=null;
	ResultSet rs=null;
	try {
		ps=conectar().prepareStatement("SELECT * FROM paciente WHERE idPaciente=?");
		ps.setString(1,ne.id);
		rs=ps.executeQuery();
		if(rs.next()) {
				ne.setId(rs.getString(1));
				ne.setNom(rs.getString(2));
				ne.setPre(rs.getString(3));
				ne.setCan(rs.getString(4));
				ne.setTotal(rs.getString(5));
			
				return true;
		}else {
			return false;
		}
	} catch (Exception e) {
	
	e.printStackTrace();
	return false;
}
	
}
public boolean eliminar(String id) {
	PreparedStatement ps=null;
	try {
		ps=conectar().prepareStatement("DELETE FROM prodcutos WHERE id=?");
		ps.setString(1, id);
		ps.executeUpdate();
		return ps.executeUpdate()>0;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}

}
}
