package com.dev.frontend.panels.list;

import java.util.List;

import com.dev.frontend.model.Customer;
import com.dev.frontend.model.Product;
import com.dev.frontend.services.Services;

public class ProductDataModel extends ListDataModel {
	private static final long serialVersionUID = 7526529951747614655L;

	public ProductDataModel() {
		super(new String[] { "Code", "Description", "Price", "Quantity" }, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_PRODUCT;
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
			return new String[][] { { "", "", "", "" } };
		}

		String[][] data = new String[list.size()][4];

		for (int i = 0; i < list.size(); i++) {
			Object object = list.get(i);
			if (object instanceof Product) {
				Product product = (Product) object;
				data[i][0] = product.getCode();
				data[i][1] = product.getDescription();
				data[i][2] = String.valueOf(product.getPrice());
				data[i][3] = String.valueOf(product.getQuantity());
			}
		}

		return data;
	}
}
