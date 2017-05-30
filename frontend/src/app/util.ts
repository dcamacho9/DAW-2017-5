import {environment} from 'environments/environment';

export const BASE_URL =environment.API_URL;

export const LOGIN_URL  = BASE_URL +"login";
export const RESOURCE_URL = BASE_URL +"resources"
export const OFERTA_URL = BASE_URL +"ofertas"
export const OFERTADESCUENTO_URL = BASE_URL+"ofertasDescuento"
export const USER_URL = BASE_URL +"users";

export const IMG_URL  ="./assets/img/";

export const Status_NO_CONTENT = 204;
