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