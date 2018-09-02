package com.weather.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XMLParseUtils {

    public static Object xmlParse(Class<?> clazz, String xmlStr) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader stringReader = new StringReader(xmlStr);
        Object unmarshal = unmarshaller.unmarshal(stringReader);
        if (stringReader != null){
            stringReader.close();
        }
        return unmarshal;
    }

}
