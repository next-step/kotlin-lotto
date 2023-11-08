package lottery.domain

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoGameTest {
    @ParameterizedTest(name = "구매 금액 {0}원을 입력하면 로또 {1}장이 생성된다")
    @CsvSource("999,0", "1000,1", "1001,1", "3500,3")
    fun `로또 구입 금액을 입력받아 로또 구매 장수를 생성한다`(price: Int, quantity: Int) {
        val lottoGame = LottoGame(price)

        lottoGame.getLottos().size shouldBe quantity
    }

    @Test
    fun `지난 주 당첨 번호를 입력하여 결과 객체를 반환 받는다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lottoGame = LottoGame(1000, InputNumberGenerator(lottoNumbers))
        val result = lottoGame.getRanks(WinningLotto(lottoNumbers, bonusNumber))

        result.shouldBeInstanceOf<Ranks>()
    }
}
