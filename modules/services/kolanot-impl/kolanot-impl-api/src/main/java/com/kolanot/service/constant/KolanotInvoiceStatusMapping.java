package com.kolanot.service.constant;

import java.util.HashMap;
import java.util.Map;

public enum KolanotInvoiceStatusMapping {
	CLOSED("closed", 0), OPEN("open", 1), PAID("partialPaid", 2), CANCELLED("cancelled", 3);

	public final String statusName;
	public final int statusNumber;

	private static final Map<String, KolanotInvoiceStatusMapping> BY_STATUS_NAME = new HashMap<>();

	static {
		for (KolanotInvoiceStatusMapping status : values()) {
			BY_STATUS_NAME.put(status.statusName, status);
		}
    }

	public static int getStatusNumberByName(String documentStatus) {
		KolanotInvoiceStatusMapping selectedStatus = valueOfStatusName(documentStatus);

		if (selectedStatus != null) return selectedStatus.statusNumber;
		
		throw new IllegalArgumentException("Could not find any invoice status with documentStatus: " + documentStatus);
	}

	private KolanotInvoiceStatusMapping(String _statusName, int _statusNumber) {
		this.statusName = _statusName;
		this.statusNumber = _statusNumber;
    }

	private static KolanotInvoiceStatusMapping valueOfStatusName(String name) {
		return BY_STATUS_NAME.get(name.toLowerCase());
    }
}
