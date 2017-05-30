import {Resource} from './resource.model';

export interface User {
  id?: number;
  name?: string;
  surname?: string;
  email?: string;
  pais?: string;
  descripcion?: string;
  telephone?: string;
  password?: string;
  postalCode?: number;
  roles?: string[];
  carrito?: Resource[]
  precioCarrito?: number;


 
}