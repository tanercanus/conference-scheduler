var addButton = $('#addButton');
var addInput = $('#addInput');
var submitButton = $('#submitButton');
var postInput = $('#postInput');

var errorArea = $('.errorArea');

var seperatorChar = '__';
var commaChar = ',';

addButton.click(function (){
	
	var sentence = addInput.val().trim();
	
	if ( !validationForInputArea(sentence) ) {
		return;
	}
	
	//" replace space
	sentence = sentence.replace(/"/g, ' ');
	
	var conferenceName = sentence;
	var time = sentence.split(' ').pop();
	
	var indexOfMin = time.indexOf('min');
	if ( indexOfMin != -1 ) {
		time = time.substring(0,indexOfMin);
		conferenceName = sentence.substring(0,sentence.indexOf(time+'min'));
	} else {
		time = 0;
	}
	
	addRowTable(conferenceName, time);
	
	
	
});

var addRowTable = function(conferenceName, time){	
	
	var inputVal = $('#postInput').val();
	var addedVal = conferenceName+seperatorChar+time;
	
	if ( time > 60 ) {
		errorArea.text('Conference time cannot be greater than 60 min.');
		errorArea.removeClass('elementHide');
		return;
	}
	
	//Check input added before
	if ( inputVal && inputVal.length > 0) {
		var inputVals = inputVal.split(commaChar);		
		for (var i=0; i<inputVals.length; i++) {
			if ( addedVal == inputVals[i] ) {
				errorArea.text('The Conference is added before!!');
				errorArea.removeClass('elementHide');
				return;
			}
		}
	}	
	
	$('#addTable tbody').append('<tr><td>'+conferenceName+'</td><td>'+time+' min</td><td><button type="button" onclick="removeFunction(this)" class="btn btn-secondary">Remove</button><input type="hidden" value="'+addedVal+'"/></td></tr>');
	
	postInput.val(inputVal+addedVal+commaChar);
	
	addInput.val('');
	
	submitButton.removeAttr('disabled')
};

var validationForInputArea = function(sentence){
	isValid = true;
	if ( sentence.length == 0 ) {
		errorArea.text('Please Enter Conference!!');
		isValid = false;
	}
	
	if ( sentence.indexOf(seperatorChar) != -1 ) {
		errorArea.text('Please Enter Valid Conference!!');
		isValid = false;
	}
	
	if ( sentence.indexOf(commaChar) != -1) {
		errorArea.text('Please Enter Conference Name without comma char!!');
		isValid = false;
	}
	
	if ( isValid ) {
		errorArea.addClass('elementHide');
	} else {
		errorArea.removeClass('elementHide');
	}
	
	return isValid;
	
};

var removeFunction = function(obj){
	
	$(obj).parents('tr').remove();
	var removedVal = $(obj).parent().find('input').val();
	
	var inputVals = postInput.val().split(commaChar);
	
	var index = -1;
	for ( var i=0; i<inputVals.length; i++ ) {
		if (removedVal == inputVals[i] ) {
			index = i;
			break;
		}
	}
	
	//Delete object from list
	inputVals.splice(index,1);
	
	//There is only empty string
	if ( inputVals.length == 1 ) {
		postInput.val('');
		submitButton.attr('disabled','true');
	} else {
		postInput.val(inputVals.join());
	}
		
};