import java.time.Year;

    public class Person
    {


        String firstName;
        String lastName;
        String ID;
        String title;
        int YOB;

        public Person(String firstName, String lastName, String ID, String title, int YOB) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.ID = ID;
            this.title = title;
            this.YOB = YOB;
        }

        public String fullName() {
            return firstName + " " + lastName;
        }

        public String formalName() {
            return title + " " + fullName();
        }

        public int getAge() {
            int currentYear = Year.now().getValue();
            return currentYear - YOB;
        }

        public int getAge(int year) {
            return year - YOB;
        }
        public String toCSV() {
            return ID + "," + firstName + "," + lastName + "," + title + "," + YOB;
        }

        public String toJSON() {
            return "{\"ID\":\"" + ID + "\",\"firstName\":\"" + firstName + "\",\"lastName\":\"" + lastName
                    + "\",\"title\":\"" + title + "\",\"YOB\":" + YOB + "}";
        }

        public String toXML() {
            return "<Person><ID>" + ID + "</ID><FirstName>" + firstName + "</FirstName><LastName>" + lastName
                    + "</LastName><Title>" + title + "</Title><YOB>" + YOB + "</YOB></Person>";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return ID.equals(person.ID);
        }


    }


