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

    override fun getInput(): Lottos {
        val purchaseAmount = this.readPurchaseAmount()
        val lottoCount = this.readLottoCount(purchaseAmount)
        val lottos = this.createLottos(lottoCount)
        if (policy.isManualPurchaseAllowed) {
            println("수동으로 ${lottoCount.manual}장, 자동으로 ${lottoCount.automatic}개를 구매했습니다.")
        } else {
            println("${lottoCount.total}개를 구매했습니다.")
        }
        printLottos(lottos)
        return lottos
    }

    private fun readLottoCount(purchaseAmount: Int): LottoCount {
        val totalLottoCount = purchaseAmount / policy.priceOfLotto
        val isManualPurchaseAllowed = policy.isManualPurchaseAllowed

        return if (isManualPurchaseAllowed) {
            val manualLottoCount = this.manualLottosReader.readCountOfManualLotto(maxCount = totalLottoCount)
            LottoCount(totalLottoCount, manualLottoCount)
        } else {
            LottoCount(totalLottoCount, 0)
        }
    }

    private fun createLottos(lottoCount: LottoCount): Lottos {
        val manualLottos = this.manualLottosReader.readManualLottos(lottoCount.manual)
        val autoLottos = RangeLottoBuilder(policy).createLottos(lottoCount.automatic)
        return manualLottos + autoLottos
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

    private data class LottoCount(val total: Int, val manual: Int) {
        val automatic: Int
            get() = total - manual
    }
}
