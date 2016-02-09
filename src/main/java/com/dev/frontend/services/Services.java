package com.dev.frontend.services;

import java.util.ArrayList;
import java.util.List;

import com.dev.frontend.model.Customer;
import com.dev.frontend.model.Product;
import com.dev.frontend.panels.ComboBoxItem;
import com.dev.frontend.services.impl.CustomerClient;
import com.dev.frontend.services.impl.ProductClient;

public class Services {
	public static final int TYPE_PRODUCT = 1;
	public static final int TYPE_CUSTOMER = 2;
	public static final int TYPE_SALESORDER = 3;

	public static final String REST_API_URL = "http://localhost:8080";

	public static Object save(Object object, int objectType) {
		// TODO by the candidate
		/*
		 * This method is called eventually after you click save on any edit
		 * screen object parameter is the return object from calling method
		 * guiToObject on edit screen and the type is identifier of the object
		 * type and may be TYPE_PRODUCT , TYPE_CUSTOMER or TYPE_SALESORDER
		 */
		Object result = null;

		switch (objectType) {
		case TYPE_CUSTOMER:
			result = CustomerClient.create((Customer) object);
			break;
		case TYPE_PRODUCT:
			result = ProductClient.create((Product) object);
			break;

		default:
			break;
		}

		return result;
	}

	public static Object readRecordByCode(String code, int objectType) {
		// TODO by the candidate
		/*
		 * This method is called when you select record in list view of any
		 * entity and also called after you save a record to re-bind the record
		 * again the code parameter is the first column of the row you have
		 * selected and the type is identifier of the object type and may be
		 * TYPE_PRODUCT , TYPE_CUSTOMER or TYPE_SALESORDER
		 */
		Object result = null;

		switch (objectType) {
		case TYPE_CUSTOMER:
			result = CustomerClient.get(code);
			break;
		case TYPE_PRODUCT:
			result = ProductClient.get(code);
			break;

		default:
			break;
		}

		return result;
	}

	public static boolean deleteRecordByCode(String code, int objectType) {
		// TODO by the candidate
		/*
		 * This method is called when you click delete button on an edit view
		 * the code parameter is the code of (Customer - PRoduct ) or order
		 * number of Sales Order and the type is identifier of the object type
		 * and may be TYPE_PRODUCT , TYPE_CUSTOMER or TYPE_SALESORDER
		 */
		boolean result = false;
		switch (objectType) {
		case TYPE_CUSTOMER:
			result = CustomerClient.delete(code);
			break;
		case TYPE_PRODUCT:
			result = ProductClient.delete(code);
			break;
		default:
			break;
		}

		return result;
	}

	public static List<Object> listCurrentRecords(int objectType) {
		// TODO by the candidate
		/*
		 * This method is called when you open any list screen and should return
		 * all records of the specified type
		 */
		List result = new ArrayList<Object>();
		switch (objectType) {
		case TYPE_CUSTOMER:
			result = CustomerClient.fetchAllCustomers();
			break;
		case TYPE_PRODUCT:
			result = ProductClient.fetchAllProducts();
			break;

		default:
			break;
		}

		return result;
	}

	public static List<ComboBoxItem> listCurrentRecordRefernces(int objectType) {
		// TODO by the candidate
		/*
		 * This method is called when a Combo Box need to be initialized and
		 * should return list of ComboBoxItem which contains code and
		 * description/name for all records of specified type
		 */
		return new ArrayList<ComboBoxItem>();
	}

	public static double getProductPrice(String productCode) {
		// by the candidate
		/*
		 * This method is used to get unit price of product with the code passed
		 * as a parameter
		 */
		Product product = ProductClient.get(productCode);
		if (product != null) {
			return product.getPrice();
		}
		return 0;
	}
}
