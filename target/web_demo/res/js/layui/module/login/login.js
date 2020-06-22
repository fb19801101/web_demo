layui.define(["layer","jquery"],function (exports) {
    var login = {
        login : function (url,data,$,targetUrl) {
            $.post(url,{code:data.code},function (res) {
                if (res.code && res.code === 400){
                    layer.msg(res.msg,{icon:1},function () {
                        window.location.href = targetUrl;
                    });
                }else{
                    layer.msg(res.msg,{icon:1},function () {
                        window.location.href = targetUrl;
                    });
                }
            });
        }
    };
    exports("login", login);
});
