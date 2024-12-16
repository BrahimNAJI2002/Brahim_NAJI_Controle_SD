import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";
import { provideHttpClient, withInterceptorsFromDi } from "@angular/common/http";
import { ProductComponent } from './ui/product/product.component';

function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'bdcc-realm',
        clientId: 'ecom-client-ang'
      },
      initOptions: {
        onLoad: 'check-sso',
        silentCheckSsoRedirectUri:
          window.location.origin + '/assets/silent-check-sso.html'
      }
    });
}
@NgModule({ declarations: [
        AppComponent,
        ProductComponent
    ],
    bootstrap: [AppComponent], imports: [BrowserModule,
        AppRoutingModule, KeycloakAngularModule], providers: [
        { provide: APP_INITIALIZER, useFactory: initializeKeycloak, multi: true, deps: [KeycloakService] },
        provideHttpClient(withInterceptorsFromDi())
    ] })
export class AppModule { }
