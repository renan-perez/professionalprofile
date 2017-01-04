import { ContactType }  from '../enums/contact-type';
import { User }         from './user';

export class Contact {
    
    private id: Number;
    private type: ContactType;
    private contact: string;
    private mainContact: Boolean;
    private user: User;
    private contactIcon: String;

    constructor(
        id: Number,
        type: ContactType,
        contact: string,
    ) {
        this.id = id;
        this.type = type;
        this.contact = contact;
    }

    setContactIcon(icon: String): void {
        this.contactIcon = icon;
    }

    getContactIcon(): String {
        this.contactIcon = Contact.getIcon(this.type);
        console.log(this.contactIcon);
        return this.contactIcon;
    }

    getType() {
        return this.type;
    }

    static getIcon(contactType: ContactType) {
        switch(contactType) {
            case ContactType.EMAIL:
                return "icon fa-envelope";
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