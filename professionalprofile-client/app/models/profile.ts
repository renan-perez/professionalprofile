import { ProfileId }   from '../models/profile-id';
import { Contact }   from '../models/contact';

export class Profile {
    id: ProfileId;
    professionalHeadline: String;
    industry: String;
    summary: String;
    mainProfile: Boolean;
    mainContact: Contact;

    getId():  ProfileId {
        return this.id;
    }
}