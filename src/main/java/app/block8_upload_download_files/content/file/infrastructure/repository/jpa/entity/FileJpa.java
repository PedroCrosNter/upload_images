package app.block8_upload_download_files.content.file.infrastructure.repository.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "files")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FileJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "updated_at")
    private LocalDate updatedDate;

    @Column(name = "category")
    private String category;
}
