package lotto.domain

class LottoNum(val value: Int): Comparable<LottoNum> {

    init {
        verifyLottoNum(value)
    }

    private fun verifyLottoNum(value: Int) {
        require(value in 1..45) { "로또 숫자는 ${LOTTO_START_NUM}에서 ${LOTTO_END_NUM}사이에 존재해야합니다." }
    }

    override fun compareTo(other: LottoNum): Int {
        return value - other.value
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoNum

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }

    override fun toString(): String {
        return value.toString()
    }


    companion object {
        const val LOTTO_START_NUM = 1
        const val LOTTO_END_NUM = 45
    }

}