package lotto.domain

class Lotto(list: List<Int>): Iterable<LottoNum> {

    private val numbers: List<LottoNum>

    init {
        verifyLottoNumCount(list)
        numbers = list.map {
            LottoNum.of(it)
        }.sorted()
    }

    private fun verifyLottoNumCount(numbers: List<Int>) {
        require(numbers.size == LOTTO_NUM_COUNT) {"로또 번호 갯수는 $LOTTO_NUM_COUNT 여야 합니다."}
    }

    override fun iterator(): Iterator<LottoNum> = numbers.iterator()

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        private const val LOTTO_NUM_COUNT = 6

        fun create(num: String): Lotto {
            val splitManual = num.split(", ")
            val numbers = splitManual.map { s -> s.toIntOrNull() ?: throw IllegalArgumentException() }.toList()
            return Lotto(numbers)
        }

    }
}