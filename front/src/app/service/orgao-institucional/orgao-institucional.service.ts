import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/app/environments/environment';
import { OrgaoInstitucional } from 'src/app/model/OrgaoInstitucionalModel';

@Injectable({
  providedIn: 'root'
})
export class OrgaoInstitucionalService {

  constructor(private httpClient: HttpClient) { }

  adquirir() {
      return this.httpClient.get<OrgaoInstitucional[]>(`${environment.urlBackend}/orgaoInstitucional/todos`);
    }
}
