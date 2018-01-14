
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
        newNode:{},
        currentNode:'/',
    },
    mounted: function () {
        var _self = this;
        axiosUtils.get("/home/getChilds")
            .then(function (res) {
                if (res.data.success) {
                    _self.leftNodes = res.data.data;
                }
            }).catch(function (reason) {
                console.log(reason);
        })
    },
    methods:{
        addNode:function(){
            var _self=this;
            var postData={
                parentNode:_self.currentNode,
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
                })
        },
        addProperty:function () {
            alert('addProperty');
        },
        updateProperty:function(){
            alert('updateProperty');
        },
        delNode:function () {
            alert('delete');
        }
    }
});