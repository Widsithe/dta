import { TestBed, inject } from '@angular/core/testing';

import { AdminSearchService } from './admin/admin-search.service';

describe('AdminSearchService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdminSearchService]
    });
  });

  it('should be created', inject([AdminSearchService], (service: AdminSearchService) => {
    expect(service).toBeTruthy();
  }));
});
