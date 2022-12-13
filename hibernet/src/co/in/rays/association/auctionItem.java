package co.in.rays.association;

import java.util.Set;

public class auctionItem {
	private int id;
	 private String description;
	 private Set<bid> bids;
	 
 public auctionItem() {
	
	}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Set<bid> getBids() {
	return bids;
}
public void setBids(Set<bid> bids) {
	this.bids = bids;
}

}
