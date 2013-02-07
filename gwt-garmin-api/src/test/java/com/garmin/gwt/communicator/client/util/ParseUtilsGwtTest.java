package com.garmin.gwt.communicator.client.util;

/*
 * #%L
 * GWT Garmin API - Core API
 * %%
 * Copyright (C) 2012 - 2013 GWT Garmin API
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import junit.framework.Assert;

import com.garmin.gwt.communicator.client.AbstractGarminGWTTest;
import com.garmin.gwt.communicator.client.base.Device;
import com.garmin.gwt.communicator.client.request.TransferProgress;

/**
 * Test ParseUtils
 * 
 * @author Joseph Lust
 * 
 */
public class ParseUtilsGwtTest extends AbstractGarminGWTTest {

	public void testParseDeviceDescriptionXml_defaultForerunner() {
		String mockXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><Device xmlns=\"http://www.garmin.com/xmlschemas/GarminDevice/v2\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.garmin.com/xmlschemas/GarminDevice/v2 http://www.garmin.com/xmlschemas/GarminDevicev2.xsd\"><Model><PartNumber>006-B1430-00</PartNumber><SoftwareVersion>290</SoftwareVersion><Description>Forerunner305 Software Version 2.90</Description></Model><Id>3600980071</Id><DisplayName>Forerunner305 Software Version 2.90</DisplayName><MassStorageMode><DataType><Name>GPSData</Name><File><Specification><Identifier>http://www.topografix.com/GPX/1/1</Identifier><Documentation>http://www.topografix.com/GPX/1/1/gpx.xsd</Documentation></Specification><Location><FileExtension>GPX</FileExtension></Location><TransferDirection>InputOutput</TransferDirection></File></DataType><DataType><Name>FitnessHistory</Name><File><Specification><Identifier>http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2</Identifier><Documentation>http://www.garmin.com/xmlschemas/TrainingCenterDatabasev2.xsd</Documentation></Specification><Location><FileExtension>TCX</FileExtension></Location><TransferDirection>InputOutput</TransferDirection></File></DataType></MassStorageMode></Device>";
		Device mockDevice = new Device("Foo Description",2);

		mockDevice = ParseUtils.parseDeviceDescriptionXml(mockDevice, mockXml);

		String expected = "Device [displayName=Foo Description, deviceNumber=2, model=Model [partNumber=006-B1430-00, softwareVersion=290, description=Forerunner305 Software Version 2.90, extensions=], id=3600980071, registrationCode=, unlockCode=]";
		Assert.assertEquals("Incorrectly parsed device description XML", expected,mockDevice.toString());
	}

	public void testParseDeviceDescriptionXml_defaultNuvi() {
		String mockXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><Device xmlns=\"http://www.garmin.com/xmlschemas/GarminDevice/v2\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.garmin.com/xmlschemas/GarminDevice/v2 http://www.garmin.com/xmlschemas/GarminDevicev2.xsd\"><Model><PartNumber>006-B0851-00</PartNumber><SoftwareVersion>610</SoftwareVersion><Description>nüvi 255</Description></Model><Id>3493891722</Id><RegistrationCode>9HHRRUY</RegistrationCode><Unlock><Code>6VFQ8CHJIK3FVCTSW9AJAQ488</Code></Unlock><MassStorageMode><DataType><Name>GPSData</Name><File><Specification><Identifier>http://www.topografix.com/GPX/1/1</Identifier><Documentation>http://www.topografix.com/GPX/1/1/gpx.xsd</Documentation></Specification><Location><Path>Garmin/gpx</Path><FileExtension>GPX</FileExtension></Location><TransferDirection>InputToUnit</TransferDirection></File><File><Specification><Identifier>http://www.topografix.com/GPX/1/1</Identifier><Documentation>http://www.topografix.com/GPX/1/1/gpx.xsd</Documentation></Specification><Location><Path>Garmin/gpx</Path><BaseName>Current</BaseName><FileExtension>GPX</FileExtension></Location><TransferDirection>OutputFromUnit</TransferDirection></File></DataType><DataType><Name>LastKnownPosition</Name><File><Specification><Identifier>http://www.topografix.com/GPX/1/1</Identifier><Documentation>http://www.topografix.com/GPX/1/1/gpx.xsd</Documentation></Specification><Location><Path>Garmin/gpx</Path><BaseName>Position</BaseName><FileExtension>GPX</FileExtension></Location><TransferDirection>OutputFromUnit</TransferDirection></File></DataType><DataType><Name>BaseMaps</Name><File><Specification><Identifier>IMG</Identifier></Specification><Location><Path>Garmin</Path><BaseName>gmapbmap</BaseName><FileExtension>img</FileExtension></Location><TransferDirection>InputOutput</TransferDirection></File></DataType><DataType><Name>PreProgrammedMaps</Name><File><Specification><Identifier>IMG</Identifier></Specification><Location><Path>Garmin</Path><BaseName>gmapprom</BaseName><FileExtension>img</FileExtension></Location><TransferDirection>InputOutput</TransferDirection></File></DataType><DataType><Name>SupplementalMaps</Name><File><Specification><Identifier>IMG</Identifier></Specification><Location><Path>Garmin</Path><BaseName>gmapsupp</BaseName><FileExtension>img</FileExtension></Location><TransferDirection>InputOutput</TransferDirection></File></DataType><DataType><Name>TimeZoneMaps</Name><File><Specification><Identifier>IMG</Identifier></Specification><Location><Path>Garmin</Path><BaseName>gmaptz</BaseName><FileExtension>img</FileExtension></Location><TransferDirection>InputOutput</TransferDirection></File></DataType><DataType><Name>Voices</Name><File><Specification><Identifier>VPM</Identifier></Specification><Location><Path>Garmin/Voice</Path><FileExtension>vpm</FileExtension></Location><TransferDirection>InputOutput</TransferDirection></File></DataType><DataType><Name>VCTVoices</Name><File><Specification><Identifier>VCT</Identifier></Specification><Location><Path>Garmin/Voice</Path><FileExtension>vpm</FileExtension></Location><TransferDirection>InputOutput</TransferDirection></File></DataType><DataType><Name>TranslatedText</Name><File><Specification><Identifier>http://www.garmin.com/xmlschemas/GarminTextTranslation/v1</Identifier><Documentation>http://www.garmin.com/xmlschemas/GarminTextTranslationv1.xsd</Documentation></Specification><Location><Path>Garmin/Text</Path><FileExtension>gtt</FileExtension></Location><TransferDirection>InputOutput</TransferDirection></File></DataType><DataType><Name>FTLImageVersion</Name><File><Specification><Identifier>VER</Identifier></Specification><Location><Path>Garmin</Path><BaseName>fs_image</BaseName><FileExtension>ver</FileExtension></Location><TransferDirection>InputOutput</TransferDirection></File></DataType><DataType><Name>CustomPOI</Name><File><Specification><Identifier>GPI0.0</Identifier></Specification><Location><Path>Garmin/POI</Path><FileExtension>gpi</FileExtension></Location><TransferDirection>InputToUnit</TransferDirection></File></DataType><DataType><Name>Safety_Cameras_PROM_Provider_1</Name><File><Specification><Identifier>GPI</Identifier></Specification><Location><Path>Garmin/POI</Path><FileExtension>GPI</FileExtension></Location><TransferDirection>InputToUnit</TransferDirection></File></DataType><DataType><Name>Scenic_Routes_Provider_1</Name><File><Specification><Identifier>GPI</Identifier></Specification><Location><Path>Garmin/POI</Path><FileExtension>GPI</FileExtension></Location><TransferDirection>InputToUnit</TransferDirection></File></DataType><DataType><Name>geocache_visits</Name><File><Specification><Identifier>TXT</Identifier></Specification><Location><Path>Garmin</Path><BaseName>geocache_visits</BaseName><FileExtension>txt</FileExtension></Location><TransferDirection>OutputFromUnit</TransferDirection></File></DataType><UpdateFile><PartNumber>006-D0397-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>English_American_.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0400-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Deutsch__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0401-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Francais_European_.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0399-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Italiano__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0402-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Espanol_European_.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0405-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Svenska__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0404-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Dansk__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0408-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Portugues_European_.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0406-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Nederlands__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0407-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Norsk__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0403-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Suomi__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0585-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Polski__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0582-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Cesky__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0584-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Magyar__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0398-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>English_British_.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0409-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Francais_Canadian_.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0588-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Portugues_Brazilian_.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0583-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Ellinika__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0580-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Flemish__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0863-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Chinese_Simplified_.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0865-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Japanese__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0581-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Hrvatski__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0587-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Slovenscina__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0633-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Eesti__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0632-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Lietuviu__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0635-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Romana__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0586-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Russkiy__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0631-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Slovencina__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0636-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Turkce__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0634-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Bulgarian__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0637-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Srpski__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0860-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Chinese_Traditional_.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0870-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Korean__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0864-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Thai__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0861-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Taiwanese__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0862-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Cantonese__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0872-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Arabic__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0866-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Letzebuergesch__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0867-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Catala__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D0869-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Afrikaans__.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1022-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Svenska__Alva.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1021-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Nederlands__Claire.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1020-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>English_British_Daniel.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1019-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Espanol_European_Diego.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1018-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>English_British_Emily.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1017-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Francais_Canadien_Felix.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1027-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Dansk__Ida.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1016-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Espanol_Americas_Javier.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1015-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>English_American_Jill.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1014-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Francais_Canadien_Julie.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1023-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>English_Australian_Karen.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1024-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>English_Australian_Lee.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1013-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Portuguese_European_Madalena.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1075-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Portuguese_European_Joana.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1012-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Espanol_European_Monica.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1011-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Italiano__Paolo.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1010-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Espanol_Americas_Paulina.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1036-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Portuguese_Brazilian_Raquel.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1118-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>English_American_Samantha.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1009-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Francais_European_Sebastian.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1008-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>English_British_Serena.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1007-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Italiano__Silvia.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1006-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Deutsch__Steffi.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1025-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Norsk__Stine.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1005-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>English_American_Jack.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1004-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Francais_European_Virginie.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1026-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Nederlands__Xander.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-D1003-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin/Voice</Path><FileName>Deutsch__Yannick.vpm</FileName></UpdateFile><UpdateFile><PartNumber>006-F0057-01</PartNumber><Version><Major>3</Major><Minor>0</Minor></Version><Path>Garmin</Path><FileName>gmapbmap.img</FileName></UpdateFile><UpdateFile><PartNumber>006-D0322-05</PartNumber><Version><Major>20</Major><Minor>10</Minor></Version><Path>Garmin</Path><FileName>gmapprom.img</FileName></UpdateFile><UpdateFile><PartNumber>006-D1074-00</PartNumber><Version><Major>4</Major><Minor>0</Minor></Version><Path>Garmin</Path><FileName>gmaptz.img</FileName></UpdateFile><UpdateFile><PartNumber>006-B0482-01</PartNumber><Version><Major>5</Major><Minor>50</Minor></Version><Path>Garmin/RemoteSW</Path><FileName>006B048201.bin</FileName></UpdateFile><UpdateFile><PartNumber>006-B0630-00</PartNumber><Version><Major>3</Major><Minor>30</Minor></Version><Path>Garmin/RemoteSW</Path><FileName>006B063000.GCD</FileName></UpdateFile><UpdateFile><PartNumber>006-D1359-00</PartNumber><Version><Major>3</Major><Minor>0</Minor></Version><Path>Garmin/Poi</Path><FileName>006D135900.gpi</FileName></UpdateFile><UpdateFile><PartNumber>006-B0851-00</PartNumber><Version><Major>6</Major><Minor>10</Minor></Version><Path>Garmin</Path><FileName>GUPDATE.GCD</FileName></UpdateFile><UpdateFile><PartNumber>006-D0578-00</PartNumber><Version><Major>2</Major><Minor>50</Minor></Version><Path>Garmin/Vehicle</Path><FileName>car_blue.srf</FileName></UpdateFile><UpdateFile><PartNumber>006-D0578-01</PartNumber><Version><Major>2</Major><Minor>40</Minor></Version><Path>Garmin/Vehicle</Path><FileName>truck_blue.srf</FileName></UpdateFile><UpdateFile><PartNumber>006-D0578-02</PartNumber><Version><Major>2</Major><Minor>40</Minor></Version><Path>Garmin/Vehicle</Path><FileName>euro_blue.srf</FileName></UpdateFile><UpdateFile><PartNumber>006-D0578-03</PartNumber><Version><Major>2</Major><Minor>40</Minor></Version><Path>Garmin/Vehicle</Path><FileName>triangle_blue.srf</FileName></UpdateFile><UpdateFile><PartNumber>006-D0952-01</PartNumber><Version><Major>2</Major><Minor>10</Minor></Version><Path>Garmin/ExtData</Path><FileName>006-D0952-01.bin</FileName></UpdateFile><UpdateFile><PartNumber>006-D0952-02</PartNumber><Version><Major>2</Major><Minor>0</Minor></Version><Path>Garmin/ExtData</Path><FileName>006-D0952-02.bin</FileName></UpdateFile><UpdateFile><PartNumber>006-D0952-03</PartNumber><Version><Major>2</Major><Minor>0</Minor></Version><Path>Garmin/ExtData</Path><FileName>006-D0952-03.bin</FileName></UpdateFile><UpdateFile><PartNumber>006-D0952-04</PartNumber><Version><Major>2</Major><Minor>0</Minor></Version><Path>Garmin/ExtData</Path><FileName>006-D0952-04.bin</FileName></UpdateFile><UpdateFile><PartNumber>006-D0952-05</PartNumber><Version><Major>2</Major><Minor>0</Minor></Version><Path>Garmin/ExtData</Path><FileName>006-D0952-05.bin</FileName></UpdateFile><UpdateFile><PartNumber>006-D0952-06</PartNumber><Version><Major>2</Major><Minor>0</Minor></Version><Path>Garmin/ExtData</Path><FileName>006-D0952-06.bin</FileName></UpdateFile><UpdateFile><PartNumber>006-D0952-07</PartNumber><Version><Major>2</Major><Minor>10</Minor></Version><Path>Garmin/ExtData</Path><FileName>006-D0952-07.bin</FileName></UpdateFile><UpdateFile><PartNumber>006-D0952-08</PartNumber><Version><Major>2</Major><Minor>10</Minor></Version><Path>Garmin/ExtData</Path><FileName>006-D0952-08.bin</FileName></UpdateFile><UpdateFile><PartNumber>006-H0036-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin</Path><FileName>H003600.zip</FileName></UpdateFile><UpdateFile><PartNumber>006-D0981-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin</Path><FileName>D098100.zip</FileName></UpdateFile><UpdateFile><PartNumber>006-D0904-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin</Path><FileName>D090400.zip</FileName></UpdateFile><UpdateFile><PartNumber>006-D1169-00</PartNumber><Version><Major>0</Major><Minor>0</Minor></Version><Path>Garmin</Path><FileName>D116900.zip</FileName></UpdateFile><UpdateFile><PartNumber>006-D1122-00</PartNumber><Version><Major>2</Major><Minor>50</Minor></Version><Path>Garmin</Path><FileName>Locales.xml</FileName></UpdateFile></MassStorageMode><Extensions><DeviceExtension xmlns=\"http://www.garmin.com/xmlschemas/GarminDeviceExtensions/v2\" xsi:schemaLocation=\"http://www.garmin.com/xmlschemas/GarminDeviceExtensions/v2 http://www.garmin.com/xmlschemas/GarminDeviceExtensionv2.xsd\"><Ifix>635352477</Ifix><ActiveItem><Name>Vehicle</Name><Location><Path>Garmin/Vehicle</Path><BaseName>car_blue</BaseName><FileExtension>srf</FileExtension></Location></ActiveItem></DeviceExtension></Extensions></Device>";
		Device mockDevice = new Device("Foo Description",2);

		mockDevice = ParseUtils.parseDeviceDescriptionXml(mockDevice, mockXml);

		String expected = "Device [displayName=Foo Description, deviceNumber=2, model=Model [partNumber=006-B0851-00, softwareVersion=610, description=nüvi 255, extensions=null], id=3493891722, registrationCode=9HHRRUY, unlockCode=6VFQ8CHJIK3FVCTSW9AJAQ488]";
		Assert.assertEquals("Incorrectly parsed device description XML", expected,mockDevice.toString());
	}

	public void testToString_no_percentage() {
		String mockXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><ProgressWidget xmlns=\"http://www.garmin.com/xmlschemas/PluginAPI/v1\"><Title>Foo Title</Title><Text></Text><Text></Text><Text>0% complete</Text><ProgressBar Type=\"Foo\" Value=\"33\"/></ProgressWidget>";
		TransferProgress prog = ParseUtils.parseProgressXml(mockXml);

		String expected = "Foo Title";
		Assert.assertEquals("Incorrect tostring() output", expected, prog.toString());
	}

	public void testXmlConstructor() {
		String mockXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><ProgressWidget xmlns=\"http://www.garmin.com/xmlschemas/PluginAPI/v1\"><Title>GarminPlugin Status not yet implemented</Title><Text></Text><Text></Text><Text>0% complete</Text><ProgressBar Type=\"Percentage\" Value=\"33\"/></ProgressWidget>";
		TransferProgress prog = ParseUtils.parseProgressXml(mockXml);

		String expected = "GarminPlugin Status not yet implemented";
		Assert.assertEquals("Incorrectly parsed xml title", expected, prog.getTitle());

		expected = "0% complete";
		Assert.assertTrue("Only one text string should appear in output", prog.getText().length==1);
		Assert.assertEquals("Incorrectly parsed xml title", expected, prog.getText()[0]);

		int expectedPercentage = 33;
		Assert.assertTrue("Percentage set flag should be set",prog.hasPercentage());
		Assert.assertEquals("Incorrectly parsed xml percentage", expectedPercentage, prog.getPercentage());
	}

	public void testXmlConstructor_indefinite_percentage() {
		String mockXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><ProgressWidget xmlns=\"http://www.garmin.com/xmlschemas/PluginAPI/v1\"><Title>GarminPlugin Status not yet implemented</Title><Text></Text><Text></Text><Text>0% complete</Text><ProgressBar Type=\"Indefinite\" Value=\"33\"/></ProgressWidget>";
		TransferProgress prog = ParseUtils.parseProgressXml(mockXml);

		int expectedPercentage = 100;
		Assert.assertTrue("Percentage set flag should be set",prog.hasPercentage());
		Assert.assertEquals("Incorrectly parsed xml percentage", expectedPercentage, prog.getPercentage());
	}

	public void testXmlConstructor_no_percentage() {
		String mockXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><ProgressWidget xmlns=\"http://www.garmin.com/xmlschemas/PluginAPI/v1\"><Title>GarminPlugin Status not yet implemented</Title><Text></Text><Text></Text><Text>0% complete</Text><ProgressBar Type=\"Foo\" Value=\"33\"/></ProgressWidget>";
		TransferProgress prog = ParseUtils.parseProgressXml(mockXml);

		int expectedPercentage = 0;
		Assert.assertFalse("Percentage set flag should NOT be set",prog.hasPercentage());
		Assert.assertEquals("Incorrectly parsed xml percentage", expectedPercentage, prog.getPercentage());
	}

	public void testParseDeviceXml() {
		String mockDeviceXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><Devices xmlns=\"http://www.garmin.com/xmlschemas/PluginAPI/v1\"><Device DisplayName=\"Forerunner305 Software Version 2.90\" Number=\"4\" /></Devices>";
		Device[] deviceList = ParseUtils.parseDeviceXml(mockDeviceXml);

		Assert.assertTrue("Should only have been a single parsed device", deviceList.length==1);

		String expected = "Forerunner305 Software Version 2.90";
		Assert.assertEquals("Incorrect displayName value parsed", expected, deviceList[0].getDisplayName());

		int expectedNumber = 4;
		Assert.assertEquals("Incorrect deviceNumber value parsed", expectedNumber, deviceList[0].getDeviceNumber());
	}

	public void testParseDeviceXml_several_devices() {
		String mockDeviceXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><Devices xmlns=\"http://www.garmin.com/xmlschemas/PluginAPI/v1\"><Device DisplayName=\"Forerunner305 Software Version 2.90\" Number=\"0\" /><Device DisplayName=\"Forerunner303 Software Version 2.90\" Number=\"1\" /><Device DisplayName=\"Forerunner405 Software Version 2.90\" Number=\"2\" /></Devices>";
		Device[] deviceList = ParseUtils.parseDeviceXml(mockDeviceXml);

		Assert.assertTrue("Wrong number of devices parsed", deviceList.length==3);

		String expected = "Forerunner305 Software Version 2.90";
		Assert.assertEquals("Incorrect displayName value parsed", expected, deviceList[0].getDisplayName());
		expected = "Forerunner303 Software Version 2.90";
		Assert.assertEquals("Incorrect displayName value parsed", expected, deviceList[1].getDisplayName());
		expected = "Forerunner405 Software Version 2.90";
		Assert.assertEquals("Incorrect displayName value parsed", expected, deviceList[2].getDisplayName());

		Assert.assertEquals("Incorrect deviceNumber value parsed", 0, deviceList[0].getDeviceNumber());
		Assert.assertEquals("Incorrect deviceNumber value parsed", 1, deviceList[1].getDeviceNumber());
		Assert.assertEquals("Incorrect deviceNumber value parsed", 2, deviceList[2].getDeviceNumber());
	}

	public void testParseDeviceXml_empty() {
		String mockDeviceXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><Devices xmlns=\"http://www.garmin.com/xmlschemas/PluginAPI/v1\" />";
		Device[] deviceList = ParseUtils.parseDeviceXml(mockDeviceXml);

		Assert.assertTrue("Device list should be empty", deviceList.length==0);
	}

}