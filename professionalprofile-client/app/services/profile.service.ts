import { Injectable }                               from '@angular/core';
import { Observable }                               from 'rxjs';
import { Http, Response, Headers, RequestOptions, }  from '@angular/http';

import { Profile }   from '../models/Profile';

// Import RxJs required methods
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/debounceTime';


@Injectable()
export class ProfileService {

    private mainInformationURL = 'http://localhost:8081/professionalprofile-core/getProfileMainInformation?userId';

    constructor(private http: Http) {}

    getMainInformation(userId: Number) {
        const url = `${this.mainInformationURL}=${userId}`;
        let mainInformation: Profile; 
        let teste: Profile;
        return this.http
                .get(url, { headers: this.getHeaders() })
                .map(response => <Profile>response.json())
                .catch(this.handleError);
    }

    private getHeaders(): Headers {
        let headers = new Headers();
        headers.append('Accept', 'application/json');
        return headers;
    }

    private handleError(error: any): Promise<any> {
        console.log('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
    }
}
