package lotto

class LottoNumbers(var lottoNumbers: List<LottoNumber>) {
    init {
        if (lottoNumbers.size != 6) {
            throw IllegalStateException("로또 숫자는 6개 입니다.")
        }
        lottoNumbers = lottoNumbers.sorted()
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
}
