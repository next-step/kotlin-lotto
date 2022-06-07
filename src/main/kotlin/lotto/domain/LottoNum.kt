package lotto.domain

class LottoNum(num: Int) {
    val num: Int

    init {
        require(num in 1..45) {
            "로또 숫자 범위는 1 ~ 45 입니다."
        }

        this.num = num
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoNum

        if (num != other.num) return false

        return true
    }

    override fun hashCode(): Int {
        return num
    }
}
