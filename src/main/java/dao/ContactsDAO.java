package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import game_userDTO.GameUserDTO;

public class ContactsDAO {

	private static ContactsDAO instance;

	public static ContactsDAO getInstance() {
		if(instance==null) {
			instance=new ContactsDAO();
		}
		return instance;
	}

	private ContactsDAO() {}

	private Connection getConnection() throws Exception{ 
		Context cts = new InitialContext(); 
		DataSource ds = (DataSource)cts.lookup("java:comp/env/jdbc/mysql");
		return ds.getConnection();
	}

	public int insert(GameUserDTO dto) throws Exception { 

		String sql = "insert into game_user values(null,?,?,default)";

		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getMessage());

			return pstat.executeUpdate(sql);
		}

	}

	public List<GameUserDTO> selectAll() throws Exception{      
		String sql ="select * from game_user";
		SimpleDateFormat sdf = new SimpleDateFormat("MM:dd");

		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){
			List<GameUserDTO> list = new ArrayList<>();
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String message = rs.getString("message");
				Timestamp date = rs.getTimestamp("write_date");
				String write_date = sdf.format(date.getTime());
				list.add(new GameUserDTO(seq,writer,message,write_date));
			}
			return list;
		} 


	}
}