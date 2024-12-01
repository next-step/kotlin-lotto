package lotto

data class Count(val value: Int) {
    init {
        require(value >= 0) { "음수는 입력할 수 없습니다." }
    }

    fun plus(): Count {
        return Count(value + 1)
    }

    override fun toString(): String {
        return value.toString()
    }

    companion object {
        private const val MIN_VALUE = 0

        fun zero(): Count {
            return Count(MIN_VALUE)
        }
    }
}
