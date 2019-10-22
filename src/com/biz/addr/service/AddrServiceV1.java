package com.biz.addr.service;

import java.util.List;
import java.util.Scanner;

import com.biz.addr.presistence.AddrDTO;
import com.biz.addr.presistence.dao.AddrDao;
import com.biz.addr.presistence.dao.AddrDaoImp;

public class AddrServiceV1 {

	AddrDao addrDao = null;
	Scanner scan = null;
	
	public AddrServiceV1() {
		addrDao = new AddrDaoImp();
		scan = new Scanner(System.in);
	}
	
	public void viewAddrList() {
		List<AddrDTO> addrList = addrDao.selectAll();
		this.viewList(addrList);
	}
	
	private void viewList(List<AddrDTO> addrList) {
		System.out.println("==============================================================");
		System.out.println("전체 주소록 리스트 V1");
		System.out.println("==============================================================");
		System.out.println("코드\t이름\t전화번호\t주소\t관계");
		System.out.println("--------------------------------------------------------------");
		for(AddrDTO dto : addrList) {
			System.out.printf("%s\t", dto.getId());
			System.out.printf("%s\t", dto.getName());
			System.out.printf("%s\t", dto.getTel());
			System.out.printf("%s\t", dto.getAddr());
			System.out.printf("%s\n", dto.getChain());
		}
		System.out.println("=============================================================");
	}

	public void searchAddrId() {
		
		while(true) {
			System.out.println("==============================================================");
			System.out.println("코드 검색");
			System.out.println("==============================================================");
			try {
				System.out.print("코드(Q:quit) >> ");
				String strId = scan.nextLine();
				if(strId.equals("-Q")) break;
				
				int intId = Integer.valueOf(strId);
				
				AddrDTO addrList = addrDao.findById(intId);
				System.out.printf("%s\t", addrList.getId());
				System.out.printf("%s\t", addrList.getName());
				System.out.printf("%s\t", addrList.getTel());
				System.out.printf("%s\t", addrList.getAddr());
				System.out.printf("%s\n", addrList.getChain());
				
			} catch (Exception e) {
				System.out.println("코드는 숫자로만 입력하세요");
				continue;
			}
			
		}
	}

	public void searchAddrName(boolean bConti) {
		while(true) {
			if(this.searchAddrName()) break;
		}
	}
	
	public boolean searchAddrName() {
		System.out.println("==============================================================");
		System.out.println("이름 검색");
		System.out.println("==============================================================");
		System.out.print("이름명(Q:quit) >> ");
		String strName = scan.nextLine();
		if(strName.equals("-Q")) return true;
			
		List<AddrDTO> addrList = addrDao.findByName(strName);
		if(addrList == null || addrList.size() < 1) {
		System.out.println("찾는 이름이 없음!!");
		return false;
		}

		this.viewList(addrList);

		return true;
	}
	
	public void searchAddrTel(boolean bConti) {
		while(true) {
			if(this.searchAddrTel()) break;
		}
	}
	
	public boolean searchAddrTel() {
		System.out.println("==============================================================");
		System.out.println("전화번호 검색");
		System.out.println("==============================================================");
		System.out.print("전화번호(Q:quit) >> ");
		String strTel = scan.nextLine();
		if(strTel.equals("-Q")) return true;
			
		List<AddrDTO> addrList = addrDao.findByTel(strTel);
		if(addrList == null || addrList.size() < 1) {
		System.out.println("찾는 전화번호가 없음!!");
		return false;
		}

		this.viewList(addrList);

		return true;
	}
	
	public void searchAddrChain(boolean bConti) {
		while(true) {
			if(this.searchAddrChain()) break;
		}
	}
	
	public boolean searchAddrChain() {
		System.out.println("==============================================================");
		System.out.println("관계 검색");
		System.out.println("==============================================================");
		System.out.print("관계(Q:quit) >> ");
		String strChain = scan.nextLine();
		if(strChain.equals("-Q")) return true;
			
		List<AddrDTO> addrList = addrDao.findByChain(strChain);
		if(addrList == null || addrList.size() < 1) {
		System.out.println("찾는 관계가 없음!!");
		return false;
		}

		this.viewList(addrList);

		return true;
	}

}