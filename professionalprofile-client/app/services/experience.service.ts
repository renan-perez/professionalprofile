import { Injectable }               from '@angular/core';
import { Observable }               from 'rxjs';
import { Http, Response, Headers }  from '@angular/http';

import { Experience }    from '../models/experience';
import { Language }     from '../enums/language';
import { ServiceUtil }  from '../util/service-util';
import { Age }          from '../enums/age';

// Import RxJs required methods
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

@Injectable()
export class ExperienceService {

    private userExperienceURL = `${ServiceUtil.getMainURL()}/getExperience`;

    constructor(private http: Http) {}

    getUserExperience(userId: Number, language: Language, initialDate: Date, age: Age) {
        let url = `${this.userExperienceURL}/${userId}/${Language[language]}?age=${Age[age]}`;
        if (initialDate != null) {
            url = `${url}&initialDate=${initialDate}`;
        }
        
        console.log(url);
        console.log(url);
        return this.http
                .get(url, { headers: this.getHeaders()})
                .map(response => <Experience>response.json())
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
