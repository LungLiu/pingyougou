//控制层
app.controller('userController', function ($scope, $controller, userService) {

    //注册用户
    $scope.reg = function () {

        //比较两次输入的密码是否一致,且不为空
        if ($scope.entity.password != $scope.password || !$scope.entity.password) {
            alert("两次输入的密码不一致，请重新确认");
            $scope.password = "";//清空确认密码
            return;
        }
        //新增
        userService.add($scope.entity,$scope.smscode).success(function (response) {
            if(response.success){
                //注册成功
                alert(response.message);
            }else {
                //注册失败或验证码有误
                alert(response.message);
                $scope.smscode = "";//验证码清除
            }
        });
    }

    //发送验证码
    $scope.sendCode = function () {

        //发送验证码前，先判断两次密码一致，且不为空
        if ($scope.entity.password != $scope.password || !$scope.entity.password) {
            alert("请确认密码");
            $scope.password = "";//清空确认密码
            return;
        }
        if (!$scope.entity.phone) {
            alert("手机号不能为空");
            return;
        }
        userService.sendCode($scope.entity.phone).success(function (response) {
            alert(response.message);
        })
    }

});	
