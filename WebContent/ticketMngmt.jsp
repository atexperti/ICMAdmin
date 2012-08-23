<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ICM ADMIN PANEL</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript" src="clockp.js"></script>
<script type="text/javascript" src="clockh.js"></script>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="ddaccordion.js"></script>
<script type="text/javascript">
ddaccordion.init({
	headerclass: "submenuheader", //Shared CSS class name of headers group
	contentclass: "submenu", //Shared CSS class name of contents group
	revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
	mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
	defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
	animatedefault: false, //Should contents open by default be animated into view?
	persiststate: true, //persist state of opened contents within browser session?
	toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
	togglehtml: ["suffix", "<img src='images/plus.gif' class='statusicon' />", "<img src='images/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
})
</script>
<script type="text/javascript" src="jconfirmaction.jquery.js"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
		$('.ask').jConfirmAction();
	});
	
</script>
<script language="javascript" type="text/javascript" src="niceforms.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="niceforms-default.css" />
</head>
<body>
<div id="main_container">
  <div class="header">
    <div class="logo"><a href="#"><img src="images/logo.jpg" alt="" title="" border="0" /></a></div>
    <div class="right_header">Welcome Admin, <a href="#">Visit site</a> | <a href="#" class="messages">(3) Messages</a> | <a href="#" class="logout">Logout</a></div>
    <div id="clock_a"></div>
  </div>
  <div class="main_content">
    <div class="menu">
      <ul>
        <li><a  href="index.html">Admin Home</a></li>
        <li><a  href="media1.html">Media </a></li>
        <li><a href="event.html"> Event</a></li>
        <li><a href="articles.html"> Article </a></li>
        <li><a href="lyrics.html"> Lyrics </a></li>
        <li><a  href="order.html">	Order Management </a></li>
		<li><a href="user.html"> User Management </a></li>
		<li><a class="current" href="ticketmngt.html"> Ticket Managemnet </a></li>
          <!--<![endif]-->
          <!--[if lte IE 6]><table><tr><td><![endif]-->
          <ul>
            <li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
            <li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
            <li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
            <li><a class="sub1" href="" title="">sublevel2
              <!--[if IE 7]><!-->
              </a>
              <!--<![endif]-->
              <!--[if lte IE 6]><table><tr><td><![endif]-->
              <ul>
                <li><a href="" title="">sublevel link</a></li>
                <li><a href="" title="">sulevel link</a></li>
                <li><a class="sub2" href="#nogo">sublevel3
                  <!--[if IE 7]><!-->
                  </a>
                  <!--<![endif]-->
                  <!--[if lte IE 6]><table><tr><td><![endif]-->
                  <ul>
                    <li><a href="#nogo">Third level-1</a></li>
                    <li><a href="#nogo">Third level-2</a></li>
                    <li><a href="#nogo">Third level-3</a></li>
                    <li><a href="#nogo">Third level-4</a></li>
                  </ul>
                  <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                </li>
                <li><a href="" title="">sulevel link</a></li>
              </ul>
              <!--[if lte IE 6]></td></tr></table></a><![endif]-->
            </li>
            <li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
          </ul>
          <!--[if lte IE 6]></td></tr></table></a><![endif]-->
        </li>
        <li>
          <!--<![endif]-->
          <!--[if lte IE 6]><table><tr><td><![endif]-->
          <ul>
            <li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
            <li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
            <li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
            <li><a class="sub1" href="" title="">sublevel2
              <!--[if IE 7]><!-->
              </a>
              <!--<![endif]-->
              <!--[if lte IE 6]><table><tr><td><![endif]-->
              <ul>
                <li><a href="" title="">sublevel link</a></li>
                <li><a href="" title="">sulevel link</a></li>
                <li><a class="sub2" href="#nogo">sublevel3
                  <!--[if IE 7]><!-->
                  </a>
                  <!--<![endif]-->
                  <!--[if lte IE 6]><table><tr><td><![endif]-->
                  <ul>
                    <li><a href="#nogo">Third level-1</a></li>
                    <li><a href="#nogo">Third level-2</a></li>
                    <li><a href="#nogo">Third level-3</a></li>
                    <li><a href="#nogo">Third level-4</a></li>
                  </ul>
                  <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                </li>
                <li><a href="" title="">sulevel link</a></li>
              </ul>
              <!--[if lte IE 6]></td></tr></table></a><![endif]-->
            </li>
            <li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
          </ul>
          <!--[if lte IE 6]></td></tr></table></a><![endif]-->
        </li>
        <li>
          <!--<![endif]-->
          <!--[if lte IE 6]><table><tr><td><![endif]-->
          <ul>
            <li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
            <li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
            <li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
            <li><a class="sub1" href="" title="">sublevel2
              <!--[if IE 7]><!-->
              </a>
              <!--<![endif]-->
              <!--[if lte IE 6]><table><tr><td><![endif]-->
              <ul>
                <li><a href="" title="">sublevel link</a></li>
                <li><a href="" title="">sulevel link</a></li>
                <li><a class="sub2" href="#nogo">sublevel3
                  <!--[if IE 7]><!-->
                  </a>
                  <!--<![endif]-->
                  <!--[if lte IE 6]><table><tr><td><![endif]-->
                  <ul>
                    <li><a href="#nogo">Third level-1</a></li>
                    <li><a href="#nogo">Third level-2</a></li>
                    <li><a href="#nogo">Third level-3</a></li>
                    <li><a href="#nogo">Third level-4</a></li>
                  </ul>
                  <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                </li>
                <li><a href="" title="">sulevel link</a></li>
              </ul>
              <!--[if lte IE 6]></td></tr></table></a><![endif]-->
            </li>
            <li><a href="" title="">Lorem ipsum dolor sit amet</a></li>
          </ul>
          <!--[if lte IE 6]></td></tr></table></a><![endif]-->
        </li>
        <li></li>
        <li></li>
      </ul>
    </div>
    <div class="center_content">
      <div class="left_content">
        <div class="sidebar_search">
          <form>
            <input type="text" name="" class="search_input" value="search keyword" onclick="this.value=''" />
            <input type="image" class="search_submit" src="images/search.png" />
          </form>
        </div>
        <div class="sidebarmenu"> <a class="menuitem submenuheader" href="">Media Categories </a>
          <div class="submenu">
            <ul>
              <li><a href="">Vedio</a></li>
              <li><a href="">Audio</a></li>
              <li><a href="">Presentation</a></li>
              <li><a href="">Wallpaper</a></li>
              <li></li>
            </ul>
          </div>
          <a class="menuitem submenuheader" href="" >Language</a>
          <div class="submenu">
            <ul>
              <li><a href="">Telugu</a></li>
              <li><a href="">Tamil</a></li>
              <li><a href="">English</a></li>
              <li><a href="">Hindi</a></li>
              <li></li>
            </ul>
          </div>
          <a class="menuitem submenuheader" href="">Type</a>
          <div class="submenu">
            <ul>
              <li><a href="">Commercial</a></li>
              <li><a href="">Non-Commercial</a></li>
              <li></li>
              <li></li>
            </ul>
          </div>
          <a class="menuitem" href="">User Reference</a></div>
      </div>
      <div class="right_content">
       <h2>	Ticket Management</h2>
        <div>
		<table>
		<tr>
		<td class="m_select">
          <select name="select" class="select_m">
            <option> Media Categories </option>
            <option>Vedio</option>
            <option>Audio</option>
            <option>Presentation</option>
            <option>Wallpaper</option>
            <option>Website</option>
          </select>
		  </td>
		  <td class="m_select">
          <select name="select3" class="select_m">
            <option> Language </option>
            <option>Tamil</option>
            <option>Telugu</option>
            <option>English</option>
            <option>Hindi</option>
          </select>
		  </td>
		  <td class="m_select">
          <select name="select4" class="select_m">
            <option> Type </option>
            <option>Commercial</option>
            <option>Non Commercial</option>
          </select>
		  </td>
		  <td class="m_select">
          <select name="select6" class="select_m">
            <option> Date </option>
            <option>Date  1</option>
            <option>Date  2</option>
            <option>Date 3</option>
          </select>
		  </td></tr></table>
          <div class="clear"></div>
        </div>
        <table id="rounded-corner" summary="2007 Major IT Companies' Profit">
          <thead>
            <tr>
					
              <th scope="col" class="rounded-company"></th>
			  <th scope="col" class="rounded">User Id</th>	
              <th scope="col" class="rounded">User Name</th>
              <th scope="col" class="rounded">User Role</th>
              <th scope="col" class="rounded">Status</th>
              <th scope="col" class="rounded">Start Date</th>
			  <th scope="col" class="rounded">End Date</th>
              <th scope="col" class="rounded">Edit</th>
              <th scope="col" class="rounded-q4">Delete</th>
            </tr>
          </thead>
          <tfoot>
          </tfoot>
          <tbody>
            <tr>
              <td><input type="checkbox" name="" /></td>
			  <td>123</td>
              <td>Product name</td>
              <td>details</td>
              <td>Active/Inactive</td>
              <td>12/05/2010</td>
			  <td>12/05/2010</td>
              <td><a href="#"><img src="images/user_edit.png" alt="" title="" border="0" /></a></td>
              <td><a href="#" class="ask"><img src="images/trash.png" alt="" title="" border="0" /></a></td>
            </tr>
            <tr>
              <td><input type="checkbox" name="" /></td>
			  <td>123</td>
              <td>Product name</td>
              <td>details</td>
              <td>Active/Inactive</td>
              <td>12/05/2010</td>
			  <td>12/05/2010</td>
              <td><a href="#"><img src="images/user_edit.png" alt="" title="" border="0" /></a></td>
              <td><a href="#" class="ask"><img src="images/trash.png" alt="" title="" border="0" /></a></td>
            </tr>
            <tr>
              <td><input type="checkbox" name="" /></td>
			  <td>123</td>
              <td>Product name</td>
              <td>details</td>
              <td>Active/Inactive</td>
              <td>12/05/2010</td>
			  <td>12/05/2010</td>
              <td><a href="#"><img src="images/user_edit.png" alt="" title="" border="0" /></a></td>
              <td><a href="#" class="ask"><img src="images/trash.png" alt="" title="" border="0" /></a></td>
            </tr>
            <tr>
              <td><input type="checkbox" name="" /></td>
			  <td>1232</td>
              <td>Product name</td>
              <td>details</td>
              <td>Active/Inactive</td>
              <td>12/05/2010</td>
			  <td>12/05/2010</td>
              <td><a href="#"><img src="images/user_edit.png" alt="" title="" border="0" /></a></td>
              <td><a href="#" class="ask"><img src="images/trash.png" alt="" title="" border="0" /></a></td>
            </tr>
            <tr>
              <td><input type="checkbox" name="" /></td>
			  <td>123</td>
              <td>Product name</td>
              <td>details</td>
              <td>Active/Inactive</td>
              <td>12/05/2010</td>
			  <td>12/05/2010</td>
              <td><a href="#"><img src="images/user_edit.png" alt="" title="" border="0" /></a></td>

              <td><a href="#" class="ask"><img src="images/trash.png" alt="" title="" border="0" /></a></td>
            </tr>
            <tr>
              <td><input type="checkbox" name="" /></td>
			  <td>123</td>
              <td>Product name</td>
              <td>details</td>
              <td>Active/Inactive</td>
              <td>12/05/2010</td>
			  <td>12/05/2010</td>
              <td><a href="#"><img src="images/user_edit.png" alt="" title="" border="0" /></a></td>
              <td><a href="#" class="ask"><img src="images/trash.png" alt="" title="" border="0" /></a></td>
            </tr>
          </tbody>
        </table>
        <p>&nbsp;</p>
        <h2>&nbsp;</h2>
        <h2>&nbsp;</h2>
      </div>
      <!-- end of right content-->
    </div>
    <!--end of center content -->
    <div class="clear"></div>
  </div>
  <!--end of main content-->
  <div class="footer">
    <div class="left_footer">ICM ADMIN PANEL | Powered by <a href="http://joevin.com/icm"></a></div>
    <div class="right_footer"><a href="http://Atexperti.com"><img src="images/logo_bw.png" alt="" title="" border="0" /></a></div>
  </div>
</div>
</body>
</html>
