package loginpeg.skt.domain;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Getter
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int fno;

    String filename;
    String fileOriName;
    String fileurl;
}
