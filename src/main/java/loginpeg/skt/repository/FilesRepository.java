package loginpeg.skt.repository;

import loginpeg.skt.domain.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository  extends JpaRepository <Files, Integer>{

    Files findByFno(int fno);
}
