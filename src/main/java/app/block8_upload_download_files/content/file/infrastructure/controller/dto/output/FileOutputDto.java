package app.block8_upload_download_files.content.file.infrastructure.controller.dto.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FileOutputDto {

    private Long id;
    private String name;
    private LocalDate updatedDate;
    private String category;
}
