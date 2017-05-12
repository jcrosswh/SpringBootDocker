/*
 * Copyright 2017
 *
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
 */
package us.xwhite.dvd.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
@Entity
public class StoreSummary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long storeId;

    private String address;

    private String address2;

    private String district;

    private String phone;

    private String city;

    private String country;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public StoreSummary() {
    }

    public StoreSummary(Long storeId, String address, String address2, String district, String phone, String city,
            String country) {
        super();
        this.storeId = storeId;
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.phone = phone;
        this.city = city;
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeId != null ? storeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StoreSummary)) {
            return false;
        }
        StoreSummary other = (StoreSummary) object;
        return !((this.storeId == null && other.storeId != null)
                || (this.storeId != null && !this.storeId.equals(other.storeId)));
    }

    @Override
    public String toString() {
        return "us.xwhite.dvd.domain.StoreSummary[ storeId=" + storeId + " ]";
    }

}
