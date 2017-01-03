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
        id: ProfileId,
        professionalHeadline: String,
        industry: String,
        summary: String,
        mainProfile: Boolean,
        mainContact: Contact
    ) {
        this.id = id;
        this.professionalHeadline = professionalHeadline;
        this.industry = industry;
        this.summary = summary;
        this.mainProfile = mainProfile;
        this.mainContact = mainContact;
    }

}