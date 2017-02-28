<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:sitemaster>
    <section ng-app="usersApp" ng-controller="usersCtrl">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th class="col-md-1">
                    </th>
                    <th>
                        Email
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="u in users track by $index">
                    <td class="">
                        <button type="button" class="btn btn-warning" ng-click="delete($index)">
                            <span class="glyphicon glyphicon-trash"></span>
                        </button>
                    </td>
                    <td ng-click="selectUser(u)" style="cursor: pointer">
                        {{u.name}}
                        <small>
                            <span class="help-block text-muted">Created on 12/12/12</span>    
                        </small>
                    </td>
                </tr>
            </tbody>
        </table>
    </section>
    <script type="text/javascript" src="../resources/views/users/users.js"></script>
</t:sitemaster>