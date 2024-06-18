package app.block8_upload_download_files.content.file.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/setpath")
public class PathFileController {

    private String filePath;


    @PutMapping
    public ResponseEntity<String> setFilePath(@RequestParam("path") String path) {
        this.filePath = path;
        return ResponseEntity.ok("Ruta configurada correctamente");
    }
}
