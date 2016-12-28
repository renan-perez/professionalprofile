import { Injectable }       from '@angular/core';
import { Headers, Http }    from '@angular/http';

import { Profile }   from '../models/Profile';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class ProfileService {

    private mainInformationURL = 'http://localhost:8081/professionalprofile-core/getProfileMainInformation?userId=';

    constructor(private http: Http) {}

    getMainInformation(userId: Number): Promise<Profile> {
        console.log("GET MAIN INFORMATION @@@@@@@@@@@@@@ " + this.mainInformationURL + userId);
        return this.http.get(this.mainInformationURL + userId)
                    .toPromise()
                    .then(response => response.json().data as Profile)
                    .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
    }
}
