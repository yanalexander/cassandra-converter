package br.com.cassandraconverter.utils;

import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.IOException;
import java.io.OutputStream;

public class FlyingSaucerPDFGenerator implements IPDFGenerator{

    private String htmlTemplate;

    public FlyingSaucerPDFGenerator() {
    }

    public FlyingSaucerPDFGenerator(String htmlTemplate) {
        this.htmlTemplate = htmlTemplate;
    }

    public String getHtmlTemplate() {
        return htmlTemplate;
    }

    public void setHtmlTemplate(String htmlTemplate) {
        this.htmlTemplate = htmlTemplate;
    }

    @Override
    public void generate(OutputStream stream) throws DocumentException, IOException {
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlTemplate);
        renderer.layout();
        renderer.createPDF(stream);
        stream.close();
    }
}
