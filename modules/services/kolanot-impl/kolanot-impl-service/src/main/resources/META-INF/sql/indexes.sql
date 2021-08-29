create index IX_CF57C8F2 on kolanot_KolanotInvoice (accountExternalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_50C8C273 on kolanot_KolanotInvoice (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_5D5A7E9B on kolanot_KolanotInvoice (createdByAccountId);
create index IX_294C0452 on kolanot_KolanotInvoice (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_404D7754 on kolanot_KolanotInvoice (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_88C9E6A6 on kolanot_KolanotInvoiceLine (invoiceId);
create index IX_A4498A66 on kolanot_KolanotInvoiceLine (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3F5D7268 on kolanot_KolanotInvoiceLine (uuid_[$COLUMN_LENGTH:75$], groupId);