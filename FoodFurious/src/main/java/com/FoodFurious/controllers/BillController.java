package com.FoodFurious.controllers;

import java.time.LocalDate;
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
	private BillService billService;

	@PostMapping("/BillGenrate")
	public ResponseEntity<String> CreateBill(@RequestBody Bill bill) {
		Bill SavedBill = billService.addBill(bill);

		return new ResponseEntity<String>("Bill Genrated " + bill.getBillId(), HttpStatus.CREATED);

	}

	@GetMapping("/BillGenrate/{billId}")
	public ResponseEntity<Bill> ViewBill(@PathVariable("billId") Integer billId) throws BillException {
		Bill bill = billService.viewBill(billId);

		return new ResponseEntity<Bill>(bill, HttpStatus.CREATED);

	}

	@DeleteMapping("/Bill/{billId}")
	public ResponseEntity<Bill> Remove(@PathVariable("billId") Integer billId) throws BillException {

		Bill bill = billService.removeBill(billId);
		return new ResponseEntity<Bill>(bill, HttpStatus.OK);

	}

	@PutMapping("/Bills")
	public ResponseEntity<Bill> updateBill(@RequestBody Bill Bill) throws BillException {

		Bill UpdatedBill = billService.updateBill(Bill);
		return new ResponseEntity<Bill>(UpdatedBill, HttpStatus.ACCEPTED);
	}

	@GetMapping("/Bills/{startDate}/{endDate}")
	@ResponseBody
	public ResponseEntity<List<Bill>> ViewBillByDate(@PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate) throws BillException {

		List<Bill> bills = billService.viewBills(LocalDate.parse(startDate), LocalDate.parse(endDate));

		return new ResponseEntity<List<Bill>>(bills, HttpStatus.CREATED);
	}
}
