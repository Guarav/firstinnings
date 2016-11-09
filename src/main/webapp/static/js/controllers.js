
firstinnings.controller('renew-member-controller', ['$scope', 'httpService', function($scope, httpService) {

    $scope.init = function() {
    };

    $scope.findMember = function(medium, value) {


        httpService.post('/findMember', serializeData({medium : medium, value : value}))
            .success(function(response){
                if(response.member) {
                    $scope.members = [response.member];
                } else {
                    $scope.members = null;
                }
            })
            .error(function(response) {

            })

    };

    $scope.selectMember = function(member) {
        $('#membership_id').val(member.memberId)
    };

}]);