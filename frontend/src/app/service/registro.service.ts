import {Injectable,OnDestroy} from'@angular/core';
import{Http,Headers,RequestOptions} from'@angular/http';
import{Observable} from'rxjs/Observable';
import'rxjs/Rx';
import{User} from'app/models/user.model';

const BASE_URL ="https://localhost:8443/api/register";


@Injectable()
export class RegistroService implements OnDestroy{
    ngOnDestroy(){
        console.log("localStorage called ngOnDestroy");
        localStorage.clear();
    }

    user:User;

    constructor(private http:Http){}


register(name:string,surname:string,email:string,pais:string,descripcion:string,telefono:string,passwordHash:string,postalCode:number){
    let newUser :User;
    newUser ={name:name,surname:surname,email:email,pais:pais,descripcion:descripcion,telephone:telefono,password:passwordHash,postalCode:postalCode};
    return this.http.post(BASE_URL,newUser);
}

}