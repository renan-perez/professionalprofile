import { ProfileId }   from '../models/profile-id';
import { Contact }   from '../models/contact';

export class Profile {
    id: ProfileId;
    professionalHeadline: String;
    industry: String;
    summary: String;
    mainProfile: Boolean;
    mainContact: Contact;

    constructor(
        userId: Number,
        language: String,
        locale: String,
        professionalHeadline: String,
        industry: String,
        summary: String,
        mainProfile: Boolean,
        //mainContact: Contact
    ) {
        this.industry = industry;
    }

    static toProfile(response: any): Profile {
        let profile = new Profile(
            response.id.user.id,
            response.id.language.id,
            response.id.language.locale,
            response.professionalHeadline,
            response.industry,
            response.summary,
            response.mainProfile,
        );
        console.log('Parsed person:', profile);
        return profile;
    }

    toString() {
        return `Profile: ${this.id.userId}`;
    }
}