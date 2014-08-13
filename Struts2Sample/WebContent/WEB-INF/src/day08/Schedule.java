package day08;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Schedule implements Serializable {
	public Schedule(){/* コンストラクタ */}

	private int sid;
	public void setSid(int sid){this.sid = sid;}
	public int getSid(){return this.sid;}

	private String title;
	public void setTitle(String title){this.title = title;}
	public String getTitle(){return this.title;}

	private String sdate;
	public void setSdate(String sdate){this.sdate = sdate;}
	public String getSdate(){return this.sdate;}

	private String stime;
	public void setStime(String stime){this.stime = stime;}
	public String getStime(){return this.stime;}

	private String memo;
	public void setMemo(String memo){this.memo = memo;}
	public String getMemo(){return this.memo;}

	public int insertInfo(){
		int result = 0;
		Connection db = null;
		PreparedStatement ps =null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/Jsp10");
			db = ds.getConnection();
			ps = db.prepareStatement("INSERT INTO schedule(title, sdate, stime, memo) VALUES(? ,? ,? ,?)");
			ps.setString(1, this.title);
			ps.setString(2, this.sdate);
			ps.setString(3, this.stime);
			ps.setString(4, this.memo);
			result = ps.executeUpdate();
			ps.close();
			db.close();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null){ps.close();}
				if(db!=null){db.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int editInfo(){
		int result = 0;
		Connection db = null;
		PreparedStatement ps =null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/Jsp10");
			db = ds.getConnection();
			ps = db.prepareStatement("UPDATE jsp10.schedule SET title = ? , sdate = ?, stime = ?, memo=? WHERE sid = ?");
			ps.setString(1, this.title);
			ps.setString(2, this.sdate);
			ps.setString(3, this.stime);
			ps.setString(4, this.memo);
			ps.setInt(5, this.sid);
			result = ps.executeUpdate();
			ps.close();
			db.close();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null){ps.close();}
				if(db!=null){db.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static ArrayList<Schedule> getInfos(){
		ArrayList<Schedule> list = new ArrayList<Schedule>();
		Connection db = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/Jsp10");
			db = ds.getConnection();
			ps = db.prepareStatement("SELECT * FROM schedule ORDER BY sdate, stime");
			rs = ps.executeQuery();
			while(rs.next()){
				Schedule info = new Schedule();
				info.setSid(rs.getInt("sid"));
				info.setTitle(rs.getString("title"));
				info.setSdate(rs.getString("sdate"));
				info.setStime(rs.getString("stime"));
				info.setMemo(rs.getString("memo"));
				list.add(info);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null){rs.close();}
				if(ps!=null){ps.close();}
				if(db!=null){db.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
