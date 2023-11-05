package lottery.domain

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottosTest {

    @Test
    @DisplayName("로또 갯수와 로또 생성 규칙을 전달하여 로또 번호 리스트를 가지는 객체를 생성한다")
    fun create_lotto_list() {
        val result = Lottos.of(5, RandomNumberGenerator())

        result.lottos.size shouldBe 5
    }

    @Test
    @DisplayName("로또 번호 리스트를 가지고 있는 객체는 당첨 번호 정보를 가지는 로또 객체를 받아 매칭 결과를 리스트로 반환한다")
    fun matchLottos() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lottos.of(1, InputNumberGenerator(lottoNumbers))
        val result = lotto.matchLottos(Lotto(lottoNumbers))

        result.shouldBeInstanceOf<List<Rank>>()
    }
}
