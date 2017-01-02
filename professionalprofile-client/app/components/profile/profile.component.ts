import { Component, OnInit }   from '@angular/core';

import { ProfileService }   from '../../services/profile.service';
import { Profile }          from '../../models/profile';

@Component({
    moduleId: module.id,
    selector: 'profile',
    styleUrls: [ 'profile.component.css' ],
    templateUrl: 'profile.component.html',
    providers: [ ProfileService ]
})

export class ProfileComponent implements OnInit {

    mainInformation: Profile;

    constructor(
        private profileService: ProfileService
    ) {}

    ngOnInit(): void {
        this.getMainInformation();    
    }

    getMainInformation() {
        this.profileService.getMainInformation(1)
            .subscribe(
                data => this.mainInformation = data,
                err => console.log(err)
            );
        console.log(this.mainInformation);
        
    }

}