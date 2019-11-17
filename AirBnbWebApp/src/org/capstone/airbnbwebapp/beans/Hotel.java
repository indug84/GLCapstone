package org.capstone.airbnbwebapp.beans;

public class Hotel {

	private String code;
	   private String name;
	   private String area;
		private String city;
		private String state;
		private String country;
		private float price;
		private String zip;
		private String pin;
	 
	   public Hotel() {
	 
	   }
	 
	   public Hotel(String code, String name, String area, String city, String state, String country, float price, String zip, String pin) {
	       this.code = code;
	       this.name = name;
			this.area = area;
			this.city = city;
			this.state = state;
			this.country = country;
			this.price = price;
			this.zip = zip;
			this.pin = pin;
	   }
	 
	   public String getCode() {
	       return code;
	   }
	 
	   public void setCode(String code) {
	       this.code = code;
	   }
	 
	   public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getcity() {
			return city;
		}

		public void setcity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}

		public String getPin() {
			return pin;
		}

		public void setPin(String pin) {
			this.pin = pin;
		}

		public String getArea() {
			return area;
		}

		public void setArea(String area) {
			this.area = area;
		}
	 
	   public float getPrice() {
	       return price;
	   }
	 
	   public void setPrice(float price) {
	       this.price = price;
	   }
}
