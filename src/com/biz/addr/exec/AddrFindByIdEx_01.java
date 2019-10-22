package com.biz.addr.exec;

import com.biz.addr.service.AddrServiceV1;

public class AddrFindByIdEx_01 {

	public static void main(String[] args) {
		
		AddrServiceV1 as = new AddrServiceV1();
		
		as.viewAddrList();
		as.searchAddrId();

	}

}