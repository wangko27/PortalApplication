/**
 * Copyright 2014 Sayem Ahmed Licensed under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package net.filippov.newsportal.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;

/**
 * @author <a href="mailto:sayem64@gmail.com">Sayem Ahmed</a>
 */
@Entity
@Table(name = "project")
public class Project {

    @Id
//  @SequenceGenerator(name = "project_id_seq", sequenceName = "project_id_seq", 
//      allocationSize = 1)
//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_id_seq")
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private ProjectType type;

    private String name;
    private String description;
    private BigDecimal budget;

    @ManyToOne
    @JoinColumn(name = "leader_id")
    private Employee leader;

    @ManyToMany
    @JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Collection<Employee> employees;

    public Long getId() {
        return id;
    }

    public Project setId(Long id) {
        this.id = id;
        return this;
    }

    public ProjectType getType() {
        return type;
    }

    public Project setType(ProjectType type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Project setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public Project setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public Employee getLeader() {
        return leader;
    }

    public Project setLeader(Employee leader) {
        this.leader = leader;
        return this;
    }

    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employees);
    }

    public Project addEmployee(Employee employee) {
        employees.add(employee);
        return this;
    }

    public Project addAllEmployees(Collection<? extends Employee> employees) {
        this.employees.addAll(employees);
        return this;
    }
}
