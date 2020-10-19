package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Item
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-18T13:30:15.832Z[GMT]")

@Entity
@Table(name = "ITEMS")
public class Item {
    @JsonProperty("item no")
    @Column
    private Integer itemNo = null;

    @JsonProperty("name")
    @Column
    private String name = null;

    @JsonProperty("amount")
    @Column
    private Integer amount = null;

    @JsonProperty("inventory code")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer inventoryCode = null;

    public Item() {
    }

    public Item(Integer item_no, String name, Integer amount) {
        this.itemNo = item_no;
        this.name = name;
        this.amount = amount;
        this.inventoryCode = 0;
    }

    public Item itemNo(Integer itemNo) {
        this.itemNo = itemNo;
        return this;
    }


    /**
     * Get itemNo
     *
     * @return itemNo
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    public Item name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item amount(Integer amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Get amount
     *
     * @return amount
     **/
    @ApiModelProperty(value = "")

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Item inventoryCode(Integer inventoryCode) {
        this.inventoryCode = inventoryCode;
        return this;
    }

    /**
     * Get inventoryCode
     *
     * @return inventoryCode
     **/
    @ApiModelProperty(value = "")

    public Integer getInventoryCode() {
        return inventoryCode;
    }

    public void setInventoryCode(Integer inventoryCode) {
        this.inventoryCode = inventoryCode;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(this.itemNo, item.itemNo) &&
                Objects.equals(this.name, item.name) &&
                Objects.equals(this.amount, item.amount) &&
                Objects.equals(this.inventoryCode, item.inventoryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemNo, name, amount, inventoryCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Item {\n");

        sb.append("    itemNo: ").append(toIndentedString(itemNo)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    inventoryCode: ").append(toIndentedString(inventoryCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
