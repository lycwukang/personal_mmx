$(function () {
    $(function () {
        var subnav = $('#mainNavigation').find('.subnav.open');
        subnav.animate({height: subnav.find('ul').outerHeight() + 'px'});
    });

    $('#mainNavigation .folder a').on('click', function () {
        var subnav = $(this).parent().find('.subnav');
        if (!subnav.hasClass('open')) {
            // 关闭其他
            var other = subnav.closest('#mainNavigation').find('.subnav.open');
            if (other.length > 0) {
                other.animate({height: '0px'});
                other.toggleClass('open');
            }
            // 展开自身
            subnav.toggleClass('open');
            subnav.animate({height: subnav.find('ul').outerHeight() + 'px'});
        } else {
            subnav.toggleClass('open');
            subnav.animate({height: '0px'});
        }
    });

    $('#mobileMenuLink a').on('click', function () {
        var mobileMav = $('#mobileNav');
        mobileMav.toggleClass('menu-open');
        mobileMav.animate({height: (mobileMav.hasClass('menu-open') ? mobileMav.find('.wrapper').outerHeight() : '0') + 'px'});
    });

    $('#simpleControls .prev-slide, .overlay-controls.left-control').on('click', function () {
        var showSlide = $('#slideshow .slide:not(.hidden)');
        var nextSlide = showSlide.prev();
        if (nextSlide.length == 0) {
            nextSlide = $('#slideshow .slide:last-child');
        }
        $('.j-slide').addClass('hidden');
        $('.' + nextSlide.data('class')).removeClass('hidden');
    });

    $('#simpleControls .next-slide, .overlay-controls.right-control').on('click', function () {
        var showSlide = $('#slideshow .slide:not(.hidden)');
        var nextSlide = showSlide.next();
        if (nextSlide.length == 0) {
            nextSlide = $('#slideshow .slide:first-child');
        }
        $('.j-slide').addClass('hidden');
        $('.' + nextSlide.data('class')).removeClass('hidden');
    });

    $('.thumbnail-toggle').on('click', function () {
        $('#galleryWrapper').toggleClass('thumbnails');
    });

    $('#thumbnails .thumb img').on('click', function () {
        $('#galleryWrapper').toggleClass('thumbnails');
        $('.j-slide').addClass('hidden');
        $('.' + $(this).data('class')).removeClass('hidden');
    });
});