import { Component, ViewEncapsulation }    from '@angular/core';

import { ProfileComponent }     from '../profile.component';

@Component({
    moduleId: module.id,
    selector: 'skills',
    styleUrls: [ 'skill.component.css' ],
    templateUrl: 'skill.component.html',
    encapsulation: ViewEncapsulation.None
})

export class SkillComponent extends ProfileComponent {

}