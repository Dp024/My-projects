package com.test;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
public class Test {
	
	public static void main(String[] args) {
		
		Client client =ClientBuilder.newClient();
		
		String request="<?xml version=\"1.0\" encoding=\"UTF-8\"?><wps:Execute version=\"1.0.0\""
				+ " service=\"WPS\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://www.opengis.net/wps/1.0.0\""
				+ " xmlns:wfs=\"http://www.opengis.net/wfs\" xmlns:wps=\"http://www.opengis.net/wps/1.0.0\" "
				+ "xmlns:ows=\"http://www.opengis.net/ows/1.1\" xmlns:gml=\"http://www.opengis.net/gml\" "
				+ "xmlns:ogc=\"http://www.opengis.net/ogc\" xmlns:wcs=\"http://www.opengis.net/wcs/1.1.1\" "
				+ "xmlns:xlink=\"http://www.w3.org/1999/xlink\""
				+ " xsi:schemaLocation=\"http://www.opengis.net/wps/1.0.0 http://schemas.opengis.net/wps/1.0.0/wpsAll.xsd\">\r\n"
				+ "  <ows:Identifier>gs:Aggregate</ows:Identifier>\r\n  <wps:DataInputs>\r\n    <wps:Input>\r\n     "
				+ " <ows:Identifier>features</ows:Identifier>\r\n      "
				+ "<wps:Reference mimeType=\"text/xml\" xlink:href=\"http://geoserver/wfs\" method=\"POST\">\r\n        <wps:Body>\r\n "
				+ "         <wfs:GetFeature service=\"WFS\" version=\"1.0.0\" outputFormat=\"GML2\" xmlns:sf=\"http://www.openplans.org/spearfish\">\r\n   "
				+ "         <wfs:Query typeName=\"topp:states\"/>\r\n          </wfs:GetFeature>\r\n        </wps:Body>\r\n      </wps:Reference>\r\n    </wps:Input>\r\n    <wps:Input>\r\n      <ows:Identifier>aggregationAttribute</ows:Identifier>\r\n      <wps:Data>\r\n        <wps:LiteralData>PERSONS</wps:LiteralData>\r\n      </wps:Data>\r\n    </wps:Input>\r\n    <wps:Input>\r\n      <ows:Identifier>function</ows:Identifier>\r\n      <wps:Data>\r\n        <wps:LiteralData>Count</wps:LiteralData>\r\n      </wps:Data>\r\n    </wps:Input>\r\n    <wps:Input>\r\n      <ows:Identifier>function</ows:Identifier>\r\n      <wps:Data>\r\n        <wps:LiteralData>Average</wps:LiteralData>\r\n      </wps:Data>\r\n    </wps:Input>\r\n    <wps:Input>\r\n      <ows:Identifier>function</ows:Identifier>\r\n      <wps:Data>\r\n        <wps:LiteralData>Sum</wps:LiteralData>\r\n      </wps:Data>\r\n    </wps:Input>\r\n    <wps:Input>\r\n      <ows:Identifier>function</ows:Identifier>\r\n      <wps:Data>\r\n        <wps:LiteralData>Min</wps:LiteralData>\r\n      </wps:Data>\r\n    </wps:Input>\r\n    <wps:Input>\r\n      <ows:Identifier>function</ows:Identifier>\r\n      <wps:Data>\r\n        <wps:LiteralData>Max</wps:LiteralData>\r\n      </wps:Data>\r\n    </wps:Input>\r\n    <wps:Input>\r\n      <ows:Identifier>singlePass</ows:Identifier>\r\n      <wps:Data>\r\n        <wps:LiteralData>false</wps:LiteralData>\r\n      </wps:Data>\r\n    </wps:Input>\r\n  </wps:DataInputs>\r\n  <wps:ResponseForm>\r\n    <wps:RawDataOutput mimeType=\"application/json\">\r\n      <ows:Identifier>result</ows:Identifier>\r\n    </wps:RawDataOutput>\r\n  </wps:ResponseForm>\r\n</wps:Execute>";
	
		System.out.println("request:"+request);
		String callResult = client
		         .target("http://localhost:9090/geoserver/wps")
		         .request(MediaType.APPLICATION_JSON)//.header("Authorization", "Basic YWRtaW46Z2Vvc2VydmVy")
		         .post(Entity.entity(request,
		            MediaType.APPLICATION_XML),
		            String.class);
		System.out.println("response:"+callResult);
	}
	
	
	
	
	

}
