var addButton = $('#addButton');
var addInput = $('#addInput');

var errorArea = $('.errorArea');

var seperatorChar = '__';

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
	
	console.log(conferenceName);
	console.log(time);
	
	/*var lastWord2 = sentence.match(/\S*$/)[0]
	console.log(lastWord2);*/
	
});

var addRowTable = function(conferenceName, time){	
	$('#addTable tbody').append('<tr><td>'+conferenceName+'</td><td>'+time+' min</td><td><button type="button" onclick="removeFunction(this)" class="btn btn-secondary">Remove</button></td></tr>');
	
	var inputVal = $('#postInput').val();
	
	$('#postInput').val(inputVal+conferenceName+seperatorChar+time+',');
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
	
	if ( isValid ) {
		errorArea.addClass('elementHide');
	} else {
		errorArea.removeClass('elementHide');
	}
	
	return isValid;
	
};

var removeFunction = function(obj){
	console.log('removeeeee');
};