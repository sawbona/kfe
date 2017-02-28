<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:sitemaster>
    <script type="text/javascript" src="${contextPath}/res/app/users/admin.js"></script>
    <div class="oj-web-applayout-max-width oj-web-applayout-content">
        <div class="row">
            <div class="col-md-2">
            </div>
            <div class="col-md-8">
                <div class="panel panel-default">
                    <h3 class="oj-margin">Users registered <small class="loader-displayer" data-bind="visible:loading"><span class="loader"></span> loading...</small></h3>
                    <table class="table table-striped">
                        <tbody data-bind="foreach: users,
                            beforeRemove: hideUser">
                            <tr>
                                <td class="col-md-8">
                                    <div>
                                        <span data-bind="text:email" style="word-wrap:break-word;"></span>
                                    </div>
                                    <div>
                                        <small>Vice president</small>
                                    </div>
                                </td>
                                <td class="col-md-4">
                                    <div class="btn-group pull-right">
                                        <button class="btn btn-default dropdown-toggle"
                                                data-toggle="dropdown"
                                                data-bind="click:$parent.setCurrentUser">Actions <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#"><span class="text-primary">Edit</span></a></li>
                                            <li><a href="#" data-bind="click: $parent.removeCurrentUser">Delete</a></li>
                                        </ul>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div id="myModal" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-body">
                        <p>Do you really want to delete user: <strong data-bind="text:currentUser().email"></strong>?</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button"
                                data-bind="click:confirmDeleteUser"
                                class="btn btn-warning" data-dismiss="modal">Delete</button>
                    </div>
                </div>

            </div>
        </div>
    </div>
</t:sitemaster>