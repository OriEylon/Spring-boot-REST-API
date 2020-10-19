/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.21).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-18T13:30:15.832Z[GMT]")
@Api(value = "item", description = "the item API")
public interface ItemApi {

    @ApiOperation(value = "delete item from stock", nickname = "itemItemNoDelete", notes = "this will remove item entirely from the repository", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "item doesn't exists")})
    @RequestMapping(value = "/item/{item no}",
            method = RequestMethod.DELETE)
    ResponseEntity<Void> itemItemNoDelete(@ApiParam(value = "The number of the item to delete", required = true) @PathVariable("item no") Integer itemNo
    );


    @ApiOperation(value = "read item details", nickname = "itemItemNoGet", notes = "get item details by item no", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "item not found")})
    @RequestMapping(value = "/item/{item no}",
            method = RequestMethod.GET)
    ResponseEntity<Item> itemItemNoGet(@ApiParam(value = "The number of the item to return", required = true) @PathVariable("item no") Integer itemNo
    );


    @ApiOperation(value = "add new item to stock", nickname = "itemPost", notes = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "item already exists"),
            @ApiResponse(code = 401, message = "invalid 'amount' value")})
    @RequestMapping(value = "/item",
            method = RequestMethod.POST)
    ResponseEntity<Void> itemPost(@NotNull @ApiParam(value = "item number", required = true) @Valid @RequestParam(value = "item no", required = true) Integer itemNo
            , @NotNull @ApiParam(value = "item name", required = true) @Valid @RequestParam(value = "name", required = true) String name
            , @ApiParam(value = "item amount", defaultValue = "1") @Valid @RequestParam(value = "amount", required = false, defaultValue = "1") Integer amount
    );

}

