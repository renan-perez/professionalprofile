import { Component, OnInit }   from '@angular/core';

import { ProfileService }   from '../../services/profile.service';
import { ContactService }   from '../../services/contact.service';
import { Profile }          from '../../models/profile';
import { Contact }            from '../../models/contact';

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
        private contactService: ContactService
    ) {}

    ngOnInit(): void {
        this.userId = 1;
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