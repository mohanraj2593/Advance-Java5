package com.tap.service;

import com.tap.gov.PrimeMinister;
import com.tap.gov.Services;

public class IndianAirForce implements Services {
public void addressPm() {
	PrimeMinister pm= PrimeMinister.getPm();
	System.out.println("Indian Air Force Prime Minister: "+pm);
}
}
