package grobal.domain.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import grobal.db.GlobalDAO;
import grobal.model.GlobalEngineer;

public class GlobalService {
	
	private static final GlobalService instance = new GlobalService();
	
	GlobalDAO globalDAO = new GlobalDAO();
	
	public static GlobalService getInstance() {
		return instance;
	}

	public int insert(Integer id, Integer rollNumber, String name, String nationality, String birthday,String sex, String almamater, Integer salary, String employment, String place, String email, String note) {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
		try {
			date = sdFormat.parse(birthday);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		GlobalEngineer globalEngineer = new GlobalEngineer(id, rollNumber, name, nationality, date, sex, almamater, salary, employment, place, email, note);
		return globalDAO.insert(globalEngineer);
	}
	
	public List<GlobalEngineer> selectAll() {
		List<GlobalEngineer> list = new ArrayList<>();
		list = globalDAO.finedtAll();
		return list;
	}
	
	public GlobalEngineer selectGlobalEngineer(Integer id) {
		return globalDAO.finedById(id);
	}
	
	public int insertGlobalEngineer(GlobalEngineer globalEngineer) {
		return globalDAO.insert(globalEngineer);
	}
}