import{Component}from'@angular/core';
import{Router} from'@angular/router';
import{RegistroService} from'app/service/registro.service';


@Component({
    selector:'app-registro',
    templateUrl:'registro.component.html'
})

export class RegistroComponent{ 

    constructor(private registroService:RegistroService,private router:Router){

    }

    register(name:string,surname:string,email:string,pais:string,descripcion:string,telephone:string,passwordHash:string,postalCode:number){


        this.registroService.register(name,surname,email,pais,descripcion,telephone,passwordHash,postalCode).subscribe(
            user =>{ this.router.navigate(['']);},
            error => console.log("Fail trying to register new account")

        );
    }
}