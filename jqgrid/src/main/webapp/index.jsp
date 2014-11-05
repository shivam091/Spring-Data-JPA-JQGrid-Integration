<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>Person Master Grid</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/css/start/jquery-ui.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/css/start/jquery.ui.theme.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/css/start/jquery-ui.min.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/css//ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/css//personGrid.css" />
</head>
<body>
	<!-- Grid code starts here -->
	<div id='jqgrid'>
		<table id='myGrid'></table>
		<div id='pager'></div>
	</div>
	<div id='msgbox' title='' style='display: none'></div>
	<!-- Grid code ends here -->
	<script type='text/javascript'
		src="${pageContext.request.contextPath}/resources/js/jquery-1.7.2.min.js" /></script>
	<script type='text/javascript'
		src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.16.custom.min.js" /></script>
	<script type='text/javascript'
		src="${pageContext.request.contextPath}/resources/js/i18n/grid.locale-en.js" /></script>

	<script type='text/javascript'
		src="${pageContext.request.contextPath}/resources/js/jquery.jqGrid.min.js" /></script>
	<script type='text/javascript'
		src="${pageContext.request.contextPath}/resources/js/jquery.maskedinput-1.3.js" /></script>
	<script type="text/javascript">
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

			$("#myGrid")
					.jqGrid(
							{
								url : './person/getAllPeople.json',
								datatype : 'json',
								mtype : 'get',
								colNames : [ 'ID', 'Name', 'Password',
										'Gender', 'Birth Date',
										'Mobile Number', 'Email ID',
										'Designation', 'State', 'City',
										'Postal Code', 'GitHub URL', 'Skills',
										'Project Value' ],
								colModel : [
										{
											name : 'personId',
											index : 'personId',
											width : 70,
											align : 'center',
											editable : true,
											editoptions : {
												readonly : true,
												size : 10
											},
											hidden : false,
											formoptions : {
												elmprefix : "<span class='mystar' style='color:red'>&nbsp;&nbsp;</span>",
												elmsuffix : "",
												label : "<span>Person ID</span><span style='float:right'></span>"
											},
											search : true,
											searchrules : {
												required : true,
												number : true
											},
											searchtype : "number",
											searchoptions : {
												sopt : [ 'eq', 'bw', 'ew',
														'lt', 'gt' ]
											}
										},
										{
											name : 'personName',
											index : 'personName',
											width : 130,
											sortable : false,
											align : 'center',
											editable : true,
											editrules : {
												custom:true,
												custom_func:checkNameForEmpty,
											},
											editoptions : {
												size : 30
											},
											hidden : false,
											formoptions : {
												elmprefix : "<span class='mystar' style='color:red'>*&nbsp;</span>",
												elmsuffix : "",
												label : "<span>Name</span><span style='float:right'></span>"
											},
											search : false,
											searchrules : {
												required : true
											},
											searchoptions : {
												sopt : [ 'eq', 'bw', 'ew' ]
											}
										},
										{
											name : 'personPassword',
											index : 'personPassword',
											fixed : true,
											sortable : false,
											editable : true,
											hidden : true,//hide coloumn in grid
											width : 90,
											formatter : 'password',
											edittype : 'password',
											editrules : {
												custom:true,
												custom_func:checkPasswordForEmpty,
												edithidden : true,//to enable unhide password field when editing
											},
											formoptions : {
												elmprefix : "<span class='' style='color:red;'>*&nbsp;</span>",
												elmsuffix : "",
												label : "<span>Password</span><span style='float:right'></span>"
											},
											search : false
										},
										{
											name : 'personGender',
											index : 'personGender',
											width : 140,
											sortable : false,
											align : 'center',
											editable : true,
											editrules : {
												custom:true,
												custom_func:checkGenderForEmpty,
											},
											edittype : "select",
											formatter : 'select',
											stype : 'select',
											editoptions : {
												value : ":Select Gender;Male:Male;Female:Female"
											},
											formatoptions : {
												value : ":Select Gender;Male:Male;Female:Female"
											},
											formoptions : {
												elmprefix : "<span class='' style='color:red;'>*&nbsp;</span>",
												elmsuffix : "",
												label : "<span>Gender</span><span style='float:right'></span>"
											},
											searchoptions : {
												sopt : [ 'eq' ],
												value : ":Select Gender;Male:Male;Female:Female"
											}
										},
										{
											name : 'personBirthDate',
											index : 'personBirthDate',
											width : 200,
											sortable : false,
											template : dateTemplate,
											formoptions : {
												elmprefix : "<span class='mystar' style='color:red'>*&nbsp;</span>",
												elmsuffix : "",
												label : "<span>Birth Date</span><span style='float:right'></span>"
											},
											search : true,
											editrules : {
												custom:true,
												custom_func:checkBirthDateForEmpty
											}
										},
										{
											name : 'personMobileNumber',
											index : 'personMobileNumber',
											width : 160,
											sortable : false,
											align : 'center',
											editable : true,
											editrules : {
												custom:true,
												custom_func:checkMobileNumberForEmpty
											},
											editoptions : {
												size : 10,
												dataInit : function(elem) {
													$(elem).mask("9999999999");
												}
											},
											hidden : false,
											formoptions : {
												elmprefix : "<span class='mystar' style='color:red'>*&nbsp;</span>",
												elmsuffix : "",
												label : "<span>Mobile Number</span><span style='float:right'></span>"
											},
											search : true,
											searchrules : {
												required : true
											},
											searchoptions : {
												sopt : [ 'eq' ],
												size : 10,
												dataInit : function(elem) {
													$(elem).mask("9999999999");
												}
											}
										},
										{
											name : 'personEmailId',
											index : 'personEmailId',
											width : 215,
											formatter : 'email',
											sortable : false,
											align : 'center',
											editable : true,
											editrules : {
												email : true,
												custom:true,
												custom_func:checkEmailIdForUnique
											},
											editoptions : {
												size : 30
											},
											hidden : false,
											formoptions : {
												elmprefix : "<br><span class='' style='color:red;'>&nbsp;*&nbsp;</span>",
												elmsuffix : "<span id='required' style='color:red;'><br>&nbsp;&nbsp;&nbsp;&nbsp;(must be unique)</span>",
												label : "<span>Email ID</span><span style='float:right'></span>"
											},
											search : true,
											searchrules : {
												required : true
											},
											searchoptions : {
												sopt : [ 'eq' ]
											}
										},
										{
											name : 'personDesignation',
											index : 'personDesignation',
											sortable : false,
											width : 155,
											align : 'center',
											editable : true,
											editrules : {
												custom:true,
												custom_func:checkDesignationForEmpty,
											},
											editoptions : {
												size : 30
											},
											hidden : false,
											formoptions : {
												elmprefix : "<span class='mystar' style='color:red'>*&nbsp;</span>",
												elmsuffix : "",
												label : "<span>Designation</span><span style='float:right'></span>"
											},
											search : true,
											searchrules : {
												required : true
											},
											searchoptions : {
												sopt : [ 'eq', 'bw', 'ew' ]
											}
										},
										{
											name : 'personState',
											index : 'personState',
											width : 170,
											sortable : false,
											align : 'center',
											editable : true,
											editrules : {
												custom:true,
												custom_func:checkStateForEmpty

											},
											edittype : "select",
											formatter : 'text',
											stype : 'select',
											editoptions : {
												dataUrl : './person/getStateList.json',
												dataEvents : [ {
													type : 'change',
													fn : function(e) {

													}
												} ]
											},
											formatoptions : {

											},
											formoptions : {
												elmprefix : "<span class='' style='color:red;'>*&nbsp;</span>",
												elmsuffix : "",
												label : "<span>State</span><span style='float:right'></span>"
											},
											searchoptions : {
												sopt : [ 'eq' ],
												dataUrl : './person/getStateList.json'
											}
										},
										{
											name : 'personCity',
											index : 'personCity',
											width : 170,
											sortable : false,
											align : 'center',
											editable : true,
											editrules : {
												custom:true,
												custom_func:checkCityForEmpty
											},
											edittype : "select",
											formatter : 'text',
											stype : 'select',
											editoptions : {
												dataUrl : './person/getAllCities.json'
											},
											formatoptions : {

											},
											formoptions : {
												elmprefix : "<span class='' style='color:red;'>*&nbsp;</span>",
												elmsuffix : "",
												label : "<span>City</span><span style='float:right'></span>"
											},
											searchoptions : {
												sopt : [ 'eq' ],
												dataUrl : './person/getAllCities.json'
											}
										},
										{
											name : 'personPostalCode',
											index : 'personPostalCode',
											width : 90,
											sortable : false,
											align : 'center',
											editable : true,
											editrules : {
												custom:true,
												custom_func:checkPostalCodeForEmpty
											},
											formatter : 'text',
											editoptions : {
												size : 10,
												dataInit : function(elem) {
													$(elem).mask("999999");
												}
											},
											hidden : false,
											formoptions : {
												elmprefix : "<span class='mystar' style='color:red'>*&nbsp;</span>",
												elmsuffix : "",
												label : "<span>Postal Code</span><span style='float:right'></span>"
											},
											search : true,
											searchrules : {
												required : true
											},
											searchoptions : {
												sopt : [ 'eq', 'bw', 'ew' ],
												size : 10,
												dataInit : function(elem) {
													$(elem).mask("999999");
												}
											}
										},
										{
											name : 'personGitUrl',
											index : 'personGitUrl',
											sortable : false,
											width : 220,
											align : 'center',
											editable : true,
											editrules : {
												custom:true,
												custom_func:checkGitUrlForEmpty
											},
											formatter : 'link',
											editoptions : {
												size : 30
											},
											hidden : false,
											formoptions : {
												elmprefix : "<span class='mystar' style='color:red'>*&nbsp;</span>",
												elmsuffix : "",
												label : "<span>GitHub URL</span><span style='float:right'></span>"
											},
											search : true,
											searchrules : {
												required : true
											},
											searchoptions : {
												sopt : [ 'eq' ]
											}
										},
										{
											name : 'personSkills',
											index : 'personSkills',
											width : 240,
											sortable : false,
											align : 'center',
											editable : true,
											editrules : {
												custom:true,
												custom_func:checkSkillsForEmpty,
											},
											edittype : "select",
											formatter : 'text',
											stype : 'select',
											editoptions : {
												dataUrl : './person/getSkillsList.json',
												multiple : true,
												size : 100,
											},
											formatoptions : {
												size : 100,
											},
											formoptions : {
												elmprefix : "<span class='' style='color:red;'>*&nbsp;</span>",
												elmsuffix : "",
												label : "<span>Skills</span><span style='float:right'></span>"
											},
											search : false,
											size : 50
										},
										{
											name : 'personProjectValue',
											index : 'personProjectValue',
											editable : true,
											width : 130,
											align : 'right',
											sortable : false,
											formatter : 'currency',
											formatoptions : {
												decimalSeparator : '.',
												thousandsSeparator : ',',
												decimalPlaces : 2,
												defaultValue : '&nbsp;'
											},
											formoptions : {
												elmprefix : "<span class='' style='color:red;'>&nbsp;&nbsp;</span>",
												elmsuffix : "",
												label : "<span>Project Value</span><span style='float:right'></span>"
											},
											search : true,
											searchrules : {
												required : true
											},
											searchoptions : {
												sopt : [ 'eq', 'gt', 'lt' ]
											}
										}, ],
								rowNum : 10,
								rowList : [ 10, 20, 30, 40, 60, 80, 100 ],
								height : 347,
								autowidth : true,
								gridview : true,
								rownumbers : true, //enables row numbers
								rownumWidth : 25, //size of row number column.
								pager : '#pager',
								sortname : 'personId',
								multisort : false,
								multiselect : false,
								viewrecords : true,
								shrinkToFit : false,
								autoencode : false, //e.g.< will be converted to &lt;.
								cellEdit : false,
								loadtext : '', //set loading text when grid is refreshed e.g. Loading...
								sortable : true, //To sort columns
								sortorder : "asc",
								recordtext : 'Person/People {0} - {1} of {2}',
								caption : "Person Master Records",
								emptyrecords : "No person to display",
								toolbar : true,
								jsonReader : {
									root : "rows",
									page : "page",
									total : "total",
									records : "records",
									repeatitems : true,
									cell : "cell",
									id : "personId"
								},
								postData : {

								},
								loadError : function(jqXHR, textStatus,
										errorThrown) {
									$('#msgbox').text(
											'HTTP status code: ' + jqXHR.status
													+ '\n' + 'Test Status: '
													+ textStatus + '\n'
													+ 'Error Thrown: '
													+ errorThrown + '\n\n'
													+ 'Error Text: '
													+ jqXHR.responseText);
									$('#msgbox').dialog({
										title : 'Error',
										modal : true,
										buttons : {
											"Ok" : function() {
												$(this).dialog("close");
											}
										}
									});
								},
								loadComplete : function() {

								},
								gridComplete : function() {

								},
								ondblClickRow : function(rowid, ri, ci) {

								},
								onSelectRow : function() {

								},
								onSortCol : function(index, idxcol, sortorder) {
									var $icons = $(this.grid.headers[idxcol].el)
											.find(
													">div.ui-jqgrid-sortable>span.s-ico");
									if (this.p.sortorder === 'asc') {
										//$icons.find('>span.ui-icon-asc').show();
										$icons.find('>span.ui-icon-asc')[0].style.display = "";
										$icons.find('>span.ui-icon-desc')
												.hide();
									} else {
										//$icons.find('>span.ui-icon-desc').show();
										$icons.find('>span.ui-icon-desc')[0].style.display = "";
										$icons.find('>span.ui-icon-asc').hide();
									}
								}
							});
			$(
					'#gbox_'
							+ $.jgrid.jqID($('#myGrid')[0].deviceId)
							+ ' tr.ui-jqgrid-labels th.ui-th-column>div.ui-jqgrid-sortable>span.s-ico')
					.each(
							function() {

								$(this)
										.find(
												'>span.ui-icon-'
														+ ($('#myGrid').jqGrid(
																'getGridParam',
																'sortorder') === 'desc' ? 'asc'
																: 'desc'))
										.hide();
							});

			$('#myGrid').jqGrid('sortableRows');//Enables sortable rows
			
			var height = window.innerHeight;
			$('#myGrid').jqGrid('setGridHeight', 347);
			$("#myGrid").jqGrid('navGrid', '#pager', {
				edit : false,
				view : true,
				add : false,
				del : false,
				search : false,
				refresh : true
			}, {}, {}, {}, {
				sopt : [],
				//currently all are set to false as search toolbar is used.
				closeOnEscape : false, /* Close search modal after ESC is pressed */
				multipleSearch : false, /* Enables multiple search */
				reloadAfterSearch : false,
				closeAfterSearch : false, /* Close search modal after search */
				closeAfterReset : false, /* Close search modal after reset */
				recreateFilter : false, /* Search modal will be recreated when it's called */
				multipleGroup : false, /* To enable multiple groups in search */
				showQuery : false, /* To show query fired */
				overlay : 0
			});

			$("#myGrid").navButtonAdd(
					'#pager',
					{
						caption : "",
						title : "Toggle Search Toolbar",
						buttonicon : 'ui-icon-pin-s',
						onClickButton : function() {
							this.toggleToolbar();
							if ($.isFunction(this.p._complete)) {
								if ($('.ui-search-toolbar', this.grid.hDiv).is(
										':visible')) {
									$('.ui-search-toolbar', this.grid.fhDiv)
											.show();
								} else {
									$('.ui-search-toolbar', this.grid.fhDiv)
											.hide();
								}
								this.p._complete.call(this);
								fixPositionsOfFrozenDivs.call(this);
							}
						}
					});

			$("#myGrid").navButtonAdd('#pager', {
				caption : "Add",
				buttonicon : "ui-icon-plus",
				onClickButton : addRow,
				position : "last",
				title : "Add new person",
				cursor : "pointer"
			});

			$("#myGrid").navButtonAdd('#pager', {
				caption : "Edit",
				buttonicon : "ui-icon-pencil",
				onClickButton : editRow,
				position : "last",
				title : "Edit person",
				cursor : "pointer"
			});

			$("#myGrid").navButtonAdd('#pager', {
				caption : "Delete",
				buttonicon : "ui-icon-trash",
				onClickButton : deleteRow,
				position : "last",
				title : "Delete person",
				cursor : "pointer"
			});

			// Toolbar Search
			$("#myGrid")
					.jqGrid(
							'filterToolbar',
							{
								autosearch : true,
								searchOperators : true,
								stringResult : true,
								searchOnEnter : true,
								defaultSearch : "eq",
								afterSearch : function() {
									if ($('.ui-search-toolbar', this.grid.hDiv)
											.is(':visible')) {
										$('.ui-search-toolbar', this.grid.fhDiv)
												.show();
									}
								},
								beforeSearch : function() {

								}
							});
		});

		function addRow() {
			$("#myGrid").trigger('reloadGrid');
			$("#myGrid").jqGrid('setColProp', 'personEmailId', {
				editoptions : {
					readonly : false
				}
			});
			$('required').hide();

			// Get the currently selected row
			$('#myGrid')
					.jqGrid(
							'editGridRow',
							'new',
							{
								url : './person/saveNewPerson.json',
								
								editData : {

								},
								serializeEditData : function(data) {
									data.id = 0;
									return $.param(data);
								},
								recreateForm : true,
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
									dlgDiv[0].style.top = Math
											.round((parentHeight - (dlgHeight - 150)) / 2)
											+ "px";
									dlgDiv[0].style.left = Math
											.round((parentWidth - dlgWidth + 130) / 2)
											+ "px";
								},
								beforeInitData : function(form) {

								},
								savekey : [ true, 13 ], //to perform submit operation when enter key is pressed.
								closeAfterAdd : true,
								reloadAfterSubmit : true,
								afterSubmit : function(response, postdata) {
									var result = eval('('
											+ response.responseText + ')');
									var errors = "";

									if (result.success == false) {
										for (var i = 0; i < result.message.length; i++) {
											errors += result.message[i]
													+ "<br/>";
										}
									} else {
										$('#msgbox')
												.text(
														'person has been added successfully.');
										$('#msgbox').dialog({
											title : 'Success',
											modal : true,
											buttons : {
												"Ok" : function() {
													$(this).dialog("close");
												}
											}
										});
									}
									// only used for adding new records
									var newId = null;

									return [ result.success, errors, newId ];
								}
							});
		} // end of addRow

		function editRow() {
			// Get the currently selected row
			var row = $('#myGrid').jqGrid('getGridParam', 'selrow');
			$("#myGrid").jqGrid('setColProp', 'personEmailId', {
				editoptions : {
					readonly : true
				}
			});
			if (row != null) {

				$('#myGrid')
						.jqGrid(
								'editGridRow',
								row,
								{
									url : './person/editPerson.json',
									editData : {

									},
									recreateForm : true,
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
										dlgDiv[0].style.top = Math
												.round((parentHeight - (dlgHeight - 150)) / 2)
												+ "px";
										dlgDiv[0].style.left = Math
												.round((parentWidth - dlgWidth + 130) / 2)
												+ "px";
									},
									beforeInitData : function(form) {

									},
									savekey : [ true, 13 ], //to perform submit operation when enter key is pressed.
									closeAfterEdit : true,
									reloadAfterSubmit : true,
									afterSubmit : function(response, postdata) {
										var result = eval('('
												+ response.responseText + ')');
										var errors = "";

										if (result.success == false) {
											for (var i = 0; i < result.message.length; i++) {
												errors += result.message[i]
														+ "<br/>";
											}
										} else {
											$('#msgbox')
													.text(
															'person details has been edited successfully.');
											$('#msgbox')
													.dialog(
															{
																title : 'Success',
																modal : true,
																buttons : {
																	"Ok" : function() {
																		$(this)
																				.dialog(
																						"close");
																	}
																}
															});
										}
										// only used for adding new records
										var newId = null;
										$("#myGrid").trigger('reloadGrid');
										return [ result.success, errors, newId ];
									}
								});
			} else {
				$('#msgbox').text('You must select a person to edit!');
				$('#msgbox').dialog({
					title : 'Error',
					modal : true,
					buttons : {
						"Ok" : function() {
							$(this).dialog("close");
						}
					}
				});
			}
		}

		function deleteRow() {
			// Get the currently selected row
			var row = $('#myGrid').jqGrid('getGridParam', 'selrow');
			// A pop-up dialog will appear to confirm the selected action
			if (row != null)
				$('#myGrid')
						.jqGrid(
								'delGridRow',
								row,
								{
									url : './person/deletePerson.json?personId='
											+ row,
									recreateForm : true,
									beforeShowForm : function(form) {
										//Change title
										$(".delmsg")
												.replaceWith(
														'<span style="white-space: pre;">'
																+ 'Delete selected person?'
																+ '</span>');
										//hide arrows
										$('#pData').hide();
										$('#nData').hide();
										var dlgDiv = $("#delmod" + "myGrid");
										var parentDiv = dlgDiv.parent();
										var dlgWidth = dlgDiv.width();
										var parentWidth = parentDiv.width();
										var dlgHeight = dlgDiv.height();
										var parentHeight = parentDiv.height();
										// TODO: change parentWidth and parentHeight in case of the grid
										//       is larger as the browser window
										dlgDiv[0].style.top = Math
												.round((parentHeight - (dlgHeight - 200)) / 2)
												+ "px";
										dlgDiv[0].style.left = Math
												.round((parentWidth - dlgWidth + 130) / 2)
												+ "px";
									},
									savekey : [ true, 13 ], //to perform submit operation when enter key is pressed.
									reloadAfterSubmit : true,
									closeAfterDelete : true,
									serializeDelData : function(postdata) {
										var rowdata = $('#myGrid').getRowData(
												postdata.id);
										// append postdata with any information 
										return {
											id : postdata.id,
											oper : postdata.oper,
											emailId : rowdata.emailId
										};
									},
									afterSubmit : function(response, postdata) {
										var result = eval('('
												+ response.responseText + ')');
										var errors = "";

										if (result.success == false) {
											for (var i = 0; i < result.message.length; i++) {
												errors += result.message[i]
														+ "<br/>";
											}
										} else {
											$('#msgbox')
													.text(
															'Person has been deleted successfully.');
											$('#msgbox')
													.dialog(
															{
																title : 'Success',
																modal : true,
																buttons : {
																	"Ok" : function() {
																		$(this)
																				.dialog(
																						"close");
																	}
																}
															});
										}
										var newId = null;

										return [ result.success, errors, newId ];
									}
								});
			else {
				$('#msgbox').text('You must select a person to delete!');
				$('#msgbox').dialog({
					title : 'Error',
					modal : true,
					buttons : {
						"Ok" : function() {
							$(this).dialog("close");
						}
					}
				});
			}
		}
		
		function checkNameForEmpty(value, colname) {
			if (value == '') {
				result = [ false, "Enter name" ];
			} else {
				result = [ true, "" ];
			}
			return result;
		}
		
		function checkPasswordForEmpty(value, colname) {
			if (value == '') {
				result = [ false, "Enter password" ];
			} else {
				result = [ true, "" ];
			}
			return result;
		}
		
		function checkGenderForEmpty(value, colname) {
			if (value == '') {
				result = [ false, "Select gender" ];
			} else {
				result = [ true, "" ];
			}
			return result;
		}
		
		function checkBirthDateForEmpty(value, colname) {
			if (value == '') {
				result = [ false, "Select birth date from date picker" ];
			} else {
				result = [ true, "" ];
			}
			return result;
		}
		
		function checkMobileNumberForEmpty(value, colname) {
			if (value == '') {			
				result = [ false, "Enter mobile number" ];
			} else {
				result = [ true, "" ];
			}
			return result;
		}
		
		function checkDesignationForEmpty(value, colname) {
			if (value == '') {
				result = [ false, "Enter designation" ];
			} else {
				result = [ true, "" ];
			}
			return result;
		}
		
		function checkStateForEmpty(value, colname) {
			if (value == 'Select State') {
				result = [ false, "Select state" ];
			} else {
				result = [ true, "" ];
			}
			return result;
		}
		
		function checkCityForEmpty(value, colname) {
			if (value == 'Select City') {
				result = [ false, "Select city" ];
			} else {
				result = [ true, "" ];
			}
			return result;
		}
		
		function checkPostalCodeForEmpty(value, colname) {
			if (value == '') {
				result = [ false, "Enter postal code" ];
			} else {
				result = [ true, "" ];
			}
			return result;
		}
		
		function checkGitUrlForEmpty(value, colname) {
			if (value == '') {
				result = [ false, "Enter GitHub URL" ];
			} else {
				result = [ true, "" ];
			}
			return result;
		}
		
		function checkSkillsForEmpty(value, colname) {
			if (value == '') {
				result = [ false, "Select your skills" ];
			} else {
				result = [ true, "" ];
			}
			return result;
		}
		
		function checkProjectValueForEmpty(value, colname) {
			if (value == '') {
				result = [ false, "Enter your project's value" ];
			} else {
				result = [ true, "" ];
			}
			return result;
		}
		
		function checkEmailIdForUnique(value, colname) {
			var row = $('#myGrid').jqGrid('getGridParam', 'selrow');

			if (value == '') {
				result = [ false, "Email ID is must." ];
			} else if (row == null) {
				$
						.ajax({
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

	</script>
	
</body>
</html>
