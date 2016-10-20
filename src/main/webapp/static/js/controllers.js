
firstinnings.controller('renew-member-controller', ['$scope', 'httpService', function($scope, httpService) {

    $scope.init = function() {
        alert(0);
    };

    $scope.findMember = function(medium, value) {


        httpService.post('/findMember', serializeData({medium : medium, value : value}))
            .success(function(response){
                $scope.members = [response.member];
            })
            .error(function(response) {

            })

    };

}]);


/**
 * This methods serialize the object in the form of query params to be used for form post.
 * @param data the data to be converted
 * @returns {string} the string after conversion
 */
function serializeData(data) {
    // If this is not an object, defer to native stringification.
    if (!angular.isObject(data)) {
        return ( ( data == null ) ? "" : data.toString() );
    }

    var buffer = [];

    // Serialize each key in the object.
    for (var name in data) {
        if (!data.hasOwnProperty(name)) {
            continue;
        }

        var value = data[name];

        buffer.push(
            encodeURIComponent(name) + "=" + encodeURIComponent(( value == null ) ? "" : value)
        );
    }

    // Serialize the buffer and clean it up for transportation.
    return buffer.join("&").replace(/%20/g, "+");
}