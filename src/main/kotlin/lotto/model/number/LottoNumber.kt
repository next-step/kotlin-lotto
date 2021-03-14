package lotto.model.number

abstract class LottoNumber(private val lottoNumber: Int) : Comparable<LottoNumber> {
    init {
        require(lottoNumber in MINIMUM..MAXIMUM) { "로또 번호는 1에서 45 사이의 자연수입니다!" }
    }

    override fun equals(other: Any?): Boolean {
        if (other is LottoNumber) {
            return lottoNumber == other.lottoNumber
        }
        return false
    }

    override fun hashCode(): Int {
        return lottoNumber.hashCode()
    }

    override fun toString(): String {
        return lottoNumber.toString()
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.lottoNumber.compareTo(other.lottoNumber)
    }

    companion object {
        const val MINIMUM = 1
        const val MAXIMUM = 45
    }
}
