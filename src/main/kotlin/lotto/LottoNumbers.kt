package lotto

class LottoNumbers(numbers: List<LottoNumber>) {
    init {
        require(numbers.size == SIZE) { LOTTO_NUMBERS_INVALID_SIZE_MESSAGE }

        val hasDuplicateNumber = numbers.size != numbers.distinct().size
        require(!hasDuplicateNumber) { LOTTO_NUMBERS_DUPLICATE_MESSAGE }
    }

    companion object {
        const val SIZE = 6
        const val LOTTO_NUMBERS_INVALID_SIZE_MESSAGE = "로또 번호는 6개의 숫자로 이루어져야 합니다."
        const val LOTTO_NUMBERS_DUPLICATE_MESSAGE = "로또 번호는 중복된 숫자가 존재할 수 없습니다."
    }
}
