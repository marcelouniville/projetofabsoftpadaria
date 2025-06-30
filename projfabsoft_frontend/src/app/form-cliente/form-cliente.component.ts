import { Component } from '@angular/core';
import { Cliente } from '../model/cliente';
import { ClienteService } from '../service/cliente.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router'; // importe RouterModule

@Component({
  selector: 'app-form-cliente',
  imports: [HttpClientModule, CommonModule, FormsModule, RouterModule],
  templateUrl: './form-cliente.component.html',
  styleUrls: ['./form-cliente.component.css'], // <-- Corrija aqui, coloque colchetes
  providers: [ClienteService]
})
export class FormClienteComponent {
  cliente: Cliente = new Cliente();

  constructor(
    private clienteService: ClienteService,
    private router: Router
  ) {}

salvar() {
  this.clienteService.saveCliente(this.cliente).subscribe({
    next: () => {
      this.router.navigate(['/clientes']); // Redireciona para a lista após salvar
    },
    error: (erro) => {
      console.error('Erro ao salvar cliente', erro); // Mostra erro no console se falhar
    }
  });
}}
