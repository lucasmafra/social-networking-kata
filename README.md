# Social Networking Kata

This is a Java implementation of a console-based social networking application.

This project was created for practice purposes and it is not intended to be used for real. 


## Kata Description
The exercise description can be checked [here](kata_description.txt).


## Build and Run

**System Requirements:** In order to build and run this project, is necessary to have Java 8 and Maven installed.

### Building the project
Open the terminal and from the project folder execute
```sh
mvn clean package
```

This will generate a *socialnetworking-0.0.1-SNAPSHOT.jar* file inside the *target* folder

### Runnning the project
After build the project, execute the command below to run the application:
 ```sh
 java -cp target/socialnetworking-0.0.1-SNAPSHOT.jar com.lucasmafra.socialnetworking.infrastructure.console.main.App
 ```

## About the implementation

* This application design was heavily inspired on [Clean Architecure](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html) by Uncle Bob.

* The core principle that led my design is *"Depend on abstractions, not on concretions"*. Because of
 that, I created some interfaces and abstraction layers that would not be necessary for the exercise completion. 
Still, I decided to follow this way to practice and see if I could get to a good design.

* That was not my first time practicing Clean Architecture and TDD. But it was my first time trying the
*Outside-in* approach! It introduced me some difficulties since I wasn't sure where to go in the first
 acceptance tests, but it led me to an unexpected cool new thing: as I was coding to pass in the 
 acceptance tests, I realized how the "package by layer" style that I was using was sort of inefficient,
  since I had to transverse many folders and layers just to get a feature done. So I decided to go back 
  to Clean Architecture's book and found this idea of *Ports and Adapters packaging* that I decided to 
  follow. And I'm going to explain that in the next bullet point!
* Basically, my code is composed of an "inside world" (domain) and an "outside world" (infrastructure),
 opposed to the "core, data and presentation" horizontal layering that I was used to follow. 
 The biggest benefit is that I'm grouping my files according to their use case (feature) but I'm still agnostic to the external world. 
 Here is a diagram that illustrates my application architecture:
 
 ![Architecture schema](social_networking_kata_architecture.png)
 
 
The \<**I**> symbol represents *interfaces*, while the \<**DS**> 
represent simple *data structures*. An arrow from A to B means that A 
knows about B but B does not know about A.

 ## To think about
 At some point of the development process, I moved the services 
 implementation to the infrastructure, and then I moved it back to the 
 domain. The same happened to the controller, view and view model classes. I would like to share my thoughts about that:
 * In the case of the service, I don't like the fact that it **implicitly** assumes some facts about the data layer. 
  For example, in order to retrieve the wall to the use case interactor, 
 the wall service gets the posts from the user, then his followings,
  then his followings posts and finally it combines the posts and return them.
  That's obviously a not so good strategy when we talk about performance. Let's say
  that our system now has many users and posts, and we decide to use the *reverse feed* strategy,
  or in another words, every time that someone you follow make a new post, the system create a reference
  of this new post somewhere in the storage dedicated to your wall. That would make much better
  to retrieve your wall when you ask for it, but how can we address that change in our code? We would certainly
  have to change our wall service method. So that's the problem: we would make a change inside our domain in the name of performance.
  It doesn't feel right to me. Yet, I'm not so confident about putting the service in
  the infrastructure package, since it does not **explicitly** know about the external world.
  
  * In the case of the presenters, controllers, views and view models,
  I'm still struggling with the fact I'm putting all of that inside the
  domain package. That's probably because I still have the "horizontal
   layering" model in my mind, so it's hard to see something that is apparently a detail, like the 
   view-model, inside the domain package. But since I was experimenting a new way of packaging, and
    mainly, I inverted the dependency and used the Humble Object pattern so the view details like the 
    output system are in the outside world, I decided to relieve that. But I still have a problem. 
    Let's say that we are building a web version of this Kata. Now, when we make a new post, we want to 
    show something in the browser, we want to give some user feedback. We wil certainly have to adapt 
    our use case, since with the current console application our use case does not present nothing. 
    But is that reasonable? Just because we are creating a new requirement for presenting, should we really change our domain?
    What about if we have, for the same use case, two different view models? How can we address that? Despite
    all of those questions, I decided to keep things as it is for now since I don't have any better solution beside
    falling back into the horizonal layering again.
      
 

