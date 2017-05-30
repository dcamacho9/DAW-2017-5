import{Injectable}from'@angular/core';
import {Http} from '@angular/http';
import{Observable} from'rxjs/Observable';
import'rxjs/Rx';

import{Oferta} from'app/models/oferta.model';
const BASE_URL ="https://localhost:8443/api/ofertas/";

@Injectable()
export class OfertaService{
    constructor(private http:Http){
    }

    getOfertas(){
        return this.http.get(BASE_URL)
        .map(response => response.json())
        .catch(error => this.handleError(error));
    }

    getOferta(id:number){
        return this.http.get(BASE_URL+ id)
        .map(response => response.json())
        .catch(error => this.handleError(error));
    }
    addOferta(oferta: Oferta){
        return this.http.post(BASE_URL,oferta)
        .map(response => response.json())
        ._catch(error => this.handleError(error));

    }




    private handleError(error: any) {
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text())
	}
}