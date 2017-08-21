<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta charset="UTF-8">
    <title>${site.title}</title>
    <link rel="shortcut icon" type="image/x-icon" href="/favicon.ico">
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
                        <li class="<c:if test="${om.active}">active-link</c:if> <c:if test="${om.childAble}">mobile-folder</c:if>">
                            <a href="${om.path}">${om.name}</a>
                            <c:if test="${om.childAble}">
                                <div class="subnav">
                                    <ul>
                                        <c:forEach items="${om.childs}" var="cm">
                                            <li class="gallery-collection"><a href="${cm.path}">${cm.name}</a></li>
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
                            <li class="<c:if test="${om.active}">active-link</c:if> <c:if test="${om.childAble}">folder</c:if>">
                                <a href="${om.path}">${om.name}</a>
                                <c:if test="${om.childAble}">
                                    <div class="subnav">
                                        <ul>
                                            <c:forEach items="${om.childs}" var="cm">
                                                <li><a href="${cm.path}">${cm.name}</a></li>
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
                <c:forEach items="${data}" var="dt">
                <div class="sqs-block-content">
                    <c:if test="${dt.imageAble}">
                    <div class="image-content">
                        <img src="${dt.image}" />
                    </div>
                    </c:if>
                    <c:forEach items="${dt.titles}" var="title">
                    <p class="text-align-center"><strong>${title.value}</strong></p>
                    </c:forEach>
                    <c:forEach items="${dt.descs}" var="desc">
                    <p class="text-align-center">${desc.value}</p>
                    </c:forEach>
                </div>
                </c:forEach>
            </section>
        </div>
    </div>
</div>
</body>
</html>