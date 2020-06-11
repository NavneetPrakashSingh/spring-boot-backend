

# NotifyMe
<table>
<tr>
  <td><img src="https://raw.githubusercontent.com/NavneetPrakashSingh/spring-boot-backend/dev/docs/icon.png"></td>
<td>
  A product that will help you increase user engagement by leveraging the use of notifications. It's simple to generate, add and use the notifications without writing complicated code for you website. First step is to customize your notifications by adjusting parameters related to the notification (background color,etc). Second step is to get the auto-generated script. Last step is to the script to your website. You can decide when to show the notification to the user and design your entire timeline associated with it.  
</td>
</tr>
</table>



## Approach taken to implement the project

### Step1: Working on the architectural diagram

The first approach I take even before drawing the architectural diagram, is to make sure that the requirements related to the project is understood properly. Once the requirements are understood well, it becomes easy to visualize things. The next step I take is to create the architectural diagram associated with it.

#### Creating the high-level architecture
High level architecture diagram does not include any low level details. It mainly deals with the structure of the application. It revolves around dividing the applicaiton into different layers ( presentation, business and data layer). The main advantage of creating layers for the project is that incase, the project structure is to be changed in future to another structure like microservice architecture, it becomes easy for transition it to a module based architecture to microservice based architecture. Below is the high-level architecture implemented for this project:
<img src="https://raw.githubusercontent.com/NavneetPrakashSingh/spring-boot-backend/master/docs/HighLevelOverview.png">
Within the above diagram, we can see that the entire project is divided into different modules and sub-modules. Each module representing a part of layer ( presentation, business or data layer). Together these layers form the main crux of the project. Presentation layer defines the APIs which include controllers. Business layer defines the main logic of the application. Data layer defines the way how the data interacts with the business layer and finally we have our QA/test layer, where all the test are written for test driven development approach.

#### Creating the low-level architecture
Once there was a brief understanding of how the project would be divided, the next step was to implement the low-level architecture for the project. This is where the flow of application is seen in the form of classes and objects. This is where the the use of design patters, SOLID principles is defined. Consider the following low-level architecture diagram created for this project:
<img src="https://raw.githubusercontent.com/NavneetPrakashSingh/spring-boot-backend/master/docs/LowLevelArchitecture.png">


### Landing Page
Currently it is working on all NSE (India) Stocks, BSE (India) Stocks Symbol will be added soon.

![](https://iharsh234.github.io/WebApp/images/demo/web_app_face.JPG)

### Query Filled Form
![](https://iharsh234.github.io/WebApp/images/demo/demo_query.JPG)

### Charts
![](https://iharsh234.github.io/WebApp/images/demo/demo_chart1.JPG)
![](https://iharsh234.github.io/WebApp/images/demo/demo_chart2.JPG)
![](https://iharsh234.github.io/WebApp/images/demo/demo_chart3.JPG)


## Mobile support
The WebApp is compatible with devices of all sizes and all OS's, and consistent improvements are being made.

![](https://iharsh234.github.io/WebApp/images/demo/mobile.png)




## [Usage](https://iharsh234.github.io/WebApp/) 

### Development
Want to contribute? Great!

To fix a bug or enhance an existing module, follow these steps:

- Fork the repo
- Create a new branch (`git checkout -b improve-feature`)
- Make the appropriate changes in the files
- Add changes to reflect the changes made
- Commit your changes (`git commit -am 'Improve feature'`)
- Push to the branch (`git push origin improve-feature`)
- Create a Pull Request 

### Bug / Feature Request

If you find a bug (the website couldn't handle the query and / or gave undesired results), kindly open an issue [here](https://github.com/iharsh234/WebApp/issues/new) by including your search query and the expected result.

If you'd like to request a new function, feel free to do so by opening an issue [here](https://github.com/iharsh234/WebApp/issues/new). Please include sample queries and their corresponding results.


## Built with 

- [jQuery - Ajax](http://www.w3schools.com/jquery/jquery_ref_ajax.asp) - jQuery simplifies HTML document traversing, event handling, animating, and Ajax interactions for rapid web development.
- [Google Chart API](https://developers.google.com/chart/interactive/docs/quick_start) - Free , Rich Gallery , Customizable and Cross-browser compatible.
- [Bootstrap](http://getbootstrap.com/) - Extensive list of components and  Bundled Javascript plugins.


## To-do
- Add BSE (India) Symbol to the current App.
- Decide comparison models of Stocks. (suggestions are most welcome).
- Another WebApp, capable of comparing at least 10 stocks.

## Team

[![Harsh Vijay](https://avatars1.githubusercontent.com/u/12688534?v=3&s=144)](https://github.com/iharsh234)  | [![Quandl.com](https://github.com/iharsh234/WebApp/blob/master/images/quandl.jpg)](https://www.quandl.com/)
---|---
[Harsh Vijay ](https://github.com/iharsh234) |[Quandl](https://www.quandl.com)

## [License](https://github.com/iharsh234/WebApp/blob/master/LICENSE.md)

MIT © [Harsh Vijay ](https://github.com/iharsh234)

