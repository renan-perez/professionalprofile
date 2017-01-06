import { Location } from '../models/location';

export class Education {
    id: Number;
	school: String;
	course: String;
	fildOfStudy: String;
	initialDate: Date;
	finalDate: Date;
	location: Location;
	period: String;
}