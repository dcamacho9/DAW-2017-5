import{Component,OnInit}from'@angular/core';
import{Router,ActivatedRoute} from'@angular/router';
import {OfertaService} from 'app/service/ofertas.service';
import {Oferta} from 'app/models/oferta.model';
import {OfertaDescuentoService} from'app/service/ofertaDescuento.service';
import {OfertaDescuento} from'app/models/ofertaDescuento.model';


@Component({
    selector:'app-ofertas',
    templateUrl:'ofertas.component.html'
})

export class OfertasComponent implements OnInit { 
  ofertas: Oferta[];
  ofertasDescuento:OfertaDescuento[];
  oferta:Oferta;
  newOferta:boolean;

  constructor(private router:Router,private service:OfertaService,private ofertaDescuentoService:OfertaDescuentoService,activatedRoute:ActivatedRoute){
      let id = activatedRoute.snapshot.params['id'];
      if(id) {
          service.getOferta(id).subscribe(
              oferta => this.oferta = oferta,
              error => console.error(error)

          );
      this.newOferta= false;
      }else{
      
      this.oferta ={name:'', code:''}
      this.newOferta=true;
  }
 }

  ngOnInit(){
      this.service.getOfertas().subscribe(
          ofertas => this.ofertas = ofertas,
          error => console.log(error)
      );
      this.ofertaDescuentoService.getOfertasDescuento().subscribe(
           ofertasDescuento => this.ofertasDescuento = ofertasDescuento,
           error => console.log(error)
      )
      
  }
  save(){
      this.service.addOferta(this.oferta).subscribe(
          oferta =>{ },
          error =>console.error('error creating new oferta:'+error)   
      );
      window.history.back();
  }


}