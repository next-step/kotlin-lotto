package lotto.domain

data class Lotto(val numbers: Set<LottoNumber>) {

    val value = krw

    init {
        require(numbers.size == 6) {
            "로또 번호의 수는 6개여야 합니다"
        }
    }

    companion object {
        val krw = KRW(1000)

        fun manual(numbers: String): Lotto {
            val list = numbers.split(',')
            return Lotto(list.map { LottoNumber(it.trim().toInt()) }.toSet())
        }
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
