package simulator.lotto

data class Numbers(val values: List<Number>) {
    init {
        require(values.size == NUMBERS_COUNT) {
            "로또 번호는 ${NUMBERS_COUNT}개의 숫자로 구성되어야 합니다."
        }

        require(!hasDuplicates()) {
            "로또 번호는 중복된 숫자가 존재해서는 안됩니다."
        }
    }

    fun countOfMatch(numbers: Numbers): Int {
        var countOfMatch = 0
        numbers.values.forEach { if (values.contains(it)) countOfMatch++ }
        return countOfMatch
    }

    fun contains(number: Number): Boolean {
        return values.contains(number)
    }

    override fun toString(): String {
        return values.sortedBy { it.value }
            .joinToString(",")
    }

    private fun hasDuplicates(): Boolean {
        return values.size != values.distinct().count()
    }

    companion object {
        const val NUMBERS_COUNT = 6

        fun of(intList: List<Int>): Numbers {
            return Numbers(intList.map { Number(it) })
        }
    }
}
