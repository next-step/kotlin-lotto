package lotto.domain

import lotto.domain.ExceptionType.NUMBER_OF_MANUAL_SELECT_GAME_MUST_LESS_THEN_FULL_GAME_NUMBER
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.assertj.core.api.Assertions.assertThatNoException
import org.junit.jupiter.api.Test

class LottoNumberSelectPaperTest {
    @Test
    fun `수동 게임 구매 횟수가, 전체 구매 가능 게임 횟수를 넘기면 예외가 발생한다`() {
        val expectedException: () -> LottoNumberSelectPaper =
            { LottoNumberSelectPaper(LottoBudget(2000), NumberOfManualSelectGames(3)) }

        assertThatIllegalArgumentException().isThrownBy { expectedException.invoke() }
            .withMessage(NUMBER_OF_MANUAL_SELECT_GAME_MUST_LESS_THEN_FULL_GAME_NUMBER)
    }

    @Test
    fun `수동 게임 구매 횟수가, 전체 구매 가능 게임 횟수를 넘기지 않으면 예외가 발생하지 않는다`() {
        val expectedException: () -> LottoNumberSelectPaper =
            { LottoNumberSelectPaper(LottoBudget(2000), NumberOfManualSelectGames(2)) }

        assertThatNoException().isThrownBy { expectedException.invoke() }
    }

    @Test
    fun `수동 게임 구매 횟수보다 이하로 로또 게임을 추가 할 경우 예외가 발생 하지 않는다`() {
        val lottoNumberSelectPaper = LottoNumberSelectPaper(LottoBudget(2000), NumberOfManualSelectGames(2))
        val lottoGame = LottoGame((1..6).map { LottoNumber(it) })
        lottoNumberSelectPaper.addManualSelectGame(lottoGame)

        assertThatNoException().isThrownBy { lottoNumberSelectPaper.addManualSelectGame(lottoGame) }
    }
    @Test
    fun `수동 게임 구매 횟수보다 더 많이 로또 게임을 추가 할 경우 예외가 발생 한다`() {
        val lottoNumberSelectPaper = LottoNumberSelectPaper(LottoBudget(2000), NumberOfManualSelectGames(2))
        val lottoGame = LottoGame((1..6).map { LottoNumber(it) })
        lottoNumberSelectPaper.addManualSelectGame(lottoGame)
        lottoNumberSelectPaper.addManualSelectGame(lottoGame)

        assertThatIllegalArgumentException()
            .isThrownBy { lottoNumberSelectPaper.addManualSelectGame(lottoGame) }
            .withMessage(ExceptionType.CAN_NOT_ADD_MANUAL_GAME_MORE_THEN_FIXED_NUMBER)
    }
}
