package it.scp.tests.accounts.entities;

public class Transaction extends Account {

  public Integer id;

  public Float amount;

  public String type;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Float getAmount() {
	return amount;
}

public void setAmount(Float amount) {
	this.amount = amount;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

   


}