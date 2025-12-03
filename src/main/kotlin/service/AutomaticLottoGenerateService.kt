package service

import domain.lotto.Lotto
import domain.lotto.LottoNumber

class AutomaticLottoGenerateService {
    fun generateAutomaticLotto(): Lotto =
        Lotto(
            availableLottoNumbers
                .shuffled()
                .take(Lotto.SIZE)
                .toSet(),
        )

    companion object {
        private val availableLottoNumbers: Set<LottoNumber> =
            (LottoNumber.MIN_NUMBER..LottoNumber.MAX_NUMBER).map { LottoNumber(it) }.toSet()
    }
}
