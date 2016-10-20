/**
 * Service for invoking any service APIs.
 */
firstinnings.service('httpService',['$http', '$q', function($http, $q) {

    /**
     * The caller function for http post.
     * @param url the url where to make the post call
     * @param input the data that needs to be passed with the call
     * @param config the extra information that needs to be passed, e.g headers
     * @returns {*}
     */
    this.post = function (url, input){
        config = {'headers': {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
                'request-Type' : 'ajax'
        }};
        return $http.post(url, input, config)
            .success(function(result) {
                return result;
            }).error(function (result) {
                return $q.reject(result);
            });
    };
}]);