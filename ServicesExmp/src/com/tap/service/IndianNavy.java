package com.tap.service;

import com.tap.gov.PrimeMinister;
import com.tap.gov.Services;

public class IndianNavy implements Services {
public void addressPm(){
	PrimeMinister pm = PrimeMinister.getPm();
	System.out.println("Indian Navy Prime Minister: "+pm);
}
}
