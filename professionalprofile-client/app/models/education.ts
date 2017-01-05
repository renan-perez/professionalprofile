import { Location } from '../models/Location';

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