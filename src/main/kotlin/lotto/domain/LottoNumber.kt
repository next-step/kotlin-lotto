package lotto.domain

class LottoNumber private constructor(private val value: Int) {
    companion object {
        private val associateWith: Map<Int, LottoNumber> = (1..45).associateWith { LottoNumber(it) }

        fun get(number: Int): LottoNumber {
            return associateWith[number] ?: throw IllegalArgumentException()
        }

        fun generateNumbers(): Set<LottoNumber> {
            return associateWith.values.shuffled()
                .take(6)
                .sortedBy { it.value }.toSet()
        }
    }

    override fun toString(): String {
        return value.toString()
    }
}
