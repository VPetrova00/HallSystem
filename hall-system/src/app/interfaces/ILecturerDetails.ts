export interface ILecturerDetails {
  id: string;
  name: string;
  email: string;
  password: string;
}
export class Lecturer implements ILecturerDetails {
  id: string = '';
  name: string = '';
  email: string = '';
  password: string = '';

  constructor(name: string, email: string, password: string, id?: string) {
    if (id) this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
  }
}
