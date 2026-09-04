package example.miniproject2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class MemberDto {
    private Integer member_id;
    private String login_id;
    private String password;
    private String phone;
    private String member_type;
    private String name;
    private String created_at;

    // DTO -> Entity 변환
    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .member_id(this.member_id)
                .login_id(this.login_id)
                .password(this.password)
                .phone(this.phone)
                .member_type(this.member_type)
                .name(this.name)
                .created_at(this.created_at) 
                .build();
    }

    // Entity -> DTO 변환
    public static MemberDto from(MemberEntity memberEntity) {
        return MemberDto.builder()
                .member_id(memberEntity.getMember_id())
                .login_id(memberEntity.getLogin_id())
                .password(memberEntity.getPassword())
                .phone(memberEntity.getPhone())
                .member_type(memberEntity.getMember_type())
                .name(memberEntity.getName())
                .created_at(memberEntity.getCreated_at())
                .build();
    }
}