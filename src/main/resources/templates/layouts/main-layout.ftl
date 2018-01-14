<!DOCTYPE html>
<#macro page>
<html>
    <head>
        <#include "../common/include.ftl"/>
    </head>
    <body>
        <div id="wrap" class="app">
            <#include "../common/menubar.ftl"/>
            <!-- Content starts -->
            <#nested>
            <!-- Content ends -->
        </div>
        <script src="/js/home.js"></script>
    </body>
</html>
</#macro>

