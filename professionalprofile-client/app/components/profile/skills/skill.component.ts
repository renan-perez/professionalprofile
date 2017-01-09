import { Component, OnInit }        from '@angular/core';
import { ActivatedRoute, Params }   from '@angular/router';
import { Location }                 from '@angular/common';

import { ProfileComponent } from '../profile.component';
import { SkillService }     from '../../../services/skills.service';
import { Skill }            from '../../../models/skill';
import { RouterUtil }       from '../../../util/router-util';

@Component({
    moduleId: module.id,
    selector: 'skills',
    styleUrls: [ 'skill.component.css' ],
    templateUrl: 'skill.component.html',
})

export class SkillComponent implements OnInit {

    userId: Number;
    skills: Skill[];

    constructor(
        private skillsService: SkillService,
        private route: ActivatedRoute
    ) {}

    ngOnInit(): void {
        this.route.params.subscribe((param: any) => this.userId = param[RouterUtil.PARAM_USER_ID]);
        this.getUserSkills(this.userId);    
    }

    getUserSkills(userId: Number) {
        this.skillsService.getUserSkills(userId)
            .subscribe(
                skills => this.skills = skills,
                err => console.log(err),
            );
    }

}