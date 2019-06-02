import { Component, OnInit } from "@angular/core";
import { UsuarioService } from "../usuario.service";
import { MessageService } from 'primeng/api';

@Component({
  selector: "app-painel-usuario",
  templateUrl: "./painel-usuario.component.html",
  styleUrls: ["./painel-usuario.component.css"]
})
export class PainelUsuarioComponent implements OnInit {
  termoBusca: string;
  listaUsuarios = [];
  paginaAtual: number = 0;
  totalPaginas: number = 0;
  blockNext: boolean = true;
  blockPrevious: boolean = true;
  showLoading: boolean = false;

  constructor(private usuarioService: UsuarioService,
    private messageService: MessageService
    ) {}

  ngOnInit() {}

  buscar() {
    var retorno;

    this.showLoading = true;
    this.usuarioService.buscar(this.termoBusca, 0).subscribe(resposta => {
      retorno = <any>resposta;

      if (retorno) {
        this.listaUsuarios = retorno.content;
        this.paginaAtual = retorno.number + 1;
        this.totalPaginas = retorno.totalPages - 1;

        this.checkPagening();
      }

      this.showLoading = false;
    },
    resposta => {
      let msg = 'Erro inesperado. Tente novamente.'

      if (resposta.error.message) {
        msg = resposta.error.message;
      }

      this.messageService.add({
        severity: 'error',
        summary: msg
      })
    });
  }

  buscarProximaPagina() {
    this.showLoading = true;
    if (this.paginaAtual < this.totalPaginas) {
      var retorno;
      this.usuarioService
        .buscar(this.termoBusca, this.paginaAtual)
        .subscribe(resposta => {
          retorno = <any>resposta;
          if (retorno) {
            this.listaUsuarios = retorno.content;
            this.paginaAtual = retorno.number + 1;
            this.totalPaginas = retorno.totalPages - 1;
          }

          this.checkPagening();
          this.showLoading = false;
        },
        resposta => {
          let msg = 'Erro inesperado. Tente novamente.'

          if (resposta.error.message) {
            msg = resposta.error.message;
          }

          this.messageService.add({
            severity: 'error',
            summary: msg
          })
        });
    }
  }

  buscarPaginaAnterior() {
    this.showLoading = true;

    if (this.paginaAtual > 1) {
      var retorno;

      this.usuarioService
        .buscar(this.termoBusca, this.paginaAtual - 1)
        .subscribe(resposta => {
          retorno = <any>resposta;
          if (retorno) {
            this.listaUsuarios = retorno.content;
            this.paginaAtual = retorno.number;
            this.totalPaginas = retorno.totalPages - 1;
          }

          this.checkPagening();
          this.showLoading = false;
        },
        resposta => {
          let msg = 'Erro inesperado. Tente novamente.'

          if (resposta.error.message) {
            msg = resposta.error.message;
          }

          this.messageService.add({
            severity: 'error',
            summary: msg
          })
        });
    }
  }

  firstPage() {
    this.showLoading = true;

    var retorno;

    this.usuarioService
      .buscar(this.termoBusca, 0)
      .subscribe(resposta => {
        retorno = <any>resposta;
        if (retorno) {
          this.listaUsuarios = retorno.content;
          this.paginaAtual = retorno.number + 1;
          this.totalPaginas = retorno.totalPages - 1;
        }

        this.checkPagening();
        this.showLoading = false;
      },
      resposta => {
        let msg = 'Erro inesperado. Tente novamente.'

        if (resposta.error.message) {
          msg = resposta.error.message;
        }

        this.messageService.add({
          severity: 'error',
          summary: msg
        })
      });
  }

  lastPage() {
    this.showLoading = true;

    var retorno;

    if(this.paginaAtual < this.totalPaginas){
      this.usuarioService
      .buscar(this.termoBusca, this.totalPaginas)
      .subscribe(resposta => {
        retorno = <any>resposta;
        if (retorno) {
          this.listaUsuarios = retorno.content;
          this.paginaAtual = retorno.number;
          this.totalPaginas = retorno.totalPages - 1;
        }

        this.checkPagening();
        this.showLoading = false;
      },
      resposta => {
        let msg = 'Erro inesperado. Tente novamente.'

        if (resposta.error.message) {
          msg = resposta.error.message;
        }

        this.messageService.add({
          severity: 'error',
          summary: msg
        })
      });
    }
    
  }

  checkPagening() {
    if (this.paginaAtual == 1) {
      this.blockPrevious = true;
    } else {
      this.blockPrevious = false;
    }
    if (this.paginaAtual == this.totalPaginas) {
      this.blockNext = true;
    } else {
      this.blockNext = false;
    }
  }
}
