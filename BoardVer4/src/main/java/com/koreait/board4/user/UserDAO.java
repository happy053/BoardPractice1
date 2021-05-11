package com.koreait.board4.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board4.board.DBUtils;

public class UserDAO {
	public static int inUser(UserVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "insert into t_user (uid, upw, unm, gender) values (?, ?, ?, ?)";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUid());
			ps.setString(2, vo.getUpw());
			ps.setString(3, vo.getUnm());
			ps.setInt(4, vo.getGender());
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	public static int loginUser(UserVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from t_user where uid = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUid());
			rs = ps.executeQuery();
			
			if (rs.next()) {
				if(rs.getString("Upw").equals(vo.getUpw())) {
					return 1;
				} else {
					return 3;
				}
			} else {
				return 2;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	public static void delUser(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "delete from t_user where uid = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
}
