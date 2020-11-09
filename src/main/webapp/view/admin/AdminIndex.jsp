
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Index</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../data/plugins/fontawesome-free/css/all.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="../../data/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="../../data/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../data/dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Home</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Contact</a>
            </li>
        </ul>

        <!-- SEARCH FORM -->
        <form class="form-inline ml-3" action="#">
            <div class="input-group input-group-sm">
                <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
                <div class="input-group-append">
                    <button class="btn btn-navbar" type="submit">
                        <i class="fas fa-search"></i>
                    </button>
                </div>
            </div>
        </form>

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
            <!-- Messages Dropdown Menu -->
            <li class="nav-item d-none d-sm-inline-block">
                <a href="/Logout" class="nav-link">Logout</a>
            </li>
        </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="#" class="brand-link">
            <img src="../../data/dist/img/AdminLTELogo.png"
                 alt="AdminLTE Logo"
                 class="brand-image img-circle elevation-3"
                 style="opacity: .8">
            <span class="brand-text font-weight-light">TVDM Team</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="../../data/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">
                    <a href="#" class="d-block">Admin</a>
                </div>
            </div>

            <!-- Sidebar Menu -->

            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <li class="nav-item">
                        <a href="/Admin?fileName=CreateClassForm" class="nav-link">
                            <i class="nav-icon fas fa-plus"></i>
                            <p>Create New Class</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="/Admin?fileName=ListClassroom" class="nav-link">
                            <i class="nav-icon fas fa-book"></i>
                            <p>Display Class</p>
                        </a>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-user-plus"></i>
                            <p>
                                Create New User
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/Admin?fileName=CreateNewAcaStaff" class="nav-link">
                                    <i class="far fa-star nav-icon"></i>
                                    <p>Academic Staff</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/Admin?fileName=CreateNewTeacher" class="nav-link">
                                    <i class="far fa-star nav-icon"></i>
                                    <p>Teacher</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/Admin?fileName=CreateNewStudent" class="nav-link">
                                    <i class="far fa-star nav-icon"></i>
                                    <p>Student</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas  fa-users"></i>
                            <p>
                                User List
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/Admin?fileName=ListAcademicStaff" class="nav-link">
                                    <i class="far fa-star nav-icon"></i>
                                    <p>Academic Staff</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/Admin?fileName=ListTeacher" class="nav-link">
                                    <i class="far fa-star nav-icon"></i>
                                    <p>Teacher</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/Admin?fileName=ListStudent" class="nav-link">
                                    <i class="far fa-star nav-icon"></i>
                                    <p>Student</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/Admin?fileName=ListUser" class="nav-link">
                                    <i class="far fa-star nav-icon"></i>
                                    <p>All user</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-paint-brush"></i>
                            <p>
                                Write Daily Diary
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/Admin?fileName=createDiaryForm&&action=createDiaryForm" class="nav-link">
                                    <i class="far  fa-bookmark nav-icon"></i>
                                    <p>Class Diary</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="far  fa-bookmark nav-icon"></i>
                                    <p>Student Diary</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas  fa-trophy"></i>
                            <p>
                                Mark
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="far  fa-star nav-icon"></i>
                                    <p>Class</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="far  fa-star nav-icon"></i>
                                    <p>All Student</p>
                                </a>
                            </li>
                        </ul>
                    </li>

                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>

    <jsp:include page="../pageContent/${fileNameRes}.jsp" />

    <footer class="main-footer">
        <div class="float-right d-none d-sm-block">
            <b>Lorem ipsum dolor.</b>
        </div>
        <strong>Lorem ipsum dolor <a href="#">Lorem</a></strong> Lorem ipsum dolor.
    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="../../data/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../../data/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables -->
<script src="../../data/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../../data/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="../../data/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="../../data/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<!-- AdminLTE App -->
<script src="../../data/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../data/dist/js/demo.js"></script>
<!-- page script -->

</body>
</html>
