package lotto

import java.util.*

class LottoNumbers(private val lottoNumbers: SortedSet<LottoNumber>) {
    init {
        check (lottoNumbers.size == LOTTO_NUMBER) {
            throw IllegalStateException("로또 숫자는 ${LOTTO_NUMBER}개 입니다.")
        }
    }

    fun contains(winningLottoNumbers: List<LottoNumber>): Int {
        var count = 0
        for (lottoNumber in lottoNumbers) {
            count += winningLottoNumbers.contain(lottoNumber)
        }
        return count
    }

    private fun List<LottoNumber>.contain(lottoNumber: LottoNumber): Int {
        if (this.contains(lottoNumber)) return 1
        return 0
    }

    override fun toString(): String {
        return "$lottoNumbers"
    }

    companion object {
        private const val LOTTO_NUMBER = 6
    }
}
