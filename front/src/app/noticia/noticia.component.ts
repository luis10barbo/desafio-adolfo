import { Component, Input, OnInit } from '@angular/core';
import { Noticia } from '../model/NoticiaModel';

@Component({
  selector: 'app-noticia',
  templateUrl: './noticia.component.html',
  styleUrls: ['./noticia.component.scss']
})
export class NoticiaComponent implements OnInit {

  @Input("noticia")
  noticia!: Noticia
  constructor() { }

  ngOnInit(): void {
    console.log(this.noticia);
  }

}
