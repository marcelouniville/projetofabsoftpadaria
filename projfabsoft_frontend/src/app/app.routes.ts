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
    path: 'produtos/pao/novo',
    loadComponent: () => import('./produtos/pao/form-pao.component').then(m => m.FormPaoComponent)
  },
  {
    path: 'produtos/pao/editar/:id',
    loadComponent: () => import('./produtos/pao/form-pao.component').then(m => m.FormPaoComponent)
  },

  
  {
    path: 'produtos/bolo',
    loadComponent: () => import('./produtos/bolo/bolo.component').then(m => m.BoloComponent)
  },
  {
    path: 'produtos/bolo/novo',
    loadComponent: () => import('./produtos/bolo/form-bolo.component').then(m => m.FormBoloComponent)
  },
  {
    path: 'produtos/bolo/editar/:id',
    loadComponent: () => import('./produtos/bolo/form-bolo.component').then(m => m.FormBoloComponent)
  },

  
  {
    path: 'produtos/cafe',
    loadComponent: () => import('./produtos/cafe/cafe.component').then(m => m.CafeComponent)
  },
  {
    path: 'produtos/cafe/novo',
    loadComponent: () => import('./produtos/cafe/form-cafe.component').then(m => m.FormCafeComponent)
  },
  {
    path: 'produtos/cafe/editar/:id',
    loadComponent: () => import('./produtos/cafe/form-cafe.component').then(m => m.FormCafeComponent)
  },

  
  {
    path: 'estoque',
    loadComponent: () => import('./estoque/estoque.component').then(m => m.EstoqueComponent)
  },
  {
    path: 'estoque/pao',
    loadComponent: () => import('./estoque/pao/estoque-pao.component').then(m => m.EstoquePaoComponent)
  },
  {
    path: 'estoque/bolo',
    loadComponent: () => import('./estoque/bolo/estoque-bolo.component').then(m => m.EstoqueBoloComponent)
  },
  {
    path: 'estoque/cafe',
    loadComponent: () => import('./estoque/cafe/estoque-cafe.component').then(m => m.EstoqueCafeComponent)
  }
];
