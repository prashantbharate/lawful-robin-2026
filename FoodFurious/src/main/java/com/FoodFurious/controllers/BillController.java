package com.FoodFurious.controllers;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.FoodFurious.exceptions.BillException;
import com.FoodFurious.models.Bill;
//import com.FoodFurious.models.Item;
import com.FoodFurious.service.BillService;

@RestController
public class BillController {
	

	
	@Autowired
	private BillService bService;
	
	@PostMapping("/BillGenrate")
	public ResponseEntity<String> CreateBill(@RequestBody Bill bill) {
		Bill SavedBill=bService.addBill(bill);
		

		
		return new ResponseEntity<String>( "Bill Genrated "+bill.getBillId(),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/BillGenrate/{id}")
	public ResponseEntity<Bill> ViewBill(@PathVariable ("id") Integer billId) throws BillException {
		Bill bill=bService.viewBill(billId);
		
		return new ResponseEntity<Bill>( bill,HttpStatus.CREATED);
		
	}
	
//	@GetMapping("/Bill")
//	public ResponseEntity<Double> TotalCost(Bill bill){
//	List<Item> items=	bill.getOrderDetails().getFoodCart().getItems();
//	
//	Double sum=0.00;
//	
//	for(Item i : items) {
//		sum+=i.getCost();
//	}
//	return new ResponseEntity<Double>(sum,HttpStatus.OK);
//	}
//	
	
	
	
	@DeleteMapping("/Bill/{id}")
	public ResponseEntity<Bill> Remove(@PathVariable ("id") Integer billId) throws BillException{
		
		Bill bill=bService.remove(billId);
		return new ResponseEntity<Bill>(bill , HttpStatus.OK);
			
	}

//	@GetMapping("/Bills/{id}")
//	public ResponseEntity<List<Bill>> getAllBill(@PathVariable ("id") String Custid)throws BillException {
//		List <Bill> bills=bService.viewBills( Custid);
//		return new ResponseEntity<List<Bill>>(bills,HttpStatus.OK);
//	}

	
	@PutMapping("/Bills")
	public ResponseEntity<Bill> updateBill(@RequestBody Bill Bill)throws BillException{
		
		Bill UpdatedBill=bService.update(Bill);
		
		return new ResponseEntity<Bill>(UpdatedBill,HttpStatus.ACCEPTED);
	}
	@GetMapping("/Bills/{s}/{e}")
	@ResponseBody
	public ResponseEntity<List<Bill>> ViewBillByDate(@PathVariable ("s") String s, @PathVariable ("e") String e) throws BillException{
		List<Bill> bills=bService.viewBills(s, e);
		
		return new ResponseEntity<List<Bill>>(bills,HttpStatus.CREATED);
	}
}
