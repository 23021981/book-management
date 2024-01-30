# Pre-Requisite Software:

Apache Maven
JDK 11
Lombok plugin for compilation into IntelliJ IDEA.
Postman.

### In Memory database used H2Database.

*  BOOKDETAILS and INVENTORY tables used to hold book details and stock
* URL to H2 UI console. http://localhost:8071/h2
  
### List of End-Point
http://localhost:8071/bookStore/addBookDetail
http://localhost:8071/bookStore/getBookDetail/{bookId}
http://localhost:8071/bookStore/deleteBookDetail/{bookId}
http://localhost:8071/bookStore/updateBookDetail

http://localhost:8071/bookStore/getBookInventory/{bookId}
http://localhost:8071/bookStore/updateBookInventory


