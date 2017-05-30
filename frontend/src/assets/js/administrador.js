$(document).ready(function () {
    $('#admin').hide();
    $('#contents').show();
    $('#users').hide();
    $('#validation').hide();
    $('#adminMenu').addClass('active');
    $('#analytics').hide();


    $('#adminMenu').click(function () {
        $('#admin').slideDown("slow");
        $('#contents').hide();
        $('#analytics').hide();
        $('#users').hide();
        $('#analytics').hide();
        $('#validation').hide();
        $('#adminMenu').addClass('active');
        $('#contentMenu').removeClass('active');
        $('#usersMenu').removeClass('active');
        $('#analyticsMenu').removeClass('active');
        $('#validationMenu').removeClass('active');

        return false;
    });

    $('#contentMenu').click(function () {
        $('#admin').hide();
        $('#contents').slideDown("slow");
        $('#users').hide();
        $('#analytics').hide();
        $('#analytics').hide();
        $('#validation').hide();
        $('#adminMenu').removeClass('active');
        $('#contentMenu').addClass('active');
        $('#usersMenu').removeClass('active');
        $('#analyticsMenu').removeClass('active');
        $('#validationMenu').removeClass('active');

        return false;
    });

    $('#usersMenu').click(function () {
        $('#admin').hide();
        $('#contents').hide();
        $('#analytics').hide();
        $('#users').slideDown("slow");
        $('#analytics').hide();
        $('#validation').hide();
        $('#adminMenu').removeClass('active');
        $('#contentMenu').removeClass('active');
        $('#usersMenu').addClass('active');
        $('#analyticsMenu').removeClass('active');
        $('#validationMenu').removeClass('active');

        return false;
    });
    
    $('#validationMenu').click(function () {
        $('#admin').hide();
        $('#analytics').hide();
        $('#contents').hide();
        $('#users').hide();
        $('#analytics').hide();
        $('#validation').slideDown("slow");
        $('#adminMenu').removeClass('active');
        $('#contentMenu').removeClass('active');
        $('#usersMenu').removeClass('active');
        $('#analyticsMenu').removeClass('active');
        $('#validationMenu').addClass('active');

        return false;
    });
    
    $('#analyticsMenu').click(function () {
        $('#admin').hide();
        $('#contents').hide();
        $('#users').hide();
        $('#validation').hide();
        $('#analytics').slideDown("slow");
        $('#adminMenu').removeClass('active');
        $('#contentMenu').removeClass('active');
        $('#usersMenu').removeClass('active');
        $('#validationMenu').removeClass('active');
        $('#analyticsMenu').addClass('active');

        return false;
    });

});
