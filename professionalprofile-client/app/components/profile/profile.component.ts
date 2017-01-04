import { Component, OnInit }   from '@angular/core';

import { ProfileService }   from '../../services/profile.service';
import { SkillService }     from '../../services/skills.service';
import { Profile }          from '../../models/profile';
import { Skill }          from '../../models/skill';

@Component({
    moduleId: module.id,
    selector: 'profile',
    styleUrls: [ 'profile.component.css' ],
    templateUrl: 'profile.component.html'
})

export class ProfileComponent implements OnInit {

    mainInformation: Profile;
    skills: Skill[];

    constructor(
        private profileService: ProfileService,
        private skillsService: SkillService
    ) {}

    ngOnInit(): void {
        this.getMainInformation();    
    }

    getMainInformation() {
        this.profileService.getMainInformation(1)
            .subscribe(
                profile => this.mainInformation = profile,
                err => console.log(err),
            );
    }

}