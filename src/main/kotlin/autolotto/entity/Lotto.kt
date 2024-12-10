package autolotto.entity

import autolotto.domain.LottoNumber

class Lotto(private val lottoNumbers: LottoNumber) {
    fun getNumbers(): Set<Int> = lottoNumbers.getNumbers()

    fun hasNumber(bonusNumber: Int): Boolean {
        return this.lottoNumbers.getNumbers().contains(bonusNumber)
    }
}
