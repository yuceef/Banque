var app = angular.module('myBanque',['ngRoute']).config(function($routeProvider) {
    $routeProvider.when('/home', {
        templateUrl : 'home.html',
        controller : 'homeCtrl'
    })
    .when('/compte/:codeCompte', {
        templateUrl : 'compte.html',
        controller : 'compteCtrl'
    })
    .when('/addcompte', {
        templateUrl : 'addcompte.html',
        controller : 'addcompteCtrl'
    })
    .when('/addclient', {
        templateUrl : 'addclient.html',
        controller : 'addclientCtrl'
    })
    .when('/virement', {
        templateUrl : 'virement.html',
        controller : 'virementCtrl'
    })
    .otherwise({
        redirectTo : '/home'
    });
});
app.filter('range', function() {
    return function(input, total) {
      total = parseInt(total);
  
      for (var i=0; i<total; i++) {
        input.push(i);
      }
  
      return input;
    };
  });
app.controller("homeCtrl",function($scope){
    $scope.codeCompte = ""
})
app.controller("virementCtrl",function($scope,$http){   
    $scope.code1 = ""
    $scope.code2 = ""
    $scope.montant = ""
    $scope.virement = function () {
        
        $http.put("http://127.0.0.1:8080/api/virement?codeEmpl=3&code1="+$scope.code1+"&code2="+$scope.code2+"&montant="+$scope.montant).then((data)=>{
            $scope.code1 = " "
            $scope.code2 = " "
            $scope.montant = " "
            
        },(err)=>{            
            alert(err.data.message)
        })
    }
})
app.controller("addclientCtrl",function($scope,$http){
    $scope.nomClient = ""
    $scope.addclient = function () {        
        $http.post("http://127.0.0.1:8080/api/clients",{"nomClient":$scope.nomClient}).then((data)=>{
                $scope.nomClient = " "
            
        },(err)=>{            
            alert(err.data.message)
        })
    }
})
app.controller("addcompteCtrl",function($scope,$http){
    $scope.typeCompte = "CC"
    $scope.codeCompte = ""
    $scope.solde = ""
    $scope.client = ""
    $scope.addcompte = function () {        
        compte={
            "type_compte":$scope.typeCompte,
            "codeCompte":$scope.codeCompte,
            "solde":$scope.solde,
            "client":{"codeClient":$scope.client},
            "employe":{"codeEmploye":3}
        }
        
        $http.post("http://127.0.0.1:8080/api/comptes",compte).then((data)=>{
            $scope.codeCompte = " "
            $scope.solde = " "
            $scope.client = " "    
            $scope.typeCompte = "CC"        
        },(err)=>{            
            alert(err.data.message)
        })
    }
})
app.controller("compteCtrl",function($scope,$http,$routeParams){
    $scope.operationFaire = "versement"
    $scope.pageOperations = 0
    getCompte()
    getOperations()
    $scope.getOperations = function(page){
        $scope.pageOperations = page
        getOperations()
    }
    $scope.faireOperation = function(){
        $http.put("http://127.0.0.1:8080/api/"+$scope.operationFaire+"?code="+$routeParams.codeCompte+"&montant="+parseInt($scope.montantFaire)+"&codeEmpl=3").then((data,error)=>{
            if(data.data == true){
                $scope.operationFaire = "versement"
            }
        },(err)=>{            
            alert(err.data.message)
        })
        
    }
    function getCompte(){
        $http.get("http://127.0.0.1:8080/api/comptes/"+$routeParams.codeCompte).then((data)=>{
            $scope.compte = data.data
        })
    }
    function getOperations(){
        $http.get("http://127.0.0.1:8080/api/getOperation?size=5&codeCompte="+$routeParams.codeCompte+"&page="+$scope.pageOperations).then((data)=>{
            $scope.operations = data.data
            console.log(data.data);
            
        })
    }
})