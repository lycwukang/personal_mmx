项目数据存储方式：
===========

数据使用外部文件调用方式访问，格式以.json的文件为主

数据编辑：
===========

数据目录下必须存在`site.json`和`menu.json`文件

site.json:
-----------

```json
{
    "title": "title",
    "logo": "image/logo.jpeg",
    "email": "liskfeng@gmail.com",
    "menuButton": "Menu",
    "prevButton": "PREV",
    "nextButton": "NEXT",
    "thumbnailsButton": "SHOW THUMBNAILS",
    "facebookLink": "",
    "twitterLink": "",
    "instagramLink": "",
    "linkedinLink": "",
    "envelopeLink": "",
    "soundcloudLink": "",
    "tumblrLink": ""
}
```
title: 页面标题<br>
logo: logo图片地址<br>
email: 联系邮箱<br>
menuButton: 菜单按钮名称<br>
prevButton: 上一张图片按钮名称<br>
nextButton: 下一张图片按钮名称<br>
thumbnailsButton: 显示缩略图按钮名称<br>
facebookLink: facebook个人主页链接，不填写则不显示按钮<br>
twitterLink: twitter个人主页链接，不填写则不显示按钮<br>
instagramLink: instagram个人主页链接，不填写则不显示按钮<br>
linkedinLink: linkedin个人主页链接，不填写则不显示按钮<br>
envelopeLink: envelope个人主页链接，不填写则不显示按钮<br>
soundcloudLink: soundcloud个人主页链接，不填写则不显示按钮<br>
tumblrLink: tumblr个人主页链接，不填写则不显示按钮

menu.json:
-----------

```json
{
	"Home": {
		"path": "/index"
	},
	"关于": {
		"path": "/about"
	},
	"Exhibitions": {
		"childs": {
			"Now I An An Artist": {
				"path": "/artist"
			},
			"Now I An An Artist2": {
				"path": "/artist2"
			}
		}
	}
}
```
`key`是菜单显示的名称<br>
`path`是菜单访问的路径<br>
`childs`预示包含二级菜单<br>
首页的`path`固定为`/index`，关于页面的`path`固定为`/about`<br>
每一个页面对应`/page`目录下的文件，例如`/index`对应`/page/index.json`文件<br>
其中`about.json`是特殊格式，其余页面为统一格式

统一格式.json
-------------

```json
[{
    "image": "image/final-flatter.jpg",
    "title": "Groucho Club- Hay Festival",
    "desc": "An illustration to promote the Groucho Club's pop up at Hay Festival 2015."
}, {
    "image": "image/MoralFibrerevisions2.jpg",
    "title": "The Boston Globe- Still Breaking All The Rules",
    "desc": "I worked on a series of illustrations for a package about the baby boomer generation getting older."
}, {
    "image": "image/b1.jpg",
    "title": "",
    "desc": ""
}, {
    "image": "image/all-elements.jpg",
    "title": "The Groucho Club- Menu Illustrations",
    "desc": "A series of spot illustrations for the Groucho Club's new menu"
}]
```
统一页面内容为多张图片，每张图片对于一个标题和介绍<br>
image: 图片地址<br>
title: 图片标题，可不填<br>
desc: 图片介绍，可不填

about.json
-----------

```json
[{
    "titles": ["Rose Blake"]
}, {
    "image": "image/person.jpeg"
}, {
    "titles": ["Representation","Fine Art"],
    "descs": ["((USA + UK))-&nbsp;Rebecca Hossack Gallery", "info@rebeccahossack.com &nbsp;+44 0 20 7436 4899"]
}, {
    "titles": ["Selected Clients"],
    "descs": [
        "The New Yorker .&nbsp;The New York Times .&nbsp;The Sunday Times Magazine . The Guardian . &nbsp;Volkswagen . Disney . TFL . Wallpaper* . Soho House Group. The Ned .&nbsp;New Statesman .&nbsp;bbc.co.uk .&nbsp;Google Creative Lab .&nbsp;Stella McCartney Kids .&nbsp;BBC4.&nbsp;The Boston Globe . Stella Magazine . Nationwide . &nbsp;Phillips . Thameslink . Tate .&nbsp;Heals . Cartoon Network . Tatler . &nbsp;V&amp;A Museum of Childhood .&nbsp;The Groucho Club . New York Magazine. &nbsp;FutureBrand .&nbsp;&nbsp;Markus Lupfer . Bon Appetit .&nbsp;Martha Stewart Living . Converse . Drakes .&nbsp;The Telegraph . &nbsp;The Independent on Sunday . Random House . asos.com . &nbsp;Walker Books &nbsp;. Psychologies Magazine . &nbsp;It's Nice That Magazine . INT Works- Unilever . Sekret Firmy . Management Today . Doberman . Nick Lowe- Yep Roc Records . &nbsp; Passion Pictures . Nobrow . Studio Output- Penguin Books . Hornet Inc . Film 4- Somerset House .&nbsp;Zizzi Restaurants . Lux Magazine . Sophie Hulme . Visual Editions .&nbsp;&nbsp;Metropolitan Magazine (Eurostar) ."
    ]
}]
```
关于页面包含多块内容，每块内容可以选择图片内容，或标题+文字的内容<br>
image： 图片地址，填写了image就不用填写titles和descs了<br>
titles: 标题数组，标题会显示在最上面<br>
descs: 文字数组，文字会显示在标题的下面
