package camp.nextstep.lotto.number

class LottoNumbers private constructor(private val _numbers: List<LottoNumber>) {

    val numbers
        get() = _numbers.sortedBy { it.value }

    val size
        get() = _numbers.size

    operator fun contains(element: LottoNumber): Boolean {
        return _numbers.contains(element)
    }

    fun toSet(): Set<LottoNumber> {
        return _numbers.toSet()
    }

    companion object {

        fun of(vararg numbers: Int): LottoNumbers {
            return LottoNumbers(numbers.map { LottoNumber.of(it) })
        }

        fun of(numbers: List<Int>): LottoNumbers {
            return LottoNumbers(numbers.map { LottoNumber.of(it) })
        }
    }
}
