import { User }   from '../models/user';

export class ProfileId {
    user: User;
    language: String;

    constructor(
        user: User,
        language: String,
    ) {
        this.user = user;
        this.language = language;
    }
}