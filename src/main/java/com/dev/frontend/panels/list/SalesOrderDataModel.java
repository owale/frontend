package com.dev.frontend.panels.list;

import java.util.List;

import com.dev.frontend.model.SalesOrder;
import com.dev.frontend.model.Product;
import com.dev.frontend.panels.ComboBoxItem;
import com.dev.frontend.services.Services;

public class SalesOrderDataModel extends ListDataModel {
	private static final long serialVersionUID = 7526529951747614655L;

	public SalesOrderDataModel() {
		super(new String[] { "Order Number", "Customer", "Total Price" }, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_SALESORDER;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) {
		// by the candidate
		/*
		 * This method use list returned by Services.listCurrentRecords and
		 * should convert it to array of rows each row is another array of
		 * columns of the row
		 */

		if (list.isEmpty()) {
			return new String[][] { { "", "", "" } };
		}

		String[][] data = new String[list.size()][4];

		for (int i = 0; i < list.size(); i++) {
			Object object = list.get(i);
			if (object instanceof SalesOrder) {
				SalesOrder order = (SalesOrder) object;
				data[i][0] = order.getOrderNumber();
				data[i][1] = new ComboBoxItem(order.getCustomer().getCode(),
						order.getCustomer().getName()).toString();
				data[i][2] = String.valueOf(order.getTotalPrice());
			}
		}
		return data;
	}
}
