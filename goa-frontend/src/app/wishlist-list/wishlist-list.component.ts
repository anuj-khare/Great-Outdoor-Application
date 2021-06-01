import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Wishlist } from '../model/wishlist';
import { WishlistService } from '../service/wishlist.service';

@Component({
  selector: 'app-wishlist-list',
  templateUrl: './wishlist-list.component.html',
  styleUrls: ['./wishlist-list.component.css']
})
export class WishlistListComponent implements OnInit {
  wishlist : Wishlist[];
  err : string ;
  p : number=1;
  constructor(private wishlistService : WishlistService, private router: Router) {

   }

  ngOnInit(): void {
    this.wishlistService.getAll().subscribe(
      (data) => this.wishlist = data,
      (err) => { console.log (err); this.err = "sorry. unable to retrieve data"}
    );
  }
  delete(pid :number){
    if(confirm("are you sure")){

      this.wishlistService.deleteById(pid).subscribe(
        () => { this.wishlist.splice(this.wishlist.findIndex(p => p.wishListId==pid),1) }
      );
    }
  }
  deleteByUserId(uid : number){
    if(confirm("are you sure")){
    () => {this.wishlist.splice(this.wishlist.findIndex(p => p.wishListId == uid),1) }
    }
  }


  key : string = "wishlistId";
  reverse : boolean = false;
  sort(key){
    this.key = key;
    this.reverse = !this.reverse;
}


}
