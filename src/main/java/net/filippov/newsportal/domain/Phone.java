/**
 * Copyright 2014 Sayem Ahmed
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.filippov.newsportal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author <a href="mailto:sayem64@gmail.com">Sayem Ahmed</a>
 */
@Entity
@Table(name = "phone")
public class Phone {
  @Id
//  @SequenceGenerator(name = "employee_id_seq", sequenceName = "employee_id_seq", 
//      allocationSize = 1)
//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_seq")
  @GeneratedValue
  private Long id;
  
  @Enumerated(EnumType.STRING)
  private PhoneType type;
  
  @Column(name = "phone_number")
  private String phoneNumber;
  
  @Column(name = "country_code")
  private String countryCode;
  
  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Employee owner;

  public Long getId() {
    return id;
  }

  public Phone setId(Long id) {
    this.id = id;
    return this;
  }

  public PhoneType getType() {
    return type;
  }

  public Phone setType(PhoneType type) {
    this.type = type;
    return this;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public Phone setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public Phone setCountryCode(String country_code) {
    this.countryCode = country_code;
    return this;
  }

  public Employee getOwner() {
    return owner;
  }

  public Phone setOwner(Employee owner) {
    this.owner = owner;
    return this;
  }
}
