import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'clientes',
    loadComponent: () => import('./cliente/cliente.component').then(m => m.ClienteComponent)
  },
  {
    path: 'clientes/novo',
    loadComponent: () => import('./form-cliente/form-cliente.component').then(m => m.FormClienteComponent)
  },
  {
    path: 'clientes/alterar/:id',
    loadComponent: () => import('./form-cliente/form-cliente.component').then(m => m.FormClienteComponent)
  },
  {
    path: '',
    redirectTo: '/clientes',
    pathMatch: 'full'
  },
  {
    path: 'produtos/pao',
    loadComponent: () => import('./produtos/pao/pao.component').then(m => m.PaoComponent)
  },
  {
    path: 'produtos/bolo',
    loadComponent: () => import('./produtos/bolo/bolo.component').then(m => m.BoloComponent)
  },
  {
    path: 'produtos/cafe',
    loadComponent: () => import('./produtos/cafe/cafe.component').then(m => m.CafeComponent)
  },
  {
    path: 'estoque',
    loadComponent: () => import('./estoque/estoque.component').then(m => m.EstoqueComponent)
  }
];
