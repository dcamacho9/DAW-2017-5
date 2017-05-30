import {Resource} from './resource.model';

export interface PurchaseOrder {
  id?: number;
  code?: string;
  totalToPay?: number;
  description?: string;
  carrito?: Resource[];
}

















