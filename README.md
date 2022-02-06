# Sort Manager

## Summary

An application that's purpose is to sort a random array of integers using either _bubble sort, merge sort or a
binary search tree_. 
The project is made in _Java_ with _Maven_. 
_Log4j2_ is used for logging, as well as _JUnit 5_ for unit testing.

## Setting up the project

1. Click the green code button on the repo page.

![CodeButtonImage](https://user-images.githubusercontent.com/48356710/152687720-c6429ebd-1806-4db0-b2ea-c5b6f2b1fe61.png)

2. Click the copy button to copy the url to your clipboard.

![CopyButtonImage](https://user-images.githubusercontent.com/48356710/152687728-e8a27445-ea8c-4140-8f66-013cca7b8e61.png)

3. Open up a terminal and navigate to a directory of your choice. Type 'git clone' then paste the url.

![GitCloneImage](https://user-images.githubusercontent.com/48356710/152687733-4b26cccb-bd4b-4141-94c5-35eca26fb860.png)

4. In IntelliJ click the file button at the top left then navigate to open.

![FileOpenImage](https://user-images.githubusercontent.com/48356710/152687736-ffee487a-e745-4fe8-b3cc-5d18d6478eab.png)

5. Navigate the directory you cloned the project and open it up.

![OpenProjectImage](https://user-images.githubusercontent.com/48356710/152687738-6300a606-21bb-44cd-8cf2-01355848c21f.png)

6. In the project view find SorterMain to run the project.

![OpenMainImage](https://user-images.githubusercontent.com/48356710/152687741-5da113dd-df5a-4470-9ea6-74797cd0eca0.png)

7. Run the main method and enjoy!

## Design

The application uses an _MVC_ design with the _model_, _view_ and _controller_ split into there
respective packages. It also incorporates an adapter pattern to allow the _binary search tree_ to work with the 
sorting algorithm interface.

## Testing

I tested all the algorithms as well as the SortManager controller class.
To test the algorithm I used parameterised test with the algorithm type as the parameter.

For the algorithms I tested the following conditions:

- A normal positive value array should be sorted
- A mixed positive and negative value array should be sorted
- A negative value array should be sorted
- An array full of zeros should remain the same
- An empty array should remain the same
- An array of null should throw a NullPointException

This resulted in a total of 18 tests cases collectively.

Algorithm Test Results:

![AlgorithmTestImage](https://user-images.githubusercontent.com/48356710/152694512-13b4a83d-e9a6-4dd2-8117-f3c24cd3f8ee.png)

![AlgorithmCoverageImage](https://user-images.githubusercontent.com/48356710/152694518-39b46e8c-b5e4-480b-9d2d-53c44cfb3098.png)

Sort Manager (Controller) Results:

![SortManagerImage](https://user-images.githubusercontent.com/48356710/152694516-910cfd2a-d4f1-4e7c-abe9-cab664da917e.png)

## Logging

The logging is outputted to the 'mylogfile.log' file which is generated upon running the application.

![LoggingFileImage](https://user-images.githubusercontent.com/48356710/152694633-d89e8dfc-5061-4076-8ff4-fc2bd4c8be8b.png)

## Screenshots

![ApplicationUseImage](https://user-images.githubusercontent.com/48356710/152694543-66ce5ea8-0914-40b9-a3f1-d6a9db493dcd.png)



