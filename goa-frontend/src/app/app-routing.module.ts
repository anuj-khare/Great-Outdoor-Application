import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCartToOrderComponent } from './add-cart-to-order/add-cart-to-order.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { CartFormComponent } from './cart-form/cart-form.component';
import { CartListComponent } from './cart-list/cart-list.component';
import { CartUpdateComponent } from './cart-update/cart-update.component';
import { CartComponent } from './cart/cart.component';
import { CustomerFormComponent } from './customer-form/customer-form.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerComponent } from './customer/customer.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { Dashboard1Component } from './dashboard1/dashboard1.component';
import { FilterComponent } from './filter/filter.component';
import { GrowthreportFormComponent } from './growthreport-form/growthreport-form.component';
import { GrowthreportListComponent } from './growthreport-list/growthreport-list.component';
import { GrowthreportComponent } from './growthreport/growthreport.component';
import { HeaderComponent } from './header/header.component';
import { Header1Component } from './header1/header1.component';

import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { OrderFormComponent } from './order-form/order-form.component';
import { OrderListComponent } from './order-list/order-list.component';
import { OrderComponent } from './order/order.component';
import { ProductFormComponent } from './product-form/product-form.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductComponent } from './product/product.component';
import { Product1Component } from './product1/product1.component';
import { Productlist1Component } from './productlist1/productlist1.component';
import { ProductnameComponent } from './productname/productname.component';
import { ProducttocartComponent } from './producttocart/producttocart.component';
import { ProducttoorderComponent } from './producttoorder/producttoorder.component';
import { SalesreportFormComponent } from './salesreport-form/salesreport-form.component';
import { SalesreportListComponent } from './salesreport-list/salesreport-list.component';
import { SalesreportComponent } from './salesreport/salesreport.component';
import { SearchbycategoryComponent } from './searchbycategory/searchbycategory.component';
import { UpdatedateComponent } from './updatedate/updatedate.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { Welcome1Component } from './welcome1/welcome1.component';
import { WishlistFormComponent } from './wishlist-form/wishlist-form.component';
import { WishlistListComponent } from './wishlist-list/wishlist-list.component';
import { WishlistComponent } from './wishlist/wishlist.component';

const routes: Routes = [
  {path:'dashboard',component:DashboardComponent,children:[
    {path:'product',component:ProductComponent ,children : [
      { path : 'productlist', component :ProductListComponent  },
      { path : 'productadd', component : ProductFormComponent },
      { path : 'productedit/:kid', component :ProducttocartComponent },
      { path : 'producttoorder/:kid', component :ProducttoorderComponent },
      { path : 'productsearchbycategory/cat', component : SearchbycategoryComponent },
      { path : 'productfilterbyprice/filter', component : FilterComponent },
      { path : 'findbyproductname', component : ProductnameComponent},
      { path : '', redirectTo : 'product', pathMatch : 'full'}
    ]},
    {path:'order',component:OrderComponent ,children : [
      { path : 'orderlist', component :OrderListComponent  },
      { path : 'orderadd', component : OrderFormComponent },
      { path : 'orderupdate/:oid,:did,:ded', component : OrderFormComponent },
      { path : 'orderedit/:oid', component : OrderFormComponent },
       {path:'updateDate', component : UpdatedateComponent},
      { path : '', redirectTo : 'order', pathMatch : 'full'}
    ]},
    {path:'customer',component:CustomerComponent ,children : [
      { path : 'customerlist', component :CustomerListComponent  },
      { path : 'customeradd', component : CustomerFormComponent },
      { path : 'customeredit/:cid', component : CustomerFormComponent },
      { path : '', redirectTo : 'customer', pathMatch : 'full'}
    ]},

    {path:'cart',component:CartComponent ,children : [
      { path : 'cartlist', component :CartListComponent  },
      { path : 'cartadd', component : CartFormComponent },
      { path : 'cartedit/:cid', component : CartUpdateComponent },
      {path:'carttoorder/:cid',component:AddCartToOrderComponent},
      { path : '', redirectTo : 'cart', pathMatch : 'full'}
    ]},
    {path:'wish',component:WishlistComponent ,children : [
      { path : 'wishlist', component :WishlistListComponent  },
      { path : 'wishadd', component : WishlistFormComponent },
      { path : 'wishedit/:cid', component : WishlistFormComponent },
      { path : '', redirectTo : 'wish', pathMatch : 'full'}
    ]},
    { path:'welcome',component :WelcomeComponent},
    { path : '', redirectTo : 'header1', pathMatch : 'full'}
  ]},


  {path:'dashboard1',component:Dashboard1Component,children:[
    {path:'sales',component:SalesreportComponent ,children : [
      { path : 'saleslist', component :SalesreportListComponent  },
      { path : 'salesadd', component : SalesreportFormComponent },
      { path : 'salesedit/:sid', component : SalesreportFormComponent },
      { path : '', redirectTo : 'sales', pathMatch : 'full'}
    ]},
    {path:'growth',component:GrowthreportComponent ,children : [
      { path : 'growthlist',pathMatch:'full', component :GrowthreportListComponent  },
      { path : 'growthadd',pathMatch:'full', component : GrowthreportFormComponent },
      { path : '', redirectTo : 'growth', pathMatch : 'full'}
    ]},
    {path:'product1',component:Product1Component ,children : [
      { path : 'productlist',pathMatch:'full', component :Productlist1Component  },
      { path : 'productedit/:pid', component : ProductFormComponent },
      { path : 'productadd',pathMatch:'full', component : ProductFormComponent },
      { path : '', redirectTo : 'productlist', pathMatch : 'full'}
    ]},
    { path : 'welcome1',component:Welcome1Component},
    { path : '', redirectTo : 'header', pathMatch : 'full'}
  ]},



  {path:'header1',component:Header1Component },
  {path:'header',component:HeaderComponent},
  {path:'adminhome',pathMatch:'full',component:AdminHomeComponent},
  {path:'userhome',pathMatch:'full',component:UserHomeComponent},
  {path:'',pathMatch:'full',component:HomeComponent},
  {path:'adduser',pathMatch:'full',component:UserFormComponent},
  {path:'applogin',pathMatch:'full',component:LoginComponent},
  {path:'userlogin',pathMatch:'full',component:UserHomeComponent},
  {path:'adminlogin',pathMatch:'full',component:AdminHomeComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
