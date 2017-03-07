var bid_index = [];

var columns_number;

var contract_column;

function REMOVE_THIS() {
    return '<table> <tr> <th> W </th> <th> N </th> <th> E </th> <th> S </th> </tr> <tr> <td> PASS </td> <td> 1 <img src="img/clubs.gif"/> </td> <td> PASS </td> <td> 1 <img src="img/hearts.gif"/> </td> </tr> <tr> <td> PASS </td> <td> 2 <img src="img/hearts.gif"/> </td> <td> PASS </td> <td> PASS </td> </tr> <tr> <td> PASS </td> <td> </td> <td> </td> <td> </td> </tr> </table>';
}

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
    // console.log("show bidding");
    display_bidding(elem, REMOVE_THIS());
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

function contract_html() {
    var result = ' <a href="javascript:void(0)" class="biddingLink">';
    result += '<img src="img/link.png" />';
    result += '</a>';
    return result;
}

function inject_contract(row) {
    var contract_td = row.children().first();
    for (var i = 0; i < contract_column; i++) {
        contract_td = contract_td.next();
    }
    contract_td.html(contract_td.html() + contract_html());
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
