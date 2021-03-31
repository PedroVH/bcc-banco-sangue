/*!
    * Start Bootstrap - Freelancer v6.0.5 (https://startbootstrap.com/theme/freelancer)
    * Copyright 2013-2020 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-freelancer/blob/master/LICENSE)
    */
    (function($) {
    "use strict"; // Start of use strict
  
    // Smooth scrolling using jQuery easing
    $('a.js-scroll-trigger[href*="#"]:not([href="#"])').click(function() {
      if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
        var target = $(this.hash);
        target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
        if (target.length) {
          $('html, body').animate({
            scrollTop: (target.offset().top - 71)
          }, 1000, "easeInOutExpo");
          return false;
        }
      }
    });
  
    // Scroll to top button appear
    $(document).scroll(function() {
      var scrollDistance = $(this).scrollTop();
      if (scrollDistance > 100) {
        $('.scroll-to-top').fadeIn();
      } else {
        $('.scroll-to-top').fadeOut();
      }
    });
  
    // Closes responsive menu when a scroll trigger link is clicked
    $('.js-scroll-trigger').click(function() {
      $('.navbar-collapse').collapse('hide');
    });
  
    // Activate scrollspy to add active class to navbar items on scroll
    $('body').scrollspy({
      target: '#mainNav',
      offset: 80
    });
  
    // Collapse Navbar
    var navbarCollapse = function() {
      if ($("#mainNav").offset().top > 100) {
        $("#mainNav").addClass("navbar-shrink");
      } else {
        $("#mainNav").removeClass("navbar-shrink");
      }
    };
    // Collapse now if page is not at top
    navbarCollapse();
    // Collapse the navbar when page is scrolled
    $(window).scroll(navbarCollapse);
  
    // Floating label headings for the contact form
    $(function() {
      $("body").on("input propertychange", ".floating-label-form-group", function(e) {
        $(this).toggleClass("floating-label-form-group-with-value", !!$(e.target).val());
      }).on("focus", ".floating-label-form-group", function() {
        $(this).addClass("floating-label-form-group-with-focus");
      }).on("blur", ".floating-label-form-group", function() {
        $(this).removeClass("floating-label-form-group-with-focus");
      });
    });
  
  })(jQuery); // End of use strict

/*
* My Functions
* =============================================================================
*/

/**
 * Edit
 * ----------------------------------------------------------------------------
 */
function sendQtdParaOTipo(){
  let url = "http://localhost:8080/tipo/" + document.getElementById("dropdownMenuCadastro").value + "/" + document.getElementById("qntdDepositar").value;
  console.log(url);
  let abacate = apiEDIT(url);
  abacate.then(console.log);
}

function deleteQtdParaOTipo(){
  let url = "http://localhost:8080/tipo/" + document.getElementById("dropdownMenuCadastro").value + "/" + -document.getElementById("qntdDepositar").value;
  console.log(url);
  let abacate = apiEDIT(url);
  abacate.then(console.log);
}

/**
 * Get
 * -----------------------------------------------------------------------------
 */
function getQuantidades(){
  loaderIcon();
}

function loaderIcon(){
  document.getElementById("dispLoader").style.display = "inline-block";
  document.getElementById("recepLoader").style.display = "inline-block";
  getQuantidadeDisponivel();
  getQuantidadeReceptor();
}

function hideLoaderIconDisp(){
  document.getElementById("dispLoader").style.display = "none";
}

function hideLoaderIconRecep(){
  document.getElementById("recepLoader").style.display = "none";
}

function getQuantidadeDisponivel() {
  console.log("http://localhost:8080/tipo/" + document.getElementById("dropdownMenu").value);
  let abacate = apiGET("http://localhost:8080/tipo/" + document.getElementById("dropdownMenu").value);
  abacate.then(console.log);
  abacate.then((data) => {
    setQtdDisponivel(data);
    hideLoaderIconDisp();
  });
}

function setQtdDisponivel(abacate) {
  document.getElementById("quantidadeDisponivel").innerText = abacate.data.qtdDisponivel + "ml";
}

function getQuantidadeReceptor() {
  console.log("http://localhost:8080/tipo/" + document.getElementById("dropdownMenu").value + "/receptor");
  let abacate = apiGET("http://localhost:8080/tipo/" + document.getElementById("dropdownMenu").value + "/receptor");
  abacate.then(console.log);
  abacate.then((data) => {
    setQtdReceptor(data);
    hideLoaderIconRecep();
  });
}

function setQtdReceptor(abacate) {
  document.getElementById("quantidadeReceptor").innerText = abacate.data + "ml";
}

/*
*  Get from API
* ------------------------------------------------------------------------------
*/
function apiGET(url) {
  return fetch(url, {
      method: 'GET',
      headers: {
          'Content-Type': 'application/json'
      },
  }).then((response) => {
      return response.json().then((data) => {
          let resultData = {data,response};
          return resultData;
      })
  }).catch((error) => {
      console.log(error);
      return error;
  });
}

/**
 * Edit in API
 * ------------------------------------------------------------------------------
 */
function apiEDIT(url){
  return fetch(url, {
      method: 'PUT',
      headers: {
          'Content-Type': 'application/json'
      },
  }).then((response) => {
      return response.json().then((data) => {
          return {data, response};
      })
  }).catch((error) => {
      console.log(error);
      return error;
  });
  
}