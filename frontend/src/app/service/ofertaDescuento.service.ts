import{Injectable} from'@angular/core';
import{Http,Headers,RequestOptions} from '@angular/http';
import{Observable} from 'rxjs/Observable';
import'rxjs/Rx';
import{OfertaDescuento} from'app/models/ofertaDescuento.model';


const URL ='https://localhost:8443/api/ofertasDescuento/';

@Injectable()
export class OfertaDescuentoService{

   constructor(private http:Http){}

   getOfertasDescuento(){
       return this.http.get(URL)
       .map(response => response.json())
       .catch(error => this.handleError(error));

    }
    getOfertaDescuento(id:number){
        return this.http.get(URL +id)
        .map(response => response.json())
        .catch(error => this.handleError(error))

    }


    private handleError(error: any) {
    console.error(error);
    return Observable.throw('Server error (' + error.status + '): ' + error.text());
  }



}
