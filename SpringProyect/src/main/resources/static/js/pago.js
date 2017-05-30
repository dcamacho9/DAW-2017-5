$(function () {
    $('#payment-method').change(function () {
        if ($(this).val() == "card") {
            $('#card-selected').show();
            $('#check-selected').hide();
            $('#pay-selected').hide();
        } else {
            $('#card-selected').hide();
        }

        if ($(this).val() == "check") {
            $('#check-selected').show();
            $('#card-selected').hide();
            $('#pay-selected').hide();
        } else {
            $('#check-selected').hide();
        }

        if ($(this).val() == "pay") {
            $('#pay-selected').show();
            $('#check-selected').hide();
            $('#card-selected').hide();
        } else {
            $('#pay-selected').hide();
        }
    });
});
