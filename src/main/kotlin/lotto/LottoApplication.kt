package lotto

import lotto.ui.LottoInputTitle
import lotto.ui.LottoResponse
import java.math.BigDecimal

private const val INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요."
private const val INPUT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요."
private const val INPUT_MANUAL_LOTTO = "수동으로 구매할 번호를 입력해 주세요."

private const val INPUT_WINNING_LOTTO = "지난 주 당첨 번호를 입력해 주세요."
private const val INPUT_WINNING_BONUS_NUMBER = "보너스 볼을 입력해 주세요."

fun main() {

    val lottoMachine = LottoMachine(AutoLottoMaker(), ManualLottoMaker())

    val lottoSeller = paidMoneyToLottoSeller()

    val lottos = buyLottos(lottoSeller, lottoMachine)

    val winningLotto = selectWinningLotto()

    showStatistics(winningLotto, lottos)
}

private fun showStatistics(winningLotto: WinningLotto, lottos: Lottos) {
    LottoResponse.responseStatisticTitle()
    val statistics = Statistics(winningLotto, lottos.lottos)
    LottoResponse.responseStatistics(statistics.getWinningResult(), statistics.getYield())
}

private fun selectWinningLotto(): WinningLotto {
    LottoInputTitle.print(INPUT_WINNING_LOTTO)
    val inputWinningLottoNumber = readln()

    LottoInputTitle.print(INPUT_WINNING_BONUS_NUMBER)
    val inputWinningBonusNumber = readln()

    return WinningLotto(convertLotto(inputWinningLottoNumber), LottoNumber(inputWinningBonusNumber.toInt()))
}

private fun buyLottos(lottoSeller: LottoSeller, lottoMachine: LottoMachine): Lottos {
    LottoInputTitle.print(INPUT_MANUAL_LOTTO_COUNT)
    val inputManualLottoCount = readln().toInt()
    lottoSeller.buyManual(inputManualLottoCount)

    val manualLottos = buyManualLottos(inputManualLottoCount, lottoMachine)
    val autoLottos = buyAutoLottos(inputManualLottoCount, lottoSeller, lottoMachine)
    manualLottos.addAll(autoLottos.toList())

    val lottos = Lottos(manualLottos.toList())
    LottoResponse.responseLottos(lottos.lottos)
    return lottos
}

private fun buyAutoLottos(
    inputManualLottoCount: Int,
    lottoSeller: LottoSeller,
    lottoMachine: LottoMachine
): List<Lotto> {
    LottoResponse.responsePurchase(inputManualLottoCount, lottoSeller.getLottoCount())
    return lottoMachine.buyLotto(lottoSeller.getLottoCount())
}

private fun buyManualLottos(inputManualLottoCount: Int, lottoMachine: LottoMachine): MutableList<Lotto> {
    LottoInputTitle.print(INPUT_MANUAL_LOTTO)
    val manualLottos: MutableList<Lotto> = mutableListOf()
    repeat(inputManualLottoCount) {
        manualLottos.add(lottoMachine.buyManualLotto(convertLotto(readln()).toList()))
    }
    return manualLottos
}

private fun paidMoneyToLottoSeller(): LottoSeller {
    LottoInputTitle.print(INPUT_PURCHASE_PRICE)
    return LottoSeller(Money(BigDecimal(readln().toInt())))
}

fun convertLotto(lottoString: String): HashSet<LottoNumber> {
    val lottoStrings = lottoString.split(", ")
    return lottoStrings.map { CachedLottoNumbers.getLottoNumber(it.toInt()) }
        .toHashSet()
}
