import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ProfileComponent } from './components/profile/profile.component';
import { RouterUtil }       from './util/router-util';

const routes: Routes = [
    { path: '', redirectTo: '/profile/1', pathMatch: 'full' },
    { path: `profile/:${RouterUtil.PARAM_USER_ID}`,     component: ProfileComponent },
    { path: `profile/:${RouterUtil.PARAM_USER_ID}/:${RouterUtil.PARAM_LANGUAGE}`,    component: ProfileComponent }
];

@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}