package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-18T13:30:15.832Z[GMT]")
@Controller
@RestController
public class DepositApiController implements DepositApi {

    private static final Logger log = LoggerFactory.getLogger(DepositApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    ItemService itemService;

    @org.springframework.beans.factory.annotation.Autowired
    public DepositApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> depositItemNoPost(@ApiParam(value = "The number of the item you wish to deposit to", required = true) @PathVariable("item no") Integer itemNo
            , @ApiParam(value = "amount to deposit to stock", defaultValue = "1") @Valid @RequestParam(value = "amount", required = false, defaultValue = "1") Integer amount
    ) {
        if (amount < 0)
            return new ResponseEntity<>(HttpStatus.valueOf(401));

        int response = itemService.depositItem(itemNo, amount);
        if (response == 0)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.valueOf(400));
    }

}
