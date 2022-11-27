package lotto

class LottoNumbers(var lottoNumbers: List<LottoNumber>) {
    init {
        lottoNumbers = lottoNumbers.sorted()
    }

    fun contains(winningLottoNumbers: MutableList<LottoNumber>): Int {
        var count = 0
        for (lottoNumber in lottoNumbers) {
            count += winningLottoNumbers.contain(lottoNumber)
        }
        return count
    }

    fun MutableList<LottoNumber>.contain(lottoNumber: LottoNumber): Int {
        if (this.contains(lottoNumber)) return 1
        return 0
    }

    override fun toString(): String {
        return "$lottoNumbers"
    }
}