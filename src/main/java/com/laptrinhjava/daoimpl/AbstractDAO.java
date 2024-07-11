package com.laptrinhjava.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjava.connection.ConnectionProvider;
import com.laptrinhjava.dao.IGenericDAO;

import com.laptrinhjava.mapper.RowMapper;

public class AbstractDAO<T> implements IGenericDAO<T> {

	// Hàm set tham số trong quá trình executeQuery
	public void setParameter(PreparedStatement ps, Object... o) {
		try {
			for (int i = 0; i < o.length; i++) {
				if (o[i] instanceof Integer) {
					ps.setInt(i + 1, (int) o[i]);
				} else if (o[i] instanceof String) {
					ps.setString(i + 1, (String) o[i]);
				} else if (o[i] == null) {
					ps.setNull(i + 1, Types.NULL);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Hàm đóng kết nối
	public void closeConnect(Connection connection, PreparedStatement ps, Object... objects) {
		try {
			if (objects[0] instanceof ResultSet && (ResultSet) objects[0] != null) {
				ResultSet rs = (ResultSet) objects[0];
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Hàm truy vấn dữ liệu từ DB(Query)
	@Override
	public List<T> query(String sql, RowMapper<T> t, Object... objects) {
		List<T> list = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			conn = ConnectionProvider.getConnection();
			if (conn != null) {
				list = new ArrayList<>();
				ps = conn.prepareStatement(sql);
				setParameter(ps, objects);
				rs = ps.executeQuery();
				while (rs.next()) {
					list.add(t.mapRow(rs));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnect(conn, ps, rs);

		}
		return list;
	}

	// Hàm liên quan đến insert trong DB
	@Override
	public int insert(String sql, Object... objects) {
		int id = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ConnectionProvider.getConnection();
			if (conn != null) {
				conn.setAutoCommit(false);
				ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				setParameter(ps, objects);
				ps.executeUpdate();
				rs = ps.getGeneratedKeys();
				if (rs.next()) {
					id = rs.getInt(1);
				}
				conn.commit();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
		} finally {
			closeConnect(conn, ps, rs);

		}
		return id;

	}

	// Hàm liên quan đến thay đổi trong DB (Update, Delete)
	@Override
	public void update(String sql, Object... objects) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ConnectionProvider.getConnection();
			if (conn != null) {
				conn.setAutoCommit(false);
				ps = conn.prepareStatement(sql);
				setParameter(ps, objects);
				ps.executeUpdate();
				conn.commit();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
		} finally {
			closeConnect(conn, ps);
		}

	}

	@Override
	public int count(String sql, Object... objects) {
		int count = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ConnectionProvider.getConnection();
			if (conn != null) {
				ps = conn.prepareStatement(sql);
				setParameter(ps, objects);
				rs = ps.executeQuery();
				if (rs.next()) {
					count = rs.getInt(1);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnect(conn, ps, objects);
		}
		return count;
	}

	



}
