package com.example.compareword;

import com.aspose.words.*;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.HashMap;

@RestController
public class Controller {
//    @GetMapping
//    public ResponseEntity<?> helo() throws Exception {
//        Document docA = new Document("C:\\Users\\Admin\\Documents\\tesst.doc");
//        Document docB = new Document("C:\\Users\\Admin\\Documents\\toan-2020-thpt-chuyen-hung-vuong-gia-lai.doc");
//
//        CompareOptions options = new CompareOptions();
//        options.setIgnoreFormatting(true);
//// Relates to Microsoft Word "Show changes in" option in "Compare Documents" dialog box.
//        options.setTarget(ComparisonTargetType.NEW);
//
//        docA.compare(docB, "user", new Date(), options);
//
//        DocSaveOptions saveOptions = new DocSaveOptions();
//
//        saveOptions.setSaveFormat(SaveFormat.DOC);
//        if(docA.getWatermark().getType() == WatermarkType.TEXT) docA.getWatermark().remove();
//
//
//// Export the document as an PCL file.
//        docA.save("C:\\Users\\Admin\\Documents\\" + "Document.test.doc", saveOptions);
//        return ResponseEntity.ok("hello");
//
////        return ResponseEntity.ok(docA.getRevisions().getCount() == 0 ? ("Documents are equal") : ("Documents are not equa"));
//    }
    @PostMapping
    @CrossOrigin
    public ResponseEntity<?> report(
            @RequestParam(value = "file1", required = false) MultipartFile file1,
            @RequestParam(value = "file2", required = false) MultipartFile file2)
            throws Exception {
//        HashMap<String , ArrayList<String>> listString = new HashMap<>();
//        ArrayList<String> list = new ArrayList<>();
//
//        for (MultipartFile file : files) {
//            String fileName =StringUtils.cleanPath(file.getOriginalFilename());
//            try {
//                Path path = Paths.get("src/main/resources/static/doc/" + fileName);
//                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
////                fileNames.add(path.toString());
////                a += fileName + ',';
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println(fileName);
//            list.add(fileName);
//        }
//        listString.put("listString",list);
        String fileName1 =StringUtils.cleanPath(file1.getOriginalFilename()).replace(" ","");
        String fileName2 =StringUtils.cleanPath(file2.getOriginalFilename()).replace(" ","");
        HashMap<String, String> listString = new HashMap<>();
        listString.put("fileName1",fileName1);
        listString.put("fileName2",fileName2);
        try {
                Path path1 = Paths.get("src/main/resources/static/" + fileName1);
                Files.copy(file1.getInputStream(), path1, StandardCopyOption.REPLACE_EXISTING);
//                fileNames.add(path.toString());
//                a += fileName + ',';
                Path path2 = Paths.get("src/main/resources/static/" + fileName2);
                Files.copy(file1.getInputStream(), path2, StandardCopyOption.REPLACE_EXISTING);

            } catch (IOException e) {
                e.printStackTrace();
            }



        return ResponseEntity.ok(listString);
    }

}
