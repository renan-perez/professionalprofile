import { Component, OnInit }        from '@angular/core';
import { ActivatedRoute, Params }   from '@angular/router';
import { Location }                 from '@angular/common';

import { ProfileService }   from '../../services/profile.service';
import { ContactService }   from '../../services/contact.service';
import { Profile }          from '../../models/profile';
import { Contact }          from '../../models/contact';
import { RouterUtil }       from '../../util/router-util';

@Component({
    moduleId: module.id,
    selector: 'profile',
    styleUrls: [ 'profile.component.css' ],
    templateUrl: 'profile.component.html'
})

export class ProfileComponent implements OnInit {

    mainInformation: Profile;
    userSocialNetworks: Contact[];
    userPhotoURL: String;
    userId: Number;
    showBalloon: Boolean;

    constructor(
        private profileService: ProfileService,
        private contactService: ContactService,
        private route: ActivatedRoute,
        private location: Location,
    ) {}

    ngOnInit(): void {
        this.route.params.subscribe((param: any) => this.userId = param[RouterUtil.PARAM_USER_ID]);
        this.showBalloon = true;
        this.getMainInformation(this.userId);
        this.getUserPhoto(this.userId);
        this.getUserSocialNetworks(this.userId);
    }

    getMainInformation(userId: Number) {
        this.profileService.getMainInformation(userId)
            .subscribe(
                profile => this.mainInformation = profile,
                err => console.log(err)
            );
    }

    getUserPhoto(userId: Number) {
        this.userPhotoURL = this.profileService.getUserPhoto(userId);
    }

    getUserSocialNetworks(userId: Number) {
        this.contactService.listUserSocialNetworks(userId)
            .subscribe(
                socialNetworks => this.userSocialNetworks = socialNetworks,
                err => console.log(err)
            )
    }

    closeBallon() {
        this.showBalloon = false;
    }

}