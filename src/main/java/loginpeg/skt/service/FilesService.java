package loginpeg.skt.service;

import loginpeg.skt.domain.Files;
import loginpeg.skt.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilesService {
    @Autowired
    FilesRepository filesRepository;

    public void save(Files files) {
        Files f = new Files();
        f.setFilename(files.getFilename());
        f.setFileOriName(files.getFileOriName());
        f.setFileurl(files.getFileurl());

        filesRepository.save(f);
    }
}
