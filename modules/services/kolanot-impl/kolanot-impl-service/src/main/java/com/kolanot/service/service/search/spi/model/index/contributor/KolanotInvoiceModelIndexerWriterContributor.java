package com.kolanot.service.service.search.spi.model.index.contributor;

import com.kolanot.service.model.KolanotInvoice;
import com.kolanot.service.service.KolanotInvoiceLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

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
	service = ModelIndexerWriterContributor.class
)
public class KolanotInvoiceModelIndexerWriterContributor implements ModelIndexerWriterContributor<KolanotInvoice> {

	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable,
			ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

		batchIndexingActionable.setPerformActionMethod((KolanotInvoice invoice) -> {
			Document document = modelIndexerWriterDocumentHelper.getDocument(invoice);

			batchIndexingActionable.addDocuments(document);
		});
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory.
				getBatchIndexingActionable(
					_kolanotInvoiceLocalService.
						getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(KolanotInvoice baseModel) {
		return baseModel.getCompanyId();
	}

	@Override
	public IndexerWriterMode getIndexerWriterMode(
		KolanotInvoice baseModel) {

		return IndexerWriterMode.UPDATE;
	}

	@Reference
	private DynamicQueryBatchIndexingActionableFactory
		_dynamicQueryBatchIndexingActionableFactory;

	@Reference
	private KolanotInvoiceLocalService
		_kolanotInvoiceLocalService;
}
