package com.kolanot.service.service.search.spi.model.index.contributor;

import com.kolanot.service.model.KolanotInvoice;
import com.kolanot.service.search.constants.InvoiceSearchFields;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import java.text.Format;
import java.util.Locale;
import java.util.TimeZone;

import org.osgi.service.component.annotations.Component;

/**
*
* @author Vy Bui
*
*/
@Component(
	immediate = true,
	property = "indexer.class.name=com.kolanot.service.model.KolanotInvoice",
	service = ModelDocumentContributor.class
)
public class KolanotInvoiceModelDocumentContributor implements ModelDocumentContributor<KolanotInvoice>  {

	@Override
	public void contribute(Document document, KolanotInvoice invoice) {
		try {
			document.addDate(Field.MODIFIED_DATE, invoice.getModifiedDate());
			document.addKeyword(
				InvoiceSearchFields.FIELD_INVOICE_ID, invoice.getInvoiceId());
			document.addKeyword(Field.GROUP_ID, invoice.getGroupId());
			document.addNumberSortable(Field.STATUS, invoice.getStatus());
				document.addKeyword(Field.ENTRY_CLASS_PK, invoice.getInvoiceId());
			document.addKeywordSortable(
				InvoiceSearchFields.DOCUMENT_STATUS,
				String.valueOf(invoice.getDocumentStatus()));
			document.addKeywordSortable(
				InvoiceSearchFields.DOCUMENT_DATE,
				String.valueOf(invoice.getDocumentDate()));
			document.addKeywordSortable(
				InvoiceSearchFields.FIELD_CREATED_BY,
				String.valueOf(invoice.getCreatedBy()));
			document.addKeywordSortable(
					InvoiceSearchFields.FIELD_CREATED_BY,
					String.valueOf(invoice.getCreatedBy()));
			document.addKeywordSortable(
				InvoiceSearchFields.BALANCE_DUE,
				String.valueOf(invoice.getBalanceDue()));
//			document.addKeywordSortable(
//				InvoiceSearchFields.DOCUMENT_NUMBER,
//				invoice.getDocumentNumber());
//			document.addKeywordSortable(
//				InvoiceSearchFields.ACCOUNT_EXTERNAL_REFERENCE_CODE,
//				invoice.getAccountExternalReferenceCode());

//			Locale locale = LocaleThreadLocal.getDefaultLocale();
//			TimeZone timeZone = TimeZoneUtil.getDefault();
//
//			Format dateFormatDateTime = FastDateFormatFactoryUtil.getSimpleDateFormat("MMM dd, yyyy", locale, timeZone);
//			document.addKeywordSortable(InvoiceSearchFields.DUE_DATE, dateFormatDateTime.format(invoice.getDueDate()));
//			document.addKeywordSortable(InvoiceSearchFields.DOCUMENT_DATE, dateFormatDateTime.format(invoice.getDocumentDate()));
		}
		catch (Exception pe) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to index invoice " + invoice.getInvoiceId(), pe);
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
			KolanotInvoiceModelDocumentContributor.class);
}
