import { Component, ViewEncapsulation, OnInit } from '@angular/core';
import { ActivatedRoute, Params }               from '@angular/router';
import { Location }                             from '@angular/common';

import { ExperienceService }    from '../../../services/experience.service';
import { Experience }           from '../../../models/experience';
import { Language }             from '../../../enums/Language';
import { Age }                  from '../../../enums/age';
import { RouterUtil }           from '../../../util/router-util';

import 'rxjs/add/operator/switchMap';

@Component({
    moduleId: module.id,
    selector: 'experiences',
    styleUrls: [ 'experiences.component.css' ],
    templateUrl: 'experiences.component.html',
    encapsulation: ViewEncapsulation.None
})

export class ExperiencesComponent implements OnInit {

    userId: Number;
    language: Language;
    experience: Experience;

    constructor(
        private experienceService: ExperienceService,
        private route: ActivatedRoute
    ) {}

     ngOnInit(): void {
        this.route.params.subscribe((param: any) => {
            this.userId = param[RouterUtil.PARAM_USER_ID];
            this.language = param[RouterUtil.PARAM_LANGUAGE];
        });
        this.getUserExperience(this.userId, this.language, null, Age.NEWEST);    
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