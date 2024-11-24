package lotto

class LottoNumbers(val numbers: List<LottoNumber>) {
    companion object {
        fun generate(count: Int): LottoNumbers {
            val numbers = generateNumbers(count)
            require(numbers.size == count) { "중복되지 않는 숫자가 충분하지 않습니다." }
            return LottoNumbers(numbers.toList())
        }

        private fun generateNumbers(count: Int): Set<LottoNumber> {
            val numbers = mutableSetOf<LottoNumber>()
            while (numbers.size < count) {
                numbers.add(LottoNumber.generate())
            }
            return numbers
        }
    }
}
