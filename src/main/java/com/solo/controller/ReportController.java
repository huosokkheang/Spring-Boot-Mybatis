package com.solo.controller;

import org.springframework.web.bind.annotation.RequestBody;

import com.core.annotation.SCC;
import com.core.annotation.SOP;
import com.core.collection.SList;
import com.core.collection.Solo;
import com.core.util.validation.SValidatorUtil;

@SCC
public class ReportController {
	
	/*
	 * { "report_type": [ { "repay": [ { "total_repay": "100", "repay_collected":
	 * "100", "total_amount": "100.0", "amount_collected": "100.0" } ] }, { "late":
	 * [ { "total_late": "100", "late_collected": "100", "total_amount": "100.0",
	 * "amount_collected": "100.0" } ] }, { "disburse": [ { "total_disburse": "100",
	 * "new_disburse": "100" } ] } ] }
	 */

	@SOP("STAFF001") //Find All
	public Solo findAllUser(@RequestBody Solo params) throws Exception {
		SValidatorUtil.validate(params, "report_type");
		Solo r_repay = new Solo();
		Solo result = new Solo();
		Solo r_late = new Solo();
		Solo r_disburse = new Solo();
		SList list = params.getSList("report_type");
		for(Solo solo: list.toListSolo()) {
			// Repay
			SList repay = solo.getSList("repay");
			if(!repay.isEmpty() || repay.size() != 0) {
				for(Solo solo2: repay.toListSolo()) {
					SValidatorUtil.validate(solo2, "total_repay", "repay_collected", "total_amount", "amount_collected");
					r_repay.setString("total_repay", solo2.getString("total_repay"));
					r_repay.setString("repay_collected", solo2.getString("repay_collected"));
					r_repay.setString("total_amount", solo2.getString("total_amount"));
					r_repay.setString("amount_collected", solo2.getString("amount_collected"));
				}	
			}
			SList late = solo.getSList("late");
			if(!late.isEmpty() || late.size() != 0) {
				for(Solo solo2: late.toListSolo()) {
					r_late.setString("total_late", solo2.getString("total_late"));
					r_late.setString("late_collected", solo2.getString("late_collected"));
					r_late.setString("total_amount", solo2.getString("total_amount"));
					r_late.setString("amount_collected", solo2.getString("amount_collected"));
				}	
			}
			SList disburse = solo.getSList("disburse");
			if(!disburse.isEmpty() || disburse.size() != 0) {
				for(Solo solo2: disburse.toListSolo()) {
					r_disburse.setString("total_disburse", solo2.getString("total_disburse"));
					r_disburse.setString("new_disburse", solo2.getString("new_disburse"));
				}	
			}
		}
		result.put("repay", r_repay);
		result.put("late", r_late);
		result.put("disburse", r_disburse);
		return result;
	}
}
