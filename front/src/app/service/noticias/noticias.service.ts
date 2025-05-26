import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/app/environments/environment';
import { Noticia } from 'src/app/model/NoticiaModel';
import { ResultadoPaginado } from 'src/app/model/ResultadoPaginado';

@Injectable({
  providedIn: 'root'
})
export class NoticiasService {

  constructor(private HttpClient: HttpClient) { }

  adquirir(areasTematicas: number[], orgaosInstitucionais: number[], offset: number) {
    return this.HttpClient.get<ResultadoPaginado<Noticia[]>>(`${environment.urlBackend}/noticia/adquirir?areasTematicas=${areasTematicas.join(",")}&orgaosInstitucionais=${orgaosInstitucionais.join(",")}&offset=${offset}`);
  }

}
