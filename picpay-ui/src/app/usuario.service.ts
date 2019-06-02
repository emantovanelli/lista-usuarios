import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  apiUrl='http://localhost:8080/api/v1/users';
  // apiUrl='http://localhost:8081/api/v1/users';
  
  constructor(private httpCliente: HttpClient) { }



  buscar(usuario: string, page: number){
    return this.httpCliente.get(this.apiUrl + '/search/' + usuario + '/' + page);
  }

}
