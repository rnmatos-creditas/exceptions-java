package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.ProductOrderStatus;

public class ProductOrder {

	private Date moment;
	private ProductOrderStatus status;
	private List<OrderItem> items = new ArrayList<>();
	
	public ProductOrder() {
		
	}

	public ProductOrder(Date moment, ProductOrderStatus status) {
		this.moment = moment;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public ProductOrderStatus getStatus() {
		return status;
	}

	public void setStatus(ProductOrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem orderItem) {
		items.add(orderItem);
	}
	
	public void removeItem(OrderItem orderItem) {
		items.remove(orderItem);
	}
	
	public Double total() {
		Double total = 0.0;
		
		for (OrderItem oi : items) {
			total += oi.subTotal();
		}
		
		return total;
	}
	
}
