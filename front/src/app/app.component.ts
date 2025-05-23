import { Component } from '@angular/core';

type Orgao = {
  name: string,
  code: string
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  date1: Date | undefined = undefined;
  orgaos: Orgao[] = [{name: "Segurança publica", code: "SP"}, {name: "Saúde", code: "SA"},]
  orgaosSelecionados: Orgao[] = []
}
