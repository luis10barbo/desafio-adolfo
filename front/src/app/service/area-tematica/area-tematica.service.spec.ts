import { TestBed } from '@angular/core/testing';

import { AreaTematicaService } from './area-tematica.service';

describe('AreaTematicaService', () => {
  let service: AreaTematicaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AreaTematicaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
