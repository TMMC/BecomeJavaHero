package pl.edu.bogdan.training.solid.exercise1;

import java.util.List;



public class ReportGenerator {
	static class ReportItem {
		private String itemName;
		private int itemAmount;
		private double itemPrice;
		public ReportItem(String itemName, int itemAmount, double itemPrice) {
			super();
			this.itemName = itemName;
			this.itemAmount = itemAmount;
			this.itemPrice = itemPrice;
		}
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		public int getItemAmount() {
			return itemAmount;
		}
		public void setItemAmount(int itemAmount) {
			this.itemAmount = itemAmount;
		}
		public double getItemPrice() {
			return itemPrice;
		}
		public void setItemPrice(double itemPrice) {
			this.itemPrice = itemPrice;
		}
	}
	public static String generateReport(List<ReportItem> items) {
		StringBuilder result = new StringBuilder();
		result.append("Name;Amount;Price;Cost").append(System.lineSeparator());
		for (ReportItem item : items) {
			result.append(item.getItemName()).append(";")
				.append(item.getItemAmount()).append(";")
				.append(item.getItemPrice()).append(";")
				.append(item.getItemAmount()*item.getItemPrice())
				.append(System.lineSeparator());
		}
		return result.toString();
	}
}
