import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/app/environments/environment';
import { Noticia } from 'src/app/model/NoticiaModel';

@Injectable({
  providedIn: 'root'
})
export class NoticiasService {

  constructor(private HttpClient: HttpClient) { }

  adquirir(areasTematicas: number[], orgaosInstitucionais: number[]) {
    return this.HttpClient.get<Noticia[]>(`${environment.urlBackend}/noticia/adquirir?areasTematicas=${areasTematicas.join(",")}&orgaosInstitucionais=${orgaosInstitucionais.join(",")}`);
  }

}
