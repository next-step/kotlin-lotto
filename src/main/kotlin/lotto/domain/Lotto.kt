package lotto.domain

class Lotto(
    val numbers: List<LottoNumber>
) {
    init {
        validateLottoNumbers()
    }

    fun getRank(winningLotto: WinningLotto): LottoRank {
        return LottoRank.of(numbers.count { winningLotto.contains(it) })
    }

    fun contains(lottoNumber: LottoNumber): Boolean {
        return numbers.contains(lottoNumber)
    }

    private fun validateLottoNumbers() {
        if (numbers.size != LOTTO_NUMBER_COUNT) {
            throw IllegalArgumentException("로또 번호는 ${LOTTO_NUMBER_COUNT}개여야 합니다.")
        }

        if (numbers.distinct().size != LOTTO_NUMBER_COUNT) {
            throw IllegalArgumentException("로또 번호는 중복될 수 없습니다.")
        }
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}
