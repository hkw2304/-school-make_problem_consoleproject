package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utils.ConnectionFac;
import vo.AccountVo;
import vo.RecordVo;

public class Dao {
	StringBuilder sql = null;
	List<RecordVo> list=null;
	public boolean createAccount(AccountVo accountVo) {
		sql = new StringBuilder();
		sql.append("insert into log_table(id,pw,addr,email) values(?,?,?,?)");
		try (
				Connection con = new ConnectionFac().getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql.toString());
				){
			pstmt.setString(1, accountVo.getId());
			pstmt.setString(2, accountVo.getPw());
			pstmt.setString(3, accountVo.getAddr());
			pstmt.setString(4, accountVo.getEmail());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("중복된 id 입니다!!!!!");
			return false;
		}
		return true;
	}
	public String selectByIdAndPw(String id, String pw) {
		// TODO Auto-generated method stub
		sql = new StringBuilder();
		sql.append("select * from log_table where id = ? and pw = ?");
		
		try (
				Connection con = new ConnectionFac().getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql.toString());
				
				){
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					return rs.getString("id");
				}
				rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
	public void selectLevelzeroById(String loginId) {
		// TODO Auto-generated method stub
		sql = new StringBuilder();
		sql.append("update log_table set levelzero = levelzero + 1 where id = ?");
		try (
				Connection con = new ConnectionFac().getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql.toString());
				)
		{
			pstmt.setString(1, loginId);
			int cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void selectLevelOneById(String loginId) {
		// TODO Auto-generated method stub
		sql = new StringBuilder();
		sql.append("update log_table set levelone = levelone + 1 where id = ?");
		try (
				Connection con = new ConnectionFac().getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql.toString());
				)
		{
			pstmt.setString(1, loginId);
			int cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void selectLevelTwoById(String loginId) {
		// TODO Auto-generated method stub
		sql = new StringBuilder();
		sql.append("update log_table set leveltwo = leveltwo + 1 where id = ?");
		try (
				Connection con = new ConnectionFac().getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql.toString());
				)
		{
			pstmt.setString(1, loginId);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public List<RecordVo> selectRecord(String loginId) {
		// TODO Auto-generated method stub
		list = new ArrayList<>();
		sql = new StringBuilder();
		sql.append("select id, levelzero, levelone, leveltwo from log_table where id = ?");
		try (
				Connection con = new ConnectionFac().getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql.toString());
				)
		{
			pstmt.setString(1, loginId);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			list.add(new RecordVo(rs.getString("id"), rs.getInt("levelzero"), rs.getInt("levelone"), rs.getInt("leveltwo")));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}
