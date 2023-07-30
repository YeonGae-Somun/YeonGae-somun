package com.jpa.yeongaesomun.entity.file;

import com.jpa.yeongaesomun.entity.member.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_FILE")
@Getter @Setter @ToString
public class File {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull private String fileName;
    @NotNull private String filePath;
    @NotNull private String fileUuid;
    @NotNull private Long fileSize;

}
