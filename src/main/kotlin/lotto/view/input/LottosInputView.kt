package lotto.view.input

import lotto.model.RangeLottoBuilder
import lotto.model.data.Lotto
import lotto.model.data.Lottos
import lotto.model.data.Policy
import lotto.view.input.parser.IntInputParser
import lotto.view.input.parser.LottoInputParser
import lotto.view.input.parser.PurchaseAmountInputParser

class LottosInputView(
    private val policy: Policy,
    manualLottoProvider: ManualLottosInputView? = null,
    moneyAmountProvider: (() -> Int)? = null
) : InputView<Lottos>, ManualLottosInputView {

    private val inputParser = PurchaseAmountInputParser(policy)
    private val readPurchaseAmount = moneyAmountProvider ?: this::readAmountFromConsole
    private val manualLottosReader = manualLottoProvider ?: this

    private val lottoBuilder = RangeLottoBuilder(policy)
    override fun getInput(): Lottos {

        val isManualPurchaseAllowed = policy.isManualPurchaseAllowed

        val purchaseAmount = this.readPurchaseAmount()
        val totalLottoCount = purchaseAmount / policy.priceOfLotto

        val manualLottoCount = if (isManualPurchaseAllowed) {
            this.manualLottosReader.readCountOfManualLotto(maxCount = totalLottoCount)
        } else {
            0
        }

        val automaticLottoCount = totalLottoCount - manualLottoCount

        val manulLottos = this.manualLottosReader.readManualLottos(manualLottoCount)
        val autoLottos = lottoBuilder.createLottos(automaticLottoCount)

        val lottos = manulLottos + autoLottos

        if (isManualPurchaseAllowed) {
            println("수동으로 ${manualLottoCount}장, 자동으로 ${automaticLottoCount}개를 구매했습니다.")
        } else {
            println("${totalLottoCount}개를 구매했습니다.")
        }
        printLottos(lottos)
        return lottos
    }

    private fun readAmountFromConsole(): Int {
        return ConsoleReader.read(MESSAGE_TO_PURCHASE, inputParser)
    }

    override fun readCountOfManualLotto(maxCount: Int): Int {
        if (maxCount > 0) {
            return ConsoleReader.read(MESSAGE_FOR_MANUAL_COUNT, IntInputParser(0..maxCount))
        }
        return 0
    }

    override fun readManualLottos(count: Int): Lottos {
        if (count > 0) {
            println(MESSAGE_FOR_MANUAL_LOTTO)
            val lottoInputParser = LottoInputParser(policy)
            val lottoBuffer = mutableListOf<Lotto>()
            repeat(count) {
                val lotto = ConsoleReader.read("", lottoInputParser)
                lottoBuffer.add(lotto)
            }
            return Lottos(lottoBuffer)
        }
        return Lottos(listOf())
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
        private const val MESSAGE_FOR_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요."
        private const val MESSAGE_FOR_MANUAL_LOTTO = "수동으로 구매할 번호를 입력해 주세요."
    }
}
