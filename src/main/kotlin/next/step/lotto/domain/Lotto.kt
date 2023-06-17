package next.step.lotto.domain

@JvmInline
value class Lotto(private val numbers: Set<LottoNumber>) {

    init {
        require(numbers.size == 6) { "로또 번호들은 6개만 생성할 수 있습니다." }
    }

    fun numbers(): Set<Int> = numbers.map { it.number }.toSet()

    fun match(numbers: Set<LottoNumber>): Int = this.numbers.count { numbers.contains(it) }

    companion object {
        fun from(numbers: Set<Int>): Lotto = Lotto(numbers.map { LottoNumber.of(it) }.toSet())

        fun random(): Lotto {
            val numbers = mutableSetOf<LottoNumber>()
            while (numbers.size != 6) {
                numbers.add(LottoNumber.random())
            }
            return Lotto(numbers)
        }
    }

}