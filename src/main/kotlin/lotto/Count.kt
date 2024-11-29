package lotto

data class Count(val value: Int) {
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