package lotto.domain

data class Lotto(val type: LottoType, val numbers: List<LottoNumber>) {

    init {
        require(numbers.size == NUMBER_COUNT) { "로또 숫자의 개수는 $NUMBER_COUNT 이어야 합니다" }
        require(numbers.isUnique()) { "로또에 중복된 숫자가 존재할 수 없습니다" }
    }

    private fun List<LottoNumber>.isUnique(): Boolean = toSet().size == size

    companion object {
        const val NUMBER_COUNT = 6

        fun manualOf(vararg numbers: Int): Lotto = of(LottoType.MANUAL, numbers.toList())
        fun manualOf(numbers: List<Int>): Lotto = of(LottoType.MANUAL, numbers)
        fun autoOf(vararg numbers: Int): Lotto = of(LottoType.AUTO, numbers.toList())
        fun autoOf(numbers: List<Int>): Lotto = of(LottoType.AUTO, numbers)

        private fun of(type: LottoType, numbers: List<Int>): Lotto = Lotto(type, numbers.map(::LottoNumber))
    }
}
