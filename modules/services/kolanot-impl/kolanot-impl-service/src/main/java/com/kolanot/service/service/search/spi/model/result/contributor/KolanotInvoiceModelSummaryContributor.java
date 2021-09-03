package com.kolanot.service.service.search.spi.model.result.contributor;

import com.kolanot.service.search.constants.InvoiceSearchFields;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
*
* @author Vy Bui
*
*/
@Component(
	immediate = true,
	property = "indexer.class.name=com.kolanot.service.model.KolanotInvoice",
	service = ModelSummaryContributor.class
)
public class KolanotInvoiceModelSummaryContributor implements ModelSummaryContributor {

	@Override
	public Summary getSummary(Document document, Locale locale, String snippet) {

			Summary summary = createSummary(document);

			summary.setMaxContentLength(200);

			return summary;
	}

	private Summary createSummary(Document document) {
		String prefix = Field.SNIPPET + StringPool.UNDERLINE;

		String createBy = document.get(
			prefix + InvoiceSearchFields.FIELD_CREATED_BY,
			InvoiceSearchFields.FIELD_CREATED_BY);
		String createByAccountId = document.get(
			prefix + InvoiceSearchFields.FIELD_CREATED_BY_ACCOUNT_ID,
			InvoiceSearchFields.FIELD_CREATED_BY_ACCOUNT_ID);

		return new Summary(createBy, createByAccountId);
	}
}
