import { Component, OnInit }    from '@angular/core';

import { ProfileComponent }     from '../profile.component';

import { SkillService }     from '../../../services/skills.service';
import { Skill }          from '../../../models/skill';

@Component({
    moduleId: module.id,
    selector: 'skills',
    styleUrls: [ 'skill.component.css' ],
    templateUrl: 'skill.component.html',
})

export class SkillComponent implements OnInit {

    skills: Skill[];

    constructor(
        private skillsService: SkillService
    ) {}

    ngOnInit(): void {
        this.getUserSkills();    
    }

    getUserSkills() {
        this.skillsService.getUserSkills(1)
            .subscribe(
                skills => this.skills = skills,
                err => console.log(err),
            );
    }

}