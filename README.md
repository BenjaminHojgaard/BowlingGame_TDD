# StringUtility / BowlingGame_TDD

## Reflection

### Computer mouse
#### Tests that I would run to ensure a high quality mouse.
- Durability (How sturdy it is. Should be able to be dropped on the floor without breaking).
- The laser of the mouse. (that the input from the mouse is properly captured by the PC).
- Latency (that the delay between moving the mouse in real-life to seeing movement on screen is minimal)
- The buttons (that a click is properly captured).
- Lifespan of the buttons (how many clicks a mouse can do before inputs are either not captured at all, or only some of the time)


### Catastrophic failure

" 
Rushed into development and production, the 737-MAX needed greater efficiency to keep its fuel costs as low as possible. To do this, it needed larger engines that could not be traditionally mounted on its wings. As a workaround, the larger engines were mounted further forward than normal, introducing a number of differences in the way it flies. To avoid the increased cost of pilot retraining for these new characteristics, Boeing instead implemented a system known as MCAS to mitigate these differences by automatically pushing the nose of the aircraft down when excessive angle of attack is detected. It was this software acting erroneously that led to the crash of two 737 MAX flights months apart: Lion Air flight 610 in October 2018 and Ethiopian Airlines flight 302 March 2019, claiming a combined total of 346 lives as the aircraft were forced into the ground by the MCAS system. 
" / https://listverse.com/2019/07/30/top-10-most-catastrophic-computer-failures-in-history/
- The article mentions that MCAS pushed the nose of the airplane too far down. Boeing already implemented a feature that corrected the airplane down, but they could've included a test, that checked if the 'angle of attack' was too far in the opposite direction. It seems that they had only accounted for one of at least two edge cases.

## Investigate JUnit 5 (Jupiter). Explain the following, and how they are useful.

### @Tag 
- Used to tag methods or classes which allows us to run only certain tests by using the @IncludeTags or @ExcludeTags annotations.

### @Disabled 
- Used to mark a test as disbabled, so that it won't run when running all tests. Useful when the requirements for some functionality has changed. Instead of deleting old tests we can 'archive' them by using @Disabled.

### @RepeatedTest
- Used to run a test X amount of times. Useful if we think the result of the test might be different depending on amount of times run.

### @BeforeEach, @BeforeAll
- BeforeEach runs a method before every test. BeforeAll runs a method ***once*** before all tests are run immediately after one another. So if you have 10 tests, BeforeEach would run 10 times, and BeforeAll would run 1 time. 
- BeforeEach is useful when we want to re-instantiate an object before every test if we think the state of the object changes, and we want the state to be reset every time a new test runs. BeforeAll is useful in the opposite case. If we have an instance of a class that only has methods then re-instantiating it won't help us when we run our tests. In this case instantiating the object ***once***, then run our tests.

### @AfterEach, @AfterAll
- AfterEach runs a method after every test. AfterAll runs a method ***once*** after all tests are done.
- AfterEach is useful when we want to do some cleanup after every test run. AfterAll is useful when we think it's necessary to do cleanup only when all the tests are done.

### @DisplayName
- DisplayName can be used to give a method or class a customised name other than the name we give it in the code when defining the method or class. This can help make it more readable if we have very long or complex names, or give it a more "business"-friendly name. If we have many tests that perform similar actions we can also just give a single class a @DisplayName(="Addition tests").

### @Nested 
- Used to annotate a class as being a nested test class. This helps when you want to have a hierachical view of your tests. It's useful for splitting tests out into features, or areas of similar business concerns.

### assumeFalse / assumeTrue
- Used for 'making an assumption' that something should evaluate to true or false. If either method returns false, the rest of the test method will not run, and will be marked as passed. Useful if we think that there is no reason to continue the test if some condition is not met.


## Mocking frameworks - Investigate mocking frameworks for your preferred language. Choose at least two frameworks, and answer the questions
- I chose Java as my preferred language, and I've chosen to compare Mockito and EasyMock.

### What are their similarities?
- Both frameworks have a similar approach where you first mock either a class or interface, you then perform some sort of logic, and lastly you verify the result of your test.
- They both use a similar .verify() method, to verify that a certain method was called.

### What are their differences?
- The main difference I suppose would be syntax/naming. In mockito you would say when(mock.method()).thenReturn(value); In EasyMock you would say EasyMock.expect(mock.method()).andReturn(true);


### Which one would you prefer, if any, and why?
As of now, I don't think I would prefer one or the other. Mockito has a larger community, but both largely seem to fulfill most criteria you could have of a mocking framework. If I had to pick one, it would be Mockito for the limited amount of experience I have with it, and the fact that it's the only supported mocking framework for Spring Boot (by default). https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing
