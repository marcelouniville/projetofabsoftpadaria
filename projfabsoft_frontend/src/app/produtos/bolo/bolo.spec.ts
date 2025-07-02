import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Bolo } from './bolo.component';

describe('Bolo', () => {
  let component: Bolo;
  let fixture: ComponentFixture<Bolo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Bolo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Bolo);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
