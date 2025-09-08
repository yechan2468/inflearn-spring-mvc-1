package yechan.inflearn_spring_mvc_1.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import yechan.inflearn_spring_mvc_1.domain.member.Member;
import yechan.inflearn_spring_mvc_1.domain.member.MemberRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member("hello", 20);

        Member saved = memberRepository.save(member);

        assertThat(memberRepository.findById(saved.getId())).isEqualTo(saved);
    }

    @Test
    void findAll() {
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
}