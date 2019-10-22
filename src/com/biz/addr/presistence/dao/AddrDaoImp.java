package com.biz.addr.presistence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.addr.config.DBContract;
import com.biz.addr.presistence.AddrDTO;

public class AddrDaoImp extends AddrDao {

	@Override
	public List<AddrDTO> selectAll() {
		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_ADDRS;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet rst = pStr.executeQuery();

			List<AddrDTO> addrList = new ArrayList<AddrDTO>();
			
			while(rst.next()) {
				AddrDTO dto = this.rst_2_DTO(rst);
				addrList.add(dto);
			}
			rst.close();
			pStr.close();
			return addrList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private AddrDTO rst_2_DTO(ResultSet rst) throws SQLException {
		AddrDTO dto = AddrDTO.builder()
				.id(rst.getLong("ID"))
				.name(rst.getString("NAME"))
				.tel(rst.getString("TEL"))
				.addr(rst.getString("ADDR"))
				.chain(rst.getString("CHAIN"))
				.build();
		
		return dto;
	}

	@Override
	public AddrDTO findById(long id) {
		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_ADDRS;
		sql += " WHERE id = ? ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, id);
			ResultSet rst = pStr.executeQuery();
			
			AddrDTO addrDTO = null;
			while(rst.next()) {
				addrDTO = this.rst_2_DTO(rst);
			}
			rst.close();
			pStr.close();
			return addrDTO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AddrDTO> findByName(String name) {
		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_ADDRS;
		sql += " WHERE name = ? ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, name);
			ResultSet rst = pStr.executeQuery();

			List<AddrDTO> addrList = new ArrayList<AddrDTO>();
			while(rst.next()) {
				AddrDTO dto = this.rst_2_DTO(rst);
				addrList.add(dto);
			}
			rst.close();
			pStr.close();
			return addrList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AddrDTO> findByTel(String tel) {
		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_ADDRS;
		sql += " WHERE tel = ? ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, tel);
			ResultSet rst = pStr.executeQuery();

			List<AddrDTO> addrList = new ArrayList<AddrDTO>();
			while(rst.next()) {
				AddrDTO dto = this.rst_2_DTO(rst);
				addrList.add(dto);
			}
			rst.close();
			pStr.close();
			return addrList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AddrDTO> findByChain(String chain) {
		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_ADDRS;
		sql += " WHERE chain = ? ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, chain);
			ResultSet rst = pStr.executeQuery();

			List<AddrDTO> addrList = new ArrayList<AddrDTO>();
			while(rst.next()) {
				AddrDTO dto = this.rst_2_DTO(rst);
				addrList.add(dto);
			}
			rst.close();
			pStr.close();
			return addrList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insert(AddrDTO addrDTO) {
		PreparedStatement pStr = null;
		String sql = " INSERT INTO tbl_addr( ";
		sql += " ID, "; 
		sql += " NAME, ";
		sql += " TEL, "; 
		sql += " ADDR, "; 
		sql += " CHAIN) ";
		sql += " VALUES(?, ?, ?, ?, ?) ";
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, addrDTO.getId());
			pStr.setString(2, addrDTO.getName());
			pStr.setString(3, addrDTO.getTel());
			pStr.setString(4, addrDTO.getAddr());
			pStr.setString(5, addrDTO.getChain());

			int ret = pStr.executeUpdate();
			pStr.close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(AddrDTO addrDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		PreparedStatement pStr = null;
		String sql = " DELETE FROM tbl_addr ";
		sql += " WHERE id = ? ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, id);
			
			int ret = pStr.executeUpdate();
			
			pStr.close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}