package br.com.cassandraconverter.utils;

import com.lowagie.text.DocumentException;

import java.io.IOException;
import java.io.OutputStream;

public interface IPDFGenerator {

    public void generate(OutputStream stream) throws DocumentException, IOException;
}
