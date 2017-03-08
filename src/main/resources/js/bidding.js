var bid_index = [];

var columns_number;

var contract_column;

function count_columns() {
    columns_number = 0;
    contract_column = -1;
    for (var x = $("td[rowspan=2]:contains('ns')"); x.html() !== undefined; x = x.next()) {
        if (x.html() === 'kont.') {
            contract_column = columns_number;
        }
        columns_number++;
    }
    columns_number += 2;
}

function get_bid_index() {
    $.get('bid_index.json', function (data) {
        bid_index = JSON.parse(data);
    });
}

function remove_bidding() {
    // console.log("REMOVING");
    $("#bidding_popup").remove();
}

function show_bidding() {
    remove_bidding();
    var elem = $(this);
    var board = elem.attr('data-board');
    var pair = elem.attr('data-pair');
    // console.log("show bidding");
    $.get('bid-' + board + '-' + pair + '.html', function (data) {
        display_bidding(elem, data);
    });
}


///////////////////
function display_bidding(element, bidding) {
    var popup = $('<div id="bidding_popup"></div>');
    // console.log("ADDING");
    popup.css({
        'position': 'absolute',
        'width': '250px',
        'left': element.offset().left + element.width(),
        'top': element.offset().top
    });
    popup.html(bidding);
    $('body').append(popup);
}
/////////////////

function contract_html(pair) {
    var result = ' <a href="javascript:void(0)" class="biddingLink" data-pair="' + pair + '" data-board="' + selected + '">';
    result += '<img src="img/link.png" />';
    result += '</a>';
    return result;
}

function inject_contract(row) {
    var contract_td = row.children().first();
    var pair = contract_td.children().first().html();
    for (var i = 0; i < contract_column; i++) {
        contract_td = contract_td.next();
    }
    contract_td.html(contract_td.html() + contract_html(pair));
}

function inject_contracts() {
    var results_rows = $("td[rowspan=2]:contains('ns')").parent().parent().next().children();
    var row = results_rows.first();
    for (var i = 0; i < results_rows.length; i++, row = row.next()) {
        inject_contract(row);
    }
    $('a.biddingLink').each(function() {
        $(this).unbind('click').click(show_bidding);
    });
}

function make_bidding() {
    count_columns();
    // get_bid_index();
    inject_contracts();
    // $(document).click(remove_bidding);
}

function make_bidding_with_timeout() {
    setTimeout(
        function () {
            make_bidding();
        }, 200);
}

$(make_bidding_with_timeout);

// $(window).hashchange(make_bidding_with_timeout());
