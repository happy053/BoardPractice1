package com.koreait.board4.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board4.DBUtils;

public class BoardDAO {
	public static int insertG(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "insert into t_board (title, ctnt, iuser) values (?, ?, ?)";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIuser());
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	public static List<BoardVO> selL() {
		List<BoardVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select a.iboard, A.title, A.regdt, B.unm from t_board A "
				+ " left join t_user B on A.iuser = B.iuser "
				+ " order by A.iboard desc ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");
				
				BoardVO VO = new BoardVO();
				VO.setIboard(iboard);
				VO.setTitle(title);
				VO.setRegdt(regdt);
				VO.setUnm(unm);
				
				list.add(VO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}
	
	public static BoardVO selD(int ib) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO vo = null;
		
		String sql = "select  A.*, B.* from t_board A "
				+ " left join t_user B on A.iuser = B.iuser where A.iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, ib);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new BoardVO();
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");
				String ctnt = rs.getString("ctnt");
				int iuser = rs.getInt("iuser");
				
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setUnm(unm);
				vo.setCtnt(ctnt);
				vo.setIuser(iuser);
				vo.setIboard(ib);
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return vo;
	}
	
	public static int Del(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "delete from t_board where iboard = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	public static BoardVO Update(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "update t_board set title = ?, ctnt = ? where iboard = ? and iuser = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			ps.setInt(4, vo.getIuser());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return null;
	}
}





