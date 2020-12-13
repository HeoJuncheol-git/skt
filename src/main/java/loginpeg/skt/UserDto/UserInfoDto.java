package loginpeg.skt.UserDto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.transaction.spi.JoinStatus;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Getter
@Setter
public class UserInfoDto {
    private String id;          //아이디
    private String urPassword;  //비밀번호
    private String urAuth;      //등급
    private String urEmail;    //이메일
    private String urName;    //이름
    private int urPhone;    //핸드폰번호
    private int urHeight;     // 키
    private int urAge;     //나이
    private String urSex;     //성별
    private String urBlood;  //혈액형
    private String urReligion; //종교
    private String urDrunk;  //음주량
    private String urRadio;     // 흡연여부
    private String urEducation;  //학력
    private String urJob;       // 직업
    private String urPersonality;    //성격
    private Date urDate;     //가입날짜
    private String urIntroduce;      //자기소개
    private JoinStatus urLoading;  //가입상태
}
