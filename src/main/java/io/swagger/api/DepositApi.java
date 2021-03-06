/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.21).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-18T13:30:15.832Z[GMT]")
@Api(value = "Deposit", description = "the Deposit API")
public interface DepositApi {

    @ApiOperation(value = "Deposit item to stock", nickname = "depositItemNoPost", notes = "Deposit quantity of a specific item to stock", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "item doesn't exist"),
            @ApiResponse(code = 401, message = "invalid 'amount' value")})
    @RequestMapping(value = "/Deposit/{item no}",
            method = RequestMethod.POST)
    ResponseEntity<Void> depositItemNoPost(@ApiParam(value = "The number of the item you wish to deposit to", required = true) @PathVariable("item no") Integer itemNo
            , @ApiParam(value = "amount to deposit to stock", defaultValue = "1") @Valid @RequestParam(value = "amount", required = false, defaultValue = "1") Integer amount
    );

}

