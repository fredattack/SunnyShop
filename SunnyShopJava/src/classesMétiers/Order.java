package classesMétiers;

public class Order {
	
	

	public Integer idOrder;
	public String dateOrder;
	public String timeOrder;
	public Float totalPrice;
	public String deliveredOrder;
	public Integer idUserOrder;

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
		this.totalPrice = o.totalPrice;
		this.deliveredOrder = o.deliveredOrder;
		this.idUserOrder = o.idUserOrder;
		this.timeOrder = o.timeOrder;
	}
	/**
	 * @param idOrder
	 * @param dateOrder
	 * @param totalPrice
	 * @param deliveredOrder
	 * @param timeOrder
	 * 
	 */
	public Order(Integer idOrder, String dateOrder, Float totalPrice, String deliveredOrder,Integer idUserOrder, String timeOrder) {
		super();
		this.idOrder = idOrder;
		this.dateOrder = dateOrder;
		this.timeOrder = timeOrder;
		this.totalPrice = totalPrice;
		this.deliveredOrder = deliveredOrder;
		this.idUserOrder =idUserOrder;
	}
	
	/**
	 * @param idOrder
	 * @param dateOrder
	 * @param timeOrder
	 * @param totalPrice
	 * @param deliveredOrder
	 */
	public Order(Integer idOrder, String dateOrder, String timeOrder, Float totalPrice, String deliveredOrder) {
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
	public String getDeliveredOrder() {
		return deliveredOrder;
	}
	public void setDeliveredOrder(String deliveredOrder) {
		this.deliveredOrder = deliveredOrder;
	}
	public Integer getIdUserOrder() {
		return idUserOrder;
	}
	public void setIdUserOrder(Integer idUserOrder) {
		this.idUserOrder = idUserOrder;
	}
	
	
	

	
}
