package nextstep.mission.lotto

import nextstep.mission.lotto.vo.LottoNumber
import nextstep.mission.lotto.vo.LottoNumbers

const val LOTTO_PRICE = 1000

object LottoShop {

    fun purchaseAutoLotto(price: Int): Lotto = (1..price / LOTTO_PRICE)
        .map { LottoMachine.create() }
        .let { Lotto(it) }

    fun purchaseManualLotto(manualLottoNumbers: List<List<Int>>): Lotto = manualLottoNumbers
        .map { LottoNumbers(it.map { number -> LottoNumber(number) }) }
        .let { Lotto(it) }
}
