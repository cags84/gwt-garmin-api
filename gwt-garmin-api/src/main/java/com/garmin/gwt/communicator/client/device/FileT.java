//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.06 at 11:45:30 PM EST 
//


package com.garmin.gwt.communicator.client.device;

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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for File_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="File_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Specification" type="{http://www.garmin.com/xmlschemas/GarminDevice/v2}Specification_t"/>
 *         &lt;element name="Location" type="{http://www.garmin.com/xmlschemas/GarminDevice/v2}Location_t"/>
 *         &lt;element name="TransferDirection" type="{http://www.garmin.com/xmlschemas/GarminDevice/v2}TransferDirection_t"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "File_t", propOrder = {
    "specification",
    "location",
    "transferDirection"
})
public class FileT {

    @XmlElement(name = "Specification", required = true)
    protected SpecificationT specification;
    @XmlElement(name = "Location", required = true)
    protected LocationT location;
    @XmlElement(name = "TransferDirection", required = true)
    protected TransferDirectionT transferDirection;

    /**
     * Gets the value of the specification property.
     * 
     * @return
     *     possible object is
     *     {@links SpecificationT }
     *     
     */
    public SpecificationT getSpecification() {
        return specification;
    }

    /**
     * Sets the value of the specification property.
     * 
     * @param value
     *     allowed object is
     *     {@links SpecificationT }
     *     
     */
    public void setSpecification(SpecificationT value) {
        this.specification = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@links LocationT }
     *     
     */
    public LocationT getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@links LocationT }
     *     
     */
    public void setLocation(LocationT value) {
        this.location = value;
    }

    /**
     * Gets the value of the transferDirection property.
     * 
     * @return
     *     possible object is
     *     {@links TransferDirectionT }
     *     
     */
    public TransferDirectionT getTransferDirection() {
        return transferDirection;
    }

    /**
     * Sets the value of the transferDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@links TransferDirectionT }
     *     
     */
    public void setTransferDirection(TransferDirectionT value) {
        this.transferDirection = value;
    }

}