import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Noticia } from 'src/app/model/NoticiaModel';
import { ResultadoPaginado } from 'src/app/model/ResultadoPaginado';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class NoticiasService {

  constructor(private HttpClient: HttpClient) { }

  adquirir(areasTematicas: number[], orgaosInstitucionais: number[], offset: number, dateRange: Date[] | undefined = undefined) {
    return this.HttpClient.get<ResultadoPaginado<Noticia[]>>(`${environment.urlBackend}/noticia/adquirir?areasTematicas=${areasTematicas.join(",")}&orgaosInstitucionais=${orgaosInstitucionais.join(",")}&offset=${offset}&dateStart=${dateRange ? dateRange[0].toISOString() : ""}&dateEnd=${dateRange ? dateRange[1].toISOString() : ""}`);
  }

}
