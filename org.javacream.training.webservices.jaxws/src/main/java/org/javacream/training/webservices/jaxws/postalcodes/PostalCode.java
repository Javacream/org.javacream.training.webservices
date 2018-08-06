package org.javacream.training.webservices.jaxws.postalcodes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PostalCode {

	@XmlAttribute
	private int postalCode;
	@XmlElement(name="CityName")
	private String city;
	public PostalCode(int postalCode, String city) {
		super();
		this.postalCode = postalCode;
		this.city = city;
	}
	public PostalCode() {
		super();
	}
	@Override
	public String toString() {
		return "PostalCode [postalCode=" + postalCode + ", city=" + city + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + postalCode;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostalCode other = (PostalCode) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (postalCode != other.postalCode)
			return false;
		return true;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
