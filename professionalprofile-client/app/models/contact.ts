import { ContactType }  from '../enums/contact-type';
import { User }         from './user';

export class Contact {
    
    private id: Number;
    private type: ContactType;
    private contact: string;
    private mainContact: Boolean;
    private user: User;

    constructor(
        ContactType: Number,
        contact: string
    ) {
        this.contact = contact;
    }

    getIcon(contactType: ContactType) {
        switch(contactType) {
            case ContactType.EMAIL:
                return "icon fa-at";
            case ContactType.GITHUB:
                return "icon fa-linkedin-square";
            case ContactType.LINKEDIN:
                return "icon fa-github-square";
            case ContactType.TELEPHONE:
                return "icon fa-phone";
            case ContactType.TWITTER:
                return "icon fa-twitter-square";
            case ContactType.WEBSITE:
                return "icon fa-chrome";    
        } 
    }
}