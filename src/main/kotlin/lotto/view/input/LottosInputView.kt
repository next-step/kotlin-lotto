package lotto.view.input

import lotto.model.RangeLottoBuilder
import lotto.model.data.Lotto
import lotto.model.data.Lottos
import lotto.model.data.Policy
import lotto.view.input.parser.PurchaseAmountInputParser

class LottosInputView(
    private val policy: Policy,
    moneyAmountProvider: (() -> Int)? = null
) : InputView<Lottos> {

    private val inputParser = PurchaseAmountInputParser(policy)
    private val readInputAction = moneyAmountProvider ?: this::readAmountFromConsole
    private val lottoBuilder = RangeLottoBuilder(policy)
    override fun getInput(): Lottos {
        val purchaseAmount = readInputAction()
        val numberOfLotto = purchaseAmount / policy.priceOfLotto
        println("${numberOfLotto}개를 구매했습니다.")

        val lottos = lottoBuilder.createLottos(numberOfLotto)
        printLottos(lottos)
        return lottos
    }

    private fun readAmountFromConsole(): Int {
        return ConsoleReader.read(MESSAGE_TO_PURCHASE, inputParser)
    }

    private fun printLottos(lottos: Lottos) {
        lottos.map { it.toDisplayString() }
            .forEach(::println)
        println()
    }

    private fun Lotto.toDisplayString() =
        this.numbers.joinToString(separator = ", ", prefix = "[", postfix = "]")

    companion object {
        private const val MESSAGE_TO_PURCHASE = "구입금액을 입력해 주세요."
    }
}
