

<style>
	.fixed-sidebar {
    position: fixed;
    top: 0;
    left: 0;
    height: 100%;
    overflow-y: auto; /* Để đảm bảo nội dung sidebar có thể cuộn nếu vượt quá chiều cao màn hình */
}
</style>
 <ul class="navbar-nav bg-gradient-success sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/app/admin/home">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">OrganicShop Admin</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="/app/admin/home">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Overview</span>
                </a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Shop
            </div>
            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item active">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Manage</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
				    <div class="bg-light py-2 collapse-inner rounded">
				        <!-- Products Menu -->
				        <a class="collapse-item" href="#" data-toggle="collapse" data-target="#productsSubmenu" aria-expanded="true" aria-controls="productsSubmenu">Products</a>
				        
				        <div id="productsSubmenu" class="collapse">
				            <a class="collapse-item" href="/productForm">Add Product</a>
				        </div>
				
				        <!-- Employee Menu -->
				        <a class="collapse-item" href="#" data-toggle="collapse" data-target="#employeeSubmenu" aria-expanded="true" aria-controls="employeeSubmenu">Employee</a>
				        <div id="employeeSubmenu" class="collapse">
				            <a class="collapse-item" href="/app/admin/manage_employee/add">Add Employee</a>
				            <a class="collapse-item" href="/app/admin/manage_employee/list">List Employees</a>
				        </div>
				
				        <!-- Customers Menu -->
				        <a class="collapse-item" href="#" data-toggle="collapse" data-target="#customersSubmenu" aria-expanded="true" aria-controls="customersSubmenu">Customers</a>
				        <div id="customersSubmenu" class="collapse">
				            <a class="collapse-item" href="/app/admin/manage_customer/add">Add Customer</a>
				            <a class="collapse-item" href="/app/admin/manage_customer/list">List Customers</a>
				        </div>
				        
				        <a class="collapse-item" href="#" data-toggle="collapse" data-target="#suppliersSubmenu" aria-expanded="true" aria-controls="suppliersSubmenu">Suppliers</a>
				        
				        <div id="suppliersSubmenu" class="collapse">
				            <a class="collapse-item" href="/suppliersForm">Add Suppliers</a>
				            <a class="collapse-item" href="/list_suppliers">List Suppliers</a>
				        </div>
				    </div>
				</div>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Utilities</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Custom Utilities:</h6>
                        <a class="collapse-item" href="utilities-color.html">Colors</a>
                        <a class="collapse-item" href="utilities-border.html">Borders</a>
                        <a class="collapse-item" href="utilities-animation.html">Animations</a>
                        <a class="collapse-item" href="utilities-other.html">Other</a>
                    </div>
                </div>
            </li>
            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>