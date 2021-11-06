package domain.lotto.ui

import domain.lotto.domain.Lotto
import domain.lotto.domain.LottoNumber
import domain.lotto.domain.Lottos
import domain.lotto.domain.MatchBoard
import domain.lotto.domain.MatchResult
import domain.lotto.domain.Money
import global.common.constant.StringFavoriteConstant.BLANK
import global.common.constant.StringFavoriteConstant.COMMA
import global.common.constant.StringFavoriteConstant.EMPTY
import global.common.constant.StringFavoriteConstant.NEW_LINE
import global.common.constant.StringFavoriteConstant.SQUARE_BRACKETS_POSTFIX
import global.common.constant.StringFavoriteConstant.SQUARE_BRACKETS_PREFIX
import global.strategy.ui.ConsoleOutputStrategy
import kotlin.math.floor

class LottoResultView(private val consoleOutputStrategy: ConsoleOutputStrategy) {
    fun showNoHaveTicketResult() =
        consoleOutputStrategy.output(NO_HAVE_TICKET_MESSAGE)

    fun showLottos(lottos: Lottos) {
        consoleOutputStrategy.output(GENERATED_LOTTOS_MESSAGE)
        consoleOutputStrategy.output(lottosJoinToString(lottos.lottos))
    }

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
            .map(this::winningMatchResultMessage)
            .joinToString(separator = EMPTY)

    private fun winningMatchResultMessage(entry: Map.Entry<MatchBoard, Int>): String {
        val matchBoard = entry.key
        val rank = matchBoard.rank
        if (rank.necessityOfBonus) {
            return WINNING_MATCH_BONUS_RESULT_MESSAGE.format(rank.numberOfMatch, matchBoard.matchPrize, entry.value)
        }
        return WINNING_MATCH_RESULT_MESSAGE.format(rank.numberOfMatch, matchBoard.matchPrize, entry.value)
    }

    fun showYield(money: Money, winnings: Money) =
        consoleOutputStrategy.output(
            WINNINGS_YIELD_MESSAGE.format(
                floor(money.yield(winnings) * PERCENTAGE).div(PERCENTAGE)
            )
        )

    companion object {
        private const val NO_HAVE_TICKET_MESSAGE = "구매한 로또가 없습니다"
        private const val GENERATED_LOTTOS_MESSAGE =  "로또 리스트"
        private const val WINNING_MATCH_RESULT_MESSAGE = "%s개 일치 (%s원)- %s개$NEW_LINE"
        private const val WINNING_MATCH_BONUS_RESULT_MESSAGE = "%s개 일치 보너스 볼 일치(%s원)- %s개$NEW_LINE"
        private const val WINNINGS_YIELD_MESSAGE = "총 수익률은 %4.2f입니다."
        private const val PERCENTAGE = 100
    }
}
