package classesMétiers;

public class Order {
	
	public Integer idOrder;
	public String dateOrder;
	public String timeOrder;
	public Float totalPrice;
	public Integer deliveredOrder;
	/**
	 * 
	 */
	public Order() {
	
	}
	/**
	 * 
	 */
	public Order(Order o) {
		this.idOrder = o.idOrder;
		this.dateOrder = o.dateOrder;
		this.timeOrder = o.timeOrder;
		this.totalPrice = o.totalPrice;
		this.deliveredOrder = o.deliveredOrder;
	}
	/**
	 * @param idOrder
	 * @param dateOrder
	 * @param timeOrder
	 * @param totalPrice
	 * @param deliveredOrder
	 */
	public Order(Integer idOrder, String dateOrder, String timeOrder, Float totalPrice, Integer deliveredOrder) {
		super();
		this.idOrder = idOrder;
		this.dateOrder = dateOrder;
		this.timeOrder = timeOrder;
		this.totalPrice = totalPrice;
		this.deliveredOrder = deliveredOrder;
	}
	
	public Integer getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}
	public String getDateOrder() {
		return dateOrder;
	}
	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}
	public String getTimeOrder() {
		return timeOrder;
	}
	public void setTimeOrder(String timeOrder) {
		this.timeOrder = timeOrder;
	}
	public Float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getDeliveredOrder() {
		return deliveredOrder;
	}
	public void setDeliveredOrder(Integer deliveredOrder) {
		this.deliveredOrder = deliveredOrder;
	}
	
	

	
}
