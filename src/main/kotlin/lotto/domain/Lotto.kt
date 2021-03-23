package lotto.domain

class Lotto(val lottoNumbers: List<LottoNumber>) {
    init {
        require(lottoNumbers.size == LOTTO_NUMBER_COUNT) {
            "로또 번호는 ${LOTTO_NUMBER_COUNT}개 여야 합니다."
        }
    }

    fun matchCount(winningLotto: List<LottoNumber>): Int {
        return lottoNumbers.filter(winningLotto::contains).count()
    }

    fun matchBonus(bonusNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(bonusNumber)
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}
