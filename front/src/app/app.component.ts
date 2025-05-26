import { Component } from '@angular/core';
import { AreaTematicaService } from './service/area-tematica/area-tematica.service';
import { AreaTematica } from './model/AreaTematicaModel';
import { OrgaoInstitucionalService } from './service/orgao-institucional/orgao-institucional.service';
import { OrgaoInstitucional } from './model/OrgaoInstitucionalModel';
import { NoticiasService } from './service/noticias/noticias.service';
import { Noticia } from './model/NoticiaModel';

type OrgaoSelect = {
  name: string,
  code: number,
  orgaoInstitucional: OrgaoInstitucional
}

type AreaTematicaSelect = {
  name: string,
  code: number,
  areaTematica: AreaTematica
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  date1: Date | undefined = undefined;
  
  areasTematicasSelecionadas: AreaTematicaSelect[] = []
  areasTematicas: AreaTematicaSelect[] = [];

  orgaoInstitucionalSelecionadas: OrgaoSelect[] = []
  orgaoInstitucional: OrgaoSelect[] = [];

  noticias: Noticia[] = []

  temProximaPagina: boolean = false;
  proximoOffset = 0;

  constructor(areaTematicaService: AreaTematicaService, orgaoInstitucionalService: OrgaoInstitucionalService, private noticiasService: NoticiasService) {
    areaTematicaService.adquirir().subscribe((areasTematicas) => {
      this.areasTematicas = areasTematicas.map((value) => {return {areaTematica: value, code: value.id, name: value.titulo}});
    })
    
    orgaoInstitucionalService.adquirir().subscribe((orgaoInstitucional) => {
      this.orgaoInstitucional = orgaoInstitucional.map((value) => {
        return {code: value.id, name: value.titulo, orgaoInstitucional: value}
      })  
    })

    this.adquirirNoticias(0);
  }

  limparFiltros() {
    this.date1 = undefined;
    this.areasTematicasSelecionadas = [];
    this.orgaoInstitucionalSelecionadas = [];
  }

  adquirirNoticias(offset: number) {
    this.noticiasService.adquirir(
      this.areasTematicasSelecionadas.map((value) => {
        return value.code
      }),
      this.orgaoInstitucionalSelecionadas.map((value) => {
        return value.code
      }),
      offset
    ).subscribe((res) => {
      if (offset == 0) {
        this.noticias = res.resultado;
      } else {
        this.noticias = [...this.noticias, ...res.resultado];
      }
      this.temProximaPagina = res.temProximaPagina;
      this.proximoOffset = res.offsetProximaPagina;
    })

  }

  pesquisarNoticias() {
    this.adquirirNoticias(0);
  }

  verMaisNoticias() {
    this.adquirirNoticias(this.proximoOffset);
  }
}
