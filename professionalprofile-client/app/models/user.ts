export class User {
    id: Number;
    firstName: String;
    surname: String;

    constructor(
        id: Number,
        firstName: String,
        surname: String
    ) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
    }
}