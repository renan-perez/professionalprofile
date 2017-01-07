import { Injectable }               from '@angular/core';
import { Observable }               from 'rxjs';
import { Http, Response, Headers }  from '@angular/http';

import { Education }    from '../models/education';
import { Language }     from '../enums/language';
import { ServiceUtil }  from '../util/service-util';

// Import RxJs required methods
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

@Injectable()
export class EducationService {

    private userEducationURL = `${ServiceUtil.MAIN_URL}/listUserEducation`;

    constructor(private http: Http) {}

    listUserEducation(userId: Number, language: Language) {
        const url = `${this.userEducationURL}/${userId}/${Language[language]}`;
        console.log(url);
        return this.http
                .get(url, { headers: this.getHeaders()})
                .map(response => <Education>response.json())
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
