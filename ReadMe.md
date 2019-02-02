h1 Steps to Run the Tests:

**For MAC or Linux**

* ./gradlew clean build parallel -Dbrowser=chrome -Ptags=@search

**For Windows**

* ./gradlew.bat clean build parallel -Dbrowser=chrome -Ptags=@search

**Tasks Covered:**

* The tasks covered are below:
* Search a product
* Add an item to cart
* verify Price
* Increase the number of items in the cart
* verifying the price change
* Removing one item in the cart
* Verifying the price change
* Reusable teardown method to clear the cart
* setup and teardown methods to start and close the browser