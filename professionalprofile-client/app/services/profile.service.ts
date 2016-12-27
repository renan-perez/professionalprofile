import { Injectable }   from '@angular/core';
import { Headers, Http }         from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Profile }   from '../models/Profile';

export class ProfileService {

    private heroesUrl = 'api/heroes';

    constructor(private http: Http) {}

    getMainInformation(userId: Number): Promise<Profile> {
        return this.http.get(this.heroesUrl)
                    .toPromise()
                    .then(response => response.json().data as Profile)
                    .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
    }
}
