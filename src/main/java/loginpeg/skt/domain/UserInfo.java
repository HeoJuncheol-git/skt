package loginpeg.skt.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.engine.transaction.spi.JoinStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name="USERINFO_SEQ_GENERATOR",
        sequenceName = "USERINFO_SEQ",
        initialValue = 1,
        allocationSize = 1)

@Entity
@Getter
public class UserInfo implements UserDetails {

    @Id
    @Column(name = "ur_no")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "USERINFO_SEQ_GENERATOR")
    private Long no;

    @Column(name = "ur_id", unique = true)
    private String id;          //아이디

    @Column(name = "ur_password")
    private String urPassword;    //비밀번호

    @Column(name = "ur_auth")
    private String urAuth;        //등급

    @Column(name = "ur_email")
    private String urEmail;    //이메일

    @Column(name = "ur_name")
    private String urName;    //이름

    @Column(name = "ur_phone")
    private int urPhone; //핸드폰번호

    @Column(name = "ur_height")
    private int urHeight;     // 키

    @Column(name = "ur_age")
    private int urAge;     //나이

    @Column(name = "ur_sex")
    private String urSex;     //성별
    // private String userZipcode;  //번지주소
//    private String detail_address;    //상세주소

    @Column(name = "ur_blood")
    private String urBlood;  //혈액형

    @Column(name = "ur_religion")
    private String urReligion;  //종교

    @Column(name = "ur_drunk")
    private String urDrunk;  //음주량

    @Column(name = "ur_radio")
    private String urRadio;  //흡연여부

    @Column(name = "ur_education")
    private String urEducation;  //학력

    @Column(name = "ur_job")
    private String urJob;  //학력

    @Column(name = "ur_personality")
    private String urPersonality;    //성격

    @Column(name = "ur_date")
    private Date urDate;     //가입날짜

    @Column(name = "ur_introduce")
    private String urIntroduce;      //자기소개

    @Enumerated(EnumType.STRING)
    private JoinStatus urLoading;  //가입상태


    @Builder
    public UserInfo(String id, String urPassword, String urAuth,
                    String urEmail, String urName, int urPhone, int urHeight, int urAge,
                    String urSex, String urBlood, String urReligion, String urDrunk, String urRadio, String urEducation,
                    String urJob, String urPersonality, Date urDate, String urIntroduce, JoinStatus urLoading) {
        this.id = id;
        this.urPassword = urPassword;
        this.urAuth = urAuth;
        this.urEmail = urEmail;
        this.urName = urName;
        this.urPhone = urPhone;
        this.urHeight = urHeight;
        this.urAge = urAge;
        this.urSex = urSex;
        this.urBlood = urBlood;
        this.urReligion = urReligion;
        this.urDrunk = urDrunk;
        this.urRadio = urRadio;
        this.urEducation = urEducation;
        this.urJob = urJob;
        this.urPersonality = urPersonality;
        this.urDate = urDate;
        this.urIntroduce = urIntroduce;
        this.urLoading = urLoading;


    }

    // 사용자의 권한을 콜렉션 형태로 반환
    // 단, 클래스 자료형은 GrantedAuthority를 구현해야함
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (String role : urAuth.split(",")) {
            roles.add(new SimpleGrantedAuthority(role));
        }
        return roles;
    }

    // 사용자의 id를 반환 (unique한 값)
    @Override
    public String getUsername() {
        return id;
    }

    // 사용자의 password 를 반환
    @Override
    public String getPassword() {
        return urPassword;
    }

    // 계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() {
        // 만료되었는지 확인하는 로직
        return true; // true -> 만료되지 않았음
    }

    // 계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked() {
        // 계정 잠금되었는지 확인하는 로직
        return true; // true -> 잠금되지 않았음
    }

    // 패스워드의 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        // 패스워드가 만료되었는지 확인하는 로직
        return true; // true -> 만료되지 않았음
    }

    // 계정 사용 가능 여부 반환
    @Override
    public boolean isEnabled() {
        // 계정이 사용 가능한지 확인하는 로직
        return true; // true -> 사용 가능
    }
}
