import { Location } from './location';
import { Image }    from '../models/image';

export class User {
    id: Number;
    firstName: String;
    surname: String;
    location: Location;
    photo: Image;
} 