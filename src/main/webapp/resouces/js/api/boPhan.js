function xyz(data){
	boPhan.result = data;
}
window.boPhan = {
	result: null,
	get: function(){
		$.ajax({
            url: BASE_MAIN_URL + '/api/boPhan',
            type: 'POST',
            data: {
            	
            },
        })
        .done(function(data) {
        	xyz(data);
        })
	},
	getByMaBP: function(maBP){
		$.ajax({
            url: BASE_MAIN_URL + '/api/boPhan/getByMaBP',
            type: 'POST',
            data: {
            	maBP: maBP
            },
        })
        .done(function(data) {
        	xyz(data);
        })
	},
	add: function(maCha, tenBP){
		$.ajax({
            url: BASE_MAIN_URL + '/api/boPhan/add',
            type: 'POST',
            data: {
            	maCha: maCha,
            	tenBP: tenBP
            },
        })
        .done(function(data) {
        	xyz(data);
        })
	},
	update: function(maBP, maCha, tenBP){
		$.ajax({
            url: BASE_MAIN_URL + '/api/boPhan/update',
            type: 'POST',
            data: {
            	maBP: maBP,
            	maCha: maCha,
            	tenBP: tenBP
            },
        })
        .done(function(data) {
        	xyz(data);
        })
	},
	delete: function(maBP){
		$.ajax({
            url: BASE_MAIN_URL + '/api/boPhan/delete',
            type: 'POST',
            data: {
            	maBP: maBP
            },
        })
        .done(function(data) {
        	xyz(data);
        })
	},
	isMaBP: function(maBP){
		$.ajax({
            url: BASE_MAIN_URL + '/api/boPhan/isMaBP',
            type: 'POST',
            data: {
            	maBP: maBP
            },
        })
        .done(function(data) {
        	xyz(data);
        })
	},
	isMaCha: function(maCha){
		$.ajax({
            url: BASE_MAIN_URL + '/api/boPhan/isMaCha',
            type: 'POST',
            data: {
            	maCha: maCha
            },
        })
        .done(function(data) {
        	xyz(data);
        })
	},
	deleteByMaCha: function(maCha){
		$.ajax({
            url: BASE_MAIN_URL + '/api/boPhan/deleteByMaCha',
            type: 'POST',
            data: {
            	maCha: maCha
            },
        })
        .done(function(data) {
        	xyz(data);
        })
	},
	deleteByMaCha: function(maBP, maCha){
		$.ajax({
            url: BASE_MAIN_URL + '/api/boPhan/moveBoPhan',
            type: 'POST',
            data: {
            	maBP: maBP,
            	maCha: maCha
            },
        })
        .done(function(data) {
        	xyz(data);
        })
	}
}