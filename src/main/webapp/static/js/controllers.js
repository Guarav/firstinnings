// Renew member controller
firstinnings.controller('subscription-member-controller', ['$scope', 'httpService', function ($scope, httpService) {

    $scope.findMember = function () {

        httpService.post('/findMember', serializeData({medium: $scope.medium, value: $scope.value}))
            .success(function (response) {
                if (response.member) {
                    $scope.member = [response.member][0];
                    $scope.member.membershipDate = convertDateToString($scope.member.membershipDate);
                    $scope.member.birthDate = convertDateToString($scope.member.birthDate);
                    $('#membership_id').val(member.memberId)
                } else {
                    $scope.member = null;
                    $scope.errorMessage = "No results found";
                }
            })

    };

    $scope.selectMember = function (member) {

    };

}]);


// Update Member controller.
firstinnings.controller('update-member-controller', ['$scope', 'httpService', function($scope, httpService) {

    $scope.findMember = function () {

        httpService.post('/findMember', serializeData({medium: $scope.medium, value: $scope.value}))
            .success(function (response) {
                if (response.member) {
                    $scope.member = [response.member][0];
                    $scope.member.membershipDate = convertDateToString($scope.member.membershipDate);
                    $scope.member.birthDate = convertDateToString($scope.member.birthDate);
                    $('#membership_id').val(response.member.memberId)
                } else {
                    $scope.members = null;
                    $scope.errorMessage = "No results found";
                }
            })

    };

}]);

