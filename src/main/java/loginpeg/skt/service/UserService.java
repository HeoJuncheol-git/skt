package loginpeg.skt.service;

import loginpeg.skt.UserDto.UserInfoDto;
import loginpeg.skt.domain.UserInfo;
import loginpeg.skt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Spring Security 필수 메소드 구현
     *
     * @param id 아이디
     * @return UserDetails
     * @throws UsernameNotFoundException 유저가 없을 때 예외 발생
     */
    @Override // 기본적인 반환 타입은 UserDetails, UserDetails를 상속받은 UserInfo로 반환 타입 지정 (자동으로 다운 캐스팅됨)
    public UserInfo loadUserByUsername(String id) throws UsernameNotFoundException { // 시큐리티에서 지정한 서비스이기 때문에 이 메소드를 필수로 구현
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException((id)));
    }

    /**
     * 회원정보 저장
     *
     * @param infoDto 회원정보가 들어있는 DTO
     * @return 저장되는 회원의 PK
     */
    public Long save(UserInfoDto infoDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        infoDto.setUrPassword(encoder.encode(infoDto.getUrPassword()));

        return userRepository.save(UserInfo.builder()
                .urEmail(infoDto.getUrEmail())
                .urName(infoDto.getUrName())
                .urPhone(infoDto.getUrPhone())
                .urHeight(infoDto.getUrHeight())
                .urAge(infoDto.getUrAge())
                .urSex(infoDto.getUrSex())
                .urBlood(infoDto.getUrBlood())
                .urReligion(infoDto.getUrReligion())
                .urDrunk(infoDto.getUrDrunk())
                .urRadio(infoDto.getUrRadio())
                .urEducation(infoDto.getUrEducation())
                .urJob(infoDto.getUrJob())
                .urPersonality(infoDto.getUrPersonality())
                .urDate(new Date())
                .urIntroduce(infoDto.getUrIntroduce())
                .id(infoDto.getId())
                .urAuth(infoDto.getUrAuth())
                .urPassword(infoDto.getUrPassword()).build()).getNo();


    }
}
