import { TestBed } from '@angular/core/testing';

import { ScoresServiceService } from './scores-service.service';

describe('ScoresServiceService', () => {
  let service: ScoresServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ScoresServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
