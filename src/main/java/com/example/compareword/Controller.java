package com.example.compareword;

import com.aspose.words.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

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
//
//// Export the document as an PCL file.
//        docA.save("C:\\Users\\Admin\\Documents\\" + "Document.PclConversion_out.doc", saveOptions);
//
//        return ResponseEntity.ok("hello");
//
////        return ResponseEntity.ok(docA.getRevisions().getCount() == 0 ? ("Documents are equal") : ("Documents are not equa"));
//    }
    @PostMapping
    @CrossOrigin
    public ResponseEntity<?> report(
            @RequestParam(value = "file", required = false) MultipartFile[] files) throws Exception {
        for (MultipartFile file : files) {
            String fileName =StringUtils.cleanPath(file.getOriginalFilename());
            try {
                Path path = Paths.get("src/main/resources/static/doc/" + fileName);
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//                fileNames.add(path.toString());
//                a += fileName + ',';

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(fileName);
        }

        return ResponseEntity.ok("succes");
    }

}
