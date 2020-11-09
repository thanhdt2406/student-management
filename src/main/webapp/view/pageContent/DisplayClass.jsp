<div class="wrapper">
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Display Class</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Display Class</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <table id="example2" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Start Date</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                                    <%@ page language="java" contentType="text/html; charset=UTF-8"
                                             pageEncoding="UTF-8" %>
                                    <c:forEach items="${classrooms}" var="classroom" >
                                    <tr>
                                        <td><c:out value="${classroom.getClassID()}"/></td>
                                        <td><c:out value="${classroom.getName()}"/></td>
                                        <td><c:out value="${classroom.getStartDate()}"/></td>
                                        <td>
                                            <a href="/class?action=edit?ID=${classroom.getID()}">Edit</a>
                                            <a href="/class?action=delete?ID=${classroom.getID()}">Delete</a>
                                        </td>
                                    </tr>
                                    </c:forEach>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.card -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
