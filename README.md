# Revature Swagg Shop
This repository holds the cart microservice which handles:

- cart creation
- cart updates
- cart retrieval
- cart deletion
- cart item creation
- cart item updates
- cart item retrieval
- cart item deletion

These requests are handled by two controllers: **CartItemController and CartController**

There is a DevController but it is for development purposes only and should probably be phased out in future iterations.

Endpoints and methods are mapped out below.

### CartController

#### Endpoints
VERB | URL | USE
--- | --- | ---
POST | /cart | saves cart to db
GET | /carts/{id} | find carts by user id
GET | /cart/{id} | find cart by id
PUT | /cart | update cart
DELETE | /cart/{id} | delete cart


#### Methods

``` java
public Cart createCart(
      @ApiParam(value = "Cart object", required = true)
      @RequestBody Cart cart)
```

> Saves the Cart object to the database.

``` java
public List<Cart> getCartsByUserId(
    @ApiParam(value = "User ID", required = true)
    @PathVariable("id") int userId)
```

> Retrieves a list of Carts with the matching User ID.

``` java
public Cart getCartById(
    @ApiParam(value = "Cart ID", required = true)
    @PathVariable("id") int id)
```

> Retrieves an individual Cart by Cart ID.

``` java
public Cart updateCart(
    @ApiParam(value = "Cart object", required = true)
    @RequestBody Cart cart)
```

> Updates an already existing Cart based on Cart ID.

``` java
public void deleteCartById(
    @ApiParam(value = "Cart ID", required = true)
    @PathVariable("id") int id)
```

> Deletes a Cart from the database based on Cart ID.

### CartItemController

#### Endpoints

VERB | URL | USE
--- | --- | ---
POST | /cartitem | saves cartItem to db
GET | /cartitem/{id} | finds cartItem by id
GET | /cartitems/{id} | returns all cartItems by cart id
PUT | /cartitem | update cartItem
DELETE | /cartitem/{id} | delete cartItem


#### Methods

``` java
public CartItem createCartItem(@RequestBody CartItem ci)
```

> Saves the CartItem object to the database. If a CartItem with a matching Cart and Product ID already exists in the database the existing CartItem will add the passed CartItem's quantity to its own.

``` java
public CartItem getCartItemById(
    @ApiParam(value = "CartItem ID", required = true)
    @PathVariable("id") int id)
```

> Gets the CartItem object based on the CartItem ID.

``` java
public List<CartItem> getAllCartItems(
    @ApiParam(value = "Cart ID", required = true)
    @PathVariable("id") int cartId)
```

> Returns all CartItems that have the matching Cart by Cart ID

``` java
public CartItem updateCartItem(
    @ApiParam(value = "CartItem", required = true)
    @RequestBody CartItem ci)
```

> Updates the CartItem object in the database.

``` java
public void deleteCartItemById(
    @ApiParam(value = "CartItem ID", required = true)
    @PathVariable("id") int id)
```

> Deletes the CartItem object from the database based on CartItem ID
