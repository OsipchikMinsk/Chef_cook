import entity.Salad;
import service.implementations.ParsingFileServiceImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {

        ParsingFileServiceImpl parsingFileService = new ParsingFileServiceImpl();
        ArrayList<ArrayList> saladList = parsingFileService.getSalads("C:\\Users\\ARTos\\IdeaProjects\\chef_cook\\src\\main\\resources\\recipes.txt");

        ArrayList<Salad> salads = new ArrayList<>();
        int size = saladList.size();
//        for (int i = 0; i < size; i++) {
//            Salad salad = new Salad(saladList.get(i).get(0))
//            for (int j = 0)  saladList[i].
//
//        }

    }
}
