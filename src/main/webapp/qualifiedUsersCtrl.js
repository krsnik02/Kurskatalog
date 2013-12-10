'use strict';

ngQualifiedUsersApp.controller('qualifiedUsersCtrl', ['$scope', '$http', function (scope, http) {
    scope.query = '';

    scope.users = [
        { "id": "0", "firstName": "Timothy", "lastName": "Wilson", "email": "timothy.james.wilson@gmail.com", "userCode": "twilson" },
        { "id": "1", "firstName": "Ryan", "lastName": "Duquette", "email": "ryan.duqeutte@gmail.com", "userCode": "rduquette" },
        { "id": "2", "firstName": "Sarah", "lastName": "Wilson", "email": "sarah.wilson@gmail.com", "userCode": "0003" }
    ];

    scope.returnedData;
    //http.get('http://api.flickr.com/services/feeds/photos_public.gne?tags=surf,pipeline&tagmode=all&format=json&jsoncallback=?').success(function (data) {
    //    console.log(data);
    //    scope.returnedData = data;

    //}).error(function (error) { console.log(error);});

    scope.projects = [];

    scope.getProjects = function(e, id){
        e.preventDefault();

        if (id == 0) {
            //tim's projects
            scope.projects = [
                { "name": "Wilson Name Project", "code": "WIT" },
                { "name": "Lance Technologies", "code": "99999" },
                { "name": "IVR Technology Group", "code": "companyacronymn" },
                { "name": "Corning Glass", "code": "viewassessm" },
                { "name": "Walmart", "code": "sellfromchina" },
                { "name": "Subway", "code":"11-13-2013"},
                { "name": "China Star", "code": "findapet" },
                { "name": "New Fuji Buffet", "code":"poachedeggs"},
                { "name": "Buffalos Best", "code": "alansfriend" }
            ]
        }

        if (id == 1) {
            //ryan's projects
            scope.projects = [
                { "name": "Company Name Project", "code": "companyacronymn" },
                { "name": "Company Name Project", "code": "11-13-2013" },
                { "name": "Company Name Project", "code": "companyacronymn" },
                { "name": "Company Name Project", "code": "11-13-2013" },
                { "name": "Company Name Project", "code": "companyacronymn" },
                { "name": "Company Name Project", "code":"11-13-2013"},
                { "name": "Company Name Project", "code": "companyacronymn" },
                { "name": "Company Name Project", "code":"11-13-2013"},
                { "name": "Company Name Project", "code": "companyacronymn" },
                { "name": "Company Name Project", "code":"11-13-2013"}
            ]
        }

        if (id == 2) {
            //sarah's projects
            //no projects available so display that message
            scope.projects = [];
        }
    }
}]);
