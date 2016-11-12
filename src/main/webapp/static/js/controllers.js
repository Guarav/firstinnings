firstinnings.controller('renew-member-controller', ['$scope', 'httpService', function ($scope, httpService) {

    $scope.findMember = function () {

        httpService.post('/findMember', serializeData({medium: $scope.medium, value: $scope.value}))
            .success(function (response) {
                if (response.member) {
                    $scope.members = [response.member];
                } else {
                    $scope.members = null;
                    $scope.errorMessage = "No results found";
                }
            })
            .error(function (response) {

            })

    };

    $scope.selectMember = function (member) {
        $('#membership_id').val(member.memberId)
    };

}]);