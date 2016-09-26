package ulusoy.at.wicket.service.impl;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import ulusoy.at.wicket.entity.BestellteArtikel;
import ulusoy.at.wicket.entity.Bestellung;
import ulusoy.at.wicket.service.DocumentService;



@Named
public class DocumentServiceImpl implements DocumentService {
    private static final Log LOGGER = LogFactory.getLog(DocumentServiceImpl.class);

    @Override
    public File printBestellungToDocx(final Bestellung bestellung) {
        final Map<String, Object> contextMap = new HashMap<String, Object>();
        contextMap.put("bestellung", bestellung);
        String fileName="Bestellungen"  + " no" + bestellung.getId() +"__";
        return mergeTemplate("BestellungTemplate.docx", fileName, contextMap);
    }


    public File mergeTemplate(final String template, final String fileName, final Map<String, Object> contextVariables) {
        ByteArrayOutputStream baos = null;
        try {
            final InputStream in = DocumentServiceImpl.class.getResourceAsStream(template);
            if (in == null) {
                LOGGER.error("Template not found");
            }

            final IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Freemarker);

            final IContext context = report.createContext();

            context.putMap(contextVariables);

            final Date todayDate = new Date();
            final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            final String today = dateFormat.format(todayDate);
            context.put("today", today);

            baos = new ByteArrayOutputStream();
            report.process(context, baos);

            return printToDocx(fileName, baos);

        } catch (final IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (final XDocReportException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                baos.close();
            } catch (final IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private File printToDocx(final String fileName, final ByteArrayOutputStream downloadLinkBaos) {
        LOGGER.debug("print bestellung");

        File tempDocument;
        final InputStream downloadLinkIs = new ByteArrayInputStream(downloadLinkBaos.toByteArray());

        try {
            tempDocument = File.createTempFile(fileName, ".docx");
            IOUtils.copy(downloadLinkIs, new FileOutputStream(tempDocument));

        } catch (final IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        } finally {
            try {
                downloadLinkIs.close();
                downloadLinkBaos.close();
            } catch (final IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        return tempDocument;
    }


	@Override
	public File printEinkaufListe(List<BestellteArtikel> einkaufsliste) {
		final Map<String, Object> contextMap = new HashMap<String, Object>();
        contextMap.put("einkauf", einkaufsliste);
        return mergeTemplate("EinkaufListeTemplate.docx", "Einkauf", contextMap);

	}


	@Override
	public File printBestellungListToDocx(List<Bestellung> bestellung) {
		final Map<String, Object> contextMap = new HashMap<String, Object>();
        contextMap.put("bestellungen", bestellung);
        return mergeTemplate("BestellungListTemplate.docx", "Bestellungen", contextMap);

	}




}
