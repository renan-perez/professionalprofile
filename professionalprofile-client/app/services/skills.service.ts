import { Injectable }               from '@angular/core';
import { Observable }               from 'rxjs';
import { Http, Response, Headers }  from '@angular/http';

import { Skill }            from '../models/Skill';
import { GenericService }   from '../services/service-generic.service';
import { ServiceUtil }      from '../util/service-util';

@Injectable()
export class SkillService extends GenericService {

    private userSkillsURL =  `${ServiceUtil.MAIN_URL}/listUserSkills`;

    constructor(private http: Http) {
        super();
    }

    getUserSkills(userId: Number) {
        const url = `${this.userSkillsURL}/${userId}`;
        return this.http
                .get(url, { headers: super.getHeaders() })
                .map(response => <Skill[]>response.json())
                .catch(super.handleError);
    }

}