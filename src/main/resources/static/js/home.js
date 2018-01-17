
$(document).ready(function() {

    $("#importFileView").click(function() {
        var scmServer = $("#scmServer").val();
        var scmFilePath = $("#scmFilePath").val();
        var scmFileRevision = $("#scmFileRevision").val();
        $("#importFileView").attr('href', scmServer + scmFileRevision + "@" + scmFilePath);

    });

    //Class based selector 
    $(".href-select").click(function() {
        var propName = $(this).text();
        var propVal = $(this).attr('itemprop');
        $("#newProperty").attr('readonly', true);
        $("#newProperty").val(propName);
        $("#newValue").val(propVal);

        $("#savePropertyBtn").hide();
        $("#updatePropertyBtn").show();
    });

    //Id based selector
    $("#addPropertyBtn").click(function() {
        $("#newProperty").attr('readonly', false);
        $("#updatePropertyBtn").hide();
        $("#savePropertyBtn").show();
    });
});

var app = new Vue({
    el: '.app',
    data: {
        leafNodes: [],
        rightDatas: [],
        keyValue: {
            key:'',
            value:''
        },
        newNode:'',
        currentNode:'/',
    },
    mounted: function () {
        var _self = this;
        var parentPath=_self.$refs.parentPath.value;
        axiosUtils.get("/home/getChilds?zkPath="+parentPath)
            .then(function (res) {
                if (res.data.success) {
                    _self.leafNodes = res.data.data;
                }
            }).catch(function (reason) {
                console.log(reason);
        });
        axiosUtils.post('/home/getKVs',{zkPath:parentPath})
            .then(function (res) {
                if(res.data.success){
                    _self.rightDatas=res.data.data;
                }
            })
            .catch(function (reason) {
                console.log(reason);
            });
    },
    methods:{
        addNode:function(){
            var _self=this;
            var parentPath=_self.$refs.parentPath.value;
            var postData={
                parentNode:parentPath,
                node:_self.newNode
            };
            axiosUtils.post('/home/createNode',postData)
                .then(function (res) {
                    if(res.data.success){
                        alert('创建节点成功！');
                    }
                })
                .catch(function (reason) {
                    console.log(reason);
                });

        },
        addProperty:function () {
            var _self=this;
            var parentPath=_self.$refs.parentPath.value;
            var postData={
                parentNode:parentPath,
                key:_self.keyValue.key,
                value:_self.keyValue.value
            }
            axiosUtils.post('/home/addParameter',postData)
                .then(function(res){
                    if(res.data.success){
                        alert('创建属性成功！');
                    }
                })
                .catch(function (reason) {
                    console.log(reason);
                })
        },
        updateProperty:function(){
            alert('updateProperty');
        },
        delNode:function () {
            alert('delete');
        }
    }
});