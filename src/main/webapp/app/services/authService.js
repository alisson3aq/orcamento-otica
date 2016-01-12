(function() {
    mainApp.factory('securityService', securityService);

    function securityService() {

        var service = {
            authenticate : authenticate,
            isAuthenticated : isAuthenticated,
            getLoggedUserData : getLoggedUserData,
            logout : logout
        }

        return service;

        function authenticate(data) {
            localStorage.setItem('authToken', data);
        }

        function isAuthenticated() {
            var data = localStorage.getItem('authToken');

            if (data) {
                return true;
            } else {
                return false
            }
        }

        function getLoggedUserData() {
            if (isAuthenticated()) {
                return localStorage.getItem('authToken');
            } else {
                return undefined;
            }
        }

        function logout() {
            localStorage.removeItem('authToken');
        }
    }
})();