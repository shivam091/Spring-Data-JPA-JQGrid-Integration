#Spring-Data-JPA-JQGrid-Integration
=================
This repository contains example of integration of JQGrid with Spring Data JPA and Hibernate. This example will explain you many features integrated in it in later section.

###Import the project in Eclipse
1. Ensure Maven is installed
2. Open a command window (Windows) or a terminal (Linux/Mac)
3. Run the following command:

	mvn eclipse:eclipse -Dwtpversion=2.0

###Building with Maven
1. Ensure Maven is installed
2. Open a command window (Windows) or a terminal (Linux/Mac)
3. Run the following command:

	mvn tomcat:run
	
And browse to [http://localhost:8080/jqgrid/](http://localhost:8080/jqgrid/).
![Build Status](http://i1272.photobucket.com/albums/y389/harshal091/passing_zpsb61e9184.png?t=1408901662)

Compatibility/Tested:
* Chrome
* Works best on screen sizes greater than ~335px

### Usage

Simply clone, or download and unzip this repository and import it to eclipse as explained above. The relevant sections have been commented and explained in later sections of this file.

### Development

Requirements:
* [JQGrid](https://github.com/tonytomov/jqGrid)
* [Boostrap](http://getbootstrap.com/)
* [JQuery](http://jquery.com/)

The project uses:
* [Maven](http://maven.apache.org/)
* [Hibernate](http://hibernate.org/) 
* [Spring Data JPA](http://projects.spring.io/spring-data/)

![Screenshot](http://i1272.photobucket.com/albums/y389/harshal091/Github/JQGridStartTheme_zps4d4aa4d2.png)

###Features Integrated in example

1. Custom record text
2. Custom AJAX loader image
3. Change position of modal dialog boxes
4. Display current sort icon only instead of both sort icons
5. Toolbar search
6. JQuery input mask plug-in
7. Date picker
8. Loading dropdown with AJAX call
9. Toggle search toolbar
10. Multi-selection of elements in dropdown
11. Client/Server side custom validations
12. Sortable rows/columns
13. Bootstrap select support (Autocomplete)
14. Adding custom button in Col. Header
15. Animation of modal dialog boxes
16. Graying out readonly fields in modal dialogs
17. Seeting default filter in search toolbar
18. Changing font size of modal dialogs
19. Display custom icons in grid
20. Subgrid support
21. Cell coloring
22. Adding custom icons to Pager


