package lotto.domain

data class Number(val number: Int) {

    companion object {
        private const val MINIMUM = 1
        private const val MAXIMUM = 45
        private val numbers = (MINIMUM..MAXIMUM).map { it to Number(it) }.toMap()

        fun getNumber(number: Int): Number {
            checkRange(number)
            return numbers.getValue(number)
        }

        private fun checkRange(number: Int) {
            if (!numbers.containsKey(number)) {
                throw NumberFormatException("${number}는 로또 번호에 포함되지 않습니다.")
            }
        }
    }
}
