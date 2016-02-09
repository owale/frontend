package com.dev.frontend.panels.list;

import java.util.List;

import com.dev.frontend.model.Customer;
import com.dev.frontend.services.Services;

public class CustomerDataModel extends ListDataModel {
	private static final long serialVersionUID = 7526529951747613655L;

	public CustomerDataModel() {
		super(new String[] { "Code", "Name", "Phone", "Current Credit" }, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_CUSTOMER;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) {
		// by the candidate
		/*
		 * This method use list returned by Services.listCurrentRecords and
		 * should convert it to array of rows each row is another array of
		 * columns of the row
		 */
		String[][] data = new String[list.size()][4];

		for (int i = 0; i < list.size(); i++) {
			Object object = list.get(i);
			if (object instanceof Customer) {
				Customer customer = (Customer) object;
				data[i][0] = customer.getCode();
				data[i][1] = customer.getName();
				data[i][2] = customer.getPhone1();
				data[i][3] = String.valueOf(customer.getCurrentLimit());
			}
		}

		return data;
	}
}
