package next.step.lotto.domain

@JvmInline
value class Lotto(private val numbers: Set<LottoNumber>) {

    init {
        require(numbers.size == LOTTO_NUMBER_CNT) { "로또 번호들은 6개만 생성할 수 있습니다." }
    }

    fun numbers(): Set<Int> = numbers.map { it.number }.toSet()

    fun match(numbers: Set<LottoNumber>): Int = this.numbers.count { numbers.contains(it) }

    fun match(number: LottoNumber): Boolean = this.numbers.any { it == number }

    companion object {
        const val LOTTO_NUMBER_CNT = 6
        fun from(numbers: Set<Int>): Lotto = Lotto(numbers.map { LottoNumber.of(it) }.toSet())

        fun of(numbers: Set<LottoNumber>): Lotto = Lotto(numbers)
    }

}