import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms'
import { HttpModule }     from '@angular/http';
import { RouterModule }   from '@angular/router';

import { AppComponent }         from './app.component';
import { ProfileComponent }     from './components/profile/profile.component';
import { SummaryComponent }     from './components/profile/summary/summary.component';
import { SkillComponent }       from './components/profile/skills/skill.component';
import { ExperiencesComponent } from './components/profile/experiences/experiences.component';
import { EducationComponent }   from './components/profile/education/education.component';
import { ProfileService }       from './services/profile.service';
import { SkillService }         from './services/skills.service';
import { EducationService }     from './services/education.service';
import { ExperienceService }    from './services/experience.service';
import { ContactService }       from './services/contact.service';

import { AppRoutingModule }     from './app-routing.module';

@NgModule({
  imports: [ 
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  declarations: [ 
    AppComponent,
    ProfileComponent,
    SummaryComponent,
    SkillComponent,
    ExperiencesComponent,
    EducationComponent
  ],
  providers: [ 
    ProfileService, 
    SkillService,
    EducationService,
    ExperienceService,
    ContactService
  ],
  bootstrap: [ AppComponent ]
})

export class AppModule {}
