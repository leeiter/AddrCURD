package com.biz.addr.exec;

import com.biz.addr.service.AddrServiceV1;

public class AddrSearchEx_01 {

	public static void main(String[] args) {
		
		AddrServiceV1 as = new AddrServiceV1();
		
		as.viewAddrList();

		as.searchAddrName();
		System.out.println("이름 검색 종료");
		
		as.searchAddrTel();
		System.out.println("전화번호 검색 종료");
		
		as.searchAddrChain();
		System.out.println("관계 검색 종료");

	}

}