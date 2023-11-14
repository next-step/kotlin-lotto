package lottery.domain

import io.kotest.matchers.types.shouldBeInstanceOf
import org.junit.jupiter.api.Test

class LottoGameTest {
    @Test
    fun `로또 금액과 로또 리스트를 통해 로또 게임을 생성한다`() {
        val lottoMoney = LottoMoney.of(1000, 0)
        val lottos = AutoLottoMachine(RandomNumberGenerator()).createLottos(1)
        val lottoGame = LottoGame(lottoMoney, Lottos(lottos))

        lottoGame.shouldBeInstanceOf<LottoGame>()
    }

    @Test
    fun `지난 주 당첨 번호를 입력하여 결과 객체를 반환 받는다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val userLotto = Lottos(listOf(Lotto.of(lottoNumbers)))
        val lottoMoney = LottoMoney.of(1000, 0)
        val lottoGame = LottoGame(lottoMoney, userLotto)
        val result = lottoGame.getRanks(WinningLotto(lottoNumbers, bonusNumber))

        result.shouldBeInstanceOf<Ranks>()
    }
}
