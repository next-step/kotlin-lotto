package lotto.domain

@JvmInline
value class Numbers(private val numbers: List<Int> = (1..45).shuffled().subList(0, 6).sorted()) {
    fun amountOfNumberMatched(numbers: Numbers): Int {
        return this.numbers.intersect(numbers.numbers.toSet()).size
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
