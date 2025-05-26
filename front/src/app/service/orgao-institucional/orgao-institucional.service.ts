import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OrgaoInstitucional } from 'src/app/model/OrgaoInstitucionalModel';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrgaoInstitucionalService {

  constructor(private httpClient: HttpClient) { }

  adquirir() {
      return this.httpClient.get<OrgaoInstitucional[]>(`${environment.urlBackend}/orgaoInstitucional/todos`);
    }
}
