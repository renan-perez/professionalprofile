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

    private userExperienceURL = `${ServiceUtil.MAIN_URL}/getExperience`;

    constructor(private http: Http) {}

    getUserExperience(userId: Number, language: Language, initialDate: Date, age: Age) {
        const url = this.generateURL(this.userExperienceURL, userId, language, initialDate, age);
        
        console.log(url);
        console.log(url);
        return this.http
                .get(url, { headers: this.getHeaders()})
                .map(response => <Experience>response.json())
                .catch(this.handleError);
    }

    private generateURL(mainURL: String, userId: Number, language: Language, initialDate: Date, age: Age) {
        let url = `${mainURL}/${userId}?`;
        
        if (language != null && language != undefined) {
            url += `language=${language}&`;
        }

        if (initialDate != null && initialDate != undefined) {
            url += `initialDate=${initialDate}&`;
        }

        if (age != null && age != undefined) {
            url += `age=${Age[age]}&`;
        }

        return url;
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
