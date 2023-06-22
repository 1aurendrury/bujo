# The Pitch
- Are you completely and utterly lost with what to do with your life after OOD? Do you find yourself wondering hopelessly what you can do with the rest of your summer? Well do we have the perfect app for you! Introducing PA05 Bullet Journal! With this bullet journal, you can organize your life on a week-to-week basis, adding tasks and events for each day to maximize your productivity and fun. Pick your own theme to feel at home in your planner, now featuring NHL teams! Change fonts, colors, and text effects to add excitement to your day! Effortlessly add tasks and events, motivate yourself with a daily quote, and monitor your progress as you complete tasks left and right! Summer has never been more productive until now!


# Examples

- ![SC 1](/src/main/resources/sc1.png?raw=true)
- ![SC 2](/src/main/resources/sc2.png?raw=true)
- ![SC 3](/src/main/resources/sc3.png?raw=true)
- ![SC 4](/src/main/resources/sc4.png?raw=true)
- ![SC 5](/src/main/resources/sc5.png?raw=true)



# Solid SOLIDs
## Single Responsibility

- Within our project, we applied the single responsibility principle by first breaking our project into three modules: model, view, and controller. We then split each module into a set number of classes, all having to do with a single object (ex. Task, Event, Theme in Model) or a specific set of functionality (Controller contains the handlers, View loads the scene). This way, each class has its own distinct responsibilty within the project, and communicates with other parts through the controller, so that functionality is spread out.
## Open/Closed

- We applied the open/closed principle by creating our interfaces first before any classes and inserting the methods necessary for the classes to run (ex. run in controller, load in view). This way, classes are created with their interface in mind and don't add to the interface as they are further developed. We knew our three major classes (model, view, controller) needed a set number of methods, with the rest being project/class specific and thus left those out of the controller. This way, we can create new interfaces for new methods in the future and leave our three main interfaces closed for modification.
## Liskov Substitution Principle

- Liskov Substitution was not directly applied in our project as we did not use any abstract classes in our development.
## Interface Segregation

- Our project showcased the interface segregation principle by limiting our interfaces to what the implemented classes only needed. We made this happen by creating interfaces before our classes, and then letting class-specific methods be implemented without adding them to their respective interfaces. To stay in line with the open/closed principle, any future interfaces would be created on their own and contain methods for a class to use, instead of modifying existing interfaces. This ensured in our project that interfaces contained essential methods for all of its classes and that new interfaces were created when classes became more niche and unique.
## Dependency Inversion

- Dependency inversion was followed within our project as we created the classes within our three modules. In our view module, the main view class was designed so that it can load any scene, not just a specific one. Our controller was created such that new buttons/functionality and their subsequent handlers could be added in easily, as well as our handlers being designed in such a way that adding new tasks, events, or fonts/colors won't require altering the existing handlers. Furthermore, our model module was designed such that the main class can easily implement new methods for new functionality (adding something beyond tasks and events) and its smaller classes (ex. Day, Event) were created such that new fields and properties can easily be added or subclasses can be created that derive from these classes. Overall, we tried to use as little concrete hardcoding as possible and put emphasis on the use of interfaces and extension where possible.




# Further Implementation...

- One possible feature we can add in the future due to our design choices are a splash screen/password protection screen before the journal is opened. As we minimized the code in our viewer class and left it open to extension, we can utilize this class to load a splash screen first, then a password screen, followed by the bujo file once the user has successfully entered the correct password. This could be done by creating new Scenes in the view class (or through SceneBuilder) and simply loading them in the aforementioned order in controller's run() method. We could also implement progress bar easily, as our Task class in model and controller class can work together in MVC fashion to create a new ProgressBar that represents the number of tasks out of the total tasks that are complete. This would be done by creating a master list of tasks in the task queue, and simply adding an event handler to a progress bar to update the progress as tasks are completed in controller.


# Image Attributions
- NEU black (https://hoopdirt.com/lee-joins-northeastern-basketball-staff-as-graduate-assistant/)
- NEU red(https://wallpapers.com/wallpapers/northeastern-university-huskies-logo-1vgi2eckruh5rly1.html)
- Black background (https://stock.adobe.com/search?k=%22black+wallpaper%22&asset_id=398358705)
- White background(https://www.freepik.com/free-vector/white-abstract-background_11852427.htm#query=white%20background&position=20&from_view=keyword&track=ais)
- Leafs (https://www.wallpaperflare.com/hockey-toronto-maple-leafs-wallpaper-tfckf)
- Bruins(https://www.peakpx.com/en/hd-wallpaper-desktop-ayhfh)
- Stars (https://wall.alphacoders.com/big.php?i=859129)
- Flyers (https://www.sgclark.com/wallpapers/nhl/nhl_philadelphia_flyers_home/)
