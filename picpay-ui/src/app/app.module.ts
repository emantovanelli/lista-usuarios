import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';


import {TableModule} from 'primeng/table';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { PanelModule } from 'primeng/panel';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';
import {DialogModule} from 'primeng/dialog';

import { NgxLoadingModule } from 'ngx-loading';


import { AppComponent } from './app.component';
import { PainelUsuarioComponent } from './painel-usuario/painel-usuario.component';

@NgModule({
  declarations: [
    AppComponent,
    PainelUsuarioComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,

    TableModule,
    PanelModule,
    InputTextModule,
    ButtonModule,
    ToastModule,
    DialogModule,

    NgxLoadingModule.forRoot({})

  ],
  providers: [MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
