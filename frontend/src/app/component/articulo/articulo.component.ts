import{Component,EventEmitter,Output} from '@angular/core';
import {Router,ActivatedRoute} from '@angular/router';
import{ResourceService,Resources} from'app/service/resource.service';

@Component({
    selector:'app-articulo',
    templateUrl:'articulo.component.html'
})

export class ArticuloComponent {

    resource:Resources;
    inputContent1:string;
    inputContent2:string;
    asunto:string[]=[];
    comentarios:string[]=[];

    constructor(private router:Router,activatedRoute:ActivatedRoute,service:ResourceService){
    //  let id = activatedRoute.snapshot.params['id'];
    //  this.resource= service.getResource(id);
        let id = activatedRoute.snapshot.params['id'];
        service.getResource(id).subscribe(
            resource=> this.resource = resource,
            error => console.error(error)
        );
    }
    addContent(){
        this.asunto.push(this.inputContent1);
        this.comentarios.push(this.inputContent2);
        this.inputContent1="";
        this.inputContent2="";
    }







}