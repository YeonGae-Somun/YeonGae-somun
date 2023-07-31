package com.jpa.yeongaesomun.entity.file;

import com.jpa.yeongaesomun.audit.Period;
import com.jpa.yeongaesomun.entity.member.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_FILE")
@Getter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class File extends Period {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String fileName;
    @NotNull private String filePath;
    @NotNull private String fileUuid;
    @NotNull private Long fileSize;

}
