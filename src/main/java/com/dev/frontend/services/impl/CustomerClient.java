package com.dev.frontend.services.impl;

import java.io.IOException;
import java.rmi.UnexpectedException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.dev.frontend.model.Customer;
import com.dev.frontend.services.Services;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CustomerClient {

	private static final String API_URL = Services.REST_API_URL + "/customer/";
	private static Gson gson = new Gson();

	private static HttpClient client = new DefaultHttpClient();

	public static Customer create(Customer customer) throws UnexpectedException, ParseException, IOException {
		HttpPost httppost = new HttpPost(API_URL);
		StringEntity se = new StringEntity(gson.toJson(customer));
		se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
		httppost.setHeader(new BasicHeader(HTTP.CONTENT_TYPE,
				"application/json"));
		httppost.setHeader(new BasicHeader("Accept", "application/json"));
		httppost.setEntity(se);

		HttpResponse response = client.execute(httppost);

		if (response.getStatusLine().getStatusCode() == 200) {
			return gson.fromJson(EntityUtils.toString(response.getEntity()),
					Customer.class);
		} else {

			throw new UnexpectedException(EntityUtils.toString(response
					.getEntity()));
		}

	}

	public static Customer update(Customer customer) throws UnexpectedException, ParseException, IOException {
		HttpPost httppost = new HttpPost(API_URL + customer.getCode());
		StringEntity se = new StringEntity(gson.toJson(customer));
		se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
		httppost.setHeader(new BasicHeader(HTTP.CONTENT_TYPE,
				"application/json"));
		httppost.setHeader(new BasicHeader("Accept", "application/json"));
		httppost.setEntity(se);

		HttpResponse response = client.execute(httppost);

		if (response.getStatusLine().getStatusCode() == 200) {
			return gson.fromJson(EntityUtils.toString(response.getEntity()),
					Customer.class);
		} else {
			throw new UnexpectedException(EntityUtils.toString(response
					.getEntity()));
		}
	}

	public static Customer get(String code) throws UnexpectedException, ParseException, IOException {
		HttpGet httpget = new HttpGet(API_URL + code);
		httpget.setHeader(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
		httpget.setHeader(new BasicHeader("Accept", "application/json"));

		HttpResponse response = client.execute(httpget);

		if (response.getStatusLine().getStatusCode() == 200) {
			return gson.fromJson(EntityUtils.toString(response.getEntity()),
					Customer.class);
		} else {
			throw new UnexpectedException(EntityUtils.toString(response
					.getEntity()));
		}

	}

	public static boolean delete(String code) throws UnexpectedException, ParseException, IOException {
		HttpDelete httppost = new HttpDelete(API_URL + code);
		httppost.setHeader(new BasicHeader(HTTP.CONTENT_TYPE,
				"application/json"));
		httppost.setHeader(new BasicHeader("Accept", "application/json"));

		HttpResponse response = client.execute(httppost);

		if (response.getStatusLine().getStatusCode() == 200) {
			return true;
		} else {
			throw new UnexpectedException(EntityUtils.toString(response
					.getEntity()));
		}
	}

	public static List<Customer> fetchAllCustomers() throws UnexpectedException, ParseException, IOException {
		HttpGet httpget = new HttpGet(API_URL);
		httpget.setHeader(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
		httpget.setHeader(new BasicHeader("Accept", "application/json"));

		HttpResponse response = client.execute(httpget);

		if (response.getStatusLine().getStatusCode() == 200) {
			return gson.fromJson(EntityUtils.toString(response.getEntity()),
					new TypeToken<List<Customer>>() {
					}.getType());
		} else {
			throw new UnexpectedException(EntityUtils.toString(response
					.getEntity()));
		}
	}
}
