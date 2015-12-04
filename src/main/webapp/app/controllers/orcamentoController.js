mainApp
.controller('orcamentoController', function($scope) {
    $scope.printDiv = function(divName) {
          var printContents = document.getElementById(divName).innerHTML;
          var popupWin = window.open('', '_blank');
          popupWin.document.open()
          popupWin.document.write('<html><head><link rel="stylesheet" type="text/css" href="style.css" /></head><body onload="window.print()">' + printContents + '</html>');
          popupWin.document.close();
        }

    $scope.exportToPDF = function(){
        window.open("/reportServlet", "_blank");
    }
})