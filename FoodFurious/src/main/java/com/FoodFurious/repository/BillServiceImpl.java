package com.FoodFurious.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.ParseConversionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodFurious.exceptions.BillException;
import com.FoodFurious.models.Bill;
import com.FoodFurious.repository.BillRepo;


@Service
public class BillServiceImpl implements BillService{
	
	
	@Autowired
	private BillRepo bRepo;
	
	

	@Override
	public Bill addBill(Bill bill) {
		
		Bill SavedBill=	bRepo.save(bill);
		return SavedBill;
	}

	@Override
	public Bill update(Bill bill) throws BillException{
		Optional<Bill> opt= bRepo.findById(bill.getBillId());
		if(opt.isPresent()) {
			Bill UpdateBill=bRepo.save(bill);
			return UpdateBill;
			
		}else
			throw new BillException("Invalid Bill Details...");
		
		
	}

	@Override
	public Bill viewBill(Integer billId)throws BillException {
		Optional<Bill> opt= bRepo.findById(billId);
		if(opt.isPresent()) {
		Bill bill=opt.get();
		return  bill;
		}
		else throw new BillException("Bill Donot Exist with thos BillId "+billId);
	}

	@Override
	public Bill remove(Integer BillId)throws BillException {
	
		Optional<Bill> opt=	bRepo.findById(BillId);
		
		if(opt.isPresent()) {
			Bill ExistingBill=opt.get();
			bRepo.delete(ExistingBill);
			
			return ExistingBill;
		}else
		throw new BillException("Bill not Found");
	}

	@Override
	public List<Bill> viewBills(String startDate, String endDate)throws BillException {
		
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		LocalDate d1=LocalDate.parse(startDate,formatter);
		LocalDate d2=LocalDate.parse(endDate, formatter);
		
		List <Bill> bills=bRepo.findByDate(d1, d2);
		if(bills.size()==0) {
			throw new BillException("No Bill Found Between These Dates");
		}else
		return bills;
	}

//	@Override
//	public List<Bill> viewBills(Integer custId)throws BillException {
//		List<Bill> bills=bRepo.findAll();
//		if(bills.size()==0)
//			throw new BillException("No Bill is there with this customerId "+custId);
//		else {
//			for(Bill b:bills) {
//				b.getOrderDetails().fo
//			}
//		}
//		return bills;
//	}


//	@Override
//	public Double TotalCost(Bill bill) {
//		
//		return null;
//	}

}
