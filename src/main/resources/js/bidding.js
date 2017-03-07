var bid_index = [];

$.get('bid_index.json', function(data) {
    console.log(data);
    bid_index = JSON.parse(data);
});

