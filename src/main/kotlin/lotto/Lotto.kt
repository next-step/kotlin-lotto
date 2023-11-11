package lotto

class Lotto(selectNumberList: List<Int>) {

    init {
        selectNumberList.forEach { LottoNumber.validateRange(it) }
        require(selectNumberList.size == LOTTO_NUMBER_COUNT) { ERR_MSG_INVALID_LOTTO_NUMBER_COUNT }
        require(selectNumberList.distinct().size == LOTTO_NUMBER_COUNT) { ERR_MSG_DUPLICATE_NUMBER }
    }

    companion object {
        private const val ERR_MSG_INVALID_LOTTO_NUMBER_COUNT = "로또번호는 6개로 구성되어야 합니다."
        private const val ERR_MSG_DUPLICATE_NUMBER = "중복된 번호를 포함하고 있습니다."
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
