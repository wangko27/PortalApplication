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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * @author Sayem Ahmed
 */
@Entity
@Table(name = "employee")
public class Employee {
  @Id
//  @SequenceGenerator(name = "employee_id_seq", sequenceName = "employee_id_seq", 
//      allocationSize = 1)
//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_seq")
  @GeneratedValue
  private Long id;

  @Column(name = "first_name")
  private String firstName;
  
  @Column(name = "last_name")
  private String lastName;
  
  private BigDecimal salary;
  
  @Column(name = "start_date")
  @Temporal(TemporalType.DATE)
  private Date startDate;
  
  @Column(name = "end_date")
  @Temporal(TemporalType.DATE)
  private Date endDate;
  
  @ManyToOne
  @JoinColumn(name = "manager_id")
  private Employee manager;
  
  @ManyToOne
  @JoinColumn(name = "address_id")
  private Address address;
  
  @OneToMany(mappedBy = "owner")
  private Collection<Phone> phones;
  
  @ManyToMany(mappedBy = "employees")
  private Collection<Project> projects;

  public Long getId() {
    return id;
  }

  public Employee setId(Long id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public Employee setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public Employee setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public Employee setSalary(BigDecimal salary) {
    this.salary = salary;
    return this;
  }

  public Date getStartDate() {
    return startDate;
  }

  public Employee setStartDate(Date startDate) {
    this.startDate = startDate;
    return this;
  }

  public Date getEndDate() {
    return endDate;
  }

  public Employee setEndDate(Date endDate) {
    this.endDate = endDate;
    return this;
  }

  public Employee getManager() {
    return manager;
  }

  public Employee setManager(Employee manager) {
    this.manager = manager;
    return this;
  }

  public Address getAddress() {
    return address;
  }

  public Employee setAddress(Address address) {
    this.address = address;
    return this;
  }
  
  public Employee addPhone(Phone phone) {
    phone.setOwner(this);
    phones.add(phone);

    return this;
  }
  
  public Employee addAllPhones(Collection<? extends Phone> phones) {
    for (Phone phone: phones) {
      addPhone(phone);
    }

    return this;
  }
  
  public Collection<Phone> getPhones() {
    return Collections.unmodifiableCollection(phones);
  }
  
  public Employee addProject(Project project) {
    projects.add(project);
    return this;
  }
  
  public Employee addAllProjects(Collection<? extends Project> projects) {
    this.projects.addAll(projects);
    return this;
  }
  
  public Collection<Project> getProjects() {
    return Collections.unmodifiableCollection(projects);
  }
}
