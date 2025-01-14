create table kolanot_InvoicePayment (
	invoicePaymentId LONG not null primary key,
	transactionid VARCHAR(75) null,
	invoiceId LONG
);

create table kolanot_KolanotInvoice (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	invoiceId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createdByAccountId LONG,
	commerceOrderId LONG,
	accountExternalReferenceCode VARCHAR(75) null,
	referenceNo VARCHAR(75) null,
	createdBy VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	transactionId VARCHAR(75) null,
	documentNumber VARCHAR(75) null,
	documentStatus VARCHAR(75) null,
	documentDate DATE null,
	dueDate DATE null,
	carrier VARCHAR(75) null,
	trackingNumber VARCHAR(75) null,
	subTotal DECIMAL(30, 16) null,
	freightAmount DECIMAL(30, 16) null,
	gst DECIMAL(30, 16) null,
	invoiceTotal DECIMAL(30, 16) null,
	balanceDue DECIMAL(30, 16) null,
	trackingURL VARCHAR(75) null,
	status INTEGER,
	paidSum DECIMAL(30, 16) null,
	fileEntryId LONG,
	billingAddressId LONG,
	shippingAddressId LONG
);

create table kolanot_KolanotInvoiceLine (
	uuid_ VARCHAR(75) null,
	invoiceLineId LONG not null primary key,
	groupId LONG,
	invoiceId LONG,
	companyId LONG,
	lineNum INTEGER,
	itemCode VARCHAR(75) null,
	itemName VARCHAR(75) null,
	quantity INTEGER,
	price DECIMAL(30, 16) null,
	discountPercent DECIMAL(30, 16) null,
	lineTotal DECIMAL(30, 16) null,
	salesOrderID VARCHAR(75) null,
	salesOrderDocNum VARCHAR(75) null,
	salesOrderLineNum INTEGER,
	salesOrderQty INTEGER
);