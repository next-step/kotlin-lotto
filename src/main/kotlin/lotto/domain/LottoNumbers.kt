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

        fun of(winningLottoNumbers: LottoNumbers, bonusNumber: LottoNumber): LottoNumbers {
            return LottoNumbers((winningLottoNumbers.lottoNumbers.map { it } + bonusNumber).toSet())
        }
    }
}
