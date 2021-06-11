package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.Members;

public class MembersDAO extends DAO {
	
	public List<Members> search(String keyword) throws Exception{
		List<Members> list=new ArrayList<>();
		
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select*from members where memmber_no ?");
		st.setNString(1, "%+keyword+%");
		ResultSet rs=st.executeQuery();
		
		while(rs.next()) {
			Members m=new Members();
			m.setMember_no(rs.getString("member_no"));
			m.setName(rs.getString("name"));
			m.setAge(rs.getInt("age"));
			m.setBirth_year(rs.getInt("birth_year"));
			m.setBirth_month(rs.getInt("birth_month"));
			m.setBirth_day(rs.getInt("birth_day"));
			list.add(m);
		}
		
		st.close();
		con.close();
		
		return list;
		
		
	}
	
	public int insert(Members members) throws Exception {

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"insert into members value(?, ?, ?, ?, ?, ?)");
		st.setString(1, members.getMember_no());
		st.setString(2, members.getName());
		st.setInt(3, members.getAge());
		st.setInt(4, members.getBirth_year());
		st.setInt(5, members.getBirth_month());
		st.setInt(6, members.getBirth_day());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
}
