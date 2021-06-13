package com.demo.project82.order;

import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * https://javakeypoint.wordpress.com/2020/04/21/difference-between-joincolumn-and-jointable-in-hibernate/
 * https://stackoverflow.com/questions/30288464/when-should-i-use-joincolumn-or-jointable-with-jpa
 * https://medium.com/nerd-for-tech/elementcollection-vs-onetomany-in-hibernate-7fb7d2ac00ea
 * https://thorben-janssen.com/ultimate-guide-association-mappings-jpa-hibernate/
 * https://www.baeldung.com/jpa-many-to-many
 * https://www.callicoder.com/hibernate-spring-boot-jpa-element-collection-demo/
 * https://vladmihalcea.com/blog/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@ToString(exclude = "itemMap")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_item_mapping",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id", referencedColumnName = "id")})
    @MapKey(name = "itemName")
    private Map<String, Item> itemMap;

}
