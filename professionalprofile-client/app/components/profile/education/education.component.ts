import { Component, OnInit }   from '@angular/core';

import { Education }        from '../../../models/education';
import { Language }         from '../../../enums/language';
import { EducationService } from '../../../services/education.service';

@Component({
    moduleId: module.id,
    selector: 'education',
    styleUrls: [ 'education.component.css' ],
    templateUrl: 'education.component.html'
})

export class EducationComponent implements OnInit {

    private userEducation: Education[];

    constructor(
        private educationService: EducationService
    ) {}

    ngOnInit(): void {
        this.getUserEducation();    
    }

    getUserEducation() {
        this.educationService.listUserEducation(1,Language.EN)
            .subscribe(
                education => this.userEducation = education,
                err => console.log(err),
            );
    }

}