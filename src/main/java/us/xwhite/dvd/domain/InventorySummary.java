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
public class InventorySummary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String filmTitle;

    private String category;

    private Long count;

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public InventorySummary() {
    }

    public InventorySummary(String filmTitle, String category, Long count) {
        this.filmTitle = filmTitle;
        this.category = category;
        this.count = count;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filmTitle != null ? filmTitle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof InventorySummary)) {
            return false;
        }
        InventorySummary other = (InventorySummary) object;
        return !((this.filmTitle == null && other.filmTitle != null) || (this.filmTitle != null && !this.filmTitle.equals(other.filmTitle)));
    }

    @Override
    public String toString() {
        return "us.xwhite.dvd.domain.InventorySummary[ filmTitle=" + filmTitle + " ]";
    }

}
