package healthcare;
import java.sql.*;
import java.util.Scanner;

class Hospital {
    int hID;
    String name;
    String address;
    String phone;

    void displayAllHospitals(ResultSet rs) throws SQLException {
        System.out.format("%-5s%-40s%-40s%-15s \n", "hID", "Name", "Address", "Phone");
        while (rs.next()) {
            this.hID = Integer.parseInt(rs.getString("hospitalID"));
            this.name = rs.getString("name");
            this.address = rs.getString("address");
            this.phone = rs.getString("phone");

            System.out.format("%-5s%-40s%-40s%-15s", this.hID, this.name, this.address, this.phone);
            System.out.println();
        }
    }
}

class staff {
    int sID;
    String sname;
    String dept;
    char gender;
    String phone;

    void displayFullStaff(ResultSet rs) throws SQLException {
        System.out.format("%-5s%-25s%-25s%-15s%-15s \n", "sID", "Name", "Department", "Gender", "Phone");
        while (rs.next()) {
            this.sID = Integer.parseInt(rs.getString("staffID"));
            this.sname = rs.getString("name");
            this.dept = rs.getString("dept");
            this.gender = rs.getString("gender").charAt(0);
            this.phone = rs.getString("phone");

            System.out.format("%-5s%-25s%-25s%-15s%-15s", this.sID, this.sname, this.dept, this.gender, this.phone);
            System.out.println();
        }
    }
}

class Doctor {
    int dID;
    String dname;
    char gender;
    String phone;
    String speciality;

    void displayAllDoctors(ResultSet rs) throws SQLException {
        System.out.format("%-5s%-25s%-15s%-25s%-15s \n", "dID", "Name", "Gender", "Speciality", "Phone");
        while (rs.next()) {
            this.dID = Integer.parseInt(rs.getString("doctorID"));
            this.dname = rs.getString("name");
            this.gender = rs.getString("gender").charAt(0);
            this.phone = rs.getString("phone");
            this.speciality = rs.getString("speciality");

            System.out.format("%-5s%-25s%-15s%-25s%-15s", this.dID, this.dname, this.gender, this.speciality, this.phone);
            System.out.println();
        }
    }
}

class Nurse {
    int nID;
    String nname;
    char gender;
    String phone;

    void displayAllNurses(ResultSet rs) throws SQLException {
        System.out.format("%-5s%-25s%-15s%-15s \n", "hID", "Name", "Gender", "Phone");
        while (rs.next()) {
            this.nID = Integer.parseInt(rs.getString("nurseID"));
            this.nname = rs.getString("name");
            this.gender = rs.getString("gender").charAt(0);
            this.phone = rs.getString("phone");

            System.out.format("%-5s%-25s%-15s%-15s", this.nID, this.nname, this.gender, this.phone);
            System.out.println();
        }
    }
}

class Patient {
    int pID;
    String pname;
    char gender;
    String phone;
    String illness;

    void displayAllPatients(ResultSet rs) throws SQLException {
        System.out.format("%-5s%-25s%-30s%-15s%-15s \n", "pID", "Name", "Illness", "Gender", "Phone");
        while (rs.next()) {
            this.pID = Integer.parseInt(rs.getString("patientID"));
            this.pname = rs.getString("name");
            this.gender = rs.getString("gender").charAt(0);
            this.phone = rs.getString("phone");
            this.illness = rs.getString("illness");

            System.out.format("%-5s%-25s%-30s%-15s%-15s", this.pID, this.pname, this.illness, this.gender, this.phone);
            System.out.println();
        }
    }

    void insertData(Statement s) throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter name of the patient :");
        String pname = scan.nextLine();
        char pgender;
        do {
            System.out.print("Enter gender of the patient(Only M or F) :");
            pgender = scan.nextLine().charAt(0);
            pgender = Character.toUpperCase(pgender);
            if (pgender != 'F' && pgender != 'M')
                System.out.println("Please enter only 'M' or 'F'");
        } while (pgender != 'F' && pgender != 'M');
        String phone;
        do {
            System.out.print("Enter phone number of the patient :");
            phone = scan.nextLine();
            if (phone.length() != 10)
                System.out.println("Enter exact 10 digit phone number.");
        } while (phone.length() != 10);
        System.out.print("Enter illness of the patient :");
        String illness = scan.nextLine();
        int hos,nur,doc;boolean flag=false;
        do {
            System.out.print("Enter hospitalID of the patient(1,2 or 3) :");
            hos = Integer.parseInt(scan.nextLine());
            if(hos<1 || hos>3){
                System.out.println("Please enter hospitalID between 1,2 or 3");
                flag=true;
            }
            else
                flag=false;
        }while(flag);
        do {
            System.out.print("Enter nurseID of the nurse who attends the patient :");
            nur = Integer.parseInt(scan.nextLine());
            if (hos == 1 && (nur < 1 || nur > 6)) {
                flag = true;
                System.out.println("Enter only between 1 & 6 for hospitalID 1");
            }
            else if (hos == 2 && (nur < 7 || nur > 12)) {
                flag = true;
                System.out.println("Enter only between 7 & 12 for hospitalID 2");
            }
            else if(hos==3 && (nur<13 || nur>20)) {
                flag = true;
                System.out.println("Enter only between 13 & 20 for hospitalID 3");
            }
            else
                flag=false;
        }while(flag);
        do {
            System.out.print("Enter doctorID of the doctor who diagnoses the patient :");
            doc = Integer.parseInt(scan.nextLine());
            if(hos==1 && (doc<1 || doc>8)){
                flag=true;
                System.out.println("Enter only between 1 & 8 for hospitalID 1");
            }
            else if(hos==2 && (doc<9 || doc>16)){
                flag=true;
                System.out.println("Enter only between 9 & 16 for hospitalID 2");
            }
            else if(hos==3 && (doc<17 || doc>23)){
                flag=true;
                System.out.println("Enter only between 17 & 23 for hospitalID 3");
            }
            else
                flag=false;
        }while(flag);
        try {
            int count = s.executeUpdate("insert into patient (name,gender,phone,illness,nurseID,doctorID,hospitalID)" +
                    "values ('" + pname + "','" + pgender + "','" + phone + "','" + illness + "'," + nur + "," + doc + "," + hos + ")");
            System.out.println(count + " row(s) affected");
        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("Either nurseID, doctorID or hospitalID is invalid. Person with that ID is not present.");
        }
    }

    void deleteData(Statement s) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter patientID to delete :");
        int id = Integer.parseInt(sc.nextLine());
        s.executeUpdate("delete from patient where patientID=" + id);
    }
}

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/healthcare";    //URL of MySQL server
        String name = "root";                                     //Username of MySQL user
        String pass = "HelloWorld@";                              //Password of MySQL user
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, name, pass);
        Statement s = con.createStatement();

        char in;
        int choice = 0;
        do {
            System.out.println("...........................HEALTHCARE MANAGEMENT SYSTEM...........................");
            System.out.println("***********MENU***********");
            System.out.println("1.Display list of hospitals");
            System.out.println("2.Display list of Staff of a hospital");
            System.out.println("3.Display list of Doctors of a hospital");
            System.out.println("4.Display list of Nurses of a hospital");
            System.out.println("5.Display list of patients of a hospital");
            System.out.println("6.Find out patient by Patient's ID"); //
            System.out.println("7.Find out patient by Patient's Name");
            System.out.println("8.Find all Male patients of a hospital");
            System.out.println("9.Find all Female patients of a hospital");
            System.out.println("10.Find patients diagnosed by a particular doctor");
            System.out.println("11.Find patients taken care by a particular Nurse");
            System.out.println("12.Find Nurse by name");
            System.out.println("13.Find Nurse by Nurse's ID");
            System.out.println("14.Find doctor by Doctor's ID");
            System.out.println("15.Find doctor by Doctor's name");
            System.out.println("16.INSERT a new patient in a hospital");
            System.out.println("17.DELETE a patient in a hospital");

            Scanner scan = new Scanner(System.in);
            do {
                System.out.print("Enter choice :");
                try {
                    choice = Integer.parseInt(scan.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Not a number");
                }
                if (choice < 1 || choice > 17)
                    System.out.println("Please enter only between 1 and 16");
            } while (choice < 1 || choice > 17);

            switch (choice) {
                case 1: {
                    ResultSet rs = s.executeQuery("select * from Hospital");
                    Hospital h1 = new Hospital();
                    h1.displayAllHospitals(rs);
                    break;
                }
                case 2: {
                    System.out.print("Enter HospitalID(1, 2 or 3) whose staff is to be displayed :");
                    try {
                        int id = Integer.parseInt(scan.nextLine());
                        ResultSet rs = s.executeQuery("select * from staff where hospitalID=" + id);
                        staff st = new staff();
                        st.displayFullStaff(rs);
                    } catch (NumberFormatException ex) {
                        System.out.println("Character entered is not a number.");
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter HospitalID whose Doctors list is to be displayed :");
                    try {
                        int id = Integer.parseInt(scan.nextLine());
                        ResultSet rs = s.executeQuery("select * from Doctor where hospitalID=" + id);
                        Doctor doc = new Doctor();
                        doc.displayAllDoctors(rs);
                    } catch (NumberFormatException ex) {
                        System.out.println("Character entered is not a number.");
                    }
                    break;
                }
                case 4: {
                    System.out.print("Enter HospitalID whose Nurses list is to be displayed :");
                    try {
                        int id = Integer.parseInt(scan.nextLine());
                        ResultSet rs = s.executeQuery("select * from Nurse where hospitalID=" + id);
                        Nurse nurse = new Nurse();
                        nurse.displayAllNurses(rs);
                    } catch (NumberFormatException ex) {
                        System.out.println("Character entered is not a number.");
                    }
                    break;
                }
                case 5: {
                    System.out.print("Enter HospitalID whose Patients list is to be displayed :");
                    try {
                        int id = Integer.parseInt(scan.nextLine());
                        ResultSet rs = s.executeQuery("select * from Patient where hospitalID=" + id);
                        Patient patient = new Patient();
                        patient.displayAllPatients(rs);
                    } catch (NumberFormatException ex) {
                        System.out.println("Character entered is not a number.");
                    }
                    break;
                }
                case 6: {
                    System.out.print("Enter Patient's ID to search :");
                    try {
                        int id = Integer.parseInt(scan.nextLine());
                        ResultSet rs = s.executeQuery("select * from Patient where patientID=" + id);
                        Patient patient = new Patient();
                        patient.displayAllPatients(rs);
                    } catch (NumberFormatException ex) {
                        System.out.println("Character entered is not a number.");
                    }
                    break;
                }
                case 7: {
                    System.out.print("Enter patient's name :");
                    String str = scan.nextLine();
                    ResultSet rs = s.executeQuery("select * from Patient where name='" + str + "'");
                    Patient patient = new Patient();
                    patient.displayAllPatients(rs);
                    break;
                }
                case 8: {
                    System.out.print("Enter Hospital ID :");
                    try {
                        int id = Integer.parseInt(scan.nextLine());
                        ResultSet rs = s.executeQuery("select * from Patient where gender='M' and hospitalID=" + id);
                        Patient patient = new Patient();
                        patient.displayAllPatients(rs);
                    } catch (NumberFormatException ex) {
                        System.out.println("Character entered is not a number.");
                    }
                    break;
                }
                case 9: {
                    System.out.print("Enter Hospital ID :");
                    try {
                        int id = Integer.parseInt(scan.nextLine());
                        ResultSet rs = s.executeQuery("select * from Patient where gender='F' and hospitalID=" + id);
                        Patient patient = new Patient();
                        patient.displayAllPatients(rs);
                    } catch (NumberFormatException ex) {
                        System.out.println("Character entered is not a number.");
                    }
                    break;
                }
                case 10: {
                    System.out.print("Enter Doctor ID :");
                    try {
                        int id = Integer.parseInt(scan.nextLine());
                        ResultSet rs = s.executeQuery("select * from Patient where doctorID=" + id);
                        Patient patient = new Patient();
                        patient.displayAllPatients(rs);
                    } catch (NumberFormatException ex) {
                        System.out.println("Character entered is not a number.");
                    }
                    break;
                }
                case 11: {
                    System.out.print("Enter Nurse ID :");
                    try {
                        int id = Integer.parseInt(scan.nextLine());
                        ResultSet rs = s.executeQuery("select * from Patient where nurseID=" + id);
                        Patient patient = new Patient();
                        patient.displayAllPatients(rs);
                    } catch (NumberFormatException ex) {
                        System.out.println("Character entered is not a number.");
                    }
                    break;
                }
                case 12: {
                    System.out.print("Enter Name of the Nurse :");
                    String str = scan.nextLine();
                    ResultSet rs = s.executeQuery("select * from Nurse where name='" + str + "'");
                    Nurse nurse = new Nurse();
                    nurse.displayAllNurses(rs);
                    break;
                }
                case 13: {
                    System.out.print("Enter Nurse ID :");
                    try {
                        int id = Integer.parseInt(scan.nextLine());
                        ResultSet rs = s.executeQuery("select * from Nurse where nurseID=" + id);
                        Nurse nurse = new Nurse();
                        nurse.displayAllNurses(rs);
                    } catch (NumberFormatException ex) {
                        System.out.println("Character entered is not a number.");
                    }
                    break;
                }
                case 14: {
                    System.out.print("Enter Doctor ID :");
                    try {
                        int id = Integer.parseInt(scan.nextLine());
                        ResultSet rs = s.executeQuery("select * from Doctor where doctorID=" + id);
                        Doctor doctor = new Doctor();
                        doctor.displayAllDoctors(rs);
                    } catch (NumberFormatException ex) {
                        System.out.println("Character entered is not a number.");
                    }
                    break;
                }
                case 15: {
                    System.out.print("Enter Doctor's Name :");
                    String str = scan.nextLine();
                    ResultSet rs = s.executeQuery("select * from Doctor where name='" + str + "'");
                    Doctor doctor = new Doctor();
                    doctor.displayAllDoctors(rs);
                    break;
                }
                case 16: {
                    Patient patient = new Patient();
                    patient.insertData(s);
                    break;
                }
                case 17: {
                    Patient pat = new Patient();
                    pat.deleteData(s);
                    break;
                }
            }
            System.out.println();
            System.out.print("Do you want to do another operation from Menu." +
                    "Enter Y/y if Yes,Otherwise enter any other letter :");
            in = scan.nextLine().charAt(0);
        } while (in == 'Y' || in == 'y');
    }
}
