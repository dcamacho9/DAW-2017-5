import {Comment} from './comment.model';

export interface Resource {
  id: number;
  title: string;
  subtitle: string;
  interprete: string;
  fecha: string;
  estado: string;
  album: string;
  precio: number;
  codigo: number;
  img: string;
  visto?: boolean;
  veces?: number;
  comentarios?: Comment[];

 
}