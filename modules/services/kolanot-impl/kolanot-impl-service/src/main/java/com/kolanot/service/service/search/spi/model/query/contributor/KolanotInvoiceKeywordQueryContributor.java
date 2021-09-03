package com.kolanot.service.service.search.spi.model.query.contributor;

import com.kolanot.service.search.constants.InvoiceSearchFields;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
*
* @author Vy Bui
*
*/
@Component(
	immediate = true,
	property = "indexer.class.name=com.kolanot.service.model.KolanotInvoice",
	service = KeywordQueryContributor.class
)
public class KolanotInvoiceKeywordQueryContributor implements KeywordQueryContributor {

	@Override
	public void contribute(String keywords, BooleanQuery booleanQuery,
			KeywordQueryContributorHelper keywordQueryContributorHelper) {

		SearchContext searchContext =
				keywordQueryContributorHelper.getSearchContext();

			queryHelper.addSearchTerm(
				booleanQuery, searchContext, Field.GROUP_ID, false);
			queryHelper.addSearchTerm(
				booleanQuery, searchContext,
				InvoiceSearchFields.FIELD_CREATED_BY_ACCOUNT_ID, true);
			queryHelper.addSearchTerm(
				booleanQuery, searchContext, InvoiceSearchFields.FIELD_INVOICE_ID,
				true);
//			queryHelper.addSearchTerm(
//				booleanQuery, searchContext,
//				InvoiceSearchFields.FIELD_TRACKING_NUMBER, true);
//			queryHelper.addSearchTerm(
//				booleanQuery, searchContext, InvoiceSearchFields.FIELD_CARRIER,
//				true);
//			queryHelper.addSearchTerm(
//				booleanQuery, searchContext,
//				InvoiceSearchFields.DOCUMENT_NUMBER, true);
//			queryHelper.addSearchTerm(
//				booleanQuery, searchContext,
//				InvoiceSearchFields.ACCOUNT_EXTERNAL_REFERENCE_CODE, true);
//			queryHelper.addSearchTerm(
//					booleanQuery, searchContext,
//					InvoiceSearchFields.DUE_DATE, true);
//			queryHelper.addSearchTerm(
//					booleanQuery, searchContext,
//					InvoiceSearchFields.DOCUMENT_DATE, true);
		
	}

	@Reference
	protected QueryHelper queryHelper;
}
