package domain.lotto.ui

import domain.lotto.domain.Lotto
import domain.lotto.domain.LottoNumber
import domain.lotto.domain.Lottos
import domain.lotto.domain.MatchBoard
import domain.lotto.domain.MatchResult
import domain.lotto.domain.Money
import global.common.StringFavoriteConstant.BLANK
import global.common.StringFavoriteConstant.COMMA
import global.common.StringFavoriteConstant.EMPTY
import global.common.StringFavoriteConstant.NEW_LINE
import global.common.StringFavoriteConstant.SQUARE_BRACKETS_POSTFIX
import global.common.StringFavoriteConstant.SQUARE_BRACKETS_PREFIX
import global.strategy.ui.ConsoleOutputStrategy
import kotlin.math.floor

class LottoResultView(private val consoleOutputStrategy: ConsoleOutputStrategy) {
    fun showNumberOfPurchases(numberOfPurchases: Int) =
        consoleOutputStrategy.output(NUMBER_OF_PURCHASES_MESSAGE.format(numberOfPurchases))

    fun showLottos(lottos: Lottos) =
        consoleOutputStrategy.output(lottosJoinToString(lottos.lottos))

    private fun lottosJoinToString(lottos: List<Lotto>) =
        lottos.joinToString(separator = EMPTY, transform = this::showLotto)

    private fun showLotto(lotto: Lotto) =
        lottoJoinToString(lotto.lotto)

    private fun lottoJoinToString(lotto: Set<LottoNumber>) =
        lotto.map { it.lottoNumber }
            .joinToString(
                separator = COMMA + BLANK,
                prefix = SQUARE_BRACKETS_PREFIX,
                postfix = SQUARE_BRACKETS_POSTFIX + NEW_LINE
            )

    fun showMatchResult(matchResult: MatchResult) =
        consoleOutputStrategy.output(matchResultJoinToString(matchResult.matchResult))

    private fun matchResultJoinToString(matchResult: Map<MatchBoard, Int>) =
        matchResult
            .map { WINNING_MATCH_RESULT_MESSAGE.format(it.key.numberOfMatch, it.key.matchPrize, it.value) }
            .joinToString(separator = EMPTY)

    fun showYield(money: Money, winnings: Money) =
        consoleOutputStrategy.output(
            WINNINGS_YIELD_MESSAGE.format(
                floor(money.yield(winnings) * PERCENTAGE).div(PERCENTAGE)
            )
        )

    companion object {
        private const val NUMBER_OF_PURCHASES_MESSAGE = "%s개를 구매했습니다."
        private const val WINNING_MATCH_RESULT_MESSAGE = "%s개 일치 (%s원)- %s개$NEW_LINE"
        private const val WINNINGS_YIELD_MESSAGE = "총 수익률은 %4.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        private const val PERCENTAGE = 100
    }
}