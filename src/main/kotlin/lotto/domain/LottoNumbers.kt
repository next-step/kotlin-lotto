package lotto.domain

class LottoNumbers(
    val lottoNumbers: Set<LottoNumber>,
) {

    fun getMatchCount(winningLottoNumbers: LottoNumbers): Int {
        return winningLottoNumbers.lottoNumbers.intersect(lottoNumbers).size
    }

    fun containsBonusNumber(bonusNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(bonusNumber)
    }

    companion object {
        fun of(lottoNumbers: List<Int>): LottoNumbers {
            return LottoNumbers(lottoNumbers.map { LottoNumber(it) }.toSet())
        }

        fun of(lottoNumbers: List<Int>, bonusNumber: Int): LottoNumbers {
            return LottoNumbers((lottoNumbers.map { LottoNumber(it) } + LottoNumber(bonusNumber)).toSet())
        }
    }
}
