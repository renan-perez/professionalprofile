import { Component, ViewEncapsulation, OnInit } from '@angular/core';

import { ExperienceService }    from '../../../services/experience.service';
import { Experience }           from '../../../models/experience';
import { Language }             from '../../../enums/Language';
import { Age }                  from '../../../enums/age';

@Component({
    moduleId: module.id,
    selector: 'experiences',
    styleUrls: [ 'experiences.component.css' ],
    templateUrl: 'experiences.component.html',
    encapsulation: ViewEncapsulation.None
})

export class ExperiencesComponent implements OnInit {

    experience: Experience;

    constructor(
        private experienceService: ExperienceService
    ) {}

     ngOnInit(): void {
        this.getUserExperience(1, Language.EN, null, Age.NEWEST);    
    }

    getUserExperience(userId: Number, language: Language, inicialDate: Date, age: Age) {
        this.experienceService.getUserExperience(userId, language, inicialDate, age)
            .subscribe(
                experience => this.experience = experience,
                err => console.log(err)
            );
    }

    getUserOlderExperience() {
        this.getUserExperience(
            this.experience.profile.id.user.id,
            Language.EN,
            this.experience.initialDate,
            Age.OLDER
        );
    }

    getUserNewerExperience() {
        this.getUserExperience(
            this.experience.profile.id.user.id,
            Language.EN,
            this.experience.initialDate,
            Age.NEWER
        );
    }
}