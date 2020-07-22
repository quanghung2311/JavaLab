package JSP0054;

import java.util.ArrayList;

/**
 *
 * @author Quang Hung
 */
public class Manager {

    public static void createContact(ArrayList<Contact> lc) {
        System.out.println("--------Add a Contact---------");
        System.out.print("Enter id contact: ");
        int contactID = Validation.checkInputInt();
        System.out.print("Enter first name: ");
        String firstName = Validation.checkInputString();
        System.out.print("Enter last name: ");
        String lastName = Validation.checkInputString();
        System.out.print("Enter group: ");
        String group = Validation.checkInputString();
        System.out.print("Enter address: ");
        String address = Validation.checkInputString();
        System.out.print("Enter phone: ");
        String phone = Validation.checkInputPhone();
        lc.add(new Contact(contactID, firstName + lastName, group, address,
                phone, firstName, lastName));
        System.err.println("Add successful.");
    }

    public static void printAllContact(ArrayList<Contact> lc) {
        System.out.println("------------Display all Contact---------");
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");
        for (Contact contact : lc) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getContactID(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }

    public static void deleteContactd(ArrayList<Contact> lc) {
        System.out.println("-------Delete a Contact--------");
        System.out.print("Enter id: ");
        int idDelete = Validation.checkInputInt();
        Contact contactDelete = getContactById(lc, idDelete);
        if (contactDelete == null) {
            System.err.println("Not found contact.");
            return;
        } else {
            lc.remove(contactDelete);
        }
        System.err.println("Delete successful.");
    }

    public static Contact getContactById(ArrayList<Contact> lc, int idDelete) {
        for (Contact contact : lc) {
            if (contact.getContactID() == idDelete) {
                return contact;
            }
        }
        return null;
    }
}
