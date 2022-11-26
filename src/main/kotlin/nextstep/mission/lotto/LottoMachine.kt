package nextstep.mission.lotto

import nextstep.mission.lotto.vo.LottoNumber
import nextstep.mission.lotto.vo.LottoNumbers

private const val LOTTO_PRICE = 1000

object LottoMachine {

    private val totalLottoNumbers: List<LottoNumber> = (1..45).map { LottoNumber(it) }

    fun create(totalPrice: Int): Lotto = (1..totalPrice / LOTTO_PRICE)
        .map { LottoNumbers(totalLottoNumbers.shuffled().take(6)) }
        .let { Lotto(it) }
}
