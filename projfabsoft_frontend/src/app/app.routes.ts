import { Routes } from '@angular/router';
import { ClienteComponent } from './cliente/cliente.component';
import { FormClienteComponent } from './form-cliente/form-cliente.component';

export const routes: Routes = [
  { path: '', redirectTo: 'clientes', pathMatch: 'full' }, // Redireciona a raiz para /clientes
  { path: 'clientes', component: ClienteComponent },
  { path: 'clientes/novo', component: FormClienteComponent }
];
