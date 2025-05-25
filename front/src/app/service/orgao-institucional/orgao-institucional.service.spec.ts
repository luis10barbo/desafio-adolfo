import { TestBed } from '@angular/core/testing';
import { OrgaoInstitucionalService } from './orgao-institucional.service';


describe('OrgaoInstitucionalService', () => {
  let service: OrgaoInstitucionalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrgaoInstitucionalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
