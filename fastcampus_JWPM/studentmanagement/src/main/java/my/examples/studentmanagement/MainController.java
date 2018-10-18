package my.examples.studentmanagement;

//import my.examples.studentmanagement.dao.StudentDAO;

public class MainController {
    //private StudentDAO studentDAO;
    private UI ui;

    public MainController(UI ui) {
        this.ui = ui;
    }

//    public MainController(StudentDAO studentDAO, UI ui) {
//        this.studentDAO = studentDAO;
//        this.ui = ui;
//    }

    public void controller(){
        while(true) {
            int choice = ui.main();
            switch(choice) {
                case 1: Student student = ui.addStudent();
                        if(student != null){
                            System.out.println("등록 완료!\n");
                        }
                        break;
                case 2:
                        break;
                case 3: ui.end();
                        System.exit(0);
            }
        }
    }
}
