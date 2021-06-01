import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerComponent } from './customer/customer.component';
import { CartComponent } from './cart/cart.component';
import { OrderComponent } from './order/order.component';
import { ProductComponent } from './product/product.component';
import { SalesreportComponent } from './salesreport/salesreport.component';
import { GrowthreportComponent } from './growthreport/growthreport.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import { CustomerFormComponent } from './customer-form/customer-form.component';
import { CartFormComponent } from './cart-form/cart-form.component';
import { OrderFormComponent } from './order-form/order-form.component';
import { ProductFormComponent } from './product-form/product-form.component';
import { SalesreportFormComponent } from './salesreport-form/salesreport-form.component';
import { GrowthreportFormComponent } from './growthreport-form/growthreport-form.component';
import { WishlistFormComponent } from './wishlist-form/wishlist-form.component';
import { UserFormComponent } from './user-form/user-form.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CartListComponent } from './cart-list/cart-list.component';
import { OrderListComponent } from './order-list/order-list.component';
import { ProductListComponent } from './product-list/product-list.component';
import { SalesreportListComponent } from './salesreport-list/salesreport-list.component';
import { GrowthreportListComponent } from './growthreport-list/growthreport-list.component';
import { WishlistListComponent } from './wishlist-list/wishlist-list.component';

import { MsgBoxComponent } from './msg-box/msg-box.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { HeaderComponent } from './header/header.component';
import { Header1Component } from './header1/header1.component';
import { SearchbycategoryComponent } from './searchbycategory/searchbycategory.component';
import { FilterComponent } from './filter/filter.component';
import { ProductnameComponent } from './productname/productname.component';
import { AddCartToOrderComponent } from './add-cart-to-order/add-cart-to-order.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { Dashboard1Component } from './dashboard1/dashboard1.component';
import { UpdatedateComponent } from './updatedate/updatedate.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Product1Component } from './product1/product1.component';
import { Productlist1Component } from './productlist1/productlist1.component';
import { CartUpdateComponent } from './cart-update/cart-update.component';
import { ProducttocartComponent } from './producttocart/producttocart.component';
import { ProducttoorderComponent } from './producttoorder/producttoorder.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { Ng2OrderModule } from 'ng2-order-pipe';
import { WelcomeComponent } from './welcome/welcome.component';
import { Welcome1Component } from './welcome1/welcome1.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    CartComponent,
    OrderComponent,
    ProductComponent,
    SalesreportComponent,
    GrowthreportComponent,
    WishlistComponent,
    CustomerFormComponent,
    CartFormComponent,
    OrderFormComponent,
    ProductFormComponent,
    SalesreportFormComponent,
    GrowthreportFormComponent,
    WishlistFormComponent,
    UserFormComponent,
    CustomerListComponent,
    CartListComponent,
    OrderListComponent,
    ProductListComponent,
    SalesreportListComponent,
    GrowthreportListComponent,
    WishlistListComponent,
    MsgBoxComponent,
    HomeComponent,
    LoginComponent,
    AdminHomeComponent,
    UserHomeComponent,
    HeaderComponent,
    Header1Component,
    SearchbycategoryComponent,
    FilterComponent,
    ProductnameComponent,
    AddCartToOrderComponent,
    DashboardComponent,
    Dashboard1Component,
    UpdatedateComponent,
    Product1Component,
    Productlist1Component,
    CartUpdateComponent,
    ProducttocartComponent,
    ProducttoorderComponent,
    WelcomeComponent,
    Welcome1Component,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule,
    Ng2OrderModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
