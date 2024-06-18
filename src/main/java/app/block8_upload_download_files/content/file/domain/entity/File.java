package app.block8_upload_download_files.content.file.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class File {

    private Long id;
    private String name;
    private LocalDate updatedDate;
    private String category;

    public File(String name, LocalDate updatedDate, String category) {
        this.name = name;
        this.updatedDate = updatedDate;
        this.category = category;
    }
}

