import { Component } from '@angular/core';
import { Cliente } from '../model/cliente';
import { ClienteService } from '../service/cliente.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-cliente',
  imports: [HttpClientModule, CommonModule, RouterModule],
  templateUrl: './cliente.component.html',
  styleUrl: './cliente.component.css',
  providers: [ClienteService]
})
export class ClienteComponent {
  public listaClientes: Cliente[] = [];
  constructor(
    private clientecomponentService:ClienteService
  ){}
  


  ngOnInit(): void {
    this.clientecomponentService.getClientes().subscribe(resposta => {
      this.listaClientes = resposta;
    })


  }

}
