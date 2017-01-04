import { Injectable }               from '@angular/core';
import { Observable }               from 'rxjs';
import { Http, Response, Headers }  from '@angular/http';

import { Skill }   from '../models/Skill';

@Injectable()
export class SkillService {

    private userSkillsURL = 'http://localhost:8081/professionalprofile-core/listUserSkills?userId';

    constructor(private http: Http) {}

    getUserSkills(userId: Number) {
        const url = `${this.userSkillsURL}=${userId}`;
        return this.http
                .get(url, { headers: this.getHeaders() })
                .map(response => <Skill[]>response.json())
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