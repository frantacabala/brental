/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.protocol;

import org.lib.brental.protocol.entity.GetAuta;
import org.lib.brental.protocol.entity.CreateAuto;
import org.lib.brental.protocol.entity.Auta;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author john
 */
public class JAXBUtils {

    private static final Logger logger = Logger.getLogger(JAXBUtils.class.getName());

    public JAXBContext createJAXBContext() throws JAXBException {
        return JAXBContext.newInstance(
                GetAuta.class,
                Auta.class,
                Disconnect.class,
                Ok.class,
                CreateAuto.class
                );

    }
    
    
     public static void marshallMessage(Object message, Marshaller marshaller,
            DataOutputStream dos) throws JAXBException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        marshaller.marshal(message, baos);
        byte[] buff = baos.toByteArray();
        logger.log(Level.INFO, "marshalled message: {0}", new String(buff, StandardCharsets.UTF_8));
        dos.writeInt(buff.length);
        dos.write(buff);
        dos.flush();
    }

    public static Object unmarshalMessage(Unmarshaller u, DataInputStream dis)
            throws IOException, JAXBException {
        int len = dis.readInt();
        byte[] buff = new byte[len];
        dis.readFully(buff);
        logger.log(Level.INFO, "unmarshalled message: {0}", new String(buff, StandardCharsets.UTF_8));
        return u.unmarshal(new ByteArrayInputStream(buff));
    }
    
}
