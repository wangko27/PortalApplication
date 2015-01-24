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

package net.filippov.newsportal.persistenceutil;


import javax.persistence.EntityManager;
import net.filippov.newsportal.domain.Address;
/**
 * @author Sayem Ahmed
 */
public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
    em.getTransaction()
        .begin();
    
    for (int i = 0; i < 10; i++) {
      int index = i + 1;
      Address address = new Address().setCity("Dhaka " + index)
          .setCountry("Bangladesh " + index)
          .setPostcode("1000 " + index)
          .setStreet("Poribagh " + index);
        
      em.persist(address);
      System.out.println("Newly inserted entity's id is: " + address.getId());
    }

    em.getTransaction()
        .commit();
    em.close();

    em = PersistenceManager.INSTANCE.getEntityManager();
    em.getTransaction()
        .begin();
    
    for (int j = 47; j < 200; j++) {
      int index = j + 1;
      Address address = new Address().setCity("Dhaka " + index)
          .setCountry("Bangladesh " + index)
          .setPostcode("1000 " + index)
          .setStreet("Poribagh " + index);
        
      em.persist(address);
      System.out.println("Newly inserted entity's id is: " + address.getId());
    }
    
    em.getTransaction()
        .commit();
    
    em.close();
    PersistenceManager.INSTANCE.close();
  }
}
