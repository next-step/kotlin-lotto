package lottery.domain

interface NumbersGenerator {
    fun generate(min: Int, max: Int, size: Int): List<Int>
}
