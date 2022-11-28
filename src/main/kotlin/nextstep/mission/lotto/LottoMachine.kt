package nextstep.mission.lotto

import nextstep.mission.lotto.vo.LottoNumber
import nextstep.mission.lotto.vo.LottoNumbers

object LottoMachine {

    private val totalLottoNumbers: List<LottoNumber> = (1..45).map { LottoNumber(it) }

    fun create(): LottoNumbers = LottoNumbers(totalLottoNumbers.shuffled().take(6))
}
