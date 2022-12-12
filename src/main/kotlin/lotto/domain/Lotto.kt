package lotto.domain

@JvmInline
value class Lotto(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == SIZE) { "로또는 중복없는 6개의 번호를 가져야 합니다." }
    }

    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber.from(it) }.toSet())

    fun contains(number: LottoNumber): Boolean {
        return numbers.contains(number)
    }

    companion object {
        const val SIZE = 6
    }
}
