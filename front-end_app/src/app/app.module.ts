import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";
import { provideHttpClient, withInterceptorsFromDi } from "@angular/common/http";
import { KeynoteComponent } from './ui/keynote/keynote.component';
import { ConferenceComponent } from './ui/conference/conference.component';

function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'brahim-realm',
        clientId: 'brahim_cleint'
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
        KeynoteComponent,
        ConferenceComponent
    ],
    bootstrap: [AppComponent], imports: [BrowserModule,
        AppRoutingModule, KeycloakAngularModule], providers: [
        { provide: APP_INITIALIZER, useFactory: initializeKeycloak, multi: true, deps: [KeycloakService] },
        provideHttpClient(withInterceptorsFromDi())
    ] })
export class AppModule { }
