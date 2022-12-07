package nextstep.mission.lotto

import nextstep.mission.lotto.vo.LottoNumber
import nextstep.mission.lotto.vo.LottoNumbers

const val LOTTO_PRICE = 1000

object LottoShop {

    fun purchase(price: Int, manualLottoNumbers: List<List<Int>>): Lotto {
        val manualLotto: Lotto = purchaseManualLotto(manualLottoNumbers)
        val autoLotto: Lotto = purchaseAutoLotto(price - manualLottoNumbers.size * LOTTO_PRICE)
        return manualLotto + autoLotto
    }

    private fun purchaseAutoLotto(price: Int): Lotto = (1..price / LOTTO_PRICE)
        .map { LottoMachine.create() }
        .let { Lotto(it) }

    private fun purchaseManualLotto(manualLottoNumbers: List<List<Int>>): Lotto = manualLottoNumbers
        .map { LottoNumbers(it.map { number -> LottoNumber(number) }) }
        .let { Lotto(it) }
}
