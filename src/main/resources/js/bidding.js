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

function inject_contract(row) {
    var contract_td = row.children().first();
    for (var i = 0; i < contract_column; i++) {
        contract_td = contract_td.next();
    }
    contract_td.html(contract_td.html() + "CONTRACT INJECT");
}

function inject_contracts() {
    var results_rows = $("td[rowspan=2]:contains('ns')").parent().parent().next().children();
    var row = results_rows.first();
    for (var i = 0; i < results_rows.length; i++, row = row.next()) {
        inject_contract(row);
    }
}

function make_bidding() {
    count_columns();
    get_bid_index();
    inject_contracts();
}

$(function () {
    setTimeout(
        function () {
            make_bidding();
        }, 200);
});



