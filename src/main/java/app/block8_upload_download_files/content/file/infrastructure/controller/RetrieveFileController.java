package app.block8_upload_download_files.content.file.infrastructure.controller;

import app.block8_upload_download_files.content.file.domain.entity.File;
import app.block8_upload_download_files.content.file.infrastructure.controller.dto.output.FileOutputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@RestController
@RequestMapping("/file")
public class RetrieveFileController {

    @GetMapping
    public ResponseEntity<FileOutputDto> downloadFileById(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name)
    {
        FileOutputDto fileOutputDto = new FileOutputDto();
        fileOutputDto.setId(4L);
        fileOutputDto.setName("Nombre del archivo");
        fileOutputDto.setCategory("Categoria del archivo");
        fileOutputDto.setUpdatedDate(LocalDate.now());

        return ResponseEntity.ok(fileOutputDto);
    }
}

