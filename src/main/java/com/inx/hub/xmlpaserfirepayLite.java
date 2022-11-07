package com.inx.hub;

/**
 * @Author huangjinping1000@163.com
 * @Description
 * @Date 4/29/22
 **/


import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.xpath.DefaultXPath;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class xmlpaserfirepayLite {

    private static final String unit = "east_t_";

    public static void main(String[] args) {
//        e4bc2a19ff4fba5db96b80be17791e54
//  eastbay      776c4d7810111d848e6bd0393060c80a
        try {
            List<Map<String, String>> strings = parseMethod1();
            generate(strings, "xml/stringsResult.xml", "776c4d7810111d848e6bd0393060c80a");

        } catch (Exception e) {
            e.printStackTrace();
        }







        String value = "<html><body><div><h3><span style=\\\"font-family:Arial; font-size:14pt; font-weight:bold\\\">1. INFORMACIÓN PERSONAL QUE RECOPILAMOS</span></h3><span style=\\\"font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;Recopilamos cierta información personal sobre usted. La información personal que recopilamos puede ser proporcionada por usted directamente (por ejemplo, cuando abre una Cuenta para usar el Servicio a través de la aplicación, o nos proporciona información personal) o por terceros, o puede ser recopilada automáticamente cuando utiliza el App. Podemos recopilar información en diversas formas y para diversos fines (incluidos los fines permitidos por la Ley Aplicable).</span><h3><span style=\\\"font-family:Arial; font-size:14pt; font-weight:bold\\\">2. Información obtenida de usted o de su dispositivo móvil directamente:</span></h3><span style=\\\"font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;Cuando se registra y crea una Cuenta con nosotros utilizando la aplicación, debe proporcionarnos cierta información personal, incluido su nombre, identificación nacional, fecha de nacimiento, sexo, antecedentes educativos, religión, fotografía, dirección física, correo electrónico dirección, información de trabajo, estado civil, contacto de emergencia, su número de teléfono, detalles de la tarjeta SIM, información financiera y crediticia (incluidos los detalles de su cuenta de dinero móvil, detalles de la cuenta bancaria y número de verificación bancaria, cuando corresponda) y una identificación de cuenta y / o contraseña que usará para acceder a la aplicación después del registro.</span><h3><span style=\\\"font-family:Arial; font-size:14pt; font-weight:bold\\\">a.SMS</span></h3><span style=\\\"font-family:Arial; font-size:11pt\\\">Recopilar y monitorear los SMS financieros y no personales para los detalles transaccionales de los montos, servirá para calcular la eligibilidad y evaluar el riesgo de cliente. Otros SMS no los evaluará, verificamos y rastreamos las transacciones financieras de los usuarios en el backend mediante el análisis de sus SMS para tomar una decisión inteligente sobre la línea de crédito basada en la evaluación de su presupuesto de gastos y capacidad de pago. <p><span style=\\\"font-family:Arial; font-size:11pt\\\">La información de contacto se cargará en el servidor (https://www.glbyeastbay.com/) y no se compartirá con ningún tercero.</span><p>  </span><h3><span style=\\\"font-family:Arial; font-size:14pt; font-weight:bold\\\">b.Contacts</span></h3><span style=\\\"font-family:Arial; font-size:11pt\\\">Permite que la APP obtenga permiso de acceder a tus contactos para detectar referencias y poder completar automáticamente el proceso de solicitud del préstamo. Recopilar información de los contactos sirve para evaluar su riesgo y puntuaje crediticio, como parte de nuestro proceso de préstamo, requerimos referencias del solicitante del préstamo. En este sentido, durante la presentación del formulario en nuestra aplicación, recopilamos su información de contacto para detectar contactos cercanos que le permitan completar automáticamente los datos durante el proceso de solicitud de préstamo.<p><span style=\\\"font-family:Arial; font-size:11pt\\\">La información de contacto se cargará en el servidor (https://www.glbyeastbay.com/) y no se compartirá con ningún tercero.</span><p>  </span><h3><span style=\\\"font-family:Arial; font-size:14pt; font-weight:bold\\\">c.Cámara y fotos</span></h3><span style=\\\"font-family:Arial; font-size:11pt\\\">Permítanos capturar las imágenes de su documento e imágenes para la solicitud de préstamo.</span><h3><span style=\\\"font-family:Arial; font-size:14pt; font-weight:bold\\\">d.Ubicación</span></h3><span style=\\\"font-family:Arial; font-size:11pt\\\">La ubicación del usuario ayuda a encontrar y verificar direcciones, lo que ayuda a tomar mejores decisiones de riesgo crediticio y acelera el proceso de \\\"conocer a su cliente\\\" (KYC).</span><h3><span style=\\\"font-family:Arial; font-size:14pt; font-weight:bold\\\">e.Equipo</span></h3><span style=\\\"font-family:Arial; font-size:11pt\\\">Permítanos recopilar y monitorear la información relevante del hardware de su equipo para establecer su identidad.</span><h3><span style=\\\"font-family:Arial; font-size:14pt; font-weight:bold\\\">f.Estado del teléfono</span></h3><span style=\\\"font-family:Arial; font-size:11pt\\\">El estado del teléfono solo se usa para registrar y ver información específica. La información proporcionada por el usuario puede ayudarnos a ver mejor cualquier operación no autorizada en este dispositivo, ya que esto nos permitirá detectar mejor el fraude y los riesgos potenciales.</span><h3><span style=\\\"font-family:Arial; font-size:14pt; font-weight:bold\\\">g.Calendario</span></h3><span style=\\\"font-family:Arial; font-size:11pt\\\">Se usa para recordarle la fecha de pago para evitar el impacto del pago vencido en su crédito.</span><h3><span style=\\\"font-family:Arial; font-size:14pt; font-weight:bold\\\">h.Almacenamiento de archivos</span></h3><span style=\\\"font-family:Arial; font-size:11pt\\\">Este permiso es necesario para que los estados de cuenta de préstamos de los usuarios se puedan descargar y guardar de forma segura en el teléfono de los usuarios, y para que el usuario pueda cargar los documentos correctos para una aprobación y desembolso más rápidos del préstamo. Además, esto ayuda a proporcionar una experiencia fluida y fluida al usar la aplicación.</span><h3><span style=\\\"font-family:Arial; font-size:14pt; font-weight:bold\\\">i.Lista de aplicaciones</span></h3><span style=\\\"font-family:Arial; font-size:11pt\\\">Recopilamos la información de metadatos de cada aplicación insgua_cashada, como el nombre de la aplicación, el nombre del paquete, la hora de insgua_cashación, la hora de actualización en su dispositivo para mejorar su evaluación crediticia y crear ofertas personalizadas.</span><h3><span style=\\\"font-family:Arial; font-size:14pt; font-weight:bold\\\">j.Registros de llamadas </span></h3><span style=\\\"font-family:Arial; font-size:11pt\\\">Escanearemos y cargaremos la información del registro de llamadas utilizando el protocolo de transferencia de datos más seguro. La información del registro de llamadas solo se utiliza en el proceso de revisión de crédito y no se compartirá con organizaciones de terceros sin su permiso. <p><span style=\\\"font-family:Arial; font-size:11pt\\\">La información de contacto se cargará en el servidor (https://www.glbyeastbay.com/) y no se compartirá con ningún tercero.</span><p> </span><h3><span style=\\\"font-family:Arial; font-size:14pt; font-weight:bold\\\">3. EL USO DE INFORMACIÓN PERSONAL RECOPILADA</span></h3><span style=\\\"font-family:Arial; font-size:11pt\\\">Podemos utilizar la información personal recopilada para cualquiera de los siguientes propósitos, así como para otros fines permitidos por la ley aplicable:</span><h3><span style=\\\"font-family:Arial; font-size:14pt; font-weight:bold\\\">Podemos usar su información personal:</span></h3><p><span style=\\\"font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;•&nbsp;para identificarlo y registrarlo como usuario y para administrar, o verificar su Cuenta como tal;</span></p><p><span style=\\\" font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;•&nbsp;para facilitar o habilitar cualquier verificación que podamos, según nuestro criterio, consideremos necesario antes de que lo registremos como usuario;</span></p><p><span style=\\\"font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;•&nbsp;desembolsar el préstamo y cobrar pagos por su uso del Servicio;</span></p><p><span style=\\\" font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;•&nbsp;para construir modelos de crédito y realizar una calificación crediticia;</span></p><p><span style=\\\" font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;•&nbsp;para cumplir con las leyes, regulaciones y normas aplicables, como las relacionadas con los requisitos de KYC (conocer a su cliente, ¨Know Your Customer¨ en inglés) y anti-lavado de dinero;</span></p><p><span style=\\\" font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;•&nbsp;para comunicarse con usted y enviarle información relacionada con el uso de la aplicación;</span></p><p><span style=\\\" font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;•&nbsp;para notificarle sobre cualquier actualización de la Aplicación o cambios en el Servicio (incluida la tasa de interés, las Tarifas de transacción, etc.) disponibles;</span></p><p><span style=\\\" font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;•&nbsp;para procesar y responder las consultas y comentarios recibidos de usted;</span></p><p><span style=\\\" font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;•&nbsp;para mantener, desarrollar, probar, mejorar y personalizar la aplicación para satisfacer sus necesidades y preferencias como usuario;</span></p><p><span style=\\\" font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;•&nbsp;ponerse en contacto con usted por teléfono mediante llamadas de mensajes marcados automáticamente o pregrabados o mensajes de texto (SMS) (si corresponde) según lo autorizado para los fines descritos en esta Política de Privacidad y los Términos de Uso;</span></p><p><span style=\\\"font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;•&nbsp;para monitorear y analizar las actividades de los usuarios y los datos demográficos, incluidas las tendencias y el uso del Servicio disponible en la Aplicación;</span></p><h3><span style=\\\"font-family:Arial; font-size:14pt; font-weight:bold\\\">4. COMPARTIR INFORMACIÓN PERSONAL RECOPILADA</span></h3><span style=\\\"font-family:Arial; font-size:11pt\\\">a. Podemos divulgar o compartir con afiliados y otras partes su información personal para cualquiera de los siguientes propósitos, así como para otros fines permitidos por la Ley Aplicable (aunque en cada caso siempre actuaremos de manera razonable y no divulgaremos o compartiremos más) Información personal de lo que se requiere para el propósito particular):</span><p><span style=\\\" font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;•&nbsp;cuando sea requerido o autorizado por la Ley Aplicable (incluyendo, entre otros, responder a consultas regulatorias, investigaciones o directivas, o cumplir con los requisitos legales o reglamentarios de presentación y presentación de informes), para los fines especificados en dicha Ley Aplicable;</span></p><p><span style=\\\" font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;•&nbsp;cuando exista algún tipo de procedimiento legal entre usted y nosotros, o entre usted y otra parte, en relación con el Servicio o relacionado con él, a los fines de dicho procedimiento legal;</span></p><p><span style=\\\" font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;•&nbsp;en relación con, o durante las negociaciones de cualquier fusión, venta de activos de la empresa, consolidación o reestructuración, financiación o adquisición de todo o una parte de nuestro negocio por o en otra empresa, a los fines de dicha transacción (incluso si el la transacción eventualmente no se procede con);</span></p><p>\\t<span style=\\\" font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;•&nbsp;donde compartimos su información personal con terceros (incluidos los burós de referencia de crédito, proveedores de redes móviles, agencias de cobro ,nuestros propios agentes, proveedores, contratistas, socios y cualquier otra persona que nos brinde servicios, realice funciones en nuestro nombre o quien colaboramos con), para o en relación con los fines para los cuales están involucrados dichos terceros o los propósitos de nuestra colaboración con dichos terceros (según sea el caso), lo que puede incluir permitir que dichos terceros introduzcan u ofrezcan productos o servicios para usted u otras actividades de conducción que incluyen marketing, investigación, análisis y desarrollo de productos;</span></p><p><span style=\\\" font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;•&nbsp;cuando compartimos información personal con afiliados, solo lo haremos con el fin de que nos ayuden a proporcionar la aplicación o para operar nuestro negocio (incluido, cuando se haya suscrito a nuestra lista de correo, para fines de marketing directo) o para con el propósito de que realicen el procesamiento de datos en nuestro nombre. Por ejemplo, nuestro afiliado en otro país puede procesar y / o almacenar su información personal en nombre de la compañía de nuestro grupo en su país. Todos nuestros Afiliados se comprometen a procesar la Información personal que reciben de nosotros de acuerdo con esta Política de privacidad y la Ley aplicable;</span></p><p><span style=\\\" font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;•&nbsp;donde publicamos estadísticas relacionadas con el uso de la Aplicación y el Servicio, en cuyo caso toda la información se agregará y se hará anónima;</span></p><p><span style=\\\" font-family:Arial; font-size:11pt\\\">&nbsp;&nbsp;•&nbsp;cuando creemos de buena fe que la divulgación de su información personal es necesaria para cumplir con la ley aplicable, evitar daños físicos o pérdidas financieras, informar sospechas de actividad ilegal o investigar violaciones de nuestros Términos de Uso;</span></p><p><span style=\\\"font-family:Arial; font-size:11pt\\\">b.Cuando no sea necesario que la información personal divulgada o compartida con otras partes esté asociada con usted, haremos todos los esfuerzos razonables para eliminar los medios por los cuales la información personal puede asociarse con usted como individuo antes de divulgar o compartir dicha información.</span><p><p><span style=\\\"font-family:Arial; font-size:11pt\\\">c. No venderemos ni alquilaremos su información personal a terceros.</span><p><p><span style=\\\"font-family:Arial; font-size:11pt\\\">d.Además de lo dispuesto en esta Política de Privacidad, podemos divulgar o compartir su información personal si le notificamos esto por adelantado y hemos obtenido su consentimiento para la divulgación o el intercambio.</span><p><h3><span style=\\\"font-family:Arial; font-size:14pt; font-weight:bold\\\">5. DÓNDE ALMACENAMOS SU INFORMACIÓN PERSONAL</span></h3><p><span style=\\\"font-family:Arial; font-size:11pt\\\">a. La información de contacto se cargará en el servidor (https://www.glbyeastbay.com/) y no se compartirá con ningún tercero.</span><p><p><span style=\\\"font-family:Arial; font-size:11pt\\\">b. La información personal que recopilamos de usted puede ser almacenada, transferida o procesada por proveedores de servicios externos. Haremos todos los esfuerzos razonables para garantizar que todos los proveedores de servicios de terceros brinden un nivel de protección comparable a nuestros compromisos en virtud de esta Política de Privacidad.</span><p><p><span style=\\\"font-family:Arial; font-size:11pt\\\">c.Su información personal también puede ser almacenada o procesada fuera de su país por personal que trabaja para nosotros en otros países, o por nuestros proveedores de servicios externos, proveedores, contratistas o afiliados, en la medida permitida por la ley aplicable. En tal caso, nos aseguraremos de que dicha información personal permanezca sujeta a un nivel de protección comparable a lo requerido por las leyes de su país (y, en cualquier caso, en línea con nuestros compromisos en esta Política de privacidad).</span><p></div></body></html>";



        System.out.println(unit + AESUtil.encrypt(value, "776c4d7810111d848e6bd0393060c80a"));


        String sorce = "east_t_3be51dcec3b99270956398e8bab54f5562f311a7672023264c5b3a3d41c3d60c4011eaed7f80042048d9f1162c9f15505fbd58e5c4b86c8fe494365b286060899a6a3a3cee3930caca7d64f782c3e3959a0497be6c0036a23bc523387f00d02e15d89c0d8e445ab285f8a59258f8d5ca11ee2fe4050688e9f0e9bffffe40991142af406fbeaf669b24af9983318173e92b23cfcb21a0a73453eb6b57371aa84315287594445bcbbb66a2996019119f00c7d8a44ff53d9fa4ec8d9e8461d53844183c2ae0417883531902964e8451da9db5bfbdcb2a27a3552c4672646491576b0402c35cb57c84b3cde300f618d81b7fc340b518e49efb76d8928e0b2b4f173853c279fd62d6786bcf6f8223dff781e45b9a4471ac39d4de3ced392d3e13fa68d660e9957ec772cc24936b33b5c67152dfd75006fe27f49446be77255fc143f52f6bcac63ddf2368f847d6ca775fe7489667fd5bc25f546e97b77dac5eaa4164784357aa23c5acff3359f0c90d166aa045bd598bd454872129794904d05cde5d41e6ef8783645d7f2414c95b9bccebaf6857a5457e2c062ad7095b29c86a60eb89ac2efe4e0dbc12cd76d3f8dafa3ccb3b30e31f87e51794a552ce6c35c66cbf521ff4a9c288d09c2f3b66b19b70b2bca4a61f8fbf62451f51e1d939d87e5ea8769f3ccf425651b31e3d0d49e0efb1711ba9a01ddd3e35b3fb2d61a67a015432328793044321c26dad91ab2c7bc03fd5127756275727f6a8daae146320fb0ddbb8de470f7f22c8ba5bca010b3a608e0421ab55fa5211b8b71a923e0f76ef080b5161773c2f6014ab2af146b4dfaeecd6de9d8642e96431f8e8b50fd4f47e3450";
        sorce=  "87f892ab69b3ac6e91a01029f00ac730434fbdb947e7e02ac363d96d31a66cde1319c52988aaf8c70c0ffbd0aed2b36551e89a415e2d609381d4152f4630911ec8f285d9d9f106400e5caedee568e622d54ef6e124084c706bbd5b8e878f3248e5ae7f23fc25e2aaef2fbf4d9a008cab2f5fb74fa9bbf1c3d58342f36f3390058a702a9c90e82acb7f29c4556892fa0131ae1d1de39615c3ca84e8bbc88d9fd198789d01e0482f31e78cc1f4b1cec9ba3110f296d944914c56066af354c0b89f9066407e2f7c40e07143f28b5587aaede1ad9f1b7ddea6fceb709e8ced8d277eb12a0dae686adc593b50dc2c716b43fcd48263c98a7f634ce2ac6fa6b040e96e3d5e349ac0ab493b73cdc5258ff80dcccb4f600e2cd80392724ebe92afc6a3b633ba8512e3daf25ee4b307f30026d8561a3b031106dd855f74969d20511b5f5cf95c00fa6aae1f16e1b988eeb0c14416501f6d11c688b7b99d0e691855daf6acbe6c7d60675674e863168f1d7eb949d3d2b1f7e366138131215d1cdac2f08b142415f9c8ebc8b7e624dcfcefc3c156ba";

        try {
            System.out.println("000000000");
            System.out.println(AESUtil.decrypt(sorce, "776c4d7810111d848e6bd0393060c80a"));
            System.out.println("11111111");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }








    public static List<Map<String, String>> parseMethod1() throws DocumentException {
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();

        SAXReader reader = new SAXReader();
        Document document = reader.read("xml/strings.xml");
        XPath xPath = new DefaultXPath("/resources/string");
        List<Element> list = xPath.selectNodes(document.getRootElement());
        for (Element element : list) {
            System.out.println(element.attributeValue("name") + "======" + element.getTextTrim());
//            result.add(element.getTextTrim());
            Map<String, String> map = new HashMap<>();
            map.put(element.attributeValue("name"), element.getTextTrim());
            result.add(map);
        }
        return result;
    }


    public static String fileterValue(String value) {
        value = value.replace("\\n", "$*").replace("\\t", "$#");
        return value;
    }


    public static String reverseValue(String value) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(value);
        return buffer.reverse().toString();
    }


    public static String  insert(String value){
        String result="";
        StringBuffer buffer=new StringBuffer(value);

        result=  unit+value;

        return  result;
    }


    public static void generate(List<Map<String, String>> source, String fileName, String key) {
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("resources");
        for (Map<String, String> map : source
        ) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Element product = root.addElement("string");
                product.addAttribute("name", entry.getKey());
                String value = entry.getValue();
                if (value.contains("%s")) {
                    product.setText(value);
                } else {
                    product.setText(uRLEncoder(value));
//                    product.setText(unit + insert(entry.getValue()));

                }
            }
        }

        PrintWriter pWriter = null;
        XMLWriter xWriter = null;
        try {
            pWriter = new PrintWriter(fileName);
            xWriter = new XMLWriter(pWriter);
            xWriter.write(doc);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                xWriter.flush();
                xWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static String uRLEncoder(String source) {
        try {
            String unitEnd = "FireCreditoLite6";
            String unitStart = "FireCreditoLiteod";
            String unit_s = "vwk.1fr";
            String unit_i = "vz.2fker";
            source = source.replace("s", unit_s);
            source = source.replace("i", unit_i);

            source = URLEncoder.encode(source, "utf-8");
            StringBuilder builder = new StringBuilder();
            source = unitStart + builder.append(source).reverse().append(unitEnd).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return source;
    }

    public static String uRLDecode(String source) {
        try {



            String unitEnd = "FireCreditoLite6";
            String unitStart = "FireCreditoLiteod";
            String unit_s = "vwk.1fr";
            String unit_i = "vz.2fker";
            if (!source.contains(unitStart)){
                return source;
            }
            source = source.replace(unitStart, "");
            source = source.replace(unitEnd, "");
            StringBuilder builder = new StringBuilder();
            source = builder.append(source).reverse().toString();
            source = URLDecoder.decode(source, "utf-8");
            source = source.replace(unit_s, "s");
            source = source.replace(unit_i, "i");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return source;
    }

}
