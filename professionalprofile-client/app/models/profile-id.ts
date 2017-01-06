import { User }   from '../models/user';
import { Language }   from '../enums/language';

export class ProfileId {
    user: User;
    language: Language;

    constructor(
        user: User,
        language: Language,
    ) {
        this.user = user;
        this.language = language;
    }
}