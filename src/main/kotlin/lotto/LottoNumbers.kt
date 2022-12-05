package lotto

class LottoNumbers(private val lottoNumbers: Set<LottoNumber>) {
    init {
        check (lottoNumbers.size == LOTTO_NUMBER) {
            throw IllegalStateException("로또 숫자는 ${LOTTO_NUMBER}개 입니다.")
        }
    }

    fun match(winningLottoNumbers: Set<LottoNumber>): Rank {
        var count = 0
        for (lottoNumber in lottoNumbers) {
            count += winningLottoNumbers.contain(lottoNumber)
        }
        return Rank.findByFirst(count)
    }

    private fun Set<LottoNumber>.contain(lottoNumber: LottoNumber): Int {
        if (this.contains(lottoNumber)) return 1
        return 0
    }

    override fun toString(): String {
        return "$lottoNumbers"
    }

    fun contain(bonusLottoNumber: LottoNumber): Boolean {
        return this.lottoNumbers.contains(bonusLottoNumber)
    }

    companion object {
        private const val LOTTO_NUMBER = 6
    }
}
