#Spring-Data-JPA-JQGrid-Integration
========
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

##Downloads
Source is hosted at the [Spring-Data-JPA-JQGrid-Integration GitHub repository](https://github.com/shivam091/Spring-Data-JPA-JQGrid-Integration.git). 
Downloads are also available on the [GitHub project's Downloads section] (https://github.com/shivam091/Spring-Data-JPA-JQGrid-Integration/archive/master.zip)

##Dependencies
######javax.servlet-api:3.0.4
######servlet-api:2.5
######jsp-api:2.1
######jstl:1.2
######cglib-nodep:2.2
######commons-dbcp:1.4
######javassist:3.12.1.GA
######jackson-mapper-asl:1.9.9
######jackson-core-asl:1.9.9
######jackson-databind:2.3.2
######jackson-annotations:2.3.0
######spring-context:4.0.1.RELEASE
######spring-core:4.0.1.RELEASE
######spring-web:4.0.1.RELEASE
######spring-webmvc:4.0.1.RELEASE
######spring-orm:4.0.1.RELEASE
######spring-tx:4.0.1.RELEASE
######spring-jdbc:4.0.1.RELEASE
######spring-test:4.0.1.RELEASE
######spring-data-jpa:1.4.1.RELEASE
######hibernate-entitymanager:4.3.5.Final
######hibernate-core:3.6.5.Final
######hibernate-validator:4.1.0.Final
######mysql-connector-java:5.1.22
######dom4j:1.5
######commons-io2.4
######commons-fileupload:1.3

![Screenshot](http://i1272.photobucket.com/albums/y389/harshal091/Github/JQGridStartTheme_zps4d4aa4d2.png)

###Features Integrated in example

1. Custom record text
2. Custom AJAX loader image
3. Change position of modal dialog boxes
4. Display current sort icon only instead of both sort icons
5. Toolbar search
6. JQuery input mask plug-in
7. Date picker
8. Loading dropdown items dynamically
9. Toggle search toolbar
10. Multi-select dropdown
11. Client/Server side custom validations
12. Bootstrap select support (Autocomplete)
13. Adding custom button in Col. Header
14. Animation of modal dialog boxes
15. Graying out readonly fields in modal dialogs
16. Setting default filter in search toolbar
17. Changing font size of modal dialogs
18. Display custom buttons in pager
19. Subgrid support
20. Cell coloring
21. Adding required field (*) notation to modal dialogs
22. Column chooser
23. Adding icons in grid cell

###**Lets take a look at each feature:**

####Custom record text

We can easily override default *recordtext* property to have our own record text to be displayed on the right side of pager with:

```HTML
	recordtext : 'Person/People {0} - {1} of {2}'
```
By default, value of recordtext is *recordtext: "View {0} - {1} of {2}"*

####Custom AJAX loader icon

We can display custom icon instead of default *Loading...* by setting *loadtext : ''* and writing custom CSS as:

```HTML
	$('#grid_id').jqGrid({
		...,
		...,
		colNames : [
		],
		colModel : [
		],
		...,
		...,
		loadtext : '',
		...,
		...,
	});
	
```
```HTML
	.ui-jqgrid .loading {
		background: url(../../img/ajax-loader.gif) repeat transparent;
		background-color: transparent;
		border-style: none;
		background-repeat: no-repeat;
		height: 200px;
		width: 100px;
	}
```

![Screenshot](http://i1272.photobucket.com/albums/y389/harshal091/Github/customloadingImage_zps0e4a2de5.png)

####Change position of modal dialogs

We can change default left position of modal dialogs to whereever we want by adding small code snippet to *beforeShowForm* function as shown bellow:

```HTML
	...,
	...,
	beforeShowForm : function(form) {
		$('#pData').hide();
		$('#nData').hide();
		var dlgDiv = $("#editmod" + "myGrid");
		var parentDiv = dlgDiv.parent();
		var dlgWidth = dlgDiv.width();
		var parentWidth = parentDiv.width();
		var dlgHeight = dlgDiv.height();
		var parentHeight = parentDiv.height();
		// TODO: change parentWidth and parentHeight in case of the grid
		//       is larger as the browser window
		dlgDiv[0].style.top = Math.round((parentHeight - (dlgHeight - 150)) / 2) + "px";
		dlgDiv[0].style.left = Math.round((parentWidth - dlgWidth + 130) / 2) + "px";
	},
	...,
	...,
```
![Screenshot](http://i1272.photobucket.com/albums/y389/harshal091/Github/AddRecordForm_zps5e57a4c1.png)

####Displaying only current sortable icon instead of both sort icons

By default, we see both ascending and descending sort icons on col. header.
We can hide them alternatively. i.e., when we sort records in ascending order, sort icon of descending order is hidden and viceversa. 

We can easily achive this by following additions:

```HTML
	$('#grid_id').jqGrid({
		...,
		...,
		colNames : [
		],
		colModel : [
		],
		...,
		...,
		...,
		...,
		onSortCol : function(index, idxcol, sortorder) {
			var $icons = $(this.grid.headers[idxcol].el).find(">div.ui-jqgrid-sortable>span.s-ico");
			if (this.p.sortorder === 'asc') {
				//$icons.find('>span.ui-icon-asc').show();
				$icons.find('>span.ui-icon-asc')[0].style.display = "";
				$icons.find('>span.ui-icon-desc').hide();
			} else {
				//$icons.find('>span.ui-icon-desc').show();
				$icons.find('>span.ui-icon-desc')[0].style.display = "";
				$icons.find('>span.ui-icon-asc').hide();
			}
		},
	});
	
	$('#gbox_'+ $.jgrid.jqID($('#myGrid')[0].deviceId) + 
	' tr.ui-jqgrid-labels th.ui-th-column>div.ui-jqgrid-sortable>span.s-ico')
	.each(function() 
		{$(this).find('>span.ui-icon-' + 
		($('#myGrid').jqGrid('getGridParam','sortorder') === 'desc' ? 'asc': 'desc')).hide();
	});
```

To avoid css conflicts, we need overrride following css styles:

```HTML
	/* changing icon of sort icon also makes the header icons red */
	.searchResults .ui-state-default .ui-grid-ico-sort.ui-icon {
		background-image: url("../images/ui-icons_cd0a0a_256x240.png");
	}
	
	/* centers the icons when only one icon is showing and the other is hidden */
	.searchResults .ui-jqgrid .ui-icon-asc, .searchResults .ui-jqgrid .ui-icon-desc {
		height: 12px;
		margin-top: 0px;
	}
	
	/* hides the inactive sort icon */
	.searchResults .ui-state-disabled.ui-icon-desc, .searchResults .ui-state-disabled.ui-icon-asc {
		display: none;
	}
```

####Toolbar search

Following script snippet is used to enable search toolbar in our grid:

```HTML
	$('#grid_id').jqGrid({
		...,
		...,
		colNames : [
		],
		colModel : [
		],
		...,
		...,
		...,
		...,
	});
	
	$("#myGrid").jqGrid(
		'filterToolbar', {
			autosearch : true,
			searchOperators : true,
			stringResult : true,
			searchOnEnter : true,
			defaultSearch : "eq",
			afterSearch : function() {
				if ($('.ui-search-toolbar', this.grid.hDiv).is(':visible')) {
					$('.ui-search-toolbar', this.grid.fhDiv).show();
				}
			},
			beforeSearch : function() {
	
			}
	});
```

####Toogle search toolbar

After inserting above snippet to our grid, we can also add custom button to *pager* to hide search toolbar when it's not needed.
Following script snippet is used to add custom button on pager and to apply action to it:

```HTML
	$('#grid_id').jqGrid({
		...,
		...,
		colNames : [
		],
		colModel : [
		],
		...,
		...,
		...,
		...,
	});
	
	$("#myGrid").navButtonAdd(
		'#pager', {
			caption : "",
			title : "Toggle Search Toolbar",
			buttonicon : 'ui-icon-pin-s',
			onClickButton : function() {
				this.toggleToolbar();
				if ($.isFunction(this.p._complete)) {
					if ($('.ui-search-toolbar', this.grid.hDiv).is(':visible')) {
						$('.ui-search-toolbar', this.grid.fhDiv).show();
					} else {
						$('.ui-search-toolbar', this.grid.fhDiv).hide();
					}
					this.p._complete.call(this);
					fixPositionsOfFrozenDivs.call(this);
				}
			}
	});
```

#### JQuery input mask plug-in

To apply input mask in the fields of grid, we must first import *jquery.maskedImput.js* to our JSP. The latest version of plug-in can be downloaded from [jQuery Masked Input](http://plugins.jquery.com/maskedinput/).
After importing this plug-in, we can have small snippet as shown bellow to have masked inputs:

```HTML
	$('#grid_id').jqGrid({
		...,
		...,
		colNames : ['Mobile Number',...,
		],
		colModel : [ {
			name : '',
			index : '',
			editrules : {
			},
			editoptions : {
				size : 10,
				dataInit : function(elem) {
					$(elem).mask("9999999999");
				}
			},
			searchoptions : {
				sopt : [ 'eq' ],
				size : 10,
				dataInit : function(elem) {
					$(elem).mask("9999999999");
				}
			},
		},],
		...,
		...,
		...,
		...,
	});
```
The following mask definitions are predefined:
* a - Represents an alpha character (A-Z,a-z)
* 9 - Represents a numeric character (0-9)
* * - Represents an alphanumeric character (A-Z,a-z,0-9)

Following are the example and details of commonly used masks:

1. *999999999*: 10 digit mobile number of format **1234567890**
2. *999-999-9999*: 10 digit mobile number of format **123-456-7890**
3. *(999) 999-9999*: 10 digit mobile number of format **(123) 456-7890**
4. *99/99/9999*: Date of format **dd/mm/yyyy**
5. *(999) 999-9999? x99999*: Anything listed after '?' within the mask is considered optional user input. The common 	example for this is phone number + optional extension of format **(655) 656-6565 x99999**
6. *a*-*999-a999*: Product key of format **aa-988-a222**
7. *999-99-9999*: SSN Number of format **123-45-6789**
8. *99-9999999*: Tax ID of format **12-1234567**

You can google to get more examples. :stuck_out_tongue_closed_eyes:

#### Date picker

You can integrate date picker to your grid by adding following script snippet:

```HTML
	$(function() {
		initDateWithButton = function(elem) {
			if (/^\d+%$/.test(elem.style.width)) {
				// remove % from the searching toolbar
				elem.style.width = '';
			}
			// to be able to use 'showOn' option of datepicker in advance searching dialog
			// or in the editing we have to use setTimeout
			setTimeout(function() {
				$(elem).datepicker({
					dateFormat : 'dd.mm.yy',
					showOn : 'button',
					changeYear : true,
					changeMonth : true,
					showWeek : true,
					showButtonPanel : false,
					onClose : function(dateText, inst) {
						inst.input.focus();
					}
				});
				$(elem).next('button.ui-datepicker-trigger').button({
					text : false,
					icons : {
						primary : 'ui-icon-calculator'
					}
				}).css({
					fontSize : '0.9em',
					width : '1.7em'
					}).find('span.ui-button-text').css({
						padding : '0.1em'
					});
				}, 100);
		},
	
		dateTemplate = {
			align : 'center',
			sorttype : 'date',
			editable : true,
			formatter : 'date',
			formatoptions : {
				newformat : 'd.m.Y'
			},
			datefmt : 'd.m.Y',
			editoptions : {
				dataInit : initDateWithButton,
				size : 10
			},
			searchoptions : {
				sopt : [ 'eq' ],
				dataInit : initDateWithButton,
				size : 10, // for the advanced searching dialog
				attr : {
					size : 10
				}
					// for the searching toolbar
			}
	};
```
and adding *template : dateTemplate* to main grid script:
```HTML
	$('#grid_id').jqGrid({
			...,
			...,
			colNames : ['Date of Birth',...,
			],
			colModel : [ {
				name : '',
				index : '',
				editrules : {
				},
				template : dateTemplate,
				search : true
			},],
			...,
			...,
			...,
			...,
		});
```
![Screenshot](http://i1272.photobucket.com/albums/y389/harshal091/Github/DatePickerSupport_zps96ac7e72.png)

####Loading dropdown items dynamically

Generally, we hard code the items of dropdown but in some cases, viz., list of countries, states, cities, etc. we can't hard code items of drop down. In such case, we can use *dataUrl* of JQGrid plugin to dynamically load it from web service.

Only the thing we have to take care of it our web service must return JSON response having HTML select statement as:

```HTML
	<select><option value='Select State'>Select State</option><option value='Andaman and Nicobar Islands'>Andaman 	and Nicobar Islands</option><option value='Andhra Pradesh'>Andhra Pradesh</option><option value='Arunachal 			Pradesh'>Arunachal Pradesh</option><option value='Assam'>Assam</option><option 						value='Bihar'>Bihar</option><option value='Chhattisgarh'>Chhattisgarh</option><option value='Dadra and 		Nagar Haveli'>Dadra and Nagar Haveli</option><option value='Daman and Diu'>Daman and Diu</option><option 		value='Delhi'>Delhi</option><option value='Goa'>Goa</option><option value='Gujrat'>Gujrat</option><option 		value='Haryana'>Haryana</option><option value='Himachal Pradesh'>Himachal Pradesh</option><option 			value='Jammu and Kashmir'>Jammu and Kashmir</option><option value='Jharkhand'>Jharkhand</option><option 	value='Karnataka'>Karnataka</option><option value='Kerala'>Kerala</option><option 					value='Lakshadweep'>Lakshadweep</option><option value='Madhya Pradesh'>Madhya Pradesh</option><option 			value='Maharashtra'>Maharashtra</option><option value='Manipur'>Manipur</option><option 				value='Meghalaya'>Meghalaya</option><option value='Mizoram'>Mizoram</option><option 				value='Nagaland'>Nagaland</option><option value='Orissa'>Orissa</option><option 					value='Pondicherry'>Pondicherry</option><option value='Punjab'>Punjab</option><option 					value='Rajasthan'>Rajasthan</option><option value='Sikkim'>Sikkim</option><option value='Tamil Nadu'>Tamil 	Nadu</option><option value='Tripura'>Tripura</option><option value='Uttar Pradesh'>Uttar Pradesh</option><option 	value='Uttarakhand'>Uttarakhand</option><option value='West Bengal'>West Bengal</option></select>
```
after having this kind of JSON, you can load it to you dropdown as shown bellow:

```HTML
	$('#grid_id').jqGrid({
		...,
		...,
		colNames : ['State',...,
		],
		colModel : [ {
			name : '',
			index : '',
			editrules : {
			},
			edittype : 'select',
			stype : 'select',
			editoptions : {
				dataUrl : './person/getStateList.json',
				dataEvents : [ {
					type : 'change',
					fn : function(e) {
					
					}
			} ],
			},
			searchoptions : {
				searchoptions : {
					sopt : [ 'eq' ],
					dataUrl : './person/getStateList.json',										}
			},
		},],
		...,
		...,
		...,
		...,
	});
```

####Multi-select dropdown

To have multi- selection of elements in dropdown, we must first build JSON containing HTML <select> and <optgroup> tags as given bellow:

```HTML
	<select><option value='C'>C</option><option value='C++'>C++</option><optgroup label='J2SE'><option value='Multithreading'>Multithreading</option><option value='Collections'>Collections</option><option value='Networking'>Networking</option><option value='Swing'>Swing</option></optgroup><optgroup label='J2EE'><option value='JDBC'>JDBC</option><option value='Servlet'>Servlet</option><option value='JSP'>JSP</option><option value='EJB'>EJB</option><option value='Web Services'>Web Services</option></optgroup><option value='C#'>C#</option><option value='HTML'>HTML</option><option value='JavaScript'>JavaScript</option><option value='CSS'>CSS</option><option value='JQuery'>JQuery</option><option value='Joomla'>Joomla</option><option value='Python'>Python</option></select>
```

and after having this kind of JSON, you can load it to dropdown by setting *multiple* editoptions to *true* as bellow:

```HTML
	$('#grid_id').jqGrid({
		...,
		...,
		colNames : ['Skills',...,
		],
		colModel : [ {
			name : '',
			index : '',
			editrules : {
			},
			edittype : 'select',
			stype : 'select',
			editoptions : {
				dataUrl : ''./person/getSkillsList.json',',,
				multiple : true,
				size : 100,
			} ],
			}
		},],
		...,
		...,
		...,
		...,
	});
```

####Bootstrap select support

To integrate bootstap select to our grid, we must first import select2.js and select2.css in out project (provided with this repositoryin /bootstrap). After importing it to our script, we can have script snippet as bellow:

```HTML
	$('#grid_id').jqGrid({
		...,
		...,
		colNames : ['State',...,
		],
		colModel : [ {
			name : '',
			index : '',
			editrules : {
			},
			edittype : 'select',
			stype : 'select',
			editoptions : {
				dataUrl : './person/getStateList.json',
				dataEvents : [ {
					type : 'change',
					fn : function(e) {

					}
				} ],
				dataInit : function(element) {
					$(element).width(165).select2({
						// add "ui-widget" class to have the same font-family like in jQuery 							UI Theme
						// add "ui-jqdialog" class to have font-size:11px like in other items 						of jqGrid form
						dropdownCssClass : "ui-widget ui-jqdialog"
				});
			}
			} ],
			},
			searchoptions : {
				searchoptions : {
					sopt : [ 'eq' ],
					dataUrl : './person/getStateList.json',										}
			},
		},],
		...,
		...,
		...,
		...,
	});
```
![Screenshot](http://i1272.photobucket.com/albums/y389/harshal091/Github/BootstrapSelectSupport_zps5e317986.png)

####Adding custom buttons in Col.Header

We can add custom button to Col.Header of our grid and assign it action for later. We just want to add following script snippet to our script file:

```HTML
	$('#grid_id').jqGrid({
		...,
		...,
		colNames : [
		],
		colModel : [
		],
		...,
		...,
		...,
		...,
	});
	...
	...
	...
	$('#grid_id').closest("div.ui-jqgrid-view").
		find("div.ui-jqgrid-hdiv table.ui-jqgrid-htable tr.ui-jqgrid-labels > th.ui-th-column > 				div.ui-jqgrid-sortable")
            .each(function () {
                $('<button>').css({ height: "17px" }).appendTo(this).button({
                    icons: {
                        primary: "ui-icon-gear"
                    },
                    text: false
                }).click(function (e) {
                    var idPrefix = "jqgh_" + $('#grid_id')[0].id + "_",
                        thId = $(e.target).closest('div.ui-jqgrid-sortable')[0].id;
                    // thId will be like "jqgh_list_name"
                    if (thId.substr(0, idPrefix.length) === idPrefix) {
                        alert('Clicked the button in the column "' + thId.substr(idPrefix.length) + '"');
                        return false;
                    }
                });
            });
```
You can have a look at our grid screenshot which I have uploaded earlier in this file.

####Animation of modal dialog boxes

We can apply animation effects to modal dialogs in the grid by writting following small script snippet:

```HTML
	/* To animate add, update, and delete modals */
	$.extend($.jgrid, {
		showModal : function(h) {
			h.w.show("slow");
		},
		closeModal : function(h) {
			h.w.hide("slow").attr("aria-hidden", "true");
			if (h.o) {
				h.o.remove();
			}
		}
	});
	
	/* To animate column chooser modal */
	$.extend(true, $.jgrid.col, {
		width : 450,
		modal : true,
		msel_opts : {
			dividerLocation : 0.5
		},
		dialog_opts : {
			minWidth : 470,
			show : 'blind',
			hide : 'explode'
		}
	});
	...
	...
	...
	...
	$('#grid_id').jqGrid({
		...,
		...,
		colNames : [
		],
		colModel : [
		],
		...,
		...,
		...,
		...,
	});
```

#### Column Chooser

We can limit number of columns to be displayed in the grid by using column chooser. To have column chooser in our grid, we must first import ui.multiselect.js and ui.multiselect.css in our main script. After importing these two files, we must add following script snippet to our grid:

```HTML
	$('#grid_id').navButtonAdd (
	'#pager', {
	       caption: "", 
		buttonicon: "ui-icon-calculator", 
		title: "Choose columns",
	        onClickButton: function() {
	                $('#grid_id').jqGrid('columnChooser', {
			done: function(perm) {
				if (perm) {
	                        $('#grid_id').jqGrid("remapColumns", perm, true);
	                        } else {
	                        }
	                }
	         }
		);
	}
	});
```

This will add custom icon to pager and clicking on it, will launch column chooser.

![Screenshot](http://i1272.photobucket.com/albums/y389/harshal091/Github/ColumnChooserSupport_zps2224ddea.png)

####Changing font-size of modal dialogs

We can change font-size of modal dialogs by simply adding following CSS snipet to our custom CSS file.

```HTML
	/* To change font size of edit form */
	.ui-jqdialog {
		font-size: 10px; //font-size (whatever you feel good)
	}
```
####Subgrid support

We can have any number of grids within main grid. Here we have only one grid within our main grid. To have subgrid, we need set *subgrid : true* and *subGridRowExpanded : function (subgrid_id, row_id)* as shown in following script snippet:

```HTML
	$('#grid_id').jqGrid({
		...,
		...,
		colNames : [
		],
		colModel : [
		],
		...,
		...,
		...,
		...,
		subGrid: true,
		subGridRowExpanded: function(subgrid_id, row_id) {
		/* any data or even a grid just like main grid */
		/* in our example following--> */
			var personName = $('#grid_id').jqGrid('getCell', row_id, 'personName');
			var personBirthDate = $('#grid_id').jqGrid('getCell', row_id, 'personBirthDate');
			var personEmailId = $('#grid_id').jqGrid('getCell', row_id, 'personEmailId');
			var personMobileNumber = $('#grid_id').jqGrid('getCell', row_id, 'personMobileNumber');
			var personDesignation = $('#grid_id').jqGrid('getCell', row_id, 'personDesignation');
			var personState = $('#grid_id').jqGrid('getCell', row_id, 'personState');
			var personCity = $('#grid_id').jqGrid('getCell', row_id, 'personCity');
			var personPostalCode = $('#grid_id').jqGrid('getCell', row_id, 'personPostalCode');
			var personGitUrl = $('#grid_id').jqGrid('getCell', row_id, 'personGitUrl');
			var personSkills = $('#grid_id').jqGrid('getCell', row_id, 'personSkills');
			var personProjectValue = $('#grid_id').jqGrid('getCell', row_id, 'personProjectValue');
							            	
			var html = '<p style="font-size:15px"><b>Person details from main grid</b></p>' +					        '<table border="2" width="350">' +
				'<tr><td style="width:90px">' + '' + 'Name</td>' +
				'<td>' + personName + '</td></tr>' +
				'<tr><td style="width:90px">' + '' + 'Birth Date</td>' +
				'<td>' + personBirthDate + '</td></tr>' +
				'<tr><td style="width:90px">' + '' + 'Email ID</td>' +
				'<td>' + personEmailId + '</td></tr>' +
				'<tr><td style="width:90px">' + '' + 'Mobile Number</td>' +
				'<td>' + personMobileNumber + '</td></tr>' +
				'<tr><td style="width:90px">' + '' + 'Gender</td>' +
				'<td>' + personGender + '</td></tr>' +
				'<tr><td style="width:90px">' + '' + 'Designation</td>' +
				'<td>' + personDesignation + '</td></tr>' +
				'<tr><td style="width:90px">' + '' + 'State</td>' +					                			
				'<td><a href=https://en.wikipedia.org/wiki/' + personState + '>'+ personState + '</a></td></tr>' +
				'<tr><td style="width:90px">' + '' + 'City</td>' +
				'<td><a href=https://en.wikipedia.org/wiki/' + personCity + '>'+ personCity + '</a></td></tr>' +
				'<tr><td style="width:90px">' + '' + 'Postal Code</td>' +
				'<td>' + personPostalCode + '</td></tr>' +
				'<tr><td style="width:90px">' + '' + 'Skills</td>' +
				'<td>' + personSkills + '</td></tr>' +
				'<tr><td style="width:90px">' + '' + 'GitHub URL</td>' +
				'<td><a href=' + personGitUrl + '>'+ personGitUrl + '</a></td></tr>' +
				'<tr><td style="width:90px">' + '' + 'Project Value</td>' +
				'<td>' + personProjectValue + '</td></tr>' +
				'</table>'
				
				$("#" + subgrid_id).append(html);
			},
	});
```
![Screenshot](http://i1272.photobucket.com/albums/y389/harshal091/Github/SubGridSupport_zpsb8844832.png)

####Setting default filters in search toolbar

We can have default value in search toolbar by just adding small script snippet to column model as follows:

```HTML
	$('#grid_id').jqGrid({
		...,
		...,
		colNames : ['Mobile Number',...,
		],
		colModel : [ {
			name : '',
			index : '',
			editrules : {
			},
			editoptions : {
			},
			searchoptions : {
				$(el).val("1234567890"); //default value in search toolbar field
				setTimeout(function() { //focusing field
					$(el).focus().trigger({
						type : 'keypress',
						charCode : 13
					});
				}, 20);
			},
		},],
		...,
		...,
		...,
		...,
	});
```

####Graying out read-only fields in modal dialogs

By default, all the fields in modal dialog have no specific color to realize that they are read-only. We can gray out read-only fields while editing row to realize that these fields are ready only. We can add following script snippet (generally while editing row in modal dialog) to *beforeShowForm* as shown below:

```HTML
	beforeShowForm : function(form) {
		form.find(".FormElement[readonly]").prop("disabled", true).addClass("ui-state-disabled")
			.closest(".DataTD").prev(".CaptionTD").prop("disabled", true).addClass("ui-state-disabled")
	},
```

#### Adding required field (*) notation in modal dialog

We can add red asterik (*) in our modal dialog to indicate that perticular field is mandatory while editing.
We can achive this by adding small script snippet to out column model as follows:

```HTML
	$('#grid_id').jqGrid({
		...,
		...,
		colNames : ['Mobile Number',...,
		],
		colModel : [ {
			name : '',
			index : '',
			editrules : {
			},
			editoptions : {
			},
			formoptions : {
				elmprefix : "<br><span class='' style='color:red;'>&nbsp;*&nbsp;</span>",
				elmsuffix : "<span id='required' style='color:red;'><br>&nbsp;&nbsp;&nbsp;&nbsp;(must be unique)</span>",
				label : "<span>Email ID</span><span style='float:right'></span>"
			},
			searchoptions : {
			},
		},],
		...,
		...,
		...,
		...,
	});
```

#### Adding custom button to pager

We can add custom button to pager just by adding following script snippet to our main script:

```HTML
	autoedit : false;
	...
	...
	$('#grid_id').jqGrid({
		...,
		...,
		colNames : [
		],
		colModel : [
		],
		...,
		...,
		loadtext : '',
		...,
		...,
	});
	...
	...
	...
	$("#grid_id").jqGrid('navGrid', '#pager', {
		cloneToTop:true,
		edit : false,
		view : true,
		add : false,
		del : false,
		search : false,
		refresh : true
		}, {}, {}, {}, {
		...
		...
	});
	...
	...
	$("#pager_left table.navtable tbody tr").append(
	  '<td class="ui-pg-button ui-corner-all">' +
	  '<div class="ui-pg-div my-nav-checkbox">' +
	  '<input tabindex="-1" type="checkbox" id="AutoEdit" />' +
	  '<label title="Check caption which should appear as button tooltip"' +
	  ' for="AutoEdit">Autoedit</label></div></td>'
	);
	$("#AutoEdit").button({
		text: false,
		icons: {
		     primary: "ui-icon-mail-closed"
		}
	}).click(function () {
		var iconClass;
		if ($(this).is(':checked')) {
		     autoedit = true;
		     iconClass = "ui-icon-mail-open";
		} else {
		     autoedit = false;
		     iconClass = "ui-icon-mail-closed";
		}
	$(this).button("option", {icons: {primary: iconClass}});
	});
```

and following CSS snippet:

```HTML
	/* some settings to place Button in jqGrid */
	.ui-jqgrid .ui-pg-table .my-nav-checkbox {
		margin: 0px;
		padding: 0px;
		float: left;
		height: 18px
	}
	
	.ui-jqgrid .ui-pg-table .my-nav-checkbox>input {
		padding: 1px;
	}
	
	.ui-jqgrid .ui-pg-table .my-nav-checkbox>label {
		margin: 0px;
		border-width: 0px;
	}
	
	.ui-jqgrid .ui-pg-table .my-nav-checkbox:hover>label {
		margin: 0px;
		border-width: 1px;
	}
	
	/* fixing CSS of jQuery UI Buttons */
	.ui-jqgrid .ui-pg-table .my-nav-checkbox>.ui-button>span.ui-button-text {
		margin: 0px;
		padding: 1px 2px 1px 16px;
	}
	
	.ui-button-icon-only {
		width: 16px;
	}
	
	.ui-jqgrid .ui-pg-table .my-nav-checkbox>.ui-button>span.ui-button-icon-primary {
		margin: -8px 0px 0px -8px;
	}
```

If we want to display this icon in top pager then we must set *toppager* to true.

Following script snippet is needed to be added instead of above script:

```HTML
	autoedit : false;
	...
	...
	$('#grid_id').jqGrid({
		...,
		...,
		colNames : [
		],
		colModel : [
		],
		...,
		...,
		loadtext : '',
		toppager : true,
		...,
		...,
	});
	...
	...
	...
	$("#grid_id").jqGrid('navGrid', '#pager', {
		cloneToTop:true,
		edit : false,
		view : true,
		add : false,
		del : false,
		search : false,
		refresh : true
		}, {}, {}, {}, {
		...
		...
	});
	...
	...
	$("#pager_left table.navtable tbody tr").append(
	  '<td class="ui-pg-button ui-corner-all">' +
	  '<div class="ui-pg-div my-nav-checkbox">' +
	  '<input tabindex="-1" type="checkbox" id="AutoEdit" />' +
	  '<label title="Check caption which should appear as button tooltip"' +
	  ' for="AutoEdit">Autoedit</label></div></td>'
	);
	$("#AutoEdit").button({
		text: false,
		icons: {
		     primary: "ui-icon-mail-closed"
		}
	}).click(function () {
		var iconClass;
		if ($(this).is(':checked')) {
		     autoedit = true;
		     iconClass = "ui-icon-mail-open";
		} else {
		     autoedit = false;
		     iconClass = "ui-icon-mail-closed";
		}
	$(this).button("option", {icons: {primary: iconClass}});
	});
```

and CSS snippet will be as follow:

```HTML
	/* fix some common problems in the toppager */
	.ui-jqgrid .ui-jqgrid-toppager .ui-pg-div {
		padding: 1px 0;
		float: left;
		position: relative;
	}
	
	.ui-jqgrid .ui-jqgrid-toppager .ui-pg-button {
		height: 18px !important;
		cursor: pointer;
	}
	
	.ui-jqgrid .ui-jqgrid-toppager .ui-pg-div span.ui-icon {
		float: left;
		margin: 0 2px;
	}
```

#### Display custom icons in grid

We can have custom icons in our grid (as shown in schreenshot in Gender column) based on some conditions.
We can do this by adding *formatter* to our column model as:

```HTML
		$('#grid_id').jqGrid({
		...,
		...,
		colNames : ['Gender',...,
		],
		colModel : [ {
			name : '',
			index : '',
			editrules : {
			},
			editoptions : {
				value : ":Select Gender;Male:Male;Female:Female",
			},
			formatter: function (cellvalue, options, rowObject){
				if (cellvalue === 'Male') {
					 return "<img src='https://cdn1.iconfinder.com/data/icons/IconsLandVistaPeopleIconsDemo/256/Client_Male_Dark.png' height='30px' width='30px'></img>";
				} else if (cellvalue === 'Female') {
					return "<img src='http://icons.ae/images/icons/Professional%20Vista%20Software%20Icons/Business%20Lady%20Red%20Female/256x256/Business%20Lady%20Red%20Female.jpg' height='30px' width='30px'></img>";
				} else {
					return "<span class='ui-icon ui-icon-trash'></span>";
				}
			},
			formoptions : {
				elmprefix : "<br><span class='' style='color:red;'>&nbsp;*&nbsp;</span>",
				elmsuffix : "<span id='required' style='color:red;'><br>&nbsp;&nbsp;&nbsp;&nbsp;(must be unique)</span>",
				label : "<span>Gender</span><span style='float:right'></span>"
			},
			searchoptions : {
			},
		},],
		...,
		...,
		...,
		...,
	});
```

#### Cell coloring

We can change color of cells by different ways and different conditions. Look at the following script snippet and provided screenshow for better understanding :

```HTML
	$('#grid_id').jqGrid({
		...,
		...,
		colNames : [
		],
		colModel : [
		],
		...,
		...,
		...,
		...,
		loadComplete : function() {
			// 1 is zero-based index of the column personName. Every from the options
			// multiselect:true, rownumbers:true and subGrid:true will increase
			// the index by 1 because the option inserts additional columns
			$("#6 td:eq(1)", $('#grid_id')[0]).css({color:'red'});
			$('#grid_id').jqGrid('setCell',"12","personName","",{color:'red'});
			$('#grid_id').jqGrid('setCell',"12",'personBirthDate', '', 'my-highlight');
			$('#grid_id').jqGrid('setCell',"12","personMobileNumber","",{'background-color':'yellow', 'background-image':'none'});
			$('#grid_id').jqGrid('setCell',"12","personEmailId","",'ui-state-highlight');
		}
	});
```

Following CSS is needed to have cell coloring:

```HTML
	.my-highlight { 
		color: red; 
	}
	
	span.cellWithoutBackground {
		display: block;
		background-image: none;
		margin-right: -2px;
		margin-left: -2px;
		height: 14px;
		padding: 4px;
	}
```

####Client/Server side validations

We can perform custom validations as well as use in-build validators to perform validations in grid. The recommended way, but is the custom validations as using them, we can provide custom validation rules and custom messages when validations fail. The thing to do is little bit different but easy. We need to set *custom* to true and must provide custom function name in *custom_func* of *editrules*. Lets take a look at simple client side validation script snippet.

**Client side validation**

```HTML
	$('#grid_id').jqGrid({
		...,
		...,
		colNames : ['Gender',...,
		],
		colModel : [ {
			name : '',
			index : '',
			editrules : {
				custom : true,
				custom_func : checkGenderForEmpty
			},
			editoptions : {
				value : ":Select Gender;Male:Male;Female:Female",
			},
			formoptions : {
				elmprefix : "<br><span class='' style='color:red;'>&nbsp;*&nbsp;</span>",
				elmsuffix : "<span id='required' style='color:red;'><br>&nbsp;&nbsp;&nbsp;&nbsp;(must be unique)</span>",
				label : "<span>Gender</span><span style='float:right'></span>"
			},
			searchoptions : {
			},
		},],
		...,
		...,
		...,
		...,
		
		function checkGenderForEmpty(value, colname) {
			if (value == '') {
				result = [ false, "Select gender" ];
			} else {
				result = [ true, "" ];
			}
			return result;
		}
	});
```

when this validation fails, we will get *'Select gender'* as an error message but if we couldn't used custom
validators (*'required ; true '* in case of *'custom : false'*) we could get error message as *'Gender:Field is
required'*.

**Server Side Validation**
```HTML
	function checkEmailIdForUnique(value, colname) {
		var row = $('#myGrid').jqGrid('getGridParam', 'selrow');
	
		if (value == '') {
			result = [ false, "Email ID is must." ];
		} else if (row == null) {
			$.ajax({
				url : './person/checkEmailIdForUnique.json',
				data : {
					personEmailId : value
				},
				async : false,
				type : 'POST',
				datatype : 'text',
				success : function(data) {
					if (data) {
						result = [ false, "Email ID must be unique." ];
					} else if (!data) {
						result = [ true, "" ];
					} else {
						result = [ false, "Server encountered a problem" ];
					}
				}
			})
		} else {
			result = [ true, "" ];
		}
	
		return result;
	}
```

Above is the code snippet to perform server side validation. The above snippet shows how to validate *Email ID* to check whether it is unique or not. URL mentioned in the snippet will hit server to perform validation and procedure to call it is same as that of client side validations.

