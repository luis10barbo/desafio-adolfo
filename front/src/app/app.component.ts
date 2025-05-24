import { Component } from '@angular/core';
import { AreaTematicaService } from './service/area-tematica/area-tematica.service';
import { AreaTematica } from './model/AreaTematicaModel';

type OrgaoSelect = {
  name: string,
  code: string
}

type AreaTematicaSelect = {
  name: string,
  code: string,
  areaTematica: AreaTematica
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  date1: Date | undefined = undefined;
  orgaos: OrgaoSelect[] = [{name: "Segurança publica", code: "SP"}, {name: "Saúde", code: "SA"},]
  
  areasTematicasSelecionadas: AreaTematicaSelect[] = []
  areasTematicas: AreaTematicaSelect[] = [];

  constructor(private areaTematicaService: AreaTematicaService) {
    areaTematicaService.getAreasTematicas().subscribe((areasTematicas) => {
      this.areasTematicas = areasTematicas.map((value) => {return {areaTematica: value, code: value.titulo, name: value.titulo}});
    })
  }
}
