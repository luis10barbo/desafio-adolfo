import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AreaTematica } from 'src/app/model/AreaTematicaModel';
import { environment } from "../../environments/environment"

@Injectable({
  providedIn: 'root'
})
export class AreaTematicaService {

  constructor(private httpClient: HttpClient) { 

  }

  adquirir() {
    return this.httpClient.get<AreaTematica[]>(`${environment.urlBackend}/areaTematica/todos`);
  }
}
