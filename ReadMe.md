# Decathalon SDET Challenge  

## Steps to Run the Tests:

**Pre-Requisite**
* Install Java8 manually and verify installation by following command.
* Run `java -version`
* Output should be `java version "1.8.0_XXX"` 

1. Clone the project locally in your machine. Run the following command in your terminal
    * `git clone https://github.com/purush087/decathalon_challenge.git`
    
2. Change your directory to `decathalon_challenge`. Run following command for this
    *  `cd decathalon_challenge`

3. Run the Tests:
**MAC or Linux :: using gradle wrapper configuration**

* Run `./gradlew clean build parallel -Dbrowser=chrome -Ptags=@search`

**Windows :: To run using gradle wrapper configuration**

* Run `./gradlew.bat clean build parallel -Dbrowser=chrome -Ptags=@search`

**To Run using Gradle in your local machine:**

**MAC:**
* run `brew install gradle`

**Linux**
* Download gradle binary from `https://gradle.org/releases`
* run Following commands
    ```
       mkdir /opt/gradle
       unzip -d /opt/gradle gradle-5.1.1-bin.zip
       ls /opt/gradle/gradle-5.1.1
    ```
* set Path in .bashrc `export PATH=$PATH:/opt/gradle/gradle-5.1.1/bin`
* Verify installation of gradle by `gradle -v`. Output shoul be similar to

```

    ---------------------------------------------------------
    Gradle 5.0
    ------------------------------------------------------------
    
    Build time:   2018-11-26 11:48:43 UTC
    Revision:     7fc6e5abf2fc5fe0824aec8a0f5462664dbcd987
    
    Kotlin DSL:   1.0.4
    Kotlin:       1.3.10
    Groovy:       2.5.4
    Ant:          Apache Ant(TM) version 1.9.13 compiled on July 10 2018
    JVM:          1.8.0_161 (Oracle Corporation 25.161-b12)
    OS:           Mac OS X 10.14.1 x86_64
    
``` 


* Now Navigate to **`cd decathalon_challenge`**.

* run **`gradle clean build parallel -Dbrowser=chrome -Ptags=@search`**


####Note : All the necessary dependencies will be automatically downloaded by running `gradle clean build`.

**Tasks Covered:**

* Search a product
* Add an item to cart
* verify Price
* Increase the number of items in the cart
* verifying the price change
* Removing one item in the cart
* Verifying the price change
* Reusable teardown method to clear the cart
* setup and teardown methods to start and close the browser
