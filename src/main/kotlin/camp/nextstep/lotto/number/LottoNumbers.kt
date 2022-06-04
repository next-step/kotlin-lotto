package camp.nextstep.lotto.number

class LottoNumbers private constructor(numbers: List<LottoNumber>) {

    val numbers = numbers.sortedBy { it.value }

    val size = numbers.size

    init {
        require(numbers.toSet().size == LOTTO_NUMBERS) { "로또 티켓은 서로 다른 ${LOTTO_NUMBERS}개의 숫자를 가질 수 있습니다. numbers=$numbers" }
    }

    operator fun contains(element: LottoNumber): Boolean {
        return numbers.contains(element)
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        const val LOTTO_NUMBERS = 6

        fun of(vararg numbers: Int): LottoNumbers {
            return LottoNumbers(numbers.map { LottoNumber.of(it) })
        }

        fun of(numbers: List<Int>): LottoNumbers {
            return LottoNumbers(numbers.map { LottoNumber.of(it) })
        }
    }
}
