package com.kolanot.service.service.search;

import com.kolanot.service.model.KolanotInvoice;
import com.kolanot.service.search.constants.InvoiceSearchFields;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate=true)
public class KolanotInvoiceSearchRegistrar {
	@Activate
	protected void activate(BundleContext bundleContext) {

		_serviceRegistration = modelSearchRegistrarHelper.register(
			KolanotInvoice.class, bundleContext, modelSearchDefinition -> {
				modelSearchDefinition.setDefaultSelectedFieldNames(
					Field.COMPANY_ID, Field.ENTRY_CLASS_NAME,
					Field.ENTRY_CLASS_PK, Field.GROUP_ID, Field.SCOPE_GROUP_ID,
					Field.STATUS, Field.UID,
					InvoiceSearchFields.FIELD_CREATED_BY_ACCOUNT_ID,
					InvoiceSearchFields.FIELD_INVOICE_ID);

				modelSearchDefinition.setDefaultSelectedLocalizedFieldNames(
					Field.TITLE, Field.CONTENT);

				modelSearchDefinition.setModelIndexWriteContributor(
					modelIndexWriterContributor);
				modelSearchDefinition.setModelSummaryContributor(
					modelSummaryContributor);
				modelSearchDefinition.setSelectAllLocales(true);

			});
	}

	@Deactivate
	protected void deactivate() {
		_serviceRegistration.unregister();
	}

	@Reference(target = "(indexer.class.name=com.kolanot.service.model.KolanotInvoice)")
	protected ModelIndexerWriterContributor<KolanotInvoice> modelIndexWriterContributor;

	@Reference
	protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

	@Reference(target = "(indexer.class.name=com.kolanot.service.model.KolanotInvoice)")
	protected ModelSummaryContributor modelSummaryContributor;

	private ServiceRegistration<?> _serviceRegistration;
}
