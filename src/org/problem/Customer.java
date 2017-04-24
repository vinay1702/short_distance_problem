package org.problem;

public class Customer {
		private long user_id;
	    private String name;
	    private double latitude;
	    private double longitude;


	    public Double getLongitude() {
	        return longitude;
	    }

	    public void setLongitude(String longitude) {
	        this.longitude = Double.parseDouble(longitude);
	    }

	    public Double getLatitude() {
	        return latitude;
	    }

	    public void setLatitude(String latitude) {
	        this.latitude = Double.parseDouble(latitude);
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public long getUser_id() {
	        return user_id;
	    }

	    public void setUser_id(long user_id) {
	        this.user_id = user_id;
	    }

	  /*  @Override
	    public String toString() {
	        String separator = " - ";
	        StringBuilder builder = new StringBuilder();
	        builder.append("Id: " + getUser_id());
	        builder.append(separator);
	        builder.append("Name: " + getName());
	        builder.append(separator);
	        builder.append("latitude " + getLatitude());
	        builder.append(separator);
	        builder.append("longitude " + getLongitude());

	        return builder.toString();
	    }*/
}
