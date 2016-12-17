import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms'

import { AppComponent }  from './app.component';

import { ProfileComponent }     from './components/profile/profile.component';
import { SummaryComponent }     from './components/profile/summary/summary.component';
import { SkillComponent }       from './components/profile/skills/skill.component';
import { ExperiencesComponent }  from './components/profile/experiences/experiences.component';
import { EducationComponent }  from './components/profile/education/education.component';

@NgModule({
  imports: [ 
    BrowserModule,
    FormsModule 
  ],
  declarations: [ 
    AppComponent,
    ProfileComponent,
    SummaryComponent,
    SkillComponent,
    ExperiencesComponent,
    EducationComponent
  ],
  bootstrap: [ AppComponent ]
})

export class AppModule {}
