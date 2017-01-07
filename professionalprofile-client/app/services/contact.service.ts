import { Injectable }               from '@angular/core';
import { Observable }               from 'rxjs';
import { Http, Response, Headers, ResponseContentType }  from '@angular/http';

import { Contact }          from '../models/Contact';
import { ServiceUtil }      from '../util/service-util';
import { GenericService }   from '../services/service-generic.service';

// Import RxJs required methods
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';


@Injectable()
export class ContactService extends GenericService {

    private userSocialNetworksURL = `${ServiceUtil.MAIN_URL}/listUserSocialNetworks`;

    constructor(private http: Http) {
        super();
    }

    listUserSocialNetworks(userId: Number) {
        const url = `${this.userSocialNetworksURL}/${userId}`;
        return this.http
                .get(url, { headers: super.getHeaders() })
                .map(response => <Contact[]>response.json())
                .catch(super.handleError);
    }

}
