//Rename RentalDue
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class RentalDueTest {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName;
        if (args.length == 0) {
            fileName = ("C:\\Users\\tatia\\OneDrive\\Documents\\NetBeansProjects\\RentalDueTest\\src\\rentalDB.txt");
        } else {
            fileName = args[0];
        }
        // The following code read the file twice, first is to acquire the total number
        // of the properities and second is to acquire the data for these properties.
        PropertyInfo propertyInfo = new PropertyInfo();
        int numberOfProperty = propertyInfo.get_numberOfProperty("C:\\Users\\tatia\\OneDrive\\Documents\\NetBeansProjects\\RentalDueTest\\src\\rentalDB.txt");

        // Construct objects for differnt type of rental properties 
        RentalProperty[] property = propertyInfo.get_typeOfProperty(fileName, numberOfProperty);
        propertyInfo.sortProperty(property, numberOfProperty);

        // Apply polymorphism to different rental property for the rent 
        for (RentalProperty currentProperty : property) {
            if (currentProperty instanceof ApartmentRental) {
                ApartmentRental prop = (ApartmentRental) currentProperty;
                prop.setmonthlyRent(1.00 * prop.getmonthlyRent());
            }
            if (currentProperty instanceof SingleFamilyRental) {
                SingleFamilyRental prop = (SingleFamilyRental) currentProperty;
                prop.setmonthlyRent(1.00 * prop.getmonthlyRent());
            }
            if (currentProperty instanceof VacationRental) {
                VacationRental prop = (VacationRental) currentProperty;
                prop.setmonthlyRent(1.00 * prop.getmonthlyRent());
                prop.setweeklyRent (1.00 * prop.getweeklyRent());
                prop.setdailyRent(1.00 * prop.getdailyRent());
            }
        }

        // List the rent for different kind of property, sorted order
        System.out.println("Single-Family Rental Summary:");
        System.out.printf("%-21s%-12s%17s%22s%25s%n", "House ID Number", "Rental Type",  "# of Bedrooms",     "Description",    "Rental Due" );
        System.out.printf("%-21s%-12s%17s%22s%25s%n", "===============", "============",  "==========",       "============",   "============");

        for (RentalProperty currentProperty : property) {
            if (currentProperty instanceof SingleFamilyRental) {
                System.out.println(currentProperty);
            }
        }

        System.out.println();
        System.out.println("Apartment Rental Summary:");
        System.out.printf("%-21s%-12s%17s%22s%25s%n", "House ID Number", "Rental Type",  "# of Bedrooms",  "Description",  "Rental Due");
        System.out.printf("%-21s%-12s%17s%22s%25s%n", "===============", "===========",   "==========",    "============",  "==========" );

        for (RentalProperty currentProperty : property) {
            if (currentProperty instanceof ApartmentRental) {
                System.out.println(currentProperty);
            }
        }
        
        System.out.println();
        System.out.println("Vacation Rental Summary:");
        System.out.printf("%-21s%-12s%17s%22s%25s%n", "House ID Number", "Rental Type",  "# of Bedrooms", "Description",   "Rental Due");
        System.out.printf("%-21s%-12s%17s%22s%25s%n", "===============", "============",  "=============", "============",  "==========");

        for (RentalProperty currentProperty : property) {
            if (currentProperty instanceof VacationRental) {
                System.out.println(currentProperty);
            }
        }
    }
}

class PropertyInfo {

    private static File file;
    private static RentalProperty[] property;
    Scanner input;
    int numberOfProperty;

    public int get_numberOfProperty(String DBFile) throws FileNotFoundException {
        file = new File(DBFile);
        input = new Scanner(new File("C:\\Users\\tatia\\OneDrive\\Documents\\NetBeansProjects\\RentalDueTest\\src\\rentalDB.txt"));//("C:\\Users\\tatia\\OneDrive\\Documents\\NetBeansProjects\\RentalDueTest\\src\\rentalDB.txt");

        while (true) {
            if (input.hasNextLine()) {
                numberOfProperty++;
                input.nextLine();
            } else {
                break;
            }
        }
        return numberOfProperty;
    }

    public RentalProperty[] get_typeOfProperty(String DBFile, int numberOfProperty) {
        file = new File(DBFile);
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.printf("%nError on file: %s (either enpty or wrong file format)%n%n", file);
            e.printStackTrace();
            System.exit(1);
        }
        property = new RentalProperty[numberOfProperty];

        for (int i = 0; i < numberOfProperty; i++) {
            switch (input.next()) {
                case "A":
                    property[i] = new ApartmentRental(input.next(),input.next(), Integer.parseInt(input.next()), input.nextLine());
                    break;
                case "S":
                    property[i] = new SingleFamilyRental(input.next(),input.next(), Integer.parseInt(input.next()), input.nextLine());
                    break;
                case "V":
                    property[i] = new VacationRental (input.next(),input.next(), Integer.parseInt(input.next()), input.nextLine());
                    break;
                default:
                    break;
            }
        }
        return property;
    }

    public void sortProperty(RentalProperty[] property, int numberOfProperty) {
        for (int i = 0; i < numberOfProperty; i++) {
            RentalProperty placeholder;
            for (int j = i + 1; j < numberOfProperty; j++) {
                if (property[i].getNumBedrooms() < property[j].getNumBedrooms()) {		// primary sort key
                    placeholder = property[j];
                    property[j] = property[i];
                    property[i] = placeholder;
                }
            }
        }

        for (int i = 0; i < numberOfProperty; i++) {
            RentalProperty placeholder;
            for (int j = i + 1; j < numberOfProperty; j++) {
                if (property[i].getNumBedrooms() == property[j].getNumBedrooms()
                        && property[i].getiDNum().compareTo(property[j].getiDNum()) > 0) {		// secondary sort key
                    placeholder = property[j];
                    property[j] = property[i];
                    property[i] = placeholder;
                }
            }
        }
    }

}
