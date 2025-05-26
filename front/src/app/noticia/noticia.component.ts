import { Component, Input, OnInit } from '@angular/core';
import { Noticia } from '../model/NoticiaModel';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-noticia',
  templateUrl: './noticia.component.html',
  styleUrls: ['./noticia.component.scss']
})
export class NoticiaComponent {

  backend: string = environment.urlBackend;

  @Input("noticia")
  noticia!: Noticia
  constructor() { }

}
