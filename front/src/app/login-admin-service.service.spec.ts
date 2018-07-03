import { TestBed, inject } from '@angular/core/testing';

import { LoginAdminServiceService } from './login-admin-service.service';

describe('LoginAdminServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LoginAdminServiceService]
    });
  });

  it('should be created', inject([LoginAdminServiceService], (service: LoginAdminServiceService) => {
    expect(service).toBeTruthy();
  }));
});
