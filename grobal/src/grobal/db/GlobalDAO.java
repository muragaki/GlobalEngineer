package grobal.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import grobal.model.GlobalEngineer;

public class GlobalDAO {
	
	Connection conn = null;
	
	PreparedStatement pstmtSelectAll = null;
	PreparedStatement pstmtSelect = null;
	PreparedStatement pstmtInsert = null;
	PreparedStatement pstmtUpdate = null;
	PreparedStatement pstmtDelete = null;
	PreparedStatement pstmtFindByDate = null;
	PreparedStatement pstmtCountByDate = null;
	PreparedStatement pstmtInsertDate = null;
	PreparedStatement pstmtUpdateReservable09 = null;
	PreparedStatement pstmtUpdateReservable10 = null;
	PreparedStatement pstmtUpdateReservable11 = null;
	PreparedStatement pstmtUpdateReservable13 = null;
	PreparedStatement pstmtUpdateReservable14 = null;
	PreparedStatement pstmtUpdateReservable15 = null;
	PreparedStatement pstmtUpdateReservable16 = null;
	PreparedStatement pstmtUpdateReservable17 = null;

	
	String driverName = "org.postgresql.Driver";
	String url = "jdbc:postgresql://localhost:5432/";
	String username = "postgres";
	String password = "postgrestest";
	String db = "global";
	
	
	String sqlSelectAll = "SELECT id, rollnumber, name, nationality, birthday, sex, almamater, salary, employment, place, email, note FROM globalengineer";
	String sqlSelect = "SELECT id, rollnumber, name, nationality, birthday, sex, almamater, salary, employment, place, email, note FROM public.globalengineer WHERE id = ?";
	String sqlInsert = "INSERT INTO public.globalengineer(id, rollnumber, name, nationality, birthday, sex, almamater, salary, employment, place, email, note) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	String sqlUpdate = "UPDATE public.globalengineer SET rollnumber=?, name=?, nationality=?, birthday=?, sex=?, almamater=?, salary=?, employment=?, place=?, email=?, note=? WHERE id = ?";
	
	public GlobalDAO() {
		connect();
	}
	
	public void connect() {
		try {			
			 Class.forName(driverName);
			 conn = DriverManager.getConnection(url + db, username, password);
			 pstmtSelectAll = conn.prepareStatement(sqlSelectAll);
			 pstmtSelect = conn.prepareStatement(sqlSelect);
			 pstmtInsert = conn.prepareStatement(sqlInsert);
			 pstmtUpdate = conn.prepareStatement(sqlUpdate);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<GlobalEngineer> finedtAll() {
		List<GlobalEngineer> userList = new ArrayList<>();
		
		try (ResultSet rs = pstmtSelectAll.executeQuery()) {
				while (rs.next()) {
					userList.add(
						new GlobalEngineer(
								rs.getInt("id"),
								rs.getInt("rollnumber"),
								rs.getString("name"),
								rs.getString("nationality"),
								rs.getDate("birthday"),
								rs.getString("sex"),
								rs.getString("almamater"),
								rs.getInt("salary"),
								rs.getString("employment"),
								rs.getString("place"),
								rs.getString("email"),
								rs.getString("note")
						)
					);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public GlobalEngineer finedById(Integer id) {
		GlobalEngineer globalEngineer = null;
		try {
			pstmtSelect.setInt(1, id);
		} catch (SQLException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		try (ResultSet rs = pstmtSelect.executeQuery()) {
			if (rs.next()) {
				globalEngineer = new GlobalEngineer(
						rs.getInt("id"),
						rs.getInt("rollnumber"),
						rs.getString("name"),
						rs.getString("nationality"),
						rs.getDate("birthday"),
						rs.getString("sex"),
						rs.getString("almamater"),
						rs.getInt("salary"),
						rs.getString("employment"),
						rs.getString("place"),
						rs.getString("email"),
						rs.getString("note")
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return globalEngineer;
	}
	
	public int insert(GlobalEngineer globalEngineer) {
		int count = 0;
		try {
			pstmtInsert.setInt(1, globalEngineer.getId());
			pstmtInsert.setInt(2, globalEngineer.getRollnumber());
			pstmtInsert.setString(3, globalEngineer.getName());
			pstmtInsert.setString(4, globalEngineer.getNationality());
			pstmtInsert.setDate(5, new java.sql.Date(globalEngineer.getBirthday().getTime()));
			pstmtInsert.setString(6, globalEngineer.getSex());
			pstmtInsert.setString(7, globalEngineer.getAlmamater());
			pstmtInsert.setInt(8, globalEngineer.getSalary());
			pstmtInsert.setString(9, globalEngineer.getEmployment());
			pstmtInsert.setString(10, globalEngineer.getPlace());
			pstmtInsert.setString(11, globalEngineer.getEmail());
			pstmtInsert.setString(12, globalEngineer.getNote());
			count = pstmtInsert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public int update(GlobalEngineer globalEngineer) {
		int count = 0;
		try {
			pstmtUpdate.setInt(1, globalEngineer.getRollnumber());
			pstmtUpdate.setString(2, globalEngineer.getName());
			pstmtUpdate.setString(3, globalEngineer.getNationality());
			pstmtUpdate.setDate(4, new java.sql.Date(globalEngineer.getBirthday().getTime()));
			pstmtUpdate.setString(5, globalEngineer.getSex());
			pstmtUpdate.setString(6, globalEngineer.getAlmamater());
			pstmtUpdate.setInt(7, globalEngineer.getSalary());
			pstmtUpdate.setString(8, globalEngineer.getEmployment());
			pstmtUpdate.setString(9, globalEngineer.getPlace());
			pstmtUpdate.setString(10, globalEngineer.getEmail());
			pstmtUpdate.setString(11, globalEngineer.getNote());
			count = pstmtUpdate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public int delete(GlobalEngineer globalEngineer) {
		int count = 0;
		try {
			pstmtDelete.setString(1, globalEngineer.getEmail());
			count = pstmtDelete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
