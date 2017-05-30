import{Component}from'@angular/core';
import{Router,ActivatedRoute} from'@angular/router';
import{ResourceService} from'app/service/resource.service';
import{Resource} from'app/models/resource.model';

@Component({
    selector:'app-carrito',
    templateUrl:'carrito.component.html'
})

export class CarritoComponent{

    resource:Resource;

    constructor(private router:Router,activatedRouter:ActivatedRoute, private service:ResourceService){

        let id = activatedRouter.snapshot.params['id'];
        service.getResource(id).subscribe(
            resource => this.resource = resource,
            error => console.error(error)
        );

    }
    removeResource(){
        let okResponse = window.confirm("¿Esta seguro de eliminar el articulo?");
        if(okResponse){
            this.service.removeResource(this.resource).subscribe(
                resource => this.router.navigate(['/articulo']),
                error => console.error(error)
            )
            
        }
    }
 }