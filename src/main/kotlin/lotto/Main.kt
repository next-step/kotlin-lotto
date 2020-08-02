import lotto.domain.LottoItems
import lotto.view.InputView

fun main() {
    val inputMoney = InputView.inputMoney()
    val buyCount = inputMoney / 1000
    println("${buyCount}개를 구매했습니다.")

    val lottoItems = LottoItems(buyCount)
    val lottos = lottoItems.getLottoItems()

    val winningNumbers = InputView.inputWinningNumber()

    println(lottos.joinToString(""))

    println("당첨 통계")
    println("---------")
    val result = lottoItems.getWinLottos(winningNumbers)
    println(result.joinToString(""))
}
