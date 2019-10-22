package com.biz.addr.service;

import java.util.Scanner;

import com.biz.addr.presistence.AddrDTO;
import com.biz.addr.presistence.dao.AddrDao;
import com.biz.addr.presistence.dao.AddrDaoImp;

public class AddrCUDServiceV1 {
	
	private AddrDao addrDao = null;
	private Scanner scanner = null;
	
	public AddrCUDServiceV1() {
		scanner = new Scanner(System.in);
		addrDao = new AddrDaoImp();
	}
	
	public void inputAddr() {
		
		while(true) {
			System.out.println("==============================================================");
			System.out.println("주소록 등록");
			System.out.println("==============================================================");
			
			String strId = null;
			int intId = 0;
			while(true) {
				try {
					System.out.print("1. 코드(-Q:quit) >> ");
					strId = scanner.nextLine();
					intId = Integer.valueOf(strId);
					if(strId.equals("-Q")) break;
					if(strId.isEmpty()) {
						System.out.println("도서명은 반드시 입력해야 합니다.");
						continue;
					}
				} catch (Exception e) {
					System.out.println("가격은 숫자로만 입력!!");
					continue;
				}
				break;
			}
			if(strId.equals("-Q")) break;
			
			System.out.print("2. 이름(-Q:quit) >> ");
			String strName = scanner.nextLine();
			if(strName.equals("-Q")) break;
			
			System.out.print("3. 전화번호(-Q:quit) >> ");
			String strTel = scanner.nextLine();
			if(strTel.equals("-Q")) break;
			
			System.out.print("4. 주소(-Q:quit) >> ");
			String strAddr = scanner.nextLine();
			if(strAddr.equals("-Q")) break;
			
			System.out.print("5. 관계(-Q:quit) >> ");
			String strChain = scanner.nextLine();
			if(strChain.equals("-Q")) break;
			
			AddrDTO addrDTO = AddrDTO.builder()
					.id((long)intId)
					.name(strName)
					.tel(strTel)
					.addr(strAddr)
					.chain(strChain)
					.build();
			
			int ret = addrDao.insert(addrDTO);
			if(ret > 0)
				System.out.println("주소록 정보 저장 완료");
			else
				System.out.println("주소록 정보 저장 실패");
		}
	}

	public void deleteAddr() {
		
		while(true) {
			System.out.println("===================================");
			System.out.print("삭제할 코드(-Q:quit) >> ");
			String strId = scanner.nextLine();
			int intId = Integer.valueOf(strId);
			
			if(strId.equals("-Q")) break;
			
			AddrDTO addrDTO = addrDao.findById((long)intId);
			if(addrDTO == null) {
				System.out.println("도서 코드가 없습니다.");
				continue;
			}
			addrDao.delete(strId);
		}

	}
	
}