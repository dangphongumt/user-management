package com.test.user.controller;

import com.test.user.exception.BadRequestException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

    @PostConstruct
    public void init() {
//        // Set the library path to where libtesseract.dylib is located
//        System.setProperty("jna.library.path", "/usr/local/lib");

        // Set the library path to where libtesseract.dylib is located
//        System.setProperty("java.library.path", "/usr/local/lib");

        // Force JVM to reload the library path
        System.setProperty("jna.library.path", "/usr/local/lib");
//        System.setProperty("tess4j.library.path", "/usr/local/lib");

        System.setProperty("TESSDATA_PREFIX", "/usr/local/share/");

    }

    @PostMapping("/import-excel")
    public ResponseEntity<String> importFileTest(@RequestPart("file") MultipartFile fileRequest) {
        if (fileRequest != null) {
            System.out.println(fileRequest.getContentType());
        }else {
            System.err.println("NULLLLLLLLLL");
        }

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @GetMapping("/read-text-from-image")
    public ResponseEntity<String> readTextFromImage() throws IOException {


//        // Set the library path
//        System.setProperty("java.library.path", "/usr/local/lib");
//
//        // Reflectively update the library path (required for some JVMs)
//        try {
//            Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
//            fieldSysPath.setAccessible(true);
//            fieldSysPath.set(null, null);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        Resource resource = new ClassPathResource("Screen.png");
        File imageFile = resource.getFile();

        ITesseract instance = new Tesseract();
        instance.setDatapath("/usr/local/share/tessdata");

//        instance.setDatapath("path_to_tesseract_data"); // Set the tessdata path

        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException(e);
        }
        return ResponseEntity.ok(HttpStatus.OK.toString());
    }
}
