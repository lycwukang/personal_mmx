<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta charset="UTF-8">
    <title>${site.title}</title>
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/site.css">
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/site.js"></script>
</head>
<body>
<div id="canvasWrapper">
    <div id="canvas">
        <div id="mobileNav">
            <div class="wrapper">
                <nav class="main-nav mobile-nav">
                    <ul>
                        <c:forEach items="${menu}" var="om">
                        <li class="<c:if test="${om.value.active}">active-link</c:if> <c:if test="${om.value.isChild}">mobile-folder</c:if>">
                            <a href="${om.value.path}">${om.key}</a>
                            <c:if test="${om.value.isChild}">
                            <div class="subnav">
                                <ul>
                                    <c:forEach items="${om.value.childs}" var="cm">
                                        <li class="gallery-collection"><a href="${cm.value.path}">${cm.key}</a></li>
                                    </c:forEach>
                                </ul>
                            </div>
                            </c:if>
                        </li>
                        </c:forEach>
                    </ul>
                </nav>
            </div>
        </div>
        <div id="headerWrapper">
            <header id="header">
                <div id="topNavMobile">
                    <nav id="mobileMenuLink" class="main-nav clear">
                        <ul><li class="active-link"><a>${site.menuButton}</a></li></ul>
                    </nav>
                </div>
                <div id="logo">
                    <h1 class="logo image">
                        <a href="/"><img src="${site.logo}" alt="logo"></a>
                    </h1>
                    <div class="logo-subtitle">${site.email}</div>
                </div>
                <div id="topNav">
                    <nav id="mainNavigation" class="main-nav">
                        <ul>
                            <c:forEach items="${menu}" var="om">
                            <li class="<c:if test="${om.value.active}">active-link</c:if> <c:if test="${om.value.isChild}">folder</c:if>">
                                <a href="${om.value.path}">${om.key}</a>
                                <c:if test="${om.value.isChild}">
                                    <div class="subnav">
                                        <ul>
                                            <c:forEach items="${om.value.childs}" var="cm">
                                            <li><a href="${cm.value.path}">${cm.key}</a></li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </c:if>
                            </li>
                            </c:forEach>
                        </ul>
                    </nav>
                </div>
                <div id="topLink">
                    <c:if test="${site.isFacebookLink}">
                    <a href="${site.facebookLink}"><i class="fa fa-facebook"></i></a>
                    </c:if>
                    <c:if test="${site.isTwitterLink}">
                    <a href="${site.twitterLink}"><i class="fa fa-twitter"></i></a>
                    </c:if>
                    <c:if test="${site.isInstagramLink}">
                    <a href="${site.instagramLink}"><i class="fa fa-instagram"></i></a>
                    </c:if>
                    <c:if test="${site.isLinkedinLink}">
                    <a href="${site.linkedinLink}"><i class="fa fa-linkedin"></i></a>
                    </c:if>
                    <c:if test="${site.isEnvelopeLink}">
                    <a href="${site.envelopeLink}"><i class="fa fa-envelope"></i></a>
                    </c:if>
                    <c:if test="${site.isSoundcloudLink}">
                    <a href="${site.soundcloudLink}"><i class="fa fa-soundcloud"></i></a>
                    </c:if>
                    <c:if test="${site.isTumblrLink}">
                    <a href="${site.tumblrLink}"><i class="fa fa-tumblr"></i></a>
                    </c:if>
                </div>
            </header>
        </div>
        <div id="pageWrapper">
            <section class="page">
                <div id="galleryWrapper">
                    <div id="slideshowWrapper">
                        <div id="slideshow">
                            <c:forEach items="${data}" var="dt">
                            <div class="slide j-slide j-slide-${dt.number} <c:if test="${dt.hidden}">hidden</c:if>" data-class="j-slide-${dt.number}">
                                <img src="${dt.image}" alt="${dt.title}" />
                                <div class="image-title-mobile"><strong>${dt.title}</strong></div>
                                <div class="image-desc-mobile"><p>${dt.desc}</p></div>
                            </div>
                            </c:forEach>
                        </div>
                        <div class="overlay-controls left-control"></div>
                        <div class="overlay-controls center-control thumbnail-toggle"></div>
                        <div class="overlay-controls right-control"></div>
                        <div id="thumbnails">
                            <c:forEach items="${data}" var="dt">
                            <div class="thumb">
                                <img data-class="j-slide-${dt.number}" src="${dt.image}" alt="${dt.title}" />
                            </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="meta">
                        <div id="imageData">
                            <c:forEach items="${data}" var="dt">
                            <div class="slide-meta-wrapper j-slide j-slide-${dt.number} <c:if test="${dt.hidden}">hidden</c:if>">
                                <div class="image-title"><strong>${dt.title}</strong></div>
                                <div class="image-desc"><p>${dt.desc}</p></div>
                            </div>
                            </c:forEach>
                        </div>
                        <div id="simpleControls" class="gallery-controls">
                            <span class="control prev-slide">${site.prevButton}</span> / <span class="control next-slide">${site.nextButton}</span>
                        </div>
                        <div class="thumbnail-toggle">${site.thumbnailsButton}</div>
                    </div>
                </div>
            </section>
        </div>
    </div>
</div>
</body>
</html>