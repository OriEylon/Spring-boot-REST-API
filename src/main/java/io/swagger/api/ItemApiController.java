package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Item;
import io.swagger.model.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-18T13:30:15.832Z[GMT]")
@Controller
public class ItemApiController implements ItemApi {

    private static final Logger log = LoggerFactory.getLogger(ItemApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    ItemService itemService;

    @org.springframework.beans.factory.annotation.Autowired
    public ItemApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> itemItemNoDelete(@ApiParam(value = "The number of the item to delete", required = true) @PathVariable("item no") Integer itemNo
    ) {
        int response = itemService.deleteItem(itemNo);
        if (response == 1)
            return new ResponseEntity<>(HttpStatus.valueOf(400));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Item> itemItemNoGet(@ApiParam(value = "The number of the item to return", required = true) @PathVariable("item no") Integer itemNo
    ) {
        Item i = itemService.getItem(itemNo);
        if (i == null)
            return new ResponseEntity<>(HttpStatus.valueOf(400));
        return ResponseEntity.ok().body(i);
    }

    public ResponseEntity<Void> itemPost(@NotNull @ApiParam(value = "item number", required = true) @Valid @RequestParam(value = "item no", required = true) Integer itemNo
            , @NotNull @ApiParam(value = "item name", required = true) @Valid @RequestParam(value = "name", required = true) String name
            , @ApiParam(value = "item amount", defaultValue = "1") @Valid @RequestParam(value = "amount", required = false, defaultValue = "1") Integer amount
    ) {
        if (amount < 0)
            return new ResponseEntity<>(HttpStatus.valueOf(401));

        int response = itemService.addItem(itemNo, name, amount);
        if (response == 1)
            return new ResponseEntity<>(HttpStatus.valueOf(400));
        else
            return new ResponseEntity<>(HttpStatus.OK);
    }

}
