import { ContactType }  from '../enums/contact-type';
import { User }         from './user';

export class Contact {
    
    private id: Number;
    private type: ContactType;
    private contact: string;
    private mainContact: Boolean;
    private user: User;

    constructor() {}

    constructor(
        ContactType: Number,
        contact: string
    ) {
        this.contact = contact;
    }

    getId(): Number {
        return this.id;
    }

    setId(id: Number) {
        this.id = id;
    }
}