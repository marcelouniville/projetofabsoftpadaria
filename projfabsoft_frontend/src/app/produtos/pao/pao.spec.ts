import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PaoComponent } from './pao.component';

describe('PaoComponent', () => {
  let component: PaoComponent;
  let fixture: ComponentFixture<PaoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PaoComponent],  // standalone em imports
    })
    .compileComponents();

    fixture = TestBed.createComponent(PaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
