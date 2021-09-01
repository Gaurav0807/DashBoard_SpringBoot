$(".nav").click(function () {
      $("#mySidenav").css('width', '80px');
      $("#main").css('margin-left', '80px');

      $(".icon-a").css('visibility', 'hidden');
      $(".icon-b").css('visibility', 'hidden');
      $(".icons").css('visibility', 'visible');
      $(".icons").css('margin-left', '-8px');
      $(".nav").css('display', 'none');
      $(".nav2").css('display', 'block');
    });

    $(".nav2").click(function () {
      $("#mySidenav").css('width', '300px');
      $("#main").css('margin-left', '300px');

      $(".icon-a").css('visibility', 'visible');
      $(".icon-b").css('visibility', 'visible');
      $(".icons").css('visibility', 'visible');
      $(".nav").css('display', 'block');
      $(".nav2").css('display', 'none');
    });

    function load_user() {
      document.getElementById("div1").innerHTML = '<iframe src="User/add_user.html" style="width:100%; height:100%; overflow: hidden; border:none;"  seamless="seamless"></iframe>';
    }
    function view_user() {
      document.getElementById("div1").innerHTML = '<iframe src="User/view_user.html" style="width:100%; height:100%; overflow: hidden; border:none;"  seamless="seamless"></iframe>';
    }
    function load_role() {
      document.getElementById("div1").innerHTML = '<iframe src="Role/add_role.html" style="width:100%; height:100%; overflow: hidden; border:none;" scrolling="no"  seamless="seamless"></iframe>';
    }
    function load_rights() {
      document.getElementById("div1").innerHTML = '<iframe src="Role/role_rights.html" style="width:100%; height:100%; overflow: hidden; border:none;" scrolling="no"  seamless="seamless"></iframe>';
    }
    function view_role() {
      document.getElementById("div1").innerHTML = '<iframe src="Role/view_role.html" style="width:100%; height:100%; overflow: hidden; border:none;"  seamless="seamless"></iframe>';
    }

    function reveal1() {
      var x = document.querySelector(".toggle1").style;
      if (x.display == 'none' || x.display == '') {
        x.display = 'block';
      } else {
        x.display = 'none';
      }
    }

    function reveal2() {
      var x = document.querySelector(".toggle2").style;
      if (x.display == 'none' || x.display == '') {
        x.display = 'block';
      } else {
        x.display = 'none';
      }
    }