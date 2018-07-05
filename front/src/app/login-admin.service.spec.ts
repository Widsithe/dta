import { TestBed, inject } from '@angular/core/testing';

import { LoginAdminService } from './login-admin.service';

describe('LoginAdminService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LoginAdminService]
    });
  });

  it('should be created', inject([LoginAdminService], (service: LoginAdminService) => {
    expect(service).toBeTruthy();
  }));
});
