import { ProfileId }    from '../models/profile-id';
import { Contact }      from '../models/contact';
import { ContactType }  from '../enums/contact-type';

export class Profile {
    id: ProfileId;
    professionalHeadline: String;
    industry: String;
    summary: String;
    mainProfile: Boolean;
    mainContact: Contact;
}
