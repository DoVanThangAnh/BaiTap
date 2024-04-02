package view;

import model.TextEditorModel;

import java.util.Scanner;

public class TextEditorView {
    private TextEditorModel model;

    public TextEditorView(TextEditorModel model) {
        this.model = model;
    }

    public void displayMenu() {
        System.out.println("1. Thêm dòng văn bản");
        System.out.println("2. Lưu vào tập tin");
        System.out.println("3. Đọc từ tập tin");
        System.out.println("4. Duyệt thư mục");
        System.out.println("0. Thoát");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            displayMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Nhập dòng văn bản: ");
                    String line = scanner.nextLine();
                    model.addLine(line);
                    break;
                case 2:
                    System.out.print("Nhập đường dẫn tập tin để lưu: ");
                    String saveFilePath = scanner.nextLine();
                    model.saveToFile(saveFilePath);
                    break;
                case 3:
                    System.out.print("Nhập đường dẫn tập tin để đọc: ");
                    String loadFilePath = scanner.nextLine();
                    model.loadFromFile(loadFilePath);
                    break;
                case 4:
                    System.out.print("Nhập đường dẫn thư mục để duyệt: ");
                    String directoryPath = scanner.nextLine();
                    model.recursiveFileSearch(directoryPath);
                    break;
                case 0:
                    System.out.println("Chương trình kết thúc.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (choice != 0);
    }
} 