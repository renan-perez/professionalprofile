import { Company } from '../models/company';
import { Profile } from '../models/profile';

export class Experience {
    id: Number;
    title: String;
    initialDate: Date;
    finalDate:Date;
    decription: String;
    site: String;
    company: Company;
    years: Number;
	months: Number;
    profile: Profile;
}