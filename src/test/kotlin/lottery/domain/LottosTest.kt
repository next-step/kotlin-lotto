package lottery.domain

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.types.shouldBeInstanceOf
import org.junit.jupiter.api.Test

class LottosTest {

    @Test
    fun `로또 번호 리스트를 가지는 객체를 생성한다`() {
        val result = Lottos(LottoMachine(RandomNumberGenerator()).createLottos(5))

        result.lottos shouldHaveSize 5
    }

    @Test
    fun `로또 번호 리스트를 가지고 있는 객체는 당첨 번호 정보를 가지는 로또 객체를 받아 매칭 결과를 리스트로 반환한다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val winningLotto = WinningLotto(lottoNumbers, 7)
        val result = Lottos(listOf(Lotto.of(lottoNumbers))).matchLottos(winningLotto)

        result.shouldBeInstanceOf<List<Rank>>()
    }
}
