# Sort Manager Specification

### Phase 1
- [x] <span style="color:#9BDAFC"> Write a program which will take an array of ints and sort it using a bubble sort algorithm </span>
- [x] <span style="color:#B84F4F"> and then a merge sort algorithm. </span>
- [x] <span style="color:#7363F8"> Include JUnit tests for this and all subsequent phases (and all subsequent projects for the rest of time). </span>


### Phase 2

- [x] <span style="color:#31A3A3"> Update your project to use MVC and start to incorporate some of the design principle discussed earlier in the course (OOP, SOLID, design patterns). </span>
- [x] <span style="color:#CCDF32"> Create classes which implements MVC, including SortManager (controller) and a DisplayManager(view) classes. The code should include a basic factory pattern to determine which sorter to use. </span>
- [x] <span style="color:#7363F8"> Make sure packages are created properly and the structure follows the MVC pattern. </span>
- [x] <span style="color:#9BDAFC"> Create an interface which both sort classes can implement and make sure your application uses this interface where possible. </span>

### Phase 3
- [x] <span style="color:#B84F4F"> Add logging code into the Sort Manager project. </span>
- [x] <span style="color:#31A3A3"> Set up log4j in the project and add a properties file. </span>
- [x] <span style="color:#CCDF32"> Create logs at different levels and fully test the resulting output. Have output going to the console and to a log file created in the resources directory. </span>
- [x] <span style="color:#7363F8"> Ensure there are meaningful log messages added to the project and that they reflect the needs of the levels for which they are set. </span>

### Phase 4
- [x] <span style="color:#9BDAFC"> Integrate a new class to implement a binary search tree approach for sorting, so that the BST can be called in the same way as the other sort algorithms. </span>
- [x] <span style="color:#B84F4F"> The new class should implement the current Sorter interface. </span>
- [x] <span style="color:#31A3A3"> Add code that calls the BST and passes in the array that will be used to construct the tree and then return a sorted array. </span>
- [x] <span style="color:#CCDF32"> Use the Facade design pattern for this step and implement a nested class to represent a node in the tree. </span>

### Phase 5
- [x] <span style="color:#7363F8"> Add timing information to the project</span>
- [x] <span style="color:#9BDAFC"> and allow the user to select multiple algorithms to compare their performance. </span>