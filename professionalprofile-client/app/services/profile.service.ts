import { Injectable }               from '@angular/core';
import { Observable }               from 'rxjs';
import { Http, Response, Headers, ResponseContentType }  from '@angular/http';

import { Profile }      from '../models/Profile';
import { ServiceUtil }  from '../util/service-util';

// Import RxJs required methods
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';


@Injectable()
export class ProfileService {

    private mainInformationURL = `${ServiceUtil.MAIN_URL}/getProfileMainInformation`;
    private userPhotoURL = `${ServiceUtil.MAIN_URL}/getUserPhoto`;

    constructor(private http: Http) {}

    getMainInformation(userId: Number) {
        const url = `${this.mainInformationURL}/${userId}`;
        return this.http
                .get(url, { headers: this.getHeaders() })
                .map(response => <Profile>response.json())
                .catch(this.handleError);
    }

    getUserPhoto(userId: Number) {
        const url = `${this.userPhotoURL}/${userId}`;
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
