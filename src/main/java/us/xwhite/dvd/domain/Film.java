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
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Joel Crosswhite <joel.crosswhite@ix.netcom.com>
 */
@Entity
@Table(name = "film")
public class Film implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "film")
    private Collection<FilmCategory> filmCategoryCollection;

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "film_id")
    private Short filmId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;

    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    @Temporal(TemporalType.DATE)
    private Date releaseYear;

    @Basic(optional = false)
    @NotNull
    @Column(name = "rental_duration")
    private short rentalDuration;

    @Basic(optional = false)
    @NotNull
    @Column(name = "rental_rate")
    private BigDecimal rentalRate;

    @Column(name = "length")
    private Short length;

    @Basic(optional = false)
    @NotNull
    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;

    @Size(max = 5)
    @Column(name = "rating")
    private String rating;

    @Size(max = 54)
    @Column(name = "special_features")
    private String specialFeatures;

    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @JoinColumn(name = "language_id", referencedColumnName = "language_id")
    @ManyToOne(optional = false)
    private Language languageId;

    @JoinColumn(name = "original_language_id", referencedColumnName = "language_id")
    @ManyToOne
    private Language originalLanguageId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filmId")
    private Collection<Inventory> inventoryCollection;

    public Short getFilmId() {
        return filmId;
    }

    public void setFilmId(Short filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public short getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(short rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Language getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Language languageId) {
        this.languageId = languageId;
    }

    public Language getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Language originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    @XmlTransient
    public Collection<Inventory> getInventoryCollection() {
        return inventoryCollection;
    }

    public void setInventoryCollection(Collection<Inventory> inventoryCollection) {
        this.inventoryCollection = inventoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filmId != null ? filmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        return !((this.filmId == null && other.filmId != null) || (this.filmId != null && !this.filmId.equals(other.filmId)));
    }

    @Override
    public String toString() {
        return "us.xwhite.dvd.domain.Film[ filmId=" + filmId + " ]";
    }

    public Film() {
    }

    @XmlTransient
    public Collection<FilmCategory> getFilmCategoryCollection() {
        return filmCategoryCollection;
    }

    public void setFilmCategoryCollection(Collection<FilmCategory> filmCategoryCollection) {
        this.filmCategoryCollection = filmCategoryCollection;
    }

}
