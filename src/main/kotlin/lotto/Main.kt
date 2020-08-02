import lotto.domain.LottoItems
import lotto.domain.LottoNumber
import lotto.input.InputView

fun main() {
    val inputMoney = InputView.inputMoney("구입금액을 입력해 주세요.")
    val buyCount = inputMoney / 1000
    println("${buyCount}개를 구매했습니다.")

    val lottoItems = LottoItems(buyCount)
    val lottos = lottoItems.getLottoItems()

    // InputView.inputWinningNumber("지난 주 당첨 번호를 입력해 주세요.")
    val winningNumbers = List(6) { i -> LottoNumber(i + 1) }

    println(lottos)

    val a = lottoItems.getWinLottos(winningNumbers)

    println("당첨 통계")
    println("---------")
    println(a.joinToString(""))
}
